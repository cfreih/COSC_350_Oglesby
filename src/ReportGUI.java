import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class ReportGUI
{
    protected JFrame frame;
    protected Report report;
    protected JPanel gridPanel;
    protected JPanel labelPanel;
    protected JTable table;
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
        gridPanel = new JPanel(new FlowLayout());
        labelPanel = new JPanel();
        setupLabel();
        setupGrid(new InventoryPainting[0]);
        addButtons(iconPanel);
        setupGridBag(iconPanel, gridPanel, labelPanel);
        setupFrameSettings();
        displayPaintings();
    }
    //Desc: method to setup the labels
    //Post: the labels are setup
    private void setupLabel()
    {
        labelPanel.removeAll();
        JLabel label = new JLabel();
        if(lastClicked == 0)
        {
            String labelString = "Average Ratio of Actual Purchase Price to Maximum Purchase Price: ";
            PurchasedPaintingReport p = (PurchasedPaintingReport) report;
            labelString += p.getMaxAndActualRatio();
            label.setText(labelString);
        }
        else if(lastClicked == 1)
        {
            String labelString = "Average Ratio of Actual Selling Price to Target Selling Price: ";
            SoldPaintingsReport s = (SoldPaintingsReport) report;
            labelString += s.getTargetAndActualRatio();
            label.setText(labelString);
        }
        else if(lastClicked == 2)
        {
            String labelString = "Number of Unique Artists: ";
            DetectTrendsReport d = (DetectTrendsReport) report;
            labelString += d.findTrendingArtists().length;
            label.setText(labelString);
        }
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setSize(new Dimension(860, 30));
        labelPanel.add(label);
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
    //Post: Paintings are displayed in the gridPanel
    private void displayPaintings()
    {
        InventoryPainting[] paintings = convertToInventoryPainting();
        sortPaintings(paintings);
        setupGrid(paintings);
        setupLabel();
    }
    private void sortPaintings(InventoryPainting[] paintings)
    {
        if(lastClicked == 0) sortPurchasedPaintings(paintings);
        else if(lastClicked == 1) sortSoldPaintings(paintings);
        else if(lastClicked == 2) sortDetectPaintings(paintings);
    }
    //Desc: method to sort all detected paintings
    //Post: all paintings will be sorted
    private void sortDetectPaintings(InventoryPainting[] paintings)
    {
        Arrays.sort(paintings, new NameComparator());
    }
    //Desc: method to sort all purchased paintings
    //Post: all paintings will be sorted
    private void sortPurchasedPaintings(InventoryPainting[] paintings)
    {
        int masterpieceCount = 0;
        int masterworkCount = 0;
        Arrays.sort(paintings, new ClassificationComparator());
        for(int i = 0; i < paintings.length; i++)
        {
            if(paintings[i].getClassification().equals("Masterpiece"))
            {
                masterpieceCount++;
            }
            if(paintings[i].getClassification().equals("Masterwork"))
            {
                masterworkCount++;
            }
        }
        masterworkCount = masterpieceCount + masterworkCount;
        int otherCount = masterpieceCount + masterworkCount;
        InventoryPainting[] masterpieces = Arrays.copyOfRange(paintings, 0, masterpieceCount);
        InventoryPainting[] masterworks = Arrays.copyOfRange(paintings, masterpieceCount, masterworkCount);
        InventoryPainting[] others = Arrays.copyOfRange(paintings, masterworkCount, paintings.length);
        Arrays.sort(masterpieces,new DateOfPurchaseComparator(true));
        Arrays.sort(masterworks, new DateOfPurchaseComparator(true));
        Arrays.sort(others, new DateOfPurchaseComparator(true));
        if(masterpieceCount != 0)mergeArrays(0, masterpieceCount, paintings, masterpieces);
        if(masterworkCount != 0) mergeArrays(masterpieceCount, masterworkCount, paintings, masterworks);
        if(otherCount != paintings.length) mergeArrays(masterworkCount, paintings.length, paintings, others);
    }
    //Desc: method to sort all sold paintings
    //Post: all paintings will be sorted
    private void sortSoldPaintings(InventoryPainting[] paintings)
    {
        int masterpieceCount = 0;
        int masterworkCount = 0;
        Arrays.sort(paintings, new ClassificationComparator());
        for(int i = 0; i < paintings.length; i++)
        {
            if(paintings[i].getClassification().equals("Masterpiece"))
            {
                masterpieceCount++;
            }
            if(paintings[i].getClassification().equals("Masterwork"))
            {
                masterworkCount++;
            }
        }
        masterworkCount = masterpieceCount + masterworkCount;
        InventoryPainting[] masterpieces = Arrays.copyOfRange(paintings, 0, masterpieceCount);
        InventoryPainting[] masterworks = Arrays.copyOfRange(paintings,masterpieceCount, masterworkCount);
        InventoryPainting[] others = Arrays.copyOfRange(paintings, masterworkCount, paintings.length );
        Arrays.sort(masterpieces,new DateOfPurchaseComparator(false));
        Arrays.sort(masterworks, new DateOfPurchaseComparator(false));
        Arrays.sort(others, new DateOfPurchaseComparator(false));
        mergeArrays(0, masterpieceCount, paintings, masterpieces);
        mergeArrays(masterpieceCount, masterworkCount, paintings, masterworks);
        mergeArrays(masterworkCount, paintings.length, paintings, others);
    }
    private void mergeArrays(int start, int end, InventoryPainting[] arr1, InventoryPainting[] arr2)
    {
        int count = 0;
        for(int i = start; i < end; i++)
        {
            arr1[i] = arr2[count];
            count++;
        }
    }
    //Desc: creates and sets up the gridPanel
    //Post: the Grid is setup
    private void setupGrid(InventoryPainting[] paintings)
    {
        gridPanel.removeAll();
        String[] columnTitles = loadTitles();
        ArrayList<String[]> pairs = new ArrayList<String[]>();
        loadData(paintings, pairs);
        int rows = 20;
        if(pairs.size() > rows) rows = pairs.size();
        table = new JTable(new ReportTableModel(rows, columnTitles.length, pairs, columnTitles));
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(22);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(860, 463));
        gridPanel.add(scrollPane);
    }
    //Desc: creates and sets up buttons
    //Post: buttons are added to the panel
    private void addButtons(JPanel iconPanel)
    {
        final JButton purchasedButton = new JButton("Purchased Paintings Report");
        final JButton soldButton = new JButton("Sold Paintings Report");
        final JButton detectedButton = new JButton("Detect Trends Report");
        final Font activeFont=new Font(purchasedButton.getFont().getName(),Font.BOLD,purchasedButton.getFont().getSize() + 3);
        final Font passiveFont=new Font(purchasedButton.getFont().getName(),0,purchasedButton.getFont().getSize() + 1);
        purchasedButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(lastClicked != 0)
                {
                    lastClicked = 0;
                    purchasedButton.setFont(activeFont);
                    soldButton.setFont(passiveFont);
                    detectedButton.setFont(passiveFont);
                    report = new PurchasedPaintingReport();
                    displayPaintings();
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
                    lastClicked = 1;
                    purchasedButton.setFont(passiveFont);
                    soldButton.setFont(activeFont);
                    detectedButton.setFont(passiveFont);
                    report = new SoldPaintingsReport();
                    displayPaintings();
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
                    lastClicked = 2;
                    purchasedButton.setFont(passiveFont);
                    soldButton.setFont(passiveFont);
                    detectedButton.setFont(activeFont);
                    report = new DetectTrendsReport();
                    displayPaintings();
                }
            }
        });
        purchasedButton.setFont(activeFont);
        soldButton.setFont(passiveFont);
        detectedButton.setFont(passiveFont);
        purchasedButton.setPreferredSize(new Dimension(280, 30));
        soldButton.setPreferredSize(new Dimension(280, 30));
        detectedButton.setPreferredSize(new Dimension(280, 30));
        iconPanel.add(purchasedButton);
        iconPanel.add(soldButton);
        iconPanel.add(detectedButton);
    }
    //Desc: method to setup the gridbag
    //Post: the gridbag is setup
    private void setupGridBag(JPanel iconPanel, JPanel grid, JPanel label)
    {
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(iconPanel, c);
        c.gridy = 1;
        frame.add(grid,c);
        c.gridy = 2;
        frame.add(label, c);
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
            titles.add("Artist Name"); //1
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
        MoneyFormat mf = new MoneyFormat();
        if(lastClicked == 0)
        {
            for(int i = 0; i < paintings.length; i++)
            {
                String[] fields = new String[6];
                fields[0] = paintings[i].getClassification();
                fields[1] = paintings[i].getDateOfPurchase().toString();
                fields[2] = paintings[i].getArtistLastName();
                fields[3] = paintings[i].getTitleOfWork();
                fields[4] = mf.format(paintings[i].getMaxPurchasePrice());
                fields[5] = mf.format(paintings[i].getActualPurchasePrice());
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
                fields[4] = mf.format(paintings[i].getTargetSellPrice());
                fields[5] = mf.format(paintings[i].getActualSellPrice());
                data.add(fields);
            }
        }
        else if(lastClicked == 2)
        {
            for(int i = 0; i < paintings.length; i++)
            {
                String[] fields = new String[6];
                fields[0] = paintings[i].getArtistLastName() + ", " + paintings[i].getArtistFirstName();
                fields[1] = paintings[i].getDateOfSale().toString();
                fields[2] = paintings[i].getClassification();
                fields[3] = paintings[i].getTitleOfWork();
                fields[4] = mf.format(paintings[i].getTargetSellPrice());
                fields[5] = mf.format(paintings[i].getActualSellPrice());
                data.add(fields);
            }
        }
    }
    public static void main(String[] args)
    {
        ReportGUI g = new ReportGUI();
    }
}