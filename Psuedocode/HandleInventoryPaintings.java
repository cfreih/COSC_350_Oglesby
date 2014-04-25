public abstract class HandleInventoryPaintings
{
  //Desc: method creates an InventoryPainting in the database
  //Post: an InventoryPainting is created in the database
  public static void createInventoryPainting(InventoryPainting inventory)
  {
    int artistID = HandleArtist.getArtistID(new Artist(inventory.getArtistFirstName(), inventory.getArtistLastName(), -1)) 
    String statement = "INSERT INTO inventory_paintings(artistID, titleOfWork, dateOfWork, classification, "
     + "heightCM, widthCM, medium, subject, sellerName, sellerAddress, dateOfPurchase, maxPurchasePrice,"
     + " actualPurchasePrice, targetSellPrice, soldYesOrNo, dateOfSale,"
      +" buyerName, buyerAddress, actualSellingPrice) VALUES('" + artistID
      + "','" + inventory.getTitleOfWork() + "','" + inventory.getDateOfWork() + "','" + inventory.getHeightCM() + 
      "','" + inventory.getWidthCM() + "','" + inventory.getMedium() + "','" + inventory.getSubject()
      + "','" + inventory.getSellerName() + "','" + inventory.getSellerAddress + "','" + inventory.getDateOfPurchase().toString() 
      + "','" + inventory.getMaxPurchasePrice() + "','" + inventory.getActualPurchasePrice() + "','" + inventory.getTargetSellPrice()
      + "','" + inventory.getSoldYesOrNo() + "','" + inventory.getDateOfSale.toString() + "','" + inventory.getBuyerName()
      + "','" + inventory.getBuyerAddress() + "','" + inventory.getActualSellingPrice() +  "')"
    SQLConnector connection = new SQLConnector(statement)
    connection.executeSQLQuery()
  }
  //Desc: method searches the database and retrieves any matching records. 
  // Search terms only a Date object
  // Is a special case for the FindSoldPaintings class.
  //Return: returns an InventoryPainting array, with elements matching search terms
  public static InventoryPainting[] retrieveInventoryPaintings(Date d)
  {
    int date = HandlerUtility.dateToInt(d)
    String statement = "SELECT artistID, titleOfWork, dateOfWork, classification, "
     + "heightCM, widthCM, medium, subject, sellerName, sellerAddress, dateOfPurchase, maxPurchasePrice,"
     + " actualPurchasePrice, targetSellPrice, soldYesOrNo, dateOfSale, buyerName, buyerAddress, actualSellingPrice"
     + " FROM artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID"
     + " WHERE sold=1 and dateOfSale > " + date + " Order by artistLastName" 
    SQLConnector connection = new SQLConnector(statement)
    Vector result = connection.executeSQLQuery()
    ArrayList<InventoryPainting> inventoryPaintings = new ArrayList<InventoryPainting>()
    loadResults(inventoryPaintings, result)
    return inventoryPaintings.toArray()
  }
  //Desc: method searches the database and retrieves any matching records. 
  // Search terms are passed in as an InventoryPainting array with fields intialized if they are search terms
  // Is a special case for the DetectTrendsReport class.
  //Return: returns an InventoryPainting array, with elements matching search terms
  public static InventoryPainting[] retrieveInventoryPaintings(InventoryPainting[] inventory)
  {
    String statement = "SELECT artistID, titleOfWork, dateOfWork, classification, "
     + "heightCM, widthCM, medium, subject, sellerName, sellerAddress, dateOfPurchase, maxPurchasePrice,"
     + " actualPurchasePrice, targetSellPrice, soldYesOrNo, dateOfSale, buyerName, buyerAddress, actualSellingPrice"
     + " FROM artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID"
    for(int i = 0; i < inventory.length; i++)
    {
      if(i != 0) statement += " OR"
      statement += stringify(inventory[i])
    }
    statement += " ORDER BY artistLastName, artistArtistFirstName" //probably needs to be changed
    SQLConnector connection = new SQLConnector(statement)
    Vector result = connection.executeSQLQuery()
    ArrayList<InventoryPainting> inventoryPaintings = new ArrayList<InventoryPainting>()
    loadResults(inventoryPaintings, result)
    return inventoryPaintings.toArray()
  }
  //Desc: method searches the database and retrieves any matching records. 
  // Search terms are passed in as an InventoryPainting with fields initialized if they are search terms
  //Return: returns an InventoryPainting array, with elements matching search terms
  public static InventoryPainting[] retrieveInventoryPaintings(InventoryPainting inventory) //if string is empty, will bring all
  {
    String statement = "SELECT artistID, titleOfWork, dateOfWork, classification, "
     + "heightCM, widthCM, medium, subject, sellerName, sellerAddress, dateOfPurchase, maxPurchasePrice,"
     + " actualPurchasePrice, targetSellPrice, soldYesOrNo, dateOfSale, buyerName, buyerAddress, actualSellingPrice"
     + " FROM artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID"
    statement += stringify(auction)
    statement += " ORDER BY artistLastName, artistArtistFirstName" //probably needs to be changed
    SQLConnector connection = new SQLConnector(statement)
    Vector result = connection.executeSQLQuery()
    ArrayList<InventoryPainting> inventoryPaintings = new ArrayList<InventoryPainting>()
    loadResults(inventoryPaintings, result)
    return inventoryPaintings.toArray()
  }
  //Desc: method to parse results from SQL database back into InventoryPaintings
  //Post: ArrayList is loaded with results from SQL database
  public static void loadResults(ArrayList<InventoryPainting> inventoryPaintings, Vector result)
  {
    for(int i = 0; i < result.size(); i++)
    {
      String artistArtistFirstName = result.get(i++)
      String artistLastName = result.get(i++)
      String titleOfWork = result.get(i++)
      int dateOfWork = Integer.parseInt(result.get(i++))
      int classification = Integer.parseInt(result.get(i++))
      double heightCM = Double.parseDouble(result.get(i++))
      double widthCM = Double.parseDouble(result.get(i++))
      String medium = result.get(i++)
      String subject = result.get(i++)
      String sellerName = result.get(i++)
      String sellerAddress = result.get(i++)
      Date dateOfPurchase = Date.parse(result.get(i++))
      double maxPurchasePrice = Double.parseDouble(result.get(i++))
      double actualPurchasePrice = Double.parseDouble(result.get(i++))
      double targetSellPrice = Double.parseDouble(result.get(i++))
      boolean soldYesOrNo = Booolean.parseBoolean(result.get(i++))
      Date dateOfSale = Date.parse(result.get(i++))
      String buyerName = result.get(i++)
      String buyerAddress = result.get(i++)
      double actualSellingPrice = result.get(i)
      inventoryPaintings.add(artistArtistFirstName, artistLastName, titleOfWork, dateOfWork, classification, heightCM, widthCM, medium,
                           subject, sellerName, sellerAddress, dateOfPurchase, maxPurchasePrice, actualPurchasePrice, 
                           targetSellPrice, soldYesOrNo, dateOfSale, buyerName, buyerAddress, actualSellingPrice)
    }
  }
  //Desc: method to load a HashMap with values to assist in the automation of SQL statements
  // In particular, this method assists with limiting the amount of hardcoding in the stringify
  //Return: the fully loaded HashMap is returned
  private static HashMap<String,Object> loadMap(InventoryPainting inventory)
  {
    HashMap<String,Object> objects = new HashMap<String,Object>()
    objects.put("artistID", HandleArtist.getArtistID(new Artist(inventory.getArtistFirstName(), inventory.getArtistLastName(), -1)))
    objects.put("titleOfWork", inventory.getTitleOfWork())
    objects.put("dateOfWork", inventory.getDateOfWork())
    objects.put("classification", inventory.getClassification())
    objects.put("heightCM", inventory.getHeightCM())
    objects.put("widthCM", inventory.getWidthCM())
    objects.put("medium", inventory.getMedium())
    objects.put("subject", inventory.getSubject())
    objects.put("sellerName", inventory.getSellerName())
    objects.put("sellerAddress", inventory.getSellerAddress())
    objects.put("dateOfPurchase", inventory.getDateOfPurchase())
    objects.put("maxPurchasePrice", inventory.getMaxPurchasePrice())
    objects.put("actualPurchasePrice", inventory.getActualPurchasePrice())
    objects.put("targetSellPrice", inventory.getTargetSellPrice())
    objects.put("dateOfSale", inventory.getDateOfSale())
    objects.put("buyerName", inventory.getBuyerName())
    objects.put("buyerAddress", inventory.getBuyerAddress())
    objects.put("actualSellingPrice", inventory.getActualSellingPrice())
    return objects
  }
  //Desc: method converts an InventoryPainting into a String. Flags are set to true if the value is uninitialized.
  //Return: returns a String for the SQL statement
  private static String stringify(InventoryPainting inventory)
  {
    String result = ""
    boolean[] flags = new boolean[9]
    HashMap<String,Object> objects = loadMap(inventory)
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
  //Desc: method updates an InventoryPainting in the database. Compares to titleOfWork as key.
  //Post: an InventoryPainting is updated in the database
  public static void updateInventoryPainting(InventoryPainting inventory, InventoryPainting searchKey)
  {
    String statement = "UPDATE FROM artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID "
      + "SET artistID='" + HandleArtist.getArtistID(inventory.getArtistFirstName(), inventory.getArtistLastName(), -1)
      + "',titleOfWork='" + inventory.getTitleOfWork() + "',dateOfWork='" + inventory.getDateOfWork() 
      + "',classification='" + inventory.getClassification() + "',heightCM='" + inventory.getHeightCM()
      + "',widthCM='" + inventory.getWidthCM() + "',medium='" + inventory.getMedium() + "',subject='" + inventory.getSubject()
      + "',sellerName='" inventory.getSellerName() + "',sellerAddress='" + inventory.getSellerAddress() + "',dateOfPurchase='"
      + inventory.getDateOfPurchase() + "',maxPurchasePrice='" + inventory.getMaxPurchasePrice() + "',actualPurchasePrice='"
      + inventory.getActualPurchasePrice() + "',targetSellPrice='" + inventory.getTargetSellPrice() + "',dateOfSale='"
      + inventory.getDateOfSale() + "',buyerName='" + inventory.getBuyerName() + "',buyerAddress='" + inventory.getBuyerAddress()
      + "',actualSellingPrice='" + inventory.getActualSellingPrice() + stringify(searchKey)
    SQLConnector connection = new SQLConnector(statement)
    connection.executeSQLQuery()
  }
  //Desc: method deletes an InventoryPainting in the database
  //Post: an InventoryPainting is deleted in the database
  public static void deleteInventoryPainting(InventoryPainting inventory)
  {
    String statement = "DELETE FROM artists INNER JOIN inventory_paintings ON artists.artistID= inventory_paintings.artistID"
    statement += stringify(inventory)
    SQLConnector connection = new SQLConnector(statement)
    connection.executeSQLQuery()
  }
}