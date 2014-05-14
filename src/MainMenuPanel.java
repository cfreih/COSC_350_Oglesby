import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MainMenuPanel extends JPanel {

	private JButton btnBuyPainting;
	private JButton btnSellPainting;
	private JButton btnManageArtists;
	private JButton btnManageAuctionRecords;
	private JButton btnManageInventory;
	private JButton btnReportsPopup;
	private JButton btnExit;
	private JLabel lblLesObjectsDorient;
	
	/**
	 * Create the panel.
	 */
	public MainMenuPanel() 
	{
		btnBuyPainting = new JButton("Buy Painting");	
		btnSellPainting = new JButton("Sell Painting");
		btnSellPainting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		lblLesObjectsDorient = new JLabel("Les Objects d'Orient");
		btnManageArtists = new JButton("Manage Artists");
		btnManageAuctionRecords = new JButton("Manage Auction Records");
		btnManageInventory = new JButton("Manage Inventory");
		btnReportsPopup = new JButton("Reports Popup");
		btnExit = new JButton("Exit");
		
		setUpPanel();
	}
	
	public void setUpPanel()
	{
		setBorder(new TitledBorder(null, "Main Menu", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{46, 171, 149, 212, 0};
		gridBagLayout.rowHeights = new int[]{30, 40, 33, 40, 32, 40, 33, 40, 33, 40, 33, 40, 61, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
				
		
		btnBuyPainting.setMnemonic('B');
		btnBuyPainting.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_btnBuyPainting = new GridBagConstraints();
		gbc_btnBuyPainting.fill = GridBagConstraints.BOTH;
		gbc_btnBuyPainting.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuyPainting.gridx = 1;
		gbc_btnBuyPainting.gridy = 1;
		add(btnBuyPainting, gbc_btnBuyPainting);
		
		
		btnSellPainting.setMnemonic('S');
		btnSellPainting.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_btnSellPainting = new GridBagConstraints();
		gbc_btnSellPainting.fill = GridBagConstraints.BOTH;
		gbc_btnSellPainting.insets = new Insets(0, 0, 5, 5);
		gbc_btnSellPainting.gridx = 1;
		gbc_btnSellPainting.gridy = 3;
		add(btnSellPainting, gbc_btnSellPainting);
		
		
		lblLesObjectsDorient.setFont(new Font("Dialog", Font.ITALIC, 32));
		GridBagConstraints gbc_lblLesObjectsDorient = new GridBagConstraints();
		gbc_lblLesObjectsDorient.gridheight = 2;
		gbc_lblLesObjectsDorient.anchor = GridBagConstraints.WEST;
		gbc_lblLesObjectsDorient.insets = new Insets(0, 0, 5, 0);
		gbc_lblLesObjectsDorient.gridx = 3;
		gbc_lblLesObjectsDorient.gridy = 3;
		add(lblLesObjectsDorient, gbc_lblLesObjectsDorient);
		
		
		btnManageArtists.setFont(new Font("Century", Font.PLAIN, 12));
		btnManageArtists.setMnemonic('A');
		GridBagConstraints gbc_btnManageArtists = new GridBagConstraints();
		gbc_btnManageArtists.fill = GridBagConstraints.BOTH;
		gbc_btnManageArtists.insets = new Insets(0, 0, 5, 5);
		gbc_btnManageArtists.gridx = 1;
		gbc_btnManageArtists.gridy = 5;
		add(btnManageArtists, gbc_btnManageArtists);
				
		
		btnManageAuctionRecords.setMnemonic('R');
		btnManageAuctionRecords.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_btnManageAuctionRecords = new GridBagConstraints();
		gbc_btnManageAuctionRecords.anchor = GridBagConstraints.WEST;
		gbc_btnManageAuctionRecords.fill = GridBagConstraints.VERTICAL;
		gbc_btnManageAuctionRecords.insets = new Insets(0, 0, 5, 5);
		gbc_btnManageAuctionRecords.gridx = 1;
		gbc_btnManageAuctionRecords.gridy = 7;
		add(btnManageAuctionRecords, gbc_btnManageAuctionRecords);
		
		
		btnManageInventory.setFont(new Font("Century", Font.PLAIN, 12));
		btnManageInventory.setMnemonic('I');
		GridBagConstraints gbc_btnManageInventory = new GridBagConstraints();
		gbc_btnManageInventory.fill = GridBagConstraints.BOTH;
		gbc_btnManageInventory.insets = new Insets(0, 0, 5, 5);
		gbc_btnManageInventory.gridx = 1;
		gbc_btnManageInventory.gridy = 9;
		add(btnManageInventory, gbc_btnManageInventory);
		
		
		btnReportsPopup.setMnemonic('R');
		btnReportsPopup.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_btnReportsPopup = new GridBagConstraints();
		gbc_btnReportsPopup.fill = GridBagConstraints.BOTH;
		gbc_btnReportsPopup.insets = new Insets(0, 0, 5, 5);
		gbc_btnReportsPopup.gridx = 1;
		gbc_btnReportsPopup.gridy = 11;
		add(btnReportsPopup, gbc_btnReportsPopup);
		
		
		btnExit.setFont(new Font("Century", Font.PLAIN, 12));
		btnExit.setMnemonic('x');
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.fill = GridBagConstraints.BOTH;
		gbc_btnExit.insets = new Insets(0, 0, 0, 5);
		gbc_btnExit.gridx = 1;
		gbc_btnExit.gridy = 13;
		add(btnExit, gbc_btnExit);
	}
	
	/**
	 * Desc: Registers listers for the different action events
	 *
	public void registerListeners()
	{
		btnBuyPainting.addActionListener(this);
		btnSellPainting.addActionListener(this);
		btnManageArtists.addActionListener(this);
		btnManageAuctionRecords.addActionListener(this);
		btnManageInventory.addActionListener(this);
		btnReportsPopup.addActionListener(this);
		btnExit.addActionListener(this);
	}*/


	public JButton getBtnManageAuctionRecords() {
		return btnManageAuctionRecords;
	}
	public JButton getBtnBuyPainting() {
		return btnBuyPainting;
	}
	public JButton getBtnSellPainting() {
		return btnSellPainting;
	}
	public JButton getBtnManageArtists() {
		return btnManageArtists;
	}
	public JButton getBtnManageInventory() {
		return btnManageInventory;
	}
	public JButton getBtnReportsPopup() {
		return btnReportsPopup;
	}
	public JButton getBtnExit() {
		return btnExit;
	}
}
