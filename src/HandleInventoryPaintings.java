import java.util.*;
public abstract class HandleInventoryPaintings
{
  //Desc: method creates an InventoryPainting in the database
  //Post: an InventoryPainting is created in the database
  public static void createInventoryPainting(InventoryPainting inventory)
  {
    String tableStatement = "inventory_paintings";
    String statement = "INSERT INTO "+ tableStatement +"(";
    Pair[] pairs = loadMap(inventory);
    statement += HandlerUtility.loadKeys(pairs);
    statement += ") VALUES(";
    statement += HandlerUtility.loadValues(pairs);
    statement += ")";
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Query();
  }
  //Desc: method searches the database and retrieves any matching records. 
  // Search terms only a Date object
  // Is a special case for the FindSoldPaintings class.
  //Return: returns an InventoryPainting array, with elements matching search terms
  public static InventoryPainting[] retrieveInventoryPaintings(SimpleDate d)
  {
    String tableStatement = "artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID";
    String orderBy = "artistLastName, artistFirstName";
    int date = HandlerUtility.dateToInt(d);
    String statement = "SELECT";
    Pair[] pairs = loadMap(new InventoryPainting());
    statement += HandlerUtility.loadKeys(pairs);
    System.out.println(statement);
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
    String tableStatement = "artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID";
    String orderBy = "artistLastName, artistFirstName";
    String statement = "SELECT";
    Pair[] pairs = loadMap(new InventoryPainting());
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
    return (InventoryPainting[])inventoryPaintings.toArray();
  }
  //Desc: method searches the database and retrieves any matching records. 
  // Search terms are passed in as an InventoryPainting with fields initialized if they are search terms
  //Return: returns an InventoryPainting array, with elements matching search terms
  public static InventoryPainting[] retrieveInventoryPaintings(InventoryPainting inventory) //if string is empty, will bring all
  {
    String tableStatement = "artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID";
    String orderBy = "artistLastName, artistFirstName";
    String statement = "SELECT";
    Pair[] pairs = loadMap(new InventoryPainting());
    statement += HandlerUtility.loadKeys(pairs);
    statement += " FROM " + tableStatement;
    statement += stringify(inventory);
    statement += " ORDER BY " + orderBy;
    SQLConnector connection = new SQLConnector(statement);
    Vector result = connection.executeSQL_Query();
    ArrayList<InventoryPainting> inventoryPaintings = new ArrayList<InventoryPainting>();
    loadResults(inventoryPaintings, result);
    return (InventoryPainting[])inventoryPaintings.toArray();
  }
  //Desc: method to parse results from SQL database back into InventoryPaintings
  //Post: ArrayList is loaded with results from SQL database
  public static void loadResults(ArrayList<InventoryPainting> inventoryPaintings, Vector result)
  {
    for(int i = 0; i < result.size(); i++)
    {
      String artistFirstName = (String)result.get(i++);
      String artistLastName = (String)result.get(i++);
      String titleOfWork = (String)result.get(i++);
      int dateOfWork = Integer.parseInt((String)result.get(i++));
      String classification = (String)result.get(i++);
      double heightCM = Double.parseDouble((String)result.get(i++));
      double widthCM = Double.parseDouble((String)result.get(i++));
      String medium = (String)result.get(i++);
      String subject = (String)result.get(i++);
      int artistID = Integer.parseInt((String)result.get(i++));
      String sellerName = (String)result.get(i++);
      String sellerAddress = (String)result.get(i++);
      SimpleDate dateOfPurchase = (SimpleDate) result.get(i++);
      double maxPurchasePrice = Double.parseDouble((String)result.get(i++));
      double actualPurchasePrice = Double.parseDouble((String)result.get(i++));
      boolean soldYesOrNo = Boolean.parseBoolean((String)result.get(i++));
      SimpleDate dateOfSale = (SimpleDate) result.get(i++);
      String buyerName = (String)result.get(i++);
      String buyerAddress = (String)result.get(i++);
      double actualSellingPrice = Double.parseDouble((String)result.get(i++));
      inventoryPaintings.add(new InventoryPainting(artistFirstName, artistLastName, titleOfWork, dateOfWork, 
                                                   heightCM, widthCM, medium, subject, artistID, sellerName, sellerAddress,
                                                   dateOfPurchase, maxPurchasePrice, actualPurchasePrice, 
                                                   soldYesOrNo, dateOfSale, buyerName, buyerAddress,
                                                   actualSellingPrice, classification));
    }
  }  
  //Desc: method to load a HashMap with values to assist in the automation of SQL statements
  // In particular, this method assists with limiting the amount of hardcoding in the stringify
  //Return: the fully loaded HashMap is returned
  private static Pair[] loadMap(InventoryPainting inventory)
  {
    ArrayList<Pair> pairs = new ArrayList<Pair>();
    pairs.add(new Pair("artistID", inventory.getArtistID()));
    pairs.add(new Pair("title", inventory.getTitleOfWork()));
    pairs.add(new Pair("dateOfWork", inventory.getDateOfWork()));
    pairs.add(new Pair("classification", inventory.getClassification()));
    pairs.add(new Pair("height", inventory.getHeightCM()));
    pairs.add(new Pair("width", inventory.getWidthCM()));
    pairs.add(new Pair("medium", inventory.getMedium()));
    pairs.add(new Pair("subject", inventory.getSubject()));
    pairs.add(new Pair("dateOfPurchase", inventory.getDateOfPurchase()));
    pairs.add(new Pair("nameOfSeller", inventory.getSellerName()));
    pairs.add(new Pair("addressOfSeller", inventory.getSellerAddress()));
    pairs.add(new Pair("maximumPurchasePrice", inventory.getMaxPurchasePrice()));
    pairs.add(new Pair("actualPurchasePrice", inventory.getActualPurchasePrice()));
    pairs.add(new Pair("targetSellingPrice", inventory.getTargetSellPrice()));
    pairs.add(new Pair("sold", inventory.getSoldYesOrNo()));
    pairs.add(new Pair("dateOfSale", inventory.getDateOfSale()));
    pairs.add(new Pair("nameOfBuyer", inventory.getBuyerName()));
    pairs.add(new Pair("addressOfBuyer", inventory.getBuyerAddress()));
    pairs.add(new Pair("actualSellingPrice", inventory.getActualSellPrice()));
    pairs.add(new Pair("flagBoughtReport", inventory.getFlagBoughtReport()));
    pairs.add(new Pair("flagSoldReport", inventory.getFlagSoldReport()));
    return Arrays.copyOf(pairs.toArray(), pairs.toArray().length, Pair[].class);
  }
  //Desc: method converts an InventoryPainting into a String. Flags are set to true if the value is uninitialized.
  //Return: returns a String for the SQL statement
  private static String stringify(InventoryPainting inventory)
  {
    String result = "";
    Pair[] pairs = loadMap(inventory);
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
    String tableStatement = "artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID";
    String statement = "UPDATE " + tableStatement + " SET";
    Pair[] pairs = loadMap(inventory);
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