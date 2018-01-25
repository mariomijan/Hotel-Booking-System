package ctrl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import db.DbConnection;
import model.Booking;
import model.Guest;
import model.GuestOrigin;
import model.Invoice;
import model.Room;
import model.RoomType;

public class BookingCtrlTest
{
	private Connection con = DbConnection.getInstance().getDBcon();
	private Booking b = new Booking();
	private BookingCtrl bCtrl;
	private GuestOrigin go = new GuestOrigin("country", "postalCode", "city");
	private RoomType rt = new RoomType(1, 100, "3 person", "good room");
	private Guest g = new Guest("name", "lastname", "email", "phone", go);
	private Invoice i = new Invoice(100, 10, null, false);
	private Room r = new Room(1, rt);
	ArrayList<Booking> list = new ArrayList<Booking>();

	@Test
	public void testAddBooking()
	{

		//System.out.println(findAllBookings().size());

		//addBookingToDatabase();

		//assertEquals(5, findAllBookings().size());

	}

	@Test
	public void testDeleteNotPayedBookings()
	{

		//System.out.println(findAllBookings().size());

		//removeBooking();

		//assertEquals(4, findAllBookings().size());
	}

	// Create Booking
	private Booking createBooking()
	{
		b.setDiscount(10);
		b.setG(g);
		b.setI(i);
		b.addToR(r);
		b.setStartDate(new Date());
		b.setEndDate(new Date());

		return b;

	}

	// Add booking to Database
	private void addBookingToDatabase()
	{
		bCtrl = new BookingCtrl();
		bCtrl.addBooking(createBooking());

	}

	/*---Retrieve BOOKING from Database---*/
	public ArrayList<Booking> findAllBookings()
	{

		return miscWhere("");
	}

	private ArrayList<Booking> miscWhere(String wClause)
	{
		ResultSet results;
		ArrayList<Booking> list = new ArrayList<Booking>();
		String query = buildQuery(wClause);
		try
		{
			PreparedStatement pre = con.prepareStatement(query);

			pre.setQueryTimeout(5);

			results = pre.executeQuery();

			while (results.next())
			{
				Booking bObj;
				bObj = buildBooking(results);
				list.add(bObj);
			}

			pre.close();
			return list;

		} catch (Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return list;
	}

	private String buildQuery(String wClause)
	{
		String query = "SELECT * FROM Booking";

		if (wClause.length() > 0)
			query = query + " WHERE " + wClause;
		return query;
	}

	private Booking buildBooking(ResultSet results)
	{
		Booking bObj = null;
		try
		{
			bObj = new Booking();
		} catch (Exception e)
		{
			System.out.println("Error in building the Booking object");
		}
		return bObj;
	}

	/*--------------DELETE BOOKING--------------*/
	private String deleteQuery()
	{
		
		return "Delete from RoomBooking where bookingID in (select i.InvoiceNo from Invoice as i "
				+ "where i.paymentDate  <=  (select convert(varchar(10), getDate()+5, 101)) and i.status = 'False');"

				+ "Delete from Booking where bookingId in (select i.InvoiceNo from Invoice as i "
				+ "where i.paymentDate  <=  (select convert(varchar(10), getDate()+5, 101)) and i.status = 'False');"

				+ "Delete from Invoice where paymentDate in (select convert(varchar(10), getDate()+5, 101)) and status = 'False';";
	}

	public void removeBooking()
	{

		try
		{
			PreparedStatement deleteBooking = con.prepareStatement(deleteQuery());
			deleteBooking.executeUpdate();

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
