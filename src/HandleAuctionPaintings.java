import java.math.BigDecimal;
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
        connection.executeSQL_Update();
    }
    //Desc: method searches the database and retrieves any matching records.
    // Search terms are passed in as an AuctionPainting with fields initialized if they are search terms
    //Return: returns an AuctionPainting array, with elements matching search terms
    public static AuctionPainting[] retrieveAuctionPaintings(AuctionPainting auction) //if string is empty, will bring all
    {
        String tableStatement = "auction_paintings";
        String orderBy = "lastName, firstName";
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
        return Arrays.copyOf(auctionPaintings.toArray(), auctionPaintings.toArray().length, AuctionPainting[].class);
    }
    //Desc: method searches the database and retrieves any matching records.
    // Search terms only a Date object, only paintings older than the date will be returned
    // Is a special case for the FindSoldPaintings class.
    //Return: returns an InventoryPainting array, with elements matching search terms
    public static AuctionPainting[] retrieveAuctionPaintings(SimpleDate d, AuctionPainting auction)
    {
        String tableStatement = "auction_paintings";
        String orderBy = "lastName, firstName";
        int date = HandlerUtility.dateToInt(d);
        String statement = "SELECT";
        Pair[] pairs = loadMap(new AuctionPainting());
        statement += HandlerUtility.loadKeys(pairs);
        statement += " FROM " + tableStatement;
        statement += stringify(auction);
        statement += " AND dateOfAuction < " + date + " "; //I fixed it, there was an extra WHERE, feel free to push this up. Also, you aren't initializing your SimpleDate correctly
        statement += " ORDER BY " + orderBy;
        SQLConnector connection = new SQLConnector(statement);
        Vector result = connection.executeSQL_Query();
        ArrayList<AuctionPainting> auctionPaintings = new ArrayList<AuctionPainting>();
        loadResults(auctionPaintings, result);
        return Arrays.copyOf(auctionPaintings.toArray(), auctionPaintings.toArray().length, AuctionPainting[].class);
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
            String dateOfWork = (String) result.get(i++);
            double heightCM = ((BigDecimal) result.get(i++)).doubleValue();
            double widthCM = ((BigDecimal) result.get(i++)).doubleValue();
            String medium = (String) result.get(i++);
            String subject = (String) result.get(i++);
            double auctionSalePrice = ((BigDecimal) result.get(i++)).doubleValue();
            SimpleDate auctionDateOfSale = HandlerUtility.intToDate((Integer) result.get(i));
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
        pairs.add(new Pair("title", auction.getTitleOfWork()));
        pairs.add(new Pair("dateOfWork", auction.getDateOfWork()));
        pairs.add(new Pair("height", auction.getHeightCM()));
        pairs.add(new Pair("width", auction.getWidthCM()));
        pairs.add(new Pair("medium", auction.getMedium()));
        pairs.add(new Pair("subject", auction.getSubject()));
        pairs.add(new Pair("salePrice", auction.getSalePriceAuction()));
        pairs.add(new Pair("dateOfAuction", HandlerUtility.dateToInt(auction.getDateOfSaleAuction())));
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
            if(HandlerUtility.checkInitialization(pairs[i].getValue()));
            else
            {
                if(HandlerUtility.checkFlags(flags, i))
                {
                    result += " WHERE " + pairs[i].getKey() + "='" + pairs[i].getValue() + "'";
                    flags[i] = true;
                }
                else result += " AND " + pairs[i].getKey() + "='" + pairs[i].getValue() + "'";
            }
        }
        return result;
    }
    //Desc: method updates an AuctionPainting in the database. Compares to titleOfWork as key.
    //Post: an AuctionPainting is updated in the database
    public static void updateAuctionPainting(AuctionPainting modification, AuctionPainting searchKey)
    {
        String tableStatement = "auction_paintings";
        String statement = "UPDATE " + tableStatement + " SET";
        Pair[] pairs = loadMap(modification);
        statement += HandlerUtility.loadKeysAndValues(pairs);
        statement += stringify(searchKey);
        SQLConnector connection = new SQLConnector(statement);
        connection.executeSQL_Update();
    }
    //Desc: method deletes an AuctionPainting in the database
    //Post: an AuctionPainting is deleted in the database
    public static void deleteAuctionPainting(AuctionPainting auction)
    {
        String tableStatement = "auction_paintings";
        String statement = "DELETE FROM " + tableStatement;
        statement += stringify(auction);
        SQLConnector connection = new SQLConnector(statement);
        connection.executeSQL_Update();
    }

}
class HandleAuctionPaintingsTest
{

