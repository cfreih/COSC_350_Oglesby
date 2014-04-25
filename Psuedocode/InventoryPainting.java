/**
 * Class extending painting to fit the model of a painting in
 * then inventory database.
 * @author Clint
 *
 */
public class InventoryPainting extends Painting{
	
	private String sellerName
	private String sellerAddress
	private Date dateOfPurchase
	private double maxPurchasePrice
	private double actualPurchasePrice
	private double maxAndActualRatio
	private double targetSellPrice
	private boolean soldYesOrNo
	private Date dateOfSale
	private String buyerName
	private String buyerAddress
	private double actualSellPrice
	private double targetAndActualRatio
	private boolean flagBoughtReport
	private boolean flagSoldReport
	private int classification
	
	/**
	 * Desc:  no arg constructor initializing an InventoryPainting
	 * Post:  eveything is given an initial value same as with
	 * 		  Painting, date will be intialized with a no-arg constructor
	 */
	public AuctionPainting()
	{
		super()
		sellerName = ""
		sellerAddress = ""
		dateOfPurchase = new Date()
		maxPurcahsePrice = -1.0
		actualPurchasePrice = -1.0
		soldYesOrNo = false
		dateOfSale = new Date()
		buyerName = ""
		buyerAddress = ""
		actualSellPrice = -1.0
		
		maxAndActualRatio = -1.0
		targetAndActualRatio = -1.0
		flagBoughtReport = false
		flagSoldReport = false
	}
	
	/**
	 * Desc:  All arg constructor for Inventory
	 * Post:  InventoryPainting is initalized with the fields
	 * 		  being set with the proper parameters
	 */
	public AuctionPainting(String firstName, String lastName, String title, int date, int classif,
			double height, double width, String med, String subj, int id, String sName, String sAddress,
			Date dateP, double maxPurch, double actualPurch, boolean soldYN, Date dateS,
			string bName, String bAddress, double actualSell)
	{
		super(firstName, lastName, title, date, classif, height, width, med, subj, id)
		sellerName = sName
		sellerAddress = sAddress
		dateOfPurchase = dateP
		maxPurcahsePrice = maxPurch
		actualPurchasePrice = actualPurch
		soldYesOrNo = soldYN
		dateOfSale = dateS
		buyerName = bName
		buyerAddress = bAddress
		actualSellPrice = actualSell
		
		calcMaxAndActualRatio()
		calcTargetAndActualRatio
		calcflagBoughtReport()
		calcflagSoldReport()
	}
	
	/**
	 * Desc:  sets the painting's sellerName to name
	 * Pre:   name must be 30 or less characters long. If longer,
	 * 		  it will be trimmed to 30 characters.
	 * Post:  sellerName is set to name
	 */
	public void setSellerName(String name)
	{
		if(name.length() < 31)
		{
			sellerName = name
		}
		else
			sellerName = name.substring(0, 30)				
	}

	
	/**
	 * Desc:  returns the painting's sellerName
	 * Return:the painting's sellerName
	 */
	public String getSellerName()
	{
		return sellerName
	}
	
	/**
	 * Desc:  sets the painting's sellerAddress to address
	 * Pre:   address must be 40 or less characters long. If longer,
	 * 		  it will be trimmed to 40 characters.
	 * Post:  sellerAddress is set to address
	 */
	public void setSellerAddress(String address)
	{
		if(address.length() < 41)
		{
			sellerAddress = address
		}
		else
			sellerAddress = address.substring(0, 40)				
	}

	
	/**
	 * Desc:  returns the painting's sellerAddress
	 * Return:the painting's sellerAddress
	 */
	public String getSellerAddress()
	{
		return sellerAddress
	}
	
	/**
	 * Desc:  sets the painting's dateOfOurchase to datePurch
	 * Post:  dateOfPurchase is set to datePurch
	 */
	public void setDateOfPurchase(Date datePurch)
	{
		dateOfPurchase = datePurch
	}
	
	/**
	 * Desc:  sets the painting's dateOfPurchase to the proper date from
	 * 		  year, month, and day
	 * Pre:   year must be between 0 and 8099
	 * 		  month must be between 1 and 12
	 * 		  day must be between 1 and 31
	 * Post:  dateOfPurchase is set to the date of year, month, and day
	 */
	public void setDateOfPurchase(int year, int month, int day)
	{
		if(year < 8099 && year > 0 && month <= 12 && month > 0 &&
				day > 0 && day < 31)
			dateOfPurchase = new Date(year, month-1, day)
		else
			System.out.println("year must be between 0 and 8099, month between 1 and 12 and day between 1 and 31")
	}
	
