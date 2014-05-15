import javax.swing.JPanel;

import java.awt.GridBagLayout;

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
import javax.swing.text.MaskFormatter;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CompleteSalePanel extends JPanel {
	private InventoryPainting origPainting;
	private JLabel lblBuyerInfo;
	private JLabel lblFullName;
	private JLabel lblAddress;
	private JLabel lblTitle;
	private JFormattedTextField formattedFullName;
	private JFormattedTextField formattedAddress;
	private JFormattedTextField formattedPrice;
	private JButton btnCompleteSale;
	private JButton btnCancel;
	private JLabel lblSaleInfo;
	private JLabel lblPaintingInformation;
	private JScrollPane scrollPane;
	private JTable paintingsTable;
	private DefaultTableModel tableModel;
	
	private InventoryPainting inventoryPainting;
	private JLabel lblTargetSellPrice;
	private JLabel lblTarget;

	public CompleteSalePanel() {
		setUpPanel();
	}

	public void setUpPanel() {
		origPainting=new InventoryPainting();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 253, 108, 76, 86, 153, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 62, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "Complete Sale",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));

		lblPaintingInformation = new JLabel("Painting Information");
		lblPaintingInformation.setFont(new Font("Cambria", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPaintingInformation = new GridBagConstraints();
		gbc_lblPaintingInformation.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaintingInformation.gridx = 1;
		gbc_lblPaintingInformation.gridy = 0;
		add(lblPaintingInformation, gbc_lblPaintingInformation);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		paintingsTable=new JTable();
		paintingsTable.setFont(new Font("Cambria", Font.PLAIN, 12));
		paintingsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
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
			};
		paintingsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(paintingsTable);

		lblBuyerInfo = new JLabel("Buyer Information");
		lblBuyerInfo.setFont(new Font("Cambria", Font.ITALIC, 12));
		GridBagConstraints gbc_lblBuyerInfo = new GridBagConstraints();
		gbc_lblBuyerInfo.anchor = GridBagConstraints.WEST;
		gbc_lblBuyerInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuyerInfo.gridx = 1;
		gbc_lblBuyerInfo.gridy = 2;
		add(lblBuyerInfo, gbc_lblBuyerInfo);
		
		lblTargetSellPrice = new JLabel("Target Sell Price:");
		lblTargetSellPrice.setFont(new Font("Cambria", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTargetSellPrice = new GridBagConstraints();
		gbc_lblTargetSellPrice.anchor = GridBagConstraints.WEST;
		gbc_lblTargetSellPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblTargetSellPrice.gridx = 2;
		gbc_lblTargetSellPrice.gridy = 2;
		add(lblTargetSellPrice, gbc_lblTargetSellPrice);
		
		lblTarget = new JLabel("Price");
		GridBagConstraints gbc_lblTarget = new GridBagConstraints();
		gbc_lblTarget.anchor = GridBagConstraints.WEST;
		gbc_lblTarget.insets = new Insets(0, 0, 5, 5);
		gbc_lblTarget.gridx = 3;
		gbc_lblTarget.gridy = 2;
		add(lblTarget, gbc_lblTarget);

		lblFullName = new JLabel("Full Name (max 40 characters)");
		lblFullName.setFont(new Font("Cambria", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFullName = new GridBagConstraints();
		gbc_lblFullName.anchor = GridBagConstraints.WEST;
		gbc_lblFullName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFullName.gridx = 1;
		gbc_lblFullName.gridy = 3;
		add(lblFullName, gbc_lblFullName);
		formattedFullName = new JFormattedTextField(
				createFormatter("A***************************************"));
		formattedFullName.setFont(new Font("Cambria", Font.PLAIN, 12));

		formattedFullName.setColumns(40);
		GridBagConstraints gbc_formattedFullName = new GridBagConstraints();
		gbc_formattedFullName.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedFullName.insets = new Insets(0, 0, 5, 5);
		gbc_formattedFullName.gridx = 1;
		gbc_formattedFullName.gridy = 4;
		add(formattedFullName, gbc_formattedFullName);

		lblAddress = new JLabel("Address (max 40 characters)");
		lblAddress.setFont(new Font("Cambria", Font.PLAIN, 12));
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 5;
		add(lblAddress, gbc_lblAddress);
		formattedAddress = new JFormattedTextField(
				createFormatter("A***************************************"));
		formattedAddress.setFont(new Font("Cambria", Font.PLAIN, 12));

		formattedAddress.setColumns(40);
		GridBagConstraints gbc_formattedAddress = new GridBagConstraints();
		gbc_formattedAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedAddress.insets = new Insets(0, 0, 5, 5);
		gbc_formattedAddress.gridx = 1;
		gbc_formattedAddress.gridy = 6;
		add(formattedAddress, gbc_formattedAddress);

		lblSaleInfo = new JLabel("Sale Information");
		lblSaleInfo.setFont(new Font("Cambria", Font.ITALIC, 12));
		GridBagConstraints gbc_lblSaleInfo = new GridBagConstraints();
		gbc_lblSaleInfo.anchor = GridBagConstraints.WEST;
		gbc_lblSaleInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaleInfo.gridx = 1;
		gbc_lblSaleInfo.gridy = 7;
		add(lblSaleInfo, gbc_lblSaleInfo);

		lblTitle = new JLabel("Sale Price");
		lblTitle.setFont(new Font("Cambria", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.anchor = GridBagConstraints.WEST;
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 8;
		add(lblTitle, gbc_lblTitle);
		formattedPrice = new JFormattedTextField(NumberFormat.getNumberInstance());
		formattedPrice.setFont(new Font("Cambria", Font.PLAIN, 12));

		formattedPrice.setColumns(40);
		GridBagConstraints gbc_formattedPrice = new GridBagConstraints();
		gbc_formattedPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedPrice.insets = new Insets(0, 0, 5, 5);
		gbc_formattedPrice.gridx = 1;
		gbc_formattedPrice.gridy = 9;
		add(formattedPrice, gbc_formattedPrice);

		btnCompleteSale = new JButton("Complete Sale");
		btnCompleteSale.setFont(new Font("Cambria", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCompleteSale = new GridBagConstraints();
		gbc_btnCompleteSale.insets = new Insets(0, 0, 0, 5);
		gbc_btnCompleteSale.anchor = GridBagConstraints.WEST;
		gbc_btnCompleteSale.gridx = 1;
		gbc_btnCompleteSale.gridy = 10;
		add(btnCompleteSale, gbc_btnCompleteSale);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Cambria", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 10;
		add(btnCancel, gbc_btnCancel);
	}

	public boolean isInputValid() {
		if (formattedFullName.isEditValid() && formattedAddress.isEditValid()
				&& formattedPrice.isEditValid()) {
				return true;
		}
		return false;
	}
	public void updateTableModel(InventoryPainting invPainting){
		inventoryPainting = invPainting;
		Object[][] dataVector= {invPainting.toTableRow()};		
		String[] columnNames = new String[] {
				"Artist First Name", "Arist Last Name", "Title", "Date of Work",
				"Classification", "Height", "Width", "Medium", "Subject",
				"Date of Purchase", "Name of Seller", "Address of Seller",
				"Maximun Purchase Price", "Actual Purchase Price", "Target Selling Price",
				"Date of Sale", "Name of Buyer", "Address of Buyer", "Actual Selling Price"};
		tableModel.setDataVector(dataVector, columnNames);
		paintingsTable.setModel(tableModel);
	}
	
	public void updateTargetLabel()
	{
		//MoneyFormat money = new MoneyFormat();
		DecimalFormat money = new DecimalFormat("###,###,##0.00");
		String targetPrice = money.format(inventoryPainting.getTargetSellPrice());
		//lblTarget.setText("$"+inventoryPainting.getTargetSellPrice());
		lblTarget.setText("$" + targetPrice);
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

	public void resetTextFields() {
		formattedFullName.setValue(null);
		formattedAddress.setValue(null);
		formattedPrice.setValue(null);
	}

	public InventoryPainting updateInventoryPainting() {
		inventoryPainting.setBuyerName((String) formattedFullName.getValue());
		inventoryPainting.setBuyerAddress((String) formattedAddress.getValue());
		if(formattedPrice.getValue() instanceof Double)
			inventoryPainting.setActualSellPrice((Double) formattedPrice.getValue());
		else
			inventoryPainting.setActualSellPrice((Long) formattedPrice.getValue());
		return inventoryPainting;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnCompleteSale() {
		return btnCompleteSale;
	}
	public InventoryPainting getInventoryPainting() {
		return inventoryPainting;
	}
	public static void main( String[] args )
   	{
		InventoryPainting paint = new InventoryPainting();
		paint.setArtistFirstName("Micahel");
		paint.setArtistLastName("LeVan");
		paint.setTitleOfWork("Test1");
		
		CompleteSalePanel IP = new CompleteSalePanel();
		IP.updateTableModel(paint);
		JFrame frame =new JFrame("Test");		
		frame.getContentPane().add(IP , BorderLayout.CENTER);
		frame.setSize(800, 600);
		frame.setMaximumSize(new Dimension(800, 600));
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setVisible(true);
		
	}

	
}
