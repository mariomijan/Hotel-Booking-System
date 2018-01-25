package ctrl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import db.InvoiceDb;
import model.Booking;
import model.Invoice;
import model.Room;

public class InvoiceCtrl
{
	private InvoiceDb iDb;

	public InvoiceCtrl()
	{
		iDb = new InvoiceDb();
	}

	// Creates the invoice, adds it to the database and returns it
	public Invoice createInvoice(Booking b)
	{
		Invoice i = new Invoice(b.getId(), totalPriceCalculation(b), paymentDate(), false);
		iDb.addInvoiceToDB(i);
		return i;
	}

	// Calculates the total price for the stay
	public double totalPriceCalculation(Booking b)
	{
		Double totalPrice = 0.00;
		for (Room r : b.getR())
		{
			totalPrice += r.getRt().getRoomPrice() * b.daysBetween(b.getStartDate(), b.getEndDate());
		}
		return totalPrice;

		// b.getR().get(0).getRt().getRoomPrice() *
		// b.daysBetween(b.getStartDate(), b.getEndDate());
	}

	// Gets the paymentDate 5 days ahead of today and returns it
	public Date paymentDate()
	{
		LocalDate ltd = LocalDateTime.now().plusDays(5).toLocalDate();
		return Date.valueOf(ltd);
	}

	// Calculates the totalPrice after discount and returns it
	public double calculateTotalPrice(Booking b)
	{
		double totalPrice = b.getI().getTotalPrice() - (b.getDiscount() / 100 * b.getI().getTotalPrice());
		return totalPrice;
	}

	// Calculates the deposit and returns it
	public double deposit(Booking b)
	{
		double deposit = (totalPriceCalculation(b) / 2);
		return deposit;
	}

	// Changes the invoice status
	public void changeStatus(Booking b)
	{
		iDb.updateStatus(b);
	}

}
