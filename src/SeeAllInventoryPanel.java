import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;


public class SeeAllInventoryPanel extends JPanel {
	private JTable paintingsTable;
	
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
		paintingsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Last Name", "First Name", "Title", "Date of Work", "Classification", "Height", "Width", "Medium", "Subject", "Date of Prucahse", "Name of Seller", "Address of Seller", "Maximun Purchase Price", "Actual Purchase Price", "Target Selling Price", "Date of Sale", "Name of Buyer", "Address of Buyer", "Actual Selling Price", "New column"
			}
		));
		paintingsTable.getColumnModel().getColumn(9).setPreferredWidth(96);
		paintingsTable.getColumnModel().getColumn(10).setPreferredWidth(92);
		paintingsTable.getColumnModel().getColumn(11).setPreferredWidth(95);
		paintingsTable.getColumnModel().getColumn(12).setPreferredWidth(139);
		paintingsTable.getColumnModel().getColumn(13).setPreferredWidth(122);
		paintingsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(paintingsTable);
		
		JButton btnBack = new JButton("Back");
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, 5, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, scrollPane);
		add(btnBack);
	}
}
