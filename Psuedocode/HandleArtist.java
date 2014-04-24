public abstract class HandleArtist
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
  public static Artist[] retrieveArtists(Artist artist) //if string is empty, will bring all
  {
    String statement = "SELECT firstName, lastName, fashionability FROM painters INNER"
     + " JOIN auction_paintings ON painters.painterID= auction_paintings.painterID"
    statement += " " + stringify(artist)
    statement += " ORDER BY lastName, firstName"
    SQLConnector connection = new SQLConnector(0, statement)
    Vector result = connector.executeSQLQuery()
    ArrayList<Artist> artists = new ArrayList<Artist>()
    for(int i = 0; i < result.size(); i++)
    {
      String firstName = result.get(i++)
      String lastName = result.get(i++)
      int fashionabilityConstant = Integer.parseInt(result.get(i))
      artists.add(lastName, firstName, fashionabilityConstant)
    }
    return artists.toArray()
  }
  //Desc: method converts an Artist into a String
  //Return: returns a String for the SQL statement
  private static String stringify(Artist artist)
  {
    String result = ""
    boolean[] flags = new boolean[3]
    String lastName = artist.lastName
    String firstName = artist.firstName
    int fashionability = artist.fashionabilityConstant
    if(lastName == null || lastName.equals("")) flags[0] = true
    else result += "WHERE lastName ='" + lastName + "'"
    if(firstName == null || firstName.equals("")) flags[1] = true
    else
    {
      if(flags[0]) result += "WHERE firstName ='" + firstName + "'"
      else result += "AND firstName ='" + firstName + "'"
    }
    if(fashionability == -1) flags[2] = true
    else
    {
      if(flags[0] && flags[1]) result += "WHERE fashionability ='" + fashionability + "'"
      else result += "AND fashionability ='" + fashionability + "'"
    }
    return result
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
 