package ctrl;

import db.GuestOriginDb;
import model.GuestOrigin;

public class GuestOriginCtrl
{
	private GuestOriginDb goDb;

	public GuestOriginCtrl()
	{
		goDb = new GuestOriginDb();
	}

	// Create a GuestOrigin Object and returns it
	public GuestOrigin createGuestOrigin(String Country, String PostalCode, String City)
	{
		GuestOrigin go = new GuestOrigin(Country, PostalCode, City);
		return go;
	}

	// Calls the method to add the guestOrigin to the database
	public void addGuestOrigin(GuestOrigin go)
	{
		goDb.addGuestOrigin(go);
	}

	// Finds the guestOrigin based on the city
	public GuestOrigin findGuestOrigin(GuestOrigin go)
	{
		return GuestOrigin.class.cast(goDb.findFromDatbase(GuestOrigin.class, "city", go.getCity()));
	}

}
