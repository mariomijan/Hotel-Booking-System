/**
 * 
 */
package model;

/**
 * @author Kerim
 *
 */
public class Room
{
	private int roomNo;
	private RoomType rt;
	
	/**
	 * @param roomNo
	 * @param rt
	 */

	public Room(int roomNo, RoomType rt)
	{
		this.roomNo = roomNo;
		this.rt = rt;
	}

	public Room(RoomType rt)
	{
		this.rt = rt;
	}

	/**
	 * @return the roomNo
	 */
	public int getRoomNo()
	{
		return roomNo;
	}

	/**
	 * @param roomNo
	 *            the roomNo to set
	 */
	public void setRoomNo(int roomNo)
	{
		this.roomNo = roomNo;
	}


	/**
	 * @return the rt
	 */
	public RoomType getRt()
	{
		return rt;
	}

	/**
	 * @param rt
	 *            the rt to set
	 */
	public void setRt(RoomType rt)
	{
		this.rt = rt;
	}
	
	@Override
	public String toString()
	{
		return roomNo + "";
	}

}
