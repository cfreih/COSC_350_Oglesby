import java.util.*;
public abstract class HandleAuctionPaintings
{
  //Desc: method creates an AuctionPainting in the database
  //Post: an AuctionPainting is created in the database
  public static void createAuctionPainting(AuctionPainting auction)
  {
    String tableStatement = "auction_paintings";
    String statement = "INSERT INTO "+ tableStatement +"(";
    HashMap<String,Object> objects = loadMap(auction);
    String[] keys = (String[]) objects.keySet().toArray();
    statement += HandlerUtility.loadKeys(keys);
    statement += ") VALUES(";
    statement += HandlerUtility.loadValues(objects, keys);
    statement += ")";
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Query();
  }
  //Desc: method searches the database and retrieves any matching records.
  // Search terms are passed in as an AuctionPainting with fields initialized if they are search terms
  //Return: returns an AuctionPainting array, with elements matching search terms
  public static AuctionPainting[] retrieveAuctionPaintings(AuctionPainting auction) //if string is empty, will bring all
  {
    String tableStatement = "FROM artists INNER JOIN auction_paintings ON artists.artistID= auction_paintings.artistID";
    String orderBy = "artistLastName, artistFirstName";
    String statement = "SELECT";
    HashMap<String,Object> objects = loadMap(auction);
    Object[] keys = objects.keySet().toArray();
    statement += HandlerUtility.loadKeys(keys);
    statement += " FROM " + tableStatement;
    statement += stringify(auction);
    statement += " ORDER BY " + orderBy;
    SQLConnector connection = new SQLConnector(statement);
    Vector result = connection.executeSQL_Query();
    ArrayList<AuctionPainting> auctionPaintings = new ArrayList<AuctionPainting>();
    loadResults(auctionPaintings, result);
    return (AuctionPainting[]) auctionPaintings.toArray();
  }
  //Desc: method to parse results from SQL database back into AuctionPaintings
  //Post: ArrayList is loaded with results from SQL database
  public static void loadResults(ArrayList<AuctionPainting> auctionPaintings, Vector result)
  {
    for(int i = 0; i < result.size(); i++)
    {
      String artistFirstName = (String) result.get(i++);
      String artistLastName = (String) result.get(i++);
      String titleOfWork = (String) result.get(i++);
      int dateOfWork = Integer.parseInt((String)result.get(i++));
      double heightCM = Double.parseDouble((String)result.get(i++));
      double widthCM = Double.parseDouble((String)result.get(i++));
      String medium = (String) result.get(i++);
      String subject = (String) result.get(i++);
      int artistID = Integer.parseInt((String)result.get(i++));
      double auctionSalePrice = Double.parseDouble((String)result.get(i++));
      SimpleDate auctionDateOfSale = (SimpleDate) result.get(i);
      //Date auctionDateOfSale = new Date(Date.parse((String)result.get(i)));
      auctionPaintings.add(new AuctionPainting(artistFirstName, artistLastName, titleOfWork, dateOfWork,
                           heightCM, widthCM, medium, subject, artistID, auctionSalePrice, auctionDateOfSale));
    }
  }
  //Desc: method to load a HashMap with values to assist in the automation of SQL statements
  // In particular, this method assists with limiting the amount of hardcoding in the stringify
  //Return: the fully loaded HashMap is returned
  private static HashMap<String,Object> loadMap(AuctionPainting auction)
  {
    HashMap<String,Object> objects = new HashMap<String,Object>();
    objects.put("artistID", auction.getArtistID());
    objects.put("titleOfWork", auction.getTitleOfWork());
    objects.put("dateOfWork", auction.getDateOfWork());
    objects.put("heightCM", auction.getHeightCM());
    objects.put("widthCM", auction.getWidthCM());
    objects.put("medium", auction.getMedium());
    objects.put("subject", auction.getSubject());
    objects.put("artistID", auction.getArtistID());
    objects.put("auctionSalePrice", auction.getSalePriceAuction());
    objects.put("auctionDateOfSale", auction.getDateOfSaleAuction());
    return objects;
  }
  //Desc: method converts an AuctionPainting into a String
  //Return: returns a String for the SQL statement
  private static String stringify(AuctionPainting auction)
  {
    String result = "";
    HashMap<String,Object> objects = loadMap(auction);
    boolean[] flags = new boolean[objects.size()];
    Object[] keys = objects.keySet().toArray();
    for(int i = 0; i < keys.length; i++)
    {
      if(HandlerUtility.checkInitialization(objects.get(keys[i]))) flags[i] = true;
      else
      {
        if(HandlerUtility.checkFlags(flags, i)) result += " WHERE " + keys[i] + "='" + objects.get(keys[i]) + "'";
        else result += " AND " + keys[i] + "='" + objects.get(keys[i]) + "'";
      }
    }
    return result;
  }
  //Desc: method updates an AuctionPainting in the database. Compares to titleOfWork as key.
  //Post: an AuctionPainting is updated in the database
  public static void updateAuctionPainting(AuctionPainting auction, AuctionPainting searchKey)
  {
    String tableStatement = "artists INNER JOIN auction_paintings ON artists.artistID= auction_paintings.artistID";
    String statement = "UPDATE " + tableStatement + " SET";
    HashMap<String,Object> objects = loadMap(auction);
    String[] keys = (String[]) objects.keySet().toArray();
    statement += HandlerUtility.loadKeysAndValues(objects,keys);
    statement += stringify(searchKey);
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Query();
  }
  //Desc: method deletes an AuctionPainting in the database
  //Post: an AuctionPainting is deleted in the database
  public static void deleteAuctionPainting(AuctionPainting auction)
  {
    String tableStatement = "artists INNER JOIN auction_paintings ON artists.artistID= auction_paintings.artistID";
    String statement = "DELETE FROM " + tableStatement;
    statement += stringify(auction);
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Query();
  }
}