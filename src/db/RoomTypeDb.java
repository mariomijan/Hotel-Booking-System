	/**
* 
*/
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.RoomType;

/**
 * @author Kerim
 *
 */

public class RoomTypeDb
{
	private Connection con;

	/**
	 * Gets the singleton db connection
	 */
	public RoomTypeDb()
	{
		con = DbConnection.getInstance().getDBcon();
	}

	/**
	 * @param status
	 *            of room availability
	 * @param roomPrice
	 * @param roomType
	 * @param description
	 */

	/**
	 * 
	 * @param retriveAssociation
	 * @return
	 */
	public ArrayList<RoomType> findAllRoomTypes()
	{
		return miscWhere("");
	}

	/**
	 * 
	 * @param roomTypeID
	 */
	public void removeRoomType(String roomTypeID)
	{
		try
		{
			String deleteQ = deleteQuery(roomTypeID);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeQuery(deleteQ);
		} catch (SQLException e)
		{
			System.out.println(e.getErrorCode());
		}
	}

	public void updateRoomType(double roomPrice, String roomType, String description)
	{
		try
		{
			String updateQ = updateQuery(/* status, */ roomPrice, roomType, description);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeQuery(updateQ);
		} catch (SQLException e)
		{
			System.out.println(e.getErrorCode());
		}
	}

	/**
	 * 
	 * @param wClause
	 * @param retrieveAssociation
	 * @return
	 */
	private ArrayList<RoomType> miscWhere(String wClause)
	{
		ResultSet results;
		ArrayList<RoomType> list = new ArrayList<RoomType>();
		String query = buildQuery(wClause);
		try
		{
	
			PreparedStatement pre = con.prepareStatement(query);

			pre.setQueryTimeout(5);

			results = pre.executeQuery();

			while (results.next())
			{
				RoomType rtObj;
				rtObj = buildRoomType(results);
				list.add(rtObj);
			}

			pre.close();
			return list;

		} catch (Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return list;
	}



	/**
	 * 
	 * @param results
	 * @return
	 */
	private RoomType buildRoomType(ResultSet results)
	{
		RoomType rtObj = null;
		try
		{
			rtObj = new RoomType(results.getInt(1), results.getDouble(2), results.getString(3), results.getString(4));
		} catch (Exception e)
		{
			System.out.println("Error in building the RoomType object");
		}
		return rtObj;
	}

	/**
	 * 
	 * @param wClause
	 * @return
	 */
	private String buildQuery(String wClause)
	{
		String query = "SELECT * FROM RoomType";

		if (wClause.length() > 0)
			query = query + " WHERE " + wClause;
		return query;
	}

	/**
	 * 
	 * @param roomTypeID
	 * @return
	 */
	public String deleteQuery(String roomTypeID)
	{
		return "DELETE FROM RoomType WHERE roomTypeID = '" + roomTypeID + "';";
	}

	/**
	 * 
	 * @param rt
	 * @return
	 */

	private String updateQuery(double roomPrice, String roomType, String description)
	{
		return "UPDATE RoomType SET roomPrice, roomType, roomDescription = "  + roomPrice + roomType
				+ description
				+ "WHERE roomPrice, roomType, roomDescription = " 
				+ roomPrice + roomType + description + ";";
	}

	/**
	 * 
	 * @param RoomTypeID
	 * @return
	 */
	public String findQuery(String RoomTypeID)
	{
		return "SELECT * FROM RoomType WHERE roomType = '" + RoomTypeID + " ';";
	
	}

}
