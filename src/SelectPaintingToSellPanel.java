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
import java.awt.Font;

public class SelectPaintingToSellPanel extends JPanel {
	private JLabel lblArtistInfo;
	private JLabel lblFirstName;
	private JLabel lblLastNamemax;
	private JLabel lblTitle;
	private JFormattedTextField formattedFirstName;
	private JFormattedTextField formattedLastName;
	private JFormattedTextField formattedTitle;
	private JButton btnSelectPainting;
	private JButton btnCancel;
	private JLabel lblPaintingInfo;
	public SelectPaintingToSellPanel() {
		formattedFirstName = new JFormattedTextField(createFormatter("H*******************"));
		formattedLastName = new JFormattedTextField(createFormatter("H*******************"));
		
		setUpPanel();
	}
	public void setUpPanel()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 253, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "Select Painting To Sell",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		
		lblArtistInfo = new JLabel("Artist Information");
		lblArtistInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
		
		lblPaintingInfo = new JLabel("Painting Information");
		lblPaintingInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPaintingInfo = new GridBagConstraints();
		gbc_lblPaintingInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaintingInfo.gridx = 1;
		gbc_lblPaintingInfo.gridy = 5;
		add(lblPaintingInfo, gbc_lblPaintingInfo);
		
		lblTitle = new JLabel("Title (max 40 characters)");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.anchor = GridBagConstraints.WEST;
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 6;
		add(lblTitle, gbc_lblTitle);
		formattedTitle = new JFormattedTextField(createFormatter("H***************************************"));
		
		formattedTitle.setColumns(40);
		GridBagConstraints gbc_formattedTitle = new GridBagConstraints();
		gbc_formattedTitle.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTitle.anchor = GridBagConstraints.WEST;
		gbc_formattedTitle.gridx = 1;
		gbc_formattedTitle.gridy = 7;
		add(formattedTitle, gbc_formattedTitle);
		
		btnSelectPainting = new JButton("Select Painting To Sell");
		GridBagConstraints gbc_btnSelectPainting = new GridBagConstraints();
		gbc_btnSelectPainting.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelectPainting.anchor = GridBagConstraints.WEST;
		gbc_btnSelectPainting.gridx = 1;
		gbc_btnSelectPainting.gridy = 8;
		add(btnSelectPainting, gbc_btnSelectPainting);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 8;
		add(btnCancel, gbc_btnCancel);
	}
	public boolean isInputValid()
	{
		if(formattedFirstName.isEditValid() && formattedLastName.isEditValid() && formattedTitle.isEditValid())
		{
				return true;
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
		formattedTitle.setValue(null);
	}
	public InventoryPainting createNewInventoryPainting()
	{
		InventoryPainting inventoryPainting=new InventoryPainting();
		inventoryPainting.setArtistFirstName((String)formattedFirstName.getValue());
		inventoryPainting.setArtistLastName((String)formattedLastName.getValue());
		inventoryPainting.setTitleOfWork((String)formattedTitle.getValue());
		return inventoryPainting;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
	public JButton getBtnSelectPainting() {
		return btnSelectPainting;
	}
}
