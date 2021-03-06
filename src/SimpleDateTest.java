
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
	public static void main(String[] args) {
		SimpleDate d1 = new SimpleDate(SimpleDate.DEFAULT);
		// "-1/-1/-1"
		System.out.println(d1);
		System.out.println(new SimpleDate());
		d1.setMonth(3);
		d1.setDay(16);
		d1.setYear(2014);
		// "3-16-2014"
		System.out.println(d1.getMonth() + "-" + d1.getDay() + "-"
				+ d1.getYear());
		SimpleDate d2 = new SimpleDate(2013, 3, 15);
		SimpleDate d3 = new SimpleDate(2013, 3, 16);
		SimpleDate d4 = new SimpleDate(2013, 3, 17);
		// "3/15/2013 3/16/2013 3/17/2013
		System.out.println(d2 + " " + d3 + " " + d4);
		// false
		System.out.println(d1.withinNYears(d2, 1));
		// true
		System.out.println(d1.withinNYears(d3, 1));
		// true
		System.out.println(d3.withinNYears(d4, 1));
		// false
		System.out.println(d2.withinNYears(d1, 1));
		// true
		System.out.println(d3.withinNYears(d1, 1));
		// true
		System.out.println(d4.withinNYears(d1, 1));
		// Invalid Date: Month
		SimpleDate d5 = new SimpleDate(2012, 13, 1);
		// -1/-1/-1
		System.out.println(d5);
		// Invalid Date: Day
		d5 = new SimpleDate(2012, 1, 0);
		// -1/-1/-1
		System.out.println(d5);
		// Invalid Date: Day
		d5 = new SimpleDate(2012, 1, 32);
		// -1/-1/-1
		System.out.println(d5);
		for (int i = 2; i < 13; i++) {
			// Invalid Date: Day
			d5 = new SimpleDate(2012, i, 32);
			// -1/-1/-1
			System.out.println(d5);
		}

		d1 = new SimpleDate(SimpleDate.TODAY);
		System.out.println(d1);
		
		d2 = new SimpleDate(SimpleDate.TODAY);
		System.out.println(d1.equals(d2));
		d3 = new SimpleDate(2014,5,8);
		System.out.println(d1.equals(d3));
		d4 = new SimpleDate(2014,5,7);
		System.out.println(d1.equals(d4));
		
		d5 = SimpleDate.parseSimpleDate("11/11/1111");
		System.out.println(d5);
	}

}
