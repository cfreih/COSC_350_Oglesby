import java.util.*;
import java.math.BigDecimal;
public abstract class HandleArtist
{
  //Desc: method creates an Artist in the database
  //Post: an artist is created in the database
  public static void createArtist(Artist artist)
  {
    String tableStatement = "artists";
    String statement = "INSERT INTO "+ tableStatement +"(";
    Pair[] pairs = loadMap(artist);
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
    String tableStatement = "artists";
    String orderBy = "lastName, firstName";
    String statement = "SELECT";
    Pair[] pairs = loadMap(new Artist());
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
      int fashionabilityConstant = (Integer)result.get(i);
      artists.add(new Artist(artistFirstName, artistLastName, fashionabilityConstant));
    }
  }
  //Desc: method to load a HashMap with values to assist in the automation of SQL statements
  // In particular, this method assists with limiting the amount of hardcoding in the stringify
  //Return: the fully loaded HashMap is returned
  private static Pair[] loadMap(Artist artist)
  {
    ArrayList<Pair> pairs = new ArrayList<Pair>();
    pairs.add(new Pair("firstName", artist.getArtistFirstName()));
    pairs.add(new Pair("lastName", artist.getArtistLastName()));
    pairs.add(new Pair("fashionability", artist.getFashionabilityCoeff()));
    return Arrays.copyOf(pairs.toArray(), pairs.toArray().length, Pair[].class);
  }
  //Desc: method converts an Artist into a String
  //Return: returns a String for the SQL statement
  private static String stringify(Artist artist)
  {
    String result = "";
    Pair[] pairs = loadMap(artist);
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
  //Desc: method updates an Artist in the database. Compares to artistID as key
  //Post: an artist is updated in the database
  public static void updateArtist(Artist modification, Artist searchKey)
  {
    String tableStatement = "artists";
    String statement = "UPDATE " + tableStatement + " SET";
    Pair[] pairs = loadMap(modification);
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
    statement += stringify(artist);
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Update();
  }
}
class HandleArtistTest extends HandleArtist
{
    //Desc: method to run unit tests for all methods
    //Output: prints the results of unit tests
    public static Pair[] runTests()
    {
        Pair[] report = new Pair[5];
        boolean result = true;
        boolean temp = createArtistTest();
        if(!temp) result = false;
        report[1] = new Pair("\tCreateArtistTest: ", temp);
        temp = retrieveArtistsTest();
        if(!temp) result = false;
        report[2] = new Pair("\tRetrieveArtistTest: ", temp);
        temp = updateArtistsTest();
        if(!temp) result = false;
        report[3] = new Pair("\tUpdateArtistTest: ", temp);
        temp = deleteArtistsTest();
        if(!temp) result = false;
        report[4] = new Pair("\tDeleteArtistTest: ", temp);
        report[0] = new Pair("", result);
        return report;
    }
    public static boolean createArtistTest()
    {
        Artist[] testArtists = {
                new Artist("Fred", "Phelps", 1),
                new Artist("Lergan", "Berlock", 999),
                new Artist("Brendel", "the Destroyer", 532)};
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
        Artist testArtist = new Artist("Clint","Freiheit",8900);
        Artist[] correctnessTest = HandleArtist.retrieveArtists(testArtist);
        if(!correctnessTest[0].getArtistFirstName().equals(testArtist.getArtistFirstName())) return false;
        if(!correctnessTest[0].getArtistLastName().equals(testArtist.getArtistLastName())) return false;
        if(correctnessTest[0].getFashionabilityCoeff() != testArtist.getFashionabilityCoeff()) return false;
        testArtist = new Artist("Claudio", "Arky", 4000);
        correctnessTest = HandleArtist.retrieveArtists(testArtist);
        if(correctnessTest.length != 0) return false;
        return true;
    }
    public static boolean updateArtistsTest()
    {
        Artist testArtist = new Artist("Sam","Bock",5522);
        createArtist(testArtist);
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
        return true;
    }
    public static boolean deleteArtistsTest()
    {
        Artist testArtist = new Artist("Tim","Burwitz", 6000);
        createArtist(testArtist);
        Artist[] correctnessTest = HandleArtist.retrieveArtists(testArtist);
        Artist temp = correctnessTest[0];
        deleteArtist(testArtist);
        correctnessTest = retrieveArtists(testArtist);
        if(correctnessTest.length != 0) return false;
        return true;
    }
}