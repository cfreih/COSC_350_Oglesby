import java.util.*;
public abstract class HandleAuctionPaintings
{
  //Desc: method creates an AuctionPainting in the database
  //Post: an AuctionPainting is created in the database
  public static void createAuctionPainting(AuctionPainting auction)
  {
    String tableStatement = "auction_paintings";
    String statement = "INSERT INTO "+ tableStatement +"(";
    Pair[] pairs = loadMap(auction);
    statement += HandlerUtility.loadKeys(pairs);
    statement += ") VALUES(";
    statement += HandlerUtility.loadValues(pairs);
    statement += ")";
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Query();
  }
  //Desc: method searches the database and retrieves any matching records.
  // Search terms are passed in as an AuctionPainting with fields initialized if they are search terms
  //Return: returns an AuctionPainting array, with elements matching search terms
  public static AuctionPainting[] retrieveAuctionPaintings(AuctionPainting auction) //if string is empty, will bring all
  {
    String tableStatement = "auction_paintings";
    String orderBy = "artistLastName, artistFirstName";
    String statement = "SELECT";
    Pair[] pairs = loadMap(new AuctionPainting());
    statement += HandlerUtility.loadKeys(pairs);
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
      auctionPaintings.add(new AuctionPainting(artistFirstName, artistLastName, titleOfWork, dateOfWork,
                           heightCM, widthCM, medium, subject, auctionSalePrice, auctionDateOfSale));
    }
  }
  //Desc: method to load a HashMap with values to assist in the automation of SQL statements
  // In particular, this method assists with limiting the amount of hardcoding in the stringify
  //Return: the fully loaded HashMap is returned
  private static Pair[] loadMap(AuctionPainting auction)
  {
    ArrayList<Pair> pairs = new ArrayList<Pair>();
    pairs.add(new Pair("firstName", auction.getArtistFirstName()));
    pairs.add(new Pair("lastName", auction.getArtistLastName()));
    pairs.add(new Pair("titleOfWork", auction.getTitleOfWork()));
    pairs.add(new Pair("dateOfWork", auction.getDateOfWork()));
    pairs.add(new Pair("heightCM", auction.getHeightCM()));
    pairs.add(new Pair("widthCM", auction.getWidthCM()));
    pairs.add(new Pair("medium", auction.getMedium()));
    pairs.add(new Pair("subject", auction.getSubject()));
    pairs.add(new Pair("auctionSalePrice", auction.getSalePriceAuction()));
    pairs.add(new Pair("auctionDateOfSale", auction.getDateOfSaleAuction()));
    return Arrays.copyOf(pairs.toArray(), pairs.toArray().length, Pair[].class);
  }
  //Desc: method converts an AuctionPainting into a String
  //Return: returns a String for the SQL statement
  private static String stringify(AuctionPainting auction)
  {
    String result = "";
    Pair[] pairs = loadMap(auction);
    boolean[] flags = new boolean[pairs.length];
    for(int i = 0; i < pairs.length; i++)
    {
      if(HandlerUtility.checkInitialization(pairs[i].getValue())) flags[i] = true;
      else
      {
          if(HandlerUtility.checkFlags(flags, i)) result += " WHERE " + pairs[i].getKey() + "='" + pairs[i].getValue() + "'";
          else result += " AND " + pairs[i].getKey() + "='" + pairs[i].getValue() + "'";
      }
    }
    return result;
  }
  //Desc: method updates an AuctionPainting in the database. Compares to titleOfWork as key.
  //Post: an AuctionPainting is updated in the database
  public static void updateAuctionPainting(AuctionPainting auction, AuctionPainting searchKey)
  {
    String tableStatement = "auction_paintings";
    String statement = "UPDATE " + tableStatement + " SET";
    Pair[] pairs = loadMap(auction);
    statement += HandlerUtility.loadKeysAndValues(pairs);
    statement += stringify(searchKey);
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Query();
  }
  //Desc: method deletes an AuctionPainting in the database
  //Post: an AuctionPainting is deleted in the database
  public static void deleteAuctionPainting(AuctionPainting auction)
  {
    String tableStatement = "auction_paintings";
    String statement = "DELETE FROM " + tableStatement;
    statement += stringify(auction);
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Query();
  }
 
}
class HandleAuctionPaintingsTest
{
	  
	//Desc: method to run unit tests for all methods
	//Output: prints the results of unit tests
	public static void runTests()
	{
	    System.out.println("\tCreateAuctionPaintingTest: " + createAuctionPaintingTest());
	    //System.out.println("\tRetrieveAuctionTest: " + retrieveAuctionPaintingTest());
	    //things
	}
	
	public static boolean createAuctionPaintingTest()
	{
		AuctionPainting testPainting = new AuctionPainting("Sammichelle", "Bachman",
				"Twinkle, Twinkle", 1992, 0.1, 199.9, "Oil", "Economics",
				12, new SimpleDate(1852, 3, 17));
		HandleAuctionPaintings.createAuctionPainting(testPainting);
		AuctionPainting[] result = HandleAuctionPaintings.retrieveAuctionPaintings(testPainting);
		if(result.length < 1) return false;
		if(!result[0].equals(testPainting)) return false;
		testPainting = new AuctionPainting("Earl", "Chuck", "Beauty and the Beautier",
			1273, 23, 56, "Paint", "Me, Myself, and I",
			3.50, new SimpleDate(1999,12,31));
		HandleAuctionPaintings.createAuctionPainting(testPainting);
		result = HandleAuctionPaintings.retrieveAuctionPaintings(testPainting);
		if(result.length < 1) return false;
		if(!result[0].equals(testPainting)) return false;
		return true;
	}
	
	public static boolean retrieveAuctionPaintingTest()
    {
        //Test for getting all InventoryPaintings
        AuctionPainting testPainting = new AuctionPainting();
        AuctionPainting[] result = HandleAuctionPaintings.retrieveAuctionPaintings(testPainting);
        for(int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }
        //Test for getting a specific InventoryPainting
        testPainting = result[0];
        result = HandleAuctionPaintings.retrieveAuctionPaintings(testPainting);
        if(result.length < 1) return false;
        if(!result[0].equals(testPainting)) return false;
        return true;
    }
}