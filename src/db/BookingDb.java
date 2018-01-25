package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Booking;
import model.Guest;
import model.GuestOrigin;
import model.Invoice;
import model.Room;
import model.RoomType;

public class BookingDb extends FrameWork
{
	private Connection con;

	// BookingDB constructor gets the singleton DB connection
	public BookingDb()
	{
		con = DbConnection.getInstance().getDBcon();
	}

	// Adds the booking to the database
	public void addBooking(Booking b)
	{
		String query = addQueryBooking(b);
		PreparedStatement addBooking = null;

		String queryRB = addQueryRoomBooking();
		PreparedStatement addRoomBooking = null;

		java.sql.Date sqlDate0 = new java.sql.Date(b.getStartDate().getTime());
		java.sql.Date sqlDate1 = new java.sql.Date(b.getEndDate().getTime());

		try
		{
			con.setAutoCommit(false);

			addBooking = con.prepareStatement(query);
			addRoomBooking = con.prepareStatement(queryRB);
			// Adds the Booking to the database
			// startDate, endDate, discount, guestID
			addBooking.setDate(1, sqlDate0);
			addBooking.setDate(2, sqlDate1);
			addBooking.setInt(3, b.getDiscount());
			addBooking.setInt(4, b.getG().getId());
			addBooking.setBoolean(5, false);
			addBooking.executeUpdate();
			// con.commit();
			// Adds the RoomBooking relation

			for (Room r : b.getR())
			{
				addRoomBooking.setInt(1, findBookingId(b));
				addRoomBooking.setInt(2, r.getRoomNo());
				addRoomBooking.executeUpdate();

			}

			con.commit();
		} catch (SQLException e)
		{
			try
			{
				con.rollback();
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally
		{
			try
			{
				if (addBooking != null)
				{
					addBooking.close();
				}
				if (addRoomBooking != null)
				{
					addRoomBooking.close();
				}
				con.setAutoCommit(true);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	// Finds a specific bookingId
	public int findBookingId(Booking b)
	{
		String findQuery = findQueryBookingId();
		PreparedStatement findId = null;
		ResultSet rs = null;
		int id = 0;
		try
		{
			con.setAutoCommit(false);
			java.sql.Date sqlDate0 = new java.sql.Date(b.getStartDate().getTime());
			java.sql.Date sqlDate1 = new java.sql.Date(b.getEndDate().getTime());
			findId = con.prepareStatement(findQuery);
			findId.setQueryTimeout(5);
			findId.setDate(1, sqlDate0);
			findId.setDate(2, sqlDate1);
			findId.setInt(3, b.getG().getId());
			rs = findId.executeQuery();
			while (rs.next())
			{
				id = rs.getInt("bookingId");
			}
		} catch (SQLException e)
		{
			System.out.print(e.getErrorCode());
		} finally
		{
			try
			{
				findId.close();
				con.setAutoCommit(true);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return id;
	}

	// Get free rooms for calendar
	public ArrayList<Room> getRooms(Booking b, int id)
	{
		ArrayList<Room> rooms = new ArrayList<Room>();
		String findQuery = findQueryFreeRoom();
		PreparedStatement findId = null;
		ResultSet rs = null;
		try
		{
			con.setAutoCommit(false);
			java.sql.Date sqlDate0 = new java.sql.Date(b.getStartDate().getTime());
			java.sql.Date sqlDate1 = new java.sql.Date(b.getEndDate().getTime());
			findId = con.prepareStatement(findQuery);
			findId.setQueryTimeout(5);
			findId.setInt(1, id);
			findId.setInt(2, id);
			findId.setDate(3, sqlDate0);
			findId.setDate(4, sqlDate1);
			findId.setDate(5, sqlDate0);
			findId.setDate(6, sqlDate1);
			rs = findId.executeQuery();

			// Loop over the resultSet creating all the room & roomtype objects
			while (rs.next())
			{
				// Gets the roomTypeId
				String rtId = rs.getInt("roomTypeId") + "";
				// Creates the room with a RoomType on it
				Room r = new Room(rs.getInt("roomNo"),
						// Cast the class to RoomType because the
						// findFromDatabase is generic
						RoomType.class.cast(findFromDatbase(RoomType.class, "roomTypeID", rtId)));
				rooms.add(r);
			}

		} catch (SQLException e)
		{
			System.out.print(e.getErrorCode());
		} finally
		{
			try
			{
				findId.close();
				con.setAutoCommit(true);

			} catch (SQLException e)
			{
				e.printStackTrace();
			}

		}
		// Return the Arraylist<Room> of free rooms
		return rooms;
	}

	// Delete reserved bookings if it has been over 5 days
	public void deleteReservedBooking()
	{
		try
		{
			con.setAutoCommit(false);
			// Creates the preparedStatement with the Sql Query
			PreparedStatement deleteBooking = con.prepareStatement(deleteReservedBookingQuery());
			// Executes the Sql Query on the database
			deleteBooking.executeUpdate();
			con.setAutoCommit(true);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

	// Find all the bookings from the database
	public ArrayList<Booking> getAllBookings()
	{
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		// Calls the method that returns the Query to find all information about
		// bookings
		String findBookingData = getsAllTheBookingsAndRelations();
		PreparedStatement findBookings = null;
		ResultSet rs = null;
		try
		{
			con.setAutoCommit(false);
			// Preparedstatment with query getting all the data about a booking
			findBookings = con.prepareStatement(findBookingData);
			rs = findBookings.executeQuery();
			while (rs.next())
			{
				// Create all the objects associated with a booking
				GuestOrigin go = new GuestOrigin(rs.getInt("originID"), rs.getString("country"),
						rs.getString("postalCode"), rs.getString("city"));
				Guest g = new Guest(rs.getInt("guestId"), rs.getString("name"), rs.getString("lastName"),
						rs.getString("email"), rs.getString("phoneNo"), go);
				RoomType rt = new RoomType(rs.getInt("roomTypeID"), rs.getDouble("roomPrice"), rs.getString("roomType"),
						rs.getString("description"));
				Room r = new Room(rs.getInt("roomNo"), rt);
				ArrayList<Room> roomList = new ArrayList<Room>();
				roomList.add(r);
				Invoice i = new Invoice(rs.getInt("invoiceNo"), rs.getDouble("totalPrice"), rs.getDate("paymentDate"),
						rs.getBoolean("status"));
				Booking b = new Booking(rs.getInt("bookingId"), rs.getDate("startDate"), rs.getDate("endDate"),
						rs.getInt("discount"), rs.getBoolean("payedStatus"), i, g, roomList);
				// Adds the final booking object to the arraylist
				bookings.add(b);
			}
			con.setAutoCommit(true);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		// Return the booking arrayList
		return bookings;

	}

	// Changes the status of a payment to either true or false
	public void changePayedStatus(Booking b)
	{

		String updateQuery = updateStatusQuery();
		PreparedStatement updatePayedStatus = null;
		try
		{
			con.setAutoCommit(false);
			updatePayedStatus = con.prepareStatement(updateQuery);
			updatePayedStatus.setBoolean(1, true);
			updatePayedStatus.setInt(2, b.getId());
			updatePayedStatus.executeUpdate();
		} catch (SQLException e)
		{

			e.printStackTrace();
		} finally
		{
			try
			{

				updatePayedStatus.close();
				con.setAutoCommit(true);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}

		}
	}

	// Deletes the invoice, RoomBooking and booking from the database
	public void deleteBookingAndRelatives(Booking b)
	{
		// Deletes the invoice from the database
		System.out.println(b.getI().getInvoiceNo());
		deleteFromDatabase("Invoice", "invoiceNo", b.getI().getInvoiceNo() + "");

		// Deletes the RoomBooking from database
		deleteFromDatabase("RoomBooking", "bookingID", b.getId() + "");

		// Deletes the booking from database
		deleteFromDatabase("Booking", "bookingId", b.getId() + "");
	}

	// Returns the payment to the customer
	public double returnPayment(Booking b)
	{
		String updateQuery = returnPaymentQuery();
		PreparedStatement returnPayment = null;
		ResultSet rs = null;
		try
		{
			con.setAutoCommit(false);
			returnPayment = con.prepareStatement(updateQuery);
			returnPayment.setBoolean(1, true);
			returnPayment.setInt(2, b.getId());
			rs = returnPayment.executeQuery();
			while (rs.next())
			{
				Date currentDate = rs.getDate("currentDate");
				Date startDate = rs.getDate("startDate");
				int totalPrice = rs.getInt("totalPrice");
				int diffInDays = (int) ((startDate.getTime() - currentDate.getTime()) / (1000 * 60 * 60 * 24));

				if (diffInDays >= 7 && diffInDays < 14)
				{
					return totalPrice * 0.25;
				}
				if (diffInDays >= 14)
				{
					return totalPrice * 0.50;
				}
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				returnPayment.close();
				con.setAutoCommit(true);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return 0;
	}

	// Add Booking to the database
	private String addQueryBooking(Booking b)
	{
		// Insert into the Bookiing table in the database
		return "INSERT INTO Booking (startDate,endDate,discount,guestID, payedStatus) " + "VALUES (?,?,?,?,?)";
	}

	// Add RoomBooking to the database
	private String addQueryRoomBooking()
	{
		// Inserts into the roomBooking table in the database
		return "Insert into RoomBooking(bookingId, roomNo) values (?,?)";
	}

	// Finds a booking Id
	private String findQueryBookingId()
	{
		// Gets the booking id from a given start and end date + guestId
		return "Select bookingId from booking " + "where startDate = ? and endDate = ? and guestID = ?;";
	}

	// Finds free rooms and the roomType to the room
	private String findQueryFreeRoom()
	{
		// Checks if there is any free rooms relative to the RoomType and a
		// given date
		// If there is any rooms free in the given period, this method will
		// return the roomNr
		return "select t1.* from (Select r.roomNo, r.roomTypeId from Room as r INNER JOIN RoomType"
				+ " on r.roomTypeId = RoomType.roomTypeID where RoomType.roomTypeID = ?)  as t1"
				+ " LEFT JOIN (select rb.* from Booking as b, RoomBooking as rb"
				+ " where b.bookingId  in (select rb.bookingId where rb.roomNo  in ( Select roomNo from Room"
				+ " INNER JOIN RoomType on Room.roomTypeId = RoomType.roomTypeID where RoomType.roomTypeID = ?"
				+ " )) and startDate BETWEEN ? and ? or endDate BETWEEN ? and ?) as t2"
				+ " on t1.roomNo = t2.roomNo where t2.roomNo is null;";
	}

	// Deletes Invoice and the booking related to it
	private String deleteReservedBookingQuery()
	{
		// Checks if the invoice is payed 5 days after is created
		// if the invoice is not payed 5days after creation then Booking,
		// Invoice and RoomBooking
		// Relative to the invoice will be deleted
		return "Delete from RoomBooking where bookingID in (select i.InvoiceNo from Invoice as i "
				+ "where i.paymentDate  <=  (select convert(varchar(10), getDate(), 101)) and i.status = 'False');"

				+ "Delete from Booking where bookingId in (select i.InvoiceNo from Invoice as i "
				+ "where i.paymentDate  <=  (select convert(varchar(10), getDate(), 101)) and i.status = 'False');"

				+ "Delete from Invoice where paymentDate in (select convert(varchar(10), getDate(), 101)) and status = 'False';";
	}

	// Gets all the information needed to create a booking
	private String getsAllTheBookingsAndRelations()
	{
		// Joins the tables related to booking, so the data returned is one
		// tuple per booking
		return "Select *  from booking " + "inner join Guest " + "on booking.guestId = guest.guestId "
				+ "inner join GuestOrigin " + "on guest.originId = GuestOrigin.originId " + "inner join RoomBooking "
				+ "on booking.bookingId = RoomBooking.bookingID " + "inner join Room "
				+ "on RoomBooking.roomNo = Room.roomNo " + "inner join RoomType "
				+ "on Room.roomTypeId = RoomType.roomTypeId " + "inner join Invoice "
				+ "on booking.bookingId = Invoice.invoiceNo " +
				// After joining tables bookingPayed Status is checked,
				// because we only want the not payed bookings.
				// Expired bookings have no value for us and will clutter the
				// page
		"and booking.payedStatus = 0;";
	}

	// Updates the payedStatus of a booking
	private String updateStatusQuery()
	{
		return "UPDATE Booking SET payedStatus = ? " + "where bookingId = ?";
	}

	// Refunds the customer
	private String returnPaymentQuery()
	{
		return "select b.*,i.*,(select convert(date, getDate(), 101)) as currentDate from Booking as b inner join "
				+ "Invoice as i on b.bookingid = i.invoiceNo " + "where i.status = ?  and b.bookingId = ?;";
	}
}
