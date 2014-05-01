import java.util.*;
public class PurchasedPaintingReport
{
  private InventoryPainting[] paintingsBoughtInLastYear;
  private double maxAndActualRatio;
  
  //Desc: Creates an object of type PurchasedPaintingReport
  //Post: paintingsBoughtInLastYear initialized with the paintings purchased one year
  //   back from today. calcMaxAndActualRatio is set to the ratio of maximum purchase
  //   price to actual purchase price. (max/actual)
  public PurchasedPaintingReport()
  {
    paintingsBoughtInLastYear=getPaintingsBoughtInLastYear();
    calcMaxAndActualRatio();
  }
  
  //Desc: Get method for bought painting
  //Return: Returns array of paintings purchased in last year.
  public InventoryPainting[] getBoughtPaintings()
  {
    return paintingsBoughtInLastYear;
  }
  
  //Desc: Gets the maxAndActualRatio of this object.
  //   maxAnd ActualRatio defined to be maximum purchase price/actual purchase price
  //Return: Returns the maxAndActualRatio of this object.
  public double getMaxAndActualRatio()
  {
    return maxAndActualRatio;
  }
  
  //Desc: Calculates the ratio of maximum purchase price to actual purchase price 
  //   for all paintings bought in the last year.
  //Post: The ratio saved into maxAndaActualRatio of this object.
  private void calcMaxAndActualRatio()
  {
    int count=0;
    int total=0;
    int length=paintingsBoughtInLastYear.length;
    for(int i=0;i<length; i++)
    {
      total+=paintingsBoughtInLastYear[i].getMaxAndActualRatio();
      count++;
    }
    maxAndActualRatio=total/count;
  }
  
  //Desc: Finds all paintings that have been bought in the last year. 
  //Return: An array of InventoryPainting Objects that were bought in the last year.
  private InventoryPainting[] getPaintingsBoughtInLastYear()
  {
    Date d=new Date();
    d.setYear(d.getYear()-1);
    return HandleInventoryRecords.retrieveInventoryPaintings(d);
  }
  
}
