package ctrl;

import model.Room;
import model.RoomType;

public class RoomCtrl
{
	
	// Creates the room and returns it
	public Room createRoom(RoomType rt)
	{
		Room r = new Room( rt);
		return r;
	}
	
	
	
}
