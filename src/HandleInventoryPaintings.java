import java.util.*;
public abstract class HandleInventoryPaintings
{
  //Desc: method creates an InventoryPainting in the database
  //Post: an InventoryPainting is created in the database
  public static void createInventoryPainting(InventoryPainting inventory)
  {
    String tableStatement = "inventory_paintings";
    String statement = "INSERT INTO "+ tableStatement +"(";
    HashMap<String,Object> objects = loadMap(inventory);
    String[] keys = (String[]) objects.keySet().toArray();
    statement += HandlerUtility.loadKeys(keys);
    statement += ") VALUES(";
    statement += HandlerUtility.loadValues(objects, keys);
    statement += ")";
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Query();
  }
  //Desc: method searches the database and retrieves any matching records. 
  // Search terms only a Date object
  // Is a special case for the FindSoldPaintings class.
  //Return: returns an InventoryPainting array, with elements matching search terms
  public static InventoryPainting[] retrieveInventoryPaintings(Date d)
  {
    String tableStatement = "artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID";
    String orderBy = "artistLastName, artistFirstName";
    int date = HandlerUtility.dateToInt(d);
    String statement = "SELECT";
    HashMap<String,Object> objects = loadMap(new InventoryPainting());
    String[] keys = (String[]) objects.keySet().toArray();
    statement += HandlerUtility.loadKeys(keys);
    statement += " FROM " + tableStatement;
    statement += " WHERE sold=1 and dateOfSale > " + date + " ";
    statement += " ORDER BY " + orderBy;
    SQLConnector connection = new SQLConnector(statement);
    Vector result = connection.executeSQL_Query();
    ArrayList<InventoryPainting> inventoryPaintings = new ArrayList<InventoryPainting>();
    loadResults(inventoryPaintings, result);
    return (InventoryPainting[]) inventoryPaintings.toArray();
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
    HashMap<String,Object> objects = loadMap(new InventoryPainting());
    String[] keys = (String[]) objects.keySet().toArray();
    statement += HandlerUtility.loadKeys(keys);
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
    HashMap<String,Object> objects = loadMap(new InventoryPainting());
    String[] keys = (String[]) objects.keySet().toArray();
    statement += HandlerUtility.loadKeys(keys);
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
      //Date dateOfPurchase = new Date(Date.parse((String)result.get(i++)));
      double maxPurchasePrice = Double.parseDouble((String)result.get(i++));
      double actualPurchasePrice = Double.parseDouble((String)result.get(i++));
      boolean soldYesOrNo = Boolean.parseBoolean((String)result.get(i++));
      SimpleDate dateOfSale = (SimpleDate) result.get(i++);
      //Date dateOfSale = new Date(Date.parse((String)result.get(i++)));
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
  private static HashMap<String,Object> loadMap(InventoryPainting inventory)
  {
    HashMap<String,Object> objects = new HashMap<String,Object>();
    objects.put("artistID", inventory.getArtistID());
    objects.put("titleOfWork", inventory.getTitleOfWork());
    objects.put("dateOfWork", inventory.getDateOfWork());
    objects.put("classification", inventory.getClassification());
    objects.put("heightCM", inventory.getHeightCM());
    objects.put("widthCM", inventory.getWidthCM());
    objects.put("medium", inventory.getMedium());
    objects.put("subject", inventory.getSubject());
    objects.put("sellerName", inventory.getSellerName());
    objects.put("sellerAddress", inventory.getSellerAddress());
    objects.put("dateOfPurchase", inventory.getDateOfPurchase());
    objects.put("maxPurchasePrice", inventory.getMaxPurchasePrice());
    objects.put("actualPurchasePrice", inventory.getActualPurchasePrice());
    objects.put("dateOfSale", inventory.getDateOfSale());
    objects.put("buyerName", inventory.getBuyerName());
    objects.put("buyerAddress", inventory.getBuyerAddress());
    objects.put("actualSellingPrice", inventory.getActualSellPrice());
    return objects;
  }
  //Desc: method converts an InventoryPainting into a String. Flags are set to true if the value is uninitialized.
  //Return: returns a String for the SQL statement
  private static String stringify(InventoryPainting inventory)
  {
    String result = "";
    HashMap<String,Object> objects = loadMap(inventory);
    boolean[] flags = new boolean[objects.size()];
    String[] keys = (String[])objects.keySet().toArray();
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
  //Desc: method updates an InventoryPainting in the database. Compares to titleOfWork as key.
  //Post: an InventoryPainting is updated in the database
  public static void updateInventoryPainting(InventoryPainting inventory, InventoryPainting searchKey)
  {
    String tableStatement = "artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID";
    String statement = "UPDATE " + tableStatement + " SET";
    HashMap<String,Object> objects = loadMap(inventory);
    String[] keys = (String[]) objects.keySet().toArray();
    statement += HandlerUtility.loadKeysAndValues(objects,keys);
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