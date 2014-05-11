/**
 * The general painting class. Will mainly be used to be inherited 
 * by both inventory paintings and auction paintings. It will included
 * the shared traits of both classes.
 * @author Clint
 *
 */
public class Painting implements Cloneable {
	
	private String artistFirstName;
	private String artistLastName;
	private String titleOfWork;
	private int dateOfWork;
	private double heightCM;
	private double widthCM;
	private String medium;
	private String subject;
	//private int artistID;
	
	/**
	 * Desc:  No arg constructor for a painting
	 * Post:  Painting is initialized. Strings will be blank strings,
	 * 		  double and int will be -1.0 and -1.
	 */
	public Painting()
	{
		artistFirstName = "";
		artistLastName = "";
		titleOfWork = "";
		dateOfWork = -1;
		heightCM = -1.0;
		widthCM = -1.0;
		medium = "";
		subject = "";
		//artistID = -1;
	}
	
	/**
	 * Desc:  All arg constructor for painting
	 * Post:  Painting is initialized with the fields
	 * 		  being set with the proper parameters
	 */
	public Painting(String firstName, String lastName, String title, int date,
			double height, double width, String med, String subj)
	{
		artistFirstName = firstName;
		artistLastName = lastName;
		titleOfWork = title;
		dateOfWork = date;
		heightCM = height;
		widthCM = width;
		medium = med;
		subject = subj;
		//artistID = id;
	}
	
	/**
	 * Desc:  sets the painting's artistFirstName to firstName
	 * Pre:   firstName must be less than 20 characters. If it is more,
	 * 		  the String will be trimmed to 20 characters.
	 * Post:  artistFirstName changed to firstName
	 */
	public void setArtistFirstName(String firstName)
	{
		artistFirstName = firstName;
	}
	
	/**
	 * Desc:  returns the painting's artistFirstName
	 * Return:the painting's artistFirstName
	 */
	public String getArtistFirstName()
	{
		return artistFirstName;
	}
	
	/**
	 * Desc:  sets the paintings artistLastName to lastName
	 * Pre:   lastName should be no more than 20 characters. If it is more,
	 * 		  the string will be trimmed to 20 characters.
	 * Post:  artistFirstName is set to lastName
	 */
	public void setArtistLastName(String lastName)
	{
		artistLastName = lastName;
		
	}
	
	/**
	 * Desc:  returns the painting's artistLastName
	 * Return:the painting's artistLastName
	 */
	public String getArtistLastName()
	{
		return artistLastName;
	}
	
	/**
	 * Desc:  sets the painting's titleOfWork to title
	 * Pre:   title should be no more than 40 characters. If it is more,
	 * 		  the string will be trimmed to 40 characters.
	 * Post:  titleOfWork is set to title
	 */
	public void setTitleOfWork(String title)
	{
		titleOfWork = title;
		
	}
	
	/**
	 * Desc:  returns the painting's titleOfWork
	 * Return:the painting's titleOfWOrk
	 */
	public String getTitleOfWork()
	{
		return titleOfWork;
	}
	
	/**
	 * Desc:  sets the painting's dateOfWork to date
	 * Post:  dateOfWork is set to date
	 */
	public void setDateOfWork(int date)
	{
		dateOfWork = date;
	}
	
	/**
	 * Desc:  returns the painting's dateOfWork, which is the year it
	 * 		  was painted
	 * Return:the painting's dateOfWOrk
	 */
	public int getDateOfWork()
	{
		return dateOfWork;
	}
	
	/**
	 * Desc:  sets the painting's heightCM to height
	 * pre:	  height is given in centimetres
	 * Post:  heightCM is set to height
	 */
	public void setHeightCM(double height)
	{
		heightCM = height;
	}
	
	/**
	 * Desc:  returns the painting's heightCM
	 * Return:the painting's heightCM
	 */
	public double getHeightCM()
	{
		return heightCM;
	}
	
	/**
	 * Desc:  sets the painting's widhtCM to width
	 * pre:	  width is given in centimetres
	 * Post:  widthCM is set to width
	 */
	public void setWidthCM(double width)
	{
		widthCM = width;
	}
	
