package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 * @Version 2016.02.12 This class is used to create the connection to the
 *          database It is implemented as a singleton. The constructor is
 *          private to ensure that only one connection exists
 */

public class DbConnection
{
	// Constants used to get access to the database
	private static final String driver = "jdbc:sqlserver://kraka.ucn.dk";
	private static final String databaseName = ";databaseName=dmab0915_2Sem_9";

	private static String userName = "; user=dmab0915_2sem_9";
	private static String password = ";password=IsAllowed";

	private DatabaseMetaData dma;
	private static Connection con;

	// an instance of the class is generated
	private static DbConnection instance = null;

	// the constructor is private to ensure that only one object of this class
	// is created

	private DbConnection()
	{
		String url = driver + databaseName + userName + password;

		try
		{
			// load of driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver class loaded ok ");

		} catch (Exception e)
		{
			System.out.println("Cannot find the driver");
			System.out.println(e.getMessage());
		}
		try
		{
			// connection to the database
			con = DriverManager.getConnection(url);
			con.setAutoCommit(true);
			dma = con.getMetaData(); // get meta data
			// System.out.println("Connection to " + dma.getURL());
			System.out.println("Driver " + dma.getDriverName());
			System.out.println("Database product name " + dma.getDatabaseProductName());
		} // end try
		catch (Exception e)
		{
			System.out.println("Problems with the connection to the database:");
			System.out.println(e.getMessage());
			System.out.println(url);
		} // end catch
	}// end constructor*/

	// closeDb: closes the connection to the database
	public static void closeConnection()
	{
		try
		{
			con.close();
			instance = null;
			System.out.println("The connection is closed");
		} catch (Exception e)
		{
			System.out.println("Error trying to close the database " + e.getMessage());
		}
	}// end closeDB

	// getDBcon: returns the singleton instance of the DB connection
	public Connection getDBcon()
	{
		return con;
	}

	// this method is used to get the instance of the connection
	public static DbConnection getInstance()
	{
		if (instance == null)
		{
			instance = new DbConnection();
		}
		return instance;
	}

}// end DbConnection