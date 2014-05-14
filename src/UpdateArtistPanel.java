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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateArtistPanel extends JPanel {
	private JLabel lblArtistInfo;
	private JLabel lblFirstName;
	private JLabel lblLastNamemax;
	private JFormattedTextField formattedFirstName;
	private JFormattedTextField formattedLastName;
	private JButton btnSelectArtist;
	private JButton btnCancel;
	public UpdateArtistPanel() {
		formattedFirstName = new JFormattedTextField(createFormatter("A*******************"));
		formattedLastName = new JFormattedTextField(createFormatter("A*******************"));
		
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
				null, null), new TitledBorder(null, "Select Artist to Modify/Delete",
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
		
		btnSelectArtist = new JButton("Select Artist");
		GridBagConstraints gbc_btnSelectArtist = new GridBagConstraints();
		gbc_btnSelectArtist.insets = new Insets(0, 0, 5, 5);
		gbc_btnSelectArtist.anchor = GridBagConstraints.WEST;
		gbc_btnSelectArtist.gridx = 1;
		gbc_btnSelectArtist.gridy = 6;
		add(btnSelectArtist, gbc_btnSelectArtist);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 6;
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
		if(formattedFirstName.isEditValid() && formattedLastName.isEditValid() )
		{
				return false;
		}
		return false;
	}
	public Artist createNewArtist()
	{
		Artist artist=new Artist();
		artist.setArtistFirstName((String)formattedFirstName.getValue());
		artist.setArtistLastName((String)formattedLastName.getValue());
		return artist;
	}
	public void resetTextFields()
	{
		formattedFirstName.setValue(null);
		formattedLastName.setValue(null);
	}
	public JButton getBtnSelectArtist() {
		return btnSelectArtist;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
}
