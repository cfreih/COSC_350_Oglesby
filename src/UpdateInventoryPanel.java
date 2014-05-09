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
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;


public class UpdateInventoryPanel extends JPanel {
	
	private SpringLayout springLayout;
	
	private JLabel lblPaintingInfo;
	private JScrollPane scrollPane;
	private JTable paintingsTable;
	
	private JLabel lblArtistinfo;
	private JLabel lblArtistFirstName;
	private JFormattedTextField formattedFirstName;
	private JLabel lblArtistLastName;
	private JFormattedTextField formattedLastName;
	
	private JLabel lblNewPaintingInfo;
	private JLabel lblTitleOfWork;
	private JFormattedTextField formattedTitle;
	private JLabel lblDateOfWork;
	private JFormattedTextField formattedDateOfWork;
	private JLabel lblClassification;	
	private JFormattedTextField formattedClassification;
	private JLabel lblHeightcm;
	private JFormattedTextField formattedHeight;
	private JLabel lblWidthcm;
	private JFormattedTextField formattedWidth;
	private JLabel lblMedium;
	private JTextField textFieldMedium;
	private JLabel lblSubject;
	private JTextField textFieldSubject;
	private JLabel lblNameOfSeller;
	private JFormattedTextField formattedNameofSeller;
	private JLabel lblAddressOfSeller;
	private JFormattedTextField formattedAddressOfSeller;
	private JLabel lblActualPurchasePrice;
	private JFormattedTextField formattedActualPurchasePrice;
	private JLabel lblNameOfBuyer;
	private JFormattedTextField formattedNameOfBuyer;
	private JLabel lblAddressOfBuyer;
	private JFormattedTextField formattedAddressOfBuyer;
	private JLabel lblActualSellingPrice;
	private JFormattedTextField formattedActualSellingPrice;
	private JButton btnSaveChanges;
	private JButton btnDelete;
	private JButton btnCancel;
	
	public UpdateInventoryPanel()
	{
		springLayout = new SpringLayout();
		lblPaintingInfo = new JLabel("Current Painting Info");
		paintingsTable = new JTable();
		scrollPane = new JScrollPane(paintingsTable);
		
		
		lblArtistinfo = new JLabel("Artist Info");		
		lblArtistFirstName = new JLabel("Artist First Name (max 20 characters)");
		formattedFirstName = new JFormattedTextField(createFormatter("********************"));
		lblArtistLastName = new JLabel("Artist Last Name (max 20 characters)");
		formattedLastName = new JFormattedTextField(createFormatter("********************"));
		
		lblNewPaintingInfo = new JLabel("Painting Info");
		lblTitleOfWork = new JLabel("Title of Work (max 40 characters)");
		formattedTitle = new JFormattedTextField(createFormatter("****************************************"));
		lblDateOfWork = new JLabel("Date of Work (yyyy)");		
		formattedDateOfWork = new JFormattedTextField(createFormatter("####'?"));
		lblHeightcm = new JLabel("Height(cm)");
		formattedHeight = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblWidthcm = new JLabel("Width (cm)");
		formattedWidth = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblMedium = new JLabel("Medium");
		textFieldMedium = new JTextField();
		lblSubject = new JLabel("Subject");
		textFieldSubject = new JTextField();
		lblClassification = new JLabel("Classification");
		formattedClassification = new JFormattedTextField(createFormatter("********************"));
		lblNameOfSeller = new JLabel("Name of Seller");
		formattedNameofSeller = new JFormattedTextField();
		lblAddressOfSeller = new JLabel("Address of Seller");
		formattedAddressOfSeller = new JFormattedTextField();
		lblActualPurchasePrice = new JLabel("Actual Purchase Price");
		formattedActualPurchasePrice = new JFormattedTextField();
		lblNameOfBuyer = new JLabel("Name of Buyer");
		formattedNameOfBuyer = new JFormattedTextField();
		lblAddressOfBuyer = new JLabel("Address of Buyer");
		formattedAddressOfBuyer = new JFormattedTextField();
		lblActualSellingPrice = new JLabel("Actual Selling Price");
		formattedActualSellingPrice = new JFormattedTextField();
		btnSaveChanges = new JButton("Save Changes");
		btnDelete = new JButton("Delete");
		btnCancel = new JButton("Cancel");
				
		springLayout.putConstraint(SpringLayout.WEST, lblTitleOfWork, 15, SpringLayout.WEST, lblPaintingInfo);
		
		
		
		springLayout.putConstraint(SpringLayout.NORTH, formattedTitle, 5, SpringLayout.SOUTH, lblTitleOfWork);
		springLayout.putConstraint(SpringLayout.WEST, formattedTitle, 10, SpringLayout.WEST, lblTitleOfWork);
		

		springLayout.putConstraint(SpringLayout.NORTH, lblDateOfWork, 5, SpringLayout.SOUTH, formattedTitle);
		springLayout.putConstraint(SpringLayout.WEST, lblDateOfWork, 15, SpringLayout.WEST, lblPaintingInfo);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, formattedDateOfWork, 5, SpringLayout.SOUTH, lblDateOfWork);
		springLayout.putConstraint(SpringLayout.WEST, formattedDateOfWork, 10, SpringLayout.WEST, lblDateOfWork);
		
		
		springLayout.putConstraint(SpringLayout.WEST, lblHeightcm, 15, SpringLayout.WEST, lblPaintingInfo);
		
		
		springLayout.putConstraint(SpringLayout.WEST, formattedHeight, 10, SpringLayout.WEST, lblHeightcm);
		
		
		springLayout.putConstraint(SpringLayout.WEST, lblWidthcm, 91, SpringLayout.EAST, lblHeightcm);
		
		
		springLayout.putConstraint(SpringLayout.WEST, formattedWidth, 10, SpringLayout.WEST, lblWidthcm);
		
		
		springLayout.putConstraint(SpringLayout.WEST, lblMedium, 15, SpringLayout.WEST, lblPaintingInfo);
		
		
		
