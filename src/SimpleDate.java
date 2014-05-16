import java.util.Calendar;
import java.util.Scanner;

/*
 * A class to make a simple date for the Osbert Oglesby project
 * 
 * @author Clint Freiheit
 */
public class SimpleDate {

	private int month;
	private int day;
	private int year;
	public static final int DEFAULT = 9;
	public static final int TODAY = 12;

	/*
	 * public static enum Selection { DEFAULT, TODAY }
	 */

	/**
	 * Desc: No-arg contructor for SimpleDate. Initializes all fields to -1
	 * Private because the one-arg constructor should be used.
	 */
	public SimpleDate() {
		month = -1;
		day = -1;
		year = -1;
	}

	/**
	 * Desc: One arg contructor that takes a constant, DEFAULT or TODAY DEFAULT
	 * uses the no-arg contructor to initialize the SimpleDate Object TODAY
	 * creates a SimpleDate object that is for today.
	 */
	public SimpleDate(int s) {
		if (s == TODAY) {
			Calendar c = Calendar.getInstance();
			month = c.get(Calendar.MONTH) + 1;
			day = c.get(Calendar.DAY_OF_MONTH);
			year = c.get(Calendar.YEAR);
		} else {
			month = -1;
			day = -1;
			year = -1;
		}
	}

	/**
	 * Desc: All-arg contructor for SimpleDate. Initializes month to m, day to
	 * d, and year to y. If the date is invalid, month, day, year is initialized
	 * to -1
	 */
	public SimpleDate(int y, int m, int d) {
		if (m > 12 || m < 1) {
			month = -1;
			day = -1;
			year = -1;
			return;
		}
		if (d < 1) {
			month = -1;
			day = -1;
			year = -1;
			return;
		} else if (m == 1 && d > 31) {
			month = -1;
			day = -1;
			year = -1;
			return;
		}
		// leap year
		else if (m == 2 && y % 4 == 0 && (y % 100 == 0 || y % 400 == 0)
				&& d > 29) {
			month = -1;
			day = -1;
			year = -1;
			return;
		}
		// not leap year
		else if (m == 2 && d > 28) {
			month = -1;
			day = -1;
			year = -1;
			return;
		} else if (m == 3 && d > 31) {
			month = -1;
			day = -1;
			year = -1;
			return;
		} else if (m == 4 && d > 30) {
			month = -1;
			day = -1;
			year = -1;
			return;
		} else if (m == 5 && d > 31) {
			month = -1;
			day = -1;
			year = -1;
			return;
		} else if (m == 6 && d > 30) {
			month = -1;
			day = -1;
			year = -1;
			return;
		} else if (m == 7 && d > 31) {
			month = -1;
			day = -1;
			year = -1;
			return;
		} else if (m == 8 && d > 31) {
			month = -1;
			day = -1;
			year = -1;
			return;
		} else if (m == 9 && d > 30) {
			month = -1;
			day = -1;
			year = -1;
			return;
		} else if (m == 10 && d > 31) {
			month = -1;
			day = -1;
			year = -1;
			return;
		} else if (m == 11 && d > 30) {
			month = -1;
			day = -1;
			year = -1;
			return;
		} else if (m == 12 && d > 31) {
			month = -1;
			day = -1;
			year = -1;
			return;
		} else {
			month = m;
			day = d;
			year = y;
		}
	}

	/**
	 * Desc: Sets the month to the argument Post: month is set to m
	 */
	public void setMonth(int m) {
		if (m > 12 || m < 1) {
			month = -1;
		} else
			month = m;
	}

	/**
	 * Desc: Gets the value of month Return: the value of month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Desc: Sets the day to the argument Post: day is set to d
	 */
	public void setDay(int d) {
		if (d < 1) {
			day = -1;
		} else if (month == 1 && d > 31) {
			day = -1;
		}
		// leap year
		else if (month == 2 && year % 4 == 0
				&& (year % 100 == 0 || year % 400 == 0) && d > 29) {
			day = -1;
		}
		// not leap year
		else if (month == 2 && d > 28) {
			day = -1;
		} else if (month == 3 && d > 31) {
			day = -1;
		} else if (month == 4 && d > 30) {
			day = -1;
		} else if (month == 5 && d > 31) {
			day = -1;
		} else if (month == 6 && d > 30) {
			day = -1;
		} else if (month == 7 && d > 31) {
			day = -1;
		} else if (month == 8 && d > 31) {
			day = -1;
		} else if (month == 9 && d > 30) {
			day = -1;
		} else if (month == 10 && d > 31) {
			day = -1;
		} else if (month == 11 && d > 30) {
			day = -1;
		} else if (month == 12 && d > 31) {
			day = -1;
		} else
			day = d;
	}

