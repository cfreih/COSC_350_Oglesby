import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JList;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class SearchResultsAuctionPanel extends JPanel {
	
	private GridBagLayout gridBagLayout;
	private JButton btnSelect;
	private JButton btnCancel;
	private JScrollPane scrollPaneList;
	private AuctionPainting[] searchResults;
	private JTable table;
	private AuctionPainting origPainting;
	private DefaultTableModel tableModel;
	
	public SearchResultsAuctionPanel() {
		
		gridBagLayout = new GridBagLayout();
		scrollPaneList = new JScrollPane();
		btnSelect = new JButton("Select");
		btnCancel = new JButton("Cancel");
		
		setUpPanel();
	}
	
	public void setUpPanel()
	{
		setBorder(new TitledBorder(null, "Manage Auction", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		gridBagLayout.columnWidths = new int[]{0, 325, 0, 0, 325, 0};
		gridBagLayout.rowHeights = new int[]{0, 400, 0, 34, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		GridBagConstraints gbc_scrollPaneList = new GridBagConstraints();
		gbc_scrollPaneList.gridwidth = 4;
		gbc_scrollPaneList.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneList.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneList.gridx = 1;
		gbc_scrollPaneList.gridy = 1;
		add(scrollPaneList, gbc_scrollPaneList);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		origPainting = new AuctionPainting();
		tableModel = new DefaultTableModel(new Object[][] { origPainting.toTableRow() },
				new String[] { "Artist First Name", "Arist Last Name", "Title",
						"Date of Work", "Date of Sale", "Sale Price", "Height",
						"Width", "Medium", "Subject" }) {
			Class[] columnTypes = new Class[] { String.class, String.class,
					String.class, Integer.class, Object.class, Double.class,
					Integer.class, Integer.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false,
					false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};		

		scrollPaneList.setViewportView(table);
		
		
		btnSelect.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.fill = GridBagConstraints.BOTH;
		gbc_btnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelect.gridx = 1;
		gbc_btnSelect.gridy = 3;
		add(btnSelect, gbc_btnSelect);
		
				
		btnCancel.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.BOTH;
		gbc_btnCancel.gridx = 4;
		gbc_btnCancel.gridy = 3;
		add(btnCancel, gbc_btnCancel);
	}
	
	public void updateTableModel(AuctionPainting[] aucPaintings)
	{
		 searchResults=aucPaintings;
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
	public AuctionPainting getSelectedAuctionPainting()
    {
        int row = table.getSelectedRow();
        if(row == -1)
            return new AuctionPainting();
        else
            return searchResults[row];
    }
	public JButton getBtnSelect() {
		return btnSelect;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
	public static void main(String[] args) {
        JFrame f = new JFrame("test window");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setSize(800, 600);
        f.setLocation(10, 10);
        SearchResultsAuctionPanel panel =new SearchResultsAuctionPanel();
        f.getContentPane().add(panel);
        f.setVisible(true);
        AuctionPainting[] invP = new AuctionPainting[25];
        for(int i=0; i <= invP.length-1; ++i){

            invP[i] = new AuctionPainting( "firstName","lastName","title","date",22.8,36.8,"med","subj",40000,new SimpleDate());
        }
        panel.updateTableModel(invP);
    }
}
