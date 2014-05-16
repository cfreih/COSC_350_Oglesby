import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class SearchResultsSalePanel extends JPanel {
	private JTable paintingsTable;
	private DefaultTableModel tableModel;
	private InventoryPainting[] searchedPaintings;
	private JButton btnBack;
	private JButton btnSelect;
	
	public SearchResultsSalePanel() {
		
		setUpPanel();
		
	}
	public void setUpPanel(){
		this.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search Results", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200, 175, 0, 175, 200, 0};
		gridBagLayout.rowHeights = new int[]{33, 464, 22, 34, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		tableModel =new DefaultTableModel(
				new Object[][] {
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					},
					new String[] {
						"Last Name", "First Name", "Title", "Date of Work", "Classification", "Height", "Width", "Medium", "Subject", "Date of Prucahse", "Name of Seller", "Address of Seller", "Maximun Purchase Price", "Actual Purchase Price", "Target Selling Price", "Date of Sale", "Name of Buyer", "Address of Buyer", "Actual Selling Price", "New column"
					}
				);
		paintingsTable = new JTable();
		paintingsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Last Name", "First Name", "Title", "Date of Work", "Classification", "Height", "Width", "Medium", "Subject", "Date of Prucahse", "Name of Seller", "Address of Seller", "Maximun Purchase Price", "Actual Purchase Price", "Target Selling Price", "Date of Sale", "Name of Buyer", "Address of Buyer", "Actual Selling Price", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		paintingsTable.getColumnModel().getColumn(9).setPreferredWidth(96);
		paintingsTable.getColumnModel().getColumn(10).setPreferredWidth(92);
		paintingsTable.getColumnModel().getColumn(11).setPreferredWidth(95);
		paintingsTable.getColumnModel().getColumn(12).setPreferredWidth(139);
		paintingsTable.getColumnModel().getColumn(13).setPreferredWidth(122);
		paintingsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(paintingsTable);
		
		btnSelect = new JButton("Select");
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.fill = GridBagConstraints.BOTH;
		gbc_btnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelect.gridx = 1;
		gbc_btnSelect.gridy = 3;
		add(btnSelect, gbc_btnSelect);
		
		btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.gridx = 3;
		gbc_btnBack.gridy = 3;
		add(btnBack, gbc_btnBack);
		
	}
	public void updateTableModel(InventoryPainting[] invPaintings){
		searchedPaintings=invPaintings;
		Object[][] dataVector= new Object[invPaintings.length][20];
		for(int i=0; i <= invPaintings.length-1; i++){
			dataVector[i]=invPaintings[i].toTableRow();
		}		
		//Object[][] dataVector = {invPainintgs[0].toTableRow(),invPainintgs[1].toTableRow(),invPainintgs[2].toTableRow(),invPainintgs[3].toTableRow(),invPainintgs[4].toTableRow()};
		
		String[] columnNames = new String[] {
				"Artist First Name", "Arist Last Name", "Title", "Date of Work",
				"Classification", "Height", "Width", "Medium", "Subject",
				"Date of Purchase", "Name of Seller", "Address of Seller",
				"Maximun Purchase Price", "Actual Purchase Price", "Target Selling Price",
				"Date of Sale", "Name of Buyer", "Address of Buyer", "Actual Selling Price"};
		TableModel model = new DefaultTableModel(dataVector, columnNames)
		{
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		};		
		paintingsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		paintingsTable.setModel(model);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("test window");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setSize(800, 600);
		f.setLocation(10, 10);
		SearchResultsSalePanel panel =new SearchResultsSalePanel();
		f.getContentPane().add(panel);
		f.setVisible(true);
		InventoryPainting[] invP = new InventoryPainting[25];
		for(int i=0; i <= invP.length-1; ++i){
			
			invP[i] = new InventoryPainting( "firstName","lastName","title","date",22.8,36.8,"med","subj","sName","sAddress",new SimpleDate(),15222.0, 175545.2,new SimpleDate(),"bName", "bAddress", 589999.0,
					"classif");			
		}
		panel.updateTableModel(invP);
	}
	public InventoryPainting getSelectedSalePainting()
	{
		int row = paintingsTable.getSelectedRow();
		if(row == -1)
			return new InventoryPainting();
		else
			return searchedPaintings[row];
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public JButton getBtnSelect() {
		return btnSelect;
	}
}
