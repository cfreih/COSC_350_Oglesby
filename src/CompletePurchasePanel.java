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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompletePurchasePanel extends JPanel {

 private GridBagLayout gridBagLayout;
 private JLabel lblSellerName;
 private JFormattedTextField formattedSellerName;
 private JLabel lblSellerinfo;
 private JLabel lblSellerAddress;
 private JFormattedTextField formattedSellerAddress;
 private JLabel lblPriceBoughtAt;
 private JFormattedTextField formattedBuyPrice;
 private JButton btnAddPaintingTo;
 private JButton btnCancel;

 public CompletePurchasePanel() {
  gridBagLayout = new GridBagLayout();
  formattedSellerName = new JFormattedTextField(
    createFormatter("****************************************"));

  setUpPanel();
 }

 public void setUpPanel() {
  setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
    null, null), new TitledBorder(null, "Complete Purchase",
    TitledBorder.CENTER, TitledBorder.TOP, null, null)));

  gridBagLayout.columnWidths = new int[] { 0, 29, 200, 0 };
  gridBagLayout.rowHeights = new int[] { 30, 15, 21, 30, 21, 15, 21, 16,
    41, 15, 21, 16, 22, 15, 21, 15, 21, 27, 0 };
  gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0,
    Double.MIN_VALUE };
  gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
    0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
    Double.MIN_VALUE };
  setLayout(gridBagLayout);

  lblSellerinfo = new JLabel("Seller Information");
  lblSellerinfo.setFont(new Font("Century", Font.PLAIN, 12));
  GridBagConstraints gbc_lblSellerinfo = new GridBagConstraints();
  gbc_lblSellerinfo.anchor = GridBagConstraints.SOUTHWEST;
  gbc_lblSellerinfo.insets = new Insets(0, 0, 5, 5);
  gbc_lblSellerinfo.gridx = 1;
  gbc_lblSellerinfo.gridy = 0;
  add(lblSellerinfo, gbc_lblSellerinfo);

  lblSellerName = new JLabel("Seller Name (max 40 characters)");
  lblSellerName.setFont(new Font("Century", Font.PLAIN, 12));
  GridBagConstraints gbc_lblSellerName = new GridBagConstraints();
  gbc_lblSellerName.anchor = GridBagConstraints.NORTHWEST;
  gbc_lblSellerName.insets = new Insets(0, 0, 5, 5);
  gbc_lblSellerName.gridx = 1;
  gbc_lblSellerName.gridy = 1;
  add(lblSellerName, gbc_lblSellerName);

  lblSellerName.setLabelFor(formattedSellerName);

  formattedSellerName.setFont(new Font("Century", Font.PLAIN, 12));
  formattedSellerName.setColumns(40);
  GridBagConstraints gbc_formattedSellerName = new GridBagConstraints();
  gbc_formattedSellerName.anchor = GridBagConstraints.NORTHWEST;
  gbc_formattedSellerName.insets = new Insets(0, 0, 5, 0);
  gbc_formattedSellerName.gridwidth = 2;
  gbc_formattedSellerName.gridx = 1;
  gbc_formattedSellerName.gridy = 2;
  add(formattedSellerName, gbc_formattedSellerName);
  formattedSellerName = new JFormattedTextField(
    createFormatter("****************************************"));

  lblSellerAddress = new JLabel("Seller Address (max 40 characters)");

  lblSellerAddress.setFont(new Font("Century", Font.PLAIN, 12));
  GridBagConstraints gbc_lblSellerAddress = new GridBagConstraints();
  gbc_lblSellerAddress.anchor = GridBagConstraints.NORTHWEST;
  gbc_lblSellerAddress.insets = new Insets(0, 0, 5, 5);
  gbc_lblSellerAddress.gridx = 1;
  gbc_lblSellerAddress.gridy = 3;
  add(lblSellerAddress, gbc_lblSellerAddress);
  formattedSellerAddress = new JFormattedTextField(
    createFormatter("****************************************"));

  lblSellerAddress.setLabelFor(formattedSellerAddress);
  formattedSellerAddress.setColumns(40);
  formattedSellerAddress.setFont(new Font("Century", Font.PLAIN, 12));
  GridBagConstraints gbc_formattedSellerAddress = new GridBagConstraints();
  gbc_formattedSellerAddress.anchor = GridBagConstraints.NORTHWEST;
  gbc_formattedSellerAddress.insets = new Insets(0, 0, 5, 0);
  gbc_formattedSellerAddress.gridwidth = 2;
  gbc_formattedSellerAddress.gridx = 1;
  gbc_formattedSellerAddress.gridy = 4;
  add(formattedSellerAddress, gbc_formattedSellerAddress);
  lblPriceBoughtAt = new JLabel("Actual Purchase Price");

  lblPriceBoughtAt.setFont(new Font("Century", Font.PLAIN, 12));
  GridBagConstraints gbc_lblPriceBoughtAt = new GridBagConstraints();
  gbc_lblPriceBoughtAt.anchor = GridBagConstraints.NORTHWEST;
  gbc_lblPriceBoughtAt.insets = new Insets(0, 0, 5, 5);
  gbc_lblPriceBoughtAt.gridx = 1;
  gbc_lblPriceBoughtAt.gridy = 5;
  add(lblPriceBoughtAt, gbc_lblPriceBoughtAt);
  formattedBuyPrice = new JFormattedTextField(
    NumberFormat.getNumberInstance());

  lblPriceBoughtAt.setLabelFor(formattedBuyPrice);
  formattedBuyPrice.setColumns(20);
  formattedBuyPrice.setFont(new Font("Century", Font.PLAIN, 12));
  GridBagConstraints gbc_formattedBuyPrice = new GridBagConstraints();
  gbc_formattedBuyPrice.anchor = GridBagConstraints.NORTHWEST;
  gbc_formattedBuyPrice.insets = new Insets(0, 0, 5, 5);
  gbc_formattedBuyPrice.gridx = 1;
  gbc_formattedBuyPrice.gridy = 6;
  add(formattedBuyPrice, gbc_formattedBuyPrice);
  btnAddPaintingTo = new JButton("Complete Purchase");
  btnAddPaintingTo.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) {
   }
  });
  btnAddPaintingTo.setFont(new Font("Century", Font.PLAIN, 12));

  btnAddPaintingTo.setPreferredSize(new Dimension(200, 20));
  btnAddPaintingTo.setMnemonic('A');
  GridBagConstraints gbc_btnAddPaintingTo = new GridBagConstraints();
  gbc_btnAddPaintingTo.fill = GridBagConstraints.BOTH;
  gbc_btnAddPaintingTo.insets = new Insets(0, 0, 5, 5);
  gbc_btnAddPaintingTo.gridx = 1;
  gbc_btnAddPaintingTo.gridy = 8;
  add(btnAddPaintingTo, gbc_btnAddPaintingTo);
  btnCancel = new JButton("Cancel");
  btnCancel.setFont(new Font("Century", Font.PLAIN, 12));

  btnCancel.setPreferredSize(new Dimension(200, 20));
  btnCancel.setMnemonic('C');
  GridBagConstraints gbc_btnCancel = new GridBagConstraints();
  gbc_btnCancel.insets = new Insets(0, 0, 5, 0);
  gbc_btnCancel.fill = GridBagConstraints.VERTICAL;
  gbc_btnCancel.gridx = 2;
  gbc_btnCancel.gridy = 8;
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