	/**
	 * Desc: Gets the value of day Return: the value of day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Desc: Sets the year to the argument Post: year is set to y
	 */
	public void setYear(int y) {
		year = y;
	}

	/**
	 * Desc: Gets the value of year Return: the value of year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Desc: determines if two dates are within n years of each other.
	 * 
	 * @param d
	 *            a second date to be checked whether it is within each other.
	 * @param n
	 *            how many years the dates want to be within of each other
	 * @return true if the two dates are within n years, else false.
	 */
	public boolean withinNYears(SimpleDate d, int n) {
		if (Math.abs(this.getYear() - d.getYear()) < n)
			return true;
		else if (Math.abs(this.getYear() - d.getYear()) > n)
			return false;
		else {
			// Condition for when this is the later date
			if (this.getYear() > d.getYear()) {
				if (d.getMonth() > this.getMonth())
					return true;
				else if (d.getMonth() < this.getMonth())
					return false;
				else {
					if (d.getDay() >= this.getDay())
						return true;
					else
						return false;
				}
			}
			// Condition for when d is the later date
			else {

				if (this.getMonth() > d.getMonth())
					return true;
				else if (this.getMonth() < d.getMonth())
					return false;
				else {
					if (this.getDay() >= d.getDay())
						return true;
					else
						return false;
				}
			}
		}

	}

	/*
	 * Desc: Takes a string and makes it into a parse
	 */
	public static SimpleDate parseSimpleDate(String s) {
		Scanner fDelimiter = new Scanner(s);
		fDelimiter.useDelimiter("[/-]");
		int month = fDelimiter.nextInt();
		int day = fDelimiter.nextInt();
		int year = fDelimiter.nextInt();
		return new SimpleDate(year, month, day);
	}
	
	/**
	 * Desc: Tests whether two SimpleDate Objects are equal
	 * Return: True if the two SimpleDates are the same date. False otherwise.
	 */
	public boolean equals(SimpleDate test)
	{
		if(this.day == test.getDay() && this.month == test.getMonth() && this.year == test.getYear())
			return true;
		else
			return false;
	}

	
	public static boolean is_DateTooLarge(SimpleDate maxDate, SimpleDate dateToCompare){
		int iMaxDate = maxDate.getYear()*1000+maxDate.getMonth()*100+maxDate.getDay();
		int iDateToCompare = dateToCompare.getYear()*1000+dateToCompare.getMonth()*100+dateToCompare.getDay();
		if(iMaxDate<iDateToCompare) return true;
		return false;
	}	
	
	public int compareTo(SimpleDate date)
	{
		if(this.equals(date))
			return 0;
		else if(this.getYear() > date.getYear() && this.getMonth() > date.getMonth() && this.getDay() > date.getDay())
			return 1;
		else
			return -1;
	}
	/*
	 * Desc: Returns a String in the form "month/day/year" 
	 * Returns: the string of this date in the above format
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = this.getMonth() + "/" + this.getDay() + "/"
				+ Math.abs(this.getYear());
		if (this.getYear() < 0)
			s += " B.C.E.";
		/*else
			s += " C.E.";*/ //commented out for Oglesby project
		return s;
	}
	
	/**
	 * class to throw an excpetion when a SimpleDate is given an invalid day.
	 * @author Clint
	 *
	 */
	class InvalidSimpleDateDayException extends Exception
	{
		public InvalidSimpleDateDayException()
		{
			super();
		}
	}
	
	/**
	 * class to throw an excpetion when a SimpleDate is given an invalid day.
	 * @author Clint
	 *
	 */
	class InvalidSimpleDateMonthException extends Exception
	{
		public InvalidSimpleDateMonthException()
		{
			super();
		}
	}
	
	/**
	 * class to throw an excpetion when a SimpleDate is given an invalid day.
	 * @author Clint
	 *
	 */
	class InvalidSimpleDateYearException extends Exception
	{
		public InvalidSimpleDateYearException()
		{
			super();
		}
	}

}
