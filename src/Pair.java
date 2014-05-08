/**
 * Created by Samuel on 5/7/2014.
 */
public class Pair
{
    private String key;
    private Object value;
    public Pair(String key, Object value)
    {
        this.key = key;
        this.value = value;
    }
    public String getKey()
    {
        return this.key;
    }
    public Object getValue()
    {
        return this.value;
    }
}
