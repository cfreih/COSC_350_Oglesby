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
    if(count > flags.length - 1 || count < 0) throw ArrayIndexOutOfBoundsException;
    for(int i = 0; i <= count; i++)
    {
      if(!flags[i]) return false;
    }
    return true;
  }
  //Desc: method to check if a Number is initialized
  //Return: returns true if uninitialized, false if initialized
  public static boolean checkInitialization(Number n)
  {
    if(n < 0) return true;
    return false;
  }
  //Desc: method to check if a String is initialized
  //Return: returns true if uninitialized, false if initialized
  public static boolean checkInitialization(String s)
  {
    if(s == null || s.equals("")) return true;
    return false;
  }
  //Desc: method to check if a Date is initialized
  //Return: returns true if uninitialized, false if initialized
  public static boolean checkInitialization(Date d)
  {
    if(d == null) return true;
    return false;
  }
}