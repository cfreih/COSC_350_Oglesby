import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;


public class AddPaintingInventoryPanel extends JScrollPane {

	private JPanel updateInventoryPanel; 
	private SpringLayout springLayout; 
	
	private JLabel lblArtistinfo;
	private JLabel lblWarning_1;
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
	private JLabel lblDateOfPurchase;
	private JFormattedTextField formattedDateOfPurchase;
	private JFormattedTextField formattedSubject;
	private JLabel lblSellerName;
	private JFormattedTextField formattedSellerName;
	private JLabel lblSellerAddress;
	private JFormattedTextField formattedSellerAddress;
	private JLabel lblActualPurchasePrice;
	private JFormattedTextField formattedActualPurchasePrice;
	private JLabel lblWarning_2;
	private JLabel lblDateOfSale;
	private JFormattedTextField formattedDateOfSale;
	private JLabel lblBuyerName;
	private JFormattedTextField formattedBuyerName;
	private JLabel lblBuyerAddress;
	private JFormattedTextField formattedBuyerAddress;
	private JLabel lblActualSellingPrice;
	private JFormattedTextField formattedActualSellingPrice;
	private JButton btnSaveNew;	
	private JButton btnCancel;
	
	public AddPaintingInventoryPanel(){
		
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);		
		updateInventoryPanel = new JPanel();
		
		springLayout = new SpringLayout();
		
		lblArtistinfo = new JLabel("Artist Info");
		lblWarning_1 = new JLabel("( * Indicates Required Fields )");		
		
		lblArtistFirstName = new JLabel("Artist First Name (max 20 characters) *");		
		formattedFirstName = new JFormattedTextField(createFormatter("A********************"));
		lblArtistLastName = new JLabel("Artist Last Name (max 20 characters) *");
		formattedLastName = new JFormattedTextField(createFormatter("A********************"));		
		lblNewPaintingInfo = new JLabel("Painting Info");
		lblTitleOfWork = new JLabel("Title of Work (max 40 characters) *");				
		formattedTitle = new JFormattedTextField(createFormatter("A****************************************"));
		lblDateOfWork = new JLabel("Date of Work (yyyy) *");		
		formattedDateOfWork = new JFormattedTextField(createFormatter("####*"));
		lblHeightcm = new JLabel("Height(cm) *");		
		formattedHeight = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblWidthcm = new JLabel("Width (cm) *");			
		formattedWidth = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblMedium = new JLabel("Medium *");		
		formattedMedium = new JFormattedTextField(createFormatter("A************************"));
		lblSubject = new JLabel("Subject *");
		formattedSubject = new JFormattedTextField(createFormatter("A************************"));
		lblDateOfPurchase = new JLabel("Date of Purchase *");
		formattedDateOfPurchase = new JFormattedTextField(createFormatter("##/##/####"));				
		lblClassification = new JLabel("Classification *");		
		formattedClassification = new JFormattedTextField(createFormatter("A*****************************"));
		lblSellerName = new JLabel("Name of Seller *");		
		formattedSellerName = new JFormattedTextField(createFormatter("A*****************************************"));
		lblSellerAddress = new JLabel("Address of Seller *");		
		formattedSellerAddress = new JFormattedTextField(createFormatter("A*****************************************"));
		lblActualPurchasePrice = new JLabel("Actual Purchase Price *");		
		formattedActualPurchasePrice = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblWarning_2 = new JLabel("( ** Must be all Provided OR all Blank )");
		lblDateOfSale = new JLabel("Date of Sale **");
		formattedDateOfSale = new JFormattedTextField(createFormatter("##/##/####"));
		lblBuyerName = new JLabel("Name of Buyer **");		
		formattedBuyerName = new JFormattedTextField(createFormatter("****************************************"));
		lblBuyerAddress = new JLabel("Address of Buyer **");		
		formattedBuyerAddress = new JFormattedTextField(createFormatter("****************************************"));
		lblActualSellingPrice = new JLabel("Actual Selling Price **");		
		formattedActualSellingPrice = new JFormattedTextField(NumberFormat.getNumberInstance());
		btnSaveNew = new JButton("Save New Painting");		
		btnCancel = new JButton("Cancel");
		
