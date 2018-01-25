package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Threads.UpdateBookingThread;
import ctrl.BookingCtrl;
import ctrl.InvoiceCtrl;
import gui.BookingCrud.index.BookingDefault;
import model.Booking;

public class Bookings extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 823033142698355956L;
	private BookingCtrl bCtrl = new BookingCtrl();
	private InvoiceCtrl iCtrl = new InvoiceCtrl();
	private JTable table;
	private static BookingTableModel model;

	private Utilities util;

	/**
	 * Create the panel.
	 */
	public Bookings()
	{
		
		model = new BookingTableModel();
		util = new Utilities();
		setLayout(new BorderLayout(0, 0));
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		createButtonColumn(4);
		createButtonColumn(5);
		createButtonColumn(6);
	}

	private void createButtonColumn(int position)
	{
		new ButtonColumn(table, new AbstractAction()
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Booking bN = model.getBookingAt(table.getSelectedRow());
				buttonCall(position, bN);

			}
		}, position);

	}

	private void buttonCall(int columnPos, Booking b)
	{
		switch (columnPos)
		{
		case 4:
			changeInvoiceStatus(b);
			model.updateElements();
			break;
		case 5:
			changePayedStatus(b);
			model.updateElements();
			break;
		case 6:
			delete(b);
			break;
		}
	}

	private void details(Booking b)
	{
		// TODO add some popUp here where the booking details is on etc
		System.out.println("details");
		util.refreshTab(this, new BookingFinish(b));
	}

	private void edit(Booking b)
	{
		// TODO add some popUp here where the booking Edit is on etc
		util.refreshTab(this, new BookingDefault(b));

		// TODO send the booking object the controller and update it
	}

	private void changeInvoiceStatus(Booking b)
	{

		int reply = JOptionPane.showConfirmDialog(null, "Is Invoice payed?", "Pay Invoice", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION)
		{

			iCtrl.changeStatus(b);
			JOptionPane.showMessageDialog(null, "Invoice is now payed!");
		} else
		{
			JOptionPane.showMessageDialog(null, "Invoice was not set as payed");
		}

	}

	private void changePayedStatus(Booking b)
	{
		int reply = JOptionPane.showConfirmDialog(null, "Is Booking payed?", "Pay Booking", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION)
		{
			bCtrl.changePayedStatus(b);
			JOptionPane.showMessageDialog(null, "Booking is now payed!");
		} else
		{
			JOptionPane.showMessageDialog(null, "Booking was not set as payed!");
		}

	}

	private void delete(Booking b)
	{
		JOptionPane.showConfirmDialog(null, "this amount was refunded: " + bCtrl.returnPayment(b), "Money refunded",
				JOptionPane.YES_NO_OPTION);

		int reply = JOptionPane.showConfirmDialog(null, "Delete Booking?", "Delete a booking",
				JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION)
		{
			bCtrl.deleteBookingAndRelatives(b);
		} else
		{
			JOptionPane.showMessageDialog(null, "Booking was not deleted");
		}
		model.updateElements();
	}
	
	public void update(){
		model.updateElements();
	}
}
