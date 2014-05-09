import java.math.BigDecimal;
import java.util.*;
public abstract class HandleInventoryPaintings
{
  //Desc: method creates an InventoryPainting in the database
  //Post: an InventoryPainting is created in the database
  public static void createInventoryPainting(InventoryPainting inventory)
  {
    boolean isQuery = false;
    String tableStatement = "inventory_paintings";
    String fromTableStatement = "artists";
    String statement = "INSERT INTO "+ tableStatement +"(";
    Artist[] a = HandleArtist.retrieveArtists(new Artist(inventory.getArtistFirstName(), inventory.getArtistLastName(), -1, -1));
    if(a.length == 0) return; //throw errors
    Pair[] pairs = HandleInventoryPaintings.loadMap(inventory, isQuery);
    statement += HandlerUtility.loadKeys(pairs);
    statement += ") SELECT";
    statement += HandlerUtility.loadValues(pairs);
    statement += "FROM " + fromTableStatement + " WHERE artistID = '" + a[0].getArtistID() + "'";
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Update();
  }
  //Desc: method searches the database and retrieves any matching records. 
  // Search terms only a Date object
  // Is a special case for the FindSoldPaintings class.
  //Return: returns an InventoryPainting array, with elements matching search terms
  public static InventoryPainting[] retrieveInventoryPaintings(SimpleDate d)
  {
    boolean isQuery = true;
    String tableStatement = "artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID";
    String orderBy = "artistID";
    int date = HandlerUtility.dateToInt(d);
    String statement = "SELECT";
    Pair[] pairs = loadMap(new InventoryPainting(),isQuery); //clint needs to fix inventorypainting
    statement += HandlerUtility.loadKeys(pairs);
    statement += " FROM " + tableStatement;
    statement += " WHERE sold=1 and dateOfSale > " + date + " ";
    statement += " ORDER BY " + orderBy;
    SQLConnector connection = new SQLConnector(statement);
    Vector result = connection.executeSQL_Query();
    ArrayList<InventoryPainting> inventoryPaintings = new ArrayList<InventoryPainting>();
    loadResults(inventoryPaintings, result);
    return Arrays.copyOf(inventoryPaintings.toArray(), inventoryPaintings.toArray().length, InventoryPainting[].class);
  }
  //Desc: method searches the database and retrieves any matching records. 
  // Search terms are passed in as an InventoryPainting array with fields intialized if they are search terms
  // Is a special case for the DetectTrendsReport class.
  //Return: returns an InventoryPainting array, with elements matching search terms
  public static InventoryPainting[] retrieveInventoryPaintings(InventoryPainting[] inventory)
  {
    boolean isQuery = true;
    String tableStatement = "artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID";
    String orderBy = "artistID";
    String statement = "SELECT";
    Pair[] pairs = loadMap(new InventoryPainting(), isQuery);
    statement += HandlerUtility.loadKeys(pairs);
    statement += " FROM " + tableStatement;
    for(int i = 0; i < inventory.length; i++)
    {
      if(i != 0) statement += " OR";
      statement += stringify(inventory[i]);
    }
    statement += " ORDER BY " + orderBy;
    SQLConnector connection = new SQLConnector(statement);
    Vector result = connection.executeSQL_Query();
    ArrayList<InventoryPainting> inventoryPaintings = new ArrayList<InventoryPainting>();
    loadResults(inventoryPaintings, result);
    return Arrays.copyOf(inventoryPaintings.toArray(), inventoryPaintings.toArray().length, InventoryPainting[].class);
  }
  //Desc: method searches the database and retrieves any matching records. 
  // Search terms are passed in as an InventoryPainting with fields initialized if they are search terms
  //Return: returns an InventoryPainting array, with elements matching search terms
  public static InventoryPainting[] retrieveInventoryPaintings(InventoryPainting inventory) //if string is empty, will bring all
  {
    boolean isQuery = true;
    String tableStatement = "artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID";
    String orderBy = "artistID";
    String statement = "SELECT";
    Pair[] pairs = loadMap(new InventoryPainting(),isQuery);
    statement += HandlerUtility.loadKeys(pairs);
    statement += " FROM " + tableStatement;
    statement += stringify(inventory);
    statement += " ORDER BY " + orderBy;
    System.out.println(statement);
    SQLConnector connection = new SQLConnector(statement);
    Vector result = connection.executeSQL_Query();
    ArrayList<InventoryPainting> inventoryPaintings = new ArrayList<InventoryPainting>();
    loadResults(inventoryPaintings, result);
    return Arrays.copyOf(inventoryPaintings.toArray(), inventoryPaintings.toArray().length, InventoryPainting[].class);
  }
  //Desc: method to load a HashMap with values to assist in the automation of SQL statements
  // In particular, this method assists with limiting the amount of hardcoding in the stringify
  //Return: the fully loaded HashMap is returned
  public static Pair[] loadMap(InventoryPainting inventory, boolean isQuery)
  {
    ArrayList<Pair> pairs = new ArrayList<Pair>();
    if(isQuery)
    {
        pairs.add(new Pair("artists.firstName", inventory.getArtistFirstName()));
        pairs.add(new Pair("artists.lastName", inventory.getArtistLastName()));
        pairs.add(new Pair("inventory_paintings.artistID", inventory.getArtistID()));
    }
    pairs.add(new Pair("inventory_paintings.title", inventory.getTitleOfWork()));
    pairs.add(new Pair("inventory_paintings.dateOfWork", inventory.getDateOfWork()));
    pairs.add(new Pair("inventory_paintings.classification", inventory.getClassification()));
    pairs.add(new Pair("inventory_paintings.height", inventory.getHeightCM()));
    pairs.add(new Pair("inventory_paintings.width", inventory.getWidthCM()));
    pairs.add(new Pair("inventory_paintings.medium", inventory.getMedium()));
    pairs.add(new Pair("inventory_paintings.subject", inventory.getSubject()));
    pairs.add(new Pair("inventory_paintings.dateOfPurchase", HandlerUtility.dateToInt(inventory.getDateOfPurchase())));
    pairs.add(new Pair("inventory_paintings.nameOfSeller", inventory.getSellerName()));
    pairs.add(new Pair("inventory_paintings.addressOfSeller", inventory.getSellerAddress()));
    pairs.add(new Pair("inventory_paintings.maximumPurchasePrice", inventory.getMaxPurchasePrice()));
    pairs.add(new Pair("inventory_paintings.actualPurchasePrice", inventory.getActualPurchasePrice()));
    pairs.add(new Pair("inventory_paintings.targetSellingPrice", inventory.getTargetSellPrice()));
    pairs.add(new Pair("inventory_paintings.sold", inventory.getSoldYesOrNo() ? 1 : 0));
    if(inventory.getSoldYesOrNo())
    {
        pairs.add(new Pair("inventory_paintings.dateOfSale", HandlerUtility.dateToInt(inventory.getDateOfSale())));
        pairs.add(new Pair("inventory_paintings.nameOfBuyer", inventory.getBuyerName()));
        pairs.add(new Pair("inventory_paintings.addressOfBuyer", inventory.getBuyerAddress()));
        pairs.add(new Pair("inventory_paintings.actualSellingPrice", inventory.getActualSellPrice()));
        pairs.add(new Pair("inventory_paintings.flagBoughtReport", inventory.getFlagBoughtReport() ? 1 : 0));
        pairs.add(new Pair("inventory_paintings.flagSoldReport", inventory.getFlagSoldReport() ? 1 : 0));
    }
    else
    {
        pairs.add(new Pair("inventory_paintings.dateOfSale", 010010001));
        pairs.add(new Pair("inventory_paintings.nameOfBuyer", ""));
        pairs.add(new Pair("inventory_paintings.addressOfBuyer", ""));
        pairs.add(new Pair("inventory_paintings.actualSellingPrice", -1));
        pairs.add(new Pair("inventory_paintings.flagBoughtReport", 0));
        pairs.add(new Pair("inventory_paintings.flagSoldReport", 0));
    }
    return Arrays.copyOf(pairs.toArray(), pairs.toArray().length, Pair[].class);
  }
    //Desc: method to parse results from SQL database back into InventoryPaintings
    //Post: ArrayList is loaded with results from SQL database
    public static void loadResults(ArrayList<InventoryPainting> inventoryPaintings, Vector result)
    {
        System.out.println("Num in result: " + (result.size() / 23));
        System.out.println("Num in result: " + (result.size()));
        for(int i = 0; i < result.size(); i++)
        {
            String artistFirstName = (String) result.get(i++);
            String artistLastName = (String) result.get(i++);
            int artistID = (Integer)result.get(i++);
            String titleOfWork = (String)result.get(i++);
            int dateOfWork = (Integer)result.get(i++);
            String classification = (String)result.get(i++);
            double heightCM = ((BigDecimal)result.get(i++)).doubleValue();
            double widthCM = ((BigDecimal)result.get(i++)).doubleValue();
            String medium = (String)result.get(i++);
            String subject = (String)result.get(i++);
            Date temp = ((Date)result.get(i++)); //hopefully remove
            SimpleDate dateOfPurchase = new SimpleDate(temp.getYear(), temp.getMonth(), temp.getDay());
            String sellerName = (String)result.get(i++);
            String sellerAddress = (String)result.get(i++);
            double maxPurchasePrice = ((BigDecimal)result.get(i++)).doubleValue();
            double actualPurchasePrice = ((BigDecimal)result.get(i++)).doubleValue();
            double targetPurchasePrice = ((BigDecimal)result.get(i++)).doubleValue();
            boolean soldYesOrNo = (Boolean)result.get(i++); //breaking here
            temp = ((Date)result.get(i++)); //hopefully remove
            SimpleDate dateOfSale;
            if(soldYesOrNo) dateOfSale = new SimpleDate(temp.getYear(), temp.getMonth(), temp.getDay());
            else dateOfSale = new SimpleDate();
            String buyerName = (String)result.get(i++);
            String buyerAddress = (String)result.get(i++);
            double actualSellingPrice = ((BigDecimal)result.get(i++)).doubleValue();
            boolean flagBoughtReport = (Boolean)result.get(i++);
            boolean flagSoldReport = (Boolean)result.get(i);
            inventoryPaintings.add(new InventoryPainting(artistFirstName, artistLastName, titleOfWork, dateOfWork,
                    heightCM, widthCM, medium, subject, artistID, sellerName, sellerAddress,
                    dateOfPurchase, maxPurchasePrice, actualPurchasePrice,
                    soldYesOrNo, dateOfSale, buyerName, buyerAddress,
                    actualSellingPrice, classification));
        }
    }
    //Desc: method converts an InventoryPainting into a String. Flags are set to true if the value is uninitialized.
  //Return: returns a String for the SQL statement
  private static String stringify(InventoryPainting inventory)
  {
    boolean isQuery = true;
    String result = "";
    Pair[] pairs = loadMap(inventory,isQuery);
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
  //Desc: method updates an InventoryPainting in the database. Compares to titleOfWork as key.
  //Post: an InventoryPainting is updated in the database
  public static void updateInventoryPainting(InventoryPainting inventory, InventoryPainting searchKey)
  {
    boolean isQuery = false;
    String tableStatement = "artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID";
    String statement = "UPDATE " + tableStatement + " SET";
    Pair[] pairs = loadMap(inventory, isQuery);
    statement += HandlerUtility.loadKeysAndValues(pairs);
    statement += " FROM " + tableStatement;
    statement += stringify(searchKey);
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Query();
  }
  //Desc: method deletes an InventoryPainting in the database
  //Post: an InventoryPainting is deleted in the database
  public static void deleteInventoryPainting(InventoryPainting inventory)
  {
    String tableStatement = "artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID";
    String statement = "DELETE FROM " + tableStatement;
    statement += stringify(inventory);
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Query();
  }
}
class HandleInventoryPaintingsTest
{
    //Desc: method to run unit tests for all methods
    //Output: prints the results of unit tests
    public static void runTests()
    {
        createInventoryPaintingTest();
    }
    public static boolean createInventoryPaintingTest()
    {
        InventoryPainting testPainting = new InventoryPainting("Sammichelle", "Bachman",
                "Twinkle, Twinkle", 1992, 24.2, 36.3, "Oil", "Economics", -1,
                "Cloud Fieldsize", "Van by the river", new SimpleDate(2010, 6,
                14), 1230000, 1000000, false, new SimpleDate(
                SimpleDate.DEFAULT), "", "", -1, "MasterPiece");
        HandleInventoryPaintings.createInventoryPainting(testPainting);
        InventoryPainting[] result = HandleInventoryPaintings.retrieveInventoryPaintings(testPainting);
        if(result.length != 1) return false;
        if(!result.equals(testPainting)) return false;
        return true;
    }
}