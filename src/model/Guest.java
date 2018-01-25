package model;

/**
 * Class Guest, which holds the information about the guest
 * 
 * @author (Gruppe 2)
 * @version (05-12-2016)
 */

public class Guest
{

	private int id;
	private String name;
	private String lastname;
	private String email;
	private String phoneNo;
	private GuestOrigin guestOrigin;

	/**
	 * Constructor for objects of class Guest
	 * 
	 * @param id,
	 *            the id of the guest
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
	public Guest(String name, String lastname, String email, String phoneNo, GuestOrigin go)
	{
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.phoneNo = phoneNo;
		this.guestOrigin = go;
	}

	public Guest(int id, String name, String lastname, String email, String phoneNo, GuestOrigin go)
	{
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.phoneNo = phoneNo;
		this.guestOrigin = go;
	}

	/**
	 * @return the id of the guest
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id,
	 *            input to set the id of the guest
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the name of the guest
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name,
	 *            input to set the name of the guest
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the lastname of the guest
	 */
	public String getLastname()
	{
		return lastname;
	}

	/**
	 * @param lastname,
	 *            input to set the lastname of the guest
	 */
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	/**
	 * @return the email of the guest
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email,
	 *            input to set the email of the guest
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * @return the phone number of the guest
	 */
	public String getPhoneNo()
	{
		return phoneNo;
	}

	/**
	 * @param phoneNo,
	 *            input to set the phone number of the guest
	 */
	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the guest origin of the guest
	 */
	public GuestOrigin getGuestOrigin()
	{
		return guestOrigin;
	}

	/**
	 * @param guestOrigin,
	 *            input to set the country of origin to the guest
	 * 
	 */
	public void setGuestOrigin(GuestOrigin guestOrigin)
	{
		this.guestOrigin = guestOrigin;
	}

}
