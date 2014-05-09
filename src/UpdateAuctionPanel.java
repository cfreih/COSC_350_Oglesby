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
		formattedDateOfWork = new JFormattedTextField(createFormatter("####"));
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
		paintingsTable.setModel(new DefaultTableModel(new Object[][] { { null,
				null, "", null, null, null, null, null, null, null }, },
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
		});
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
}
