import java.util.Date;

/**
 * Class extending painting to fit the model of a painting in
 * then inventory database.
 * @author Clint
 *
 */
public class InventoryPainting extends Painting{
 
 private String sellerName;
 private String sellerAddress;
 private Date dateOfPurchase;
 private double maxPurchasePrice;
 private double actualPurchasePrice;
 private double maxAndActualRatio;
 private double targetSellPrice;
 private boolean soldYesOrNo;
 private Date dateOfSale;
 private String buyerName;
 private String buyerAddress;
 private double actualSellPrice;
 private double targetAndActualRatio;
 private boolean flagBoughtReport;
 private boolean flagSoldReport;
 private String classification;
 
 /**
  * Desc:  no arg constructor initializing an InventoryPainting
  * Post:  everything is given an initial value same as with
  *     Painting, date will be initialized with a no-arg constructor
  */
 public InventoryPainting()
 {
  super();
  sellerName = "";
  sellerAddress = "";
  dateOfPurchase = new Date();
  maxPurchasePrice = -1.0;
  actualPurchasePrice = -1.0;
  soldYesOrNo = false;
  dateOfSale = new Date();
  buyerName = "";
  buyerAddress = "";
  actualSellPrice = -1.0;
  
  maxAndActualRatio = -1.0;
  targetAndActualRatio = -1.0;
  flagBoughtReport = false;
  flagSoldReport = false;
  classification = "";
 }
 
 /**
  * Desc:  All arg constructor for Inventory
  * Post:  InventoryPainting is initialized with the fields
  *     being set with the proper parameters
  */
 public InventoryPainting(String firstName, String lastName, String title, int date,
   double height, double width, String med, String subj, int id, String sName, String sAddress,
   Date dateP, double maxPurch, double actualPurch, boolean soldYN, Date dateS,
   String bName, String bAddress, double actualSell, String classif)
 {
  super(firstName, lastName, title, date, height, width, med, subj, id);
  sellerName = sName;
  sellerAddress = sAddress;
  dateOfPurchase = dateP;
  maxPurchasePrice = maxPurch;
  actualPurchasePrice = actualPurch;
  soldYesOrNo = soldYN;
  dateOfSale = dateS;
  buyerName = bName;
  buyerAddress = bAddress;
  actualSellPrice = actualSell;
  classification = classif;
  
  calcMaxAndActualRatio();
  calcTargetAndActualRatio();
  calcFlagBoughtReport();
  calcFlagSoldReport();
 }
 
 /**
  * Desc:  sets the painting's sellerName to name
  * Pre:   name must be 30 or less characters long. If longer,
  *     it will be trimmed to 30 characters.
  * Post:  sellerName is set to name
  */
 public void setSellerName(String name)
 {
  sellerName = name;
     
 }

 
 /**
  * Desc:  returns the painting's sellerName
  * Return:the painting's sellerName
  */
 public String getSellerName()
 {
  return sellerName;
 }
 
 /**
  * Desc:  sets the painting's sellerAddress to address
  * Pre:   address must be 40 or less characters long. If longer,
  *     it will be trimmed to 40 characters.
  * Post:  sellerAddress is set to address
  */
 public void setSellerAddress(String address)
 {
  sellerAddress = address;
      
 }

 
 /**
  * Desc:  returns the painting's sellerAddress
  * Return:the painting's sellerAddress
  */
 public String getSellerAddress()
 {
  return sellerAddress;
 }
 
 /**
  * Desc:  sets the painting's dateOfOurchase to datePurch
  * Post:  dateOfPurchase is set to datePurch
  */
 public void setDateOfPurchase(Date datePurch)
 {
  dateOfPurchase = datePurch;
 }
 
 /**
  * Desc:  sets the painting's dateOfPurchase to the proper date from
  *     year, month, and day
  * Pre:   year must be between 0 and 8099
  *     month must be between 1 and 12
  *     day must be between 1 and 31
  * Post:  dateOfPurchase is set to the date of year, month, and day
  */
 public void setDateOfPurchase(int year, int month, int day)
 {
  if(year < 8099 && year > 0 && month <= 12 && month > 0 &&
    day > 0 && day < 31)
   dateOfPurchase = new Date(year, month-1, day);
  else
   System.out.println("year must be between 0 and 8099, month between 1 and 12 and day between 1 and 31");
 }
 
