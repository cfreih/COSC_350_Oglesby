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

public class SeeAllArtistsPanel extends JPanel {
	private JButton btnBack;
	private JTable artistTable;
	private DefaultTableModel tableModel;
	public SeeAllArtistsPanel() {
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "See All Artists",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
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
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(artistTable);
		
		btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 3;
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
		SeeAllArtistsPanel panel =new SeeAllArtistsPanel();
		f.getContentPane().add(panel);
		f.setVisible(true);
		Artist[] artists = new Artist[75];
		for(int i=0; i <= artists.length-1; ++i){
			
			artists[i] = new Artist( "thisnameis25characterslon","lastName", 5000);
		}
		panel.updateTableModel(artists);
	}
}
