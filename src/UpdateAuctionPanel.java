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
 * 
 */

/**
 * @author Clint
 *
 */
public class UpdateAuctionPanel extends JPanel {
	
	private SpringLayout springLayout;
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
	
	public UpdateAuctionPanel()
	{
		springLayout = new SpringLayout();
		lblPaintingInfo = new JLabel("Current Painting Info");
		paintingsTable = new JTable();
		scrollPane = new JScrollPane(paintingsTable);
		lblArtistFirstName = new JLabel("Artist First Name (max 20 characters)");
		formattedFirstName = new JFormattedTextField(createFormatter("********************"));
		lblArtistLastName = new JLabel("Artist Last Name (max 20 characters)");
		formattedLastName = new JFormattedTextField(createFormatter("********************"));
		lblTitleOfWork = new JLabel("Title of Work (max 40 characters)");
		formattedTitle = new JFormattedTextField(createFormatter("****************************************"));
		lblDateOfWork = new JLabel("Date of Work (yyyy)");
		formattedDateOfWork = new JFormattedTextField(createFormatter("####'?"));
		lblDateSoldAt = new JLabel("Date Sold at Auction (mm/dd/yyyy)");
		formattedDateAuction = new JFormattedTextField(createFormatter("##/##/####"));
		lblPriceSoldAt = new JLabel("Price Sold at Auction");
		formattedSalePrice = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblHeightcm = new JLabel("Height(cm)");
		formattedHeight = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblWidthcm = new JLabel("Width (cm)");
		formattedWidth = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblMedium = new JLabel("Medium");
		textFieldMedium = new JTextField();
		lblSubject = new JLabel("Subject");
		textFieldSubject = new JTextField();
		btnSaveChanges = new JButton("Save Changes");
		btnDelete = new JButton("Delete Painting");
		btnCancel = new JButton("Cancel");
		
		setUpPanel();
	}

