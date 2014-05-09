package test;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ApplyArtistChangesPanel extends JPanel {
	private JLabel lblArtistInfo;
	private JLabel lblFirstName;
	private JLabel lblLastNamemax;
	private JLabel lblFashionabilityCoefficient;
	private JFormattedTextField formattedFirstName;
	private JFormattedTextField formattedLastName;
	private JFormattedTextField formattedFashionability;
	private JButton btnSaveChanges;
	private JButton btnCancel;
	private JLabel lblNewArtistInfo;
	private JButton btnDeleteArtist;
	private JScrollPane scrollPane;
	private JTable table;
	public ApplyArtistChangesPanel() {
		formattedFirstName = new JFormattedTextField(createFormatter("?*******************"));
		formattedLastName = new JFormattedTextField(createFormatter("?*******************"));
		formattedFashionability = new JFormattedTextField(createFormatter("#####"));
		
		setUpPanel();
	}
	public void setUpPanel()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 253, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "Apply Changes",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		
		lblArtistInfo = new JLabel("Artist Info");
		GridBagConstraints gbc_lblArtistInfo = new GridBagConstraints();
		gbc_lblArtistInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtistInfo.gridx = 1;
		gbc_lblArtistInfo.gridy = 0;
		add(lblArtistInfo, gbc_lblArtistInfo);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"First Name", "Last Name", "Fashionability Coeff."
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		scrollPane.setViewportView(table);
		
		lblNewArtistInfo = new JLabel("New Artist Info (Values left blank will not be modified)");
		GridBagConstraints gbc_lblNewArtistInfo = new GridBagConstraints();
		gbc_lblNewArtistInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewArtistInfo.gridx = 1;
		gbc_lblNewArtistInfo.gridy = 2;
		add(lblNewArtistInfo, gbc_lblNewArtistInfo);
		
		lblFirstName = new JLabel("First Name (max 20 characters)");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.WEST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 3;
		add(lblFirstName, gbc_lblFirstName);
		
		formattedFirstName.setColumns(20);
		GridBagConstraints gbc_formattedFirstName = new GridBagConstraints();
		gbc_formattedFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_formattedFirstName.anchor = GridBagConstraints.WEST;
		gbc_formattedFirstName.gridx = 1;
		gbc_formattedFirstName.gridy = 4;
		add(formattedFirstName, gbc_formattedFirstName);
		
		lblLastNamemax = new JLabel("Last Name (max 20 characters)");
		GridBagConstraints gbc_lblLastNamemax = new GridBagConstraints();
		gbc_lblLastNamemax.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastNamemax.anchor = GridBagConstraints.WEST;
		gbc_lblLastNamemax.gridx = 1;
		gbc_lblLastNamemax.gridy = 5;
		add(lblLastNamemax, gbc_lblLastNamemax);
		
		formattedLastName.setColumns(20);
		GridBagConstraints gbc_formattedLastName = new GridBagConstraints();
		gbc_formattedLastName.insets = new Insets(0, 0, 5, 5);
		gbc_formattedLastName.anchor = GridBagConstraints.WEST;
		gbc_formattedLastName.gridx = 1;
		gbc_formattedLastName.gridy = 6;
		add(formattedLastName, gbc_formattedLastName);
		
		lblFashionabilityCoefficient = new JLabel("Fashionability Coefficient");
		GridBagConstraints gbc_lblFashionabilityCoefficient = new GridBagConstraints();
		gbc_lblFashionabilityCoefficient.insets = new Insets(0, 0, 5, 5);
		gbc_lblFashionabilityCoefficient.anchor = GridBagConstraints.WEST;
		gbc_lblFashionabilityCoefficient.gridx = 1;
		gbc_lblFashionabilityCoefficient.gridy = 7;
		add(lblFashionabilityCoefficient, gbc_lblFashionabilityCoefficient);
		
		formattedFashionability.setColumns(5);
		GridBagConstraints gbc_formattedFashionability = new GridBagConstraints();
		gbc_formattedFashionability.insets = new Insets(0, 0, 5, 5);
		gbc_formattedFashionability.anchor = GridBagConstraints.WEST;
		gbc_formattedFashionability.gridx = 1;
		gbc_formattedFashionability.gridy = 8;
		add(formattedFashionability, gbc_formattedFashionability);
		
		btnDeleteArtist = new JButton("Delete Artist");
		GridBagConstraints gbc_btnDeleteArtist = new GridBagConstraints();
		gbc_btnDeleteArtist.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeleteArtist.gridx = 2;
		gbc_btnDeleteArtist.gridy = 8;
		add(btnDeleteArtist, gbc_btnDeleteArtist);
		
		btnSaveChanges = new JButton("Save Changes");
		GridBagConstraints gbc_btnSaveChanges = new GridBagConstraints();
		gbc_btnSaveChanges.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveChanges.anchor = GridBagConstraints.WEST;
		gbc_btnSaveChanges.gridx = 1;
		gbc_btnSaveChanges.gridy = 9;
		add(btnSaveChanges, gbc_btnSaveChanges);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 9;
		add(btnCancel, gbc_btnCancel);
	}
	protected MaskFormatter createFormatter(String s) {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(s);
		} catch (java.text.ParseException exc) {
			System.err.println("formatter is bad: " + exc.getMessage());
			System.exit(-1);
		}
		return formatter;
	}

	public JButton getBtnSaveChanges() {
		return btnSaveChanges;
	}
	public JButton getBtnDeleteArtist() {
		return btnDeleteArtist;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
}
