import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.GridBagLayout;

public class MainFrame extends JFrame {

	private GridBagLayout gridBagLayout;
	private AddPaintingAuctionPanel addPainting;
	private MainMenuPanel mainMenu;
	private ManageAuctionMainMenuPanel auctionMM;
	private SearchAuctionPanel searchAuction;
	private SeeAllPaintingsPanel seeAllAuction;
	private UpdateAuctionPanel updateAuction;

	// constants to change panels
	public static int TO_BUY_PAINTING = 0;
	public static int TO_SELL_PAINTING = 1;
	public static int TO_MANAGE_ARTISTS = 2;
	public static int TO_MANAGE_AUCTION = 3;
	public static int TO_MANAGE_INVENTORY = 4;
	public static int POPUP_RECORDS = 5;
	
	/*
	 * Desc: Initializes the MainFrame object
	 */
	public MainFrame() {
		addPainting = new AddPaintingAuctionPanel();
		mainMenu = new MainMenuPanel();
		auctionMM = new ManageAuctionMainMenuPanel();
		searchAuction = new SearchAuctionPanel();
		seeAllAuction = new SeeAllPaintingsPanel();
		updateAuction = new UpdateAuctionPanel();

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

		getContentPane().setLayout(new CardLayout());
		getContentPane().add(mainMenu);
		getContentPane().add(auctionMM);
		getContentPane().add(seeAllAuction);
		getContentPane().add(updateAuction);
		getContentPane().add(addPainting);
		getContentPane().add(searchAuction);
	}
	

	/**
	 * Desc: Main method to run the whole program.
	 * @param args
	 */
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.show();
	}

}
