import java.util.*;
public abstract class FindSoldPaintings extends Report
{
  protected InventoryPainting[] soldPaintings;
  
  //Desc: constructor for FindSoldPaintings
  //Post: soldPaintings is initialized
  public FindSoldPaintings()
  {
    findSoldInLastYear();
  }
  //Desc: method retrieves all of the painting sold in the last year
  //Post: the paintings sold in the last year are stored as soldPaintings
  protected void findSoldInLastYear()
  {
    SimpleDate d = new SimpleDate(12);
    d.setYear(d.getYear() - 1);
    this.soldPaintings = HandleInventoryPaintings.retrieveInventoryPaintings(d, true);
  }
  //Desc: setter for soldPaintings
  //Post: soldPaintings is changed to arg
  protected void setSoldPaintings(InventoryPainting[] soldPaintings)
  {
    this.soldPaintings = soldPaintings;
  }
    public InventoryPainting[] getSoldPaintings()
    {
        return soldPaintings;
    }
}