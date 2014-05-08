import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import java.awt.Font;
import javax.swing.JButton;


public class AddPaintingAuctionPanel extends JPanel {

	private SpringLayout springLayout;
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
	private JButton btnAddPaintingTo;
	private JButton btnCancel;
	
	public AddPaintingAuctionPanel()
	{
		springLayout = new SpringLayout();
		lblArtistFirstName = new JLabel("Artist First Name (max 20 characters)");
		formattedFirstName = new JFormattedTextField(createFormatter("********************"));
		lblArtistFirstName.setLabelFor(formattedFirstName);
		lblArtistLastName = new JLabel("Artist Last Name (max 20 characters)");
		formattedLastName = new JFormattedTextField(createFormatter("********************"));
		lblTitleOfWork = new JLabel("Title of Work (max 40 characters)");
		formattedTitle = new JFormattedTextField(createFormatter("****************************************"));
		lblDateOfWork = new JLabel("Date of Work (yyyy)");
		formattedDateOfWork = new JFormattedTextField(createFormatter("####"));
		lblDateSoldAt = new JLabel("Date Sold at Auction (mm/dd/yyyy)");
		formattedDateAuction = new JFormattedTextField(createFormatter("##/##/####"));
		lblPriceSoldAt = new JLabel("Price Sold at Auction");
		formattedSalePrice = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblHeightcm = new JLabel("Height (cm)");
		formattedHeight = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblWidthcm = new JLabel("Width (cm)");
		formattedWidth = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblMedium = new JLabel("Medium");
		textFieldMedium = new JTextField();
		lblSubject = new JLabel("Subject");		
		textFieldSubject = new JTextField();	
		btnAddPaintingTo = new JButton("Add Painting to Auction Records");
		btnCancel = new JButton("Cancel");
		
		setUpPanel();
	}
	
