import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;

/**
 * This is the class controlling most aspects of the GUI for
 * the program.
 * @author Clint
 *
 */
public class OOGUI extends JPanel implements ActionListener{
	
	private JPanel mainMenu = new JPanel()
	private JButton updateAuctionRecordsMenuButton = new JButton()
	private JPanel updateAuctionRecordsMenuPanel = new JPanel()
	private JButton sellAndUpdateLOOMenuButton = new JButton()
	private JPanel sellAndUpdateLOOMenuPanel = new JPanel()
	private JButton buyLOOMenuButton = new JButton()
	private JPanel buyLOOMenuPanel = new JPanel()
	private JButton updateArtistFashionabilityMenuButton = new JButton()
	private JPanel updateArtistFashionabilityMenuPanel = new JPanel()
	private JButton reportsMenuButton = new JButton()
	private JPanel reportsMenuPanel = new JPanel()
	private JOptionPane buyOption = new JOptionPane()
	
	/**
	 * Desc:  Constructor for OOGUI
	 * Post:  OOGUI will be setup with the right properties
	 */
	public OOGUI()
	{
		setLayout(new GridBagLayout())
		setTitle("Les Objects d'Or")
		setSize(600,600)
		setLocation(100,100)
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
	}
	
	/**
	 * Desc:  Sets up the main menu Frame.
	 * Post:  mainMenu is setup properly
	 */
	public void setUpMenu()
	{
		mainMenu.setLayout(new FlowLayout())
		mainMenu.add(updateAuctionRecordsMenuButton)
		mainMenu.add(sellAndUpdateLOOMenuButton)
		mainMenu.add(buyLOOMenuButton)
		mainMenu.add(updateArtistFashionabilityMenuButton)
		mainMenu.add(reportsMenuButton)
	}
	
	/**
	 * Desc:  Adds Listeners for the buttons
	 * Post:  listeners for all the buttons is added
	 */
	public void registerListeners()
	{
		updateAuctionRecordsMenuButton.addActionListener(this)
		sellAndUpdateLOOMenuButton.addActionListener(this)
		buyLOOMenuButton.addActionListener(this)
		updateArtistFashionabilityMenuButton.addActionListener(this)
		reportsMenuButton.addActionListener(this)
		registerUpdateAuctionRecordsMenuPanelActions()
	}
	
	/**
	 * Desc:  Hands performing the proper actions as they are
	 * 		  done.
	 * @param e is the event of an action.
	 */
	public void ActionPerformed(ActionEvent e)
	{
		if(e.getSource() == updateAuctionRecordsMenuButton)
		{
			setUpUpdateAuctionRecordsMenuPanel()
			changePanelToUpdateAuctionRecordsMenuPanel()
		}
		if(e.getSource() == sellAndUpdateLOOMenuButton)
		{
			setUpSellAndUpdateLOOMenuPanel()
			changePanelToSellAndUpdateLOOMenuPanel()
		}
		if(e.getSource() == buyLOOMenuButton)
		{
			setUpBuyLOOMenuPanel()
			changePanelToBuyLOOMenuPanel()
		}
		if(e.getSource() == updateArtistFashionabilityMenuButton)
		{
			setUpUpdateArtistFashionabilityMenuPanel()
			changePanleToUpdateArtistFashionabilityMenuPanel()
		}
		if(e.getSource() == reportsMenuButton)
		{
			popUpreportsMenuFrame()
			if(e.getSource() == buyReportButton)
			{
				purchPaintingsRep = new PurchasedPaintingsReport()
				popUpBoughtReport(purchPaintingsRep.getBoughtPaintings(), purchPaintingsRep.getMaxANdActualRatioSum())
			}
			if(e.getSource() == sellReportButton)
			{
				soldPaintingsRep = new soldPaintingsReport()
				popUpSoldReport(soldPaintingsRep.getSoldPaintings(), soldPaintingsRep.getTargetAndActualRatioAvg())
			}
			if(e.getSource() == trendReportButton)
			{
				trendRep = new DetectTrendsReport
				popUpTrendsReport(detectTrendsReport.getFullTrendsReport())
			}
		}
	}
	
	/**
	 * Desc:  Pops up the bought report
	 * Post:  A pop up window of paintings bought in last year is displayed
	 * @param boughtPaintings
	 * @param ratio
	 */
	public void popUpBoughtReport(BinarySearchTree<InventoryPainting> boughtPaintings, double ratio)
	{
		double pages = (double)boughtPaintings.size() / 20.0
		if(pages%1 != 0)
			pages += 1
		JTabbedPane tabbedPane = new JTabbedPane()
		for(int i = 0; i<pages; i++)
		{
			tabbedPane.addTab(Page i+1 of boughtReport)  
		}
		displayAvgRatioAtEnd(ratio)
	}
	
	/**
	 * Desc:  Pops up the Sold report
	 * Post:  sold Paintings report is pops up in a window
	 * @param soldPaintings
	 * @param ratio
	 */
	public void popUpBoughtReport(BinarySearchTree<InventoryPainting> soldPaintings, double ratio)
	{
		double pages = (double)soldPaintings.size() / 20.0
		if(pages%1 != 0)
			pages += 1
		JTabbedPane tabbedPane = new JTabbedPane()
		for(int i = 0; i<pages; i++)
		{
			tabbedPane.addTab(Page i+1 of soldReport)  
		}
		displayAvgRatioAtEnd(ratio)
	}
	
	/**
	 * Desc:  Pops up the Trending Artist Reports
	 * Post:  sold Paintings report is pops up in a window
	 * @param soldPaintings
	 * @param ratio
	 */
	public void popUpBoughtReport(BinarySearchTree<InventoryPainting> trendingPaintings)
	{
		double pages = (double)trendingPaintings.size() / 20.0
		if(pages%1 != 0)
			pages += 1
		JTabbedPane tabbedPane = new JTabbedPane()
		for(int i = 0; i<pages; i++)
		{
			tabbedPane.addTab(Page i+1 of trendReport)  
		}
	}
}
