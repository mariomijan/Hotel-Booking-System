package gui.BookingCrud.index;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ctrl.LoginCtrl;
import gui.CreateGuestUi;
import gui.BookingCrud.Edit.BookingEdit;
import gui.BookingCrud.Edit.GuestOriginEdit;
import gui.BookingCrud.Edit.RoomEdit;
import model.Booking;

import javax.swing.JTabbedPane;

public class BookingDefault extends JPanel {

	public BookingDefault(Booking b) {
		
		setBounds(100, 100, 1024, 768);
		JPanel content = new JPanel();
		
		JPanel panel_1 = new JPanel();
		content.add(panel_1);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(e -> {

		});
		panel_1.add(btnSave);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(e -> {

		});
		panel_1.add(btnBack);

		// TabbedPane
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.add(tabbedPane, BorderLayout.NORTH);
 

		JPanel loginMenu = new BookingEdit(b);
		loginMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Booking", null, loginMenu, null);
		
		JPanel bookingMenu = new CreateGuestUi(b);
		bookingMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Guest", null, bookingMenu, null);
		
		JPanel guestOriginEdit = new GuestOriginEdit(b);
		bookingMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("GuestOrigin", null, guestOriginEdit, null);

		JPanel bookingMenu2 = new RoomEdit(b);
		bookingMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Room", null, bookingMenu2 , null);
	}
}
