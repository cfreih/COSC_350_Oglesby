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
import javax.swing.UIManager;

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
	private JFormattedTextField textFieldSubject;
	private JLabel lblNameOfSeller;
	private JFormattedTextField formattedNameofSeller;
	private JLabel lblAddressOfSeller;
	private JFormattedTextField formattedAddressOfSeller;
	private JLabel lblActualPurchasePrice;
	private JFormattedTextField formattedActualPurchasePrice;
	private JLabel lblWarning_2;
	private JLabel lblDateOfSale;
	private JFormattedTextField formattedDateOfSale;
	private JLabel lblNameOfBuyer;
	private JFormattedTextField formattedNameOfBuyer;
	private JLabel lblAddressOfBuyer;
	private JFormattedTextField formattedAddressOfBuyer;
	private JLabel lblActualSellingPrice;
	private JFormattedTextField formattedActualSellingPrice;
	private JButton btnSaveNew;
	private JButton btnCancel;

	public AddPaintingInventoryPanel() {

		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		updateInventoryPanel = new JPanel();

		springLayout = new SpringLayout();

		lblArtistinfo = new JLabel("Artist Info");
		lblWarning_1 = new JLabel("( * Indicates Required Fields )");
		lblWarning_1.setFont(new Font("Cambria", Font.PLAIN, 12));

		lblArtistFirstName = new JLabel(
				"Artist First Name (max 20 characters) *");
		formattedFirstName = new JFormattedTextField(
				createFormatter("A*******************"));
		lblArtistLastName = new JLabel("Artist Last Name (max 20 characters) *");
		formattedLastName = new JFormattedTextField(
				createFormatter("A*******************"));
		lblNewPaintingInfo = new JLabel("Painting Info");
		lblTitleOfWork = new JLabel("Title of Work (max 40 characters) *");
		formattedTitle = new JFormattedTextField(
				createFormatter("A***************************************"));
		formattedTitle.setFont(new Font("Cambria", Font.PLAIN, 12));
		lblDateOfWork = new JLabel("Date of Work (yyyy) *");
		formattedDateOfWork = new JFormattedTextField(createFormatter("####*"));
		lblHeightcm = new JLabel("Height(cm) *");
		formattedHeight = new JFormattedTextField(
				NumberFormat.getNumberInstance());
		lblWidthcm = new JLabel("Width (cm) *");
		formattedWidth = new JFormattedTextField(
				NumberFormat.getNumberInstance());
		lblMedium = new JLabel("Medium *");
		formattedMedium = new JFormattedTextField(
				createFormatter("A************************"));
		lblSubject = new JLabel("Subject *");
		textFieldSubject = new JFormattedTextField(
				createFormatter("A************************"));
		lblDateOfPurchase = new JLabel("Date of Purchase *");
		formattedDateOfPurchase = new JFormattedTextField(
				createFormatter("##/##/####"));
		formattedDateOfPurchase.setFont(new Font("Cambria", Font.PLAIN, 12));
		lblClassification = new JLabel("Classification *");
		formattedClassification = new JFormattedTextField(
				createFormatter("A*****************************"));
		lblNameOfSeller = new JLabel("Name of Seller *");
		formattedNameofSeller = new JFormattedTextField(
				createFormatter("A*****************************************"));
		lblAddressOfSeller = new JLabel("Address of Seller *");
		formattedAddressOfSeller = new JFormattedTextField(
				createFormatter("A*****************************************"));
		lblActualPurchasePrice = new JLabel("Actual Purchase Price *");
		formattedActualPurchasePrice = new JFormattedTextField(
				NumberFormat.getNumberInstance());
		lblWarning_2 = new JLabel("( ** Must be all Provided OR all Blank )");
		lblWarning_2.setFont(new Font("Cambria", Font.PLAIN, 12));
		lblDateOfSale = new JLabel("Date of Sale **");
		formattedDateOfSale = new JFormattedTextField(
				createFormatter("##/##/####"));
		formattedDateOfSale.setFont(new Font("Cambria", Font.PLAIN, 12));
		lblNameOfBuyer = new JLabel("Name of Buyer **");
		formattedNameOfBuyer = new JFormattedTextField(
				createFormatter("******************************************"));
		lblAddressOfBuyer = new JLabel("Address of Buyer **");
		formattedAddressOfBuyer = new JFormattedTextField(
				createFormatter("******************************************"));
		lblActualSellingPrice = new JLabel("Actual Selling Price **");
		formattedActualSellingPrice = new JFormattedTextField(
				NumberFormat.getNumberInstance());
		btnSaveNew = new JButton("Save New Painting");
		btnSaveNew.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Cambria", Font.PLAIN, 12));

		setUpPanel();
	}

	public void setUpPanel() {

		setMinimumSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));

		updateInventoryPanel.setLayout(springLayout);
		updateInventoryPanel.setPreferredSize(new Dimension(765, 750));
		updateInventoryPanel.setBorder(new CompoundBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Manage Inventory Paintings", TitledBorder.CENTER,
				TitledBorder.TOP, null, null)));

		lblArtistinfo.setFont(new Font("Cambria", Font.ITALIC, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistinfo, 5,
				SpringLayout.NORTH, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.WEST, lblArtistinfo, 10,
				SpringLayout.WEST, updateInventoryPanel);
		updateInventoryPanel.add(lblArtistinfo);

		springLayout.putConstraint(SpringLayout.NORTH, lblWarning_1, 0,
				SpringLayout.NORTH, lblArtistinfo);
		springLayout.putConstraint(SpringLayout.WEST, lblWarning_1, 10,
				SpringLayout.EAST, lblArtistinfo);
		updateInventoryPanel.add(lblWarning_1);

		lblArtistFirstName.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblArtistFirstName, 15,
				SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistFirstName, 5,
				SpringLayout.SOUTH, lblArtistinfo);
		updateInventoryPanel.add(lblArtistFirstName);

		formattedFirstName.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, formattedFirstName, 10,
				SpringLayout.WEST, lblArtistFirstName);
		springLayout.putConstraint(SpringLayout.NORTH, formattedFirstName, 5,
				SpringLayout.SOUTH, lblArtistFirstName);
		formattedFirstName.setColumns(20);
		updateInventoryPanel.add(formattedFirstName);

		lblArtistLastName.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblArtistLastName, 0,
				SpringLayout.NORTH, lblArtistFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblArtistLastName, 100,
				SpringLayout.EAST, lblArtistFirstName);
		updateInventoryPanel.add(lblArtistLastName);

		formattedLastName.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, formattedLastName, 5,
				SpringLayout.SOUTH, lblArtistLastName);
		springLayout.putConstraint(SpringLayout.WEST, formattedLastName, 10,
				SpringLayout.WEST, lblArtistLastName);
		formattedLastName.setColumns(20);
		updateInventoryPanel.add(formattedLastName);

		lblNewPaintingInfo.setFont(new Font("Cambria", Font.ITALIC, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblNewPaintingInfo, 10,
				SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewPaintingInfo, 31,
				SpringLayout.SOUTH, lblArtistFirstName);
		updateInventoryPanel.add(lblNewPaintingInfo);

		lblTitleOfWork.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblTitleOfWork, 15,
				SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblTitleOfWork, 5,
				SpringLayout.SOUTH, lblNewPaintingInfo);
		updateInventoryPanel.add(lblTitleOfWork);

		springLayout.putConstraint(SpringLayout.NORTH, formattedTitle, 5,
				SpringLayout.SOUTH, lblTitleOfWork);
		springLayout.putConstraint(SpringLayout.WEST, formattedTitle, 10,
				SpringLayout.WEST, lblTitleOfWork);
		formattedTitle.setColumns(40);
		updateInventoryPanel.add(formattedTitle);

		lblDateOfWork.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblDateOfWork, 15,
				SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblDateOfWork, 5,
				SpringLayout.SOUTH, formattedTitle);
		updateInventoryPanel.add(lblDateOfWork);

		formattedDateOfWork.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, formattedDateOfWork, 5,
				SpringLayout.SOUTH, lblDateOfWork);
		springLayout.putConstraint(SpringLayout.WEST, formattedDateOfWork, 10,
				SpringLayout.WEST, lblDateOfWork);
		formattedDateOfWork.setColumns(5);
		updateInventoryPanel.add(formattedDateOfWork);

		lblClassification.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblClassification, 0,
				SpringLayout.WEST, lblArtistLastName);
		springLayout.putConstraint(SpringLayout.NORTH, lblClassification, 0,
				SpringLayout.NORTH, lblDateOfWork);
		updateInventoryPanel.add(lblClassification);

		formattedClassification.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, formattedClassification,
				10, SpringLayout.WEST, lblClassification);
		springLayout.putConstraint(SpringLayout.NORTH, formattedClassification,
				6, SpringLayout.SOUTH, lblClassification);
		formattedClassification.setColumns(20);
		updateInventoryPanel.add(formattedClassification);

		lblHeightcm.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblHeightcm, 5,
				SpringLayout.SOUTH, formattedDateOfWork);
		springLayout.putConstraint(SpringLayout.WEST, lblHeightcm, 15,
				SpringLayout.WEST, updateInventoryPanel);
		updateInventoryPanel.add(lblHeightcm);

		formattedHeight.setFont(new Font("Cambria", Font.PLAIN, 12));
		formattedHeight.setColumns(5);
		springLayout.putConstraint(SpringLayout.WEST, formattedHeight, 10,
				SpringLayout.WEST, lblHeightcm);
		springLayout.putConstraint(SpringLayout.NORTH, formattedHeight, 6,
				SpringLayout.SOUTH, lblHeightcm);
		updateInventoryPanel.add(formattedHeight);

		lblWidthcm.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblWidthcm, 103,
				SpringLayout.EAST, lblHeightcm);
		springLayout.putConstraint(SpringLayout.SOUTH, lblWidthcm, 0,
				SpringLayout.SOUTH, lblHeightcm);
		updateInventoryPanel.add(lblWidthcm);

		formattedWidth.setFont(new Font("Cambria", Font.PLAIN, 12));
		formattedWidth.setColumns(5);
		springLayout.putConstraint(SpringLayout.WEST, formattedWidth, 10,
				SpringLayout.WEST, lblWidthcm);
		springLayout.putConstraint(SpringLayout.NORTH, formattedWidth, 0,
				SpringLayout.NORTH, formattedHeight);
		updateInventoryPanel.add(formattedWidth);

		lblMedium.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblMedium, 15,
				SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblMedium, 6,
				SpringLayout.SOUTH, formattedHeight);
		updateInventoryPanel.add(lblMedium);

		formattedMedium.setFont(new Font("Cambria", Font.PLAIN, 12));
		formattedMedium.setColumns(20);
		springLayout.putConstraint(SpringLayout.NORTH, formattedMedium, 5,
				SpringLayout.SOUTH, lblMedium);
		springLayout.putConstraint(SpringLayout.WEST, formattedMedium, 10,
				SpringLayout.WEST, lblMedium);
		updateInventoryPanel.add(formattedMedium);

		lblSubject.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblSubject, 0,
				SpringLayout.WEST, lblArtistLastName);
		springLayout.putConstraint(SpringLayout.NORTH, lblSubject, 0,
				SpringLayout.NORTH, lblMedium);
		updateInventoryPanel.add(lblSubject);

		textFieldSubject.setFont(new Font("Cambria", Font.PLAIN, 12));
		textFieldSubject.setColumns(20);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldSubject, 5,
				SpringLayout.SOUTH, lblSubject);
		springLayout.putConstraint(SpringLayout.WEST, textFieldSubject, 10,
				SpringLayout.WEST, lblSubject);
		updateInventoryPanel.add(textFieldSubject);

		springLayout.putConstraint(SpringLayout.NORTH, lblDateOfPurchase, 5,
				SpringLayout.SOUTH, formattedMedium);
		springLayout.putConstraint(SpringLayout.WEST, lblDateOfPurchase, 15,
				SpringLayout.WEST, updateInventoryPanel);
		lblDateOfPurchase.setFont(new Font("Cambria", Font.PLAIN, 12));
		updateInventoryPanel.add(lblDateOfPurchase);

		formattedDateOfPurchase.setColumns(10);
		springLayout.putConstraint(SpringLayout.NORTH, formattedDateOfPurchase,
				8, SpringLayout.SOUTH, lblDateOfPurchase);
		springLayout.putConstraint(SpringLayout.WEST, formattedDateOfPurchase,
				0, SpringLayout.WEST, formattedFirstName);
		updateInventoryPanel.add(formattedDateOfPurchase);

		lblNameOfSeller.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblNameOfSeller, 15,
				SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNameOfSeller, 5,
				SpringLayout.SOUTH, formattedDateOfPurchase);
		updateInventoryPanel.add(lblNameOfSeller);

		formattedNameofSeller.setFont(new Font("Cambria", Font.PLAIN, 12));
		formattedNameofSeller.setColumns(42);
		springLayout.putConstraint(SpringLayout.WEST, formattedNameofSeller,
				10, SpringLayout.WEST, lblNameOfSeller);
		springLayout.putConstraint(SpringLayout.NORTH, formattedNameofSeller,
				5, SpringLayout.SOUTH, lblNameOfSeller);
		updateInventoryPanel.add(formattedNameofSeller);

		lblAddressOfSeller.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblAddressOfSeller, 15,
				SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblAddressOfSeller, 8,
				SpringLayout.SOUTH, formattedNameofSeller);
		updateInventoryPanel.add(lblAddressOfSeller);

		formattedAddressOfSeller.setFont(new Font("Cambria", Font.PLAIN, 12));
		formattedAddressOfSeller.setColumns(42);
		springLayout.putConstraint(SpringLayout.WEST, formattedAddressOfSeller,
				10, SpringLayout.WEST, lblAddressOfSeller);
		springLayout.putConstraint(SpringLayout.NORTH,
				formattedAddressOfSeller, 5, SpringLayout.SOUTH,
				lblAddressOfSeller);
		updateInventoryPanel.add(formattedAddressOfSeller);

		lblActualPurchasePrice.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblActualPurchasePrice,
				15, SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblActualPurchasePrice,
				5, SpringLayout.SOUTH, formattedAddressOfSeller);
		updateInventoryPanel.add(lblActualPurchasePrice);

		formattedActualPurchasePrice
				.setFont(new Font("Cambria", Font.PLAIN, 12));
		formattedActualPurchasePrice.setColumns(20);
		springLayout.putConstraint(SpringLayout.WEST,
				formattedActualPurchasePrice, 10, SpringLayout.WEST,
				lblActualPurchasePrice);
		springLayout.putConstraint(SpringLayout.NORTH,
				formattedActualPurchasePrice, 5, SpringLayout.SOUTH,
				lblActualPurchasePrice);
		updateInventoryPanel.add(formattedActualPurchasePrice);

		springLayout.putConstraint(SpringLayout.NORTH, lblWarning_2, 7,
				SpringLayout.SOUTH, formattedActualPurchasePrice);
		springLayout.putConstraint(SpringLayout.WEST, lblWarning_2, 15,
				SpringLayout.WEST, updateInventoryPanel);
		updateInventoryPanel.add(lblWarning_2);

		lblDateOfSale.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.NORTH, lblDateOfSale, 5,
				SpringLayout.SOUTH, lblWarning_2);
		springLayout.putConstraint(SpringLayout.WEST, lblDateOfSale, 15,
				SpringLayout.WEST, updateInventoryPanel);
		updateInventoryPanel.add(lblDateOfSale);

		formattedDateOfSale.setColumns(10);
		springLayout.putConstraint(SpringLayout.WEST, formattedDateOfSale, 10,
				SpringLayout.WEST, lblDateOfSale);
		springLayout.putConstraint(SpringLayout.NORTH, formattedDateOfSale, 5,
				SpringLayout.SOUTH, lblDateOfSale);
		updateInventoryPanel.add(formattedDateOfSale);

		lblNameOfBuyer.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblNameOfBuyer, 15,
				SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNameOfBuyer, 5,
				SpringLayout.SOUTH, formattedDateOfSale);
		updateInventoryPanel.add(lblNameOfBuyer);

		formattedNameOfBuyer.setFont(new Font("Cambria", Font.PLAIN, 12));
		formattedNameOfBuyer.setColumns(42);
		springLayout.putConstraint(SpringLayout.NORTH, formattedNameOfBuyer, 5,
				SpringLayout.SOUTH, lblNameOfBuyer);
		springLayout.putConstraint(SpringLayout.WEST, formattedNameOfBuyer, 10,
				SpringLayout.WEST, lblNameOfBuyer);
		updateInventoryPanel.add(formattedNameOfBuyer);

		lblAddressOfBuyer.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblAddressOfBuyer, 15,
				SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblAddressOfBuyer, 5,
				SpringLayout.SOUTH, formattedNameOfBuyer);
		updateInventoryPanel.add(lblAddressOfBuyer);

		formattedAddressOfBuyer.setFont(new Font("Cambria", Font.PLAIN, 12));
		formattedAddressOfBuyer.setColumns(42);
		springLayout.putConstraint(SpringLayout.WEST, formattedAddressOfBuyer,
				10, SpringLayout.WEST, lblAddressOfBuyer);
		springLayout.putConstraint(SpringLayout.NORTH, formattedAddressOfBuyer,
				5, SpringLayout.SOUTH, lblAddressOfBuyer);
		updateInventoryPanel.add(formattedAddressOfBuyer);

		lblActualSellingPrice.setFont(new Font("Cambria", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, lblActualSellingPrice,
				15, SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, lblActualSellingPrice,
				5, SpringLayout.SOUTH, formattedAddressOfBuyer);
		updateInventoryPanel.add(lblActualSellingPrice);

		formattedActualSellingPrice
				.setFont(new Font("Cambria", Font.PLAIN, 12));
		formattedActualSellingPrice.setColumns(20);
		springLayout.putConstraint(SpringLayout.WEST,
				formattedActualSellingPrice, 10, SpringLayout.WEST,
				lblActualSellingPrice);
		springLayout.putConstraint(SpringLayout.NORTH,
				formattedActualSellingPrice, 5, SpringLayout.SOUTH,
				lblActualSellingPrice);
		updateInventoryPanel.add(formattedActualSellingPrice);

		springLayout.putConstraint(SpringLayout.WEST, btnSaveNew, 35,
				SpringLayout.WEST, updateInventoryPanel);
		springLayout.putConstraint(SpringLayout.NORTH, btnSaveNew, 15,
				SpringLayout.SOUTH, formattedActualSellingPrice);
		updateInventoryPanel.add(btnSaveNew);

		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 0,
				SpringLayout.NORTH, btnSaveNew);
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 25,
				SpringLayout.EAST, btnSaveNew);
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

	public boolean isInputValid() {
		if (formattedFirstName.isEditValid()
				&& formattedFirstName.isEditValid()
				&& formattedTitle.isEditValid()
				&& formattedDateOfWork.isEditValid()
				&& formattedHeight.isEditValid()
				&& formattedWidth.isEditValid()
				&& formattedMedium.isEditValid())
			;
		return true; // feel free to edit this out. This was submitted without a
						// return statement. As such it didn't compile.
	}

	public static void main(String[] args) {
		AddPaintingInventoryPanel IP = new AddPaintingInventoryPanel();
		JFrame frame = new JFrame("Test");
		frame.getContentPane().add(IP, BorderLayout.CENTER);
		frame.setSize(800, 600);
		frame.setMaximumSize(new Dimension(800, 600));
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setVisible(true);

	}
}