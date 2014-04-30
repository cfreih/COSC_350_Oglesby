import java.util.*;
public abstract class FindSoldPaintings
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
  public void findSoldInLastYear()
  {
    Date d = new Date();
    d.setYear(d.getYear() - 1);
    this.soldPaintings = HandleInventoryPaintings.retrieveInventoryPaintings(d);
  }
  
}