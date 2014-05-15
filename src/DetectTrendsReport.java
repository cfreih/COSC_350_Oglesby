import java.util.*;
public class DetectTrendsReport extends FindSoldPaintings
{
    private InventoryPainting[] reportPaintings;

    //Desc: constructor for DetectTrendReports
    //Post: reportPaintings is initialized to correct values
    public DetectTrendsReport()
    {
        super();
        String[] artists = findTrendingArtists();
        reportPaintings = getFullTrendsReport(artists);
    }
    //Desc: method gets the reportPaintings field
    //Return: returns a InventoryPainting[]
    public InventoryPainting[] getReportPaintings()
    {
        return reportPaintings;
    }
    //Desc: method finds all artists who have sold more than one painting in the last year.
    //Pre: soldPaintings must be loaded from the Handler
    //Return: returns a String array with the artists names from the last year as elements
    public String[] findTrendingArtists()
    {
        if(soldPaintings == null) return null;
        HashMap<String, Integer> paintingCountHash = new HashMap<String, Integer>();
        HashMap<String, Boolean> badArtistHash = new HashMap<String, Boolean>();
        for(int i = 0; i < soldPaintings.length; i++)
        {
            String key = soldPaintings[i].getArtistFirstName() + "\n" + soldPaintings[i].getArtistLastName();
            if(!badArtistHash.containsKey(key))
            {
                if(soldPaintings[i].getActualSellPrice() > soldPaintings[i].getTargetSellPrice())
                {
                    Integer num = paintingCountHash.get(key);
                    if(num == null) paintingCountHash.put(key, 1);
                    else paintingCountHash.put(key, num + 1);
                }
                else
                {
                    badArtistHash.put(key, true);
                    paintingCountHash.remove(key);
                }
            }
        }
        Object[] keySet = paintingCountHash.keySet().toArray();
        ArrayList<String> trendingArtists = new ArrayList<String>();
        for(int i = 0; i < keySet.length; i++)
        {
            String artistKey = (String) keySet[i];
            if(paintingCountHash.get(artistKey) > 1) trendingArtists.add(artistKey);
        }
        return Arrays.copyOf(trendingArtists.toArray(), trendingArtists.toArray().length, String[].class);
    }
    //Desc: method changes the artist names into InventoryPaintings
    //Return: an array containing the prepared InventoryPaintings
    protected static InventoryPainting[] splitNames(String[] trendingArtists)
    {
        if(trendingArtists == null) return null;
        InventoryPainting[] paintings = new InventoryPainting[trendingArtists.length];
        for(int i = 0; i < trendingArtists.length; i++)
        {
            InventoryPainting temp = new InventoryPainting();
            String[] names = trendingArtists[i].split("\n");
            temp.setArtistFirstName(names[0]);
            temp.setArtistLastName(names[1]);
            paintings[i] = temp;
        }
        return paintings;
    }
    //Desc: method uses the handler to get the information needed for the trend report.
    //Return: returns an IntentoryPainting array loaded with the information matching the artists
    // names passed to the database
    protected InventoryPainting[] getFullTrendsReport(String[] trendingArtists)
    {
        ArrayList<InventoryPainting> paintings = new ArrayList<InventoryPainting>();
        return HandleInventoryPaintings.retrieveInventoryPaintings(splitNames(trendingArtists));
    }
}
class DetectTrendsReportTest extends DetectTrendsReport
{
    //Desc: method to run unit tests for all methods
    //Output: prints the results of unit tests
    public static void runTests()
    {
        System.out.println("\tFindTrendingArtistTest: " + findTrendingArtistsTest());
        //System.out.println("\tSplitNamesTest: " + splitNamesTest());
    }
    //Desc: Unit Test for splitNames
    //Return: True if successful, false if failure
    private static boolean findTrendingArtistsTest()
    {
        //Test Case #1: Generic Success
        DetectTrendsReport d = new DetectTrendsReport();
        InventoryPainting[] paintings = new InventoryPainting[13];
        for(int i = 0; i < paintings.length - 3; i++)
        {
            InventoryPainting temp = new InventoryPainting();
            temp.setArtistFirstName("" + (char)(65 + i));
            temp.setArtistLastName("" + (char)(65 + i));
            paintings[i] = temp;
        }
        InventoryPainting temp = new InventoryPainting();
        temp.setArtistFirstName("" + (char) 65);
        temp.setArtistLastName("" + (char) 65);
        paintings[10] = temp;
        temp = new InventoryPainting();
        temp.setArtistFirstName("" + (char) 65);
        temp.setArtistLastName("" + (char) 65);
        paintings[11] = temp;
        temp = new InventoryPainting();
        temp.setArtistFirstName("" + (char) 66);
        temp.setArtistLastName("" + (char) 65);
        paintings[12] = temp;
        d.setSoldPaintings(paintings);
        String[] s = d.findTrendingArtists();
        //if(s[0] != "a\nk") return false;
        //if(s[1] != "b\nl") return false;
        if(s.length != 2) return false;
        //Test Case #2: Empty String Array
        paintings = new InventoryPainting[0];
        d.setSoldPaintings(paintings);
        s = d.findTrendingArtists();
        if(s.length != 0) return false;
        //Test Case #3: Null
        paintings = null;
        d.setSoldPaintings(paintings);
        s = d.findTrendingArtists();
        if(s != null) return false;
        return true;
    }
    //Desc: Unit Test for splitNames
    //Return: True if successful, false if failure
    /*private static boolean splitNamesTest()
    {
        //Test Case #1: Generic Success
        String[] s = {"Bock\nSamuel","Freiheit\nClint","Burwitz\nTimothy","Cassante\nArce Claudio"};
        InventoryPainting[] paintings = splitNames(s);
        for(int i = 0; i < paintings.length; i++)
        {
            s[i] = s[i].replaceAll("\n"," ");
            String temp = paintings[i].getArtistLastName() + " " + paintings[i].getArtistFirstName();
            if(!temp.equals(s[i])) return false;
        }
        //Test Case #2: Empty String Array
        s = new String[0];
        paintings = splitNames(s);
        for(int i = 0; i < paintings.length; i++)
        {
            s[i] = s[i].replaceAll("\n"," ");
            String temp = paintings[i].getArtistLastName() + " " + paintings[i].getArtistFirstName();
            if(!temp.equals(s[i])) return false;
        }
        //Test Case #3: null Reference
        s = null;
        paintings = splitNames(s);
        if(paintings != null) return false;
        return true;
    }
    */
}