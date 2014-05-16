import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.text.NumberFormat;


public class UpdateInventoryPanel extends JScrollPane {
	private InventoryPainting origPainting;
	
	private JPanel updateInventoryPanel; 
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
	private JFormattedTextField formattedMedium;
	private JLabel lblSubject;
	private JFormattedTextField formattedSubject;
	private JLabel lblNameOfSeller;
	private JFormattedTextField formattedSellerName;
	private JLabel lblAddressOfSeller;
	private JFormattedTextField formattedSellerAddress;
	private JLabel lblActualPurchasePrice;
	private JFormattedTextField formattedActualPurchasePrice;
	private JLabel lblNameOfBuyer;
	private JFormattedTextField formattedBuyerName;
	private JLabel lblAddressOfBuyer;
	private JFormattedTextField formattedBuyerAddress;
	private JLabel lblActualSellingPrice;
	private JFormattedTextField formattedActualSellingPrice;
	private JButton btnSaveChanges;
	private JButton btnDelete;
	private JButton btnCancel;
	
	private DefaultTableModel tableModel;

	
	public UpdateInventoryPanel(){
		
		origPainting =new InventoryPainting();
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);		
		updateInventoryPanel = new JPanel();
		springLayout = new SpringLayout();
		lblPaintingInfo = new JLabel("Selected Painting Info");
		
		paintingsTable = new JTable();
		scrollPane = new JScrollPane(paintingsTable);
		
		lblArtistinfo = new JLabel("Artist Info");		
		lblArtistFirstName = new JLabel("Artist First Name (max 20 characters)");
		formattedFirstName = new JFormattedTextField(createFormatter("*****************"));
		lblArtistLastName = new JLabel("Artist Last Name (max 20 characters)");
		formattedLastName = new JFormattedTextField(createFormatter("*****************"));
		
