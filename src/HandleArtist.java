import java.util.*;
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
    connection.executeSQL_Query();
  }
  //Desc: method searches the database and retrieves any matching records.
  // Search terms are passed in as an Artist with fields initialized if they are search terms
  //Return: returns an Artist array, with elements matching search terms
  public static Artist[] retrieveArtists(Artist artist) //if string is empty, will bring all
  {
    String tableStatement = "artists";
    String orderBy = "artistLastName, artistFirstName";
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
    return (Artist[]) artists.toArray();
  }
  //Desc: method to parse results from SQL database back into Artists
  //Post: ArrayList is loaded with results from SQL database
  public static void loadResults(ArrayList<Artist> artists, Vector result)
  {
    for(int i = 0; i < result.size(); i++)
    {
      String artistFirstName = (String)result.get(i++);
      String artistLastName = (String)result.get(i++);
      int fashionabilityConstant = Integer.parseInt((String)result.get(i++));
      int artistID = Integer.parseInt((String)result.get(i));
      artists.add(new Artist(artistLastName, artistFirstName, fashionabilityConstant, artistID));
    }
  }
  //Desc: method to load a HashMap with values to assist in the automation of SQL statements
  // In particular, this method assists with limiting the amount of hardcoding in the stringify
  //Return: the fully loaded HashMap is returned
  private static Pair[] loadMap(Artist artist)
  {
    ArrayList<Pair> pairs = new ArrayList<Pair>();
    pairs.add(new Pair("artistLastName", artist.getArtistLastName()));
    pairs.add(new Pair("artistFirstName", artist.getArtistFirstName()));
    pairs.add(new Pair("fashionability", artist.getFashionabilityCoeff()));
    pairs.add(new Pair("artistID", artist.getArtistID()));
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
      if(HandlerUtility.checkInitialization(pairs[i].getValue())) flags[i] = true;
      else
      {
          if(HandlerUtility.checkFlags(flags, i)) result += " WHERE " + pairs[i].getKey() + "='" + pairs[i].getValue() + "'";
          else result += " AND " + pairs[i].getKey() + "='" + pairs[i].getValue() + "'";
      }
    }
    return result;
  }
  //Desc: method updates an Artist in the database. Compares to artistID as key
  //Post: an artist is updated in the database
  public static void updateArtist(Artist artist, Artist searchKey)
  {
    String tableStatement = "artists";
    String statement = "UPDATE " + tableStatement + " SET";
    Pair[] pairs = loadMap(artist);
    statement += HandlerUtility.loadKeysAndValues(pairs);
    statement += stringify(searchKey);
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Query();
  }
  //Desc: method deletes an Artist in the database
  //Post: an artist is deleted in the database
  public static void deleteArtist(Artist artist)
  {
    String tableStatement = "artists";
    String statement = "DELETE FROM " + tableStatement;
    statement += stringify(artist);
    SQLConnector connection = new SQLConnector(statement);
    connection.executeSQL_Query();
  }
}
 