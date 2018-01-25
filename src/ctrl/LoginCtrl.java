package ctrl;

import java.util.Objects;

import javax.swing.JPanel;

import Threads.DeleteBooking;
import db.LoginDb;
import gui.LoginUi;
import gui.Utilities;
import model.Login;

public class LoginCtrl
{

	private static Login currentUser;
	private Utilities util = new Utilities();
	private DeleteBooking deleteThread = new DeleteBooking();
	private String[] adminAccess =
	{ "BookingFinish", "ChooseDate", "ChooseRoom", "CreateGuestUi", "LoginUi", "MainUi", "Bookings" };
	private String[] userAccess =
	{ "LoginUi", "MainUi", };
	private String[] expedientAccess =
	{ "BookingFinish", "ChooseDate", "ChooseRoom", "CreateGuestOriginUi", "CreateGuestUi", "GuestOriginUi", "LoginUi",
			"MainUi" };

	// Method that checks if the userName and password are correct
	public String login(String txtUserName, String txtPassword)
	{
		String userName = txtUserName;
		String password = txtPassword;
		LoginDb lDb = new LoginDb();
		Login login = lDb.findLogin(userName);

		// Checks the login txtValues with the ones from the database
		if (login != null)
		{
			if (Objects.equals(login.getPassword(), password))
			{
				currentUser = login;
				currentUser.setStatus(true);
				if (Objects.equals(login.getRole().getLoginRole(), "Admin"))
				{
					Thread t = new Thread(deleteThread);
					t.setName("DeleteBookingLoop");
					t.start();
				}
				return "You are now logged in as " + login.getUserName();
			} else
			{
				return "Username or Password was incorrect !";
			}
		} else
		{
			if (userName.length() == 0 && password.length() == 0)
			{
				return "Please input a Username and a Password !";
			} else
			{
				return "Username or Password was incorrect !";
			}

		}
	}

	// Checks what the current login has access to view
	public boolean hasAccessTo(JPanel jp)
	{
		String panelName = jp.getClass().getSimpleName();
		if (currentUser != null)
		{
			switch (currentUser.getRole().getLoginRole())
			{
			case "Admin":
				if (checkAllowed(adminAccess, panelName) && currentUser.getStatus())
				{
					return true;
				} else
				{
					util.refreshTab(jp, new LoginUi());
					return false;
				}
			case "User":
			{
				if (checkAllowed(userAccess, panelName) && currentUser.getStatus())
				{
					return true;
				} else
				{
					util.refreshTab(jp, new LoginUi());
					return false;
				}
			}
			case "Expedient":
				if (checkAllowed(expedientAccess, panelName) && currentUser.getStatus())
				{
					return true;
				} else
				{
					util.refreshTab(jp, new LoginUi());
					return false;
				}
			}
		} else
		{
			util.refreshTab(jp, new LoginUi());
			return false;
		}
		return false;
	}

	// Returns true if the list contains the panelName
	public boolean checkAllowed(String[] accessList, String panelName)
	{
		for (int i = 0; i < accessList.length; i++)
		{
			if (accessList[i].contains(panelName))
			{
				return true;
			}
		}
		return false;
	}

	// Stops the delete thread
	public void StopThread()
	{
		deleteThread.cancel();
	}

	// Gets the currentUser
	public Login getCurrentLogin()
	{
		return currentUser;
	}

}
