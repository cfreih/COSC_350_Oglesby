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

public class AddNewArtistPanel extends JPanel {
	private JLabel lblArtistInfo;
	private JLabel lblFirstName;
	private JLabel lblLastNamemax;
	private JLabel lblFashionabilityCoefficient;
	private JFormattedTextField formattedFirstName;
	private JFormattedTextField formattedLastName;
	private JFormattedTextField formattedFashionability;
	private JButton btnAddNewArtist;
	private JButton btnCancel;
	public AddNewArtistPanel() {
		formattedFirstName = new JFormattedTextField(createFormatter("H*******************"));
		formattedLastName = new JFormattedTextField(createFormatter("H*******************"));
		formattedFashionability = new JFormattedTextField(createFormatter("#####"));
		
		setUpPanel();
	}
	public void setUpPanel()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 253, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "Add New Artist",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		
		lblArtistInfo = new JLabel("Artist Info");
		GridBagConstraints gbc_lblArtistInfo = new GridBagConstraints();
		gbc_lblArtistInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtistInfo.gridx = 1;
		gbc_lblArtistInfo.gridy = 0;
		add(lblArtistInfo, gbc_lblArtistInfo);
		
		lblFirstName = new JLabel("First Name (max 20 characters)");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.WEST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 1;
		add(lblFirstName, gbc_lblFirstName);
		
		formattedFirstName.setColumns(20);
		GridBagConstraints gbc_formattedFirstName = new GridBagConstraints();
		gbc_formattedFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_formattedFirstName.anchor = GridBagConstraints.WEST;
		gbc_formattedFirstName.gridx = 1;
		gbc_formattedFirstName.gridy = 2;
		add(formattedFirstName, gbc_formattedFirstName);
		
		lblLastNamemax = new JLabel("Last Name (max 20 characters)");
		GridBagConstraints gbc_lblLastNamemax = new GridBagConstraints();
		gbc_lblLastNamemax.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastNamemax.anchor = GridBagConstraints.WEST;
		gbc_lblLastNamemax.gridx = 1;
		gbc_lblLastNamemax.gridy = 3;
		add(lblLastNamemax, gbc_lblLastNamemax);
		
		formattedLastName.setColumns(20);
		GridBagConstraints gbc_formattedLastName = new GridBagConstraints();
		gbc_formattedLastName.insets = new Insets(0, 0, 5, 5);
		gbc_formattedLastName.anchor = GridBagConstraints.WEST;
		gbc_formattedLastName.gridx = 1;
		gbc_formattedLastName.gridy = 4;
		add(formattedLastName, gbc_formattedLastName);
		
		lblFashionabilityCoefficient = new JLabel("Fashionability Coefficient");
		GridBagConstraints gbc_lblFashionabilityCoefficient = new GridBagConstraints();
		gbc_lblFashionabilityCoefficient.insets = new Insets(0, 0, 5, 5);
		gbc_lblFashionabilityCoefficient.anchor = GridBagConstraints.WEST;
		gbc_lblFashionabilityCoefficient.gridx = 1;
		gbc_lblFashionabilityCoefficient.gridy = 5;
		add(lblFashionabilityCoefficient, gbc_lblFashionabilityCoefficient);
		
		formattedFashionability.setColumns(5);
		GridBagConstraints gbc_formattedFashionability = new GridBagConstraints();
		gbc_formattedFashionability.insets = new Insets(0, 0, 5, 5);
		gbc_formattedFashionability.anchor = GridBagConstraints.WEST;
		gbc_formattedFashionability.gridx = 1;
		gbc_formattedFashionability.gridy = 6;
		add(formattedFashionability, gbc_formattedFashionability);
		
		btnAddNewArtist = new JButton("Add New Artist");
		GridBagConstraints gbc_btnAddNewArtist = new GridBagConstraints();
		gbc_btnAddNewArtist.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddNewArtist.anchor = GridBagConstraints.WEST;
		gbc_btnAddNewArtist.gridx = 1;
		gbc_btnAddNewArtist.gridy = 7;
		add(btnAddNewArtist, gbc_btnAddNewArtist);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 7;
		add(btnCancel, gbc_btnCancel);
	}
	public boolean isInputValid()
	{
		int fashionability=Integer.parseInt((String) formattedFashionability.getValue());
		if(formattedFirstName.isEditValid() && formattedLastName.isEditValid() && formattedFashionability.isEditValid())
		{
			if((fashionability >= 0) && (fashionability <=10000))
				return true;
			else
				return false;
		}
		return false;
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
	public void resetTextFields()
	{
		formattedFirstName.setValue(null);
		formattedLastName.setValue(null);
		formattedFashionability.setValue(null);
	}
	public Artist createNewArtist()
	{
		Artist artist=new Artist();
		artist.setArtistFirstName((String)formattedFirstName.getValue());
		artist.setArtistLastName((String)formattedLastName.getValue());
		artist.setFashionabilityCoeff((Integer)formattedFashionability.getValue());
		return artist;
	}
	public JButton getBtnAddNewArtist() {
		return btnAddNewArtist;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
}