	/**
	 * Desc:  returns the painting's dateOfPurchase
	 * Return:the painting's dateOfPurchase
	 */
	public Date getDateOfPurchase()
	{
		return dateOfPurchase
	}
	
	/**
	 * Desc:  returns the painting's maxPurchasePrice
	 * Return:the painting's maxPurchasePrice
	 */
	public double getMaxPurchasePrice()
	{
		return maxPurchasePrice
	}
	
	/**
	 * Desc:  sets the painting's actualPurchasePrice to price.
	 *		  updates the maxAndActualRatio and targetSellPrice.
	 *		  sets the flagBoughtReport to its proper status
	 * Post:  actualPurchasePrice is set to price and maxAndActualRatio
	 * 		  and targetSellPrice is properly adjusted
	 */
	public void setActualPurchasePrice(double price)
	{
		actualPurchasePrice = price
	    calcMaxAndActualRatio()
		calcTargetSellPrice()
		calcflagBoughtReport()
	}
	
	/**
	 * Desc:  returns the painting's actualPurchasePrice
	 * Return:the painting's atualPurchasePrice
	 */
	public double getActualPurchasePrice()
	{
		return actualPurchasePrice
	}
	
	/**
	 * Desc:  Calculates a paintings maxAndActual Ratio by dividing
	 * 		  maxPurchasePrice from actualPurchasePrice
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
		return maxAndActualRatio
	}
	
	/**
	 * Desc:  Calculates the targetSellingPrice by multiplying
	 * 		  actualPurcahsePirce by 2.15
	 * Post:  The targetSellPrice is properly calculated and set.
	 */
	protected void calcTargetSellPrice()
	{
		targetSellPrice = actualSellPrice * 2.15
	}
	
	/**
	 * Desc:  returns the painting's targetSellPrice
	 * Return:the painting's targetSellPrice
	 */
	public double getTargetSellPrice()
	{
		return targetSellPrice
	}
	
	/**
	 * Desc:  sets the painting's soldYesOrNo status
	 * Post:  soldYesOrNo is set to sold
	 */
	public void setSoldYesOrNo(boolean sold)
	{
		soldYesOrNo = sold
	}
	
	/**
	 * Desc:  returns the painting's soldYesOrNo status
	 * Return:the painting's soldYesOrNo status
	 */
	public boolean getSoldYesOrNo()
	{
		return soldYesOrNo
	}
	
	/**
	 * Desc:  sets the painting's dateOfSale
	 * Pre:	  soldYesOrNo must be set to true to set date.
	 * Post:  dateOfSale is set to date
	 */
	public void setDateOfSale(Date date)
	{
		if(soldYesOrNo)
		{
			dateOfSale = date
		}
		else
			System.out.println("Painting has not be sold. Cannot set date")
	}
	
	/**
	 * Desc:  sets the painting's dateOfPurchase to the proper date from
	 * 		  year, month, and day
	 * Pre:   SoldYesOrNo must be set to true to set date
	 * 		  year must be between 0 and 8099
	 * 		  month must be between 1 and 12
	 * 		  day must be between 1 and 31
	 * Post:  dateOfPurchase is set to the date of year, month, and day
	 */
	public void setDateOfPurchase(int year, int month, int day)
	{
		if(soldYesOrNo)
		{
			if(year < 8099 && year > 0 && month <= 12 && month > 0 &&
					day > 0 && day < 31)
				dateOfPurchase = new Date(year, month-1, day)
			else
				System.out.println("year must be between 0 and 8099, month between 1 and 12 and day between 1 and 31")
		}
		else
			System.out.println("Painting has not be sold. Cannot set date")
	}
	
	/**
	 * Desc:  returns the painting's dateOfPurchase
	 * Pre:   soldYesOrNo must be true
	 * Return:the painting's dateOfPurchase
	 */
	public Date getDateOfPurchase()
	{
		if(SoldYesOrNo)
			return dateOfPurchase
		else
			System.out.println("Painting has not been sold")
	}
	
	/**
	 * Desc:  sets the painting's buyerName to name
	 * Pre:	  soldYesOrNo must be set to true to set date.
	 * Post:  buyerName is set to name
	 */
	public void setBuyerName(String name)
	{
		if(soldYesOrNo)
		{
			buyerName = name
		}
		else
			System.out.println("Painting has not be sold. Cannot set buyerName")
	}
	
