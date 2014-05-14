import java.util.Comparator;

/**
 * Created by Samuel on 5/13/2014.
 */
public class ClassificationComparator implements Comparator<InventoryPainting>
{
    @Override
    public int compare(InventoryPainting o1, InventoryPainting o2)
    {
        int rank1 = rankClassification(o1.getClassification());
        int rank2 = rankClassification(o2.getClassification());
        if(rank1 > rank2) return -1;
        if(rank1 == rank2) return 0;
        return 1;
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
