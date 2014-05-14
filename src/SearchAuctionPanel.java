import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**

/**
 * @author Clint
 * 
 */
public class SearchAuctionPanel extends JPanel {

	private GridBagLayout gridBagLayout;
	private JLabel lblArtistFirstName;
	private JFormattedTextField formattedFirstName;
	private JLabel lblArtistLastName;
	private JFormattedTextField formattedLastName;
	private JLabel lblTitleOfWork;
	private JFormattedTextField formattedTitleOfWork;
	private JButton btnSearch;
	private JButton btnCancel;

	public SearchAuctionPanel() {
		gridBagLayout = new GridBagLayout();
		lblArtistFirstName = new JLabel("Artist First Name (max 20 characters)");
		formattedFirstName = new JFormattedTextField(
				createFormatter("********************"));
		lblArtistLastName = new JLabel("Artist Last Name (max 20 characters)");
		formattedLastName = new JFormattedTextField(
				createFormatter("********************"));
		lblTitleOfWork = new JLabel("Title Of Work (max 40 characters)");
		formattedTitleOfWork = new JFormattedTextField(
				createFormatter("****************************************"));
		btnSearch = new JButton("Search");
		btnCancel = new JButton("Cancel");

		setUpPanel();
	}

	/**
	 * Desc: Sets up the Panel for this class.
	 */
	public void setUpPanel() {
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "Manage Auction Records",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));

		gridBagLayout.columnWidths = new int[] { 48, 215, 228, 150, 0 };
		gridBagLayout.rowHeights = new int[] { 70, 15, 21, 57, 15, 21, 58, 15,
				21, 85, 39, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblArtistFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_lblArtistFirstName = new GridBagConstraints();
		gbc_lblArtistFirstName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblArtistFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtistFirstName.gridx = 1;
		gbc_lblArtistFirstName.gridy = 1;
		add(lblArtistFirstName, gbc_lblArtistFirstName);

		formattedFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedFirstName.setColumns(20);
		GridBagConstraints gbc_formattedFirstName = new GridBagConstraints();
		gbc_formattedFirstName.anchor = GridBagConstraints.NORTH;
		gbc_formattedFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_formattedFirstName.gridx = 1;
		gbc_formattedFirstName.gridy = 2;
		add(formattedFirstName, gbc_formattedFirstName);

		lblArtistLastName.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_lblArtistLastName = new GridBagConstraints();
		gbc_lblArtistLastName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblArtistLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtistLastName.gridx = 1;
		gbc_lblArtistLastName.gridy = 4;
		add(lblArtistLastName, gbc_lblArtistLastName);

		formattedLastName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedLastName.setColumns(20);
		GridBagConstraints gbc_formattedLastName = new GridBagConstraints();
		gbc_formattedLastName.anchor = GridBagConstraints.NORTH;
		gbc_formattedLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedLastName.insets = new Insets(0, 0, 5, 5);
		gbc_formattedLastName.gridx = 1;
		gbc_formattedLastName.gridy = 5;
		add(formattedLastName, gbc_formattedLastName);
		lblTitleOfWork = new JLabel("Title Of Work (max 40 characters)");

		lblTitleOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTitleOfWork = new GridBagConstraints();
		gbc_lblTitleOfWork.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTitleOfWork.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitleOfWork.gridx = 1;
		gbc_lblTitleOfWork.gridy = 7;
		add(lblTitleOfWork, gbc_lblTitleOfWork);

		formattedTitleOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		formattedTitleOfWork.setColumns(40);
		GridBagConstraints gbc_formattedTitleOfWork = new GridBagConstraints();
		gbc_formattedTitleOfWork.anchor = GridBagConstraints.NORTHWEST;
		gbc_formattedTitleOfWork.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTitleOfWork.gridwidth = 3;
		gbc_formattedTitleOfWork.gridx = 1;
		gbc_formattedTitleOfWork.gridy = 8;
		add(formattedTitleOfWork, gbc_formattedTitleOfWork);

		btnSearch.setMnemonic('S');
		btnSearch.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.fill = GridBagConstraints.BOTH;
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.gridx = 1;
		gbc_btnSearch.gridy = 10;
		add(btnSearch, gbc_btnSearch);

		btnCancel.setMnemonic('C');
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.BOTH;
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 10;
		add(btnCancel, gbc_btnCancel);

	}
	
	/**
	 * Desc: Checks to see if the input is valid so that the search can be done.
	 * @return true if the input is valid (any field has input), false if it is not.
	 */
	public boolean isInputValid()
	{
		String fName = "";
		String lName = "";
		String title = "";
		if(formattedFirstName.getValue() != null)
			fName = ((String) formattedFirstName.getValue()).trim();
		if(formattedLastName.getValue() != null)
			lName = ((String) formattedLastName.getValue()).trim();
		if(formattedTitleOfWork.getValue() != null)
			title = ((String) formattedTitleOfWork.getValue()).trim();
		if(fName.length() > 0 || lName.length() > 0 || title.length() > 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Desc: gets the field values in this panel and creates the String[]
	 * 		 in the order of firstName [0], lastName [1], and title [2].
	 * Return: String[] in the above order.
	 */
	public String[] getFieldValues()
	{
		String[] fieldValues = new String[3];
		if(formattedFirstName.isEditValid())
			fieldValues[0] = ((String) formattedFirstName.getValue()).trim();
		else
			fieldValues[0] = "";
		if(formattedLastName.isEditValid())
			fieldValues[1] = ((String) formattedLastName.getValue()).trim();
		else
			fieldValues[1] = "";
		if(formattedTitleOfWork.isEditValid())
			fieldValues[2] = ((String) formattedTitleOfWork.getValue()).trim();
		else
			fieldValues[2] = "";
		return fieldValues;
	}
	
	/**
	 * 
	 */
	public static AuctionPainting createNewAuctionPainting(String[] fieldValues)
	{
		AuctionPainting search = new AuctionPainting();
		search.setArtistFirstName(fieldValues[0]);
		search.setArtistLastName(fieldValues[1]);
		search.setTitleOfWork(fieldValues[2]);
		return search;
	}
	
	/**
	 * Desc: resets the text fields to be blank again.
	 * Post: all the text fields have the value of being blank again.
	 */
	public void resetTextFields()
	{
		formattedFirstName.setValue(null);
		formattedLastName.setValue(null);
		formattedTitleOfWork.setValue(null);	
	}

	/**
	 * Desc: Method to create a format for the strings to be entered. Taken from
	 * the Java "How to use Formatted Text Fields" site.
	 * 
	 * @param s
	 *            what the format will be.
	 * @return A Maskformatter of the format from String s.
	 */
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
	public JButton getBtnSearch() {
		return btnSearch;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
}
