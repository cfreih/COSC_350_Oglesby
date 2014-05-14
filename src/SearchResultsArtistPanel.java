import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JList;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;


public class SearchResultsArtistPanel extends JPanel {
	
	private GridBagLayout gridBagLayout;
	private JButton btnSelect;
	private JButton btnCancel;
	private JScrollPane scrollPaneList;
	private JList<Artist> listSearchResults;
	private JLabel lblSearchResults;
	private Artist[] searchResults;
	
	public SearchResultsArtistPanel() {
		
		gridBagLayout = new GridBagLayout();
		scrollPaneList = new JScrollPane();
		listSearchResults = new JList<Artist>();
		lblSearchResults = new JLabel("Search Results");
		btnSelect = new JButton("Select");
		btnCancel = new JButton("Cancel");
		
		setUpPanel();
	}
	
	public void setUpPanel()
	{
		setBorder(new TitledBorder(null, "Select Artist", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		gridBagLayout.columnWidths = new int[]{0, 325, 0, 0, 325, 0};
		gridBagLayout.rowHeights = new int[]{0, 400, 0, 34, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		GridBagConstraints gbc_scrollPaneList = new GridBagConstraints();
		gbc_scrollPaneList.gridheight = 2;
		gbc_scrollPaneList.gridwidth = 4;
		gbc_scrollPaneList.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneList.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneList.gridx = 1;
		gbc_scrollPaneList.gridy = 1;
		add(scrollPaneList, gbc_scrollPaneList);
		
		
		scrollPaneList.setViewportView(listSearchResults);		
		lblSearchResults.setLabelFor(listSearchResults);
		lblSearchResults.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchResults.setFont(new Font("Century", Font.PLAIN, 12));
		scrollPaneList.setColumnHeaderView(lblSearchResults);
		
		
		btnSelect.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.fill = GridBagConstraints.BOTH;
		gbc_btnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelect.gridx = 1;
		gbc_btnSelect.gridy = 3;
		add(btnSelect, gbc_btnSelect);
		
				
		btnCancel.setFont(new Font("Century", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.BOTH;
		gbc_btnCancel.gridx = 4;
		gbc_btnCancel.gridy = 3;
		add(btnCancel, gbc_btnCancel);
	}
	
	/**
	 * Desc: Takes a searchPainting and sets the list to what that will
	 * 		 retrieve from the auction, the search results.
	 * Post: listSearchResults has the data of searchResults.
	 */
	public void updateSearchResultsList(Artist[] searchResults)
	{
		listSearchResults.setListData(searchResults);
	}
	
	/**
	 * Desc: Gets the selected painting and returns what it is.
	 * @return the painting selected in the listSearchResults.
	 */
	public Artist getSelectedPainting()
	{
		return listSearchResults.getSelectedValue();
	}

	public JButton getBtnSelect() {
		return btnSelect;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
}
