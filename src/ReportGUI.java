import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class ReportGUI
{
    protected JFrame frame;
    protected Report report;
    protected JPanel grid;
    //Desc: Constructor for Report
    public ReportGUI(Report report)
    {
        this.report = report;
        String[] paintings = {"Please select a report"};
        setupFrame(paintings);
    }
    //Desc: converts a Report in a String[]
    //Return: returns a String[]
    private String[] convertToString()
    {
        if(report instanceof DetectTrendsReport)
        {
            return convertToString((DetectTrendsReport) report);
        }
        if(report instanceof PurchasedPaintingReport)
        {
            return convertToString((PurchasedPaintingReport) report);
        }
        if(report instanceof SoldPaintingsReport)
        {
            return convertToString((SoldPaintingsReport) report);
        }
        return null;
    }
    //Desc: converts a DetectTrendsReport in a String[]
    //Return: returns a String[]
    private String[] convertToString(DetectTrendsReport d)
    {
        String[] result = {"No Paintings exist"};
        InventoryPainting[] paintings = d.getReportPaintings();
        if(paintings == null || paintings.length == 0) return result;
        result = new String[paintings.length];
        for(int i = 0; i < result.length; i++)
        {
            result[i] = paintings[i].toString();
        }
        return result;
    }
    //Desc: converts a PurchasedPaintingReport in a String[]
    //Return: returns a String[]
    private String[] convertToString(PurchasedPaintingReport p)
    {
        String[] result = {"No Paintings exist"};
        InventoryPainting[] paintings = p.getBoughtPaintings();
        if(paintings == null || paintings.length == 0) return result;
        result = new String[paintings.length];
        for(int i = 0; i < result.length; i++)
        {
            result[i] = paintings[i].toString();
        }
        return result;
    }
    //Desc: converts a SoldPaintingsReport in a String[]
    //Return: returns a String[]
    private String[] convertToString(SoldPaintingsReport s)
    {
        String[] result = {"No Paintings exist"};
        InventoryPainting[] paintings = s.getSoldPaintings();
        if(paintings == null || paintings.length == 0) return result;
        result = new String[paintings.length];
        for(int i = 0; i < result.length; i++)
        {
            result[i] = paintings[i].toString();
        }
        return result;
    }
    //Desc: method to encapsulate setting up the JFrame
    //Post: the JFrame will be setup
    public void setupFrame(String[] paintings)
    {
        frame = new JFrame("Report GUI");
        JPanel iconPanel = new JPanel();
        grid = new JPanel(new FlowLayout());
        setupGrid(paintings);
        addButtons(iconPanel);
        setupGridBag(iconPanel, grid);
        setupFrameSettings();
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
        String[] paintings = convertToString();
        setupGrid(paintings);
    }
    //Desc: creates and sets up the grid
    //Post: the Grid is setup
    private void setupGrid(String[] paintings)
    {
        grid.removeAll();
        JList list = new JList(paintings);
        list.setVisibleRowCount(20);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(730, 365));
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
                purchasedButton.setFont(activeFont);
                soldButton.setFont(passiveFont);
                detectedButton.setFont(passiveFont);
                report = new PurchasedPaintingReport();
                displayPaintings();
            }
        });
        soldButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                purchasedButton.setFont(passiveFont);
                soldButton.setFont(activeFont);
                detectedButton.setFont(passiveFont);
                report = new SoldPaintingsReport();
                displayPaintings();
            }
        });
        detectedButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                purchasedButton.setFont(passiveFont);
                soldButton.setFont(passiveFont);
                detectedButton.setFont(activeFont);
                report = new DetectTrendsReport();
                displayPaintings();
            }
        });
        purchasedButton.setFont(passiveFont);
        soldButton.setFont(passiveFont);
        detectedButton.setFont(passiveFont);
        purchasedButton.setPreferredSize(new Dimension(240, 30));
        soldButton.setPreferredSize(new Dimension(240, 30));
        detectedButton.setPreferredSize(new Dimension(240, 30));
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
    public static void main(String[] args)
    {
        ReportGUI g = new ReportGUI(new Report());
    }
}