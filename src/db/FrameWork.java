package db;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Booking;

public class FrameWork
{
	Connection con;

	public FrameWork()
	{
		con = DbConnection.getInstance().getDBcon();
	}

	// This method inserts information into the database
	// The function works by you applying a table name and a object to update.
	// Table name could be found from object name if that convention is used
	public <T> void addToDatabase(String tableName, T objectToBuild)
	{

		try
		{
			String addQuery = addQuery(tableName, objectToBuild);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(addQuery);
			stmt.close();
		} catch (Exception e)
		{
			System.out.println("Query exception: " + e);
		}

	}

	// columnValue needs to come from the GUI and get insertet into the method
	// parameter.
	// the function works by parameter Table Name and what column, the
	// columnValue.
	public void deleteFromDatabase(String tableName, String whatColumn, String columnValue)
	{
		try
		{
			String deleteQuery = deleteQuery(tableName, whatColumn, columnValue);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(deleteQuery);
			stmt.close();
		} catch (Exception e)
		{
			System.out.println("Query exception: " + e);
		}
	}

	// Finds the Object from the database
	public <T> T findFromDatbase(T clazz, String whatColumn, String columnValue)
	{
		ResultSet results;
		T obj = null;
		try
		{
			String findQuery = findQuery(clazz, whatColumn, columnValue);
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(findQuery);
			obj = buildObject(results, clazz);
			stmt.close();
		} catch (Exception e)
		{
			System.out.println("Query exception: " + e);
		}
		return (T) obj;
	}

	private String deleteQuery(String tableName, String whatColumn, String columnValue)
	{
		return "DELETE FROM " + tableName + " WHERE " + whatColumn + " = " + columnValue + ";";
	}

	private String addQuery(String tableName, Object obj)
	{
		return "INSERT INTO " + tableName + "(" + getStringClassFileds(obj) + ") " + "VALUES ('" + getObjectValues(obj)
				+ ")";
	}

	private <T> String findQuery(T clazz, String whatColumn, String columnValue)
	{
		return "select * from " + ((Class) clazz).getSimpleName() + " where " + whatColumn + "= '" + columnValue + "';";
	}

	private <T> String getStringClassFileds(T obj)
	{
		Field[] myFields = getAllClassFields(obj);
		String myString = "";
		for (int i = 1; i < myFields.length; i++)
		{
			myString += "\"" + myFields[i].getName() + "\",";
		}
		myString = myString.substring(0, myString.length() - 1);
		return myString;
	}

	private String getObjectValues(Object obj)
	{
		String myString = "";
		Field[] myFields = getAllClassFields(obj);
		for (int i = 1; i < myFields.length; i++)
		{
			Field field = null;
			try
			{
				field = obj.getClass().getDeclaredField(myFields[i].getName());
			} catch (NoSuchFieldException | SecurityException e)
			{
				e.printStackTrace();
			}
			field.setAccessible(true);
			try
			{
				myString += field.get(obj) + "','";

			} catch (IllegalArgumentException | IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		myString = myString.substring(0, myString.length() - 2);
		return myString;
	}

	private Field[] getAllClassFields(Object obj)
	{
		return obj.getClass().getDeclaredFields();
	}

	private <T> T buildObject(ResultSet results, T clazz)
	{
		T obj = null;
		try
		{
			Class<?> cls = Class.forName("model." + ((Class) clazz).getSimpleName());

			Constructor[] constructors = cls.getDeclaredConstructors();

			for (Constructor ctor : constructors)
			{

				if (results.next())
				{
					Object[] testList = new Object[ctor.getParameterCount()];
					Class<?>[] pType = ctor.getParameterTypes();
					for (int x = 0; x < ctor.getParameterCount(); x++)
					{
						if (pType[x].getName() == "int")
						{
							testList[x] = results.getInt(x + 1);
						} else if (pType[x].getName() == "double")
						{
							testList[x] = results.getDouble(x + 1);
						} else
						{
							testList[x] = results.getString(x + 1);
						}
						// Need all datatype here as a switch
					}
					obj = (T) ctor.newInstance(testList);
					return obj;
				}
			}
		} catch (

		Exception e)
		{
			System.out.print(e.getMessage());
		}
		return obj;
	}

	// Update Below

	public void updateBooking(Booking b1, Booking b2)
	{
		checkObjectValues(b1, b2);
	}

	// SimpelName A[A[0]] ?
	// Values A[A[x->]]
	/*
	 * Loop(A[A.length){ UPDATE A[A.[0]] SET A[A[1->x]] }
	 * 
	 * 
	 * 
	 * Check both objects here with hashcode // Making this function faster /*
	 * if (obj1.hashCode() != obj2.hashCode()) {
	 */

	private List<ArrayList<String>> updateData = new ArrayList<ArrayList<String>>();

	private ArrayList<Map<String, ArrayList<String>>> newData = new ArrayList<Map<String, ArrayList<String>>>();
	private int arrayCount = 0;
	private int arrayPos = 0;

	public void checkObjectValues(Object obj1, Object obj2)
	{
		Method[] m1 = obj1.getClass().getDeclaredMethods();
		Method[] m2 = obj2.getClass().getDeclaredMethods();

		String dbTableName = obj1.getClass().getSimpleName();

		if (giveMeDataType(dbTableName))
		{
			arrayCount = returnArrayListSize(obj1);
		}

		if (updateData.size() <= arrayPos)
		{
			updateData.add(new ArrayList<String>());
		}

		updateData.get(arrayPos).add(dbTableName);

		for (int i = 0; i < m1.length; i++)
		{
			if (m1[i].getName().startsWith("get") || m1[i].getName().startsWith("is"))
			{
				// findValueParrent(dbTableName)
				callTheGet(m1[i], m2[i], obj1, obj2);
			}
		}

	}

	// Some invocation magic below
	private void callTheGet(Method m1, Method m2, Object obj1, Object obj2)
	{
		Object value2 = null;
		Object value1 = null;
		try
		{
			if (arrayCount == 0)
			{
				value1 = m1.invoke(obj1, null);
				value2 = m2.invoke(obj2, null);
			} else
			{
				for (int x = 0; x < arrayCount;)
				{
					value1 = m1.invoke(obj1, x);
					value2 = m2.invoke(obj2, x);
					arrayCount--;
					arrayPos++;
					checkObjectValues(value1, value2);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
		String checkObjectName = value1.toString();
		if (checkObjectName.contains("model"))
		{
			arrayPos++;
			checkObjectValues(value1, value2);
		}
		if (value1.equals(value2))
		{
			System.out.println("This Works");

			updateData.get(findValueParrent(obj1.getClass().getSimpleName())).add(value2.toString());
		}

	}

	// DataTypes to look for might need more values
	private boolean giveMeDataType(String str)
	{
		switch (str)
		{
		case "ArrayList":
			return true;
		case "List":
			return true;
		}
		return false;
	}

	// Returns the size of an arrayList
	private int returnArrayListSize(Object obj1)
	{
		Method[] m3 = obj1.getClass().getMethods();
		for (int x = 0; x < m3.length; x++)
		{
			if (m3[x].getName().startsWith("size"))
			{
				try
				{
					// Length of the arayList use this in a for loop
					return (int) m3[x].invoke(obj1, null);

				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
				{
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	// TODO needs hash map here
	// For faster Searching
	private int findValueParrent(String someObjName)
	{
		// Find some object name?
		for (int i = 0; i < updateData.size(); i++)
		{
			if (updateData.get(i).get(0).equals(someObjName))
			{
				return i;
			}
		}
		return 0;
	}
}