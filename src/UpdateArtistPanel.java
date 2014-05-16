

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.*;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class UpdateArtistPanel extends JPanel {
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
	private DefaultTableModel tableModel;
	private JTable artistTable;
	
	private Artist origArtist;
	
	public UpdateArtistPanel() {
		
		setUpPanel();
	}
	public void setUpPanel()
	{
		origArtist = new Artist();
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "Apply Changes",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{38, 101, 153, 93, 99, 0};
		gridBagLayout.rowHeights = new int[]{14, 45, 14, 14, 20, 14, 20, 14, 23, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblArtistInfo = new JLabel("Artist Info");
		GridBagConstraints gbc_lblArtistInfo = new GridBagConstraints();
		gbc_lblArtistInfo.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblArtistInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtistInfo.gridx = 2;
		gbc_lblArtistInfo.gridy = 0;
		add(lblArtistInfo, gbc_lblArtistInfo);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridwidth = 4;
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
		
		lblNewArtistInfo = new JLabel("New Artist Info (Values left blank will not be modified)");
		GridBagConstraints gbc_lblNewArtistInfo = new GridBagConstraints();
		gbc_lblNewArtistInfo.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewArtistInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewArtistInfo.gridwidth = 2;
		gbc_lblNewArtistInfo.gridx = 1;
		gbc_lblNewArtistInfo.gridy = 2;
		add(lblNewArtistInfo, gbc_lblNewArtistInfo);
		
		lblFirstName = new JLabel("First Name (max 20 characters)");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridwidth = 2;
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 3;
		add(lblFirstName, gbc_lblFirstName);
		formattedFirstName = new JFormattedTextField(createFormatter("A*******************"));
		
		formattedFirstName.setColumns(20);
		GridBagConstraints gbc_formattedFirstName = new GridBagConstraints();
		gbc_formattedFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedFirstName.anchor = GridBagConstraints.NORTH;
		gbc_formattedFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_formattedFirstName.gridwidth = 2;
		gbc_formattedFirstName.gridx = 1;
		gbc_formattedFirstName.gridy = 4;
		add(formattedFirstName, gbc_formattedFirstName);
		
		lblLastNamemax = new JLabel("Last Name (max 20 characters)");
		GridBagConstraints gbc_lblLastNamemax = new GridBagConstraints();
		gbc_lblLastNamemax.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLastNamemax.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastNamemax.gridwidth = 2;
		gbc_lblLastNamemax.gridx = 1;
		gbc_lblLastNamemax.gridy = 5;
		add(lblLastNamemax, gbc_lblLastNamemax);
		formattedLastName = new JFormattedTextField(createFormatter("A*******************"));
		
		formattedLastName.setColumns(20);
		GridBagConstraints gbc_formattedLastName = new GridBagConstraints();
		gbc_formattedLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedLastName.anchor = GridBagConstraints.NORTH;
		gbc_formattedLastName.insets = new Insets(0, 0, 5, 5);
		gbc_formattedLastName.gridwidth = 2;
		gbc_formattedLastName.gridx = 1;
		gbc_formattedLastName.gridy = 6;
		add(formattedLastName, gbc_formattedLastName);
		
		lblFashionabilityCoefficient = new JLabel("Fashionability Coefficient");
		GridBagConstraints gbc_lblFashionabilityCoefficient = new GridBagConstraints();
		gbc_lblFashionabilityCoefficient.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblFashionabilityCoefficient.insets = new Insets(0, 0, 5, 5);
		gbc_lblFashionabilityCoefficient.gridwidth = 2;
		gbc_lblFashionabilityCoefficient.gridx = 1;
		gbc_lblFashionabilityCoefficient.gridy = 7;
		add(lblFashionabilityCoefficient, gbc_lblFashionabilityCoefficient);
		formattedFashionability = new JFormattedTextField(NumberFormat.getIntegerInstance());
		
		formattedFashionability.setColumns(5);
		GridBagConstraints gbc_formattedFashionability = new GridBagConstraints();
		gbc_formattedFashionability.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedFashionability.insets = new Insets(0, 0, 5, 5);
		gbc_formattedFashionability.gridx = 1;
		gbc_formattedFashionability.gridy = 8;
		add(formattedFashionability, gbc_formattedFashionability);
		
		btnDeleteArtist = new JButton("Delete Artist");
        btnDeleteArtist.setFont(new Font("Cambria", Font.BOLD, 12));
		GridBagConstraints gbc_btnDeleteArtist = new GridBagConstraints();
		gbc_btnDeleteArtist.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnDeleteArtist.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteArtist.gridx = 3;
		gbc_btnDeleteArtist.gridy = 8;
		add(btnDeleteArtist, gbc_btnDeleteArtist);
		
		btnSaveChanges = new JButton("Save Changes");
        btnSaveChanges.setFont(new Font("Cambria", Font.BOLD, 12));
		GridBagConstraints gbc_btnSaveChanges = new GridBagConstraints();
		gbc_btnSaveChanges.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSaveChanges.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveChanges.gridx = 1;
		gbc_btnSaveChanges.gridy = 9;
		add(btnSaveChanges, gbc_btnSaveChanges);
		tableModel =new DefaultTableModel(
				new Object[][] {
						{null, null, null},
					},
					new String[] {
						"Last Name", "First Name", "Fashionability"
					}
				);
		
		btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Cambria", Font.BOLD, 12));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.anchor = GridBagConstraints.NORTH;
		gbc_btnCancel.gridx = 3;
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
	public boolean isInputValid()
	{
		String[] values = getFieldValues();
		int fash = -1;
		if(values[2].length() > 0)
			fash = Integer.parseInt(values[2]);
		if(values[0].length() > 0 || values[1].length() > 0 || (fash > -1 && fash < 10001))
			return true;
		else
			return false;
			
		/*int fashionability=Integer.parseInt((String) formattedFashionability.getValue());
		if(formattedFirstName.isEditValid() && formattedLastName.isEditValid() && formattedFashionability.isEditValid())
		{
			if((fashionability >= 0) && (fashionability <=10000))
				return true;
			else
				return false;
		}
		return false;*/
	}
	public String[] getFieldValues()
	{
		String[] fieldValues = new String[3];
		fieldValues[0] = "";
		if(formattedFirstName.getValue() != null)
			fieldValues[0] = ((String) formattedFirstName.getValue()).trim();
		fieldValues[1] = "";
		if(formattedLastName.getValue() != null)
			fieldValues[1] = ((String) formattedLastName.getValue()).trim();
		fieldValues[2] = "";
		if(formattedFashionability.getValue() != null)
			fieldValues[2] = Long.toString((Long) formattedFashionability.getValue());
		return fieldValues;
	}
	public void resetTextFields()
	{
		formattedFirstName.setValue(null);
		formattedLastName.setValue(null);
		formattedFashionability.setValue(null);
	}
	public void updateArtist(Artist artist)
	{
		String[] values = getFieldValues();
		if(values[0].length() > 0)
			artist.setArtistFirstName(values[0]);
		if(values[1].length() > 0)
			artist.setArtistLastName(values[1]);
		if(values[2].length() > 0)
			artist.setFashionabilityCoeff(Integer.parseInt(values[2]));
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
	public Artist getOrigArtist() {
		return origArtist;
	}
	public void updateTableModel(Artist artist){
		origArtist = artist;
		Object[][] dataVector= new Object[1][3];
		dataVector[0]=artist.toTableRow();
		String[] columnNames = new String[] {
				"Artist Last Name", "Arist First Name", "Fashionability"};
		TableModel model = new DefaultTableModel(dataVector, columnNames)
		{
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		};		
		artistTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		artistTable.setModel(model);		
		artistTable.getColumnModel().getColumn(0).setMinWidth(200);
		artistTable.getColumnModel().getColumn(1).setMinWidth(200);
		artistTable.getColumnModel().getColumn(2).setMinWidth(100);
		artistTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
	public static void main(String[] args) {
		JFrame f = new JFrame("test window");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setSize(800, 600);
		f.setLocation(10, 10);
		UpdateArtistPanel panel =new UpdateArtistPanel();
		f.getContentPane().add(panel);
		f.setVisible(true);
		Artist artist = new Artist( "thisnameis25characterslon","lastName", 5000);
		panel.updateTableModel(artist);
	}
	
}
