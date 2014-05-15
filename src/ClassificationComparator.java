import java.util.Comparator;

/**
 * Created by Samuel on 5/13/2014.
 */
public class ClassificationComparator implements Comparator<InventoryPainting>
{
    private boolean purchaseReport;
    public ClassificationComparator(boolean purchaseReport)
    {
        this.purchaseReport = purchaseReport;
    }
    @Override
    public int compare(InventoryPainting o1, InventoryPainting o2)
    {
        Integer rank1 = rankClassification(o1.getClassification());
        Integer rank2 = rankClassification(o2.getClassification());
        int result = rank2.compareTo(rank1);
        if(result == 0)
        {
            if(purchaseReport)
            {
                rank1 = HandlerUtility.dateToInt(o1.getDateOfPurchase());
                rank2 = HandlerUtility.dateToInt(o2.getDateOfPurchase());
            }
            else
            {
                rank1 = HandlerUtility.dateToInt(o1.getDateOfSale());
                rank2 = HandlerUtility.dateToInt(o2.getDateOfSale());
            }
            result = rank2.compareTo(rank1);
        }
        return result;
    }
    public int rankClassification(String classification)
    {
        String[] rank = {"Other", "Masterwork", "Masterpiece"};
        for(int i = 0; i < rank.length; i++)
        {
            if(rank[i].equals(classification)) return i;
        }
        return -1;
    }
    @Override
    public boolean equals(Object object)
    {
        return true;
    }
}
