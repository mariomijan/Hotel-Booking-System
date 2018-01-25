package db;

import model.Room;
import model.RoomType;

public class RoomDb
{
	// Creates the room and returns it
	public Room createRoom(RoomType rt)
	{
		Room room = new Room(rt);
		return room;
	}
}
