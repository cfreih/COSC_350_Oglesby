import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Dimension;


/**

/**
 * @author Clint
 * 
 */
public class UpdateAuctionPanel extends JPanel {
	
	private JLabel lblPaintingInfo;
	private JScrollPane scrollPane;
	private JTable paintingsTable;
	private JLabel lblArtistFirstName;
	private JFormattedTextField formattedFirstName;
	private JLabel lblArtistLastName;
	private JFormattedTextField formattedLastName;
	private JLabel lblArtistinfo;
	private JLabel lblPaintingInfo_1;
	private JLabel lblTitleOfWork;
	private JFormattedTextField formattedTitle;
	private JLabel lblDateOfWork;
	private JFormattedTextField formattedDateOfWork;
	private JLabel lblDateSoldAt;
	private JFormattedTextField formattedDateAuction;
	private JLabel lblPriceSoldAt;
	private JFormattedTextField formattedSalePrice;
	private JLabel lblHeightcm;
	private JFormattedTextField formattedHeight;
	private JLabel lblWidthcm;
	private JFormattedTextField formattedWidth;
	private JLabel lblMedium;
	private JTextField textFieldMedium;
	private JLabel lblSubject;
	private JTextField textFieldSubject;
	private JButton btnSaveChanges;
	private JButton btnDelete;
	private JButton btnCancel;
	
	private DefaultTableModel tableModel;
	private AuctionPainting origPainting;

	public UpdateAuctionPanel() {
		lblPaintingInfo = new JLabel("Current Painting Info");
		lblPaintingInfo.setBounds(27, 61, 119, 15);
		paintingsTable = new JTable();
		scrollPane = new JScrollPane(paintingsTable);
		scrollPane.setBounds(27, 79, 696, 54);
		lblArtistFirstName = new JLabel("Artist First Name (max 20 characters)");
		lblArtistFirstName.setBounds(27, 176, 215, 15);
		formattedFirstName = new JFormattedTextField(
				createFormatter("********************"));
		formattedFirstName.setBounds(27, 194, 226, 21);
		lblTitleOfWork = new JLabel("Title of Work (max 40 characters)");
		lblTitleOfWork.setBounds(27, 255, 186, 15);
		formattedTitle = new JFormattedTextField(
				createFormatter("****************************************"));
		formattedTitle.setBounds(27, 276, 446, 21);
		lblDateOfWork = new JLabel("Date of Work (yyyy)");
		lblDateOfWork.setBounds(27, 300, 108, 15);
		formattedDateOfWork = new JFormattedTextField(createFormatter("####*"));
		formattedDateOfWork.setBounds(27, 318, 116, 21);
		lblDateSoldAt = new JLabel("Date Sold at Auction (mm/dd/yyyy)");
		lblDateSoldAt.setBounds(186, 300, 193, 15);
		formattedDateAuction = new JFormattedTextField(
				createFormatter("##/##/####"));
		formattedDateAuction.setBounds(186, 318, 116, 21);
		lblHeightcm = new JLabel("Height(cm)");
		lblHeightcm.setBounds(27, 342, 62, 15);
		formattedHeight = new JFormattedTextField(
				NumberFormat.getNumberInstance());
		formattedHeight.setBounds(27, 360, 61, 21);
		lblWidthcm = new JLabel("Width (cm)");
		lblWidthcm.setBounds(186, 342, 62, 15);
		formattedWidth = new JFormattedTextField(
				NumberFormat.getNumberInstance());
		formattedWidth.setBounds(186, 360, 61, 21);
		lblMedium = new JLabel("Medium");
		lblMedium.setBounds(27, 384, 47, 15);
		textFieldMedium = new JTextField();
		textFieldMedium.setBounds(27, 402, 226, 21);
		lblSubject = new JLabel("Subject");
		lblSubject.setBounds(27, 426, 42, 15);
		textFieldSubject = new JTextField();
		textFieldSubject.setBounds(27, 444, 226, 21);
		
		origPainting = new AuctionPainting();
		tableModel = new DefaultTableModel(new Object[][] { origPainting.toTableRow() },
			new String[] { "Artist First Name", "Arist Last Name", "Title",
					"Date of Work", "Date of Sale", "Sale Price", "Height",
					"Width", "Medium", "Subject" }) {
		Class[] columnTypes = new Class[] { String.class, String.class,
				String.class, Integer.class, Object.class, Double.class,
				Integer.class, Integer.class, String.class, String.class };

		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}

		boolean[] columnEditables = new boolean[] { false, false, false,
				false, false, false, false, false, false, false };

		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};		

