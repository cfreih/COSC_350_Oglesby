public abstract class HandleArtistFashionability
{
  //Desc: method creates an Artist in the database
  //Post: an artist is created in the database
  public static void createArtist(Artist artist)
  {
    String statement = "SQL CREATE statement" //actual SQL statement will be completed in next step
    statement += artist.toString()
    SQLConnector connection = new SQLConnector(1, statement)
  }
  //Desc: method searches the database and retrieves any matching records. Search terms are passed in as a String
  //Return: returns an Artist array, with elements matching search terms
  public static Artist[] retrieveArtists(String searchTerm) //if string is empty, will bring all
  {
    String statement = "SQL GET statement" //actual SQL statement will be completed in next step
    statement += searchTerm
    SQLConnector connection = new SQLConnector(0, statement)
    String[] result = connection.getQueryResult()
    ArrayList<Artist> artists = new ArrayList<Artist>();
    for(int i = 0; i < result.length; i++)
    {
      String firstName = result[i++]
      String lastName = result[i++]
      int fashionabilityConstant = Integer.parseInt(result[i])
      artist.add(lastName, firstName, fashionabilityConstant)
    }
    return artists.toArray()
  }
  //Desc: method updates an Artist in the database
  //Post: an artist is updated in the database
  public static void updateArtist(Artist artist)
  {
    String statement = "SQL UPDATE statement" //actual SQL statement will be completed in next step
    statement += artist.toString()
    SQLConnector connection = new SQLConnector(1, statement)
  }
  //Desc: method deletes an Artist in the database
  //Post: an artist is deleted in the database
  public static void deleteArtist(Artist artist)
  {
    String statement = "SQL DELETE statement" //actual SQL statement will be completed in next step
    statement += artist.toString()
    SQLConnector connection = new SQLConnector(1, statement)
  }
}
 