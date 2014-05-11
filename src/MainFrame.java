import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Window.Type;
import java.awt.Font;

public class MainFrame extends JFrame implements ActionListener{

	private GridBagLayout gridBagLayout;
	private CardLayout cardLayout;
	
	private MainMenuPanel mainMenu;
	
	private CalcMaxPurchasePricePanel calcMaxPurchase;
	private CompletePurchasePanel completePurchase;
	
	private ManageAuctionMainMenuPanel auctionMM;
	private AddPaintingAuctionPanel addPaintingAuction;
	private SearchAuctionPanel searchAuction;
	private SeeAllAuctionPaintingsPanel seeAllAuction;
	private UpdateAuctionPanel updateAuction;
	
	private ManageArtistPanel manageArtist;
	private UpdateArtistPanel updateArtist;
	private AddNewArtistPanel addArtist;
	private ApplyArtistChangesPanel applyArtistChanges;
	
	private ManageInventoryMainMenuPanel manageInventoryMM;
	private UpdateInventoryPanel updateInventory;
	private SearchInventoryPanel searchInventory;
	
	//constants to be used for indicating a panel
	public static String MAIN_MENU = "Main Menu";
	
	public static String CALC_MAX_PURCH = "Calculate Max Purchase Price";
	public static String COMPLETE_PURCHASE = "Complete Purchase";
	
	public static String AUCTION_MM = "Auction Main Menu";
	public static String SEE_ALL_AUCTION = "See All Auction";
	public static String UPDATE_AUCTION = "Update Auction";
	public static String ADD_PAINTING_AUCTION = "Add Painting Auction";
	public static String SEARCH_AUCTION = "Search Auction";
	
	public static String MANAGE_ARTIST = "Manage Artists";
	public static String UPDATE_ARTIST = "Update Artist";
	public static String ADD_ARTIST = "Add New Artist";
	public static String APPLY_ARTIST_CHANGES = "Apply Artist Changes";
	
	public static String MANAGE_INVENTORY = "Manage Inventory";
	public static String UPDATE_INVENTORY = "Update Inventory";	
	public static String SEARCH_INVENTORY = "Search Inventory Paintings";
	
	
	/*
	 * Desc: Initializes the MainFrame object
	 */
	public MainFrame() {		
		setUpMainMenu();
		
		setUpCalcMaxPurchase();
		setUpCompletePurchase();
		
		setUpAuctionMM();
		setUpAddPaintingAuction();	
		setUpSearchAuction();
		setUpSeeAllAuction();
		setUpUpdateAuction();
		
		setUpManageArtist();
		setUpUpdateArtist();
		setUpAddArtist();
		setUpApplyArtistChanges();
		
		setUpManageInventoryMM();
		setUpUpdateInventory();	
		setUpSearchInventory();
		
		
		cardLayout = new CardLayout();

		setUpFrame();
	}


	/**
	 * Desc: sets up the Frame for MainFrame
	 */
	public void setUpFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFont(new Font("Century", Font.PLAIN, 12));
		setTitle("Les Objects d'Orient\r\n");
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(800, 600);
		setLocation(10, 10);