		setUpPanel();
	}

	public void setUpPanel() {
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "Manage Auction Paintings",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		setLayout(null);

		lblPaintingInfo.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblPaintingInfo);
		add(scrollPane);

		/**
		 * Need to get a painting and make that the Object[][] array that will
		 * be the one row in the table.
		 */
		paintingsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		paintingsTable.setModel(tableModel);
		paintingsTable.getColumnModel().getColumn(0).setResizable(false);
		paintingsTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		paintingsTable.getColumnModel().getColumn(1).setResizable(false);
		paintingsTable.getColumnModel().getColumn(1).setPreferredWidth(90);
		paintingsTable.getColumnModel().getColumn(2).setResizable(false);
		paintingsTable.getColumnModel().getColumn(2).setPreferredWidth(180);
		paintingsTable.getColumnModel().getColumn(3).setResizable(false);
		paintingsTable.getColumnModel().getColumn(4).setResizable(false);
		paintingsTable.getColumnModel().getColumn(4).setPreferredWidth(90);
		paintingsTable.getColumnModel().getColumn(5).setResizable(false);
		paintingsTable.getColumnModel().getColumn(6).setResizable(false);
		paintingsTable.getColumnModel().getColumn(7).setResizable(false);
		paintingsTable.getColumnModel().getColumn(8).setResizable(false);
		paintingsTable.getColumnModel().getColumn(9).setResizable(false);
		paintingsTable.setFont(new Font("Century", Font.PLAIN, 12));
		paintingsTable.setCellSelectionEnabled(true);
		paintingsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		lblArtistFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblArtistFirstName);
		lblArtistLastName = new JLabel("Artist Last Name (max 20 characters)");
		lblArtistLastName.setBounds(399, 176, 213, 15);
		lblArtistLastName.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblArtistLastName);

		lblArtistFirstName.setLabelFor(formattedFirstName);
		formattedFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedFirstName.setColumns(20);
		add(formattedFirstName);

		lblArtistinfo = new JLabel("Artist Information");
		lblArtistinfo.setBounds(27, 147, 103, 15);
		lblArtistinfo.setFont(new Font("Century", Font.ITALIC, 12));
		add(lblArtistinfo);
		formattedLastName = new JFormattedTextField(
				createFormatter("********************"));
		formattedLastName.setBounds(399, 194, 213, 21);

		lblArtistLastName.setLabelFor(formattedLastName);
		formattedLastName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedLastName.setColumns(20);
		add(formattedLastName);

		lblPaintingInfo_1 = new JLabel("Painting Information");
		lblPaintingInfo_1.setBounds(27, 229, 117, 15);
		lblPaintingInfo_1.setFont(new Font("Century", Font.ITALIC, 12));
		add(lblPaintingInfo_1);
		lblTitleOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblTitleOfWork);

		lblTitleOfWork.setLabelFor(formattedTitle);
		formattedTitle.setFont(new Font("Century", Font.PLAIN, 12));
		formattedTitle.setColumns(40);
		add(formattedTitle);
		lblDateOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblDateOfWork);
		lblPriceSoldAt = new JLabel("Price Sold at Auction");
		lblPriceSoldAt.setBounds(399, 300, 117, 15);
		lblPriceSoldAt.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblPriceSoldAt);

		lblDateOfWork.setLabelFor(formattedDateOfWork);
		formattedDateOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		formattedDateOfWork.setColumns(10);
		add(formattedDateOfWork);

		lblDateSoldAt.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblDateSoldAt);

		formattedDateAuction.setFont(new Font("Century", Font.PLAIN, 12));
		formattedDateAuction.setColumns(10);
		add(formattedDateAuction);
		formattedSalePrice = new JFormattedTextField(
				NumberFormat.getNumberInstance());
		formattedSalePrice.setBounds(399, 318, 213, 21);

		lblPriceSoldAt.setLabelFor(formattedSalePrice);
		formattedSalePrice.setFont(new Font("Century", Font.PLAIN, 12));
		formattedSalePrice.setColumns(20);
		add(formattedSalePrice);

		lblHeightcm.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblHeightcm);

		lblHeightcm.setLabelFor(formattedHeight);
		formattedHeight.setFont(new Font("Century", Font.PLAIN, 12));
		formattedHeight.setColumns(5);
		add(formattedHeight);

		lblWidthcm.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblWidthcm);

		lblWidthcm.setLabelFor(formattedWidth);
		formattedWidth.setColumns(5);
		formattedWidth.setFont(new Font("Century", Font.PLAIN, 12));
		add(formattedWidth);

		lblMedium.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblMedium);

		lblMedium.setLabelFor(textFieldMedium);
		textFieldMedium.setFont(new Font("Century", Font.PLAIN, 12));
		add(textFieldMedium);
		textFieldMedium.setColumns(20);

		lblSubject.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblSubject);

		lblSubject.setLabelFor(textFieldSubject);
		textFieldSubject.setFont(new Font("Century", Font.PLAIN, 12));
		add(textFieldSubject);
		textFieldSubject.setColumns(20);
		btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(31, 518, 150, 40);
		btnSaveChanges.setPreferredSize(new Dimension(150, 40));
		btnSaveChanges.setMnemonic('S');
		add(btnSaveChanges);
		btnDelete = new JButton("Delete Painting");
		btnDelete.setBounds(264, 518, 132, 40);
		btnDelete.setMnemonic('D');
		add(btnDelete);
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(615, 518, 106, 40);
		btnCancel.setMnemonic('C');
		add(btnCancel);

	}
	
	/**
	 * Desc: Updates the table model being used so the GUI shows the proper
	 * 		 painting info.
	 * @param painting
	 */
	public void updateTableModel(AuctionPainting painting)
	{
		origPainting = painting;
		Object[][] dataVector = {origPainting.toTableRow()};
		String[] columnNames = new String[] { "Artist First Name", "Arist Last Name", "Title",
				"Date of Work", "Date of Sale", "Sale Price", "Height",
				"Width", "Medium", "Subject" };
		tableModel.setDataVector(dataVector, columnNames);
		
	}
	
	/**
	 * Desc: Checks if any fields have been changed.
	 * Return: true if any field has been changed, false otherwise.
	 */
	public boolean isEditValid()
	{
		String med = textFieldMedium.getText().trim();
		String subj = textFieldSubject.getText().trim();
		String fName = "";
		if(formattedFirstName.getValue() != null)
			fName = ((String) formattedFirstName.getValue()).trim();
		String lName = "";
		if(formattedLastName.getValue() != null)
			lName = ((String) formattedLastName.getValue()).trim();
		String title = "";
		if(formattedTitle.getValue() != null)
			title = ((String) formattedTitle.getValue()).trim();
		String dateOfWork = "";
		if(formattedDateOfWork.getValue() != null)
			dateOfWork = ((String) formattedDateOfWork.getValue()).trim();
		
		if(fName.length() > 0 || lName.length() > 0 || title.length() > 0 || dateOfWork.length() > 0 || !(formattedSalePrice.getValue() == null)
				|| !(formattedHeight.getValue() == null) || !(formattedWidth.getValue() == null) || !(med.length() == 0)
				|| !(subj.length() == 0) || formattedDateAuction.getValue() != null)
		{
			String[] fieldValues = getFieldValues();
			int dateWork = -1;
			if(!fieldValues[3].equals(""))
			{
				String formatted = fieldValues[3];
				if(formatted.length() > 4)
					formatted = formatted.substring(0, 4);
				dateWork = Integer.parseInt(formatted);
			}
			SimpleDate dateAuction = new SimpleDate();
			if(!fieldValues[4].equals(""))
				dateAuction = SimpleDate.parseSimpleDate(fieldValues[4]);
			double salePrice = 0;
			if(!fieldValues[5].equals(""))
				salePrice = Double.parseDouble(fieldValues[5]);
			double height = 0;
			if(!fieldValues[6].equals(""))
				height = Double.parseDouble(fieldValues[6]);
			double width = 0;
			if(!fieldValues[7].equals(""))
				width = Double.parseDouble(fieldValues[7]);
			if(dateOfWork.length() > 0)
				if(dateWork < 1100)
					return false;
			if(!(formattedSalePrice.getValue() == null))
				if(salePrice <= 0)
					return false;
			if(!(formattedHeight.getValue() == null))
				if(height <= 0)
					return false;
			if(!(formattedWidth.getValue() == null))
				if(width <= 0)
					return false;
			if(formattedDateAuction.getValue() != null)
				if(dateAuction.equals(new AuctionPainting()) || dateAuction.getYear() < dateWork)
					return false;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Desc: Gets all the elements of the panel
	 * Pre: The fields are valid.
	 * Return: A String array of everything. The array is in the order
	 * 		   first name [0], last name [1], title [2], date of work [3], date of auction [4],
	 * 		   sale price [5], height [6], width [7], medium [8], and subject [9].
	 */
	public String[] getFieldValues()
	{
		String[] fieldValues = new String[10];
		fieldValues[0] = "";
		if(formattedFirstName.getValue() != null)
			fieldValues[0] = ((String) formattedFirstName.getValue()).trim();
		fieldValues[1] = "";
		if(formattedLastName.getValue() != null)
			fieldValues[1] = ((String) formattedLastName.getValue()).trim();
		fieldValues[2] = "";
		if(formattedTitle.getValue() != null)
			fieldValues[2] = ((String) formattedTitle.getValue()).trim();
		fieldValues[3] = "";
		if(formattedDateOfWork.getValue() != null)
			fieldValues[3] = ((String) formattedDateOfWork.getValue()).trim();
		fieldValues[4] = "";
		if(formattedDateAuction.getValue() != null)
			fieldValues[4] = ((String) formattedDateAuction.getValue()).trim();
		fieldValues[5] = "";
		if(formattedSalePrice.getValue() != null)
		{
			if(formattedSalePrice.getValue() instanceof Long)
				fieldValues[5] = Long.toString((Long) formattedSalePrice.getValue());
			else
				fieldValues[5] = Double.toString((Double) formattedSalePrice.getValue());
		}
		fieldValues[6] = "";
		if(formattedHeight.getValue() != null)
		{
			if(formattedHeight.getValue() instanceof Long)
				fieldValues[6] = Long.toString((Long) formattedHeight.getValue());
			else
				fieldValues[6] = Double.toString((Double) formattedHeight.getValue());
		}
		fieldValues[7] = "";
		if(formattedWidth.getValue() != null)
		{
			if(formattedWidth.getValue() instanceof Long)
				fieldValues[7] = Long.toString((Long) formattedWidth.getValue());
			else
				fieldValues[7] = Double.toString((Double) formattedWidth.getValue());
		}
		fieldValues[8] = textFieldMedium.getText();
		fieldValues[9] = textFieldSubject.getText();
		
		return fieldValues;
	}
	
	/**
	 * Desc: Updates an AuctionPainting based on what fields have been changed.
	 * Post: update has fields changed based on what has been inputted.
	 */
	public void updateAuctionPainting(AuctionPainting update)
	{
		String[] fieldValues = getFieldValues();
		if(fieldValues[0].length() > 0)
			update.setArtistFirstName(fieldValues[0]);
		if(fieldValues[1].length() > 0)
			update.setArtistLastName(fieldValues[1]);
		if(fieldValues[2].length() > 0)
			update.setTitleOfWork(fieldValues[2]);
		if(fieldValues[3].length() > 0)
			update.setDateOfWork(fieldValues[3]);
		if(fieldValues[4].length() > 0)
			update.setDateOfSaleAuction(SimpleDate.parseSimpleDate(fieldValues[4]));
		if(fieldValues[5].length() > 0)
			update.setSalePriceAuction(Double.parseDouble(fieldValues[5]));
		if(fieldValues[6].length() > 0)
			update.setHeightCM(Double.parseDouble(fieldValues[7]));
		if(fieldValues[7].length() > 0)
			update.setWidthCM(Double.parseDouble(fieldValues[8]));
		if(fieldValues[8].length() > 0)
			update.setMedium(fieldValues[9]);
		if(fieldValues[9].length() > 0)
			update.setSubject(fieldValues[9]);
		
	}
	
	/**
	 * Desc: resets the text fields to be blank again.
	 * Post: all the text fields have the value of being blank again.
	 */
	public void resetTextFields()
	{
		formattedFirstName.setValue(null);
		formattedLastName.setValue(null);
		formattedTitle.setValue(null);
		formattedDateOfWork.setValue(null);
		formattedDateAuction.setValue(null);
		formattedSalePrice.setValue(null);
		formattedHeight.setValue(null);
		formattedWidth.setValue(null);
		textFieldMedium.setText("");
		textFieldSubject.setText("");
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
	public JButton getBtnSaveChanges() {
		return btnSaveChanges;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}

	public AuctionPainting getOrigPainting() {
		return origPainting;
	}
	

}
