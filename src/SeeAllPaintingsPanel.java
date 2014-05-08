import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

/**
 * 
 */

/**
 * @author Clint
 *
 */
public class SeeAllPaintingsPanel extends JPanel {
	
	private JTable paintingsTable;
	private SpringLayout springLayout;
	private JButton btnBack;
	JScrollPane scrollPane;
	
	public SeeAllPaintingsPanel()
	{		
		paintingsTable = new JTable();
		springLayout = new SpringLayout();
		btnBack = new JButton("Back");
		scrollPane = new JScrollPane(paintingsTable);
		
		
		setUpPanel();
	}
	
	public void setUpPanel()
	{
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new TitledBorder(null, "Manage Auction Records", TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		
		/*
		 * Need to set up the Object array using event handlers to get all of the paintings.
		 * the following is currently pseudocode to do that
		 */
		//AuctionPainting[] allAP = HandleAuctionPainting.retrieveArtists(AuctionPainting to get all Paintings)
		//Object[][] tableInfo = new Object[allAP.size][10];
		//for(int i = 0; i < tableInfo.size; i++)
		//{
		//	tableInfo[i][0] = allAP[i].getArtistFirstName();
		//	tableInfo[i][1] = allAP[i].getArtistLastName();
		//	tableInfo[i][2] = allAP[i].getTitleOfWork();
		//	tableInfo[i][3] = (Integer) allAP[i].getDateOfWork();
		//	...
		//	tableInfo[i][9] = allAP[i].getSubject();
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 498, SpringLayout.NORTH, this);
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 790, SpringLayout.WEST, this);
		add(scrollPane);
		paintingsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		paintingsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", null, null, null, null, null, null, null},
			},
			new String[] {
				"Artist First Name", "Arist Last Name", "Title", "Date of Work", "Date of Sale", "Sale Price", "Height", "Width", "Medium", "Subject"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, Object.class, Double.class, Integer.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		paintingsTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		paintingsTable.getColumnModel().getColumn(1).setPreferredWidth(90);
		paintingsTable.getColumnModel().getColumn(2).setPreferredWidth(180);
		paintingsTable.getColumnModel().getColumn(4).setPreferredWidth(90);
		paintingsTable.setFont(new Font("Century", Font.PLAIN, 12));
		paintingsTable.setCellSelectionEnabled(true);
		
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, 6, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 0, SpringLayout.WEST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, -34, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnBack, 160, SpringLayout.WEST, this);
		btnBack.setFont(new Font("Century", Font.PLAIN, 12));
		add(btnBack);
	}
}
