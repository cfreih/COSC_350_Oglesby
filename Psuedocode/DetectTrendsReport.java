public class DetectTrendsReport extends FindSoldPaintings
{
  //Desc: method finds all artists who have sold more than one painting in the last year. 
  //Pre: soldPaintings must be loaded from the Handler
  //Return: returns a String array with the artists names from the last year as elements
  public String[] findTrendingArtists()
  {
    HashMap<String, int> artistHash = new HashMap<String, int>()
    for(int i in this.soldPaintings)
    {
      String key = this.soldPaintings.getLastName()+this.soldPaintings.getFirstName()
      artistHash.put(key, artistHash.get(key) + 1)
    }
    String[] keySet = artistHash.keySet().toArray()
    ArrayList<String> trendingArtists = new ArrayList<String>()
    for(int i in keySet)
    {
      String artist = keySet[i]
      if(artistHash.get(artist) > 1) trendingArtists.add(artist)
    }
    return trendingArtists.toArray()
  }
  //Desc: method uses the handler to get the information needed for the trend report.
  //Return: returns an IntentoryRecord array loaded with the information matching the artists
  // names passed to the database
  public InventoryRecord[] getFullTrendsReport(String[] trendingArtists)
  {
    return handleInventoryRecords.retrieveInventoryRecords(trendingArtists.toString())
  }
}