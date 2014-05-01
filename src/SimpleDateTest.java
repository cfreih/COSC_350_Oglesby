/**
 * Class to test the SimpleDate class.
 * 
 * @author Clint
 *
 */
public class SimpleDateTest {
	
	/**
	 * Desc: Main method to test the SimpleDate class
	 */
	public static void main(String[] args)
	{
		SimpleDate d1 = new SimpleDate();
		//"-1/-1/-1"
		System.out.println(d1);
		d1.setMonth(3);
		d1.setDay(16);
		d1.setYear(2014);
		//"3-16-2014"
		System.out.println(d1.getMonth() + "-" + d1.getDay() + "-" + d1.getYear());
		SimpleDate d2 = new SimpleDate(3,15,2013);
		SimpleDate d3 = new SimpleDate(3,16,2013);
		SimpleDate d4 = new SimpleDate(3,17,2013);
		//"3/15/2013 3/16/2013 3/17/2013"
		System.out.println(d2 + " " + d3 + " " + d4);
		//false
		System.out.println(d1.withinNYears(d2, 1));
		//true
		System.out.println(d1.withinNYears(d3, 1));
		//true
		System.out.println(d3.withinNYears(d4, 1));
		//false
		System.out.println(d2.withinNYears(d1, 1));
		//true
		System.out.println(d3.withinNYears(d1, 1));
		//true
		System.out.println(d4.withinNYears(d1, 1));
	}

}
