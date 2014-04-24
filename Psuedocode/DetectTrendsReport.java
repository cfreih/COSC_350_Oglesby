public class DetectTrendsReport extends FindSoldPaintings
{
  //Desc: method finds all artists who have sold more than one painting in the last year. 
  //Pre: soldPaintings must be loaded from the Handler
  //Return: returns a String array with the artists names from the last year as elements
  public String[] findTrendingArtists()
  {
    HashMap<String, Integer> artistHash = new HashMap<String, Integer>()
    for(int i in this.soldPaintings)
    {
      String key = this.soldPaintings.getLastName()+'\n'+this.soldPaintings.getFirstName()
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
  //Return: returns an IntentoryPainting array loaded with the information matching the artists
  // names passed to the database
  public InventoryPainting[] getFullTrendsReport(String[] trendingArtists)
  {
    ArrayList<InventoryPainting> paintings = new ArrayList<InventoryPainting>()
    for(int i = 0; i < trendingArtists.length; i++)
    {
      InventoryPainting temp = new InventoryPainting()
      String[] names = trendingArtists[i].split("\n")
      temp.setLastName(names[0])
      temp.setFirstName(names[1])
    }
    return handleInventoryPaintings.retrieveInventoryPaintings(paintings.toArray()) //needs to be able to get before
  }
}