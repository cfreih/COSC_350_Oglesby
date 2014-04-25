//Desc: Class to find that maximum purchase price for an input painting
class Calculation
{
 
 //Desc: Calculates the similarity between this painting and the auction record provided.
 //Return: The similarity between the two paintings.
 private static double calcSimilarity(InventoryPainting painting, AuctionPainting record)
 {
 double similarity=0
 double areaPainting=painting.getHeightCM()*painting.getWidthCM()
 double areaRecord=record.getHeightCM()*record.getWidthCM()
 if(painting.getMedium().toLowerCase.equals(record.getMedium().toLowerCase()) similarity++
 if(painting.getSubject().toLowerCase.equals(record.getSubject().toLowerCase()) similarity++
 if(areaPainting<areaRecord) similarity= (similarity * areaPainting)/areaRecord
 else similarity= (similarity * areaRecord)/areaPainting
 return similarity
 }
 
 //Desc: Finds the painting that is most similarity to the provided painting from an array of auction records.
 //Return: The auction record for the painting that is most similar to this painting.
 private static AuctionPainting findMostSimilarPainting(InventoryPainting painting, AuctionPainting[] records)
 {
 double max=0
 AuctionPainting mostSimilar
 for(int i=0; i<records.length;i++)
 {
  double temp=calcSimiliarity(painting, records[i])
  if(temp>max)
  {
   max=temp
   mostSimilar=record[i]
  }
 }
 return mostSimilar
 }
 
 //Desc: Calculates the maximum price the user should pay for the painting entered.
 //Return: The max price the user should pay for the painting.
 public static double calcMaxPrice(InventoryPainting painting)
 {
 AuctionPainting tempAP = new AuctionPainting()
 tempAP.setArtistFirstName(painting.getArtistFirstName())
 tempAP.setArtistLastName(painting.getArtistLastName())
 AuctionPainting[] records = HandleAuctionPaintings.retrieveAuctionPaintings(tempAP)
 double price = 0
 if(painting.getClassification().toLowerCase.equals("masterpiece") price=calcMaxMasterpiece(painting, records)
 else if (painting.getClassification().toLowerCase.equals("masterwork") price=calcMaxMasterwork(painting, records)
 else price = calcMaxOther(painting)
 return price
 }
 
 //Desc: Calculates the max buy price if the painting is a masterpiece.
 //Input: The painting of interest and an array of paintings by the same artist.
 //Return: The max price the painting should be bought for.
 private static double calcMaxMasterpiece(InventoryPainting painting, AuctionPainting[] records)
 {
 AuctionPainting mostSimilar=findMostSimilarpainting(painting, records)
 double maxBuyPrice=mostSimilar.getSalePriceAuction()
 Date currentDate= new Date()
 int yearsBetween= mostSimilar.getDateOfSaleAuction().getYear()-currentDate.getYear()
 maxBuyPrice=maxBuyPrice*1.085*yearsBetween
 return maxBuyPrice
 }
 
 //Desc: Calculates the max buy price if the painting is a masterwork.
 //Return: The max price the painting should be bought for.
 private static double calcMaxMasterwork(InventoryPainting painting, AuctionPainting[] records)
 {
 double maxBuyPrice=calcMaxMasterpiece(painting,  records)
 int dateOfWork = painting.getDateOfWork()/100
 if(dateOfWork >= 20) maxBuyPrice=maxBuyPrice*0.25
 else maxBuyPrice=maxBuyPrice*((21-dateOfWork)/(22-dateOfWork))
 return maxBuyPrice
 }
 
 //Desc: Calculates the max buy price if the painting is neither a masterpiece or a masterwork.
 //Return: The max price the painting should be bought for.
 private static double calcMaxOther(InventoryPainting painting)
 {
 double area=painting.getHeightCM()*painting.getWidthCM()
 Artist artist=new Artist(painting.getArtistFirstName(),painting.getArtistLastName(),-1)
 Artist[] artists=HandleArtist.retrieveArtist(artist)
 int fashionablityConstant=artists[0].getFashionablityCoeff()
 return area * fashionabilityConstant
 } 
}
