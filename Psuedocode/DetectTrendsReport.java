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
    reportPaintings= getFullTrendsReport(artist);
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
  private String[] findTrendingArtists()
  {
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
  
  //Desc: method uses the handler to get the information needed for the trend report.
  //Return: returns an IntentoryPainting array loaded with the information matching the artists
  // names passed to the database
  private InventoryPainting[] getFullTrendsReport(String[] trendingArtists)
  {
    ArrayList<InventoryPainting> paintings = new ArrayList<InventoryPainting>();
    for(int i = 0; i < trendingArtists.length; i++)
    {
      InventoryPainting temp = new InventoryPainting();
      String[] names = trendingArtists[i].split("\n");
      temp.setArtistLastName(names[0]);
      temp.setArtistFirstName(names[1]);
    }
    return HandleInventoryPaintings.retrieveInventoryPaintings((InventoryPainting[])paintings.toArray());
  }
  
}