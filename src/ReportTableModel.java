import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by Samuel on 5/13/2014.
 */
public class ReportTableModel extends AbstractTableModel
{
    private int rows;
    private int columns;
    private ArrayList<String[]> data;
    private String[] columnHeaders;
    public ReportTableModel(int rows, int columns, ArrayList<String[]> data, String[] columnHeaders)
    {
        this.rows = rows;
        this.columns = columns;
        this.data = data;
        this.columnHeaders = columnHeaders;
    }
    @Override
    public int getRowCount()
    {
        return rows;
    }
    @Override
    public int getColumnCount()
    {
        return columns;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if(rowIndex < data.size() && columnIndex < columns)
        {
            return data.get(rowIndex)[columnIndex];
        }
        return null;
    }
    @Override
    public String getColumnName(int column)
    {
        for(int i = 0; i < columnHeaders.length; i++)
        {
            if(column == i) return columnHeaders[i];
        }
        return "?";
    }
}