 /**
  * Desc:  returns the painting's dateOfPurchase
  * Return:the painting's dateOfPurchase
  */
 public Date getDateOfPurchase()
 {
  return dateOfPurchase;
 }
 
 /**
  * Desc:  returns the painting's maxPurchasePrice
  * Return:the painting's maxPurchasePrice
  */
 public double getMaxPurchasePrice()
 {
  return maxPurchasePrice;
 }
 
 /**
  * Desc:  sets the painting's actualPurchasePrice to price.
  *    updates the maxAndActualRatio and targetSellPrice.
  *    sets the flagBoughtReport to its proper status
  * Post:  actualPurchasePrice is set to price and maxAndActualRatio
  *     and targetSellPrice is properly adjusted
  */
 public void setActualPurchasePrice(double price)
 {
  actualPurchasePrice = price;
     calcMaxAndActualRatio();
  calcTargetSellPrice();
  calcFlagBoughtReport();
 }
 
 /**
  * Desc:  returns the painting's actualPurchasePrice
  * Return:the painting's atualPurchasePrice
  */
 public double getActualPurchasePrice()
 {
  return actualPurchasePrice;
 }
 
 /**
  * Desc:  Calculates a paintings maxAndActual Ratio by dividing
  *     maxPurchasePrice from actualPurchasePrice
  * Post:  The maxAndActualRatio is properly set
  */
 private void calcMaxAndActualRatio()
 {
  maxAndActualRatio = actualPurchasePrice / maxPurchasePrice;
 }
 
 /**
  * Desc:  returns the painting's maxAndActualRatio
  * Return:the painting's maxAndActualRatio
  */
 public double getMaxAndActualRatio()
 {
  return maxAndActualRatio;
 }
 
 /**
  * Desc:  Calculates the targetSellingPrice by multiplying
  *     actualPurcahsePirce by 2.15
  * Post:  The targetSellPrice is properly calculated and set.
  */
 private void calcTargetSellPrice()
 {
  targetSellPrice = actualPurchasePrice * 2.15;
 }
 
 /**
  * Desc:  returns the painting's targetSellPrice
  * Return:the painting's targetSellPrice
  */
 public double getTargetSellPrice()
 {
  return targetSellPrice;
 }
 
 /**
  * Desc:  sets the painting's soldYesOrNo status
  * Post:  soldYesOrNo is set to sold
  */
 public void setSoldYesOrNo(boolean sold)
 {
  soldYesOrNo = sold;
 }
 
 /**
  * Desc:  returns the painting's soldYesOrNo status
  * Return:the painting's soldYesOrNo status
  */
 public boolean getSoldYesOrNo()
 {
  return soldYesOrNo;
 }
 
 /**
  * Desc:  sets the painting's dateOfSale
  * Pre:   soldYesOrNo must be set to true to set date.
  * Post:  dateOfSale is set to date
  */
 public void setDateOfSale(Date date)
 {
  if(soldYesOrNo)
  {
   dateOfSale = date;
  }
  else
   System.out.println("Painting has not be sold. Cannot set date");
 }
 
 /**
  * Desc:  sets the painting's dateOfPurchase to the proper date from
  *     year, month, and day
  * Pre:   SoldYesOrNo must be set to true to set date
  *     year must be between 0 and 8099
  *     month must be between 1 and 12
  *     day must be between 1 and 31
  * Post:  dateOfPurchase is set to the date of year, month, and day
  */
 public void setDateOfSale(int year, int month, int day)
 {
  if(soldYesOrNo)
  {
   if(year < 8099 && year > 0 && month <= 12 && month > 0 &&
     day > 0 && day < 31)
    dateOfPurchase = new Date(year, month-1, day);
   else
    System.out.println("year must be between 0 and 8099, month between 1 and 12 and day between 1 and 31");
  }
  else
   System.out.println("Painting has not be sold. Cannot set date");
 }
 
 /**
  * Desc:  returns the painting's dateOfPurchase
  * Pre:   soldYesOrNo must be true
  * Return:the painting's dateOfPurchase
  */
 public Date getDateOfSale()
 {
  if(soldYesOrNo)
   return dateOfPurchase;
  else
  {
   System.out.println("Painting has not been sold");
   return new Date();
  }
 }
 
