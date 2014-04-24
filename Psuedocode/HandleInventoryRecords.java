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
  public static InventoryRecord[] retrieveInventoryRecords(InventoryRecord inventory) //if string is empty, will bring all
  {
    String statement = "SELECT painterID, titleOfWork, dateOfWork, classification, "
     + "heightCM, widthCM, medium, subject, sellerName, sellerAddress, dateOfPurchase, maxPurchasePrice,"
     + " actualPurchasePrice, targetSellPrice, soldYesOrNo, dateOfSale, buyerName, buyerAddress, actualSellingPrice"
     + " FROM painters INNER JOIN inventory_paintings ON painters.painterID= inventory_paintings.painterID"
    statement += stringify(auction)
    statement += " ORDER BY lastName, firstName" //probably needs to be changed
    SQLConnector connection = new SQLConnector(0, statement)
    Vector result = connector.executeSQLQuery()
    ArrayList<InventoryRecord> inventoryRecords = new ArrayList<InventoryRecord>()
    for(int i = 0; i < result.size(); i++)
    {
      String firstName = result.get(i++)
      String lastName = result.get(i++)
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
      inventoryRecords.add(firstName, lastName, titleOfWork, dateOfWork, classification, heightCM, widthCM, medium,
                           subject, sellerName, sellerAddress, dateOfPurchase, maxPurchasePrice, actualPurchasePrice, 
                           targetSellPrice, soldYesOrNo, dateOfSale, buyerName, buyerAddress, actualSellingPrice)
    }
    return inventoryRecords.toArray()
  }
  //Desc: method converts an InventoryRecord into a String. Flags are set to true if the value is uninitialized.
  //Return: returns a String for the SQL statement
  private static String stringify(InventoryRecord inventory)
  {
    String result = ""
    boolean[] flags = new boolean[18]
    int painterID = HandleArtist.getArtistID(new Artist(inventory.getFirstName(), inventory.getLastName(), -1))
    String titleOfWork = inventory.getTitleOfWork()
    int dateOfWork = inventory.getDateOfWork()
    int classification = inventory.getClassification()
    double heightCM = inventory.getHeightCM()
    double widthCM = inventory.getWidthCM()
    String medium = inventory.getMedium()
    String subject = inventory.getSubject()
    String sellerName = inventory.getSellerName()
    String sellerAddress = inventory.getSellerAddress()
    Date dateOfPurchase = inventory.getDateOfPurchase()
    double maxPurchasePrice = inventory.getMaxPurchasePrice()
    double actualPurchasePrice = inventory.getActualPurchasePrice()
    double targetSellPrice = inventory.getTargetSellPrice()
    Date dateOfSale = inventory.getDateOfSale()
    String buyerName = inventory.getBuyerName()
    String buyerAddress = inventory.getBuyerAddress()
    double actualSellingPrice = inventory.getActualSellingPrice()                                   
    if(painterID == -1) flags[0] = true
    else result += "WHERE painterID ='" + painterID + "'"
    if(titleOfWork == null || titleOfWork.equals("")) flags[1] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE titleOfWork ='" + titleOfWork + "'"
      else result += "AND titleOfWork ='" + titleOfWork + "'"
    }
    if(dateOfWork == -1) flags[2] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE dateOfWork ='" + dateOfWork + "'"
      else result += "AND dateOfWork ='" + dateOfWork + "'"
    }
    if(classification == null || classification.equals("")) flags[3] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE classification ='" + classification + "'"
      else result += "AND classification ='" + classification + "'"
    }
    if(heightCM < 0) flags[4] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE classification ='" + classification + "'"
      else result += "AND classification ='" + classification + "'"
    }
    if(widthCM < 0) flags[5] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE widthCM ='" + widthCM + "'"
      else result += "AND widthCM ='" + widthCM + "'"
    }
    if(medium == null || medium.equals("")) flags[6] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE medium ='" + medium + "'"
      else result += "AND medium ='" + medium + "'"
    }
    if(subject == null || subject.equals("")) flags[7] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE subject ='" + subject + "'"
      else result += "AND subject ='" + subject + "'"
    }
    if(sellerName == null ||  sellerName.equals("")) flags[8] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE sellerName ='" + sellerName + "'"
      else result += "AND sellerName ='" + sellerName + "'"
    }
    if(sellerAddresseOfSale == null || sellerAddress.equals("")) flags[9] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE sellerAddress ='" + sellerAddress + "'"
      else result += "AND sellerAddress ='" + sellerAddress + "'"
    }
    if(dateOfPurchase == null) flags[10] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE dateOfPurchase ='" + dateOfPurchase.toString() + "'"
      else result += "AND dateOfPurchase ='" + dateOfPurchase.toString() + "'"
    }
    if(maxPurchasePrice < 0) flags[11] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE maxPurchasePrice ='" + maxPurchasePrice + "'"
      else result += "AND maxPurchasePrice ='" + maxPurchasePrice + "'"
    }
    if(actualPurchasePrice < 0) flags[12] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE actualPurchasePrice ='" + actualPurchasePrice + "'"
      else result += "AND actualPurchasePrice ='" + actualPurchasePrice + "'"
    }
    if(targetSellPrice < 0) flags[13] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE targetSellPrice ='" + targetSellPrice + "'"
      else result += "AND targetSellPrice ='" + targetSellPrice + "'"
    }
    if(dateOfSale == null) flags[14] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE dateOfSale ='" + dateOfSale + "'"
      else result += "AND dateOfSale ='" + dateOfSale + "'"
    }
    if(buyerName == null || buyerName.equals("")) flags[15] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE buyerName ='" + buyerName + "'"
      else result += "AND buyerName ='" + buyerName + "'"
    }
    if(buyerAddress == null || buyerAddress.equals("")) flags[16] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE buyerAddress ='" + buyerAddress + "'"
      else result += "AND buyerAddress ='" + buyerAddress + "'"
    }
    if(actualSellingPrice < 0) flags[17] = true
    else
    {
      if(checkArray(flags, i)) result += "WHERE actualSellingPrice ='" + actualSellingPrice + "'"
      else result += "AND actualSellingPrice ='" + actualSellingPrice + "'"
    }
    return result
  }
    double actualSellingPrice 
  //Desc: method to interate through flags and return boolean value
  //Return: returns true if all are true, false if any are false
  private static boolean checkArray(boolean[] flags, int count) throws ArrayIndexOutOfBoundsException
  {
    if(count > flags.length - 1 || count < 0) throw ArrayIndexOutOfBoundsException
    for(int i = 0; i <= count; i++)
    {
      if(!flags[i]) return false
    }
    return true
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