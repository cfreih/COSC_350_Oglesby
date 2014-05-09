import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.text.NumberFormat;

import net.miginfocom.swing.MigLayout;


public class UpdateInventoryPanel extends JScrollPane {
	
	private JPanel updateInventoryPanel; 
		
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
	
	public UpdateInventoryPanel(){
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);		
		
		updateInventoryPanel = new JPanel();
		setViewportView(updateInventoryPanel);
		updateInventoryPanel.setLayout(new SpringLayout());
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
		
		
	}
	
	public void setup(){
		
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
}
