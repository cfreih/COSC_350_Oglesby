class Calculation
{
 private static double calcSimilarity(painting p, AuctionPainting record)
 {
	double similarity=0
	double areap=p.getHeightCM()*p.getWidthCM()
	double arearecord=record.getHeightCM()*record.getWidthCM()
	if(p.getMedium().toLowerCase.equals(record.getMedium().toLowerCase()) similarity++
	if(p.getSubject().toLowerCase.equals(record.getSubject().toLowerCase()) similarity++
	if(areap<arearecord) similarity= (similarity * areap)/arearecord
	else similarity= (similarity * arearecord)/areap
	return similarity
 }
 private static AuctionPainting findMostSimilarPainting(painting p, AuctionPainting[] records)
 {
	double max=0
	AuctionPainting mostSimilar=new AuctionPainting()
	for(int i=0; i<records.length;i++)
	{
		double temp=calcSimiliarity(p, records[i])
		if(temp>max)
		{
			max=temp
			mostSimilar=record[i]
		}
	}
	return mostSimilar
 }
 public static double calcMaxPrice(painting p)
 {
	AuctionPainting[] records = HandleInventory.retriveAuctionPainting(p.getLastName())
	double price = 0;
	if(p.getClassification().toLowerCase.equals("masterpiece") price=calcMaxMasterpiece(p, records)
	else if (p.getClassification().toLowerCase.equals("masterwork") price=calcMaxMasterwork(p, records)
	else price = calcMaxOther(p, records)
	return price
 }
 private static double calcMaxMasterpiece(AuctionPainting aucRec, AuctionPainting[] records)
 {
	AuctionPainting mostSimilar=findMostSimilarpainting(aucRec, AuctionPainting[] records)
	double maxBuyPrice=mostSimilar.getSalePriceAuction()
	Date currentDate= new Date()
	int yearsbetween= mostSimilar.getDateOfSaleAuction().getYear()-currentDate.getYear()
	for(int i=0;i<=yearsbetween;i++)
	{
		maxBuyPrice=maxBuyPrice*1.085
	}
	return maxBuyPrice
 }
 private static double calcMaxMasterwork(AuctionPainting aucRec, AuctionPainting[] records)
 {
	double maxBuyPrice=calcMaxMasterpiece(AuctionPainting aucRec, AuctionPainting[] records)
	int dateOfWork = aucRec.getDateOfWork()
	if(dateOfWork>20) maxBuyPrice=maxBuyPrice*0.25
	else maxBuyPrice=maxBuyPrice*((21-dateOfWork)/(22-dateOfWork))
	return maxBuyPrice
 }
 private static double calcMaxOther(AuctionPainting aucRec, AuctionPainting[] records)
 {
	double area=aucRec.getHeightCM()*aucRec.getWidthCM()
	Artist artist=new artist(aucRec.getArtistFirstName(),aucRec.getArtistLastName())
	int fashionablityConstant=artist.getFashionablityConstant()
	return area * fashionabilityConstant
 }
}
