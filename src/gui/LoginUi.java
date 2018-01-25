package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ctrl.LoginCtrl;

public class LoginUi extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -766627512470917707L;
	private JTextField txtPassword;
	private JTextField txtUserName;
	private LoginCtrl lCtrl;

	/**
	 * Create the panel.
	 */
	public LoginUi()
	{
		lCtrl = new LoginCtrl();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{ 0, 0, 0, 0, 0, 0, 0, 61, 115, 48, 0, 0 };
		gridBagLayout.rowHeights = new int[]
		{ 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[]
		{ 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[]
		{ 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(200, 330, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 6;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]
		{ 62, 114, 0 };
		gbl_panel.rowHeights = new int[]
		{ 20, 20, 26, 0 };
		gbl_panel.columnWeights = new double[]
		{ 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.WEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 0;
		panel.add(lblUsername, gbc_lblUsername);

		txtUserName = new JTextField();
		GridBagConstraints gbc_txtUserName = new GridBagConstraints();
		gbc_txtUserName.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtUserName.insets = new Insets(0, 0, 5, 0);
		gbc_txtUserName.gridx = 1;
		gbc_txtUserName.gridy = 0;
		panel.add(txtUserName, gbc_txtUserName);
		txtUserName.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		panel.add(lblPassword, gbc_lblPassword);

		txtPassword = new JPasswordField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassword.gridx = 1;
		gbc_txtPassword.gridy = 1;
		panel.add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);

		JButton btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.anchor = GridBagConstraints.NORTH;
		gbc_btnLogin.gridwidth = 2;
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 2;
		panel.add(btnLogin, gbc_btnLogin);
		// Btn Login Event
		btnLogin.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, lCtrl.login(txtUserName.getText(), txtPassword.getText()), "Login",
					JOptionPane.INFORMATION_MESSAGE);

			MainUi mui = new MainUi();
			mui.updateTabbedPane();

		});
	}
}
