

import javax.swing.JPanel;
import javax.swing.JFrame;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ApplyArtistChangesPanel extends JPanel {
	private JLabel lblArtistInfo;
	private JLabel lblFirstName;
	private JLabel lblLastNamemax;
	private JLabel lblFashionabilityCoefficient;
	private JFormattedTextField formattedFirstName;
	private JFormattedTextField formattedLastName;
	private JFormattedTextField formattedFashionability;
	private JButton btnSaveChanges;
	private JButton btnCancel;
	private JLabel lblNewArtistInfo;
	private JButton btnDeleteArtist;
	private JScrollPane scrollPane;
	private JTable table;
	public ApplyArtistChangesPanel() {
		formattedFirstName = new JFormattedTextField(createFormatter("A*******************"));
		formattedFirstName.setBounds(38, 120, 152, 20);
		formattedLastName = new JFormattedTextField(createFormatter("A*******************"));
		formattedLastName.setBounds(38, 164, 152, 20);
		formattedFashionability = new JFormattedTextField(createFormatter("#####"));
		formattedFashionability.setBounds(38, 209, 49, 20);
		
		setUpPanel();
	}
	public void setUpPanel()
	{
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "Apply Changes",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		setLayout(null);
		
		lblArtistInfo = new JLabel("Artist Info");
		lblArtistInfo.setBounds(141, 18, 49, 14);
		add(lblArtistInfo);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(38, 37, 354, 40);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"First Name", "Last Name", "Fashionability Coeff."
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		scrollPane.setViewportView(table);
		
		lblNewArtistInfo = new JLabel("New Artist Info (Values left blank will not be modified)");
		lblNewArtistInfo.setBounds(38, 82, 256, 14);
		add(lblNewArtistInfo);
		
		lblFirstName = new JLabel("First Name (max 20 characters)");
		lblFirstName.setBounds(38, 101, 151, 14);
		add(lblFirstName);
		
		formattedFirstName.setColumns(20);
		add(formattedFirstName);
		
		lblLastNamemax = new JLabel("Last Name (max 20 characters)");
		lblLastNamemax.setBounds(38, 145, 150, 14);
		add(lblLastNamemax);
		
		formattedLastName.setColumns(20);
		add(formattedLastName);
		
		lblFashionabilityCoefficient = new JLabel("Fashionability Coefficient");
		lblFashionabilityCoefficient.setBounds(38, 189, 120, 14);
		add(lblFashionabilityCoefficient);
		
		formattedFashionability.setColumns(5);
		add(formattedFashionability);
		
		btnDeleteArtist = new JButton("Delete Artist");
		btnDeleteArtist.setBounds(299, 208, 93, 23);
		add(btnDeleteArtist);
		
		btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(38, 236, 101, 23);
		add(btnSaveChanges);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(313, 236, 65, 23);
		add(btnCancel);
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
	public boolean isInputValid()
	{
		int fashionability=Integer.parseInt((String) formattedFashionability.getValue());
		if(formattedFirstName.isEditValid() && formattedLastName.isEditValid() && formattedFashionability.isEditValid())
		{
			if((fashionability >= 0) && (fashionability <=10000))
				return true;
			else
				return false;
		}
		return false;
	}
	public void resetTextFields()
	{
		formattedFirstName.setValue(null);
		formattedLastName.setValue(null);
		formattedFashionability.setValue(null);
	}
	public Artist createNewArtist()
	{
		Artist artist=new Artist();
		artist.setArtistFirstName((String)formattedFirstName.getValue());
		artist.setArtistLastName((String)formattedLastName.getValue());
		artist.setFashionabilityCoeff((Integer)formattedFashionability.getValue());
		return artist;
	}
	public JButton getBtnSaveChanges() {
		return btnSaveChanges;
	}
	public JButton getBtnDeleteArtist() {
		return btnDeleteArtist;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
	public static void main(String args[])
	{
		JFrame f = new JFrame("test window");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setSize(800, 600);
		f.setLocation(10, 10);
		f.getContentPane().add(new ApplyArtistChangesPanel());
		f.show();
	}
}
