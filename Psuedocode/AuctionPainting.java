/**
 * This class extends the Painting class and implements the proper
 * fields needed for a painting in the auction database
 * @author Clint
 *
 */
public class AuctionPainting extends Painting{

	private double salePriceAuction
	private Date dateOfSaleAuction
	
	/**
	 * Desc:  no arg constructor initializing an AuctionPainting
	 * Post:  eveything is given an initial value same as with
	 * 		  Painting, date will be intialized with a no-arg constructor
	 */
	public AuctionPainting()
	{
		super()
		salePriceAuction = -1.0
		dateOfSaleAuction = new Date()
	}
	
	/**
	 * Desc:  All arg constructor for painting
	 * Post:  Painting is initalized with the fields
	 * 		  being set with the proper parameters
	 */
	public Painting(String firstName, String lastName, String title, int date, int classif,
			double height, double width, String med, String subj, double salePrice, Date date)
	{
		super(firstName, lastName, title, date, classif, height, width, med, subj)
		salePriceAuction = salePrice
		dateOfSaleAuction = date
	}
	
	/**
	 * Desc:  sets the painting's salePriceAuction to price
	 * Post:  salePriceAUction is set to price
	 */
	public void setSalePriceAuction(double price)
	{
		salePriceAuction = price
	}
	
	/**
	 * Desc:  returns the painting's salePriceAuction
	 * Return:the painting's salePriceAuction
	 */
	public double getSalePriceAuction()
	{
		return salePriceAuction
	}
	
	/**
	 * Desc:  sets the painting's dateOfSaleAuction to dateSale
	 * Post:  dateOfSaleAuction is set to dateSale
	 */
	public void setDateOfSaleAuction(Date dateSale)
	{
		dateOfSaleAuction = dateSale
	}
	
	/**
	 * Desc:  sets the painting's dateOfSaleAuction to the proper date from
	 * 		  year, month, and day
	 * Pre:   year must be between 0 and 8099
	 * 		  month must be between 1 and 12
	 * 		  day must be between 1 and 31
	 * Post:  dateOfSaleAuction is set to the date of year, month, and day
	 */
	public void setDateOfSaleAuction(int year, int month, int day)
	{
		if(year < 8099 && year > 0 && month <= 12 && month > 0 &&
				day > 0 && day < 31)
			dateOfSaleAuction = new Date(year, month-1, day)
		else
			System.out.println("year must be between 0 and 8099, month between 1 and 12 and day between 1 and 31")
	}
	
	/**
	 * Desc:  returns the painting's dateOfSaleAuction
	 * Return:the painting's dateOfSaleAuction
	 */
	public Date getDateOfSaleAuction()
	{
		return dateOfSaleAuction
	}
	
	
}
