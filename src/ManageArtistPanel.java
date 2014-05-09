package test;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ManageArtistPanel extends JPanel {
	private JButton btnModifyDeleteExistingArtist;
	private JButton btnAddNewArtist;
	private JButton btnSeeAllArtists;
	public ManageArtistPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{64, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 75, 0, 75, 62, 75, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), new TitledBorder(null, "Manage Artists",
				TitledBorder.CENTER, TitledBorder.TOP, null, null)));
		
		btnSeeAllArtists = new JButton("See All Artists");
		GridBagConstraints gbc_btnSeeAllArtists = new GridBagConstraints();
		gbc_btnSeeAllArtists.fill = GridBagConstraints.BOTH;
		gbc_btnSeeAllArtists.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeeAllArtists.gridx = 1;
		gbc_btnSeeAllArtists.gridy = 2;
		add(btnSeeAllArtists, gbc_btnSeeAllArtists);
		
		btnModifyDeleteExistingArtist = new JButton("Modify/Delete Existing Artist");
		GridBagConstraints gbc_btnModifyDeleteExistingArtist = new GridBagConstraints();
		gbc_btnModifyDeleteExistingArtist.fill = GridBagConstraints.BOTH;
		gbc_btnModifyDeleteExistingArtist.insets = new Insets(0, 0, 5, 0);
		gbc_btnModifyDeleteExistingArtist.gridx = 1;
		gbc_btnModifyDeleteExistingArtist.gridy = 4;
		add(btnModifyDeleteExistingArtist, gbc_btnModifyDeleteExistingArtist);
		
		btnAddNewArtist = new JButton("Add New Artist");
		GridBagConstraints gbc_btnAddNewArtist = new GridBagConstraints();
		gbc_btnAddNewArtist.fill = GridBagConstraints.BOTH;
		gbc_btnAddNewArtist.gridx = 1;
		gbc_btnAddNewArtist.gridy = 6;
		add(btnAddNewArtist, gbc_btnAddNewArtist);
	}

	public JButton getBtnModifyDeleteExistingArtist() {
		return btnModifyDeleteExistingArtist;
	}
	public JButton getBtnAddNewArtist() {
		return btnAddNewArtist;
	}
	public JButton getBtnSeeAllArtists() {
		return btnSeeAllArtists;
	}
}
