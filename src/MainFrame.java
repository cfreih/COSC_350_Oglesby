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
	
	private CompleteSalePanel completeSale;
	private SearchPaintingSale searchPaintingSale;
	
	private ManageAuctionMainMenuPanel auctionMM;
	private AddPaintingAuctionPanel addPaintingAuction;
	private SearchAuctionPanel searchAuction;
	private SearchResultsAuctionPanel searchResultsAuction;
	private SeeAllAuctionPaintingsPanel seeAllAuction;
	private UpdateAuctionPanel updateAuction;
	
	private ManageArtistPanel artistMM;
	private UpdateArtistPanel updateArtist;
	private AddNewArtistPanel addArtist;
	private SearchArtistPanel searchArtist;
	private SearchResultsArtistPanel searchResultsArtist;
	private SeeAllArtistsPanel seeAllArtists;
	
	private ManageInventoryMainMenuPanel manageInventoryMM;
	private AddPaintingInventoryPanel addPaintingInventory;
	private UpdateInventoryPanel updateInventory;
	private SeeAllInventoryPanel seeAllInventory;
	private SearchInventoryPanel searchInventory;
	
	//constants to be used for indicating a panel
	public static String MAIN_MENU = "Main Menu";
	
	public static String CALC_MAX_PURCH = "Calculate Max Purchase Price";
	public static String COMPLETE_PURCHASE = "Complete Purchase";
	
	public static String COMPLETE_SALE = "Compete Sale";
	public static String SEARCH_PAINTING_SALE = "Search Painting Sale";
	
	public static String AUCTION_MM = "Auction Main Menu";
	public static String SEE_ALL_AUCTION = "See All Auction";
	public static String UPDATE_AUCTION = "Update Auction";
	public static String ADD_PAINTING_AUCTION = "Add Painting Auction";
	public static String SEARCH_AUCTION = "Search Auction";
	public static String SEARCH_RESULTS_AUCTION = "Search Results Auction";
	
	public static String ARTIST_MM = "Manage Artists";
	public static String UPDATE_ARTIST = "Update Artist";
	public static String ADD_ARTIST = "Add New Artist";
	public static String APPLY_ARTIST_CHANGES = "Apply Artist Changes";
	public static String SEARCH_ARTIST = "Search Artist";
	public static String SEARCH_RESULTS_ARTIST = "Search Results Artist";
	public static String SEE_ALL_ARTISTS = "See All Artists";
	
	public static String MANAGE_INVENTORY = "Manage Inventory";
	public static String ADD_PAINTING_INVENTORY = "Add Painting Inventory";
	public static String UPDATE_INVENTORY = "Update Inventory";	
	public static String SEE_ALL_INVENTORY = "See All Invneotry";
	public static String SEARCH_INVENTORY = "Search Inventory Paintings";
	
	
	/*
	 * Desc: Initializes the MainFrame object
	 */
	public MainFrame() {		
		setUpMainMenu();
		
		setUpCalcMaxPurchase();
		setUpCompletePurchase();
		
		setUpCompleteSale();
		setUpSearchPaintingSale();
		
		setUpAuctionMM();
		setUpAddPaintingAuction();	
		setUpSearchAuction();
		setUpSearchResultsAuction();
		setUpSeeAllAuction();
		setUpUpdateAuction();
		
		setUpArtistMM();
		setUpUpdateArtist();
		setUpAddArtist();
		setUpSearchArtist();
		setUpSearchResultsArtist();
		setUpSeeAllArtists();
		
		setUpManageInventoryMM();
		setUpUpdateInventory();	
		setUpSearchInventory();
		setUpAddPaintingInventory();
		setUpSeeAllInventory();
		
		
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
		getContentPane().add(artistMM, ARTIST_MM);
		getContentPane().add(manageInventoryMM, MANAGE_INVENTORY);
		getContentPane().add(updateInventory, UPDATE_INVENTORY);
		getContentPane().add(updateArtist, UPDATE_ARTIST);
		getContentPane().add(addArtist, ADD_ARTIST);
		getContentPane().add(searchInventory, SEARCH_INVENTORY);
		getContentPane().add(searchResultsAuction, SEARCH_RESULTS_AUCTION);
		getContentPane().add(completeSale, COMPLETE_SALE);
		getContentPane().add(searchPaintingSale, SEARCH_PAINTING_SALE);
		getContentPane().add(searchArtist, SEARCH_ARTIST);
		getContentPane().add(searchResultsArtist, SEARCH_RESULTS_ARTIST);
		getContentPane().add(seeAllArtists, SEE_ALL_ARTISTS);
		getContentPane().add(addPaintingInventory, ADD_PAINTING_INVENTORY);
		getContentPane().add(seeAllInventory, SEE_ALL_INVENTORY);
	}
	
	/**
	 * Desc: sets up the addArtist to be set up and used in MainFrame
	 * Post: addArtist and its components are able to be used in MainFrame
	 */
	private void setUpAddArtist()
	{
		addArtist = new AddNewArtistPanel();
		addArtist.getBtnCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), ARTIST_MM);
				addArtist.resetTextFields();
			}
		});
		addArtist.getBtnAddNewArtist().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!addArtist.isInputValid())
					JOptionPane.showMessageDialog(addArtist, "Input is invalid, make sure all fields are correct.");
				else
				{
					Artist newArtist = addArtist.createNewArtist();
					Artist checkDBArtist = getCheckDBArtist(newArtist);
					Artist[] checkArtistExists = HandleArtist.retrieveArtists(checkDBArtist);
					if(checkArtistExists.length > 0)
						JOptionPane.showMessageDialog(addArtist, "Artist already exists.");
					else
					{
						Object[] options = {"Yes", "Cancel"};
						int n = JOptionPane.showOptionDialog(addPaintingAuction, "Are you sure you want to add this artust?",
								"Confirm Addition", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
						if(n == 0)
						{
							HandleArtist.createArtist(newArtist);
							cardLayout.show(getContentPane(), ARTIST_MM);
							addArtist.resetTextFields();
						}
					}
				}
			}
		});
	}
	
	/**
	 * Desc: sets up the addPaintingInventory to be set up and used in MainFrame
	 * Post: addPaintingInventory and its components are able to be used in MainFrame
	 */
	private void setUpAddPaintingInventory()
	{
		addPaintingInventory = new AddPaintingInventoryPanel();
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
					AuctionPainting newPainting = AddPaintingAuctionPanel.createNewAuctionPainting(addPaintingAuction.getFieldValues());
					AuctionPainting[] searchDBPainting = getCheckDBAuctionPainting(newPainting);
					AuctionPainting[][] checkPaintingsExists = {HandleAuctionPaintings.retrieveAuctionPaintings(searchDBPainting[0]),
							HandleAuctionPaintings.retrieveAuctionPaintings(searchDBPainting[1]) };
					if(checkPaintingsExists[0].length > 0 || checkPaintingsExists[1].length > 0)
						JOptionPane.showMessageDialog(addPaintingAuction, "Paintings Already Exists");
					else
					{
						Object[] options = {"Yes", "Cancel"};
						int n = JOptionPane.showOptionDialog(addPaintingAuction, "Are you sure you want to add this painting?",
								"Confirm Addition", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
						if(n == 0)
						{
							HandleAuctionPaintings.createAuctionPainting(newPainting);
							cardLayout.show(getContentPane(), AUCTION_MM);
							addPaintingAuction.resetTextFields();
						}
					}
			
				}
			}
		});
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
		calcMaxPurchase.getBtnCalcMaxPrice().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Check to make sure input is valid
				calcMaxPurchase.isInputValid();
				//setup painting form input info
				InventoryPainting painting=calcMaxPurchase.createNewInventoryPainting(calcMaxPurchase.getFieldValues());
				//double maxPurch = Calculations.calcMaxPurchasePrice(new painting);
				double maxPrice=Calculation.calcMaxPrice(painting);
				//if maxPurch = -1 don't allow to buy
				if(maxPrice<-5)
					JOptionPane.showMessageDialog(calcMaxPurchase, "No similar paintings do not buy");
				else if(maxPrice<0)
					JOptionPane.showMessageDialog(calcMaxPurchase, "No artist fashionability do not buy");
				else
					JOptionPane.showMessageDialog(calcMaxPurchase, "Max Price: "+maxPrice);
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
	 * Desc: sets up the completeSale to be set up and used in MainFrame
	 * Post: completeSale and its components are able to be used in MainFrame
	 */
	private void setUpCompleteSale()
	{
		completeSale = new CompleteSalePanel();
	}
	
	/**
	 * Desc: sets up the mainMenu to be set up and used in MainFrame
	 * Post: mainMenu and its components are able to be used in MainFrame
	 */
	private void setUpMainMenu()
	{
		mainMenu = new MainMenuPanel();
		mainMenu.getBtnSellPainting().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(),SEARCH_PAINTING_SALE);
			}
		});
		mainMenu.getBtnManageInventory().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), MANAGE_INVENTORY);
			}
		});
		mainMenu.getBtnManageArtists().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), ARTIST_MM);
			}
		});
		mainMenu.getBtnBuyPainting().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), CALC_MAX_PURCH);
			}
		});
		mainMenu.getBtnReportsPopup().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportGUI g = new ReportGUI();
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
	private void setUpArtistMM()
	{
		artistMM = new ManageArtistPanel();
		artistMM.getBtnBackToMain().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), MAIN_MENU);
			}
		});
		artistMM.getBtnAddNewArtist().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), ADD_ARTIST);
			}
		});
		artistMM.getBtnModifyDeleteExistingArtist().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchArtist.resetTextFields();
				cardLayout.show(getContentPane(), SEARCH_ARTIST);
			}
		});
		artistMM.getBtnSeeAllArtists().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Artist[] allArtists = HandleArtist.retrieveArtists(new Artist());
				seeAllArtists.updateTableModel(allArtists);
				cardLayout.show(getContentPane(), SEE_ALL_ARTISTS);
			}
		});		
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
				searchAuction.resetTextFields();
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
		manageInventoryMM.getReturnToMainButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), MAIN_MENU);
			}
		});
		manageInventoryMM.getAddNewPaintingButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), ADD_PAINTING_INVENTORY);
			}
		});
		manageInventoryMM.getModifyPaintingButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), SEARCH_INVENTORY);
			}
		});
		manageInventoryMM.getSeeAllPaintingsButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), SEE_ALL_INVENTORY);
			}
		});
	}
	
	/**
	 * Desc: sets up the searchAuction to be set up and used in MainFrame
	 * Post: searchAuction and its components are able to be used in MainFrame
	 */
	private void setUpSearchArtist()
	{
		searchArtist = new SearchArtistPanel();
		searchArtist.getBtnCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), ARTIST_MM);
				searchArtist.resetTextFields();
			}
		});
		searchArtist.getBtnSearchForArtist().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!searchArtist.isInputValid())
					JOptionPane.showMessageDialog(searchArtist, "Input is invalid, make sure all fields are correct");
				else
				{
					String[] fieldValues = searchArtist.getFieldValues();
					Artist searchTerms = SearchArtistPanel.createNewArtist(fieldValues);
					Artist[] searchResults = HandleArtist.retrieveArtists(searchTerms);
					if(searchResults.length == 0)
						JOptionPane.showMessageDialog(searchArtist, "No results found in search");
					else if(searchResults.length == 1)
					{
						updateArtist.updateTableModel(searchResults[0]);
						updateArtist.resetTextFields();
						cardLayout.show(getContentPane(), UPDATE_ARTIST);
					}
					else
					{
						searchResultsArtist.updateTableModel(searchResults);
						cardLayout.show(getContentPane(), SEARCH_RESULTS_ARTIST);
					}
				}
			}
		});
	}
	
	/**
	 * Desc: sets up the searchResultsAuction to be set up and used in MainFrame
	 * Post: searchResultsAuction and its components are able to be used in MainFrame
	 */
	private void setUpSearchResultsArtist()
	{
		searchResultsArtist = new SearchResultsArtistPanel();
		searchResultsArtist.getBtnSelect().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Artist selectedArtist = searchResultsArtist.getSelectedArtist();
				updateArtist.updateTableModel(selectedArtist);
				updateArtist.resetTextFields();
				cardLayout.show(getContentPane(), UPDATE_ARTIST);
			}
		});
		searchResultsArtist.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), SEARCH_ARTIST);
			}
		});
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
				searchAuction.resetTextFields();
				cardLayout.show(getContentPane(), AUCTION_MM);
			}
		});
		searchAuction.getBtnSearch().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!searchAuction.isInputValid())
				{
					JOptionPane.showMessageDialog(searchAuction, "Input is invalid, make sure all fields are correct");
				}
				else
				{
					//if searchResults > 1 go straight to update screen
					String[] fieldValues = searchAuction.getFieldValues();
					AuctionPainting searchTerms = SearchAuctionPanel.createNewAuctionPainting(fieldValues);
					AuctionPainting[] searchResults = HandleAuctionPaintings.retrieveAuctionPaintings(searchTerms);
					if(searchResults.length == 0)
					{
						JOptionPane.showMessageDialog(searchAuction, "No results found in search");
					}
					else if(searchResults.length == 1)
					{
						updateAuction.updateTableModel(searchResults[0]);
						updateAuction.resetTextFields();
						cardLayout.show(getContentPane(), UPDATE_AUCTION);
					}
					else
					{
						searchResultsAuction.updateSearchResultsList(searchResults);
						cardLayout.show(getContentPane(), SEARCH_RESULTS_AUCTION);
					}					
				}
				
					
			}
		});
	}
	
	
	/**
	 * Desc: sets up the searchResultsAuction to be set up and used in MainFrame
	 * Post: searchResultsAuction and its components are able to be used in MainFrame
	 */
	private void setUpSearchResultsAuction()
	{
		searchResultsAuction = new SearchResultsAuctionPanel();
		searchResultsAuction.getBtnSelect().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuctionPainting updatePainting = searchResultsAuction.getSelectedPainting();
				updateAuction.updateTableModel(updatePainting);
				updateAuction.resetTextFields();
				cardLayout.show(getContentPane(), UPDATE_AUCTION);
			}
		});
		searchResultsAuction.getBtnCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(getContentPane(), SEARCH_AUCTION);
			}
		});
	}
	
	/**
	 * Desc: sets up the searchPaintingSale to be set up and used in MainFrame
	 * Post: searchPaintingSale and its components are able to be used in MainFrame
	 */
	private void setUpSearchPaintingSale()
	{
		searchPaintingSale = new SearchPaintingSale();
		searchPaintingSale.getBtnCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), MAIN_MENU);
			}
		});
		searchPaintingSale.getBtnSelectPainting().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	
	/**
	 * Desc: sets up the searchInventory to be set up and used in MainFrame
	 * Post: searchInventory and its components are able to be used in MainFrame
	 */
	private void setUpSearchInventory()
	{
		searchInventory = new SearchInventoryPanel();
	}
	
	/**
	 * Desc: sets up the seeAllArtists to be set up and used in MainFrame
	 * Post: seeAllArtists and its components are able to be used in MainFrame
	 */
	private void setUpSeeAllArtists()
	{
		seeAllArtists = new SeeAllArtistsPanel();
		seeAllArtists.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), ARTIST_MM);
			}
		});
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
	 * Desc: sets up the seeAllAuction to be set up and used in MainFrame
	 * Post: seeAllAuction and its components are able to be used in MainFrame
	 */
	private void setUpSeeAllInventory()
	{
		seeAllInventory = new SeeAllInventoryPanel();
	}
	
	/**
	 * Desc: sets up the updateArtist to be set up and used in MainFrame
	 * Post: updateArtist and its components are able to be used in MainFrame
	 */
	private void setUpUpdateArtist()
	{
		updateArtist = new UpdateArtistPanel();
		updateArtist.getBtnCancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), ARTIST_MM);
			}
		});
		updateArtist.getBtnSaveChanges().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!updateArtist.isInputValid())
					JOptionPane.showMessageDialog(updateArtist, "No fields have been updated.");
				else
				{
					Object[] options = {"Yes", "Cancel"};
					int n = JOptionPane.showOptionDialog(updateArtist, "Are you sure you want to update this artist?",
							"Confirm Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
					if(n == 1)
					{
						Artist origArtist = updateArtist.getOrigArtist();
						Artist changeArtist = new Artist();
						Artist[] checkArtistExists = HandleArtist.retrieveArtists(origArtist);
						if(checkArtistExists.length > 0)
							JOptionPane.showMessageDialog(addArtist, "Artist already exists.");
						else
						{
							try {
								changeArtist = origArtist.clone();
							} catch (CloneNotSupportedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							updateArtist.updateArtist(changeArtist);
							HandleArtist.updateArtist(changeArtist, origArtist);
							cardLayout.show(getContentPane(), ARTIST_MM);
						}
					}
				}					
			}
		});
		updateArtist.getBtnDeleteArtist().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = {"Yes", "Cancel"};
				int n = JOptionPane.showOptionDialog(updateAuction, "Are you sure you want to delete this artist?",
						"Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(n == 0)
				{
					HandleArtist.deleteArtist(updateArtist.getOrigArtist());
					cardLayout.show(getContentPane(), ARTIST_MM);
					
				}
			}
		});
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
				int n = JOptionPane.showOptionDialog(updateAuction, "Are you sure you want to delete this painting?",
						"Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(n == 0)
				{
					HandleAuctionPaintings.deleteAuctionPainting(updateAuction.getOrigPainting());
					cardLayout.show(getContentPane(), AUCTION_MM);
				}
			}
		});
		updateAuction.getBtnSaveChanges().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!updateAuction.isEditValid())
					JOptionPane.showMessageDialog(updateAuction, "No fields have been updated.");
				else
				{
					Object[] options = {"Yes", "Cancel"};
					int n = JOptionPane.showOptionDialog(updateAuction, "Are you sure you want to update this painting?",
							"Confirm Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
					if(n == 0)
					{
						AuctionPainting origPainting = updateAuction.getOrigPainting();						
						AuctionPainting updatePainting = new AuctionPainting();
						try {
							updatePainting = origPainting.clone();
						} catch (CloneNotSupportedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						updateAuction.updateAuctionPainting(updatePainting);
						HandleAuctionPaintings.updateAuctionPainting(updatePainting, origPainting);
						cardLayout.show(getContentPane(), AUCTION_MM);
					}
				}
			}
		});
	}
	
	/**
	 * Desc: sets up the updateInventory to be set up and used in MainFrame
	 * Post: updateInventory and its components are able to be used in MainFrame
	 */
	private void setUpUpdateInventory()
	{
		InventoryPainting stubPainting = new InventoryPainting();
		updateInventory = new UpdateInventoryPanel();
	}
	
	/**
	 * Desc: Takes an AuctionPainting and returns an AuctionPainting[2] that will
	 * 		 be used to search for a duplicate painting.
	 * Return: An AuctionPainting[2] with just the artistFirstName, artistLastName,
	 * 		   titleOfWork, and dateOfWork set. Only variance between two elements
	 * 		   is the one dateOfWork has ? and other does not.
	 */
	public static AuctionPainting[] getCheckDBAuctionPainting(AuctionPainting orig)
	{
		AuctionPainting[] searchDBPainting = new AuctionPainting[2];
		searchDBPainting[0] = new AuctionPainting();		
		searchDBPainting[0].setArtistFirstName(orig.getArtistFirstName());
		searchDBPainting[0].setArtistLastName(orig.getArtistLastName());;
		searchDBPainting[0].setTitleOfWork(orig.getTitleOfWork());
		searchDBPainting[0].setDateOfWork(orig.getDateOfWork());
		searchDBPainting[1] = new AuctionPainting();
		searchDBPainting[1].setArtistFirstName(orig.getArtistFirstName());
		searchDBPainting[1].setArtistLastName(orig.getArtistLastName());;
		searchDBPainting[1].setTitleOfWork(orig.getTitleOfWork());
		String date = "";
		if(orig.getDateOfWork().contains("?"))
			date = orig.getDateOfWork().replaceAll("\\?", "");
		else
			date = orig.getDateOfWork() + "?";
		searchDBPainting[1].setDateOfWork(date);
		return searchDBPainting;
	}
	
	/**
	 * 
	 */
	public static Artist getCheckDBArtist(Artist orig)
	{
		Artist checkArtist = new Artist();
		checkArtist.setArtistFirstName(orig.getArtistFirstName());
		checkArtist.setArtistLastName(orig.getArtistLastName());
		return checkArtist;
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