 /**
  * Desc:  sets the painting's buyerName to name
  * Pre:   soldYesOrNo must be set to true to set date.
  * Post:  buyerName is set to name
  */
 public void setBuyerName(String name)
 {
  if(soldYesOrNo)
  {
   buyerName = name;
  }
  else
   System.out.println("Painting has not be sold. Cannot set buyerName");
 }
 
 /**
  * Desc:  returns the painting's buyerName
  * Pre:   soldYesOrNo must be true
  * Return:the painting's buyerName
  */
 public String getBuyerName()
 {
  if(soldYesOrNo)
   return buyerName;
  else
  {
   System.out.println("Painting has not been sold.");
   return "";
  }
 }
 
 /**
  * Desc:  sets the painting's buyerAddress to address
  * Pre:   soldYesOrNo must be set to true to set date.
  * Post:  buyerAddress is set to address
  */
 public void setBuyerAddress(String address)
 {
  if(soldYesOrNo)
  {
   buyerAddress = address;
  }
  else
   System.out.println("Painting has not be sold. Cannot set buyerAddress");
 }
 
 /**
  * Desc:  returns the painting's buyerAddress
  * Pre:   soldYesOrNo must be true
  * Return:the painting's buyerAddress
  */
 public String getBuyerAddress()
 {
  if(soldYesOrNo)
   return buyerAddress;
  else
  {
   System.out.println("Painting has not been sold.");
   return "";
  }
 }
 
 /**
  * Desc:  sets the painting's ActualSellPrice to price and calculates
  *     targetAndActualRatio. Updates the flagSoldReport status
  * Pre:   soldYesOrNo must be set to true to set actualSellPrice
  * Post:  actualSellPrice is set to price and targetAndActualRatio
  *     is properly adjusted
  */
 public void setActualSellPrice(double price)
 {
  if(soldYesOrNo)
  {
   actualSellPrice = price;
   calcTargetAndActualRatio();
   calcFlagSoldReport();
  }
  else
   System.out.println("Painting has not be sold. Cannot set buyerAddress");
 }
 
 /**
  * Desc:  returns the painting's actualSellPrice
  * Pre:   soldYesOrNo must be true
  * Return:the painting's actualSellPrice
  */
 public double getActualSellPrice()
 {
  if(soldYesOrNo)
   return actualSellPrice;
  else
  {
   System.out.println("Painting has not been sold.");
   return -1;
  }  
 }
 
 /**
  * Desc:  Calculates a paintings targetAndActualRatio by dividing
  *     targetSellPrice from actualSellPrice
  * Post:  The targetAndActualRatio is properly set
  */
 private void calcTargetAndActualRatio()
 {
  targetAndActualRatio = actualPurchasePrice / targetSellPrice;
 }
 
 /**
  * Desc:  returns the painting's targetAndActualRatio
  * Return:the painting's targetAndActualRatio
  */
 public double getTargetAndActualRatio()
 {
  return targetAndActualRatio;
 }
 
 /**
  * Desc:  Calculates whether the flagBoughtReport should be set or not.
  *     It will be set for true if a painting was bought by
  *     Osbert for more than the maxPurcahsePrice
  * Post:  The flagBoughtReport is properly set
  */
 private void calcFlagBoughtReport()
 {
  if(actualPurchasePrice > maxPurchasePrice)
  {
   flagBoughtReport = true;
  }
  else
   flagBoughtReport = false;
 }
 
 /**
  * Desc:  returns the painting's flagBoughtReport status
  * Return:the painting's flagBoughtReport status
  */
 public boolean getFlagBoughtReport()
 {
  return flagBoughtReport;
 }
 
 /**
  * Desc:  Calculates whether the flagSoldReport should be set or not.
  *     It will be set for true if a painting was sold by
  *     Osbert for 5% or more less than targetSellPrice
  * Post:  The flagSoldReport is properly set
  */
 private void calcFlagSoldReport()
 {
  double fivePercentOffTarget = targetSellPrice - targetSellPrice*0.05;
  if(actualSellPrice <= fivePercentOffTarget)
  {
   flagSoldReport = true;
  }
  else
   flagSoldReport = false;
 }
 
 /**
  * Desc:  returns the painting's flagSoldReport status
  * Return:the painting's flagSoldReport status
  */
 public boolean getFlagSoldReport()
 {
  return flagSoldReport;
 }
 
