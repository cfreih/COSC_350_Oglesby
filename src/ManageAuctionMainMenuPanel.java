import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * 
 */

/**
 * @author Clint
 *
 */
public class ManageAuctionMainMenuPanel extends JPanel {
	
	private SpringLayout springLayout;
	private JButton SeeAllPaintingsButton;
	private JButton ModifyPaintingButton;
	private JButton AddNewPaintingButton;
	private JButton ReturnToMainButton;
	
	public ManageAuctionMainMenuPanel()
	{
		springLayout = new SpringLayout();
		
		SeeAllPaintingsButton = new JButton("See All Paintings in Auction Record");
		ModifyPaintingButton = new JButton("Modify/Update Existing Painting in Auction Records");
		AddNewPaintingButton = new JButton("Add New Painting to Auction Records");
		ReturnToMainButton = new JButton("Return to Main Menu");
		
		setUpPanel();
	}
	
	public void setUpPanel()
	{
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Manage Auction Records", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null)));
		
		setLayout(springLayout);
		
		add(SeeAllPaintingsButton);		
		SeeAllPaintingsButton.setFont(new Font("Century", Font.PLAIN, 12));
		SeeAllPaintingsButton.setMnemonic('S');
		springLayout.putConstraint(SpringLayout.NORTH, SeeAllPaintingsButton, 60, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, SeeAllPaintingsButton, 30, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, SeeAllPaintingsButton, 110, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, SeeAllPaintingsButton, 280, SpringLayout.WEST, this);
		
		add(ModifyPaintingButton);
		ModifyPaintingButton.setFont(new Font("Century", Font.PLAIN, 12));
		ModifyPaintingButton.setMnemonic('M');
		springLayout.putConstraint(SpringLayout.NORTH, ModifyPaintingButton, 70, SpringLayout.SOUTH, SeeAllPaintingsButton);
		springLayout.putConstraint(SpringLayout.WEST, ModifyPaintingButton, 0, SpringLayout.WEST, SeeAllPaintingsButton);
		springLayout.putConstraint(SpringLayout.SOUTH, ModifyPaintingButton, -342, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, ModifyPaintingButton, 0, SpringLayout.EAST, SeeAllPaintingsButton);
		
		add(AddNewPaintingButton);
		AddNewPaintingButton.setFont(new Font("Century", Font.PLAIN, 12));
		AddNewPaintingButton.setMnemonic('A');
		springLayout.putConstraint(SpringLayout.NORTH, AddNewPaintingButton, 70, SpringLayout.SOUTH, ModifyPaintingButton);
		springLayout.putConstraint(SpringLayout.WEST, AddNewPaintingButton, -250, SpringLayout.EAST, SeeAllPaintingsButton);
		springLayout.putConstraint(SpringLayout.SOUTH, AddNewPaintingButton, 120, SpringLayout.SOUTH, ModifyPaintingButton);
		springLayout.putConstraint(SpringLayout.EAST, AddNewPaintingButton, 0, SpringLayout.EAST, SeeAllPaintingsButton);
		
		add(ReturnToMainButton);
		ReturnToMainButton.setFont(new Font("Century", Font.PLAIN, 12));
		ReturnToMainButton.setMnemonic('R');
		springLayout.putConstraint(SpringLayout.NORTH, ReturnToMainButton, 70, SpringLayout.SOUTH, AddNewPaintingButton);
		springLayout.putConstraint(SpringLayout.WEST, ReturnToMainButton, 0, SpringLayout.WEST, SeeAllPaintingsButton);
		springLayout.putConstraint(SpringLayout.SOUTH, ReturnToMainButton, 120, SpringLayout.SOUTH, AddNewPaintingButton);
		springLayout.putConstraint(SpringLayout.EAST, ReturnToMainButton, 250, SpringLayout.WEST, SeeAllPaintingsButton);
	}
}