	/**
	 * Desc:  returns the painting's widthCM
	 * Return:the painting's widthCM
	 */
	public double getWidthCM()
	{
		return widthCM;
	}
	
	/**
	 * Desc:  sets the painting's medium to med
	 * Post:  medium is set to med
	 */
	public void setMedium(String med)
	{
		medium = med;
	}
	
	/**
	 * Desc:  returns the painting's medium
	 * Return:the painting's medium
	 */
	public String getMedium()
	{
		return medium;
	}
	
	/**
	 * Desc:  sets the painting's subject to subj
	 * Post:  subject is set to subj
	 */
	public void setSubject(String subj)
	{
		subject = subj;
	}
	
	/**
	 * Desc:  returns the painting's subject
	 * Return:the painting's subject
	 */
	public String getSubject()
	{
		return subject;
	}
	
	/**
	 * Desc:  returns the String representation of the painting
	 * Return:returns a string in form "artistsLastName, artistFirstName "titleOfWork""
	 */
	public String toString()
	{
		return "" + artistLastName + ", " + artistFirstName + " \"" + titleOfWork + "\"";
	}
	
	/**
	 * Desc:  Determines whether this painting is equals to another.
	 * 		  Two paintings are equal if they have the same artistFirstName,
	 * 		  artistLastName, titleOfWork, and year.
	 * Return:returns a boolean stating whether two paintings are equal.
	 */
	public boolean equals(Object o)
	{
        Painting p = (Painting) o;
		if(this.artistFirstName == p.artistFirstName && this.artistLastName == p.artistLastName
				&& this.titleOfWork == p.titleOfWork && this.dateOfWork == p.dateOfWork)
		{
			return true;
		}
		else
			return false;
	}
	/**
	 * Desc: Creats a clone of this Painting
	 * Return: the deep copy of this Painting
	 * @throws CloneNotSupportedException 
	 */
	public Painting clone() throws CloneNotSupportedException
	{
		return (Painting) super.clone();
		
	}

	
	/**
	 * Desc: Tests the various methods and constructors for a Painting
	 * Post: Tests are printed to the screen to verify methods are working.
	 * @param args
	 * @throws CloneNotSupportedException 
	 *
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Painting testP = new Painting();
		//Should print ", """
		System.out.println(testP);
		//Should print "-1 -1 -1.0 -1.0  end"
		System.out.println(testP.getArtistID() + " " + testP.getDateOfWork() + " " + 
				testP.getHeightCM() + " " + testP.getWidthCM() + " " + testP.getMedium()
				+ " " + testP.getSubject() + "end");
		testP = new Painting("Sammichelle", "Bachman", "Twinkle, Twinkle", 1992, 0.1, 199.9, "Oil", "Economics", -1);
		//Should print "Bachman, Sammichelle "Twinkle, Twinkle""
		System.out.println(testP);
		//Should print "-1 1992 0.1 199.9 Oil Economics"
		System.out.println(testP.getArtistID() + " " + testP.getDateOfWork() + " " + 
				testP.getHeightCM() + " " + testP.getWidthCM() + " " + testP.getMedium()
				+ " " + testP.getSubject() );
		testP.setArtistFirstName("Timothy");
		testP.setArtistLastName("Burrrrwalz");
		testP.setTitleOfWork("Little Star");
		testP.setDateOfWork(2014);
		testP.setHeightCM(999.9);
		testP.setWidthCM(10000.1);
		testP.setMedium("Acrylic");
		testP.setSubject("Phypsychics");
		//Should print "Burrrrwalz, Timothy "Little Star""
		System.out.println(testP);
		//Should print "-1 2014 999.9 10000.1 Acrylic Phypsychics"
		System.out.println(testP.getArtistID() + " " + testP.getDateOfWork() + " " + 
				testP.getHeightCM() + " " + testP.getWidthCM() + " " + testP.getMedium()
				+ " " + testP.getSubject() );	
		
		Painting cloneP = testP.clone();
		testP.setArtistFirstName("Mace");
		testP.setArtistLastName("Windu");
		System.out.println(testP);
		System.out.println(cloneP);
	}*/
	
	
}
