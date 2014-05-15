//This class provides the required attributes for an Artist
//First Name
//Last Name
//Fashionability Coefficient 


public class Artist implements Cloneable{
	
	private String artistFirstName;
	private String artistLastName;
	private int fashionabilityCoeff;
	
	/* Desc: no arg constructor initializing an Artist
	   Post: All attributes is initialized firstName, lastName to empty string
		     fashionabilityCoeff to -1 */	
	public Artist(){
		artistFirstName="";
		artistLastName="";
		fashionabilityCoeff = -1;
	}
	
	/* Desc: All arg constructor initializing an Artist
	   Pre:  Values are provided for each attribute 
	   Post: All attributes is initialized firstName, lastName to the given values
		     fashionabilityCoeff to -1 */	
	public Artist(String fName, String lName, int fCoeff){
		artistFirstName=fName;
		artistLastName=lName;
		fashionabilityCoeff = fCoeff;
	}	
	
	/* Desc: Returns the Artist First Name
	   Return: Artist First Name*/		
	public String getArtistFirstName(){
		return artistFirstName;
	}
	
	/* Desc: Returns the Artist Last Name
	   Return: Artist Last Name*/		
	public String getArtistLastName(){
		return artistLastName;
	}
	
	/* Desc: Returns the Artist Coefficient of Fashionability
	   Return: Artist Coefficient of Fashionability*/		
	public int getFashionabilityCoeff(){
		return fashionabilityCoeff;
	}
	
	/* Desc: Modifies the Artist First Name
	   Post: Artist First Name is modified*/	
	public void setArtistFirstName(String fName){
		artistFirstName=fName;
	}
	/* Desc: Modifies the Artist Last Name
	   Post: Artist Last Name is modified*/	
	
	public void setArtistLastName(String lName){
		artistLastName=lName;
	}
	
	/* Desc: Modifies the Artist Coefficient of Fashionability
	   Post: Artist Coefficient of Fashionability is modified*/	
	public void setFashionabilityCoeff(int fCoeff){
		fashionabilityCoeff=fCoeff;
	}
	
	/**
	 * Desc: Compares two Artists and says if they are equal or not.
	 * Return: True if artistFirstName and artistLastName of the two 
	 * 		   Artists are equal, false otherwise.
	 */
	public boolean equals(Artist artist)
	{
		String thisFName = this.getArtistFirstName().toLowerCase();
		String thisLName = this.getArtistLastName().toLowerCase();
		String artistFName = artist.getArtistFirstName().toLowerCase();
		String artistLName = artist.getArtistLastName().toLowerCase();
		if(thisFName.equals(artistFName) && thisLName.equals(artistLName))
			return true;
		else
			return false;
	}

	
	/*
	 * Desc: the toString() method for an artist.
	 * 		 returns a String in the format "artistLastName, artistFirstName; Fashionability: fashionabilityCoeff"
	 * Return: returns a String in the format in the description.
	 */
	public String toString()
	{
		return artistLastName + ", " + artistFirstName + "; Fashionability: " + fashionabilityCoeff;
	}
	
	/**
	 * Desc: Clones this' properties to a different object
	 * Return: The newly cloned Object
	 */
	@Override
	protected Artist clone() throws CloneNotSupportedException
	{
		return (Artist) super.clone();
	}
	public Object[] toTableRow(){
		Object[] rowData = { getArtistLastName(), getArtistFirstName(), getFashionabilityCoeff()};
		return rowData;
		
	}
	
	/**
	 * Desc: The tests for all the methods and constructors.
	 * Post: The tests printed onto the screen to verify the methods are working.
	public static void main(String[] args)
	{
		Artist testArtist1 = new Artist();
		//Should print ", ; Fashionability: -1 -1"
		System.out.println(testArtist1 + " " + testArtist1.getArtistID());
		testArtist1.setArtistFirstName("Fred");
		testArtist1.setArtistLastName("Phelps");
		testArtist1.setFashionabilityCoeff(1);
		//Should print "Phelps, Fred; Fashionability: 1 -1"
		System.out.println(testArtist1 + " " + testArtist1.getArtistID());
		Artist testArtist2 = new Artist("Lergan", "Berlock", 999, -1);
		//Should print "Berlock, Lergan; Fashionability: 999 -1"
		System.out.println(testArtist2 + " " + testArtist2.getArtistID());
		testArtist2.setArtistFirstName("Brendel");
		testArtist2.setArtistLastName("the Destroyer");
		testArtist2.setFashionabilityCoeff(532);
		System.out.println(testArtist2 + " " + testArtist2.getArtistID());
	}*/
}