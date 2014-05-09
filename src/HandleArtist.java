import java.util.*;
import java.math.BigDecimal;
public abstract class HandleArtist
{
  //Desc: method creates an Artist in the database
  //Post: an artist is created in the database
  public static void createArtist(Artist artist)
  {
    boolean isQuery = false;
    String tableStatement = "artists";
    String statement = "INSERT INTO "+ tableStatement +"(";
    Pair[] pairs = loadMap(artist, isQuery);
    statement += HandlerUtility.loadKeys(pairs);
    statement += ") VALUES(";
    statement += HandlerUtility.loadValues(pairs);
    statement += ")";
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Update();
  }
  //Desc: method searches the database and retrieves any matching records.
  // Search terms are passed in as an Artist with fields initialized if they are search terms
  //Return: returns an Artist array, with elements matching search terms
  public static Artist[] retrieveArtists(Artist artist) //if string is empty, will bring all
  {
    boolean isQuery = true;
    String tableStatement = "artists";
    String orderBy = "lastName, firstName";
    String statement = "SELECT";
    Pair[] pairs = loadMap(new Artist(), isQuery);
    statement += HandlerUtility.loadKeys(pairs);
    statement += " FROM " + tableStatement;
    statement += stringify(artist);
    statement += " ORDER BY " + orderBy;
    SQLConnector connection = new SQLConnector(statement);
    Vector result = connection.executeSQL_Query();
    ArrayList<Artist> artists = new ArrayList<Artist>();
    loadResults(artists, result);
    return Arrays.copyOf(artists.toArray(), artists.toArray().length, Artist[].class);
  }
  //Desc: method to parse results from SQL database back into Artists
  //Post: ArrayList is loaded with results from SQL database
  public static void loadResults(ArrayList<Artist> artists, Vector result)
  {
    for(int i = 0; i < result.size(); i++)
    {
      String artistFirstName = (String)result.get(i++);
      String artistLastName = (String)result.get(i++);
      int fashionabilityConstant = (Integer)result.get(i++);
      int artistID = (Integer)result.get(i);
      artists.add(new Artist(artistFirstName, artistLastName, fashionabilityConstant, artistID));
    }
  }
  //Desc: method to load a HashMap with values to assist in the automation of SQL statements
  // In particular, this method assists with limiting the amount of hardcoding in the stringify
  //Return: the fully loaded HashMap is returned
  private static Pair[] loadMap(Artist artist, boolean isQuery)
  {
    ArrayList<Pair> pairs = new ArrayList<Pair>();
    pairs.add(new Pair("firstName", artist.getArtistFirstName()));
    pairs.add(new Pair("lastName", artist.getArtistLastName()));
    pairs.add(new Pair("fashionability", artist.getFashionabilityCoeff()));
    if(isQuery) pairs.add(new Pair("artistID", artist.getArtistID()));
    return Arrays.copyOf(pairs.toArray(), pairs.toArray().length, Pair[].class);
  }
  //Desc: method converts an Artist into a String
  //Return: returns a String for the SQL statement
  private static String stringify(Artist artist)
  {
    boolean isQuery = true;
    String result = "";
    Pair[] pairs = loadMap(artist,isQuery);
    boolean[] flags = new boolean[pairs.length];
    for(int i = 0; i < pairs.length; i++)
    {
      if(HandlerUtility.checkInitialization(pairs[i].getValue())) flags[i] = true;
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
  //Desc: method updates an Artist in the database. Compares to artistID as key
  //Post: an artist is updated in the database
  public static void updateArtist(Artist artist, Artist searchKey)
  {
    boolean isQuery = false;
    String tableStatement = "artists";
    String statement = "UPDATE " + tableStatement + " SET";
    Pair[] pairs = loadMap(artist, isQuery);
    statement += HandlerUtility.loadKeysAndValues(pairs);
    statement += stringify(searchKey);
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Update();
  }
  //Desc: method deletes an Artist in the database
  //Post: an artist is deleted in the database
  public static void deleteArtist(Artist artist)
  {
    String tableStatement = "artists";
    String statement = "DELETE FROM " + tableStatement;
    statement += stringify(artist) + " LIMIT 1";
    System.out.println(statement);
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Update();
  }
}
class HandleArtistTest extends HandleArtist
{
    //Desc: method to run unit tests for all methods
    //Output: prints the results of unit tests
    public static void runTests()
    {
        System.out.println("\tCreateArtistTest: " + createArtistTest());
        System.out.println("\tRetrieveArtistTest: " + retrieveArtistsTest());
        System.out.println("\tUpdateArtistTest: " + updateArtistsTest());
        System.out.println("\tDeleteArtistTest: " + deleteArtistsTest());
    }
    public static boolean createArtistTest()
    {
        Artist[] testArtists = {
                new Artist("Fred", "Phelps", 1, -1),
                new Artist("Lergan", "Berlock", 999, -1),
                new Artist("Brendel", "the Destroyer", 532, -1)};
        for(int i = 0; i < testArtists.length; i++)
        {
            HandleArtist.createArtist(testArtists[i]);
        }
        //Three artists created
        Artist[] correctnessTest = new Artist[testArtists.length];
        for(int i = 0; i < correctnessTest.length; i++)
        {
            correctnessTest[i] = HandleArtist.retrieveArtists(testArtists[i])[0];
            if(!correctnessTest[i].getArtistFirstName().equals(testArtists[i].getArtistFirstName())) return false;
            if(!correctnessTest[i].getArtistLastName().equals(testArtists[i].getArtistLastName())) return false;
            if(correctnessTest[i].getFashionabilityCoeff() != testArtists[i].getFashionabilityCoeff()) return false;
        }
        return true;
    }
    public static boolean retrieveArtistsTest()
    {
        Artist testArtist = new Artist("Clint","Freiheit",8900, -1);
        Artist[] correctnessTest = HandleArtist.retrieveArtists(testArtist);
        if(!correctnessTest[0].getArtistFirstName().equals(testArtist.getArtistFirstName())) return false;
        if(!correctnessTest[0].getArtistLastName().equals(testArtist.getArtistLastName())) return false;
        if(correctnessTest[0].getFashionabilityCoeff() != testArtist.getFashionabilityCoeff()) return false;
        testArtist = new Artist("Claudio", "Arky", 4000, -1);
        correctnessTest = HandleArtist.retrieveArtists(testArtist);
        if(correctnessTest.length != 0) return false;
        return true;
    }
    public static boolean updateArtistsTest()
    {
        Artist testArtist = new Artist("Sam","Bock",5522, -1);
        Artist[] correctnessTest = HandleArtist.retrieveArtists(testArtist);
        if(!correctnessTest[0].getArtistFirstName().equals(testArtist.getArtistFirstName())) return false;
        if(!correctnessTest[0].getArtistLastName().equals(testArtist.getArtistLastName())) return false;
        if(correctnessTest[0].getFashionabilityCoeff() != testArtist.getFashionabilityCoeff()) return false;
        testArtist.setArtistFirstName("Samuel");
        updateArtist(testArtist, correctnessTest[0]);
        correctnessTest = HandleArtist.retrieveArtists(testArtist);
        if(!correctnessTest[0].getArtistFirstName().equals(testArtist.getArtistFirstName())) return false;
        if(!correctnessTest[0].getArtistLastName().equals(testArtist.getArtistLastName())) return false;
        if(correctnessTest[0].getFashionabilityCoeff() != testArtist.getFashionabilityCoeff()) return false;
        testArtist.setArtistFirstName("Sam");
        updateArtist(testArtist, correctnessTest[0]);
        correctnessTest = HandleArtist.retrieveArtists(testArtist);
        if(!correctnessTest[0].getArtistFirstName().equals(testArtist.getArtistFirstName())) return false;
        if(!correctnessTest[0].getArtistLastName().equals(testArtist.getArtistLastName())) return false;
        if(correctnessTest[0].getFashionabilityCoeff() != testArtist.getFashionabilityCoeff()) return false;
        return true;
    }
    public static boolean deleteArtistsTest()
    {
        Artist testArtist = new Artist("Tim","Burwitz", 6000, -1);
        Artist[] correctnessTest = HandleArtist.retrieveArtists(testArtist);
        Artist temp = correctnessTest[0];
        deleteArtist(testArtist);
        correctnessTest = retrieveArtists(testArtist);
        if(correctnessTest.length != 0) return false;
        createArtist(new Artist("Tim", "Burwitz", 6000, -1));
        return true;
    }
}