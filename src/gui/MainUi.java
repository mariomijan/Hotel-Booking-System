package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ctrl.BookingCtrl;
import ctrl.LoginCtrl;

public class MainUi extends JFrame {
	private static final long serialVersionUID = -2176293357931831077L;
	private JPanel contentPane;
	private LoginCtrl lCtrl;
	private BookingCtrl bCtrl; 
	private static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * Launch the application.d
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUi frame = new MainUi();
					URL url = getClass().getResource("/Images/Icon.png");
					ImageIcon img = new ImageIcon(url);
					frame.setIconImage(img.getImage());
					frame.getContentPane().setLayout(null);
					frame.setVisible(true);
					frame.createMainUI();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainUi() {
		lCtrl = new LoginCtrl();
		bCtrl = new BookingCtrl();
	}

	public void createMainUI() {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setTitle("Marokko holiday center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 1024, 768);

		setLocationRelativeTo(null);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel loginMenu = new LoginUi();
		loginMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Login", null, loginMenu, null);

		setContentPane(contentPane);

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tabbedPaneClickValue();
			};
		});

	}

	public void updateTabbedPane() {

		tabbedPane.removeAll();

		JPanel bookingMenu = new CreateGuestUi(null);
		if (lCtrl.hasAccessTo(bookingMenu)) {
			tabbedPane.addTab("Book Menu", null, bookingMenu, null);
		}

		JPanel guestOriginMenu = new GuestOriginUi();
		if (lCtrl.hasAccessTo(guestOriginMenu)) {
			tabbedPane.addTab("Guest Origin Menu", null, guestOriginMenu, null);
		}

		JPanel bookingsMenu = new Bookings();
		if (lCtrl.hasAccessTo(bookingsMenu)) {
			tabbedPane.addTab("Bookings", null, bookingsMenu, null);
		}

		JPanel loginMenu = new LoginUi();
		loginMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Login", null, loginMenu, null);

		tabbedPane.setVisible(true);
		tabbedPane.repaint();
		tabbedPane.revalidate();
	}

	public void tabbedPaneClickValue(){
		if(tabbedPane.getSelectedIndex() == 1){
			bCtrl.startUpdateBookingThread();
		}
		else {
			bCtrl.stopUpdateBookingThread();
		}
	}
}
