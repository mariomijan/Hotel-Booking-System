
package ctrl;

import java.util.ArrayList;

import db.RoomTypeDb;
import model.RoomType;

public class RoomTypeCtrl
{
	private RoomTypeDb rtDB;

	// RoomTypeCtrl Constructor
	public RoomTypeCtrl()
	{
		rtDB = new RoomTypeDb();
	}

	// Updates the RoomType
	public void updateRoomType(double roomPrice, String roomType, String description)
	{
		rtDB.updateRoomType(roomPrice, roomType, description);
	}

	// Removes the RoomType
	public void removeRoomType(String roomTypeID)
	{
		rtDB.removeRoomType(roomTypeID);
	}

	// Returns all the room types
	public ArrayList<RoomType> findAllRoomTypes()
	{
		return rtDB.findAllRoomTypes();
	}
}
