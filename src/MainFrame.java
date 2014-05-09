import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener{

	private GridBagLayout gridBagLayout;
	private AddPaintingAuctionPanel addPaintingAuction;
	private MainMenuPanel mainMenu;
	private ManageAuctionMainMenuPanel auctionMM;
	private SearchAuctionPanel searchAuction;
	private SeeAllPaintingsPanel seeAllAuction;
	private UpdateAuctionPanel updateAuction;
	private CardLayout cardLayout;

	// constants to change panels
	public static int TO_BUY_PAINTING = 0;
	public static int TO_SELL_PAINTING = 1;
	public static int TO_MANAGE_ARTISTS = 2;
	public static int TO_MANAGE_AUCTION = 3;
	public static int TO_MANAGE_INVENTORY = 4;
	public static int POPUP_RECORDS = 5;
	
	//constants to be used for indicating a panel
	public static String AUCTION_MM = "Auction Main Menu";
	public static String MAIN_MENU = "Maine Menu";
	public static String SEE_ALL_AUCTION = "See All Auction";
	public static String UPDATE_AUCTION = "Update Auction";
	public static String ADD_PAINTING_AUCTION = "Add Painting Auction";
	public static String SEARCH_AUCTION = "Search Auction";
	
	
	/*
	 * Desc: Initializes the MainFrame object
	 */
	public MainFrame() {
		setUpAddPaintingAuction();	
		setUpMainMenu();
		setUpAuctionMM();
		setUpSearchAuction();
		setUpSeeAllAuction();
		setUpUpdateAuction();
		cardLayout = new CardLayout();

		setUpFrame();
	}

	/**
	 * Desc: sets up the Frame for MainFrame
	 */
	public void setUpFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	}
	
	/**
	 * Desc: sets up the addPaintingAuctionPanel to be set up and used in MainFrame
	 * Post: auctionMM and its components are able to be used in MainFrame
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
						//HandleAuctionPaintings.createAuctionPainting(AddPaintingAuctionPanel.createNewAuctionPainting(addPaintingAuction.getFieldValues()));
						cardLayout.show(getContentPane(), AUCTION_MM);
						addPaintingAuction.resetTextFields();
					}
			
				}
			}
		});
	}
	
	/**
	 * Desc: sets up the mainMenu to be set up and used in MainFrame
	 * Post: mainMenu and its components are able to be used in MainFrame
	 */
	private void setUpMainMenu()
	{
		mainMenu = new MainMenuPanel();
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
				cardLayout.show(getContentPane(), SEE_ALL_AUCTION);
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
	
	/**
	 * Desc: sets up the seeAllAuction to be set up and used in MainFrame
	 * Post: seeAllAuction and its components are able to be used in MainFrame
	 */
	private void setUpSeeAllAuction()
	{
		seeAllAuction = new SeeAllPaintingsPanel();
		seeAllAuction.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(getContentPane(), AUCTION_MM);
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
		f.show();
	}

	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
