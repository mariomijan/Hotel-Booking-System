package Threads;

import ctrl.BookingCtrl;

public class DeleteBooking implements Runnable
{
	private volatile boolean cancelled;
	private long timeWait = 3600000;

	public void run()
	{
		BookingCtrl bCtrl = new BookingCtrl();
		while (!cancelled)
		{
			bCtrl.deleteNotPayedBookings();
			try
			{
				Thread.sleep(timeWait);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// Stops the thread
	public void cancel()
	{
		cancelled = true;
	}

	// Checks if the thread is stopped
	public boolean isCancelled()
	{
		return cancelled;
	}

}