	public void setUpPanel()
	{
		setLayout(springLayout);
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new TitledBorder(null, "Manage Auction Paintings", TitledBorder.CENTER, TitledBorder.TOP, null, null)));

		lblArtistFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistFirstName, 40, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblArtistFirstName, 10, SpringLayout.WEST, this);
		add(lblArtistFirstName);
		
		
		formattedFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedFirstName.setColumns(20);
		springLayout.putConstraint(SpringLayout.NORTH, formattedFirstName, 6, SpringLayout.SOUTH, lblArtistFirstName);
		springLayout.putConstraint(SpringLayout.WEST, formattedFirstName, 0, SpringLayout.WEST, lblArtistFirstName);
		add(formattedFirstName);
		
		
		lblArtistLastName.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistLastName, 6, SpringLayout.SOUTH, formattedFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblArtistLastName, 10, SpringLayout.WEST, this);
		add(lblArtistLastName);
		
		
		lblArtistLastName.setLabelFor(formattedLastName);
		formattedLastName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedLastName.setColumns(20);
		springLayout.putConstraint(SpringLayout.NORTH, formattedLastName, 6, SpringLayout.SOUTH, lblArtistLastName);
		springLayout.putConstraint(SpringLayout.WEST, formattedLastName, 0, SpringLayout.WEST, lblArtistFirstName);
		add(formattedLastName);
		
		
		lblTitleOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblTitleOfWork, 6, SpringLayout.SOUTH, formattedLastName);
		springLayout.putConstraint(SpringLayout.WEST, lblTitleOfWork, 0, SpringLayout.WEST, lblArtistFirstName);
		add(lblTitleOfWork);
		
		
		lblTitleOfWork.setLabelFor(formattedTitle);
		formattedTitle.setColumns(40);
		formattedTitle.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, formattedTitle, 6, SpringLayout.SOUTH, lblTitleOfWork);
		springLayout.putConstraint(SpringLayout.WEST, formattedTitle, 0, SpringLayout.WEST, lblArtistFirstName);
		add(formattedTitle);
		
		
		lblDateOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblDateOfWork, 6, SpringLayout.SOUTH, formattedTitle);
		springLayout.putConstraint(SpringLayout.WEST, lblDateOfWork, 0, SpringLayout.WEST, lblArtistFirstName);
		add(lblDateOfWork);
		
		
		formattedDateOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		formattedDateOfWork.setColumns(5);
		lblDateOfWork.setLabelFor(formattedDateOfWork);
		springLayout.putConstraint(SpringLayout.NORTH, formattedDateOfWork, 6, SpringLayout.SOUTH, lblDateOfWork);
		springLayout.putConstraint(SpringLayout.WEST, formattedDateOfWork, 0, SpringLayout.WEST, lblArtistFirstName);
		add(formattedDateOfWork);
		
		
		lblDateSoldAt.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblDateSoldAt, 6, SpringLayout.SOUTH, formattedDateOfWork);
		springLayout.putConstraint(SpringLayout.WEST, lblDateSoldAt, 10, SpringLayout.WEST, this);
		add(lblDateSoldAt);
		
		
		lblDateSoldAt.setLabelFor(formattedDateAuction);
		formattedDateAuction.setColumns(10);
		formattedDateAuction.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, formattedDateAuction, 6, SpringLayout.SOUTH, lblDateSoldAt);
		springLayout.putConstraint(SpringLayout.WEST, formattedDateAuction, 0, SpringLayout.WEST, lblArtistFirstName);
		add(formattedDateAuction);
		
		
		lblPriceSoldAt.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblPriceSoldAt, 6, SpringLayout.SOUTH, formattedDateAuction);
		springLayout.putConstraint(SpringLayout.WEST, lblPriceSoldAt, 0, SpringLayout.WEST, lblArtistFirstName);
		add(lblPriceSoldAt);
		
		
		lblPriceSoldAt.setLabelFor(formattedSalePrice);
		formattedSalePrice.setColumns(20);
		formattedSalePrice.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, formattedSalePrice, 6, SpringLayout.SOUTH, lblPriceSoldAt);
		springLayout.putConstraint(SpringLayout.WEST, formattedSalePrice, 0, SpringLayout.WEST, lblArtistFirstName);
		add(formattedSalePrice);
		
		
		lblHeightcm.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblHeightcm, 6, SpringLayout.SOUTH, formattedSalePrice);
		springLayout.putConstraint(SpringLayout.WEST, lblHeightcm, 0, SpringLayout.WEST, lblArtistFirstName);
		add(lblHeightcm);
		
		
		formattedHeight.setFont(new Font("Century", Font.PLAIN, 12));
		formattedHeight.setColumns(5);
		lblHeightcm.setLabelFor(formattedHeight);
		springLayout.putConstraint(SpringLayout.NORTH, formattedHeight, 6, SpringLayout.SOUTH, lblHeightcm);
		springLayout.putConstraint(SpringLayout.WEST, formattedHeight, 0, SpringLayout.WEST, lblArtistFirstName);
		add(formattedHeight);
		
		
		lblWidthcm.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblWidthcm, 1, SpringLayout.NORTH, lblHeightcm);
		springLayout.putConstraint(SpringLayout.WEST, lblWidthcm, 50, SpringLayout.EAST, lblHeightcm);
		add(lblWidthcm);
		
		
		lblWidthcm.setLabelFor(formattedWidth);
		formattedWidth.setFont(new Font("Century", Font.PLAIN, 12));
		formattedWidth.setColumns(5);
		springLayout.putConstraint(SpringLayout.NORTH, formattedWidth, 1, SpringLayout.NORTH, formattedHeight);
		springLayout.putConstraint(SpringLayout.WEST, formattedWidth, 0, SpringLayout.WEST, lblWidthcm);
		add(formattedWidth);
		
		
		lblMedium.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblMedium, 6, SpringLayout.SOUTH, formattedHeight);
		springLayout.putConstraint(SpringLayout.WEST, lblMedium, 0, SpringLayout.WEST, lblArtistFirstName);
		add(lblMedium);
		
		
		textFieldMedium.setColumns(20);
		textFieldMedium.setFont(new Font("Century", Font.PLAIN, 12));
		lblMedium.setLabelFor(textFieldMedium);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldMedium, 6, SpringLayout.SOUTH, lblMedium);
		springLayout.putConstraint(SpringLayout.WEST, textFieldMedium, 0, SpringLayout.WEST, lblArtistFirstName);
		add(textFieldMedium);
		
		
		lblSubject.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblSubject, 6, SpringLayout.SOUTH, textFieldMedium);
		springLayout.putConstraint(SpringLayout.WEST, lblSubject, 0, SpringLayout.WEST, lblArtistFirstName);
		add(lblSubject);
		
		
		lblSubject.setLabelFor(textFieldSubject);
		textFieldSubject.setColumns(20);
		textFieldSubject.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, textFieldSubject, 6, SpringLayout.SOUTH, lblSubject);
		springLayout.putConstraint(SpringLayout.WEST, textFieldSubject, 0, SpringLayout.WEST, lblArtistFirstName);
		add(textFieldSubject);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, btnAddPaintingTo, 30, SpringLayout.SOUTH, textFieldSubject);
		springLayout.putConstraint(SpringLayout.WEST, btnAddPaintingTo, 0, SpringLayout.WEST, lblArtistFirstName);
		springLayout.putConstraint(SpringLayout.SOUTH, btnAddPaintingTo, -10, SpringLayout.SOUTH, this);
		add(btnAddPaintingTo);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 0, SpringLayout.NORTH, btnAddPaintingTo);
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 63, SpringLayout.EAST, btnAddPaintingTo);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancel, 67, SpringLayout.NORTH, btnAddPaintingTo);
		springLayout.putConstraint(SpringLayout.EAST, btnCancel, 250, SpringLayout.EAST, btnAddPaintingTo);
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
