package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Guest;
import model.GuestOrigin;

public class GuestDb
{
	private Connection con;

	/**
	 * Constructor for objects of class GuestDb
	 */
	public GuestDb()
	{
		con = DbConnection.getInstance().getDBcon();

	}

	/**
	 * Method createGuest, create the guest
	 * 
	 * @param name,
	 *            the name of the guest
	 * @param lastname,
	 *            the lastname of the guest
	 * @param email,
	 *            the email of the guest
	 * @param phoneNo,
	 *            the phone number of the guest
	 * @param go,
	 *            the object of guest origin
	 */
	public Guest createGuest(String name, String lastName, String email, String phoneNo, GuestOrigin go)
	{
		Guest g = new Guest(name, lastName, email, phoneNo, go);
		return g;
	}

	/**
	 * Method addGuest, add the guest to table
	 * 
	 * @param name,
	 *            the name of the guest
	 * @param lastname,
	 *            the lastName of the guest
	 * @param email,
	 *            the email of the guest
	 * @param phoneNo,
	 *            the phone number of the guest
	 * @param go,
	 *            the object of guest origin
	 */
	public void addGuest(Guest g)
	{

		try
		{
			String addQ = addQuery(g);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(addQ);
		} catch (SQLException e)
		{
			System.out.println(e.getErrorCode());
		}
	}

	// Finds guest by ID
	public int findGuestId(String phoneNo)
	{
		String findQuery = findQueryId(phoneNo);
		PreparedStatement findId = null;
		ResultSet rs = null;
		int id = 0;
		try
		{
			
			findId = con.prepareStatement(findQuery);
			findId.setQueryTimeout(5);
			findId.setString(1, phoneNo);
			rs = findId.executeQuery();
			while (rs.next())
			{
				id = rs.getInt("guestId");
			}

		} catch (SQLException e)
		{
			System.out.print(e.getErrorCode());
		} finally
		{
			try
			{
				findId.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return id;
	}

	// Query to add the guest to the db
	public String addQuery(Guest g)
	{
		return "INSERT INTO Guest (name,lastName,email,phoneNo,originId) " + "VALUES ('" + g.getName() + "','"
				+ g.getLastname() + "','" + g.getEmail() + "','" + g.getPhoneNo() + "','" + g.getGuestOrigin().getId()
				+ "')";
	}

	// Query to find guestID
	public String findQueryId(String phoneNo)
	{
		return "SELECT guestId FROM Guest where PhoneNo = ? ;";
	}
}
