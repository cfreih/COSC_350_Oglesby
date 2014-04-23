PurchasedPaintingReport
{
  private InventoryPainting[] paintingsBoughtInLastYear;
  private double maxAndActualRatioSum;
  public PurchasedPaintingReport()
  {
	paintingsBoughtInLastYear=getPaintingsBoughtInLastYear()
	calcMaxAndActualRatioSum()
  }
  public InventoryPainting[] getBoughtPaintings()
  {
	return getPaintingsboughtInLastYear()
  }
  public double getMaxAndActualRatio()
  {
	return maxAndActualRatioSum
  }
  private static void calcMaxAndActualRatio()
  {
	int count=0
	for(int i=0;i<paintingsboughtInLastYear
	{
		InventoryPainting painting=iter.next()
		maxAndAcutalRatioSum+=painting.getMaxPurchasePrice()/painting.getActualPurchasePrice()
		count++
	}
	maxAndAcutalRatioSum=maxAndAcutalRatioSum/count
  }
  private static InventoryPainting[] getPaintingsBoughtInLastYear()
  {
	Date d=new Date()
	d.setYear(d.getYear()+1)
	return handleInventoryRecords.retrieveInventory("SQL statement")
  }
}
