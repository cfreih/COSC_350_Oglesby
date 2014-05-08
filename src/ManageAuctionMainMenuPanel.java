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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**

/**
 * @author Clint
 * 
 */
public class ManageAuctionMainMenuPanel extends JPanel {

	private GridBagLayout gridBagLayout;
	private JButton SeeAllPaintingsButton;
	private JButton ModifyPaintingButton;
	private JButton AddNewPaintingButton;
	private JButton ReturnToMainButton;

	public ManageAuctionMainMenuPanel() {
		gridBagLayout = new GridBagLayout();
		SeeAllPaintingsButton = new JButton(
				"See All Paintings in Auction Record");
		ModifyPaintingButton = new JButton(
				"Modify/Update Existing Painting in Auction Records");
		AddNewPaintingButton = new JButton(
				"Add New Painting to Auction Records");
		ReturnToMainButton = new JButton("Return to Main Menu");

		setUpPanel();
	}

	public void setUpPanel() {
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED,
				null, null), new TitledBorder(
				UIManager.getBorder("TitledBorder.border"),
				"Manage Auction Records", TitledBorder.CENTER,
				TitledBorder.ABOVE_TOP, null, null)));

		gridBagLayout.columnWidths = new int[] { 37, 250, 0 };
		gridBagLayout.rowHeights = new int[] { 95, 50, 74, 51, 74, 50, 74, 50,
				0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		GridBagConstraints gbc_SeeAllPaintingsButton = new GridBagConstraints();
		gbc_SeeAllPaintingsButton.fill = GridBagConstraints.BOTH;
		gbc_SeeAllPaintingsButton.insets = new Insets(0, 0, 5, 0);
		gbc_SeeAllPaintingsButton.gridx = 1;
		gbc_SeeAllPaintingsButton.gridy = 1;
		add(SeeAllPaintingsButton, gbc_SeeAllPaintingsButton);
		SeeAllPaintingsButton.setFont(new Font("Century", Font.PLAIN, 12));
		SeeAllPaintingsButton.setMnemonic('S');

		GridBagConstraints gbc_ModifyPaintingButton = new GridBagConstraints();
		gbc_ModifyPaintingButton.fill = GridBagConstraints.BOTH;
		gbc_ModifyPaintingButton.insets = new Insets(0, 0, 5, 0);
		gbc_ModifyPaintingButton.gridx = 1;
		gbc_ModifyPaintingButton.gridy = 3;
		add(ModifyPaintingButton, gbc_ModifyPaintingButton);
		ModifyPaintingButton.setFont(new Font("Century", Font.PLAIN, 12));
		ModifyPaintingButton.setMnemonic('M');

		GridBagConstraints gbc_AddNewPaintingButton = new GridBagConstraints();
		gbc_AddNewPaintingButton.fill = GridBagConstraints.BOTH;
		gbc_AddNewPaintingButton.insets = new Insets(0, 0, 5, 0);
		gbc_AddNewPaintingButton.gridx = 1;
		gbc_AddNewPaintingButton.gridy = 5;
		add(AddNewPaintingButton, gbc_AddNewPaintingButton);
		AddNewPaintingButton.setFont(new Font("Century", Font.PLAIN, 12));
		AddNewPaintingButton.setMnemonic('A');

		GridBagConstraints gbc_ReturnToMainButton = new GridBagConstraints();
		gbc_ReturnToMainButton.fill = GridBagConstraints.BOTH;
		gbc_ReturnToMainButton.gridx = 1;
		gbc_ReturnToMainButton.gridy = 7;
		add(ReturnToMainButton, gbc_ReturnToMainButton);
		ReturnToMainButton.setFont(new Font("Century", Font.PLAIN, 12));
		ReturnToMainButton.setMnemonic('R');
	}
	public JButton getSeeAllPaintingsButton() {
		return SeeAllPaintingsButton;
	}
	public JButton getModifyPaintingButton() {
		return ModifyPaintingButton;
	}
	public JButton getAddNewPaintingButton() {
		return AddNewPaintingButton;
	}
	public JButton getReturnToMainButton() {
		return ReturnToMainButton;
	}
}
