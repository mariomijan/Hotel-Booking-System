package ctrl;

import java.util.ArrayList;

import Threads.UpdateBookingThread;
import Threads.UpdateRoomThread;
import db.BookingDb;
import gui.Bookings;
import gui.ChooseDate;
import model.Booking;
import model.Guest;
import model.GuestOrigin;
import model.Invoice;
import model.Room;
import model.RoomType;

public class BookingCtrl
{
	private BookingDb bDb;
	private GuestOriginCtrl goCtrl;
	private GuestCtrl gCtrl;
	private RoomTypeCtrl rtCtrl;
	private InvoiceCtrl iCtrl;
	private UpdateRoomThread updateThread = new UpdateRoomThread();
 

	// Constructor for bookingController
	public BookingCtrl()
	{
		bDb = new BookingDb();
		goCtrl = new GuestOriginCtrl();
		gCtrl = new GuestCtrl();
		rtCtrl = new RoomTypeCtrl();
		iCtrl = new InvoiceCtrl();
	}

	// Creates the booking and returns the booking object
	public Booking createBooking()
	{
		Booking b = new Booking();
		return b;
	}

	// Creates the invoice
	public Invoice createInvoice(Booking b)
	{
		return iCtrl.createInvoice(b);
	}

	// Creates a new Guest here
	public Guest createGuest(String name, String lastName, String email, String phoneNo, String country,
			String postalCode, String city)
	{
		GuestOrigin go = goCtrl.createGuestOrigin(country, postalCode, city);
		return gCtrl.createGuest(name, lastName, email, phoneNo, go);
	}

	// Returns all the roomTypes from the database
	public ArrayList<RoomType> getAllRoomTypes()
	{
		return rtCtrl.findAllRoomTypes();
	}

	// Creates a new Room
	public int createRoom(Room r)
	{
		return r.getRoomNo();
	}

	// Finds all the free Rooms on a given date. Used to show in calendar
	public ArrayList<Room> findAllFreeRooms(Booking b, int id)
	{
		return bDb.getRooms(b, id);
	}

	// Adds the booking object and associative to the database
	public Booking addBooking(Booking b)
	{
		goCtrl.addGuestOrigin(b.getG().getGuestOrigin());
		b.getG().getGuestOrigin().setId(goCtrl.findGuestOrigin(b.getG().getGuestOrigin()).getId());
		gCtrl.addGuest(b.getG());
		b.getG().setId(gCtrl.findGuestId(b.getG().getPhoneNo()));
		bDb.addBooking(b);
		b.setId(bDb.findBookingId(b));
		b.setI(iCtrl.createInvoice(b));
		return b;
	}

	// Deletes all the bookings, invoice and room_bookings
	public void deleteNotPayedBookings()
	{
		bDb.deleteReservedBooking();
	}

	// @Return Booking Object
	public ArrayList<Booking> getAllBookings()
	{
		// Get All booking
		return bDb.getAllBookings();
	}

	// Starts the update thread
	public void startThread()
	{
		Thread updThread = new Thread(updateThread);
		updThread.setName("Update Thread");
		updThread.start();
	}
	
	private UpdateBookingThread updateBookingT = new UpdateBookingThread();
	//Start Bookings Gui Thread
	public void startUpdateBookingThread()
	{
		Thread bUpdThread = new Thread(updateBookingT);
		updateBookingT.setCancel(false);
		
		bUpdThread.setName("Update Thread");
		bUpdThread.start();
	}
	
	public void stopUpdateBookingThread(){
		updateBookingT.setCancel(true);
	}


	// Sets chooseDate object on thread
	public void setGui(ChooseDate gui)
	{
		updateThread.setGui(gui);
	}

	// Stops the thread
	public void stopUpdateThread()
	{
		updateThread.cancel();
	}

	// Deletes the invoice, RoomBooking and booking from the database by calling
	// the controller
	public void deleteBookingAndRelatives(Booking b)
	{
		bDb.deleteBookingAndRelatives(b);
	}

	// Changes the payment status on the booking
	public void changePayedStatus(Booking b)
	{
		bDb.changePayedStatus(b);
	}

	// Calculates the amount that has to be returned to a customer in case of refunds
	public double returnPayment(Booking b)
	{
		return bDb.returnPayment(b);
	}

	

}
