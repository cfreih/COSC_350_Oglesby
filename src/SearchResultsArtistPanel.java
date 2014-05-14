import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SearchResultsArtistPanel extends JPanel {
	private JButton btnBack;
	private JTable artistTable;
	private DefaultTableModel tableModel;
	private JButton btnSelect;
	public SearchResultsArtistPanel() {
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "See All Artists",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 150, 150, 150, 150, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		artistTable = new JTable();
		tableModel =new DefaultTableModel(
				new Object[][] {
						{null, null, null},
						{null, null, null},
					},
					new String[] {
						"Last Name", "First Name", "Fashionability"
					}
				);
		artistTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Last Name", "First Name", "Fashionability"
			}
		));
		scrollPane.setViewportView(artistTable);
		
		btnSelect = new JButton("Select");
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSelect.insets = new Insets(0, 0, 5, 5);
		gbc_btnSelect.gridx = 1;
		gbc_btnSelect.gridy = 2;
		add(btnSelect, gbc_btnSelect);
		
		btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 2;
		add(btnBack, gbc_btnBack);
	}
	public void updateTableModel(Artist[] artists){
		Object[][] dataVector= new Object[artists.length][20];
		for(int i=0; i <= artists.length-1; i++)
			dataVector[i]=artists[i].toTableRow();
		String[] columnNames = new String[] {
				"Artist First Name", "Arist Last Name", "Fashionability"};
		tableModel.setDataVector(dataVector, columnNames);
		artistTable.setModel(tableModel);
		artistTable.getColumnModel().getColumn(0).setMinWidth(200);
		artistTable.getColumnModel().getColumn(1).setMinWidth(200);
		artistTable.getColumnModel().getColumn(2).setMinWidth(100);
		artistTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}

	public JButton getBtnBack() {
		return btnBack;
	}
	public static void main(String[] args) {
		JFrame f = new JFrame("test window");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setSize(800, 600);
		f.setLocation(10, 10);
		SearchResultsArtistPanel panel =new SearchResultsArtistPanel();
		f.getContentPane().add(panel);
		f.setVisible(true);
		Artist[] artists = new Artist[75];
		for(int i=0; i <= artists.length-1; ++i){
			
			artists[i] = new Artist( "thisnameis25characterslon","lastName", 5000);
		}
		panel.updateTableModel(artists);
	}
	public JButton getBtnSelect() {
		return btnSelect;
	}
}
