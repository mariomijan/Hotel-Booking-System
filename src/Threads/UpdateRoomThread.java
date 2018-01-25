
package Threads;

import gui.ChooseDate;

public class UpdateRoomThread implements Runnable
{
	private volatile boolean cancelled;
	private long timeWait = 1000;
	private ChooseDate updateGui;

	@Override
	public void run()
	{

		while (!cancelled)
		{
			try
			{
				Thread.sleep(timeWait);
				updateGui.findAllRooms();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	// Stops the thread
	public void cancel()
	{
		cancelled = true;
	}

	// Checks if the thread is canceled
	public boolean isCanceled()
	{
		return cancelled;
	}

	// Sets the GUI object
	public void setGui(ChooseDate gui)
	{
		this.updateGui = gui;

	}
}
