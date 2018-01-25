package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GuestOriginUi extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4901829098339728098L;

	private JTable guestOriginTable;

	private JTextField txtSearch;

	public GuestOriginUi()
	{
		setLayout(new BorderLayout(0, 0));

		guestOriginTable = new JTable();

		guestOriginTable.setFillsViewportHeight(true);
		JScrollPane tableScrollPane = new JScrollPane(guestOriginTable);
		add(tableScrollPane, BorderLayout.CENTER);

		JPanel buttonPane = new JPanel();
		add(buttonPane, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		buttonPane.add(panel);

		JButton btnCreateGuestOrigin = new JButton("Create GuestOrigin");
		btnCreateGuestOrigin.addActionListener(e -> {
			this.removeAll();
			this.add(new CreateGuestOriginUi());
			this.revalidate();
			this.repaint();
		});
		panel.add(btnCreateGuestOrigin);

		JButton btnDeletebtnGuestOrigin = new JButton("Delete GuestOrigin");
		btnDeletebtnGuestOrigin.addActionListener(e -> {
			// Call some delete function from the controller
		});
		panel.add(btnDeletebtnGuestOrigin);

		JPanel searchPane = new JPanel();
		FlowLayout fl_searchPane = (FlowLayout) searchPane.getLayout();
		fl_searchPane.setAlignment(FlowLayout.RIGHT);
		add(searchPane, BorderLayout.NORTH);

		JLabel lblSearchCustomer = new JLabel("Search Customer Phone:");
		searchPane.add(lblSearchCustomer);
		txtSearch = new JTextField();
		searchPane.add(txtSearch);
	}

}