		getContentPane().setLayout(cardLayout);
		getContentPane().add(mainMenu, MAIN_MENU);
		getContentPane().add(auctionMM, AUCTION_MM);
		getContentPane().add(seeAllAuction, SEE_ALL_AUCTION);
		getContentPane().add(updateAuction, UPDATE_AUCTION);
		getContentPane().add(addPaintingAuction, ADD_PAINTING_AUCTION);
		getContentPane().add(searchAuction, SEARCH_AUCTION);
		getContentPane().add(calcMaxPurchase, CALC_MAX_PURCH);
		getContentPane().add(completePurchase, COMPLETE_PURCHASE);
		getContentPane().add(manageArtist, MANAGE_ARTIST);
		getContentPane().add(manageInventoryMM, MANAGE_INVENTORY);
		getContentPane().add(updateInventory, UPDATE_INVENTORY);
		getContentPane().add(updateArtist, UPDATE_ARTIST);
		getContentPane().add(addArtist, ADD_ARTIST);
		getContentPane().add(applyArtistChanges, APPLY_ARTIST_CHANGES);
		getContentPane().add(searchInventory, SEARCH_INVENTORY);
	}
	
	/**
	 * Desc: sets up the addArtist to be set up and used in MainFrame
	 * Post: addArtist and its components are able to be used in MainFrame
	 */
	private void setUpAddArtist()
	{
		addArtist = new AddNewArtistPanel();
	}
	
	/**
	 * Desc: sets up the addPaintingAuction to be set up and used in MainFrame
	 * Post: addPaintingAuction and its components are able to be used in MainFrame
	 */
	private void setUpAddPaintingAuction()
	{
		addPaintingAuction = new AddPaintingAuctionPanel();
		addPaintingAuction.getBtnCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), AUCTION_MM);
			}
		});
		addPaintingAuction.getBtnAddPaintingTo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!addPaintingAuction.isInputValid())
				{
					JOptionPane.showMessageDialog(addPaintingAuction, "Input is invalid, make sure all fields are correct");
				}
				else
				{
					Object[] options = {"Yes", "Cancel"};
					int n = JOptionPane.showOptionDialog(addPaintingAuction, "Are you sure you want to add this painting?",
							"Confirm Addition", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
					if(n == 0)
					{
						HandleAuctionPaintings.createAuctionPainting(AddPaintingAuctionPanel.createNewAuctionPainting(addPaintingAuction.getFieldValues()));
						cardLayout.show(getContentPane(), AUCTION_MM);
						addPaintingAuction.resetTextFields();
					}
			
				}
			}
		});
	}
	
	
	private void setUpApplyArtistChanges()
	{
		applyArtistChanges = new ApplyArtistChangesPanel();
	}
	
	/**
	 * Desc: sets up the calcMaxPurcahse to be set up and used in MainFrame
	 * Post: calcMaxPurchase and its components are able to be used in MainFrame
	 */
	private void setUpCalcMaxPurchase()
	{
		calcMaxPurchase = new CalcMaxPurchasePricePanel();
		calcMaxPurchase.getBtnCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), MAIN_MENU);
			}
		});
		calcMaxPurchase.getBtnAddPaintingTo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Check to make sure input is valid
				//setup painting form inputted info
				//double maxPurch = Calculations.calcMaxPurchasePrice(new painting);
				//if maxPurch = -1 don't allow to buy
				//else JOptionPane.show.....
				//if yes goto completePurchase
				//else stay at buy panel.
			}
		});
	}
	
	/**
	 * Desc: sets up the completePurchase to be set up and used in MainFrame
	 * Post: completePurchase and its components are able to be used in MainFrame
	 */
	private void setUpCompletePurchase()
	{
		completePurchase = new CompletePurchasePanel();
	}
	
	/**
	 * Desc: sets up the mainMenu to be set up and used in MainFrame
	 * Post: mainMenu and its components are able to be used in MainFrame
	 */
	private void setUpMainMenu()
	{
		mainMenu = new MainMenuPanel();
		mainMenu.getBtnManageInventory().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), MANAGE_INVENTORY);
			}
		});
		mainMenu.getBtnManageArtists().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), MANAGE_ARTIST);
			}
		});
		mainMenu.getBtnBuyPainting().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), CALC_MAX_PURCH);
			}
		});
		mainMenu.getBtnReportsPopup().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportGUI g = new ReportGUI(new Report());
			}
		});
		mainMenu.getBtnExit().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mainMenu.getBtnManageAuctionRecords().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(getContentPane(), AUCTION_MM);
			}
		});
	}
	
	/**
	 * Desc: sets up the manageArtist to be set up and used in MainFrame
	 * Post: manageArtist and its components are able to be used in MainFrame
	 */
	private void setUpManageArtist()
	{
		manageArtist = new ManageArtistPanel();
	}
	
	/**
	 * Desc: sets up the auctionMM to be set up and used in MainFrame
	 * Post: auctionMM and its components are able to be used in MainFrame
	 */
	private void setUpAuctionMM()
	{
		auctionMM = new ManageAuctionMainMenuPanel();
		auctionMM.getReturnToMainButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(getContentPane(), MAIN_MENU);
			}
		});
		auctionMM.getAddNewPaintingButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), ADD_PAINTING_AUCTION);
			}
		});
		auctionMM.getModifyPaintingButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), SEARCH_AUCTION);
			}
		});
		auctionMM.getSeeAllPaintingsButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seeAllAuction.updateList();
				cardLayout.show(getContentPane(), SEE_ALL_AUCTION);
			}
		});
	}
	
	/**
	 * Desc: sets up the manageInventoryMM to be set up and used in MainFrame
	 * Post: manageInventoryMM and its components are able to be used in MainFrame
	 */
	private void setUpManageInventoryMM()
	{
		manageInventoryMM = new ManageInventoryMainMenuPanel();
	}
	
	/**
	 * Desc: sets up the searchAuction to be set up and used in MainFrame
	 * Post: searchAuction and its components are able to be used in MainFrame
	 */
	private void setUpSearchAuction()
	{
		searchAuction = new SearchAuctionPanel();
		searchAuction.getBtnCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), AUCTION_MM);
			}
		});
		searchAuction.getBtnSearch().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//search for valid painting(s)
				//pop up a screen of paintings that can be selected.
				cardLayout.show(getContentPane(), UPDATE_AUCTION);
			}
		});
	}
	
	
	private void setUpSearchInventory()
	{
		searchInventory = new SearchInventoryPanel();
	}
	
	/**
	 * Desc: sets up the seeAllAuction to be set up and used in MainFrame
	 * Post: seeAllAuction and its components are able to be used in MainFrame
	 */
	private void setUpSeeAllAuction()
	{
		seeAllAuction = new SeeAllAuctionPaintingsPanel();
		seeAllAuction.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), AUCTION_MM);
			}
		});
	}
	
	/**
	 * Desc: sets up the updateArtist to be set up and used in MainFrame
	 * Post: updateArtist and its components are able to be used in MainFrame
	 */
	private void setUpUpdateArtist()
	{
		updateArtist = new UpdateArtistPanel();
	}
	
	/**
	 * Desc: sets up the updateAuction to be set up and used in MainFrame
	 * Post: updateAuction and its components are able to be used in MainFrame
	 */
	private void setUpUpdateAuction()
	{
		updateAuction = new UpdateAuctionPanel();
		updateAuction.getBtnCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), AUCTION_MM);
			}
		});
		updateAuction.getBtnDelete().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Yes", "Cancel"};
				int n = JOptionPane.showOptionDialog(addPaintingAuction, "Are you sure you want to delete this painting?",
						"Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(n == 0)
					cardLayout.show(getContentPane(), AUCTION_MM);
			}
		});
		updateAuction.getBtnSaveChanges().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Yes", "Cancel"};
				int n = JOptionPane.showOptionDialog(addPaintingAuction, "Are you sure you want to update this painting?",
						"Confirm Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(n == 0)
					cardLayout.show(getContentPane(), AUCTION_MM);
			}
		});
	}
	
	/**
	 * Desc: sets up the updateInventory to be set up and used in MainFrame
	 * Post: updateInventory and its components are able to be used in MainFrame
	 */
	private void setUpUpdateInventory()
	{
		updateInventory = new UpdateInventoryPanel();
	}
	
	/**
	 * Desc: Method to get cardLayout
	 * Return: the CardLayout of this
	 */
	public CardLayout getCardLayout()
	{
		return cardLayout;
	}
	
	/**
	 * 
	 *
	public void registerListeners()
	{
		mainMenu.getBtnBuyPainting().addActionListener(this);
		mainMenu.getBtnManageAuctionRecords().addActionListener(this);
		
	}*/

	/**
	 * Desc: Main method to run the whole program.
	 * @param args
	 */
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
