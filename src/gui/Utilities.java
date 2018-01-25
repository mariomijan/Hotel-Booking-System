/**
 * 
 */
package gui;

import javax.swing.JPanel;

/**
 * @author Kerim
 *
 */
public class Utilities 
{
	// Refreshes the tab
	public void refreshTab(JPanel currentJPanel, JPanel nextJPanel)
	{
		currentJPanel.removeAll();
		currentJPanel.invalidate();
		currentJPanel.add(nextJPanel);
		currentJPanel.revalidate();
		currentJPanel.repaint();
	}

}
