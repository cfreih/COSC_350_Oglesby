import java.util.Comparator;

/**
 * Created by Samuel on 5/13/2014.
 */
public class NameComparator implements Comparator<InventoryPainting>
{
    @Override
    public int compare(InventoryPainting o1, InventoryPainting o2)
    {
        String artistName1 = o1.getArtistLastName() + " " + o1.getArtistFirstName();
        String artistName2 = o2.getArtistLastName() + " " + o2.getArtistFirstName();
        int result = artistName1.compareTo(artistName2);
        if(result == 0)
        {
            Integer date1 = HandlerUtility.dateToInt(o1.getDateOfSale());
            Integer date2 = HandlerUtility.dateToInt(o2.getDateOfSale());
            result = date2.compareTo(date1);
        }
        return result;
    }
    public boolean equals(Object ob)
    {
        return true;
    }
}