		setUpPanel();
	}
	
	public void setUpPanel(){
		
		setMinimumSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));
		
		updateInventoryPanel.setLayout(springLayout);
		updateInventoryPanel.setPreferredSize(new Dimension(765, 750));		
		updateInventoryPanel.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new TitledBorder(null, "Manage Inventory Paintings", TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		
		lblArtistinfo.setFont(new Font("Century", Font.BOLD, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistinfo, 5, SpringLayout.NORTH, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.WEST, lblArtistinfo, 10, SpringLayout.WEST, updateInventoryPanel);
		updateInventoryPanel.add(lblArtistinfo);		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblWarning_1, 0, SpringLayout.NORTH, lblArtistinfo);
		springLayout.putConstraint(SpringLayout.WEST, lblWarning_1, 10, SpringLayout.EAST, lblArtistinfo);
		updateInventoryPanel.add(lblWarning_1);
		
		lblArtistFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblArtistFirstName, 15, SpringLayout.WEST, updateInventoryPanel);
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
		springLayout.putConstraint(SpringLayout.WEST, lblNewPaintingInfo, 10, SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewPaintingInfo, 31, SpringLayout.SOUTH, lblArtistFirstName);
		updateInventoryPanel.add(lblNewPaintingInfo);
		
		lblTitleOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblTitleOfWork, 15, SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblTitleOfWork, 5, SpringLayout.SOUTH, lblNewPaintingInfo);
		updateInventoryPanel.add(lblTitleOfWork);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, formattedTitle, 5, SpringLayout.SOUTH, lblTitleOfWork);
		springLayout.putConstraint(SpringLayout.WEST, formattedTitle, 10, SpringLayout.WEST, lblTitleOfWork);
		formattedTitle.setColumns(40);
		updateInventoryPanel.add(formattedTitle);
		
		lblDateOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblDateOfWork, 15, SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblDateOfWork, 5, SpringLayout.SOUTH, formattedTitle);
		updateInventoryPanel.add(lblDateOfWork);
						
		formattedDateOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, formattedDateOfWork, 5, SpringLayout.SOUTH, lblDateOfWork);
		springLayout.putConstraint(SpringLayout.WEST, formattedDateOfWork, 10, SpringLayout.WEST, lblDateOfWork);		
		formattedDateOfWork.setColumns(5);
		updateInventoryPanel.add(formattedDateOfWork);
		
		lblClassification.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblClassification, 0, SpringLayout.WEST, lblArtistLastName);
		springLayout.putConstraint(SpringLayout.NORTH, lblClassification, 0, SpringLayout.NORTH, lblDateOfWork);
		updateInventoryPanel.add(lblClassification);
				
		formattedClassification.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, formattedClassification, 10, SpringLayout.WEST, lblClassification);
		springLayout.putConstraint(SpringLayout.NORTH, formattedClassification, 6, SpringLayout.SOUTH, lblClassification);
		formattedClassification.setColumns(20);		
		updateInventoryPanel.add(formattedClassification);
				
		lblHeightcm.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblHeightcm, 5, SpringLayout.SOUTH, formattedDateOfWork);
		springLayout.putConstraint(SpringLayout.WEST, lblHeightcm, 15, SpringLayout.WEST, updateInventoryPanel);
		updateInventoryPanel.add(lblHeightcm);
						
		formattedHeight.setFont(new Font("Century", Font.PLAIN, 12));
		formattedHeight.setColumns(5);
		springLayout.putConstraint(SpringLayout.WEST, formattedHeight, 10, SpringLayout.WEST, lblHeightcm);
		springLayout.putConstraint(SpringLayout.NORTH, formattedHeight, 6, SpringLayout.SOUTH, lblHeightcm);
		updateInventoryPanel.add(formattedHeight);
				
		lblWidthcm.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblWidthcm, 103, SpringLayout.EAST, lblHeightcm);
		springLayout.putConstraint(SpringLayout.SOUTH, lblWidthcm, 0, SpringLayout.SOUTH, lblHeightcm);
		updateInventoryPanel.add(lblWidthcm);
						
		formattedWidth.setFont(new Font("Century", Font.PLAIN, 12));
		formattedWidth.setColumns(5);
		springLayout.putConstraint(SpringLayout.WEST, formattedWidth, 10, SpringLayout.WEST, lblWidthcm);
		springLayout.putConstraint(SpringLayout.NORTH, formattedWidth, 0, SpringLayout.NORTH, formattedHeight);
		updateInventoryPanel.add(formattedWidth);
				
		lblMedium.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblMedium, 15, SpringLayout.WEST, updateInventoryPanel);
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
		
		springLayout.putConstraint(SpringLayout.NORTH, lblDateOfPurchase, 5, SpringLayout.SOUTH, formattedMedium);
		springLayout.putConstraint(SpringLayout.WEST, lblDateOfPurchase, 15, SpringLayout.WEST, updateInventoryPanel);
		lblDateOfPurchase.setFont(new Font("Century", Font.PLAIN, 12));
		updateInventoryPanel.add(lblDateOfPurchase);
				
		formattedDateOfPurchase.setColumns(10);
		springLayout.putConstraint(SpringLayout.NORTH, formattedDateOfPurchase, 8, SpringLayout.SOUTH, lblDateOfPurchase);
		springLayout.putConstraint(SpringLayout.WEST, formattedDateOfPurchase, 0, SpringLayout.WEST, formattedFirstName);
		updateInventoryPanel.add(formattedDateOfPurchase);
						
		lblSellerName.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblSellerName, 15, SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblSellerName, 5, SpringLayout.SOUTH, formattedDateOfPurchase);
		updateInventoryPanel.add(lblSellerName);
				
		formattedSellerName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedSellerName.setColumns(42);
		springLayout.putConstraint(SpringLayout.WEST, formattedSellerName, 10, SpringLayout.WEST, lblSellerName);
		springLayout.putConstraint(SpringLayout.NORTH, formattedSellerName, 5, SpringLayout.SOUTH, lblSellerName);
		updateInventoryPanel.add(formattedSellerName);
				
		lblSellerAddress.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblSellerAddress, 15, SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblSellerAddress, 8, SpringLayout.SOUTH, formattedSellerName);
		updateInventoryPanel.add(lblSellerAddress);
		
		formattedSellerAddress.setFont(new Font("Century", Font.PLAIN, 12));
		formattedSellerAddress.setColumns(42);
		springLayout.putConstraint(SpringLayout.WEST, formattedSellerAddress, 10, SpringLayout.WEST, lblSellerAddress);
		springLayout.putConstraint(SpringLayout.NORTH, formattedSellerAddress, 5, SpringLayout.SOUTH, lblSellerAddress);
		updateInventoryPanel.add(formattedSellerAddress);
				
		lblActualPurchasePrice.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblActualPurchasePrice, 15, SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblActualPurchasePrice, 5, SpringLayout.SOUTH, formattedSellerAddress);
		updateInventoryPanel.add(lblActualPurchasePrice);
				
		formattedActualPurchasePrice.setFont(new Font("Century", Font.PLAIN, 12));
		formattedActualPurchasePrice.setColumns(20);
		springLayout.putConstraint(SpringLayout.WEST, formattedActualPurchasePrice, 10, SpringLayout.WEST, lblActualPurchasePrice);
		springLayout.putConstraint(SpringLayout.NORTH, formattedActualPurchasePrice, 5, SpringLayout.SOUTH, lblActualPurchasePrice);
		updateInventoryPanel.add(formattedActualPurchasePrice);

		springLayout.putConstraint(SpringLayout.NORTH, lblWarning_2, 7, SpringLayout.SOUTH, formattedActualPurchasePrice);
		springLayout.putConstraint(SpringLayout.WEST, lblWarning_2, 15, SpringLayout.WEST, updateInventoryPanel);
		updateInventoryPanel.add(lblWarning_2);		
				
		lblDateOfSale.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblDateOfSale, 5, SpringLayout.SOUTH, lblWarning_2);
		springLayout.putConstraint(SpringLayout.WEST, lblDateOfSale, 15, SpringLayout.WEST, updateInventoryPanel);
		updateInventoryPanel.add(lblDateOfSale);
		
		formattedDateOfSale.setColumns(10);
		springLayout.putConstraint(SpringLayout.WEST, formattedDateOfSale, 10, SpringLayout.WEST, lblDateOfSale);
		springLayout.putConstraint(SpringLayout.NORTH, formattedDateOfSale, 5, SpringLayout.SOUTH, lblDateOfSale);
		updateInventoryPanel.add(formattedDateOfSale);
		
		lblBuyerName.setFont(new Font("Century", Font.PLAIN, 12));	
		springLayout.putConstraint(SpringLayout.WEST, lblBuyerName, 15, SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblBuyerName, 5, SpringLayout.SOUTH, formattedDateOfSale);
		updateInventoryPanel.add(lblBuyerName);
	
		formattedBuyerName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedBuyerName.setColumns(42);
		springLayout.putConstraint(SpringLayout.NORTH, formattedBuyerName, 5, SpringLayout.SOUTH, lblBuyerName);
		springLayout.putConstraint(SpringLayout.WEST, formattedBuyerName, 10, SpringLayout.WEST, lblBuyerName);
		updateInventoryPanel.add(formattedBuyerName);
		
		lblBuyerAddress.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblBuyerAddress, 15, SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblBuyerAddress, 5, SpringLayout.SOUTH, formattedBuyerName);
		updateInventoryPanel.add(lblBuyerAddress);
						
		formattedBuyerAddress.setFont(new Font("Century", Font.PLAIN, 12));
		formattedBuyerAddress.setColumns(42);		
		springLayout.putConstraint(SpringLayout.WEST, formattedBuyerAddress, 10, SpringLayout.WEST, lblBuyerAddress);
		springLayout.putConstraint(SpringLayout.NORTH, formattedBuyerAddress, 5, SpringLayout.SOUTH, lblBuyerAddress);
		updateInventoryPanel.add(formattedBuyerAddress);
				
		lblActualSellingPrice.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblActualSellingPrice, 15, SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblActualSellingPrice, 5, SpringLayout.SOUTH, formattedBuyerAddress);
		updateInventoryPanel.add(lblActualSellingPrice);
			
		formattedActualSellingPrice.setFont(new Font("Century", Font.PLAIN, 12));
		formattedActualSellingPrice.setColumns(20);
		springLayout.putConstraint(SpringLayout.WEST, formattedActualSellingPrice, 10, SpringLayout.WEST, lblActualSellingPrice);
		springLayout.putConstraint(SpringLayout.NORTH, formattedActualSellingPrice, 5, SpringLayout.SOUTH, lblActualSellingPrice);
		updateInventoryPanel.add(formattedActualSellingPrice);
				
		springLayout.putConstraint(SpringLayout.WEST, btnSaveNew, 35, SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, btnSaveNew, 15, SpringLayout.SOUTH, formattedActualSellingPrice);
		updateInventoryPanel.add(btnSaveNew);	
		
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 0, SpringLayout.NORTH, btnSaveNew);
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 25, SpringLayout.EAST, btnSaveNew);
		updateInventoryPanel.add(btnCancel);		
		
		setViewportView(updateInventoryPanel);
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
		/*boolean isValid=false;
		boolean isSaleInfoNull = false;
		boolean isSaleInfoComplete = false;*/
		
		String[] values = getFieldValues();
		if( values[0].length() == 0 || values[1].length() == 0 || values[2].length() == 0 ||
				values[3].length() == 0 || values[4].length() == 0 || values[5].length() == 0 ||
				values[6].length() == 0 || values[7].length() == 0 || values[8].length() == 0 ||
				values[9].length() == 0 || values[10].length() == 0 || values[11].length() == 0 ||
				values[12].length() == 0)
			return false;
		System.out.println("1");
		SimpleDate today = new SimpleDate(SimpleDate.TODAY);
		int dateWork = -1;
		if (values[3].contains("?"))
			dateWork = Integer.parseInt(values[3].substring(0,
					values[3].length() - 1));
		else
			dateWork = Integer.parseInt(values[3]);
		SimpleDate datePurch = SimpleDate.parseSimpleDate(values[9]);
		double actualPurchPrice = Double.parseDouble(values[12]);
		double height = Double.parseDouble(values[5]);
		double width = Double.parseDouble(values[6]);
		if(dateWork < 1100 || dateWork > today.getYear() || height <= 0 || width <= 0
				|| datePurch.getYear() < dateWork || SimpleDate.dateIsTooLarge(datePurch, today)
				|| actualPurchPrice <= 0)
			return false;
		System.out.println("2");
		if(values[13].length() > 0 || values[14].length() > 0 || values[15].length() > 0 || values[16].length() > 0)
		{
			if(values[13].length() == 0 || values[14].length() == 0 || values[15].length() == 0 || values[16].length() == 0)
				return false;
			System.out.println("22");
			SimpleDate dateSale = SimpleDate.parseSimpleDate(values[13]);
			double actualSellPrice = Double.parseDouble(values[16]);
			if(SimpleDate.dateIsTooLarge(dateSale, today) || SimpleDate.dateIsTooLarge(datePurch, dateSale) || actualSellPrice <= 0)
				return false;
		}
		System.out.println("3");
		return true;
		
		
		
		
		
		/*if( 	formattedFirstName.isEditValid()
				&& formattedLastName.isEditValid()
				&& formattedTitle.isEditValid()
				&& formattedDateOfWork.isEditValid()
				&& formattedClassification.isEditValid()
				&& formattedHeight.isEditValid()
				&& formattedWidth.isEditValid()
				&& formattedMedium.isEditValid()
				&& formattedSubject.isEditValid()
				&& formattedDateOfPurchase.isEditValid()
				&& formattedDateOfPurchase.isEditValid()
				&& formattedSellerName.isEditValid()
				&& formattedSellerAddress.isEditValid()				
				)isValid=true;
		else return false;
		System.out.println("1");
		
		if(		formattedDateOfSale.getValue()==null 
				&& formattedBuyerName.getValue()==null 
				&& formattedBuyerAddress.getValue()==null
				&& formattedActualSellingPrice.getValue()==null
				)isSaleInfoNull = true;
		
		else if(formattedDateOfSale.isEditValid()				
				&& formattedBuyerName.isEditValid() 
				&& formattedBuyerAddress.isEditValid()
				&& formattedActualSellingPrice.isEditValid()
				)isSaleInfoComplete = true;
		
		if(		isSaleInfoNull||isSaleInfoComplete ){
				isValid=true;
		} else return false;
		System.out.println("2");
		
		String[] fieldValues = getFieldValues();
		String fName = "";
		if(formattedFirstName.getValue() != null)
		{			
			fName = ((String) formattedFirstName.getValue()).trim();
			if(fName.length()==21)
				if(fName.charAt(20)!='?')
					return false;
		}
		String lName = "";
		if(formattedLastName.getValue() != null)
		{
			lName = ((String) formattedLastName.getValue()).trim();
			if(lName.length()==21)
				if(lName.charAt(20)!='?')
					return false;
		}
		String title = "";
		if(formattedTitle.getValue() != null)
		{
			title = ((String) formattedTitle.getValue()).trim();
			if(title.length()==41)
				if(title.charAt(40)!='?')
					return false;
		}
		String dateOfWork = "";
		if(formattedDateOfWork.getValue() != null)
		{
			dateOfWork = ((String) formattedDateOfWork.getValue()).trim();
			if(dateOfWork.length()==5)
				if(dateOfWork.charAt(4)!='?')
					return false;
		}
		int dateWork = Integer.parseInt(fieldValues[3]);
		double height = Double.parseDouble(fieldValues[5]);
		double width = Double.parseDouble(fieldValues[6]);
		SimpleDate dateOfPurchase = SimpleDate.parseSimpleDate(fieldValues[9]);
		double actualPurcahsePrice = Double.parseDouble(fieldValues[12]);
		SimpleDate dateOfSale = SimpleDate.parseSimpleDate(fieldValues[13]);
		double actualSellPrice = Double.parseDouble(fieldValues[16]);
		SimpleDate today = new SimpleDate(SimpleDate.TODAY);
		
		if(		dateWork > 1099
				&& dateWork <= today.getYear()
				&& height > 0
				&& width > 0
				&& !dateOfPurchase.equals(new SimpleDate())
				&& SimpleDate.dateIsTooLarge(today , dateOfPurchase)
				&& actualPurcahsePrice >0				
			)	isValid = true;
		else return false;
		
		if(isSaleInfoComplete && actualSellPrice > 0)
			isValid = true;
		else return false;		
		return isValid;		*/
	}
	
	public String[] getFieldValues()
	{
		String[] fieldValues = new String[17];
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
		if(formattedLastName.getValue() != null)
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
		if(formattedDateOfPurchase.getValue() != null)
			fieldValues[9] = ((String) formattedDateOfPurchase.getValue()).trim();
		fieldValues[10] = "";
		if(formattedSellerName.getValue() != null)
			fieldValues[10] = ((String) formattedSellerName.getValue()).trim();
		fieldValues[11] = "";
		if(formattedSellerAddress.getValue() != null)
			fieldValues[11] = ((String) formattedSellerAddress.getValue()).trim();
		fieldValues[12] = "";
		if(formattedLastName.getValue() != null)
			if(formattedActualPurchasePrice.getValue() instanceof Long)
				fieldValues[12] = Long.toString((Long) formattedActualPurchasePrice.getValue());
			else
				fieldValues[12] = Double.toString((Double) formattedActualPurchasePrice.getValue());
		fieldValues[13] = "";
		if(formattedDateOfSale.getValue() != null)
			fieldValues[13] = ((String) formattedDateOfSale.getValue()).trim();
		fieldValues[14] = "";
		if(formattedBuyerName.getValue() != null)
			fieldValues[14] = ((String) formattedBuyerName.getValue()).trim();
		fieldValues[15] = "";
		if(formattedBuyerAddress.getValue() != null)
			fieldValues[15] = ((String) formattedBuyerAddress.getValue()).trim();
		fieldValues[16] = "";
		if(formattedActualSellingPrice.getValue() != null)
			if(formattedActualSellingPrice.getValue() instanceof Double)
				fieldValues[16] = Double.toString((Double) formattedActualSellingPrice.getValue());	
			else
				fieldValues[16] = Long.toString((Long) formattedActualSellingPrice.getValue());
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
		formattedDateOfPurchase.setValue(null);
		formattedClassification.setValue(null);
		formattedSellerName.setValue(null);
		formattedSellerAddress.setValue(null);
		formattedActualPurchasePrice.setValue(null);		
		formattedDateOfSale.setValue(null);		
		formattedBuyerName.setValue(null);		
		formattedBuyerAddress.setValue(null);		
		formattedActualSellingPrice.setValue(null);
	}
	public InventoryPainting createNewInventoryPainting(String[] values)
	{
		InventoryPainting newIPainting;
		String fName = values[0];
		String lName = values[1];
		String title = values[2];
		String dateWork = values[3];
		String classif = values[4];
		double height = Double.parseDouble(values[5]);
		double width = Double.parseDouble(values[6]);
		String med = values[7];
		String subj = values[8];
		SimpleDate dateOfPurchase = SimpleDate.parseSimpleDate(values[9]);
		String sellerN = values[10];
		String sellerA = values[11];
		double purchasePrice = Double.parseDouble(values[12]);
		if(		formattedDateOfSale.isEditValid()				
				&& formattedBuyerName.isEditValid() 
				&& formattedBuyerAddress.isEditValid()
				&& formattedActualSellingPrice.isEditValid()
				){
					SimpleDate dateOfSell = SimpleDate.parseSimpleDate(values[13]);
					String buyerN = values[14];
					String buyerA = values[15];
					double sellPrice = Double.parseDouble(values[16]);
					newIPainting = new InventoryPainting(fName,lName,title,dateWork,
														 height,width,med,subj,sellerN,
														 sellerA,dateOfPurchase,purchasePrice,
														 classif,dateOfSell,buyerN,buyerA,sellPrice);
					newIPainting.setMaxPurchasePrice(Calculation.calcMaxPrice(newIPainting));
					return newIPainting;
				}
				
		newIPainting = new InventoryPainting(fName,lName,title,dateWork,
											 height,width,med,subj,sellerN,
											 sellerA,dateOfPurchase,purchasePrice,
											 classif);
		newIPainting.setMaxPurchasePrice(Calculation.calcMaxPrice(newIPainting));
		return newIPainting;
		
		
		//return new AuctionPainting(fName,lName,title,dateWork,height,width,med,subj,salePrice,dateAuction);
	}
	
	
	
	public JButton getBtnSaveNew() {
		return btnSaveNew;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
	
	public static void main( String[] args )
   	{
		AddPaintingInventoryPanel IP = new AddPaintingInventoryPanel();		
		JFrame frame =new JFrame("Test");		
		frame.getContentPane().add(IP , BorderLayout.CENTER);		
		frame.setSize(800, 600);
		frame.setMaximumSize(new Dimension(800, 600));
		frame.setMinimumSize(new Dimension(800, 600));				
		frame.setVisible(true);
		
	}
}