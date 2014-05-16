import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;


public class SeeAllInventoryPanel extends JPanel {
	private JTable paintingsTable;
	private DefaultTableModel tableModel;
	private JButton btnBack;
	
	public SeeAllInventoryPanel() {
		
		setUpPanel();
		
	}
	public void setUpPanel(){
		this.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new TitledBorder(UIManager.getBorder("TitledBorder.border"), "See All Paintings in Inventory", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 15, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -40, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -15, SpringLayout.EAST, this);
		add(scrollPane);
		
		paintingsTable = new JTable();
		tableModel =new DefaultTableModel(
				new Object[][] {
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					},
					new String[] {
						"Last Name", "First Name", "Title", "Date of Work", "Classification", "Height", "Width", "Medium", "Subject", "Date of Prucahse", "Name of Seller", "Address of Seller", "Maximun Purchase Price", "Actual Purchase Price", "Target Selling Price", "Date of Sale", "Name of Buyer", "Address of Buyer", "Actual Selling Price", "New column"
					}
				);
		paintingsTable.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                },
                new String[]{
                        "Last Name", "First Name", "Title", "Date of Work", "Classification", "Height", "Width", "Medium", "Subject", "Date of Prucahse", "Name of Seller", "Address of Seller", "Maximun Purchase Price", "Actual Purchase Price", "Target Selling Price", "Date of Sale", "Name of Buyer", "Address of Buyer", "Actual Selling Price"
                }
        )
        {
            boolean[] columnEditables = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column)
            {
                return columnEditables[column];
            }
        });
		paintingsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(paintingsTable);
		
		btnBack = new JButton("Back");
        btnBack.setFont(new Font("Cambria", Font.BOLD, 12));
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, 5, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, scrollPane);
		add(btnBack);
	}
	public void updateTableModel(InventoryPainting[] invPainintgs){
		Object[][] dataVector= new Object[invPainintgs.length][19];
		
		for(int i=0; i <= invPainintgs.length-1; i++){
		
			dataVector[i]=invPainintgs[i].toTableRow();
		
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
		paintingsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		paintingsTable.setModel(model);
		paintingsTable.getColumnModel().getColumn(0).setMinWidth(100);
		paintingsTable.getColumnModel().getColumn(1).setMinWidth(100);
		paintingsTable.getColumnModel().getColumn(2).setMinWidth(150);
		paintingsTable.getColumnModel().getColumn(3).setMinWidth(75);
		paintingsTable.getColumnModel().getColumn(4).setMinWidth(75);
		paintingsTable.getColumnModel().getColumn(5).setMinWidth(75);
		paintingsTable.getColumnModel().getColumn(6).setMinWidth(75);
		paintingsTable.getColumnModel().getColumn(7).setMinWidth(100);
		paintingsTable.getColumnModel().getColumn(8).setMinWidth(100);		
		paintingsTable.getColumnModel().getColumn(9).setMinWidth(96);
		paintingsTable.getColumnModel().getColumn(10).setMinWidth(92);
		paintingsTable.getColumnModel().getColumn(11).setMinWidth(95);
		paintingsTable.getColumnModel().getColumn(12).setMinWidth(139);
		paintingsTable.getColumnModel().getColumn(13).setMinWidth(122);
		paintingsTable.getColumnModel().getColumn(14).setMinWidth(105);
		paintingsTable.getColumnModel().getColumn(15).setMinWidth(75);
		paintingsTable.getColumnModel().getColumn(16).setMinWidth(89);
		paintingsTable.getColumnModel().getColumn(17).setMinWidth(101);
		paintingsTable.getColumnModel().getColumn(18).setMinWidth(105);		
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("test window");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setSize(800, 600);
		f.setLocation(10, 10);
		SeeAllInventoryPanel panel =new SeeAllInventoryPanel();
		f.getContentPane().add(panel);
		f.setVisible(true);
		InventoryPainting[] invP = new InventoryPainting[25];
		for(int i=0; i <= invP.length-1; ++i){
			
			invP[i] = new InventoryPainting( "firstName","lastName","title","date",22.8,36.8,"med","subj","sName","sAddress",new SimpleDate(),15222.0, 175545.2,new SimpleDate(),"bName", "bAddress", 589999.0,
					"classif");			
		}
		panel.updateTableModel(invP);
	}
	public JButton getBtnBack() {
		return btnBack;
	}
}
