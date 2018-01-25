package model;

/**
 * 
 * @author Kerim
 *
 */

public class RoomType
{
	private int id;
	private double roomPrice;
	private String roomType;
	private String description;

	/**
	 * @param id
	 * @param roomPrice
	 * @param roomType
	 * @param description
	 */

	public RoomType(int id, double roomPrice, String roomType, String description)
	{
		this.id = id;
		this.roomPrice = roomPrice;
		this.roomType = roomType;
		this.description = description;
	}

	/**
	 * @param id
	 * @param roomPrice
	 * @param roomType
	 * @param description
	 */

	public RoomType(double roomPrice, String roomType, String description)
	{
		this.roomPrice = roomPrice;
		this.roomType = roomType;
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the roomPrice
	 */
	public double getRoomPrice()
	{
		return roomPrice;
	}

	/**
	 * @param roomPrice
	 *            the roomPrice to set
	 */
	public void setRoomPrice(double roomPrice)
	{
		this.roomPrice = roomPrice;
	}

	/**
	 * @return the roomType
	 */
	public String getRoomType()
	{
		return roomType;
	}

	/**
	 * @param roomType
	 *            the roomType to set
	 */
	public void setRoomType(String roomType)
	{
		this.roomType = roomType;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	@Override
	public String toString()
	{
		return roomType;
	}
}
