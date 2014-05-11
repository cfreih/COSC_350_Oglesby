public class UnitTestDriver
{
    public static void main(String[] args)
    {
        System.out.println("Detect Trends Report Unit Tests: ");
        //DetectTrendsReportTest.runTests();
        Pair[] result = HandleArtistTest.runTests();
        System.out.println("Handle Artist Unit Tests: " + result[0].getValue());
        for(int i = 1; i < result.length ; i++)
        {
            System.out.println(result[i].getKey() + result[i].getValue());
        }
        result = HandleInventoryPaintingsTest.runTests();
        System.out.println("Handle Inventory Paintings Unit Tests: " + result[0].getValue());
        for(int i = 1; i < result.length ; i++)
        {
            System.out.println(result[i].getKey() + result[i].getValue());
        }
    }
}