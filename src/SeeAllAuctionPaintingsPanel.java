import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;

import javax.swing.JTable;

/**

/**
 * @author Clint
 * 
 */
public class SeeAllAuctionPaintingsPanel extends JPanel {

	//private JTable paintingsTable;
	private SpringLayout springLayout;
	private JButton btnBack;
	private JScrollPane listScroll;
	private GridBagLayout gridBagLayout;
	
	AuctionPainting[] allAP;
	private JTable table;

	
	public SeeAllAuctionPaintingsPanel() {
		/*paintingsTable = new JTable();
		springLayout = new SpringLayout();
		scrollPane = new JScrollPane(paintingsTable);*/
		allAP = HandleAuctionPaintings.retrieveAuctionPaintings(new AuctionPainting());
		listScroll = new JScrollPane();		
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
		GridBagConstraints gbc_listAllAP = new GridBagConstraints();
		gbc_listAllAP.gridwidth = 2;
		gbc_listAllAP.fill = GridBagConstraints.BOTH;
		gbc_listAllAP.insets = new Insets(0, 0, 5, 5);
		gbc_listAllAP.gridx = 1;
		gbc_listAllAP.gridy = 1;
		add(listScroll, gbc_listAllAP);
		
		table = new JTable();
		listScroll.setViewportView(table);

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
	public void updateTableModel(AuctionPainting[] aucPaintings)
	{		 
	        Object[][] dataVector= new Object[aucPaintings.length][20];
	        for(int i=0; i <= aucPaintings.length-1; i++){
	            dataVector[i]=aucPaintings[i].toTableRow();
	        }
		String[] columnNames = new String[] { "Artist First Name", "Arist Last Name", "Title",
				"Date of Work", "Date of Sale", "Sale Price", "Height",
				"Width", "Medium", "Subject" };
		TableModel model = new DefaultTableModel(dataVector, columnNames)
		{
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		};		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(model);	
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
