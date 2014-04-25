//This class provides the required attributes for an Artist
//First Name
//Last Name
//Fashionability Coeffieicent 


public class Artist{
	
	private String firstName
	private String lastName
	private int fashionabilityCoeff
	private int artistID
	
	/* Desc: no arg constructor initializing an Artist
	   Post: All atributes is initialized firstName, lastName to empty string
		     fashionabilityCoeff to 0 */
	
	public Artist(){
		firstName=""
		lastName=""
		fashionabilityCoeff = -1
		artistID = -1
	}
	
	/* Desc: All arg constructor initializing an Artist
	   Pre:  Values are provied for each attribute 
	   Post: All atributes is initialized firstName, lastName to the given values
		     fashionabilityCoeff to 0 */	
	public Artist(String fName, String lName, int fCoeff, int id){
		firstName=fName
		lastName=lName
		fashionabilityCoeff = fCoeff
		artistID = id
	}	
	
	/* Desc: Returns the Artist First Name
	   Return: Artist First Name*/		
	public String getFirstName(){
		return firstName
	}
	
	/* Desc: Returns the Artist Last Name
	   Return: Artist Last Name*/		
	public String getLastName(){
		return lastName
	}
	
	/* Desc: Returns the Artist Coefficient of Fashionability
	   Return: Artist Coefficient of Fashionability*/		
	public int getFashionabilityCoeff(){
		return f1ashionabilityCoeff
	}
	
	/* Desc: Modifies the Artist First Name
	   Post: Artist First Name is modified*/	
	public void setFirstName(String fName){
		firstName=fName
	}
	/* Desc: Modifies the Artist Last Name
	   Post: Artist Last Name is modified*/	
	
	public void setLastName(String lName){
		lastName=lName
	}
	
	/* Desc: Modifies the Artist Coefficient of Fashionability
	   Post: Artist Coefficient of Fashionability is modified*/	
	public void setFashionabilityCoeff(int fCoeff){
		fashionabilityCoeff=fCoeff
	}
		
	/**
	 * Desc:  Gets the artistID value of this object
	 * Return:The artistID is returned
	 */
	public int getArtistID()
	{
		return artistID
	}
}