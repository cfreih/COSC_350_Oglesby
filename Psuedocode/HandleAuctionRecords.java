public abstract class HandleAuctionRecords
{
  //Desc: method creates an AuctionRecord in the database
  //Post: an AuctionRecord is created in the database
  public static void createAuctionRecord(AuctionRecord auction)
  {
    String statement = "SQL CREATE statement" //actual SQL statement will be completed in next step
    statement += auction.toString()
    SQLConnector connection = new SQLConnector(1, statement)
  }
  //Desc: method searches the database and retrieves any matching records. Search terms are passed in as a String
  //Return: returns an AuctionRecord array, with elements matching search terms
  public static AuctionRecord[] retrieveAuctionRecords(String searchTerm) //if string is empty, will bring all
  {
    String statement = "SQL GET statement" //actual SQL statement will be completed in next step
    statement += searchTerm
    SQLConnector connection = new SQLConnector(0, statement)
    String[] result = connection.getQueryResult()
    ArrayList<AuctionRecord> auctionRecords = new ArrayList<AuctionRecord>()
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
      double auctionSalePrice = Double.parseDouble(result[i++])
      Date auctionDateOfSale = Date.parse(result[i])
      auctionRecords.add(firstName, lastName, titleOfWork, dateOfWork, classification, heightCM, widthCM, medium, subject, auctionSalePrice, auctionDateOfSale)
    }
    return auctionRecords.toArray()
  }  
  //Desc: method updates an AuctionRecord in the database
  //Post: an AuctionRecord is updated in the database
  public static void updateAuctionRecord(AuctionRecord auction)
  {
    String statement = "SQL UPDATE statement" //actual SQL statement will be completed in next step
    statement += auction.toString()
    SQLConnector connection = new SQLConnector(1, statement)
  }
  //Desc: method deletes an AuctionRecord in the database
  //Post: an AuctionRecord is deleted in the database
  public static void deleteAuctionRecord(AuctionRecord auction)
  {
    String statement = "SQL DELETE statement" //actual SQL statement will be completed in next step
    statement += auction.toString()
    SQLConnector connection = new SQLConnector(1, statement)
  }
}