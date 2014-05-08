import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
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
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AddPaintingAuctionPanel extends JPanel {

	private GridBagLayout gridBagLayout;
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
	private JLabel lblMedium;
	private JTextField textFieldMedium;
	private JLabel lblSubject;
	private JTextField textFieldSubject;
	private JButton btnAddPaintingTo;
	private JButton btnCancel;
	private JLabel lblWidthcm;
	private JFormattedTextField formattedWidth;

	public AddPaintingAuctionPanel() {
		gridBagLayout = new GridBagLayout();
		lblArtistinfo = new JLabel("Artist Information");
		lblArtistFirstName = new JLabel("Artist First Name (max 20 characters)");
		formattedFirstName = new JFormattedTextField(createFormatter("********************"));
		lblArtistLastName = new JLabel("Artist Last Name (max 20 characters)");
		formattedLastName = new JFormattedTextField(
				createFormatter("********************"));
		lblPaintingInfo_1 = new JLabel("Painting Information");
		lblTitleOfWork = new JLabel("Title of Work (max 40 characters)");
		formattedTitle = new JFormattedTextField(
				createFormatter("****************************************"));
		lblDateOfWork = new JLabel("Date of Work (yyyy)");
		formattedDateOfWork = new JFormattedTextField(createFormatter("####"));
		lblDateSoldAt = new JLabel("Date Sold at Auction (mm/dd/yyyy)");
		formattedDateAuction = new JFormattedTextField(
				createFormatter("##/##/####"));
		lblPriceSoldAt = new JLabel("Price Sold at Auction");
		formattedSalePrice = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblHeightcm = new JLabel("Height (cm)");
		formattedHeight = new JFormattedTextField(NumberFormat.getNumberInstance());
		lblWidthcm = new JLabel("Width (cm)");
		lblWidthcm.setFont(new Font("Century", Font.PLAIN, 12));
		formattedWidth = new JFormattedTextField(NumberFormat.getNumberInstance());
		formattedWidth.setFont(new Font("Century", Font.PLAIN, 12));
		formattedWidth.setColumns(5);
		lblMedium = new JLabel("Medium");
		textFieldMedium = new JTextField();
		lblSubject = new JLabel("Subject");
		textFieldSubject = new JTextField();
		btnAddPaintingTo = new JButton("Add Painting to Auction Records");		
		btnAddPaintingTo.setFont(new Font("Century", Font.PLAIN, 12));

		setUpPanel();
	}

	public void setUpPanel() {
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "Manage Auction Paintings",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));

		gridBagLayout.columnWidths = new int[] { 0, 29, 200, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 15, 21, 30, 21, 15,
				21, 15, 21, 15, 21, 16, 22, 15, 21, 15, 21, 27, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblArtistinfo.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_lblArtistinfo = new GridBagConstraints();
		gbc_lblArtistinfo.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblArtistinfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtistinfo.gridx = 1;
		gbc_lblArtistinfo.gridy = 0;
		add(lblArtistinfo, gbc_lblArtistinfo);

		lblArtistFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_lblArtistFirstName = new GridBagConstraints();
		gbc_lblArtistFirstName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblArtistFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtistFirstName.gridx = 1;
		gbc_lblArtistFirstName.gridy = 1;
		add(lblArtistFirstName, gbc_lblArtistFirstName);

		lblArtistFirstName.setLabelFor(formattedFirstName);

		lblArtistLastName.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_lblArtistLastName = new GridBagConstraints();
		gbc_lblArtistLastName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblArtistLastName.insets = new Insets(0, 0, 5, 0);
		gbc_lblArtistLastName.gridx = 2;
		gbc_lblArtistLastName.gridy = 1;
		add(lblArtistLastName, gbc_lblArtistLastName);

		formattedFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedFirstName.setColumns(20);
		GridBagConstraints gbc_formattedFirstName = new GridBagConstraints();
		gbc_formattedFirstName.anchor = GridBagConstraints.NORTHWEST;
		gbc_formattedFirstName.insets = new Insets(0, 0, 5, 0);
		gbc_formattedFirstName.gridwidth = 2;
		gbc_formattedFirstName.gridx = 1;
		gbc_formattedFirstName.gridy = 2;
		add(formattedFirstName, gbc_formattedFirstName);

		lblArtistLastName.setLabelFor(formattedLastName);

		formattedLastName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedLastName.setColumns(20);
		GridBagConstraints gbc_formattedLastName = new GridBagConstraints();
		gbc_formattedLastName.anchor = GridBagConstraints.NORTHWEST;
		gbc_formattedLastName.insets = new Insets(0, 0, 5, 0);
		gbc_formattedLastName.gridx = 2;
		gbc_formattedLastName.gridy = 2;
		add(formattedLastName, gbc_formattedLastName);

		lblPaintingInfo_1.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPaintingInfo_1 = new GridBagConstraints();
		gbc_lblPaintingInfo_1.anchor = GridBagConstraints.WEST;
		gbc_lblPaintingInfo_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaintingInfo_1.gridx = 1;
		gbc_lblPaintingInfo_1.gridy = 3;
		add(lblPaintingInfo_1, gbc_lblPaintingInfo_1);

		lblTitleOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTitleOfWork = new GridBagConstraints();
		gbc_lblTitleOfWork.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTitleOfWork.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitleOfWork.gridx = 1;
		gbc_lblTitleOfWork.gridy = 4;
		add(lblTitleOfWork, gbc_lblTitleOfWork);

		lblTitleOfWork.setLabelFor(formattedTitle);
		formattedTitle.setColumns(40);
		formattedTitle.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_formattedTitle = new GridBagConstraints();
		gbc_formattedTitle.anchor = GridBagConstraints.NORTHWEST;
		gbc_formattedTitle.insets = new Insets(0, 0, 5, 0);
		gbc_formattedTitle.gridwidth = 2;
		gbc_formattedTitle.gridx = 1;
		gbc_formattedTitle.gridy = 5;
		add(formattedTitle, gbc_formattedTitle);

		lblDateOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDateOfWork = new GridBagConstraints();
		gbc_lblDateOfWork.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDateOfWork.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfWork.gridx = 1;
		gbc_lblDateOfWork.gridy = 6;
		add(lblDateOfWork, gbc_lblDateOfWork);
		lblDateOfWork.setLabelFor(formattedDateOfWork);

		formattedDateOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		formattedDateOfWork.setColumns(5);
		GridBagConstraints gbc_formattedDateOfWork = new GridBagConstraints();
		gbc_formattedDateOfWork.anchor = GridBagConstraints.NORTHWEST;
		gbc_formattedDateOfWork.insets = new Insets(0, 0, 5, 5);
		gbc_formattedDateOfWork.gridx = 1;
		gbc_formattedDateOfWork.gridy = 7;
		add(formattedDateOfWork, gbc_formattedDateOfWork);

		lblDateSoldAt.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDateSoldAt = new GridBagConstraints();
		gbc_lblDateSoldAt.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDateSoldAt.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateSoldAt.gridx = 1;
		gbc_lblDateSoldAt.gridy = 8;
		add(lblDateSoldAt, gbc_lblDateSoldAt);

		lblPriceSoldAt.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPriceSoldAt = new GridBagConstraints();
		gbc_lblPriceSoldAt.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPriceSoldAt.insets = new Insets(0, 0, 5, 0);
		gbc_lblPriceSoldAt.gridx = 2;
		gbc_lblPriceSoldAt.gridy = 8;
		add(lblPriceSoldAt, gbc_lblPriceSoldAt);

		lblDateSoldAt.setLabelFor(formattedDateAuction);
		formattedDateAuction.setColumns(10);
		formattedDateAuction.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_formattedDateAuction = new GridBagConstraints();
		gbc_formattedDateAuction.anchor = GridBagConstraints.NORTHWEST;
		gbc_formattedDateAuction.insets = new Insets(0, 0, 5, 5);
		gbc_formattedDateAuction.gridx = 1;
		gbc_formattedDateAuction.gridy = 9;
		add(formattedDateAuction, gbc_formattedDateAuction);

		lblPriceSoldAt.setLabelFor(formattedSalePrice);
		formattedSalePrice.setColumns(20);
		formattedSalePrice.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_formattedSalePrice = new GridBagConstraints();
		gbc_formattedSalePrice.anchor = GridBagConstraints.NORTHWEST;
		gbc_formattedSalePrice.insets = new Insets(0, 0, 5, 0);
		gbc_formattedSalePrice.gridx = 2;
		gbc_formattedSalePrice.gridy = 9;
		add(formattedSalePrice, gbc_formattedSalePrice);
		

		lblHeightcm.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_lblHeightcm = new GridBagConstraints();
		gbc_lblHeightcm.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblHeightcm.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeightcm.gridx = 1;
		gbc_lblHeightcm.gridy = 10;
		add(lblHeightcm, gbc_lblHeightcm);
		
		
		GridBagConstraints gbc_lblWidthcm = new GridBagConstraints();
		gbc_lblWidthcm.anchor = GridBagConstraints.WEST;
		gbc_lblWidthcm.insets = new Insets(0, 0, 5, 0);
		gbc_lblWidthcm.gridx = 2;
		gbc_lblWidthcm.gridy = 10;
		add(lblWidthcm, gbc_lblWidthcm);
		
		lblHeightcm.setLabelFor(formattedHeight);

		formattedHeight.setFont(new Font("Century", Font.PLAIN, 12));
		formattedHeight.setColumns(5);
		GridBagConstraints gbc_formattedHeight = new GridBagConstraints();
		gbc_formattedHeight.anchor = GridBagConstraints.NORTHWEST;
		gbc_formattedHeight.insets = new Insets(0, 0, 5, 5);
		gbc_formattedHeight.gridx = 1;
		gbc_formattedHeight.gridy = 11;
		add(formattedHeight, gbc_formattedHeight);
		
		
		GridBagConstraints gbc_formattedWidth = new GridBagConstraints();
		gbc_formattedWidth.anchor = GridBagConstraints.WEST;
		gbc_formattedWidth.insets = new Insets(0, 0, 5, 0);
		gbc_formattedWidth.gridx = 2;
		gbc_formattedWidth.gridy = 11;
		add(formattedWidth, gbc_formattedWidth);
		

		lblMedium.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMedium = new GridBagConstraints();
		gbc_lblMedium.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMedium.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedium.gridx = 1;
		gbc_lblMedium.gridy = 12;
		add(lblMedium, gbc_lblMedium);
		
		lblMedium.setLabelFor(textFieldMedium);

		textFieldMedium.setColumns(20);
		textFieldMedium.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_textFieldMedium = new GridBagConstraints();
		gbc_textFieldMedium.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldMedium.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMedium.gridx = 1;
		gbc_textFieldMedium.gridy = 13;
		add(textFieldMedium, gbc_textFieldMedium);
		

		lblSubject.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSubject = new GridBagConstraints();
		gbc_lblSubject.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSubject.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubject.gridx = 1;
		gbc_lblSubject.gridy = 14;
		add(lblSubject, gbc_lblSubject);
		

		lblSubject.setLabelFor(textFieldSubject);
		textFieldSubject.setColumns(20);
		textFieldSubject.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_textFieldSubject = new GridBagConstraints();
		gbc_textFieldSubject.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldSubject.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSubject.gridx = 1;
		gbc_textFieldSubject.gridy = 15;
		add(textFieldSubject, gbc_textFieldSubject);

		btnAddPaintingTo.setPreferredSize(new Dimension(200, 20));
		btnAddPaintingTo.setMnemonic('A');
		GridBagConstraints gbc_btnAddPaintingTo = new GridBagConstraints();
		gbc_btnAddPaintingTo.fill = GridBagConstraints.BOTH;
		gbc_btnAddPaintingTo.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddPaintingTo.gridx = 1;
		gbc_btnAddPaintingTo.gridy = 17;
		add(btnAddPaintingTo, gbc_btnAddPaintingTo);
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Century", Font.PLAIN, 12));
		
				btnCancel.setPreferredSize(new Dimension(200, 20));
				btnCancel.setMnemonic('C');
				GridBagConstraints gbc_btnCancel = new GridBagConstraints();
				gbc_btnCancel.fill = GridBagConstraints.VERTICAL;
				gbc_btnCancel.gridx = 2;
				gbc_btnCancel.gridy = 17;
				add(btnCancel, gbc_btnCancel);
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

	public static void main(String[] args) {
		JFrame f = new JFrame("test window");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setSize(800, 600);
		f.setLocation(10, 10);
		f.getContentPane().add(new AddPaintingAuctionPanel());
		f.show();
	}

	public JButton getBtnAddPaintingTo() {
		return btnAddPaintingTo;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
}
