public abstract class HandleArtist
{
  //Desc: method creates an Artist in the database
  //Post: an artist is created in the database
  public static void createArtist(Artist artist)
  {
    String statement = "INSERT INTO artists(firstName, lastName, fashionability) VALUES('" + artist.getFirstName() + 
      "','" + artist.getLastName() + "','" + artist.getFashionabilityCoeff() + "')"
    SQLConnector connection = new SQLConnector(1, statement)
    connection.executeSQLQuery()
  }
  //Desc: method searches the database and retrieves any matching records.
  // Search terms are passed in as an Artist with fields intialized if they are search terms
  //Return: returns an Artist array, with elements matching search terms
  public static Artist[] retrieveArtists(Artist artist) //if string is empty, will bring all
  {
    String statement = "SELECT firstName, lastName, fashionability FROM artists INNER"
     + " JOIN auction_paintings ON artists.artistID= auction_paintings.artistID"
    statement += " " + stringify(artist)
    statement += " ORDER BY lastName, firstName"
    SQLConnector connection = new SQLConnector(0, statement)
    Vector result = connection.executeSQLQuery()
    ArrayList<Artist> artists = new ArrayList<Artist>()
    loadResults(artists, result)
    return artists.toArray()
  }
  //Desc: method to parse results from SQL database back into Artists
  //Post: ArrayList is loaded with results from SQL database
  public static void loadResults(ArrayList<Artist> artists, Vector result)
  {
    for(int i = 0; i < result.size(); i++)
    {
      String firstName = result.get(i++)
      String lastName = result.get(i++)
      int fashionabilityConstant = Integer.parseInt(result.get(i))
      artists.add(lastName, firstName, fashionabilityConstant)
    }
  }
  //Desc: method to load a HashMap with values to assist in the automation of SQL statements
  // In particular, this method assists with limiting the amount of hardcoding in the stringify
  //Return: the fully loaded HashMap is returned
  private static HashMap<String,Object> loadMap(Artist artist)
  {
    HashMap<String,Object> objects = new HashMap<String,Object>()
    objects.put("lastName", auction.getLastName())
    objects.put("firstName", auction.getFirstName())
    objects.put("fashionability", artist.getFashionabilityCoeff())
    return objects
  }
  //Desc: method converts an Artist into a String
  //Return: returns a String for the SQL statement
  private static String stringify(Artist artist)
  {
    String result = ""
    boolean[] flags = new boolean[3]
    HashMap<String,Object> objects = loadMap(artist)
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
  //Desc: method finds and returns the PainterID of an Artist
  //Return: returns the PainterID as an int
  public static int getArtistID(Artist artist)
  {
    String statement = "SELECT artistID FROM artists "
    statement += stringify(artist)
    SQLConnector connection = new SQLConnector(0, statement)
    Vector result = connection.executeSQLQuery()
    return result.get(i)
  }
  //Desc: method updates an Artist in the database. Compares to artistID as key
  //Post: an artist is updated in the database
  public static void updateArtist(Artist artist, int artistID)
  {
    String statement = "UPDATE artists SET firstName='" + artist.getFirstName() + 
      "',lastName='" + artist.getLastName() + "',fashionability='" + artist.getFashionabilityCoeff() + 
      "' WHERE artistID = '" + artistID +"'"
    SQLConnector connection = new SQLConnector(1, statement)
    connection.executeSQLQuery()
  }
  //Desc: method deletes an Artist in the database
  //Post: an artist is deleted in the database
  public static void deleteArtist(Artist artist)
  {
    String statement = "DELETE FROM artists"
    statement += stringify(artist)
    SQLConnector connection = new SQLConnector(1, statement)
    connection.executeSQLQuery()
  }
}
 