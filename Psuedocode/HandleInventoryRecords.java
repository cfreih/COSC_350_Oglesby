public abstract class HandleInventoryRecords
{
  //Desc: method creates an InventoryRecord in the database
  //Post: an InventoryRecord is created in the database
  public static void createInventoryRecord(InventoryRecord inventory)
  {
    String statement = "SQL CREATE statement" //actual SQL statement will be completed in next step
    statement += inventory.toString()
    SQLConnector connection = new SQLConnector(1, statement)
  }
  //Desc: method searches the database and retrieves any matching records. Search terms are passed in as a String
  //Return: returns an InventoryRecord array, with elements matching search terms
  public static InventoryRecord[] retrieveInventoryRecords(String searchTerm) //if string is empty, will bring all
  {
    String statement = "SQL GET statement" //actual SQL statement will be completed in next step
    statement += searchTerm
    SQLConnector connection = new SQLConnector(0, statement)
    String[] result = connection.getQueryResult()
    ArrayList<InventoryRecord> inventoryRecords = new ArrayList<InventoryRecord>()
    for(int i = 0; i < result.length; i++)
    {
      String firstName = result[i++]
      String lastName = result[i++]
      String titleOfWork = result[i++]
      int dateOfWork = Integer.parseInt(result[i++])
      String classification = result[i++]
      double heightCM = Double.parseDouble(result[i++])
      double widthCM = Double.parseDouble(result[i++])
      String medium = result[i++]
      String subject = result[i++]
      String sellerName = result[i++]
      String sellerAddress = result[i++]
      Date dateOfPurchase = Date.parse(result[i++])
      double maxPurchasePrice = Double.parseDouble(result[i++])
      double actualPurchasePrice = Double.parseDouble(result[i++])
      double targetSellPrice = Double.parseDouble(result[i++])
      boolean soldYesOrNo = Booolean.parseBoolean(result[i++])
      Date dateOfSale = Date.parse(result[i++])
      String buyerName = result[i++]
      String buyerAddress = result[i++]
      double actualSellingPrice = result[i]
      inventoryRecords.add(firstName, lastName, titleOfWork, dateOfWork, classification, heightCM, widthCM, medium, subject, auctionSalePrice, auctionDateOfSale)
    }
    return inventoryRecords.toArray()
  }
  //Desc: method updates an InventoryRecord in the database
  //Post: an InventoryRecord is updated in the database
  public static void updateInventoryRecord(InventoryRecord inventory)
  {
    String statement = "SQL UPDATE statement" //actual SQL statement will be completed in next step
    statement += inventory.toString()
    SQLConnector connection = new SQLConnector(1, statement)
  }
  //Desc: method deletes an InventoryRecord in the database
  //Post: an InventoryRecord is deleted in the database
  public static void deleteInventoryRecord(InventoryRecord inventory)
  {
    String statement = "SQL DELETE statement" //actual SQL statement will be completed in next step
    statement += inventory.toString() 
    SQLConnector connection = new SQLConnector(1, statement)
  }
}