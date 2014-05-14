import javax.swing.*;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class ReportGUI
{
    protected JFrame frame;
    protected Report report;
    protected JPanel grid;
    protected int lastClicked = 0;
    //Desc: Constructor for Report
    public ReportGUI()
    {
        report = new PurchasedPaintingReport();
        setupFrame();
    }
    //Desc: converts a Report in a InventoryPainting[]
    //Return: returns a InventoryPainting[]
    private InventoryPainting[] convertToInventoryPainting()
    {
        if(report instanceof DetectTrendsReport)
        {
            return convertToInventoryPainting((DetectTrendsReport) report);
        }
        if(report instanceof PurchasedPaintingReport)
        {
            return convertToInventoryPainting((PurchasedPaintingReport) report);
        }
        if(report instanceof SoldPaintingsReport)
        {
            return convertToInventoryPainting((SoldPaintingsReport) report);
        }
        return null;
    }
    //Desc: converts a DetectTrendsReport in a InventoryPainting[]
    //Return: returns a InventoryPainting[]
    private InventoryPainting[] convertToInventoryPainting(DetectTrendsReport d)
    {
        InventoryPainting[] paintings = d.getReportPaintings();
        if(paintings == null) return new InventoryPainting[0];
        return paintings;
    }
    //Desc: converts a PurchasedPaintingReport in a InventoryPainting[]
    //Return: returns a InventoryPainting[]
    private InventoryPainting[] convertToInventoryPainting(PurchasedPaintingReport p)
    {
        InventoryPainting[] paintings = p.getBoughtPaintings();
        if(paintings == null) return new InventoryPainting[0];
        return paintings;
    }
    //Desc: converts a SoldPaintingsReport in a InventoryPainting[]
    //Return: returns a InventoryPainting[]
    private InventoryPainting[] convertToInventoryPainting(SoldPaintingsReport s)
    {
        InventoryPainting[] paintings = s.getSoldPaintings();
        if(paintings == null) return new InventoryPainting[0];
        return paintings;
    }
    //Desc: method to encapsulate setting up the JFrame
    //Post: the JFrame will be setup
    public void setupFrame()
    {
        frame = new JFrame("Report GUI");
        JPanel iconPanel = new JPanel();
        grid = new JPanel(new FlowLayout());
        setupGrid(new InventoryPainting[0]);
        addButtons(iconPanel);
        setupGridBag(iconPanel, grid);
        setupFrameSettings();
        displayPaintings();
    }
    //Desc: sets frame settings
    //Post: Frame has settings initialized
    private void setupFrameSettings()
    {
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    //Desc: used to display all paintings
    //Post: Paintings are displayed in the grid
    private void displayPaintings()
    {
        InventoryPainting[] paintings = convertToInventoryPainting();
        setupGrid(paintings);
    }
    //Desc: creates and sets up the grid
    //Post: the Grid is setup
    private void setupGrid(InventoryPainting[] paintings)
    {
        grid.removeAll();
        String[] columnTitles = loadTitles();
        ArrayList<String[]> pairs = new ArrayList<String[]>();
        loadData(paintings, pairs);
        int rows = 20;
        if(pairs.size() > rows) rows = pairs.size();
        JTable table = new JTable(new ReportTableModel(rows, columnTitles.length, pairs, columnTitles));
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(22);
        table.setAutoResizeMode(0);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(810, 478));
        grid.add(scrollPane);


    }
    //Desc: creates and sets up buttons
    //Post: buttons are added to the panel
    private void addButtons(JPanel iconPanel)
    {
        final JButton purchasedButton = new JButton("Purchased Paintings Report");
        final JButton soldButton = new JButton("Sold Paintings Report");
        final JButton detectedButton = new JButton("Detect Trends Report");
        final Font activeFont=new Font(purchasedButton.getFont().getName(),Font.BOLD,purchasedButton.getFont().getSize() + 2);
        final Font passiveFont=new Font(purchasedButton.getFont().getName(),0,purchasedButton.getFont().getSize());
        purchasedButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(lastClicked != 0)
                {
                    purchasedButton.setFont(activeFont);
                    soldButton.setFont(passiveFont);
                    detectedButton.setFont(passiveFont);
                    report = new PurchasedPaintingReport();
                    displayPaintings();
                    lastClicked = 0;
                }
            }
        });
        soldButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(lastClicked != 1)
                {
                    purchasedButton.setFont(passiveFont);
                    soldButton.setFont(activeFont);
                    detectedButton.setFont(passiveFont);
                    report = new SoldPaintingsReport();
                    displayPaintings();
                    lastClicked = 1;
                }
            }
        });
        detectedButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(lastClicked != 2)
                {
                    purchasedButton.setFont(passiveFont);
                    soldButton.setFont(passiveFont);
                    detectedButton.setFont(activeFont);
                    report = new DetectTrendsReport();
                    displayPaintings();
                    lastClicked = 2;
                }
            }
        });
        purchasedButton.setFont(activeFont);
        soldButton.setFont(passiveFont);
        detectedButton.setFont(passiveFont);
        purchasedButton.setPreferredSize(new Dimension(270, 30));
        soldButton.setPreferredSize(new Dimension(270, 30));
        detectedButton.setPreferredSize(new Dimension(270, 30));
        iconPanel.add(purchasedButton);
        iconPanel.add(soldButton);
        iconPanel.add(detectedButton);
    }
    //Desc: method to setup the gridbag
    //Post: the gridbag is setup
    private void setupGridBag(JPanel iconPanel, JPanel grid)
    {
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(iconPanel,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        frame.add(grid,c);
    }
    //Desc: method to load a String[] with values to assist in the creation of column headers
    // In particular, this method assists with limiting the amount of hardcoding in the stringify
    //Return: the fully loaded String[] is returned
    private String[] loadTitles()
    {
        ArrayList<String> titles = new ArrayList<String>();
        if(lastClicked == 0)
        {
            titles.add("Classification"); //4
            titles.add("Date of Purchase"); //9
            titles.add("Artist Last Name"); //1
            titles.add("Painting Title"); //2
            titles.add("Maximum Purchase Price"); //12
            titles.add("Actual Purchase Price"); //13
        }
        else if(lastClicked == 1)
        {
            titles.add("Classification"); //4
            titles.add("Date of Sale"); //14
            titles.add("Artist Last Name"); //1
            titles.add("Painting Title"); //2
            titles.add("Target Selling Price"); //not indexed
            titles.add("Actual Selling Price"); //17
        }
        else if(lastClicked == 2)
        {
            titles.add("Artist Last Name"); //1
            titles.add("Date of Sale"); //14
            titles.add("Classification"); //4
            titles.add("Painting Title"); //2
            titles.add("Target Selling Price"); //not indexed
            titles.add("Actual Selling Price"); //17
        }
        return Arrays.copyOf(titles.toArray(), titles.toArray().length, String[].class);
    }
    private void loadData(InventoryPainting[] paintings, ArrayList<String[]> data)
    {

        if(lastClicked == 0)
        {
            for(int i = 0; i < paintings.length; i++)
            {
                String[] fields = new String[6];
                fields[0] = paintings[i].getClassification();
                fields[1] = paintings[i].getDateOfPurchase().toString();
                fields[2] = paintings[i].getArtistLastName();
                fields[3] = paintings[i].getTitleOfWork();
                fields[4] = "" + paintings[i].getMaxPurchasePrice();
                fields[5] = "" + paintings[i].getActualPurchasePrice();
                data.add(fields);
            }
        }
        else if(lastClicked == 1)
        {
            for(int i = 0; i < paintings.length; i++)
            {
                String[] fields = new String[6];
                fields[0] = paintings[i].getClassification();
                fields[1] = paintings[i].getDateOfSale().toString();
                fields[2] = paintings[i].getArtistLastName();
                fields[3] = paintings[i].getTitleOfWork();
                fields[4] = "" + paintings[i].getTargetSellPrice();
                fields[5] = "" + paintings[i].getActualSellPrice();
                data.add(fields);
            }
        }
        else if(lastClicked == 2)
        {
            for(int i = 0; i < paintings.length; i++)
            {
                String[] fields = new String[6];
                fields[0] = paintings[i].getArtistLastName();
                fields[1] = paintings[i].getDateOfSale().toString();
                fields[2] = paintings[i].getClassification();
                fields[3] = paintings[i].getTitleOfWork();
                fields[4] = "" + paintings[i].getTargetSellPrice();
                fields[5] = "" + paintings[i].getActualSellPrice();
                data.add(fields);
            }
        }
    }
    public static void main(String[] args)
    {
        ReportGUI g = new ReportGUI();
    }
}