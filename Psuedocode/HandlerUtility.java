public abstract class HandlerUtility
{
  //Desc: method to convert a Date into an int
  //Return: returns the Date as an int
  public static int dateToInt(Date d)
  {
    int date = 0
    date += d.getYear() * 10000
    date += d.getMonth() * 100
    date += d.getDay()
    return date
  }
  //Desc: method to interate through flags and return boolean value
  //Return: returns true if all are true, false if any are false
  public static boolean checkFlags(boolean[] flags, int count) throws ArrayIndexOutOfBoundsException
  {
    if(count > flags.length - 1 || count < 0) throw ArrayIndexOutOfBoundsException
    for(int i = 0; i <= count; i++)
    {
      if(!flags[i]) return false
    }
    return true
  }
}