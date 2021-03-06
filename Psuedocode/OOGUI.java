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
	private JButton manageInventoryLOOMenuButton = new JButton()
	private JPanel manageInventoryLOOMenuPanel = new JPanel()
	private JButton buyLOOMenuButton = new JButton()
	private JPanel buyLOOMenuPanel = new JPanel()
	private JButton updateArtistFashionabilityMenuButton = new JButton()
	private JPanel updateArtistFashionabilityMenuPanel = new JPanel()
	private JButton reportsMenuButton = new JButton()
	private JButton buyReportButton = new JButton()
	private JButton sellReportButton = new JButton()
	private JButton trendReportButton = new JButton()
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
		mainMenu.add(manageInventoryLOOMenuButton)
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
		manageInventoryLOOMenuButton.addActionListener(this)
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
			if(Update Selected)
			{
				AuctionPainting selectedAP = selectAuctionPainting() //234
				AuctionPaintings aucPaintings[] = HandleAuctionPaintings.retrieveAuctionPaintings(selectedAP)
				selectedAP = aucPaintings[0]
				//Error check that paintings exist in DB
				AuctionPainting modifyAP = new AuctionPainting()
				setupUpdateInputPanel()
				changePanelToUpdateInputPanel()
				if(Field X is changed)
					modifyAP.setX(value changed)
				if(update selected
					HandleAuctionPaintings.updateAuctionPainting(selectedAP, modifyAP)
				if(Delete Selected)
					HandleAuctionPaintings.deleteAuctionPainting(selectedAP)
			}
			if(Add AuctionPainting Selected)
			{
				AuctionPainting addingAP = new AuctionPainting()
				setUpCreateInputPanel()
				changePanelToCreateInputPanel()
				addingAP = getInputtedFields()
				if(Add confirm selected)
					HandleAuctionPaintings.createAuctionPainting(addingAP)
			}
			if(SeeAll Selected)
			{
				show_All_Paintings_in_Auction_Records()
			}
		}
		if(e.getSource() == manageInventoryLOOMenuButton)
		{
			setUpmanageInventoryLOOMenuPanel()
			changePanelTomanageInventoryLOOMenuPanel()
			if(Update selected)
			{
				setupUpdateInputPanel()
				changeToUpdateInputPanel()
				InventoryPainting selectedIP = selectInventoryPainting()
				InventoryPainting modifyIP = new InventoryPainting()
				if(Field x is changed)
						modifyIP.setX(value changed)
				if(Fields Changed && UpdateButton Pressed)
				{
					displayPaintingInfo()
					HandleInventoryPaintings.updateInventoryPainting(modifyAP, selectedIP)
				}
				if(Delete Painting Pressed)
					HandleInventoryPaintings.deleteInventoryPainting(selectedIP)
			}
			if(Add Selected)
			{
				setupAddInputPanel()
				changeToAddInputPanel()
				InventoryPainting addedPainting = getAddedPaintingInfo()    //returns an InventoryPainting
											    //with what fields have been filled in
				if(Add Confirmed)
					HandleInventoryPaintings.createInventoryPainting(addedPainting)
			}
			if(Sell Painting Pressed)
			{
				setupSellPaintingInputPanel()
				changeToSellPaintingInputPanel()
				InventoryPainting selectedIP = selectInventoryPainting()
				InventoryPainting modifyIP = new InventoryPainting()
				getReleventInfoForSale(modifyIP)
				HandleInventoryPaintings.updateInventoryPainting(modifyIP, selectedIP)
			}
			if(SeeAll Selected)
			{
				show_All_Paintings_in_Inventory_Records()
			}
			if(SeeAllNotSold){
				show_All_Paintings_not_Sold()
			}
		}
		if(e.getSource() == buyLOOMenuButton)
		{
			setUpBuyLOOMenuPanel()
			changePanelToBuyLOOMenuPanel()
			InventoryPainting p = getReleventPaintingInfo() //Takes info from input text boxes and sets up
															//An Inventory Painting
			p.setMaxPrice(Calculation.calcMaxPrice(p))			
			displayMaxPriceWithBuyOption(p.getMaxPrice())   //Screen showing max price and option to buy painting
			if(Bought selected)
			{
				getReleventInfo()
				setRemaingFieldsForInventoryPainting(p)
				if(confirmed bought)
					HandleInventory.createInventoryPainting(p)
			}
			else backToMainScreen()
		}
		if(e.getSource() == updateArtistFashionabilityMenuButton)
		{
			setUpUpdateArtistFashionabilityMenuPanel()
			changePanelToUpdateArtistFashionabilityMenuPanel()
			Artist selectedArtist = selectArtist()
			Artist modifyArtist = new Artist()
			if(Field X is changed)
				modifyArtist.setX(changed value)
			if(update confirmed)
				HandleArtist.updateArtist(modifyArtist, selectedArtist)
			if(delete pressed)
				HandleArtist.deleteArtist(selectedArtist)
		}
		if(e.getSource() == buyReportButton)
		{
			PurhasedPaintingsReport purchPaintingsRep = new PurchasedPaintingsReport()
			popUpBoughtReport(purchPaintingsRep.getBoughtPaintings(), purchPaintingsRep.getMaxANdActualRatioSum())
		}
		if(e.getSource() == sellReportButton)
		{
			SoldPaintingsReport soldPaintingsRep = new soldPaintingsReport()
			popUpSoldReport(soldPaintingsRep.getSoldPaintings(), soldPaintingsRep.getTargetAndActualRatioAvg())
		}
		if(e.getSource() == trendReportButton)
		{
			DetectTrendsReport trendRep = new DetectTrendsReport()
			popUpTrendsReport(trendRep.getReportPaintings())
		}
		
	}
	
	/**
	 * Desc:  Pops up the bought report
	 * Post:  A pop up window of paintings bought in last year is displayed
	 * @param boughtPaintings
	 * @param ratio
	 */
	public void popUpBoughtReport(InventoryPainting[] boughtPaintings, double ratio)
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
		print20BoughtPaintingsPerTab()
	}
	
	/**
	 * Desc:  Pops up the Sold report
	 * Post:  sold Paintings report is pops up in a window
	 * @param soldPaintings
	 * @param ratio
	 */
	public void popUpSoldReport(InventoryPainting[] soldPaintings, double ratio)
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
		print20SoldReportPaintingsPerTab()
	}
	
	/**
	 * Desc:  Pops up the Trending Artist Reports
	 * Post:  sold Paintings report is pops up in a window
	 * @param soldPaintings
	 */
	public void popUpBoughtReport(InventoryPainting[] trendingPaintings)
	{
		double pages = (double)trendingPaintings.size() / 20.0
		if(pages%1 != 0)
			pages += 1
		JTabbedPane tabbedPane = new JTabbedPane()
		for(int i = 0; i<pages; i++)
		{
			tabbedPane.addTab(Page i+1 of trendReport)  
		}
		print20TrendingPaintingsPerTab()
	}
	
	/*
	 * Desc:  Gets artistFirstName, artistLastName, and titleOfWork from user and gives back that InventoryPainting
	 * Return:The InventoryPainting that is in-putted by the user
	 */
	public InventoryPainting selectInventoryPainting()
	{
		String fName = getFNameFromUser()
		String lName = getLNameFromUser()
		String pTitle = getPaintingTitleFromUser()
		InventoryPainting selectedIP = new InventoryPainting()
		selectedIP.setArtistFirstName(fName)
		selectedIP.setArtistLastName(lName)
		selectedIP.setTitleOfWork(pTitle)
		return selectedIP
	}
	
	/*
	 * Desc:  Gets artistFirstName, artistLastName, and titleOfWork from user and gives back that AuctionPainting
	 * Return:The AuctionPainting that is in-putted by the user
	 */
	public AuctionPainting selectAuctionPainting()
	{
		String fName = getFNameFromUser()
		String lName = getLNameFromUser()
		String pTitle = getPaintingTitleFromUser()
		AuctionPainting selectedAP = new AuctionPainting()
		selectedAP.setArtistFirstName(fName)
		selectedAP.setArtistLastName(lName)
		selectedAP.setTitleOfWork(pTitle)
		return selectedAP
	}
	
	/*
	 * Desc:  Gets the artistFirstName, artistLastName and returns the user the Artist
	 * Return:The Artist that is in-putted by the user
	 */
	public Artist selectArtist()
	{
		String fName = getFNameFromUser()
		String lName = getLNameFromUser()
		Artist selectedArtist = HandleArtist.retrieveArtists(new Artist(fName, lName, -1))
		return selectedArtist
	}
}
