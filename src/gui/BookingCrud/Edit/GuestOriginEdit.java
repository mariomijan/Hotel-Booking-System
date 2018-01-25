package gui.BookingCrud.Edit;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ctrl.BookingCtrl;
import model.Booking;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuestOriginEdit extends JPanel{
		private JPanel panel_1;
		private JButton btnNewButton;
		private JButton btnNewButton_1;
		private JTextField txtPostalCode;
		private JTextField txtCountry;
		private JTextField txtCity;
		private JLabel lblCountry;
		private JLabel lblPostalCode;
		private JLabel lblCity;
		private JLabel lblEditGuestorigin;
		private BookingCtrl bCtrl;
		public GuestOriginEdit(Booking b){
			bCtrl = new BookingCtrl();
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{136, 118, 89, 0};
			gridBagLayout.rowHeights = new int[]{266, 32, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.anchor = GridBagConstraints.NORTHWEST;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 0;
			add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 110, 99, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			lblEditGuestorigin = new JLabel("Edit GuestOrigin");
			GridBagConstraints gbc_lblEditGuestorigin = new GridBagConstraints();
			gbc_lblEditGuestorigin.insets = new Insets(0, 0, 5, 5);
			gbc_lblEditGuestorigin.gridx = 1;
			gbc_lblEditGuestorigin.gridy = 0;
			panel.add(lblEditGuestorigin, gbc_lblEditGuestorigin);
			
			txtCountry = new JTextField(b.getG().getGuestOrigin().getCountry());
			GridBagConstraints gbc_txtCountry = new GridBagConstraints();
			gbc_txtCountry.insets = new Insets(0, 0, 5, 5);
			gbc_txtCountry.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCountry.gridx = 1;
			gbc_txtCountry.gridy = 1;
			panel.add(txtCountry, gbc_txtCountry);
			txtCountry.setColumns(10);
			
			lblCountry = new JLabel("Country");
			GridBagConstraints gbc_lblCountry = new GridBagConstraints();
			gbc_lblCountry.insets = new Insets(0, 0, 5, 0);
			gbc_lblCountry.gridx = 2;
			gbc_lblCountry.gridy = 1;
			panel.add(lblCountry, gbc_lblCountry);
			
			txtPostalCode = new JTextField(b.getG().getGuestOrigin().getPostalCode());
			GridBagConstraints gbc_txtPostalCode = new GridBagConstraints();
			gbc_txtPostalCode.insets = new Insets(0, 0, 5, 5);
			gbc_txtPostalCode.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPostalCode.gridx = 1;
			gbc_txtPostalCode.gridy = 2;
			panel.add(txtPostalCode, gbc_txtPostalCode);
			txtPostalCode.setColumns(10);
			
			lblPostalCode = new JLabel("PostalCode");
			GridBagConstraints gbc_lblPostalCode = new GridBagConstraints();
			gbc_lblPostalCode.insets = new Insets(0, 0, 5, 0);
			gbc_lblPostalCode.gridx = 2;
			gbc_lblPostalCode.gridy = 2;
			panel.add(lblPostalCode, gbc_lblPostalCode);
			
			txtCity = new JTextField(b.getG().getGuestOrigin().getCity());
			GridBagConstraints gbc_txtCity = new GridBagConstraints();
			gbc_txtCity.insets = new Insets(0, 0, 5, 5);
			gbc_txtCity.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCity.gridx = 1;
			gbc_txtCity.gridy = 3;
			panel.add(txtCity, gbc_txtCity);
			txtCity.setColumns(10);
			
			lblCity = new JLabel("City");
			GridBagConstraints gbc_lblCity = new GridBagConstraints();
			gbc_lblCity.insets = new Insets(0, 0, 5, 0);
			gbc_lblCity.gridx = 2;
			gbc_lblCity.gridy = 3;
			panel.add(lblCity, gbc_lblCity);
			
			panel_1 = new JPanel();
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.insets = new Insets(0, 0, 0, 5);
			gbc_panel_1.anchor = GridBagConstraints.WEST;
			gbc_panel_1.gridx = 1;
			gbc_panel_1.gridy = 1;
			add(panel_1, gbc_panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{0, 105, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0};
			gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			
			btnNewButton = new JButton("Save");
			btnNewButton.addActionListener(e -> {
				updateBooking(b);
			});
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton.gridx = 0;
			gbc_btnNewButton.gridy = 0;
			panel_1.add(btnNewButton, gbc_btnNewButton);
			
			btnNewButton_1 = new JButton("Cancel");
			GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
			gbc_btnNewButton_1.gridx = 1;
			gbc_btnNewButton_1.gridy = 0;
			panel_1.add(btnNewButton_1, gbc_btnNewButton_1);

	}
		
	private void updateBooking(Booking b){
		//bCtrl.updateBooking(b, b);		

	}
}
