package ctrl;

import db.GuestDb;
import model.Guest;
import model.GuestOrigin;

public class GuestCtrl
{
	private GuestDb guestDb;

	/**
	 * Constructor for objects of class GuestCtrl
	 */
	public GuestCtrl()
	{
		guestDb = new GuestDb();

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
	 * @return
	 */
	public Guest createGuest(String name, String lastName, String email, String phoneNo, GuestOrigin go)
	{

		Guest guest = new Guest(name, lastName, email, phoneNo, go);
		return guest;
	}

	/**
	 * Method addGuest, add the guest to tabel
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

	public void addGuest(Guest g)
	{
		guestDb.addGuest(g);

	}

	/**
	 * Method findGuest, to find the guest
	 * 
	 * @param phoneNo,
	 *            input phone from the guest
	 * @return the found guest from phone number
	 */
	public int findGuestId(String phoneNo)
	{
		return guestDb.findGuestId(phoneNo);

	}

	/**
	 * Method findAllGuest, to find all the guests
	 * 
	 * @return the found guests
	 */

}
