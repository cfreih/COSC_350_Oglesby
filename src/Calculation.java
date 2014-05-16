import java.lang.String;
public abstract class Calculation
{
    //Desc: Calculates the similarity between this painting and the auction record provided.
    //Input: An auction record of a painting by the same artist.
    //Return: The similarity between the two paintings.
    private static double calcSimilarity(InventoryPainting painting, AuctionPainting record)
    {
        double similarity=0;
        double areaPainting=painting.getHeightCM()*painting.getWidthCM();
        double areaRecord=record.getHeightCM()*record.getWidthCM();
        if(painting.getMedium().toLowerCase().trim().equals(record.getMedium().toLowerCase())) similarity++;
        if(painting.getSubject().toLowerCase().trim().equals(record.getSubject().toLowerCase())) similarity++;
        if(areaPainting<areaRecord) similarity= (similarity * areaPainting)/areaRecord;
        else similarity= (similarity * areaRecord)/areaPainting;
        return similarity;
    }
    //Desc: Finds the painting that is most similary to the provided painting from an array of auction records.
    //Input: An array of auction records by the same artist.
    //Return: The auction record for the painting that is most similar to this painting.
    private static AuctionPainting findMostSimilarPainting(InventoryPainting painting, AuctionPainting[] records)
    {
        double max=0;
        AuctionPainting mostSimilar=new AuctionPainting();
        for(int i=0; i<records.length;i++)
        {
            double temp=calcSimilarity(painting, records[i]);
            System.out.println(temp);
            if(temp>max)
            {
                max=temp;
                mostSimilar=records[i];
            }
        }
        System.out.println(max);
        if((max<=0))
        	return null;
        return mostSimilar;
    }
    //Desc: Calculates the maximum price the user should pay for the painting entered.
    //Input: The painting that the user wishes to know the maxium purchase price for.
    //Return: The max price the user should pay for the painting.
    public static double calcMaxPrice(InventoryPainting painting)
    {
        AuctionPainting paintingByArtist=new AuctionPainting();
        paintingByArtist.setArtistFirstName(painting.getArtistFirstName());
        paintingByArtist.setArtistLastName(painting.getArtistLastName());
        SimpleDate date = new SimpleDate(SimpleDate.TODAY);
        if(!painting.getDateOfPurchase().equals(new SimpleDate(SimpleDate.TODAY)))
        	date = painting.getDateOfPurchase();
        AuctionPainting[] records = HandleAuctionPaintings.retrieveAuctionPaintings(paintingByArtist);      
        double price;
        if(painting.getClassification().toLowerCase().equals("masterpiece")) price=calcMaxMasterpiece(painting, records);
        else if (painting.getClassification().toLowerCase().equals("masterwork")) price=calcMaxMasterwork(painting, records);
        else price = calcMaxOther(painting, records);
        painting.setMaxPurchasePrice(price);
        return price;
    }
    //Desc: Calculates the max buy price if the painting is a masterpiece.
    //Input: The painting of interest and an array of paintings by the same artist.
    //Return: The max price the painting should be bought for.
    private static double calcMaxMasterpiece(InventoryPainting painting, AuctionPainting[] records)
    {
        AuctionPainting mostSimilar=findMostSimilarPainting(painting, records);
        if(mostSimilar==null)
        	return -10;
        double maxBuyPrice=mostSimilar.getSalePriceAuction();
        SimpleDate date = new SimpleDate(SimpleDate.TODAY);
        int yearsBetween= mostSimilar.getDateOfSaleAuction().getYear()-date.getYear();
        for(int i=0;i<=yearsBetween;i++)
        {
            maxBuyPrice=maxBuyPrice*1.085;
        }
        return maxBuyPrice;
    }
    //Desc: Calculates the max buy price if the painting is a masterwork.
    //Input: The painting of interest and an array of paintings by the same artist.
    //Return: The max price the painting should be bought for.
    private static double calcMaxMasterwork(InventoryPainting painting, AuctionPainting[] records)
    {
        double maxBuyPrice=calcMaxMasterpiece(painting,  records);
        if(maxBuyPrice<0)
        	return maxBuyPrice;
        String dateOfWork = painting.getDateOfWork();
        int date = Integer.parseInt(dateOfWork.substring(0,4));
        if(date>2000) maxBuyPrice=maxBuyPrice*0.25;       
        
        else{
        	date=date/100;
        	maxBuyPrice=maxBuyPrice*((21.00-date)/(22-date));}
        System.out.println((2100-date)/(2200-date));
        System.out.println(date);
        if(maxBuyPrice<=0) return -10;
        return maxBuyPrice;
    }
    //Desc: Calculates the max buy price if the painting is neither a masterpiece or a masterwork.
    //Input: The painting of interest and an array of paintings by the same artist.
    //Return: The max price the painting should be bought for.
    private static double calcMaxOther(InventoryPainting painting, AuctionPainting[] records)
    {
        double area=painting.getHeightCM()*painting.getWidthCM();
        Artist artist=new Artist(painting.getArtistFirstName(),painting.getArtistLastName(),-1);
        Artist[] artists=HandleArtist.retrieveArtists(artist);
       // System.out.printLn(artists[0].getFashionabilityCoeff());
        if(artists.length==0)
        	return -1;
        int fashionabilityConstant=artists[0].getFashionabilityCoeff();
        return area * fashionabilityConstant;
    }
    //Desc: ensures that the amount of money is within the allotted size
    //Return: true if it is allowed, false if not
    public static boolean isNumberValid(Number num)
    {
        long value = (long) num.doubleValue() * 100;
        if(value >= 0 && value < 999999999999l)
        {
            return true;
        }
        return false;
    }
}
