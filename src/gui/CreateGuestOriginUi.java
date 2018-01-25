package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import ctrl.LoginCtrl;

public class CreateGuestOriginUi extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3870778973021817405L;

	private Utilities util;
	private LoginCtrl lCtrl;

	/**
	 * Create the panel.
	 */
	public CreateGuestOriginUi()
	{
		lCtrl = new LoginCtrl();
		if (!lCtrl.hasAccessTo(this))
		{
			return;
		}

		util = new Utilities();

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(e -> {

		});
		panel_1.add(btnSave);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(e -> {
			util.refreshTab(this, new CreateGuestOriginUi());
		});
		panel_1.add(btnBack);

	}

}
