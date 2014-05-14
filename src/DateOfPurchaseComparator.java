import java.util.Comparator;

/**
 * Created by Samuel on 5/13/2014.
 */
public class DateOfPurchaseComparator implements Comparator<InventoryPainting>
{
    private boolean purchase;
    public DateOfPurchaseComparator(boolean purchase)
    {
        this.purchase = purchase;
    }
    @Override
    public int compare(InventoryPainting o1, InventoryPainting o2)
    {
        int rank1, rank2;
        if(purchase)
        {
            rank1 = HandlerUtility.dateToInt(o1.getDateOfPurchase());
            rank2 = HandlerUtility.dateToInt(o2.getDateOfPurchase());
        }
        else
        {
            rank1 = HandlerUtility.dateToInt(o1.getDateOfSale());
            rank2 = HandlerUtility.dateToInt(o2.getDateOfSale());
        }
        if(rank1 > rank2) return -1;
        if(rank1 == rank2) return 0;
        return 1;
    }
    @Override
    public boolean equals(Object object)
    {
        return true;
    }
}
