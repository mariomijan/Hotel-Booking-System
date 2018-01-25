package db;

import model.GuestOrigin;

public class GuestOriginDb extends FrameWork
{
	// Adds the guest origin to the database
	public void addGuestOrigin(GuestOrigin go)
	{
		addToDatabase("GuestOrigin", go);
	}

	// Adds the object to the database in a table 
	public <T> void addToDatabase(String tableName, T objectToBuild)
	{
		super.addToDatabase(tableName, objectToBuild);
	}

	// Finds the object from the database
	public <T> T findFromDatbase(T clazz, String whatColumn, String columnValue)
	{
		return super.findFromDatbase(clazz, whatColumn, columnValue);
	}

}
