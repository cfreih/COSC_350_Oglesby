/**
 * The general painting class. Will mainly be used to be inherited 
 * by both inventory paintings and auction paintings. It will included
 * the shared traits of both classes.
 * @author Clint
 *
 */
public class Painting {
	
	private String artistFirstName
	private String artistLastName
	private String titleOfWork
	private int dateOfWOrk
	private double heightCM
	private double widthCM
	private String medium
	private String subject
	private int artistID
	
	/**
	 * Desc:  No arg constructor for a painting
	 * Post:  Painting is intialized. Strings will be blank strings,
	 * 		  double and int will be -1.0 and -1.
	 */
	public Painting()
	{
		artistFirstName = ""
		artistLastName = ""
		titleOfWork = ""
		dateOfWork = -1
		heightCM = -1.0
		widthCM = -1.0
		medium = ""
		subject = ""
		artistID = -1
	}
	
	/**
	 * Desc:  All arg constructor for painting
	 * Post:  Painting is initalized with the fields
	 * 		  being set with the proper parameters
	 */
	public Painting(String firstName, String lastName, String title, int date,
			double height, double width, String med, String subj, int id)
	{
		artistFirstName = firstName
		artistLastName = lastName
		titleOfWork = title
		dateOfWork = date
		heightCM = height
		widthCM = width
		medium = med
		subject = subj
		artistID = id
	}
	
	/**
	 * Desc:  sets the painting's artistFirstName to firstName
	 * Pre:   firstName must be less than 20 characters. If it is more,
	 * 		  the String will be trimmed to 20 characters.
	 * Post:  artistFirstName changed to firstName
	 */
	public void setArtistFirstName(String firstName)
	{
		if(firstName.length() <= 20)
		{
			artistFirstName = firstName
		}
		else
			artistFirstName = firstName.subString(0,20)
	}
	
	/**
	 * Desc:  returns the painting's artistFirstName
	 * Return:the painting's artistFirstName
	 */
	public String getArtistFirstName()
	{
		return artistFirstName
	}
	
	/**
	 * Desc:  sets the paintings artistLastName to lastName
	 * Pre:   lastName should be no more than 20 characters. If it is more,
	 * 		  the string will be trimmed to 20 characters.
	 * Post:  artistFirstName is set to lastName
	 */
	public void setArtistLastName(String lastName)
	{
		if(lastName.length() <= 20)
		{
			artistLastName = lastName
		}
		else
			artistLastName = lastName.substring(0, 20)
	}
	
	/**
	 * Desc:  returns the painting's artistLastName
	 * Return:the painting's artistLastName
	 */
	public String getArtistLastName()
	{
		return artistLastName
	}
	
	/**
	 * Desc:  sets the painting's titleOfWork to title
	 * Pre:   title should be no more than 40 characters. If it is more,
	 * 		  the string will be trimmed to 40 characters.
	 * Post:  titleOfWork is set to title
	 */
	public void setTitleOFWork(String title)
	{
		if(title.length() <= 40)
		{
			titleOfWork = title
		}
		else
			titleOfWOrk = title.substring(0, 40)
	}
	
	/**
	 * Desc:  returns the painting's titleOfWork
	 * Return:the painting's titleOfWOrk
	 */
	public String getTitleOfWork()
	{
		return titleOfWork
	}
	
	/**
	 * Desc:  sets the painting's dateOfWork to date
	 * Post:  dateOfWork is set to date
	 */
	public void setDateOFWork(int date)
	{
		dateOfWork = date
	}
	
	/**
	 * Desc:  returns the painting's dateOfWork, which is the year it
	 * 		  was painted
	 * Return:the painting's dateOfWOrk
	 */
	public int getDateOfWork()
	{
		return dateOfWork
	}
	
	/**
	 * Desc:  sets the painting's heightCM to height
	 * pre:	  height is given in centimeters
	 * Post:  heightCM is set to height
	 */
	public void setHeightCM(double height)
	{
		heightCM = height
	}
	
	/**
	 * Desc:  returns the painting's heightCM
	 * Return:the painting's heightCM
	 */
	public int getHeightCM()
	{
		return heightCM
	}
	
	/**
	 * Desc:  sets the painting's widhtCM to width
	 * pre:	  width is given in centimeters
	 * Post:  widthCM is set to width
	 */
	public void setWidthCM(double width)
	{
		widthCM = width
	}
	
	/**
	 * Desc:  returns the painting's widthCM
	 * Return:the painting's widthCM
	 */
	public int getWidthCM()
	{
		return widthCM
	}
	
	/**
	 * Desc:  sets the painting's medium to med
	 * Post:  medium is set to med
	 */
	public void setMedium(String med)
	{
		medium = med
	}
	
	/**
	 * Desc:  returns the painting's medium
	 * Return:the painting's medium
	 */
	public String getMedium()
	{
		return medium
	}
	
	/**
	 * Desc:  sets the painting's subject to subj
	 * Post:  subject is set to subj
	 */
	public void setSubject(String subj)
	{
		subject = subj
	}
	
	/**
	 * Desc:  returns the painting's subject
	 * Return:the painting's subject
	 */
	public String getSubject()
	{
		return subject
	}
	
	/**
	 * Desc:  Gets the artistID value of this object
	 * Return:The artistID is returned
	*/
	public int getArtistID()
	{
		return artistID
	}
	
	/**
	 * Desc:  returns the String representation of the painting
	 * Return:returns a string in form "artistsLastName, artistFirstName "titleOfWork""
	 */
	public String toString()
	{
		return "" + artistLastName + ", " + artistFirstName + "\"" + titleOfWork + "\""
	}
	
	/**
	 * Desc:  Determines whether this painting is equals to another.
	 * 		  Two paintings are equal if they have the same artistFirstName,
	 * 		  artistLastName, titleOfWork, and year.
	 * Return:returns a boolean stating whether two paintings are equal.
	 */
	public boolean equals(Painting p)
	{
		if(this.artistFirstName == p.artistFirstName && this.artistLastName == p.artistLastName
				&& this.titleOfWork == p.titleOfWork && this.dateOfWOrk == p.dateOfWOrk)
		{
			return true
		}
		else
			return false
	}
	
	
}
