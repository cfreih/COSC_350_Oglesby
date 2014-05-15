import java.util.*;
public abstract class HandlerUtility
{
  //Desc: method to convert a Date into an int
  //Return: returns the Date as an int
  public static int dateToInt(SimpleDate d)
  {
    int date = 0;
    date += d.getYear() * 10000;
    date += d.getMonth() * 100;
    date += d.getDay();
    return date;
  }
  //Desc: method to convert a int into an Date
  //Return: returns the int as an Date
  public static SimpleDate intToDate(int i)
  {
      int year = i / 10000;
      int month = (i - (year * 10000)) / 100;
      int day = i - (year * 10000) - (month * 100);
      return new SimpleDate(year, month, day);
  }
  //Desc: method to iterate through flags and return boolean value
  //Return: returns true if all are false, false if any are true
  public static boolean checkFlags(boolean[] flags, int count) throws ArrayIndexOutOfBoundsException
  {
    if(count > flags.length - 1 || count < 0) throw new ArrayIndexOutOfBoundsException("Out of bounds");
    for(int i = 0; i <= count; i++)
    {
      if(flags[i]) return false;
    }
    return true;
  }
  //Desc: method to determine if a field is initialized
  //Return: returns true if uninitialized, false if initialized
  public static boolean checkInitialization(Object o)
  {
    if(o instanceof Number) return checkInitialization((Number) o);
    if(o instanceof SimpleDate) return checkInitialization((SimpleDate) o);
    if(o instanceof String) return checkInitialization((String) o);
    return true;
  }
  //Desc: method to check if a Number is initialized
  //Return: returns true if uninitialized, false if initialized
  public static boolean checkInitialization(Number n)
  {
    if(n instanceof Double) return ((Double) n) < 0;
    if(n instanceof Integer) return ((Integer) n) < 0;
    return true;
  }
  //Desc: method to check if a String is initialized
  //Return: returns true if uninitialized, false if initialized
  public static boolean checkInitialization(String s)
  {
    return s == null || s.equals("");
  }
  //Desc: method to check if a Date is initialized
  //Return: returns true if uninitialized, false if initialized
  public static boolean checkInitialization(SimpleDate d)
  {
    return d.getYear() == -1;
  }
  //Desc: method to load keys and values into a String
  //Return: returns a String that is loaded with the keys
  public static String loadKeysAndValues(Pair[] pairs)
  {
    String statement = "";
    boolean comma = false;
    for(int i = 0; i < pairs.length; i++)
    {
      if(checkInitialization(pairs[i].getValue()));
      else
      {
          if(comma) statement += ",";
          statement += " " + pairs[i].getKey() + "='" + pairs[i].getValue() + "'";
          comma = true;
      }
    }
    return statement;
  }
  //Desc: method to load keys into a String
  //Return: returns a String that is loaded with the keys
  public static String loadKeys(Pair[] pairs)
  {
    String statement = " ";
    for(int i = 0; i < pairs.length; i++)
    {
      statement += pairs[i].getKey();
      if(i < pairs.length - 1) statement += ",";
    }
    return statement;
  }
  //Desc: method to load values into a String
  //Return: returns a String that is loaded with the keys
  public static String loadValues(Pair[] pairs)
  {
    String statement = "";
    for(int i = 0; i < pairs.length; i++)
    {
      statement += "'" + pairs[i].getValue() + "'";
      if(i < pairs.length - 1) statement += ",";
    }
    return statement;
  }
}