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
    protected int lastClicked = -1;
    //Desc: Constructor for Report
    public ReportGUI(Report report)
    {
        this.report = report;
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
        return d.getReportPaintings();
    }
    //Desc: converts a PurchasedPaintingReport in a InventoryPainting[]
    //Return: returns a InventoryPainting[]
    private InventoryPainting[] convertToInventoryPainting(PurchasedPaintingReport p)
    {
        return p.getBoughtPaintings();
    }
    //Desc: converts a SoldPaintingsReport in a InventoryPainting[]
    //Return: returns a InventoryPainting[]
    private InventoryPainting[] convertToInventoryPainting(SoldPaintingsReport s)
    {
        return s.getSoldPaintings();
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
        JList list = new JList(paintings);
        list.setVisibleRowCount(20);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(730, 365));
        grid.add(scrollPane);

        grid.removeAll();
        ArrayList<Pair[]> pairs = new ArrayList<Pair[]>();
        for(int i = 0; i < paintings.length; i++)
        {
            //pairs.add(HandleInventoryPaintings.loadMap(paintings[i]));
        }
        JTable table = new JTable();


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