		lblNewPaintingInfo = new JLabel("Painting Info");
		lblTitleOfWork = new JLabel("Title of Work (max 40 characters)");
		formattedTitle = new JFormattedTextField(createFormatter("****************************************"));
		lblDateOfWork = new JLabel("Date of Work (yyyy)");		
		formattedDateOfWork = new JFormattedTextField(createFormatter("####*"));
		lblHeightcm = new JLabel("Height(cm)");
		formattedHeight = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblWidthcm = new JLabel("Width (cm)");
		formattedWidth = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblMedium = new JLabel("Medium");
		formattedMedium = new JFormattedTextField(createFormatter("*************************"));
		lblSubject = new JLabel("Subject");
		formattedSubject = new JFormattedTextField(createFormatter("*************************"));
		lblClassification = new JLabel("Classification");
		formattedClassification = new JFormattedTextField(createFormatter("******************************"));
		lblNameOfSeller = new JLabel("Name of Seller");
		formattedSellerName = new JFormattedTextField(createFormatter("******************************************"));
		lblAddressOfSeller = new JLabel("Address of Seller");
		formattedSellerAddress = new JFormattedTextField(createFormatter("******************************************"));
		lblActualPurchasePrice = new JLabel("Actual Purchase Price");
		formattedActualPurchasePrice = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblNameOfBuyer = new JLabel("Name of Buyer");
		formattedBuyerName = new JFormattedTextField(createFormatter("******************************************"));
		lblAddressOfBuyer = new JLabel("Address of Buyer");
		formattedBuyerAddress = new JFormattedTextField(createFormatter("******************************************"));
		lblActualSellingPrice = new JLabel("Actual Selling Price");
		formattedActualSellingPrice = new JFormattedTextField(NumberFormat.getNumberInstance());
		btnSaveChanges = new JButton("Save Changes");
		btnDelete = new JButton("Delete");
		btnCancel = new JButton("Cancel");
        btnSaveChanges.setFont(new Font("Cambria", Font.BOLD, 12));
        btnDelete.setFont(new Font("Cambria", Font.BOLD, 12));
        btnCancel.setFont(new Font("Cambria", Font.BOLD, 12));
		setUpPanel();
	}
	
	public void setUpPanel(){
		
		setMinimumSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));
		
		updateInventoryPanel.setLayout(springLayout);
		updateInventoryPanel.setPreferredSize(new Dimension(765, 750));		
		updateInventoryPanel.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
									   null, null), new TitledBorder(null, "Manage Inventory Paintings",
									   TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		
		lblPaintingInfo.setFont(new Font("Century", Font.BOLD, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblPaintingInfo, 0, SpringLayout.NORTH, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.WEST, lblPaintingInfo, 10, SpringLayout.WEST, updateInventoryPanel);
		updateInventoryPanel.add(lblPaintingInfo);
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.SOUTH, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 60, SpringLayout.SOUTH, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -8, SpringLayout.EAST, updateInventoryPanel);
		updateInventoryPanel.add(scrollPane);
		
		/**
		 * Need to get a painting and make that the Object[][] array that will be the one row in the table.
		 */
		paintingsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableModel =new DefaultTableModel(new Object[][] {origPainting.toTableRow()},
				new String[] {
					"Artist First Name", "Arist Last Name", "Title", "Date of Work",
					"Classification", "Height", "Width", "Medium", "Subject",
					"Date of Purchase", "Name of Seller", "Address of Seller",
					"Maximun Purchase Price", "Actual Purchase Price", "Target Selling Price",
					"Date of Sale", "Name of Buyer", "Address of Buyer", "Actual Selling Price"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, Integer.class, Object.class, Integer.class, Integer.class, String.class, String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
				
		paintingsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", "", "", new Double(-1.0), new Double(-1.0), "", "", null, "", "", new Double(-1.0), new Double(-1.0), "-1/-1/1 B.C.E.", "", "", new Double(-1.0), null},
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
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		paintingsTable.getColumnModel().getColumn(0).setPreferredWidth(155);
		paintingsTable.getColumnModel().getColumn(0).setMinWidth(155);
		paintingsTable.getColumnModel().getColumn(0).setMaxWidth(155);
		paintingsTable.getColumnModel().getColumn(1).setPreferredWidth(155);
		paintingsTable.getColumnModel().getColumn(1).setMinWidth(155);
		paintingsTable.getColumnModel().getColumn(1).setMaxWidth(155);
		paintingsTable.getColumnModel().getColumn(2).setPreferredWidth(155);
		paintingsTable.getColumnModel().getColumn(2).setMinWidth(155);
		paintingsTable.getColumnModel().getColumn(2).setMaxWidth(155);
		paintingsTable.getColumnModel().getColumn(3).setPreferredWidth(155);
		paintingsTable.getColumnModel().getColumn(3).setMinWidth(155);
		paintingsTable.getColumnModel().getColumn(3).setMaxWidth(155);
		paintingsTable.getColumnModel().getColumn(4).setPreferredWidth(155);
		paintingsTable.getColumnModel().getColumn(4).setMinWidth(155);
		paintingsTable.getColumnModel().getColumn(4).setMaxWidth(155);
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
		paintingsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(paintingsTable);
		
		lblArtistinfo.setFont(new Font("Century", Font.BOLD, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblArtistinfo, 10, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistinfo, 5, SpringLayout.SOUTH, scrollPane);
		updateInventoryPanel.add(lblArtistinfo);
		
		lblArtistFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblArtistFirstName, 15, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistFirstName, 5, SpringLayout.SOUTH, lblArtistinfo);
		updateInventoryPanel.add(lblArtistFirstName);
				
		formattedFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, formattedFirstName, 10, SpringLayout.WEST, lblArtistFirstName);
		springLayout.putConstraint(SpringLayout.NORTH, formattedFirstName, 5, SpringLayout.SOUTH, lblArtistFirstName);
		formattedFirstName.setColumns(20);
		updateInventoryPanel.add(formattedFirstName);
		
		lblArtistLastName.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistLastName, 0, SpringLayout.NORTH, lblArtistFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblArtistLastName, 100, SpringLayout.EAST, lblArtistFirstName);
		updateInventoryPanel.add(lblArtistLastName);
				
		formattedLastName.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, formattedLastName, 5, SpringLayout.SOUTH, lblArtistLastName);
		springLayout.putConstraint(SpringLayout.WEST, formattedLastName, 10, SpringLayout.WEST, lblArtistLastName);
		formattedLastName.setColumns(20);
		updateInventoryPanel.add(formattedLastName);
		
		lblNewPaintingInfo.setFont(new Font("Century", Font.BOLD, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblNewPaintingInfo, 10, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewPaintingInfo, 31, SpringLayout.SOUTH, lblArtistFirstName);
		updateInventoryPanel.add(lblNewPaintingInfo);
		
		lblTitleOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblTitleOfWork, 15, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.NORTH, lblTitleOfWork, 5, SpringLayout.SOUTH, lblNewPaintingInfo);
		updateInventoryPanel.add(lblTitleOfWork);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, formattedTitle, 5, SpringLayout.SOUTH, lblTitleOfWork);
		springLayout.putConstraint(SpringLayout.WEST, formattedTitle, 10, SpringLayout.WEST, lblTitleOfWork);
		formattedTitle.setColumns(40);
		updateInventoryPanel.add(formattedTitle);
		
		lblDateOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblDateOfWork, 5, SpringLayout.SOUTH, formattedTitle);
		springLayout.putConstraint(SpringLayout.WEST, lblDateOfWork, 15, SpringLayout.WEST, lblPaintingInfo);
		updateInventoryPanel.add(lblDateOfWork);
						
		formattedDateOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, formattedDateOfWork, 5, SpringLayout.SOUTH, lblDateOfWork);
		springLayout.putConstraint(SpringLayout.WEST, formattedDateOfWork, 10, SpringLayout.WEST, lblDateOfWork);		
		formattedDateOfWork.setColumns(5);
		updateInventoryPanel.add(formattedDateOfWork);
		
		lblClassification.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblClassification, 15, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.NORTH, lblClassification, 5, SpringLayout.SOUTH, formattedDateOfWork);
		updateInventoryPanel.add(lblClassification);
				
		formattedClassification.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, formattedClassification, 10, SpringLayout.WEST, lblClassification);
		springLayout.putConstraint(SpringLayout.NORTH, formattedClassification, 6, SpringLayout.SOUTH, lblClassification);
		formattedClassification.setColumns(20);		
		updateInventoryPanel.add(formattedClassification);
				
		lblHeightcm.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblHeightcm, 15, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.NORTH, lblHeightcm, 5, SpringLayout.SOUTH, formattedClassification);
		updateInventoryPanel.add(lblHeightcm);
						
		formattedHeight.setFont(new Font("Century", Font.PLAIN, 12));
		formattedHeight.setColumns(5);
		springLayout.putConstraint(SpringLayout.WEST, formattedHeight, 10, SpringLayout.WEST, lblHeightcm);
		springLayout.putConstraint(SpringLayout.NORTH, formattedHeight, 6, SpringLayout.SOUTH, lblHeightcm);
		updateInventoryPanel.add(formattedHeight);
				
		lblWidthcm.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblWidthcm, 91, SpringLayout.EAST, lblHeightcm);
		springLayout.putConstraint(SpringLayout.SOUTH, lblWidthcm, 0, SpringLayout.SOUTH, lblHeightcm);
		updateInventoryPanel.add(lblWidthcm);
						
		formattedWidth.setFont(new Font("Century", Font.PLAIN, 12));
		formattedWidth.setColumns(5);
		springLayout.putConstraint(SpringLayout.WEST, formattedWidth, 10, SpringLayout.WEST, lblWidthcm);
		springLayout.putConstraint(SpringLayout.NORTH, formattedWidth, 0, SpringLayout.NORTH, formattedHeight);
		updateInventoryPanel.add(formattedWidth);
				
		lblMedium.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblMedium, 15, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.NORTH, lblMedium, 6, SpringLayout.SOUTH, formattedHeight);
		updateInventoryPanel.add(lblMedium);
					
		formattedMedium.setFont(new Font("Century", Font.PLAIN, 12));
		formattedMedium.setColumns(20);
		springLayout.putConstraint(SpringLayout.NORTH, formattedMedium, 5, SpringLayout.SOUTH, lblMedium);
		springLayout.putConstraint(SpringLayout.WEST, formattedMedium, 10, SpringLayout.WEST, lblMedium);
		updateInventoryPanel.add(formattedMedium);		
		
		lblSubject.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblSubject, 0, SpringLayout.WEST, lblArtistLastName);
		springLayout.putConstraint(SpringLayout.NORTH, lblSubject, 0, SpringLayout.NORTH, lblMedium);
		updateInventoryPanel.add(lblSubject);
				
		formattedSubject.setFont(new Font("Century", Font.PLAIN, 12));
		formattedSubject.setColumns(20);
		springLayout.putConstraint(SpringLayout.NORTH, formattedSubject, 5, SpringLayout.SOUTH, lblSubject);
		springLayout.putConstraint(SpringLayout.WEST, formattedSubject, 10, SpringLayout.WEST, lblSubject);
		updateInventoryPanel.add(formattedSubject);
						
		lblNameOfSeller.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblNameOfSeller, 5, SpringLayout.SOUTH, formattedMedium);
		springLayout.putConstraint(SpringLayout.WEST, lblNameOfSeller, 15, SpringLayout.WEST, lblPaintingInfo);
		updateInventoryPanel.add(lblNameOfSeller);
				
		formattedSellerName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedSellerName.setColumns(42);
		springLayout.putConstraint(SpringLayout.WEST, formattedSellerName, 10, SpringLayout.WEST, lblNameOfSeller);
		springLayout.putConstraint(SpringLayout.NORTH, formattedSellerName, 5, SpringLayout.SOUTH, lblNameOfSeller);
		updateInventoryPanel.add(formattedSellerName);
				
		lblAddressOfSeller.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblAddressOfSeller, 15, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.NORTH, lblAddressOfSeller, 8, SpringLayout.SOUTH, formattedSellerName);
		updateInventoryPanel.add(lblAddressOfSeller);
		
		formattedSellerAddress.setFont(new Font("Century", Font.PLAIN, 12));
		formattedSellerAddress.setColumns(42);
		springLayout.putConstraint(SpringLayout.WEST, formattedSellerAddress, 10, SpringLayout.WEST, lblAddressOfSeller);
		springLayout.putConstraint(SpringLayout.NORTH, formattedSellerAddress, 5, SpringLayout.SOUTH, lblAddressOfSeller);
		updateInventoryPanel.add(formattedSellerAddress);
				
		lblActualPurchasePrice.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblActualPurchasePrice, 15, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.NORTH, lblActualPurchasePrice, 5, SpringLayout.SOUTH, formattedSellerAddress);
		updateInventoryPanel.add(lblActualPurchasePrice);
				
		formattedActualPurchasePrice.setFont(new Font("Century", Font.PLAIN, 12));
		formattedActualPurchasePrice.setColumns(20);
		springLayout.putConstraint(SpringLayout.WEST, formattedActualPurchasePrice, 10, SpringLayout.WEST, lblActualPurchasePrice);
		springLayout.putConstraint(SpringLayout.NORTH, formattedActualPurchasePrice, 5, SpringLayout.SOUTH, lblActualPurchasePrice);
		updateInventoryPanel.add(formattedActualPurchasePrice);
						
		lblNameOfBuyer.setFont(new Font("Century", Font.PLAIN, 12));		
		springLayout.putConstraint(SpringLayout.WEST, lblNameOfBuyer, 15, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.NORTH, lblNameOfBuyer, 5, SpringLayout.SOUTH, formattedActualPurchasePrice);
		updateInventoryPanel.add(lblNameOfBuyer);
	
		formattedBuyerName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedBuyerName.setColumns(42);
		springLayout.putConstraint(SpringLayout.NORTH, formattedBuyerName, 5, SpringLayout.SOUTH, lblNameOfBuyer);
		springLayout.putConstraint(SpringLayout.WEST, formattedBuyerName, 10, SpringLayout.WEST, lblNameOfBuyer);
		updateInventoryPanel.add(formattedBuyerName);
		
		lblAddressOfBuyer.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblAddressOfBuyer, 15, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.NORTH, lblAddressOfBuyer, 5, SpringLayout.SOUTH, formattedBuyerName);
		updateInventoryPanel.add(lblAddressOfBuyer);
						
		formattedBuyerAddress.setFont(new Font("Century", Font.PLAIN, 12));
		formattedBuyerAddress.setColumns(42);
		springLayout.putConstraint(SpringLayout.WEST, formattedBuyerAddress, 10, SpringLayout.WEST, lblAddressOfBuyer);
		springLayout.putConstraint(SpringLayout.NORTH, formattedBuyerAddress, 5, SpringLayout.SOUTH, lblAddressOfBuyer);
		updateInventoryPanel.add(formattedBuyerAddress);
				
		lblActualSellingPrice.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblActualSellingPrice, 15, SpringLayout.WEST, lblPaintingInfo);
		springLayout.putConstraint(SpringLayout.NORTH, lblActualSellingPrice, 5, SpringLayout.SOUTH, formattedBuyerAddress);
		updateInventoryPanel.add(lblActualSellingPrice);
			
		formattedActualSellingPrice.setFont(new Font("Century", Font.PLAIN, 12));
		formattedActualSellingPrice.setColumns(20);
		springLayout.putConstraint(SpringLayout.WEST, formattedActualSellingPrice, 10, SpringLayout.WEST, lblActualSellingPrice);
		springLayout.putConstraint(SpringLayout.NORTH, formattedActualSellingPrice, 5, SpringLayout.SOUTH, lblActualSellingPrice);
		updateInventoryPanel.add(formattedActualSellingPrice);
				
		springLayout.putConstraint(SpringLayout.NORTH, btnSaveChanges, 15, SpringLayout.SOUTH, formattedActualSellingPrice);
		springLayout.putConstraint(SpringLayout.WEST, btnSaveChanges, 35, SpringLayout.WEST, lblPaintingInfo);
		updateInventoryPanel.add(btnSaveChanges);
				
		springLayout.putConstraint(SpringLayout.NORTH, btnDelete, 0, SpringLayout.NORTH, btnSaveChanges);
		springLayout.putConstraint(SpringLayout.WEST, btnDelete, 25, SpringLayout.EAST, btnSaveChanges);
		updateInventoryPanel.add(btnDelete);
				
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 0, SpringLayout.NORTH, btnDelete);
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 25, SpringLayout.EAST, btnDelete);
		updateInventoryPanel.add(btnCancel);		
		
		setViewportView(updateInventoryPanel);
	}	
	
	public void updateTableModel(InventoryPainting invPainting){
		origPainting = invPainting;
		Object[][] dataVector= {invPainting.toTableRow()};		
		String[] columnNames = new String[] {
				"Artist First Name", "Arist Last Name", "Title", "Date of Work",
				"Classification", "Height", "Width", "Medium", "Subject",
				"Date of Purchase", "Name of Seller", "Address of Seller",
				"Maximun Purchase Price", "Actual Purchase Price", "Target Selling Price",
				"Date of Sale", "Name of Buyer", "Address of Buyer", "Actual Selling Price"};
		TableModel model = new DefaultTableModel(dataVector, columnNames)
		{
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		};		
		paintingsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		paintingsTable.setModel(model);	
		paintingsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		enable_DisableSellFields();
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
	
	public boolean isInputValid(){
		boolean isValid =true;
		String[] fieldValues = getFieldValues();
		
		if(fieldValues[0] != ""){
			if(fieldValues[0].length()==21)
				if(fieldValues[0].charAt(20)!='?')
					return false;
		}
		if(fieldValues[1] != ""){
			if(fieldValues[1].length()==21)
				if(fieldValues[1].charAt(20)!='?')
					return false;			
		}
		if(fieldValues[2] != ""){
			if(fieldValues[2].length()==41)
				if(fieldValues[2].charAt(40)!='?')
					return false;			
		}
		if(fieldValues[3] != ""){
			if(fieldValues[3].length()==5){
				if(fieldValues[3].charAt(4)!='?'){
					fieldValues[3] = fieldValues[3].replace(fieldValues[3].substring(fieldValues[3].length()-1), "");
					return false;
				}	
			}
			int dateOfWork = Integer.parseInt(fieldValues[3]);
			SimpleDate today = new SimpleDate(SimpleDate.TODAY);
			if(dateOfWork < 1100 || dateOfWork > today.getYear())
				return false;
		}
		if(fieldValues[5] != ""){
			double height = Double.parseDouble(fieldValues[5]);
			if(height<0) return false;
		}
		if(fieldValues[6] != ""){
			double width = Double.parseDouble(fieldValues[6]);
			if(width<0) return false;
		}
		if(fieldValues[11] != ""){
			double actualPurchasePrice = Double.parseDouble(fieldValues[11]);
			if(actualPurchasePrice<0) return false;
		}				
		if(formattedActualSellingPrice.isEnabled()){
			if(fieldValues[14] != ""){
				double actualPurchasePrice = Double.parseDouble(fieldValues[14]);
				if(actualPurchasePrice<0) return false;
			}
		}
		return isValid;
	}
	
	public String[] getFieldValues()
	{
		String[] fieldValues = new String[15];
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
		if(formattedClassification.getValue() != null)
			fieldValues[4] = ((String) formattedClassification.getValue()).trim();
		fieldValues[5] = "";
		if(formattedHeight.getValue() != null)
			if(formattedHeight.getValue() instanceof Long)
				fieldValues[5] = Long.toString((Long) formattedHeight.getValue());
			else
				fieldValues[5] = Double.toString((Double) formattedHeight.getValue());
		fieldValues[6] = "";
		if(formattedWidth.getValue() != null)
			if(formattedWidth.getValue() instanceof Long)
				fieldValues[6] = Long.toString((Long) formattedWidth.getValue());
			else
				fieldValues[6] = Double.toString((Double) formattedWidth.getValue());
		fieldValues[7] = "";
		if(formattedMedium.getValue() != null)	
			fieldValues[7] = ((String) formattedMedium.getValue()).trim();
		fieldValues[8] = "";
		if(formattedSubject.getValue() != null)
			fieldValues[8] = ((String) formattedSubject.getValue()).trim();
		fieldValues[9] = "";
		if(formattedSellerName.getValue() != null)
			fieldValues[9] = ((String) formattedSellerName.getValue()).trim();
		fieldValues[10] = "";
		if(formattedSellerAddress.getValue() != null)
			fieldValues[10] = ((String) formattedSellerAddress.getValue()).trim();
		fieldValues[11] = "";
		if(formattedActualPurchasePrice.getValue() != null)
			if(formattedActualPurchasePrice.getValue() instanceof Long)
				fieldValues[11] = Long.toString((Long) formattedActualPurchasePrice.getValue());
			else
				fieldValues[11] = Double.toString((Double) formattedActualPurchasePrice.getValue()); 
		fieldValues[12] = "";
		if(formattedBuyerName.getValue() != null)
			fieldValues[12] = ((String) formattedBuyerName.getValue()).trim();
		fieldValues[13] = "";
		if(formattedBuyerAddress.getValue() != null)
			fieldValues[13] = ((String) formattedBuyerAddress.getValue()).trim();
		fieldValues[14] = "";
		if(formattedActualPurchasePrice.getValue() != null)
			if(formattedActualPurchasePrice.getValue() instanceof Long)
				fieldValues[14] = Long.toString((Long) formattedActualPurchasePrice.getValue());
			else
				fieldValues[14] = Double.toString((Double) formattedActualPurchasePrice.getValue());	
		return fieldValues;
	}
	
	public void resetTextFields(){
		formattedFirstName.setValue(null);
		formattedLastName.setValue(null);
		formattedTitle.setValue(null);
		formattedDateOfWork.setValue(null);
		formattedHeight.setValue(null);
		formattedWidth.setValue(null);
		formattedMedium.setValue(null);
		formattedSubject.setValue(null);		
		formattedClassification.setValue(null);
		formattedSellerName.setValue(null);
		formattedSellerAddress.setValue(null);
		formattedActualPurchasePrice.setValue(null);		
		formattedBuyerName.setValue(null);		
		formattedBuyerAddress.setValue(null);		
		formattedActualSellingPrice.setValue(null);
	}
	
	public void updateInventoryPainting(InventoryPainting update)
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
			update.setClassification(fieldValues[4]);
		if(fieldValues[5].length() > 0)
			update.setHeightCM(Double.parseDouble(fieldValues[5]));
		if(fieldValues[6].length() > 0)
			update.setWidthCM(Double.parseDouble(fieldValues[6]));
		if(fieldValues[7].length() > 0)
			update.setMedium(fieldValues[8]);
		if(fieldValues[8].length() > 0)
			update.setSubject(fieldValues[9]);
		if(fieldValues[9].length() > 0)
			update.setSellerName(fieldValues[9]);
		if(fieldValues[10].length() > 0)
			update.setSellerAddress(fieldValues[10]);
		if(fieldValues[11].length() > 0)
			update.setActualPurchasePrice(Double.parseDouble(fieldValues[11]));
		
		if(formattedBuyerName.isEnabled()){
			if(fieldValues[12].length() > 0)
				update.setBuyerName(fieldValues[12]);
			if(fieldValues[13].length() > 0)
				update.setBuyerAddress(fieldValues[13]);
			if(fieldValues[14].length() > 0)
				update.setActualSellPrice(Double.parseDouble(fieldValues[14]));			
		}		
					
	}
	
	public void enable_DisableSellFields(){
		if( origPainting.getDateOfSale().equals(new SimpleDate(SimpleDate.DEFAULT)) ){
			formattedBuyerName.setEnabled(false);
			formattedBuyerAddress.setEnabled(false);
			formattedActualSellingPrice.setEnabled(false);			
		} 
		else
		{
			formattedBuyerName.setEnabled(true);
			formattedBuyerAddress.setEnabled(true);
			formattedActualSellingPrice.setEnabled(true);	
		}
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

	public static void main( String[] args )
   	{
		InventoryPainting paint = new InventoryPainting();
		paint.setArtistFirstName("Micahel");
		paint.setArtistLastName("LeVan");
		paint.setTitleOfWork("Test1");
		//paint.setDateOfSale(1992, 07, 22);	
		
		UpdateInventoryPanel IP = new UpdateInventoryPanel();
		IP.updateTableModel(paint);
		IP.enable_DisableSellFields();
		JFrame frame =new JFrame("Test");		
		frame.getContentPane().add(IP , BorderLayout.CENTER);
		frame.setSize(800, 600);
		frame.setMaximumSize(new Dimension(800, 600));
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setVisible(true);	
	}

	public InventoryPainting getOrigPainting() {
		return origPainting;
	}
}
