import java.util.*;
public class DetectTrendsReport extends FindSoldPaintings
{
  private InventoryPainting[] reportPaintings;
  
  //Desc: constructor for DetectTrendReports
  //Post: reportPaintings is initialized to correct values
  public DetectTrendsReport()
  {
    super();
    String[] artist = findTrendingArtists();
    reportPaintings = getFullTrendsReport(artist);
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
  protected String[] findTrendingArtists()
  {
    if(this.soldPaintings == null) return null;
    HashMap<String, Integer> artistHash = new HashMap<String, Integer>();
    for(int i = 0; i < this.soldPaintings.length; i++)
    {
      String key = this.soldPaintings[i].getArtistLastName()+'\n'+this.soldPaintings[i].getArtistFirstName();
      artistHash.put(key, artistHash.get(key) + 1);
    }
    Object[] keySet = artistHash.keySet().toArray();
    ArrayList<String> trendingArtists = new ArrayList<String>();
    for(int i = 0; i < keySet.length; i++)
    {
      String artist = (String) keySet[i];
      if(artistHash.get(artist) > 1) trendingArtists.add(artist);
    }
    return (String[]) trendingArtists.toArray();
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
      temp.setArtistLastName(names[0]);
      temp.setArtistFirstName(names[1]);
      paintings[i] = temp;
    }
    return paintings;
  }
  //Desc: method uses the handler to get the information needed for the trend report.
  //Return: returns an IntentoryPainting array loaded with the information matching the artists
  // names passed to the database
  protected InventoryPainting[] getFullTrendsReport(String[] trendingArtists)
  {
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
    System.out.println("\tSplitNamesTest: " + splitNamesTest());  
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
      temp.setArtistFirstName("" + (char)(97 + i));
      temp.setArtistLastName("" + (char)(107 + i));
      paintings[i] = temp;
    }
    InventoryPainting temp = new InventoryPainting();
    temp.setArtistFirstName("" + (char)(97));
    temp.setArtistLastName("" + (char)(107));
    paintings[10] = temp;
    temp = new InventoryPainting();
    temp.setArtistFirstName("" + (char)(98));
    temp.setArtistLastName("" + (char)(107));
    paintings[11] = temp;
    temp = new InventoryPainting();
    temp.setArtistFirstName("" + (char)(98));
    temp.setArtistLastName("" + (char)(107));
    paintings[12] = temp;
    d.setSoldPaintings(paintings);
    String[] s = d.findTrendingArtists();
    if(s[0] != "a\nk") return false;
    if(s[1] != "b\nl") return false;
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
    private static boolean splitNamesTest()
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
}