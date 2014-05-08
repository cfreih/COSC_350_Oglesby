import javax.swing.*;
import java.awt.*; 
import java.util.*;
public class ReportGUI
{
  protected JFrame frame;
  protected Report report;
  //Desc: Constructor for Report
  public ReportGUI(Report report)
  {
    this.report = report;
    String[] paintings = new String[40];
    for(int i = 0; i < paintings.length; i++)
    {
      paintings[i] = "Painting " + (i + 1);
    }
    setupFrame(paintings);
  }
  //Desc: method to encapsulate setting up the JFrame
  //Post: the JFrame will be setup
  public void setupFrame(String[] paintings)
  {
    frame = new JFrame("Report GUI");
    JPanel iconPanel = new JPanel();
    JPanel grid = new JPanel(new FlowLayout());
    JButton purchasedButton = new JButton("Purchased Paintings Report");
    JButton soldButton = new JButton("Sold Paintings Report");
    JButton detectedButton = new JButton("Detect Trends Report");
    purchasedButton.setPreferredSize(new Dimension(200, 30));
    soldButton.setPreferredSize(new Dimension(200, 30));
    detectedButton.setPreferredSize(new Dimension(200, 30));
    
    iconPanel.add(purchasedButton);
    iconPanel.add(soldButton);
    iconPanel.add(detectedButton);
    
    JList list = new JList(paintings);
    list.setVisibleRowCount(20);
    JScrollPane scrollPane = new JScrollPane(list);
    scrollPane.setPreferredSize(new Dimension(610, 365));
    grid.add(scrollPane);
    
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
    
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
  public static void main(String[] args)
  {
    ReportGUI g = new ReportGUI(new Report());
  }
}