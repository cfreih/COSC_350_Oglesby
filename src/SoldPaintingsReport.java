public class SoldPaintingsReport extends FindSoldPaintings
{
  private double targetAndActualRatio;
  
  //Desc: constructor for SoldPaintingsReport
  //Post: targetAndActualRatio is initialized
  public SoldPaintingsReport()
  {
    super();
    calcTargetAndActualRatio();
  }
  
  //Desc: method to get the value of the targetAndActualRatio
  //Return: returns the targetAndActualRatio as a double
  public double getTargetAndActualRatio()
  {
    return targetAndActualRatio;
  }
  
  //Desc: method to calculate the value of the targetAndActualRatio
  //Post: the targetAndActualRatio is calculated and stored
  private void calcTargetAndActualRatio()
  {
    double sum = 0;
    for(int i = 0; i < soldPaintings.length; i++)
    {
      sum += soldPaintings[i].getTargetAndActualRatio();
    }
    targetAndActualRatio = sum / soldPaintings.length;
  }
  
}