	/**
	 * Desc:  returns the painting's buyerName
	 * Pre:   soldYesOrNo must be true
	 * Return:the painting's buyerName
	 */
	public String getBuyerName()
	{
		if(SoldYesOrNo)
			return buyerName
		else
			System.out.println("Painting has not been sold.")
	}
	
	/**
	 * Desc:  sets the painting's buyerAddress to address
	 * Pre:	  soldYesOrNo must be set to true to set date.
	 * Post:  buyerAddress is set to address
	 */
	public void setBuyerAddress(String address)
	{
		if(soldYesOrNo)
		{
			buyerAddress = address
		}
		else
			System.out.println("Painting has not be sold. Cannot set buyerAddress")
	}
	
	/**
	 * Desc:  returns the painting's buyerAddress
	 * Pre:   soldYesOrNo must be true
	 * Return:the painting's buyerAddress
	 */
	public String getBuyerAddress()
	{
		if(SoldYesOrNo)
			return buyerAddress
		else
			System.out.println("Painting has not been sold.")
	}
	
	/**
	 * Desc:  sets the painting's ActualSellPrice to price and calculates
	 * 		  targetAndActualRatio. Updates the flagSoldReport status
	 * Pre:	  soldYesOrNo must be set to true to set actualSellPrice
	 * Post:  actualSellPrice is set to price and targetAndActualRatio
	 * 		  is properly adjusted
	 */
	public void setActualSellPrice(double price)
	{
		if(soldYesOrNo)
		{
			actualSellPrice = price
			calcTargetAndActualRatio()
			calcflagSoldReport()
		}
		else
			System.out.println("Painting has not be sold. Cannot set buyerAddress")
	}
	
	/**
	 * Desc:  returns the painting's actualSellPrice
	 * Pre:   soldYesOrNo must be true
	 * Return:the painting's actualSellPrice
	 */
	public String getActualSellPrice()
	{
		if(SoldYesOrNo)
			return actualSellPrice
		else
			System.out.println("Painting has not been sold.")
	}
	
	/**
	 * Desc:  Calculates a paintings targetAndActualRatio by dividing
	 * 		  targetSellPrice from actualSellPrice
	 * Post:  The targetAndActualRatio is properly set
	 */
	private void calcTargetAndActualRatio()
	{
		targetAndActualRatio = actualPurchasePrice / targetSellPrice
	}
	
	/**
	 * Desc:  returns the painting's targetAndActualRatio
	 * Return:the painting's targetAndActualRatio
	 */
	public double getTargetAndActualRatio()
	{
		return targetAndActualRatio
	}
	
	/**
	 * Desc:  Calculates whether the flagBoughtReport should be set or not.
	 * 		  It will be set for true if a painting was bought by
	 * 		  Osbert for more than the maxPurcahsePrice
	 * Post:  The flagBoughtReport is properly set
	 */
	private void calcflagBoughtReport()
	{
		if(actualPurchasePrice > maxPurchasePrice)
		{
			flagBoughtReport = true
		}
		else
			flagBoughtReport = false
	}
	
	/**
	 * Desc:  returns the painting's flagBoughtReport status
	 * Return:the painting's flagBoughtReport status
	 */
	public double getflagBoughtReport()
	{
		return flagBoughtReport
	}
	
	/**
	 * Desc:  Calculates whether the flagSoldReport should be set or not.
	 * 		  It will be set for true if a painting was sold by
	 * 		  Osbert for 5% or more less than targetSellPrice
	 * Post:  The flagSoldReport is properly set
	 */
	private void calcflagSoldReport()
	{
		fivePercentOffTarget = targetSellPrice - targetSellPrice*0.05
		if(actualSellPrice <= fivePercentOffTarget)
		{
			flagSoldReport = true
		}
		else
			flagSoldReport = false
	}
	
	/**
	 * Desc:  returns the painting's flagSoldReport status
	 * Return:the painting's flagSoldReport status
	 */
	public double getflagSoldReport()
	{
		return flagSoldReport
	}
	
	/**
	 * Desc:  sets the InventoryPainting's classification to classID
	 * Post:  classification is changed to classID
	 */
	public void setClassification(int classID)
	{
		classification = classID
	}
	
	/**
	 * Desc:  gets the InventoryPainting's classification
	 * Return:the classification of the InventoryPainting
	 */
	public int getClassification()
	{
		return classification
	}
	
}
