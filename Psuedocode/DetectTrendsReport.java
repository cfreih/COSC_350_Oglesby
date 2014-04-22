public class DetectTrendsReport
{
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
  public InventoryRecord[] getFullTrendsReport(String[] trendingArtists)
  {
    return handleInventoryRecords.retrieveInventoryRecords(trendingArtists.toString())
  }
}