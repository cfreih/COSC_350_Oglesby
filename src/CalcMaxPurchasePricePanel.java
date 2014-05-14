
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

public class CalcMaxPurchasePricePanel extends JPanel {

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
 private JLabel lblClassification;
 private JFormattedTextField formattedClassification;
 private JLabel lblHeightcm;
 private JFormattedTextField formattedHeight;
 private JLabel lblMedium;
 private JTextField textFieldMedium;
 private JLabel lblSubject;
 private JTextField textFieldSubject;
 private JButton btnCalcMaxPrice;
 private JButton btnCancel;
 private JLabel lblWidthcm;
 private JFormattedTextField formattedWidth;

 public CalcMaxPurchasePricePanel() {
  gridBagLayout = new GridBagLayout();
  lblArtistinfo = new JLabel("Artist Information");
  lblArtistFirstName = new JLabel("Artist First Name (max 20 characters)");
  formattedFirstName = new JFormattedTextField(createFormatter("A*******************"));
  lblArtistLastName = new JLabel("Artist Last Name (max 20 characters)");
  formattedLastName = new JFormattedTextField(
    createFormatter("A*******************"));
  lblPaintingInfo_1 = new JLabel("Painting Information");
  lblTitleOfWork = new JLabel("Title of Work (max 40 characters)");
  formattedTitle = new JFormattedTextField(
    createFormatter("A***************************************"));
  lblDateOfWork = new JLabel("Date of Work (yyyy)");
  formattedDateOfWork = new JFormattedTextField(createFormatter("####"));
  lblClassification = new JLabel("Classification (max 30 characters)");
  formattedClassification = new JFormattedTextField(
    createFormatter("A*****************************"));
  lblHeightcm = new JLabel("Height (cm)");
  formattedHeight = new JFormattedTextField(NumberFormat.getNumberInstance());
  lblWidthcm = new JLabel("Width (cm)");
  lblWidthcm.setFont(new Font("Century", Font.PLAIN, 12));
  formattedWidth = new JFormattedTextField(NumberFormat.getNumberInstance());
  formattedWidth.setFont(new Font("Century", Font.PLAIN, 12));
  formattedWidth.setColumns(5);
  lblMedium = new JLabel("Medium (max 25 characters)");
  textFieldMedium = new JFormattedTextField(createFormatter("A************************"));
  lblSubject = new JLabel("Subject (max 25 characters)");
  textFieldSubject = new JFormattedTextField(createFormatter("A************************"));
  btnCalcMaxPrice = new JButton("Calculate Maximum Purchase Price");  
  btnCalcMaxPrice.setFont(new Font("Century", Font.PLAIN, 12));

  setUpPanel();
 }

