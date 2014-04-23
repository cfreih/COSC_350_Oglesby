public class SoldPaintingsReport extends FindSoldPaintings
{
  private double targetAndActualRatio
  //Desc: method to get the value of the targetAndActualRatioSum
  //Return: returns the targetAndActualRatioSum as a double
  public double getTargetAndActualRatio()
  {
    return targetAndActualRatio
  }
  //Desc: method to calculate the value of the targetAndActualRatioSum
  //Post: the targetAndActualRatioSum is calculated and stored
  private void calcTargetAndActualRatio()
  {
    double sum = 0
    for(int i = 0; i < soldPaintings.length; i++)
    {
      double actualSellingPrice = soldPaintings[i].actualSellingPrice
      double maxPurchasePrice = soldPaintings[i].maxPurchasePrice
      sum += actualSellingPrice / maxPurchasePrice
    }
    targetAndActualRatio = sum / soldPaintings.length
  }
}