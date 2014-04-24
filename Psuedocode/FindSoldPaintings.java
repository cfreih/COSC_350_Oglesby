public abstract class FindSoldPaintings
{
  protected InventoryPainting[] soldPaintings
  //Desc: method retrieves all of the painting sold in the last year
  //Post: the paintings sold in the last year are stored as soldPaintings
  public static void findSoldInLastYear()
  {
    Date d = new Date()
    d.setYear(d.getYear - 1)
    InventoryPainting temp = new InventoryPainting()
    temp.setDateOfSale(d)
    soldPaintings = HandleInventoryPaintings.retrieveInventoryPaintingsInLastYear(temp)
  }
}