 public void setUpPanel() {
  setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
    null, null), new TitledBorder(null, "Calculate Maximum Purchase Price",
    TitledBorder.CENTER, TitledBorder.TOP, null, null)));

  gridBagLayout.columnWidths = new int[] { 0, 246, 200, 0 };
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

  lblClassification.setFont(new Font("Century", Font.PLAIN, 12));
  GridBagConstraints gbc_lblClassification = new GridBagConstraints();
  gbc_lblClassification.anchor = GridBagConstraints.NORTHWEST;
  gbc_lblClassification.insets = new Insets(0, 0, 5, 5);
  gbc_lblClassification.gridx = 1;
  gbc_lblClassification.gridy = 8;
  add(lblClassification, gbc_lblClassification);

  lblClassification.setLabelFor(formattedClassification);
  formattedClassification.setColumns(30);
  formattedClassification.setFont(new Font("Century", Font.PLAIN, 12));
  GridBagConstraints gbc_formattedClassification = new GridBagConstraints();
  gbc_formattedClassification.anchor = GridBagConstraints.NORTHWEST;
  gbc_formattedClassification.insets = new Insets(0, 0, 5, 5);
  gbc_formattedClassification.gridwidth = 2;
  gbc_formattedClassification.gridx = 1;
  gbc_formattedClassification.gridy = 9;
  add(formattedClassification, gbc_formattedClassification);
  

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

  textFieldMedium.setColumns(25);
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
  textFieldSubject.setColumns(25);
  textFieldSubject.setFont(new Font("Century", Font.PLAIN, 12));
  GridBagConstraints gbc_textFieldSubject = new GridBagConstraints();
  gbc_textFieldSubject.anchor = GridBagConstraints.NORTHWEST;
  gbc_textFieldSubject.insets = new Insets(0, 0, 5, 5);
  gbc_textFieldSubject.gridx = 1;
  gbc_textFieldSubject.gridy = 15;
  add(textFieldSubject, gbc_textFieldSubject);

  btnCalcMaxPrice.setPreferredSize(new Dimension(200, 20));
  btnCalcMaxPrice.setMnemonic('A');
  GridBagConstraints gbc_btnCalcMaxPrice = new GridBagConstraints();
  gbc_btnCalcMaxPrice.fill = GridBagConstraints.BOTH;
  gbc_btnCalcMaxPrice.insets = new Insets(0, 0, 0, 5);
  gbc_btnCalcMaxPrice.gridx = 1;
  gbc_btnCalcMaxPrice.gridy = 17;
  add(btnCalcMaxPrice, gbc_btnCalcMaxPrice);
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
  f.getContentPane().add(new CalcMaxPurchasePricePanel());
  f.show();
 }
 public boolean isInputValid()
	{
		String med = textFieldMedium.getText().trim();
		String subj = textFieldSubject.getText().trim();
		if(formattedFirstName.isEditValid() && formattedLastName.isEditValid() && formattedTitle.isEditValid()
				&& formattedDateOfWork.isEditValid()
				&& !(formattedHeight.getValue() == null) && !(formattedWidth.getValue() == null) && !(med.length() == 0)
				&& !(subj.length() == 0))
		{
			String[] fieldValues = getFieldValues();
			double dateWork = Double.parseDouble(fieldValues[3]);
			SimpleDate dateAuction = SimpleDate.parseSimpleDate(fieldValues[4]);
			double salePrice = Double.parseDouble(fieldValues[5]);
			double height = Double.parseDouble(fieldValues[6]);
			double width = Double.parseDouble(fieldValues[7]);
			if((dateWork > 1099) && !(dateAuction.equals(new SimpleDate())) && (salePrice > 0)
					&& (height > 0) && (width > 0))
				return true;
			else
				return false;
		}
		else
		{
			return false;
		  }
		}
		public String[] getFieldValues()
		{
			String[] fieldValues = new String[10];
			fieldValues[0] = ((String) formattedFirstName.getValue()).trim();
			fieldValues[1] = ((String) formattedLastName.getValue()).trim();
			fieldValues[2] = ((String) formattedTitle.getValue()).trim();
			fieldValues[3] = ((String) formattedDateOfWork.getValue()).trim();
			if(formattedHeight.getValue() instanceof Long)
				fieldValues[6] = Long.toString((Long) formattedHeight.getValue());
			else
				fieldValues[6] = Double.toString((Double) formattedHeight.getValue());
			if(formattedWidth.getValue() instanceof Long)
				fieldValues[7] = Long.toString((Long) formattedWidth.getValue());
			else
				fieldValues[7] = Double.toString((Double) formattedWidth.getValue());
			fieldValues[8] = textFieldMedium.getText();
			fieldValues[9] = textFieldSubject.getText();
			
			return fieldValues;
		}
		public void resetTextFields()
		{
			formattedFirstName.setValue(null);
			formattedLastName.setValue(null);
			formattedTitle.setValue(null);
			formattedDateOfWork.setValue(null);
			formattedHeight.setValue(null);
			formattedWidth.setValue(null);
			textFieldMedium.setText("");
			textFieldSubject.setText("");
		}
		public InventoryPainting createNewInventoryPainting(String[] values)
		{
			String fName = values[0];
			String lName = values[1];
			String title = values[2];
			String dateWork = values[3];
			double height = Double.parseDouble(values[6]);
			double width = Double.parseDouble(values[7]);
			String med = values[8];
			String subj = values[9];
			InventoryPainting painting=new InventoryPainting();
			painting.setArtistFirstName(fName);
			painting.setArtistLastName(lName);
			painting.setTitleOfWork(title);
			painting.setDateOfWork(dateWork);
			painting.setHeightCM(height);
			painting.setWidthCM(width);
			painting.setMedium(med);
			painting.setSubject(subj);
			return painting;
		}
		public JButton getBtnCalcMaxPrice() {
			return btnCalcMaxPrice;
		}
		public JButton getBtnCancel() {
			return btnCancel;
		}
}