    //Desc: method to run unit tests for all methods
    //Output: prints the results of unit tests
    public static Pair[] runTests()
    {
        Pair[] report = new Pair[5];
        boolean result = true;
        boolean temp = createAuctionPaintingTest();
        if(!temp) result = false;
        report[1] = new Pair("\tCreateAuctionPaintingTest: ", temp);
        temp = retrieveAuctionPaintingTest();
        if(!temp) result = false;
        report[2] = new Pair("\tRetrieveAuctionPaintingTest: ", temp);
        temp = updateAuctionPaintingTest();
        if(!temp) result = false;
        report[3] = new Pair("\tUpdateAuctionPaintingTest: ", temp);
        temp = deleteAuctionPaintingTest();
        if(!temp) result = false;
        report[4] = new Pair("\tDeleteAuctionPaintingTest: ", temp);
        report[0] = new Pair("", result);
        return report;
    }
    public static boolean createAuctionPaintingTest()
    {
        AuctionPainting testPainting = new AuctionPainting("Sammichelle", "Bachman",
                "Twinkle, Twinkle", "1992", 0.1, 199.9, "Oil", "Economics",
                12, new SimpleDate(1852, 3, 17));
        HandleAuctionPaintings.createAuctionPainting(testPainting);
        AuctionPainting[] result = HandleAuctionPaintings.retrieveAuctionPaintings(testPainting);
        if(result.length < 1) return false;
        if(!result[0].getArtistFirstName().equals(testPainting.getArtistFirstName())
                && result[0].getArtistLastName().equals(testPainting.getArtistLastName())
                && result[0].getTitleOfWork().equals(testPainting.getTitleOfWork())
                && result[0].getDateOfWork().equals(testPainting.getDateOfWork())) return false;
        testPainting = new AuctionPainting("Earl", "Chuck", "Beauty and the Beautier",
                "1273", 23, 56, "Paint", "Me, Myself, and I",
                3.50, new SimpleDate(1999,12,31));
        HandleAuctionPaintings.createAuctionPainting(testPainting);
        result = HandleAuctionPaintings.retrieveAuctionPaintings(testPainting);
        if(result.length < 1) return false;
        if(!result[0].getArtistFirstName().equals(testPainting.getArtistFirstName())
                && result[0].getArtistLastName().equals(testPainting.getArtistLastName())
                && result[0].getTitleOfWork().equals(testPainting.getTitleOfWork())
                && result[0].getDateOfWork().equals(testPainting.getDateOfWork())) return false;
        return true;
    }
    public static boolean retrieveAuctionPaintingTest()
    {
        //Test for getting all AuctionPaintings
        AuctionPainting testPainting = new AuctionPainting();
        AuctionPainting[] result = HandleAuctionPaintings.retrieveAuctionPaintings(testPainting);
        if(result.length < 1) return false;
        //Test for getting a specific AuctionPainting
        testPainting = result[0];
        result = HandleAuctionPaintings.retrieveAuctionPaintings(testPainting);
        if(result.length < 1) return false;
        if(!result[0].getArtistFirstName().equals(testPainting.getArtistFirstName())
                && result[0].getArtistLastName().equals(testPainting.getArtistLastName())
                && result[0].getTitleOfWork().equals(testPainting.getTitleOfWork())
                && result[0].getDateOfWork().equals(testPainting.getDateOfWork())) return false;
        //Test for getting a specific InventoryPainting with some fields initialized
        testPainting = new AuctionPainting();
        testPainting.setArtistFirstName("Sam");
        testPainting.setArtistLastName("Bock");
        result = HandleAuctionPaintings.retrieveAuctionPaintings(testPainting);
        if(result.length < 1) return false;
        if(!result[0].getArtistFirstName().equals(testPainting.getArtistFirstName())
                && result[0].getArtistLastName().equals(testPainting.getArtistLastName())
                && result[0].getTitleOfWork().equals(testPainting.getTitleOfWork())) return false;
        return true;
    }
    public static boolean updateAuctionPaintingTest()
    {
        //Case for changing one field on a one field search term
        AuctionPainting searchKey = new AuctionPainting();
        searchKey.setArtistFirstName("Clint");
        searchKey.setTitleOfWork("Good Painting");
        AuctionPainting modification = new AuctionPainting();
        modification.setArtistFirstName("Clinton");
        modification.setTitleOfWork("Shitty Painting");
        HandleAuctionPaintings.updateAuctionPainting(modification, searchKey);
        AuctionPainting[] result = HandleAuctionPaintings.retrieveAuctionPaintings(modification);
        if(result.length < 1) return false;
        //Case for changing all fields on one search term
        searchKey = new AuctionPainting();
        searchKey.setTitleOfWork("TestPainting1");
        modification = new AuctionPainting("Sammichelle", "Bachman",
                "Twinkle, Twinkle", "1992", 0.1, 199.9, "Oil", "Economics",
                12, new SimpleDate(1852, 3, 17));
        HandleAuctionPaintings.updateAuctionPainting(modification, searchKey);
        result = HandleAuctionPaintings.retrieveAuctionPaintings(modification);
        if(result.length < 1) return false;
        return true;
    }
    public static boolean deleteAuctionPaintingTest()
    {
        //Case for deleting a specific painting with all fields
        AuctionPainting searchKey = new AuctionPainting("Sammichelle", "Bachman",
                "Twinkle, Twinkle", "1992", 0.1, 199.9, "Oil", "Economics",
                12, new SimpleDate(1852, 3, 17));
        HandleAuctionPaintings.deleteAuctionPainting(searchKey);
        AuctionPainting[] result = HandleAuctionPaintings.retrieveAuctionPaintings(searchKey);
        if(result.length != 0) return false;
        searchKey = new AuctionPainting();
        searchKey.setArtistFirstName("Sam");
        HandleAuctionPaintings.deleteAuctionPainting(searchKey);
        result = HandleAuctionPaintings.retrieveAuctionPaintings(searchKey);
        if(result.length != 0) return false;
        return true;
    }
}