 /**
  * Desc:  sets the InventoryPainting's classification to classID
  * Post:  classification is changed to classif
  */
 public void setClassification(String classif)
 {
  classification = classif;
 }
 
 /**
  * Desc:  gets the InventoryPainting's classification
  * Return:the classification of the InventoryPainting
  */
 public String getClassification()
 {
  return classification;
 }
 /*
 public static void main(String[] args)
 {
  InventoryPainting testP = new InventoryPainting();
  //Should print ", """
  System.out.println(testP);
  //Should print "-1 -1 -1.0 -1.0  end"
  System.out.println(testP.getArtistID() + " " + testP.getDateOfWork() + " " + 
    testP.getHeightCM() + " " + testP.getWidthCM() + " " + testP.getMedium()
    + " " + testP.getSubject() + "end");
  testP = new InventoryPainting("Sammichelle", "Bachman", "Twinkle, Twinkle", 1992, 24.2, 36.3,
    "Oil", "Economics", -1, "Cloud Fieldsize", "Van by the river", new Date(2010, 6, 14),
    1230000, 1000000, false, new Date(), "", "", -1, 2);
  //Should print "Bachman, Sammichelle "Twinkle, Twinkle""
  System.out.println(testP);
  //Should print "-1 1992 0.1 199.9 Oil Economics"
  System.out.println(testP.getArtistID() + " " + testP.getDateOfWork() + " " + 
    testP.getHeightCM() + " " + testP.getWidthCM() + " " + testP.getMedium()
    + " " + testP.getSubject() );
  //Should print out the following:
  //"Cloud Fieldsize Van by the river [Date June 14 2010] 1230000 1000000 0.813 2150000"
  //"false [Initalized date] -1 false true 2
  System.out.println(testP.getSellerName() + " " + testP.getSellerAddress() + " " + 
    testP.getDateOfPurchase() + " " + testP.getMaxPurchasePrice() + " " + 
    testP.getActualPurchasePrice() + " " + testP.getMaxAndActualRatio() + " " +
    testP.getTargetSellPrice());
  System.out.println( testP.getSoldYesOrNo() + " " + 
    testP.getDateOfSale() + " " + testP.getBuyerName() + " " + testP.getBuyerAddress()
    + " " + testP.getActualSellPrice() + " " + testP.getFlagBoughtReport() + " " +
    testP.getFlagSoldReport() + " " + testP.getClassification()+ " " + testP.getTargetAndActualRatio());
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
  
  testP.setSellerName("Kevin Kevin");
  testP.setSellerAddress("Under the I-22 bridge");
  testP.setDateOfPurchase(new Date(123, 9, 14));
  System.out.println(testP.getDateOfPurchase());
  testP.setDateOfPurchase(3,6,9);
  testP.setActualPurchasePrice(1500000);
  testP.setSoldYesOrNo(true);
  testP.setDateOfSale(new Date(0,1,1));
  System.out.println(testP.getDateOfSale());
  testP.setDateOfSale(2,5,1975);
  testP.setBuyerName("Ky Kopp");
  testP.setBuyerAddress("Timbuktu");
  testP.setActualSellPrice(1500000);
  testP.setClassification(1);
  //Should print out the following:
  //"Kevin Keve Under the I-22 bridge [Date March 6, 9] 1230000 6000000 1.219 3225000"
  //"true [Date January 1, 1] Ky Kopp Timbuktu 1500000 true true 1 0.465
  System.out.println(testP.getSellerName() + " " + testP.getSellerAddress() + " " + 
    testP.getDateOfPurchase() + " " + testP.getMaxPurchasePrice() + " " + 
    testP.getActualPurchasePrice() + " " + testP.getMaxAndActualRatio() + " " +
    testP.getTargetSellPrice());
  System.out.println( testP.getSoldYesOrNo() + " " + 
    testP.getDateOfSale() + " " + testP.getBuyerName() + " " + testP.getBuyerAddress()
    + " " + testP.getActualSellPrice() + " " + testP.getFlagBoughtReport() + " " +
    testP.getFlagSoldReport() + " " + testP.getClassification() + " " + testP.getTargetAndActualRatio());
  testP.setActualSellPrice(4000000);
  System.out.println(testP.getFlagSoldReport());
 }*/
 
}
