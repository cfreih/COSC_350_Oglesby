public abstract class FindSoldPaintings
{
  protected InventoryRecord[] soldPaintings
  public static void findSoldInLastYear()
  {
    Date d = new Date()
    d.setYear(d.getYear - 1)
    soldPaintings = HandleInventoryRecords.retrieveInventoryRecords("DATE " + d.toString())
  }
}