		springLayout.putConstraint(SpringLayout.NORTH, textFieldMedium, 5, SpringLayout.SOUTH, lblMedium);
		springLayout.putConstraint(SpringLayout.WEST, textFieldMedium, 10, SpringLayout.WEST, lblMedium);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblSubject, 0, SpringLayout.NORTH, lblMedium);
		springLayout.putConstraint(SpringLayout.WEST, lblSubject, 0, SpringLayout.WEST, lblArtistLastName);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, textFieldSubject, 5, SpringLayout.SOUTH, lblSubject);
		springLayout.putConstraint(SpringLayout.WEST, textFieldSubject, 10, SpringLayout.WEST, lblSubject);
		
		setUpPanel();
	}

	public void setUpPanel()
	{
		setLayout(springLayout);
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new TitledBorder(null, "Manage Inventory Paintings", TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		
		lblPaintingInfo.setFont(new Font("Century", Font.BOLD, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblPaintingInfo, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblPaintingInfo, 0, SpringLayout.WEST, this);
		add(lblPaintingInfo);
				
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.SOUTH, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 60, SpringLayout.SOUTH, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -8, SpringLayout.EAST, this);
		add(scrollPane);
		
		/**
		 * Need to get a painting and make that the Object[][] array that will be the one row in the table.
		 */
		paintingsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		paintingsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Artist First Name", "Arist Last Name", "Title", "Date of Work", "Classification", "Height", "Width", "Medium", "Subject", "Date of Purchase", "Name of Seller", "Address of Seller", "Maximun Purchase Price", "Actual Purchase Price", "Target Selling Price", "Date of Sale", "Name of Buyer", "Address of Buyer", "Actual Selling Price"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, Object.class, Integer.class, Integer.class, String.class, String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
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
		paintingsTable.getColumnModel().getColumn(9).setPreferredWidth(107);
		paintingsTable.getColumnModel().getColumn(10).setPreferredWidth(83);
		paintingsTable.getColumnModel().getColumn(12).setPreferredWidth(134);
		paintingsTable.getColumnModel().getColumn(13).setPreferredWidth(122);
		paintingsTable.getColumnModel().getColumn(14).setPreferredWidth(105);
		paintingsTable.getColumnModel().getColumn(16).setPreferredWidth(83);
		paintingsTable.getColumnModel().getColumn(17).setPreferredWidth(93);
		paintingsTable.getColumnModel().getColumn(18).setPreferredWidth(101);
		paintingsTable.setFont(new Font("Century", Font.PLAIN, 12));
		paintingsTable.setCellSelectionEnabled(true);
		scrollPane.add(paintingsTable);
		
		
		lblArtistinfo.setFont(new Font("Century", Font.BOLD, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblArtistinfo, 10, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistinfo, 5, SpringLayout.SOUTH, scrollPane);
		add(lblArtistinfo);
		
		lblArtistFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblArtistFirstName, 15, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistFirstName, 5, SpringLayout.SOUTH, lblArtistinfo);
		add(lblArtistFirstName);
				
		lblArtistFirstName.setLabelFor(formattedFirstName);
		
		formattedFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, formattedFirstName, 10, SpringLayout.WEST, lblArtistFirstName);
		springLayout.putConstraint(SpringLayout.NORTH, formattedFirstName, 5, SpringLayout.SOUTH, lblArtistFirstName);
		formattedFirstName.setColumns(20);
		add(formattedFirstName);
		
		lblArtistLastName.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistLastName, 0, SpringLayout.NORTH, lblArtistFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblArtistLastName, 100, SpringLayout.EAST, lblArtistFirstName);
		add(lblArtistLastName);
				
		lblArtistLastName.setLabelFor(formattedLastName);
		
		formattedLastName.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, formattedLastName, 5, SpringLayout.SOUTH, lblArtistLastName);
		springLayout.putConstraint(SpringLayout.WEST, formattedLastName, 10, SpringLayout.WEST, lblArtistLastName);
		formattedLastName.setColumns(20);
		add(formattedLastName);
				
		springLayout.putConstraint(SpringLayout.NORTH, lblNewPaintingInfo, 31, SpringLayout.SOUTH, lblArtistFirstName);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblTitleOfWork, 5, SpringLayout.SOUTH, lblNewPaintingInfo);
		springLayout.putConstraint(SpringLayout.WEST, lblNewPaintingInfo, 10, SpringLayout.WEST, lblPaintingInfo);
		lblNewPaintingInfo.setFont(new Font("Century", Font.BOLD, 12));
		add(lblNewPaintingInfo);
		lblTitleOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblTitleOfWork);
		
		
		lblTitleOfWork.setLabelFor(formattedTitle);
		formattedTitle.setFont(new Font("Century", Font.PLAIN, 12));
		formattedTitle.setColumns(40);
		add(formattedTitle);
		lblDateOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblDateOfWork);
		
		
		lblDateOfWork.setLabelFor(formattedDateOfWork);
		formattedDateOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		formattedDateOfWork.setColumns(10);
		add(formattedDateOfWork);
		
		
		lblHeightcm.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblHeightcm);
		
		
		lblHeightcm.setLabelFor(formattedHeight);
		formattedHeight.setFont(new Font("Century", Font.PLAIN, 12));
		formattedHeight.setColumns(5);
		springLayout.putConstraint(SpringLayout.NORTH, formattedHeight, 6, SpringLayout.SOUTH, lblHeightcm);
		add(formattedHeight);
		
		
		lblWidthcm.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.SOUTH, lblWidthcm, 0, SpringLayout.SOUTH, lblHeightcm);
		add(lblWidthcm);
		
		
		lblWidthcm.setLabelFor(formattedWidth);
		formattedWidth.setColumns(5);
		formattedWidth.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, formattedWidth, 0, SpringLayout.NORTH, formattedHeight);
		add(formattedWidth);
		
		
		lblMedium.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblMedium, 6, SpringLayout.SOUTH, formattedHeight);
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
				
		springLayout.putConstraint(SpringLayout.NORTH, lblClassification, 5, SpringLayout.SOUTH, formattedDateOfWork);
		lblClassification.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblClassification, 15, SpringLayout.WEST, lblPaintingInfo);
		add(lblClassification);
				
		springLayout.putConstraint(SpringLayout.NORTH, lblHeightcm, 5, SpringLayout.SOUTH, formattedClassification);
		formattedClassification.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, formattedClassification, 10, SpringLayout.WEST, lblClassification);
		formattedClassification.setColumns(20);
		springLayout.putConstraint(SpringLayout.NORTH, formattedClassification, 6, SpringLayout.SOUTH, lblClassification);
		add(formattedClassification);
				
		lblNameOfSeller.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblNameOfSeller, 5, SpringLayout.SOUTH, textFieldMedium);
		springLayout.putConstraint(SpringLayout.WEST, lblNameOfSeller, 15, SpringLayout.WEST, lblPaintingInfo);
		add(lblNameOfSeller);
				
		formattedNameofSeller.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, formattedNameofSeller, 5, SpringLayout.SOUTH, lblNameOfSeller);
		formattedNameofSeller.setColumns(42);
		springLayout.putConstraint(SpringLayout.WEST, formattedNameofSeller, 10, SpringLayout.WEST, lblNameOfSeller);
		add(formattedNameofSeller);
				
		lblAddressOfSeller.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblAddressOfSeller, 8, SpringLayout.SOUTH, formattedNameofSeller);
		springLayout.putConstraint(SpringLayout.WEST, lblAddressOfSeller, 15, SpringLayout.WEST, lblPaintingInfo);
		add(lblAddressOfSeller);
				
		springLayout.putConstraint(SpringLayout.NORTH, formattedAddressOfSeller, 5, SpringLayout.SOUTH, lblAddressOfSeller);
		springLayout.putConstraint(SpringLayout.WEST, formattedAddressOfSeller, 10, SpringLayout.WEST, lblAddressOfSeller);
		formattedAddressOfSeller.setFont(new Font("Century", Font.PLAIN, 12));
		formattedAddressOfSeller.setColumns(42);
		add(formattedAddressOfSeller);
				
		lblActualPurchasePrice.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblActualPurchasePrice, 5, SpringLayout.SOUTH, formattedAddressOfSeller);
		springLayout.putConstraint(SpringLayout.WEST, lblActualPurchasePrice, 15, SpringLayout.WEST, lblPaintingInfo);
		add(lblActualPurchasePrice);
				
		formattedActualPurchasePrice.setFont(new Font("Century", Font.PLAIN, 12));
		formattedActualPurchasePrice.setColumns(20);
		springLayout.putConstraint(SpringLayout.NORTH, formattedActualPurchasePrice, 5, SpringLayout.SOUTH, lblActualPurchasePrice);
		springLayout.putConstraint(SpringLayout.WEST, formattedActualPurchasePrice, 10, SpringLayout.WEST, lblActualPurchasePrice);
		add(formattedActualPurchasePrice);
				
		
		lblNameOfBuyer.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblNameOfBuyer, 5, SpringLayout.SOUTH, formattedActualPurchasePrice);
		springLayout.putConstraint(SpringLayout.WEST, lblNameOfBuyer, 15, SpringLayout.WEST, lblPaintingInfo);
		add(lblNameOfBuyer);
			
		
		formattedNameOfBuyer.setFont(new Font("Century", Font.PLAIN, 12));
		formattedNameOfBuyer.setColumns(42);
		springLayout.putConstraint(SpringLayout.NORTH, formattedNameOfBuyer, 5, SpringLayout.SOUTH, lblNameOfBuyer);
		springLayout.putConstraint(SpringLayout.WEST, formattedNameOfBuyer, 10, SpringLayout.WEST, lblNameOfBuyer);
		add(formattedNameOfBuyer);
		
		
		lblAddressOfBuyer.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblAddressOfBuyer, 5, SpringLayout.SOUTH, formattedNameOfBuyer);
		springLayout.putConstraint(SpringLayout.WEST, lblAddressOfBuyer, 15, SpringLayout.WEST, lblPaintingInfo);
		add(lblAddressOfBuyer);
						
		formattedAddressOfBuyer.setFont(new Font("Century", Font.PLAIN, 12));
		formattedAddressOfBuyer.setColumns(42);
		springLayout.putConstraint(SpringLayout.NORTH, formattedAddressOfBuyer, 5, SpringLayout.SOUTH, lblAddressOfBuyer);
		springLayout.putConstraint(SpringLayout.WEST, formattedAddressOfBuyer, 10, SpringLayout.WEST, lblAddressOfBuyer);
		add(formattedAddressOfBuyer);
		
		
		lblActualSellingPrice.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblActualSellingPrice, 5, SpringLayout.SOUTH, formattedAddressOfBuyer);
		springLayout.putConstraint(SpringLayout.WEST, lblActualSellingPrice, 15, SpringLayout.WEST, lblPaintingInfo);
		add(lblActualSellingPrice);
		
		
		formattedActualSellingPrice.setFont(new Font("Century", Font.PLAIN, 12));
		formattedActualSellingPrice.setColumns(20);
		springLayout.putConstraint(SpringLayout.NORTH, formattedActualSellingPrice, 5, SpringLayout.SOUTH, lblActualSellingPrice);
		springLayout.putConstraint(SpringLayout.WEST, formattedActualSellingPrice, 10, SpringLayout.WEST, lblActualSellingPrice);
		add(formattedActualSellingPrice);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, btnSaveChanges, 15, SpringLayout.SOUTH, formattedActualSellingPrice);
		springLayout.putConstraint(SpringLayout.WEST, btnSaveChanges, 35, SpringLayout.WEST, lblPaintingInfo);
		add(btnSaveChanges);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, btnDelete, 0, SpringLayout.NORTH, btnSaveChanges);
		springLayout.putConstraint(SpringLayout.WEST, btnDelete, 25, SpringLayout.EAST, btnSaveChanges);
		add(btnDelete);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 0, SpringLayout.NORTH, btnDelete);
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 25, SpringLayout.EAST, btnDelete);
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
