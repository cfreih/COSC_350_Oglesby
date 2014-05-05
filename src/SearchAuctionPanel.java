import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

/**
 * 
 */

/**
 * @author Clint
 *
 */
public class SearchAuctionPanel extends JPanel {
	
	private SpringLayout springLayout;
	private JLabel lblArtistFirstName;
	private JFormattedTextField formattedFirstName;
	private JLabel lblArtistLastName;
	private JFormattedTextField formattedLastName;
	private JLabel lblTitleOfWork;
	private JFormattedTextField formattedTitleOfWork;
	private JButton btnSearch;
	private JButton btnCancel;
	
	public SearchAuctionPanel() 
	{
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new TitledBorder(null, "Manage Auction Records", TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		springLayout = new SpringLayout();
		lblArtistFirstName = new JLabel("Artist First Name (max 20 characters)");
		formattedFirstName = new JFormattedTextField(createFormatter("********************"));
		lblArtistLastName = new JLabel("Artist Last Name (max 20 characters)");
		formattedLastName = new JFormattedTextField(createFormatter("********************"));
		lblTitleOfWork = new JLabel("Title Of Work (max 40 characters)");
		formattedTitleOfWork = new JFormattedTextField(createFormatter("****************************************"));
		btnSearch = new JButton("Search");
		btnCancel = new JButton("Cancel");
		
		
		setUpPanel();
	}
	
	/**
	 * Desc: Sets up the Panel for this class.
	 */
	public void setUpPanel()
	{
		SpringLayout springLayout_1 = new SpringLayout();
		springLayout_1.putConstraint(SpringLayout.NORTH, btnCancel, 0, SpringLayout.NORTH, btnSearch);
		springLayout_1.putConstraint(SpringLayout.WEST, btnCancel, 293, SpringLayout.EAST, btnSearch);
		springLayout_1.putConstraint(SpringLayout.SOUTH, btnCancel, 0, SpringLayout.SOUTH, btnSearch);
		springLayout_1.putConstraint(SpringLayout.EAST, btnCancel, -151, SpringLayout.EAST, this);
		springLayout_1.putConstraint(SpringLayout.NORTH, formattedFirstName, 7, SpringLayout.SOUTH, lblArtistFirstName);
		springLayout_1.putConstraint(SpringLayout.WEST, formattedFirstName, 0, SpringLayout.WEST, lblArtistFirstName);
		springLayout_1.putConstraint(SpringLayout.WEST, lblArtistFirstName, 40, SpringLayout.WEST, this);
		springLayout_1.putConstraint(SpringLayout.SOUTH, lblArtistFirstName, -506, SpringLayout.SOUTH, this);
		setLayout(springLayout_1);
		
		lblArtistFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblArtistFirstName);
		
		formattedFirstName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedFirstName.setColumns(20);
		add(formattedFirstName);
		
		springLayout_1.putConstraint(SpringLayout.WEST, lblArtistLastName, 0, SpringLayout.WEST, lblArtistFirstName);
		springLayout_1.putConstraint(SpringLayout.SOUTH, lblArtistLastName, -406, SpringLayout.SOUTH, this);
		lblArtistLastName.setFont(new Font("Century", Font.PLAIN, 12));
		add(lblArtistLastName);
		
		formattedLastName.setFont(new Font("Century", Font.PLAIN, 12));
		formattedLastName.setColumns(20);
		springLayout_1.putConstraint(SpringLayout.WEST, formattedLastName, 40, SpringLayout.WEST, this);
		springLayout_1.putConstraint(SpringLayout.EAST, formattedLastName, -559, SpringLayout.EAST, this);
		springLayout_1.putConstraint(SpringLayout.EAST, formattedFirstName, 0, SpringLayout.EAST, formattedLastName);
		springLayout_1.putConstraint(SpringLayout.NORTH, formattedLastName, 6, SpringLayout.SOUTH, lblArtistLastName);
		add(formattedLastName);
		
		lblTitleOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout_1.putConstraint(SpringLayout.NORTH, lblTitleOfWork, 58, SpringLayout.SOUTH, formattedLastName);
		springLayout_1.putConstraint(SpringLayout.WEST, lblTitleOfWork, 0, SpringLayout.WEST, lblArtistFirstName);
		add(lblTitleOfWork);
		
		formattedTitleOfWork.setFont(new Font("Century", Font.PLAIN, 12));
		formattedTitleOfWork.setColumns(40);
		springLayout_1.putConstraint(SpringLayout.NORTH, formattedTitleOfWork, 6, SpringLayout.SOUTH, lblTitleOfWork);
		springLayout_1.putConstraint(SpringLayout.WEST, formattedTitleOfWork, 0, SpringLayout.WEST, lblArtistFirstName);
		add(formattedTitleOfWork);
		
		btnSearch.setMnemonic('S');
		btnSearch.setFont(new Font("Century", Font.PLAIN, 12));
		springLayout_1.putConstraint(SpringLayout.NORTH, btnSearch, 85, SpringLayout.SOUTH, formattedTitleOfWork);
		springLayout_1.putConstraint(SpringLayout.WEST, btnSearch, 0, SpringLayout.WEST, lblArtistFirstName);
		springLayout_1.putConstraint(SpringLayout.SOUTH, btnSearch, -155, SpringLayout.SOUTH, this);
		springLayout_1.putConstraint(SpringLayout.EAST, btnSearch, 190, SpringLayout.WEST, this);
		add(btnSearch);
		
		btnCancel.setMnemonic('C');
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
