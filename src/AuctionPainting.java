import java.util.Date;

/**
 * This class extends the Painting class and implements the proper
 * fields needed for a painting in the auction database
 * @author Clint
 *
 */
public class AuctionPainting extends Painting{

 private double salePriceAuction;
 private Date dateOfSaleAuction;
 
 /**
  * Desc:  no arg constructor initializing an AuctionPainting
  * Post:  everything is given an initial value same as with
  *     Painting, date will be initialized with a no-arg constructor
  */
 public AuctionPainting()
 {
  super();
  salePriceAuction = -1.0;
  dateOfSaleAuction = new Date();
 }
 
 /**
  * Desc:  All arg constructor for painting
  * Post:  Painting is initialized with the fields
  *     being set with the proper parameters
  */
 public AuctionPainting(String firstName, String lastName, String title, int date,
   double height, double width, String med, String subj, int id, double salePrice, Date dateSale)
 {
  super(firstName, lastName, title, date, height, width, med, subj, id);
  salePriceAuction = salePrice;
  dateOfSaleAuction = dateSale;
 }
 
 /**
  * Desc:  sets the painting's salePriceAuction to price
  * Post:  salePriceAUction is set to price
  */
 public void setSalePriceAuction(double price)
 {
  salePriceAuction = price;
 }
 
 /**
  * Desc:  returns the painting's salePriceAuction
  * Return:the painting's salePriceAuction
  */
 public double getSalePriceAuction()
 {
  return salePriceAuction;
 }
 
 /**
  * Desc:  sets the painting's dateOfSaleAuction to dateSale
  * Post:  dateOfSaleAuction is set to dateSale
  */
 public void setDateOfSaleAuction(Date dateSale)
 {
  dateOfSaleAuction = dateSale;
 }
 
 /**
  * Desc:  sets the painting's dateOfSaleAuction to the proper date from
  *     year, month, and day
  * Pre:   year must be between 0 and 8099
  *     month must be between 1 and 12
  *     day must be between 1 and 31
  * Post:  dateOfSaleAuction is set to the date of year, month, and day
  */
 public void setDateOfSaleAuction(int year, int month, int day)
 {
  if(year < 8099 && year > 0 && month <= 12 && month > 0 &&
    day > 0 && day < 31)
   dateOfSaleAuction = new Date(year, month-1, day);
  else
   System.out.println("year must be between 0 and 8099, month between 1 and 12 and day between 1 and 31");
 }
 
 /**
  * Desc:  returns the painting's dateOfSaleAuction
  * Return:the painting's dateOfSaleAuction
  */
 public Date getDateOfSaleAuction()
 {
  return dateOfSaleAuction;
 }
 
 /**
  * Desc: Tests for AuctionPaintings.
  * Post: Results of using methods printed on the screen.
  * @param args
  */
 public static void main(String[] args)
 {
  AuctionPainting testP = new AuctionPainting();
  //Should print ", """
  System.out.println(testP);
  //Should print "-1 -1 -1.0 -1.0  -1.0 [Current Date and Time] end"
  System.out.println(testP.getArtistID() + " " + testP.getDateOfWork() + " " + 
    testP.getHeightCM() + " " + testP.getWidthCM() + " " + testP.getMedium()
    + " " + testP.getSubject() + testP.getSalePriceAuction() + " " +
    testP.getDateOfSaleAuction() +" end");
  testP = new AuctionPainting("Sammichelle", "Bachman", "Twinkle, Twinkle", 1992, 0.1, 199.9, "Oil", "Economics", -1, 12, new Date(1852,3,17));
  //Should print "Bachman, Sammichelle "Twinkle, Twinkle""
  System.out.println(testP);
  //Should print "-1 1992 0.1 199.9 Oil Economics 12.00 [Date with March 17 1852]"
  System.out.println(testP.getArtistID() + " " + testP.getDateOfWork() + " " + 
    testP.getHeightCM() + " " + testP.getWidthCM() + " " + testP.getMedium()
    + " " + testP.getSubject() + " " + testP.getSalePriceAuction() + " " +
    testP.getDateOfSaleAuction());
  testP.setArtistFirstName("Timothy");
  testP.setArtistLastName("Burrrrwalz");
  testP.setTitleOfWork("Little Star");
  testP.setDateOfWork(2014);
  testP.setHeightCM(999.9);
  testP.setWidthCM(10000.1);
  testP.setMedium("Acrylic");
  testP.setSubject("Phypsychics");
  testP.setDateOfSaleAuction(new Date(1533, 12, 31));
  //Print out date of December 31 1533
  System.out.println(testP.getDateOfSaleAuction());
  testP.setSalePriceAuction(12525);
  testP.setDateOfSaleAuction(1725, 4, 1);
  //Should print "Burrrrwalz, Timothy "Little Star""
  System.out.println(testP);
  //Should print "-1 2014 999.9 10000.1 Acrylic Phypsychics 12525 [Date of April 1 1725]"
  System.out.println(testP.getArtistID() + " " + testP.getDateOfWork() + " " + 
    testP.getHeightCM() + " " + testP.getWidthCM() + " " + testP.getMedium()
    + " " + testP.getSubject() + " " + testP.getSalePriceAuction() + " " +
    testP.getDateOfSaleAuction());
 }
}
