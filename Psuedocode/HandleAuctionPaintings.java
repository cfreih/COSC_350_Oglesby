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
  //Desc: method converts an AuctionPainting into a String
  //Return: returns a String for the SQL statement
  private static String stringify(AuctionPainting auction)
  {
    String result = ""
    int i = 0
    boolean[] flags = new boolean[9]
    int artistID = HandleArtist.getArtistID(new Artist(auction.getFirstName(), auction.getLastName(), -1))
    String titleOfWork = auction.getTitleOfWork()
    int dateOfWork = auction.getDateOfWork()
    double heightCM = auction.getHeightCM()
    double widthCM = auction.getWidthCM()
    String medium = auction.getMedium()
    String subject = auction.getSubject()
    double auctionSalePrice = auction.getAuctionSalePrice()
    Date auctionDateOfSale = auction.getAuctionDateOfSale()                                       
    if(artistID == -1) flags[i++] = true
    else result += " WHERE artistID ='" + artistID + "'"
    if(titleOfWork == null || titleOfWork.equals("")) flags[i] = true
    else
    {
      if(HandlerUtility.checkFlags(flags, i++)) result += " WHERE titleOfWork ='" + titleOfWork + "'"
      else result += " AND titleOfWork ='" + titleOfWork + "'"
    }
    if(dateOfWork == -1) flags[i] = true
    else
    {
      if(HandlerUtility.checkFlags(flags, i++)) result += " WHERE dateOfWork ='" + dateOfWork + "'"
      else result += " AND dateOfWork ='" + dateOfWork + "'"
    }
    if(classification == null || classification.equals("")) flags[i] = true
    else
    {
      if(HandlerUtility.checkFlags(flags, i++)) result += " WHERE classification ='" + classification + "'"
      else result += " AND classification ='" + classification + "'"
    }
    if(widthCM < 0) flags[i] = true
    else
    {
      if(HandlerUtility.checkFlags(flags, i++)) result += " WHERE widthCM ='" + widthCM + "'"
      else result += " AND widthCM ='" + widthCM + "'"
    }
    if(medium == null || medium.equals("")) flags[i] = true
    else
    {
      if(HandlerUtility.checkFlags(flags, i++)) result += " WHERE medium ='" + medium + "'"
      else result += " AND medium ='" + medium + "'"
    }
    if(subject == null || subject.equals("")) flags[i] = true
    else
    {
      if(HandlerUtility.checkFlags(flags, i++)) result += " WHERE subject ='" + subject + "'"
      else result += " AND subject ='" + subject + "'"
    }
    if(auctionSalePrice < 0) flags[i] = true
    else
    {
      if(HandlerUtility.checkFlags(flags, i++)) result += " WHERE auctionSalePrice ='" + auctionSalePrice + "'"
      else result += " AND auctionSalePrice ='" + auctionSalePrice + "'"
    }
    if(auctionDateOfSale == null) flags[i] = true
    else
    {
      if(HandlerUtility.checkFlags(flags, i++)) result += " WHERE auctionDateOfSale ='" + auctionDateOfSale.toString() + "'"
      else result += " AND auctionDateOfSale ='" + auctionDateOfSale.toString() + "'"
    }
    return result
  }
  //Desc: method updates an AuctionPainting in the database
  //Post: an AuctionPainting is updated in the database
  public static void updateAuctionPainting(AuctionPainting auction, String titleOfWork)
  {
    String statement = "UPDATE FROM artists INNER JOIN auction_paintings ON artists.artistID= auction_paintings.artistID "
      + "SET artistID='" + HandleArtist.getArtistID(auction.getFirstName(), auction.getLastName(), -1) +
      "',titleOfWork='" + auction.getTitleOfWork() + "'dateOfWork=,'" + artist.getDateOfWork()
      + "' WHERE titleOfWork = '" + titleOfWork +"'"
    statement += artist.toString()
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