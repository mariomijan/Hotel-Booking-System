package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Booking;

public class BookingFinish extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 227596511798156479L;
	private Utilities util;

	public BookingFinish(Booking b) {
		util = new Utilities();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 60, 55, 0, 99, 97, 0 };
		gridBagLayout.rowHeights = new int[] { 13, 14, 14, 14, 14, 0, 0, 0, 0, 155, 23, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton btnSendEmail = new JButton("Send Email");
		btnSendEmail.addActionListener(e -> {

		});

		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);

		JLabel lblBookingInformation = new JLabel("Booking Information");
		GridBagConstraints gbc_lblBookingInformation = new GridBagConstraints();
		gbc_lblBookingInformation.insets = new Insets(0, 0, 5, 5);
		gbc_lblBookingInformation.gridx = 1;
		gbc_lblBookingInformation.gridy = 0;
		add(lblBookingInformation, gbc_lblBookingInformation);

		JLabel lblGuestInformation = new JLabel("Guest Information");
		GridBagConstraints gbc_lblGuestInformation = new GridBagConstraints();
		gbc_lblGuestInformation.insets = new Insets(0, 0, 5, 0);
		gbc_lblGuestInformation.gridx = 4;
		gbc_lblGuestInformation.gridy = 0;
		add(lblGuestInformation, gbc_lblGuestInformation);

		JLabel lblBookingid = new JLabel("BookingId:");
		GridBagConstraints gbc_lblBookingid = new GridBagConstraints();
		gbc_lblBookingid.anchor = GridBagConstraints.WEST;
		gbc_lblBookingid.insets = new Insets(0, 0, 5, 5);
		gbc_lblBookingid.gridx = 0;
		gbc_lblBookingid.gridy = 1;
		add(lblBookingid, gbc_lblBookingid);

		JLabel lblBookingId = new JLabel(b.getId() + "");
		GridBagConstraints gbc_lblBookingId = new GridBagConstraints();
		gbc_lblBookingId.anchor = GridBagConstraints.WEST;
		gbc_lblBookingId.insets = new Insets(0, 0, 5, 5);
		gbc_lblBookingId.gridx = 1;
		gbc_lblBookingId.gridy = 1;
		add(lblBookingId, gbc_lblBookingId);

		JLabel lblGuestName_1 = new JLabel("Guest Name:");
		GridBagConstraints gbc_lblGuestName_1 = new GridBagConstraints();
		gbc_lblGuestName_1.anchor = GridBagConstraints.WEST;
		gbc_lblGuestName_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblGuestName_1.gridx = 3;
		gbc_lblGuestName_1.gridy = 1;
		add(lblGuestName_1, gbc_lblGuestName_1);

		JLabel lblGuestName = new JLabel(b.getG().getName());
		GridBagConstraints gbc_lblGuestName = new GridBagConstraints();
		gbc_lblGuestName.anchor = GridBagConstraints.WEST;
		gbc_lblGuestName.insets = new Insets(0, 0, 5, 0);
		gbc_lblGuestName.gridx = 4;
		gbc_lblGuestName.gridy = 1;
		add(lblGuestName, gbc_lblGuestName);

		JLabel lblTotalPrice_1 = new JLabel("Total Price:");
		GridBagConstraints gbc_lblTotalPrice_1 = new GridBagConstraints();
		gbc_lblTotalPrice_1.anchor = GridBagConstraints.WEST;
		gbc_lblTotalPrice_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalPrice_1.gridx = 0;
		gbc_lblTotalPrice_1.gridy = 2;
		add(lblTotalPrice_1, gbc_lblTotalPrice_1);

		JLabel lblTotalPrice = new JLabel(Double.toString(b.getI().getTotalPrice()));
		GridBagConstraints gbc_lblTotalPrice = new GridBagConstraints();
		gbc_lblTotalPrice.anchor = GridBagConstraints.WEST;
		gbc_lblTotalPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalPrice.gridx = 1;
		gbc_lblTotalPrice.gridy = 2;
		add(lblTotalPrice, gbc_lblTotalPrice);

		JLabel lblGuestLastname = new JLabel("Guest Lastname:");
		GridBagConstraints gbc_lblGuestLastname = new GridBagConstraints();
		gbc_lblGuestLastname.anchor = GridBagConstraints.WEST;
		gbc_lblGuestLastname.insets = new Insets(0, 0, 5, 5);
		gbc_lblGuestLastname.gridx = 3;
		gbc_lblGuestLastname.gridy = 2;
		add(lblGuestLastname, gbc_lblGuestLastname);

		JLabel lblGuestLastName = new JLabel(b.getG().getLastname());
		GridBagConstraints gbc_lblGuestLastName = new GridBagConstraints();
		gbc_lblGuestLastName.anchor = GridBagConstraints.WEST;
		gbc_lblGuestLastName.insets = new Insets(0, 0, 5, 0);
		gbc_lblGuestLastName.gridx = 4;
		gbc_lblGuestLastName.gridy = 2;
		add(lblGuestLastName, gbc_lblGuestLastName);

		JLabel lblStartDate_1 = new JLabel("Start Date:");
		GridBagConstraints gbc_lblStartDate_1 = new GridBagConstraints();
		gbc_lblStartDate_1.anchor = GridBagConstraints.WEST;
		gbc_lblStartDate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate_1.gridx = 0;
		gbc_lblStartDate_1.gridy = 3;
		add(lblStartDate_1, gbc_lblStartDate_1);

		JLabel lblStartDate = new JLabel(b.getStartDate().toString());
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.anchor = GridBagConstraints.WEST;
		gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate.gridx = 1;
		gbc_lblStartDate.gridy = 3;
		add(lblStartDate, gbc_lblStartDate);

		JLabel lblGuestPhoneno = new JLabel("Guest PhoneNo");
		GridBagConstraints gbc_lblGuestPhoneno = new GridBagConstraints();
		gbc_lblGuestPhoneno.anchor = GridBagConstraints.WEST;
		gbc_lblGuestPhoneno.insets = new Insets(0, 0, 5, 5);
		gbc_lblGuestPhoneno.gridx = 3;
		gbc_lblGuestPhoneno.gridy = 3;
		add(lblGuestPhoneno, gbc_lblGuestPhoneno);

		JLabel lblGuestPhone = new JLabel(b.getG().getPhoneNo());
		GridBagConstraints gbc_lblGuestPhone = new GridBagConstraints();
		gbc_lblGuestPhone.anchor = GridBagConstraints.WEST;
		gbc_lblGuestPhone.insets = new Insets(0, 0, 5, 0);
		gbc_lblGuestPhone.gridx = 4;
		gbc_lblGuestPhone.gridy = 3;
		add(lblGuestPhone, gbc_lblGuestPhone);

		JLabel lblEndDate_1 = new JLabel("End Date:");
		GridBagConstraints gbc_lblEndDate_1 = new GridBagConstraints();
		gbc_lblEndDate_1.anchor = GridBagConstraints.WEST;
		gbc_lblEndDate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndDate_1.gridx = 0;
		gbc_lblEndDate_1.gridy = 4;
		add(lblEndDate_1, gbc_lblEndDate_1);

		JLabel lblEndDate = new JLabel(b.getEndDate().toString());
		GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
		gbc_lblEndDate.anchor = GridBagConstraints.WEST;
		gbc_lblEndDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndDate.gridx = 1;
		gbc_lblEndDate.gridy = 4;
		add(lblEndDate, gbc_lblEndDate);

		JButton btnOk = new JButton("Create new booking");
		btnOk.addActionListener(e -> {
			util.refreshTab(this, new CreateGuestUi(null));
		});

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(e -> {
			util.refreshTab(this, new ChooseDate(b));
		});

		JLabel lblNewLabel = new JLabel("Guest email:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 4;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblGuestEmail = new JLabel(b.getG().getEmail());
		GridBagConstraints gbc_lblGuestEmail = new GridBagConstraints();
		gbc_lblGuestEmail.anchor = GridBagConstraints.WEST;
		gbc_lblGuestEmail.insets = new Insets(0, 0, 5, 0);
		gbc_lblGuestEmail.gridx = 4;
		gbc_lblGuestEmail.gridy = 4;
		add(lblGuestEmail, gbc_lblGuestEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Discount:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 5;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblDiscount = new JLabel(b.getDiscount() + "");
		GridBagConstraints gbc_lblDiscount = new GridBagConstraints();
		gbc_lblDiscount.anchor = GridBagConstraints.WEST;
		gbc_lblDiscount.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiscount.gridx = 1;
		gbc_lblDiscount.gridy = 5;
		add(lblDiscount, gbc_lblDiscount);

		JLabel lblGuestCity_1 = new JLabel("Guest City");
		GridBagConstraints gbc_lblGuestCity_1 = new GridBagConstraints();
		gbc_lblGuestCity_1.anchor = GridBagConstraints.WEST;
		gbc_lblGuestCity_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblGuestCity_1.gridx = 3;
		gbc_lblGuestCity_1.gridy = 5;
		add(lblGuestCity_1, gbc_lblGuestCity_1);

		JLabel lblGuestCity = new JLabel(b.getG().getGuestOrigin().getCity());
		GridBagConstraints gbc_lblGuestCity = new GridBagConstraints();
		gbc_lblGuestCity.anchor = GridBagConstraints.WEST;
		gbc_lblGuestCity.insets = new Insets(0, 0, 5, 0);
		gbc_lblGuestCity.gridx = 4;
		gbc_lblGuestCity.gridy = 5;
		add(lblGuestCity, gbc_lblGuestCity);

		JLabel lblLbl = new JLabel("Guest Postalcode:");
		GridBagConstraints gbc_lblLbl = new GridBagConstraints();
		gbc_lblLbl.insets = new Insets(0, 0, 5, 5);
		gbc_lblLbl.gridx = 3;
		gbc_lblLbl.gridy = 6;
		add(lblLbl, gbc_lblLbl);

		JLabel lblPostalCode = new JLabel(b.getG().getGuestOrigin().getPostalCode());
		GridBagConstraints gbc_lblPostalCode = new GridBagConstraints();
		gbc_lblPostalCode.anchor = GridBagConstraints.WEST;
		gbc_lblPostalCode.insets = new Insets(0, 0, 5, 0);
		gbc_lblPostalCode.gridx = 4;
		gbc_lblPostalCode.gridy = 6;
		add(lblPostalCode, gbc_lblPostalCode);
		
		JLabel lblGuestCountry = new JLabel("Guest Country");
		GridBagConstraints gbc_lblGuestCountry = new GridBagConstraints();
		gbc_lblGuestCountry.anchor = GridBagConstraints.WEST;
		gbc_lblGuestCountry.insets = new Insets(0, 0, 5, 5);
		gbc_lblGuestCountry.gridx = 3;
		gbc_lblGuestCountry.gridy = 7;
		add(lblGuestCountry, gbc_lblGuestCountry);
		
		JLabel lblCountry = new JLabel(b.getG().getGuestOrigin().getCountry());
		GridBagConstraints gbc_lblCountry = new GridBagConstraints();
		gbc_lblCountry.anchor = GridBagConstraints.WEST;
		gbc_lblCountry.insets = new Insets(0, 0, 5, 0);
		gbc_lblCountry.gridx = 4;
		gbc_lblCountry.gridy = 7;
		add(lblCountry, gbc_lblCountry);
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridwidth = 2;
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 10;
		add(btnBack, gbc_btnBack);
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.gridx = 2;
		gbc_btnOk.gridy = 10;
		add(btnOk, gbc_btnOk);

		JButton btnPrintPdf = new JButton("Print");
		btnPrintPdf.addActionListener(e -> {
			new Pdf(b);
		});

		GridBagConstraints gbc_btnPrintPdf = new GridBagConstraints();
		gbc_btnPrintPdf.gridwidth = 2;
		gbc_btnPrintPdf.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPrintPdf.anchor = GridBagConstraints.NORTH;
		gbc_btnPrintPdf.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrintPdf.gridx = 3;
		gbc_btnPrintPdf.gridy = 10;
		add(btnPrintPdf, gbc_btnPrintPdf);
	}

}
