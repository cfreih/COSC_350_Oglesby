public abstract class HandleAuctionPaintings
{
  //Desc: method creates an AuctionPainting in the database
  //Post: an AuctionPainting is created in the database
  public static void createAuctionPainting(AuctionPainting auction)
  {
    int artistID = HandleArtist.getArtistID(new Artist(auction.getFirstName(), auction.getLastName(), -1)) 
    String statement = "INSERT INTO auction_paintings(artistID, titleOfWork, dateOfWork, classification, "
     + "heightCM, widthCM, medium, subject, auctionSalePrice, auctionDateOfSale) VALUES('" + artistID
      + "','" + auction.getTitleOfWork() + "','" + auction.getDateOfWork() + "','" + 
      auction.getHeightCM() + "','" + auction.getWidthCM() + "','" + auction.getMedium() + "','" + auction.getSubject()
      + "','" + auction.getAuctionSalePrice() + "','" + auction.getAuctionDateOfSale.toString() + "')"
    SQLConnector connection = new SQLConnector(1, statement)
    connection.executeSQLQuery()
  }
  //Desc: method searches the database and retrieves any matching records.
  // Search terms are passed in as an AuctionPainting with fields intialized if they are search terms
  //Return: returns an AuctionPainting array, with elements matching search terms
  public static AuctionPainting[] retrieveAuctionPaintings(AuctionPainting auction) //if string is empty, will bring all
  {
    String statement = "SELECT artistID, titleOfWork, dateOfWork, classification, "
     + "heightCM, widthCM, medium, subject, auctionSalePrice, auctionDateOfSale FROM artists INNER"
     + " JOIN auction_paintings ON artists.artistID= auction_paintings.artistID"
    statement += stringify(auction)
    statement += " ORDER BY lastName, firstName" //probably needs to be changed
    SQLConnector connection = new SQLConnector(0, statement)
    Vector result = connection.executeSQLQuery()
    ArrayList<AuctionPainting> auctionPaintings = new ArrayList<AuctionPainting>()
    loadResults(auctionPaintings, result)
    return auctionPaintings.toArray()
  }
  //Desc: method to parse results from SQL database back into AuctionPaintings
  //Post: ArrayList is loaded with results from SQL database
  public static void loadResults(ArrayList<AuctionPainting> auctionPaintings, Vector result)
  {
    for(int i = 0; i < result.size(); i++)
    {
      String firstName = result.get(i++)
      String lastName = result.get(i++)
      String titleOfWork = result.get(i++)
      int dateOfWork = Integer.parseInt(result.get(i++))
      double heightCM = Double.parseDouble(result.get(i++))
      double widthCM = Double.parseDouble(result.get(i++))
      String medium = result.get(i++)
      String subject = result.get(i++)
      double auctionSalePrice = Double.parseDouble(result.get(i++))
      Date auctionDateOfSale = Date.parse(result.get(i))
      auctionPaintings.add(firstName, lastName, titleOfWork, dateOfWork, classification,
                           heightCM, widthCM, medium, subject, auctionSalePrice, auctionDateOfSale)
    }
  }
  //Desc: method to load a HashMap with values to assist in the automation of SQL statements
  // In particular, this method assists with limiting the amount of hardcoding in the stringify
  //Return: the fully loaded HashMap is returned
  private static HashMap<String,Object> loadMap(AuctionPainting auction)
  {
    HashMap<String,Object> objects = new HashMap<String,Object>()
    objects.put("artistID", HandleArtist.getArtistID(new Artist(auction.getFirstName(), auction.getLastName(), -1)))
    objects.put("titleOfWork", auction.getTitleOfWork())
    objects.put("dateOfWork", auction.getDateOfWork())
    objects.put("heightCM", auction.getHeightCM())
    objects.put("widthCM", auction.getWidthCM())
    objects.put("medium", auction.getMedium())
    objects.put("subject", auction.getSubject())
    objects.put("auctionSalePrice", auction.getAuctionSalePrice())
    objects.put("auctionDateOfSale", auction.getAuctionDateOfSale())
    return objects
  }
  //Desc: method converts an AuctionPainting into a String
  //Return: returns a String for the SQL statement
  private static String stringify(AuctionPainting auction)
  {
    String result = ""
    boolean[] flags = new boolean[9]
    HashMap<String,Object> objects = loadMap(auction)
    String[] keys = objects.keySet().toArray()
    for(int i = 0; i < keys.length; i++)
    {
      if(HandlerUtility.checkInitialization(objects.get(keys[i]))) flags[i] = true
      else
      {
        if(HandlerUtility.checkFlags(flags, i)) result += " WHERE " + keys[i] + "='" + objects.get(keys[i]) + "'"
        else result += " AND " + keys[i] + "='" + objects.get(keys[i]) + "'"
      }
    }
    return result
  }
  //Desc: method updates an AuctionPainting in the database. Compares to titleOfWork as key.
  //Post: an AuctionPainting is updated in the database
  public static void updateAuctionPainting(AuctionPainting auction, AuctionPainting searchKey)
  {
    String statement = "UPDATE FROM artists INNER JOIN auction_paintings ON artists.artistID= auction_paintings.artistID "
      + "SET artistID='" + HandleArtist.getArtistID(auction.getFirstName(), auction.getLastName(), -1) +
      "',titleOfWork='" + auction.getTitleOfWork() + "',dateOfWork='" + auction.getDateOfWork() + "',heightCM='" + auction.getHeightCM()
      + "',widthCM='" + auction.getWidthCM() + "',medium='" + auction.getMedium() + "',subject='" + auction.getSubject()
      + "',auctionSalePrice='" auction.getAuctionSalePrice() + "',auctionDateOfSale='" + auction.getAuctionDateOfSale()
      + stringify(searchKey)
    SQLConnector connection = new SQLConnector(1, statement)
    connection.executeSQLQuery()
  }
  //Desc: method deletes an AuctionPainting in the database
  //Post: an AuctionPainting is deleted in the database
  public static void deleteAuctionPainting(AuctionPainting auction)
  {
    String statement = "DELETE FROM artists INNER JOIN auction_paintings ON artists.artistID= auction_paintings.artistID"
    statement += stringify(auction)
    SQLConnector connection = new SQLConnector(1, statement)
    connection.executeSQLQuery()
  }
}