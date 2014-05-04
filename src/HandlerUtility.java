import java.util.*;
public abstract class HandlerUtility
{
  //Desc: method to convert a Date into an int
  //Return: returns the Date as an int
  public static int dateToInt(Date d)
  {
    int date = 0;
    date += d.getYear() * 10000;
    date += d.getMonth() * 100;
    date += d.getDay();
    return date;
  }
  //Desc: method to iterate through flags and return boolean value
  //Return: returns true if all are true, false if any are false
  public static boolean checkFlags(boolean[] flags, int count) throws ArrayIndexOutOfBoundsException
  {
    if(count > flags.length - 1 || count < 0) throw new ArrayIndexOutOfBoundsException("Out of bounds");
    for(int i = 0; i <= count; i++)
    {
      if(!flags[i]) return false;
    }
    return true;
  }
  //Desc: method to determine if a field is initialized
  //Return: returns true if uninitialized, false if initialized
  public static boolean checkInitialization(Object o)
  {
    if(o instanceof Number) return checkInitialization((Number) o);
    if(o instanceof Date) return checkInitialization((Date) o);
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
  public static boolean checkInitialization(Date d)
  {
    return d == null;
  }
  //Desc: method to load keys and values into a String
  //Return: returns a String that is loaded with the keys
  public static String loadKeysAndValues(HashMap<String,Object> objects, String[] keys)
  {
    String statement = "";
    for(int i = 0; i < keys.length; i++)
    {
      statement += " " + keys[i] + "='" + objects.get(i);
      if(i < keys.length - 1) statement += ",";
    }
    return statement;
  }
  //Desc: method to load keys into a String
  //Return: returns a String that is loaded with the keys
  public static String loadKeys(String[] keys)
  {
    String statement = "";
    for(int i = 0; i < keys.length; i++)
    {
      statement += keys[i];
      if(i < keys.length - 1) statement += ",";
    }
    return statement;
  }
  //Desc: method to load values into a String
  //Return: returns a String that is loaded with the keys
  public static String loadValues(HashMap<String,Object> objects, String[] keys)
  {
    String statement = "";
    for(int i = 0; i < keys.length; i++)
    {
      statement += "'" + objects.get(i) + "'";
      if(i < keys.length - 1) statement += ",";
    }
    return statement;
  }
}