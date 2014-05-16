import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class AddNewArtistPanel extends JPanel {
	private JLabel lblArtistInfo;
	private JLabel lblFirstName;
	private JLabel lblLastNamemax;
	private JLabel lblFashionabilityCoefficient;
	private JFormattedTextField formattedFirstName;
	private JFormattedTextField formattedLastName;
	private JFormattedTextField formattedFashionability;
	private JButton btnAddNewArtist;
	private JButton btnCancel;

	public AddNewArtistPanel() {
		NumberFormat fashFormat = NumberFormat.getIntegerInstance();
		fashFormat.setMaximumIntegerDigits(5);
		fashFormat.setMinimumFractionDigits(1);
		lblArtistInfo = new JLabel("Artist Info");
		lblFirstName = new JLabel("First Name (max 20 characters)");
		formattedFirstName = new JFormattedTextField(
				createFormatter("A*******************"));
		lblLastNamemax = new JLabel("Last Name (max 20 characters)");
		formattedLastName = new JFormattedTextField(
				createFormatter("A*******************"));
		lblFashionabilityCoefficient = new JLabel("Fashionability Coefficient");
		formattedFashionability = new JFormattedTextField(fashFormat); // createFormatter("#####")
		btnAddNewArtist = new JButton("Add New Artist");
        btnAddNewArtist.setFont(new Font("Cambria", Font.BOLD, 12));
		btnCancel = new JButton("Cancel");

		setUpPanel();
	}

	public void setUpPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 200, 170, 0, 0, 170, 0 };
		gridBagLayout.rowHeights = new int[] { 200, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(
				UIManager.getBorder("TitledBorder.border"), "Add New Artist",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));

		lblArtistInfo.setFont(new Font("Cambria", Font.ITALIC, 12));
		GridBagConstraints gbc_lblArtistInfo = new GridBagConstraints();
		gbc_lblArtistInfo.anchor = GridBagConstraints.SOUTH;
		gbc_lblArtistInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtistInfo.gridx = 1;
		gbc_lblArtistInfo.gridy = 0;

		add(lblArtistInfo, gbc_lblArtistInfo);

		lblFirstName.setFont(new Font("Cambria", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.WEST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 1;
		add(lblFirstName, gbc_lblFirstName);

		formattedFirstName.setFont(new Font("Cambria", Font.PLAIN, 12));
		formattedFirstName.setColumns(20);
		GridBagConstraints gbc_formattedFirstName = new GridBagConstraints();
		gbc_formattedFirstName.gridwidth = 2;
		gbc_formattedFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_formattedFirstName.anchor = GridBagConstraints.WEST;
		gbc_formattedFirstName.gridx = 1;
		gbc_formattedFirstName.gridy = 2;
		add(formattedFirstName, gbc_formattedFirstName);

		lblLastNamemax.setFont(new Font("Cambria", Font.PLAIN, 12));
		GridBagConstraints gbc_lblLastNamemax = new GridBagConstraints();
		gbc_lblLastNamemax.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastNamemax.anchor = GridBagConstraints.WEST;
		gbc_lblLastNamemax.gridx = 1;
		gbc_lblLastNamemax.gridy = 4;
		add(lblLastNamemax, gbc_lblLastNamemax);

		formattedLastName.setFont(new Font("Cambria", Font.PLAIN, 12));
		formattedLastName.setColumns(20);
		GridBagConstraints gbc_formattedLastName = new GridBagConstraints();
		gbc_formattedLastName.gridwidth = 2;
		gbc_formattedLastName.insets = new Insets(0, 0, 5, 5);
		gbc_formattedLastName.anchor = GridBagConstraints.WEST;
		gbc_formattedLastName.gridx = 1;
		gbc_formattedLastName.gridy = 5;
		add(formattedLastName, gbc_formattedLastName);

		lblFashionabilityCoefficient
				.setFont(new Font("Cambria", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFashionabilityCoefficient = new GridBagConstraints();
		gbc_lblFashionabilityCoefficient.insets = new Insets(0, 0, 5, 5);
		gbc_lblFashionabilityCoefficient.anchor = GridBagConstraints.WEST;
		gbc_lblFashionabilityCoefficient.gridx = 1;
		gbc_lblFashionabilityCoefficient.gridy = 7;
		add(lblFashionabilityCoefficient, gbc_lblFashionabilityCoefficient);

		formattedFashionability.setFont(new Font("Cambria", Font.PLAIN, 12));

		formattedFashionability.setColumns(5);
		GridBagConstraints gbc_formattedFashionability = new GridBagConstraints();
		gbc_formattedFashionability.insets = new Insets(0, 0, 5, 5);
		gbc_formattedFashionability.anchor = GridBagConstraints.WEST;
		gbc_formattedFashionability.gridx = 1;
		gbc_formattedFashionability.gridy = 8;
		add(formattedFashionability, gbc_formattedFashionability);

		GridBagConstraints gbc_btnAddNewArtist = new GridBagConstraints();
		gbc_btnAddNewArtist.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddNewArtist.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddNewArtist.gridx = 1;
		gbc_btnAddNewArtist.gridy = 10;
		add(btnAddNewArtist, gbc_btnAddNewArtist);

		btnCancel.setFont(new Font("Cambria", Font.PLAIN, 12));
        btnCancel.setFont(new Font("Cambria", Font.BOLD, 12));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancel.gridx = 4;
		gbc_btnCancel.gridy = 10;
		add(btnCancel, gbc_btnCancel);
	}

	public boolean isInputValid() {

		if (formattedFirstName.isEditValid() && formattedLastName.isEditValid()
				&& formattedFashionability.isEditValid()) {
			// int fashionability=Integer.parseInt((String)
			// formattedFashionability.getValue());
			int fashionability = ((Long) formattedFashionability.getValue())
					.intValue();
			if ((fashionability >= 0) && (fashionability <= 10000))
				return true;
			else
				return false;
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

	public void resetTextFields() {
		formattedFirstName.setValue(null);
		formattedLastName.setValue(null);
		formattedFashionability.setValue(null);
	}

	public Artist createNewArtist() {
		Artist artist = new Artist();
		artist.setArtistFirstName(((String) formattedFirstName.getValue()).trim());
		artist.setArtistLastName(((String) formattedLastName.getValue()).trim());
		artist.setFashionabilityCoeff(((Long) formattedFashionability
				.getValue()).intValue()); // (String)
											// formattedFashionability.getValue())
		return artist;
	}

	public JButton getBtnAddNewArtist() {
		return btnAddNewArtist;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
}
