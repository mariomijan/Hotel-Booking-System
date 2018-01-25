package Threads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JPanel;

import gui.Bookings;

public class UpdateBookingThread implements Runnable
{
	private volatile boolean cancelled;
	private long timeWait = 1000;
	
	@Override
	public void run()
	{

		Bookings gui = new Bookings();
			while (!cancelled)
			{
				try
				{
					Thread.sleep(timeWait);
					gui.update();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}	
	}
	
	// Stops the thread
	public void setCancel(boolean bol)
	{
		cancelled = bol;
	}

	// Checks if the thread is canceled
	public boolean isCanceled()
	{
		return cancelled;
	}
}
