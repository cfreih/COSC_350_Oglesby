import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

public class ModifyDeleteArtistPanel extends JPanel {
	private JButton btnSearchForArtist;
	private JButton btnCancel;
	JFormattedTextField formattedFirstName;
	JFormattedTextField formattedLastName;
	public ModifyDeleteArtistPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 188, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "Modify/Delete Artists",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		
		btnSearchForArtist = new JButton("Search For Artist");
		btnSearchForArtist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblArtistInfo = new JLabel("Artist Info");
		lblArtistInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblArtistInfo = new GridBagConstraints();
		gbc_lblArtistInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtistInfo.gridx = 1;
		gbc_lblArtistInfo.gridy = 1;
		add(lblArtistInfo, gbc_lblArtistInfo);
		
		JLabel lblFirstName = new JLabel("First Name (max 20 characters)");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.WEST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 2;
		add(lblFirstName, gbc_lblFirstName);
		
		formattedFirstName = new JFormattedTextField(createFormatter("?*******************"));
		formattedFirstName.setColumns(20);
		GridBagConstraints gbc_formattedFirstName = new GridBagConstraints();
		gbc_formattedFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_formattedFirstName.anchor = GridBagConstraints.WEST;
		gbc_formattedFirstName.gridx = 1;
		gbc_formattedFirstName.gridy = 3;
		add(formattedFirstName, gbc_formattedFirstName);
		
		JLabel lblLastNamemax = new JLabel("Last Name (max 20 characters)");
		GridBagConstraints gbc_lblLastNamemax = new GridBagConstraints();
		gbc_lblLastNamemax.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastNamemax.anchor = GridBagConstraints.WEST;
		gbc_lblLastNamemax.gridx = 1;
		gbc_lblLastNamemax.gridy = 4;
		add(lblLastNamemax, gbc_lblLastNamemax);
		
		formattedLastName = new JFormattedTextField(createFormatter("?*******************"));
		formattedLastName.setColumns(20);
		GridBagConstraints gbc_formattedLastName = new GridBagConstraints();
		gbc_formattedLastName.insets = new Insets(0, 0, 5, 5);
		gbc_formattedLastName.anchor = GridBagConstraints.WEST;
		gbc_formattedLastName.gridx = 1;
		gbc_formattedLastName.gridy = 5;
		add(formattedLastName, gbc_formattedLastName);
		GridBagConstraints gbc_btnSearchForArtist = new GridBagConstraints();
		gbc_btnSearchForArtist.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearchForArtist.anchor = GridBagConstraints.WEST;
		gbc_btnSearchForArtist.gridx = 1;
		gbc_btnSearchForArtist.gridy = 6;
		add(btnSearchForArtist, gbc_btnSearchForArtist);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 6;
		add(btnCancel, gbc_btnCancel);
	}

	public JButton getBtnSearchForArtist() {
		return btnSearchForArtist;
	}
	public JButton getBtnCancel() {
		return btnCancel;
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

		 public static void main(String[] args) {
		  JFrame f = new JFrame("test window");
		  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  f.setResizable(false);
		  f.setLocationRelativeTo(null);
		  f.setSize(800, 600);
		  f.setLocation(10, 10);
		  f.getContentPane().add(new ModifyDeleteArtistPanel());
		  f.show();
		 }
		 public void resetTextFields()
		{
				formattedFirstName.setValue(null);
				formattedLastName.setValue(null);
		}
		 public boolean isInputValid()
			{
				if(formattedFirstName.isEditValid() && formattedLastName.isEditValid() )
				{
					return true;
				}
				else
				{
					return false;
				  }
				}
		 	public String[] getFieldValues()
			{
				String[] fieldValues = new String[2];
				fieldValues[0] = ((String) formattedFirstName.getValue()).trim();
				fieldValues[1] = ((String) formattedLastName.getValue()).trim();
				return fieldValues;
			}
		 	public static Artist createNewArtist(String[] values)
			{
				String fName = values[0];
				String lName = values[1];
				Artist artist=new Artist();
				artist.setArtistFirstName(fName);
				artist.setArtistLastName(lName);
				return artist;
			}
}
