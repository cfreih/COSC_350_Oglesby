import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;

/**

/**
 * @author Clint
 * 
 */
public class SeeAllAuctionPaintingsPanel extends JPanel {

	//private JTable paintingsTable;
	private SpringLayout springLayout;
	private JButton btnBack;
	//private JScrollPane scrollPane;
	private JList listAllAP;
	private JScrollPane listScroll;
	private GridBagLayout gridBagLayout;
	
	AuctionPainting[] allAP;

	
	public SeeAllAuctionPaintingsPanel() {
		/*paintingsTable = new JTable();
		springLayout = new SpringLayout();
		scrollPane = new JScrollPane(paintingsTable);*/
		allAP = HandleAuctionPaintings.retrieveAuctionPaintings(new AuctionPainting());
		listAllAP = new JList<Object>(allAP);
		listScroll = new JScrollPane(listAllAP);		
		btnBack = new JButton("Back");
		gridBagLayout = new GridBagLayout();

		setUpPanel();
	}

	public void setUpPanel() {
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "Manage Auction Records",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		gridBagLayout.columnWidths = new int[] { 34, 355, 355, 0 };
		gridBagLayout.rowHeights = new int[] { 45, 425, 43, 35, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
		listAllAP.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAllAP.setVisibleRowCount(40);
		listAllAP.setSize(new Dimension(1, 40));
		listAllAP.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_listAllAP = new GridBagConstraints();
		gbc_listAllAP.gridwidth = 2;
		gbc_listAllAP.fill = GridBagConstraints.BOTH;
		gbc_listAllAP.insets = new Insets(0, 0, 5, 5);
		gbc_listAllAP.gridx = 1;
		gbc_listAllAP.gridy = 1;
		add(listScroll, gbc_listAllAP);

		btnBack.setSize(new Dimension(150, 35));
		btnBack.setMnemonic('B');
		btnBack.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.WEST;
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.fill = GridBagConstraints.VERTICAL;
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 3;
		add(btnBack, gbc_btnBack);
	}
	
	/**
	 * Desc: Updates the list to include all elements.
	 * Post: listAllAP contains all elements of the auction records.
	 */
	public void updateList()
	{
		allAP = HandleAuctionPaintings.retrieveAuctionPaintings(new AuctionPainting());
		listAllAP.setListData(allAP);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("test window");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setSize(800, 600);
		f.setLocation(10, 10);
		f.getContentPane().add(new SeeAllAuctionPaintingsPanel());
		f.setVisible(true);
		

	}
	
	
	
	public JButton getBtnBack() {
		return btnBack;
	}
}