	public void setUpPanel()
	{
		setLayout(springLayout);
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new TitledBorder(null, "Manage Auction Paintings", TitledBorder.CENTER, TitledBorder.TOP, null, null)));

		
		lblPaintingInfo.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblPaintingInfo, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblPaintingInfo, 0, SpringLayout.WEST, this);
		add(lblPaintingInfo);
		
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 24, SpringLayout.SOUTH, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 78, SpringLayout.SOUTH, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -8, SpringLayout.EAST, this);
		add(scrollPane);
		
		/**
		 * Need to get a painting and make that the Object[][] array that will be the one row in the table.
		 */
		paintingsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		paintingsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", null, null, null, null, null, null, null},
			},
			new String[] {
				"Artist First Name", "Arist Last Name", "Title", "Date of Work", "Date of Sale", "Sale Price", "Height", "Width", "Medium", "Subject"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, Object.class, Double.class, Integer.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false
			};
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
		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistFirstName, 26, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, lblArtistFirstName, 10, SpringLayout.WEST, this);
		lblArtistFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblArtistFirstName);
		
		
		lblArtistFirstName.setLabelFor(formattedFirstName);
		springLayout.putConstraint(SpringLayout.NORTH, formattedFirstName, 48, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, formattedFirstName, 10, SpringLayout.WEST, this);
		formattedFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedFirstName.setColumns(20);
		add(formattedFirstName);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistLastName, 0, SpringLayout.NORTH, lblArtistFirstName);
		lblArtistLastName.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblArtistLastName);
		
		
		lblArtistLastName.setLabelFor(formattedLastName);
		springLayout.putConstraint(SpringLayout.WEST, lblArtistLastName, 0, SpringLayout.WEST, formattedLastName);
		springLayout.putConstraint(SpringLayout.SOUTH, formattedLastName, 0, SpringLayout.SOUTH, formattedFirstName);
		springLayout.putConstraint(SpringLayout.EAST, formattedLastName, -151, SpringLayout.EAST, this);
		formattedLastName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedLastName.setColumns(20);
		add(formattedLastName);
		
		lblArtistinfo = new JLabel("ArtistInfo");
		lblArtistinfo.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblArtistinfo, 0, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.SOUTH, lblArtistinfo, -6, SpringLayout.NORTH, lblArtistFirstName);
		add(lblArtistinfo);
		
		lblPaintingInfo_1 = new JLabel("Painting Info");
		lblPaintingInfo_1.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblPaintingInfo_1, 6, SpringLayout.SOUTH, formattedFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblPaintingInfo_1, 0, SpringLayout.WEST, lblPaintingInfo);
		add(lblPaintingInfo_1);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblTitleOfWork, 6, SpringLayout.SOUTH, lblPaintingInfo_1);
		springLayout.putConstraint(SpringLayout.WEST, lblTitleOfWork, 0, SpringLayout.WEST, scrollPane);
		lblTitleOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblTitleOfWork);
		
		
		lblTitleOfWork.setLabelFor(formattedTitle);
		springLayout.putConstraint(SpringLayout.NORTH, formattedTitle, 11, SpringLayout.SOUTH, lblTitleOfWork);
		springLayout.putConstraint(SpringLayout.WEST, formattedTitle, 0, SpringLayout.WEST, scrollPane);
		formattedTitle.setFont(new Font("Century", Font.PLAIN, 12));
		formattedTitle.setColumns(40);
		add(formattedTitle);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblDateOfWork, 6, SpringLayout.SOUTH, formattedTitle);
		springLayout.putConstraint(SpringLayout.WEST, lblDateOfWork, 0, SpringLayout.WEST, scrollPane);
		lblDateOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblDateOfWork);
		
		
		lblDateOfWork.setLabelFor(formattedDateOfWork);
		springLayout.putConstraint(SpringLayout.NORTH, formattedDateOfWork, 6, SpringLayout.SOUTH, lblDateOfWork);
		springLayout.putConstraint(SpringLayout.WEST, formattedDateOfWork, 0, SpringLayout.WEST, scrollPane);
		formattedDateOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		formattedDateOfWork.setColumns(10);
		add(formattedDateOfWork);
		
		
		lblDateSoldAt.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblDateSoldAt, 0, SpringLayout.NORTH, lblDateOfWork);
		springLayout.putConstraint(SpringLayout.WEST, lblDateSoldAt, 45, SpringLayout.EAST, lblDateOfWork);
		add(lblDateSoldAt);
		
		
		formattedDateAuction.setFont(new Font("Century", Font.PLAIN, 12));
		formattedDateAuction.setColumns(10);
		springLayout.putConstraint(SpringLayout.WEST, formattedDateAuction, 0, SpringLayout.WEST, lblDateSoldAt);
		springLayout.putConstraint(SpringLayout.SOUTH, formattedDateAuction, 0, SpringLayout.SOUTH, formattedDateOfWork);
		add(formattedDateAuction);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblPriceSoldAt, 6, SpringLayout.SOUTH, formattedTitle);
		springLayout.putConstraint(SpringLayout.WEST, lblPriceSoldAt, 73, SpringLayout.EAST, lblDateSoldAt);
		lblPriceSoldAt.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblPriceSoldAt);
		
		
		lblPriceSoldAt.setLabelFor(formattedSalePrice);
		formattedSalePrice.setFont(new Font("Century", Font.PLAIN, 12));
		formattedSalePrice.setColumns(20);
		springLayout.putConstraint(SpringLayout.NORTH, formattedSalePrice, 0, SpringLayout.NORTH, formattedDateOfWork);
		springLayout.putConstraint(SpringLayout.WEST, formattedSalePrice, 0, SpringLayout.WEST, lblPriceSoldAt);
		add(formattedSalePrice);
		
		
		lblHeightcm.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblHeightcm, 6, SpringLayout.SOUTH, formattedDateOfWork);
		springLayout.putConstraint(SpringLayout.WEST, lblHeightcm, 0, SpringLayout.WEST, scrollPane);
		add(lblHeightcm);
		
		
		lblHeightcm.setLabelFor(formattedHeight);
		formattedHeight.setFont(new Font("Century", Font.PLAIN, 12));
		formattedHeight.setColumns(5);
		springLayout.putConstraint(SpringLayout.NORTH, formattedHeight, 6, SpringLayout.SOUTH, lblHeightcm);
		springLayout.putConstraint(SpringLayout.WEST, formattedHeight, 0, SpringLayout.WEST, scrollPane);
		add(formattedHeight);
		
		
		lblWidthcm.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblWidthcm, 0, SpringLayout.WEST, lblDateSoldAt);
		springLayout.putConstraint(SpringLayout.SOUTH, lblWidthcm, 0, SpringLayout.SOUTH, lblHeightcm);
		add(lblWidthcm);
		
		
		lblWidthcm.setLabelFor(formattedWidth);
		formattedWidth.setColumns(5);
		formattedWidth.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, formattedWidth, 0, SpringLayout.NORTH, formattedHeight);
		springLayout.putConstraint(SpringLayout.WEST, formattedWidth, 0, SpringLayout.WEST, lblDateSoldAt);
		add(formattedWidth);
		
		
		lblMedium.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblMedium, 6, SpringLayout.SOUTH, formattedHeight);
		springLayout.putConstraint(SpringLayout.WEST, lblMedium, 0, SpringLayout.WEST, scrollPane);
		add(lblMedium);
		
		
		lblMedium.setLabelFor(textFieldMedium);
		textFieldMedium.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, textFieldMedium, 6, SpringLayout.SOUTH, lblMedium);
		springLayout.putConstraint(SpringLayout.WEST, textFieldMedium, 10, SpringLayout.WEST, this);
		add(textFieldMedium);
		textFieldMedium.setColumns(20);
		
		
		lblSubject.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblSubject, 6, SpringLayout.SOUTH, textFieldMedium);
		springLayout.putConstraint(SpringLayout.WEST, lblSubject, 0, SpringLayout.WEST, scrollPane);
		add(lblSubject);
		
		
		lblSubject.setLabelFor(textFieldSubject);
		textFieldSubject.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, textFieldSubject, 6, SpringLayout.SOUTH, lblSubject);
		springLayout.putConstraint(SpringLayout.WEST, textFieldSubject, 0, SpringLayout.WEST, scrollPane);
		add(textFieldSubject);
		textFieldSubject.setColumns(20);
		
		
		springLayout.putConstraint(SpringLayout.SOUTH, btnSaveChanges, -28, SpringLayout.SOUTH, this);
		btnSaveChanges.setPreferredSize(new Dimension(150, 40));
		btnSaveChanges.setMnemonic('S');
		springLayout.putConstraint(SpringLayout.NORTH, btnSaveChanges, -73, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnSaveChanges, 0, SpringLayout.WEST, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, btnSaveChanges, 160, SpringLayout.WEST, this);
		add(btnSaveChanges);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, btnDelete, 72, SpringLayout.SOUTH, textFieldSubject);
		springLayout.putConstraint(SpringLayout.WEST, btnDelete, 210, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnDelete, -28, SpringLayout.SOUTH, this);
		btnDelete.setMnemonic('D');
		add(btnDelete);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 216, SpringLayout.SOUTH, formattedSalePrice);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancel, -28, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnCancel, -205, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnDelete, -69, SpringLayout.WEST, btnCancel);
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 0, SpringLayout.WEST, lblPriceSoldAt);
		btnCancel.setMnemonic('C');
		add(btnCancel);
		
	}
	
	/**
	 * Desc: Method to create a format for the strings to be entered. 
	 * 		 Taken from the Java "How to use Formatted Text Fields" site.
	 * @param s what the format will be.
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
}
