import java.text.DecimalFormat;

/**
 * Created by Samuel on 5/13/2014.
 */
public class MoneyFormat extends DecimalFormat
{
    public MoneyFormat()
    {
        super("$#,###,###,##0.00");
        this.setMinimumFractionDigits(2);
        this.setMaximumFractionDigits(2);
        this.setMinimumIntegerDigits(1);
    }
}
