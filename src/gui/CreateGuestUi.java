package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ctrl.BookingCtrl;
import model.Booking;
import model.Guest;

public class CreateGuestUi extends JPanel
{

	private static final long serialVersionUID = -4433344709435466535L;
	private BookingCtrl bCtrl;
	private Utilities util;
	private JPanel panel;
	private JButton btnBack;
	private JButton btnNext;
	private JPanel panel_1;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtPhoneNo;
	private JTextField txtCity;
	private JTextField txtCountry;
	private JTextField txtPostalCode;
	private JLabel lblFirstNameVerfication;
	private JLabel lblEmailVerification;
	private JLabel lblPhoneNoVerification;
	private JLabel lblCityVerification;
	private JLabel lblCountryVerification;
	private JLabel lblPostalCodeVerification;
	private JLabel lblLastNameVerification;

	public CreateGuestUi(Booking bReturn)
	{
		util = new Utilities();
		bCtrl = new BookingCtrl();
		setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]
		{ 428, 47, 0 };
		gbl_panel_1.rowHeights = new int[]
		{ 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 0, 0 };
		gbl_panel_1.columnWeights = new double[]
		{ 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel label = new JLabel("Create Guest");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_1.add(label, gbc_label);

		JLabel label_2 = new JLabel("First Name");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.BOTH;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		panel_1.add(label_2, gbc_label_2);

		txtFirstName = new JTextField();
		txtFirstName.setName("txtFirstName");
		txtFirstName.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		panel_1.add(txtFirstName, gbc_textField);

		lblFirstNameVerfication = new JLabel("");
		GridBagConstraints gbc_lblFirstNameVerfication = new GridBagConstraints();
		gbc_lblFirstNameVerfication.insets = new Insets(0, 0, 5, 0);
		gbc_lblFirstNameVerfication.gridx = 1;
		gbc_lblFirstNameVerfication.gridy = 2;
		panel_1.add(lblFirstNameVerfication, gbc_lblFirstNameVerfication);

		JLabel label_4 = new JLabel("Last Name");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.BOTH;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 3;
		panel_1.add(label_4, gbc_label_4);

		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 4;
		panel_1.add(txtLastName, gbc_textField_1);

		lblLastNameVerification = new JLabel("");
		GridBagConstraints gbc_lblLastNameVerification = new GridBagConstraints();
		gbc_lblLastNameVerification.insets = new Insets(0, 0, 5, 0);
		gbc_lblLastNameVerification.gridx = 1;
		gbc_lblLastNameVerification.gridy = 4;
		panel_1.add(lblLastNameVerification, gbc_lblLastNameVerification);

		JLabel label_6 = new JLabel("Email");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.fill = GridBagConstraints.BOTH;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 5;
		panel_1.add(label_6, gbc_label_6);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 6;
		panel_1.add(txtEmail, gbc_textField_2);

		lblEmailVerification = new JLabel("");
		GridBagConstraints gbc_lblEmailVerification = new GridBagConstraints();
		gbc_lblEmailVerification.insets = new Insets(0, 0, 5, 0);
		gbc_lblEmailVerification.gridx = 1;
		gbc_lblEmailVerification.gridy = 6;
		panel_1.add(lblEmailVerification, gbc_lblEmailVerification);

		JLabel label_8 = new JLabel("PhoneNo");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.fill = GridBagConstraints.BOTH;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 7;
		panel_1.add(label_8, gbc_label_8);

		txtPhoneNo = new JTextField();
		txtPhoneNo.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 0;
		gbc_textField_3.gridy = 8;
		panel_1.add(txtPhoneNo, gbc_textField_3);

		lblPhoneNoVerification = new JLabel("");
		GridBagConstraints gbc_lblPhoneNoVerification = new GridBagConstraints();
		gbc_lblPhoneNoVerification.insets = new Insets(0, 0, 5, 0);
		gbc_lblPhoneNoVerification.gridx = 1;
		gbc_lblPhoneNoVerification.gridy = 8;
		panel_1.add(lblPhoneNoVerification, gbc_lblPhoneNoVerification);

		JLabel label_10 = new JLabel("Country");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.fill = GridBagConstraints.BOTH;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 0;
		gbc_label_10.gridy = 9;
		panel_1.add(label_10, gbc_label_10);

		txtCity = new JTextField();
		txtCity.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 0;
		gbc_textField_4.gridy = 10;
		panel_1.add(txtCity, gbc_textField_4);

		lblCityVerification = new JLabel("");
		GridBagConstraints gbc_lblCityVerification = new GridBagConstraints();
		gbc_lblCityVerification.insets = new Insets(0, 0, 5, 0);
		gbc_lblCityVerification.gridx = 1;
		gbc_lblCityVerification.gridy = 10;
		panel_1.add(lblCityVerification, gbc_lblCityVerification);

		JLabel label_12 = new JLabel("City");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.fill = GridBagConstraints.BOTH;
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 0;
		gbc_label_12.gridy = 11;
		panel_1.add(label_12, gbc_label_12);

		txtCountry = new JTextField();
		txtCountry.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.BOTH;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.gridx = 0;
		gbc_textField_5.gridy = 12;
		panel_1.add(txtCountry, gbc_textField_5);

		lblCountryVerification = new JLabel("");
		GridBagConstraints gbc_lblCountryVerification = new GridBagConstraints();
		gbc_lblCountryVerification.insets = new Insets(0, 0, 5, 0);
		gbc_lblCountryVerification.gridx = 1;
		gbc_lblCountryVerification.gridy = 12;
		panel_1.add(lblCountryVerification, gbc_lblCountryVerification);

		JLabel label_14 = new JLabel("Postal code");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.fill = GridBagConstraints.BOTH;
		gbc_label_14.insets = new Insets(0, 0, 5, 5);
		gbc_label_14.gridx = 0;
		gbc_label_14.gridy = 13;
		panel_1.add(label_14, gbc_label_14);

		lblPostalCodeVerification = new JLabel("");
		GridBagConstraints gbc_lblPostalCodeVerification = new GridBagConstraints();
		gbc_lblPostalCodeVerification.insets = new Insets(0, 0, 5, 0);
		gbc_lblPostalCodeVerification.gridx = 1;
		gbc_lblPostalCodeVerification.gridy = 14;
		panel_1.add(lblPostalCodeVerification, gbc_lblPostalCodeVerification);

		txtPostalCode = new JTextField();
		txtPostalCode.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.BOTH;
		gbc_textField_6.gridx = 0;
		gbc_textField_6.gridy = 14;
		panel_1.add(txtPostalCode, gbc_textField_6);

		panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]
		{ 227, 196, 0 };
		gbl_panel.rowHeights = new int[]
		{ 1, 0 };
		gbl_panel.columnWeights = new double[]
		{ 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[]
		{ 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		btnBack = new JButton("Cancel");
		btnBack.addActionListener(e ->
		{

		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel.add(btnBack, gbc_button);

		btnNext = new JButton("Next ->");
		btnNext.addActionListener(e ->
		{
			clickNext();
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.BOTH;
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 0;
		panel.add(btnNext, gbc_button_1);

		if (bReturn != null)
		{
			fillTextFileds(bReturn);
		}

		inputVerification();

	}

	// bCtrl.checkGuestValues(txtName.getText(), txtLastName.getText(),
	// txtEmail.getText(),
	// txtPhoneNo.getText(),txtCity.getText(), txtCountry.getText(),
	// txtPostalCode.getText());

	private void clickNext()
	{
		Booking b = bCtrl.createBooking();
		Guest g = bCtrl.createGuest(txtFirstName.getText(), txtLastName.getText(), txtEmail.getText(),
				txtPhoneNo.getText(), txtCountry.getText(), txtPostalCode.getText(), txtCity.getText());
		b.setG(g);

		Color green = Color.green;
		if (txtFirstName.getBackground() == green && txtLastName.getBackground() == green
				&& txtEmail.getBackground() == green && txtPhoneNo.getBackground() == green
				&& txtCity.getBackground() == green && txtCountry.getBackground() == green
				&& txtPostalCode.getBackground() == green)
		{
			util.refreshTab(this, new ChooseDate(b));
		} else
		{
			JOptionPane.showMessageDialog(null, "Please fill out all the fields ");
		}

	}

	private void fillTextFileds(Booking b)
	{
		Guest g = b.getG();
		txtFirstName.setText(g.getName());
		txtLastName.setText(g.getLastname());
		txtEmail.setText(g.getEmail());
		txtPhoneNo.setText(g.getPhoneNo());
		txtCity.setText(g.getGuestOrigin().getCity());
		txtCountry.setText(g.getGuestOrigin().getCountry());
		txtPostalCode.setText(g.getGuestOrigin().getPostalCode());
	}

	private void inputVerification()
	{
		txtFirstName.getDocument()
				.addDocumentListener(new TextFieldValidator(txtFirstName, lblFirstNameVerfication, "[a-zA-Z]+"));
		txtLastName.getDocument()
				.addDocumentListener(new TextFieldValidator(txtLastName, lblLastNameVerification, "[a-zA-Z]+"));
		txtEmail.getDocument().addDocumentListener(new TextFieldValidator(txtEmail, lblEmailVerification,
				"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$"));
		txtPhoneNo.getDocument()
				.addDocumentListener(new TextFieldValidator(txtPhoneNo, lblPhoneNoVerification, "[0-9]{8,20}"));
		txtCity.getDocument().addDocumentListener(new TextFieldValidator(txtCity, lblCityVerification, "[a-zA-Z]+"));
		txtCountry.getDocument()
				.addDocumentListener(new TextFieldValidator(txtCountry, lblCountryVerification, "[a-zA-Z]+"));
		txtPostalCode.getDocument()
				.addDocumentListener(new TextFieldValidator(txtPostalCode, lblPostalCodeVerification, "[0-9]{3,10}"));
	}

}
