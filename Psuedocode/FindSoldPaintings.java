public abstract class FindSoldPaintings
{
  protected InventoryRecord[] soldPaintings
  //Desc: method retrieves all of the painting sold in the last year
  //Post: the paintings sold in the last year are stored as soldPaintings
  public static void findSoldInLastYear()
  {
    Date d = new Date()
    d.setYear(d.getYear - 1)
    soldPaintings = HandleInventoryRecords.retrieveInventoryRecords("DATE " + d.toString())
  }
}