import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import java.awt.Font;

public class CompleteSalePanel extends JPanel {
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
	public CompleteSalePanel() {
		setUpPanel();
	}
	public void setUpPanel()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 253, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "Complete Sale",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		
		lblPaintingInformation = new JLabel("Painting Information");
		lblPaintingInformation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPaintingInformation = new GridBagConstraints();
		gbc_lblPaintingInformation.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaintingInformation.gridx = 1;
		gbc_lblPaintingInformation.gridy = 0;
		add(lblPaintingInformation, gbc_lblPaintingInformation);
		
		lblBuyerInfo = new JLabel("Buyer Information");
		lblBuyerInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblBuyerInfo = new GridBagConstraints();
		gbc_lblBuyerInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuyerInfo.gridx = 1;
		gbc_lblBuyerInfo.gridy = 2;
		add(lblBuyerInfo, gbc_lblBuyerInfo);
		
		lblFullName = new JLabel("Full Name (max 40 characters)");
		GridBagConstraints gbc_lblFullName = new GridBagConstraints();
		gbc_lblFullName.anchor = GridBagConstraints.WEST;
		gbc_lblFullName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFullName.gridx = 1;
		gbc_lblFullName.gridy = 3;
		add(lblFullName, gbc_lblFullName);
		formattedFullName = new JFormattedTextField(createFormatter("A*******************"));
		
		formattedFullName.setColumns(40);
		GridBagConstraints gbc_formattedFullName = new GridBagConstraints();
		gbc_formattedFullName.insets = new Insets(0, 0, 5, 5);
		gbc_formattedFullName.anchor = GridBagConstraints.WEST;
		gbc_formattedFullName.gridx = 1;
		gbc_formattedFullName.gridy = 4;
		add(formattedFullName, gbc_formattedFullName);
		
		lblAddress = new JLabel("Address (max 40 characters)");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 5;
		add(lblAddress, gbc_lblAddress);
		formattedAddress = new JFormattedTextField(createFormatter("A*******************"));
		
		formattedAddress.setColumns(40);
		GridBagConstraints gbc_formattedAddress = new GridBagConstraints();
		gbc_formattedAddress.insets = new Insets(0, 0, 5, 5);
		gbc_formattedAddress.anchor = GridBagConstraints.WEST;
		gbc_formattedAddress.gridx = 1;
		gbc_formattedAddress.gridy = 6;
		add(formattedAddress, gbc_formattedAddress);
		
		lblSaleInfo = new JLabel("Sale Information");
		lblSaleInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblSaleInfo = new GridBagConstraints();
		gbc_lblSaleInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaleInfo.gridx = 1;
		gbc_lblSaleInfo.gridy = 7;
		add(lblSaleInfo, gbc_lblSaleInfo);
		
		lblTitle = new JLabel("Sale Price");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.anchor = GridBagConstraints.WEST;
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 8;
		add(lblTitle, gbc_lblTitle);
		formattedPrice = new JFormattedTextField(createFormatter("A***************************************"));
		
		formattedPrice.setColumns(40);
		GridBagConstraints gbc_formattedPrice = new GridBagConstraints();
		gbc_formattedPrice.insets = new Insets(0, 0, 5, 5);
		gbc_formattedPrice.anchor = GridBagConstraints.WEST;
		gbc_formattedPrice.gridx = 1;
		gbc_formattedPrice.gridy = 9;
		add(formattedPrice, gbc_formattedPrice);
		
		btnCompleteSale = new JButton("Complete Sale");
		GridBagConstraints gbc_btnCompleteSale = new GridBagConstraints();
		gbc_btnCompleteSale.insets = new Insets(0, 0, 0, 5);
		gbc_btnCompleteSale.anchor = GridBagConstraints.WEST;
		gbc_btnCompleteSale.gridx = 1;
		gbc_btnCompleteSale.gridy = 10;
		add(btnCompleteSale, gbc_btnCompleteSale);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 10;
		add(btnCancel, gbc_btnCancel);
	}
	public boolean isInputValid()
	{
		if(formattedFullName.isEditValid() && formattedAddress.isEditValid() && formattedPrice.isEditValid())
		{
			if(formattedPrice.getValue() instanceof Long || formattedPrice.getValue() instanceof Double)
				return true;
		}
		return false;
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
	public void resetTextFields()
	{
		formattedFullName.setValue(null);
		formattedAddress.setValue(null);
		formattedPrice.setValue(null);
	}
	public InventoryPainting undateInventoryPainting(InventoryPainting inventoryPainting)
	{
		inventoryPainting.setBuyerName((String)formattedFullName.getValue());
		inventoryPainting.setBuyerAddress((String)formattedAddress.getValue());
		inventoryPainting.setActualSellPrice((Double)formattedPrice.getValue());
		return inventoryPainting;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
	public JButton getBtnCompleteSale() {
		return btnCompleteSale;
	}
}
