package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

import ctrl.BookingCtrl;
import model.Booking;
import model.Room;
import model.RoomType;
import java.awt.event.KeyAdapter;

public class ChooseDate extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Booking b;
	private BookingCtrl bCtrl;
	private Utilities util;
	private JComboBox<Object> rtComboBox;
	private JComboBox<Object> roomComboBox;
	private JTextField txtDiscount;
	private JTable table;
	private BookingRoomTableModel model;

	public ChooseDate(Booking b)
	{
		this.b = b;
		bCtrl = new BookingCtrl();
		util = new Utilities();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{ 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[]
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[]
		{ 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[]
		{ 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		model = new BookingRoomTableModel();
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 5;
		add(scrollPane, gbc_scrollPane);
		createButtonColumn(3);

		JLabel lblNewLabel = new JLabel("Choose Start Date");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblChooseEndDate = new JLabel("Choose End Date");
		GridBagConstraints gbc_lblChooseEndDate = new GridBagConstraints();
		gbc_lblChooseEndDate.insets = new Insets(0, 0, 5, 0);
		gbc_lblChooseEndDate.gridx = 2;
		gbc_lblChooseEndDate.gridy = 0;
		add(lblChooseEndDate, gbc_lblChooseEndDate);

		JCalendar calendar_1 = new JCalendar();
		GridBagConstraints gbc_calendar_1 = new GridBagConstraints();
		gbc_calendar_1.insets = new Insets(0, 0, 5, 5);
		gbc_calendar_1.fill = GridBagConstraints.BOTH;
		gbc_calendar_1.gridx = 0;
		gbc_calendar_1.gridy = 1;
		calendar_1.setMinSelectableDate(new Date());
		add(calendar_1, gbc_calendar_1);

		JCalendar calendar_2 = new JCalendar();
		GridBagConstraints gbc_calendar_2 = new GridBagConstraints();
		gbc_calendar_2.insets = new Insets(0, 0, 5, 0);
		gbc_calendar_2.fill = GridBagConstraints.BOTH;
		gbc_calendar_2.gridx = 2;
		gbc_calendar_2.gridy = 1;
		calendar_2.setMinSelectableDate(new Date());
		add(calendar_2, gbc_calendar_2);

		// Calendar 1 listener
		calendar_1.addPropertyChangeListener("calendar", new PropertyChangeListener()
		{
			@Override
			public void propertyChange(PropertyChangeEvent e)
			{

				b.setStartDate(calendar_1.getDate());
				if (b.getEndDate() != null)
				{
					b.deleteAllRooms();
					findAllRooms();
					model.removeAllRooms();

				}

			}

		});

		// TODO skal vi flytte Stream array ting til ctrl????
		calendar_2.addPropertyChangeListener("calendar", new PropertyChangeListener()
		{
			@Override
			public void propertyChange(PropertyChangeEvent e)
			{

				b.setEndDate(calendar_2.getDate());

				if (b.getStartDate() != null)
				{
					b.deleteAllRooms();
					findAllRooms();
					model.removeAllRooms();
				}

			}
		});

		// TODO changed to .get(0)
		JLabel lblNewLabel_1 = new JLabel("Choose room type:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblDiscount = new JLabel("Discount");
		GridBagConstraints gbc_lblDiscount = new GridBagConstraints();
		gbc_lblDiscount.insets = new Insets(0, 0, 5, 0);
		gbc_lblDiscount.gridx = 2;
		gbc_lblDiscount.gridy = 2;
		add(lblDiscount, gbc_lblDiscount);

		rtComboBox = new JComboBox<Object>(getRoomTypeStrings());
		GridBagConstraints gbc_rtComboBox = new GridBagConstraints();
		gbc_rtComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_rtComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_rtComboBox.gridx = 0;
		gbc_rtComboBox.gridy = 3;
		add(rtComboBox, gbc_rtComboBox);

		txtDiscount = new JFormattedTextField(NumberFormat.getInstance());
		txtDiscount.setText("0");
		GridBagConstraints gbc_txtDiscount = new GridBagConstraints();
		gbc_txtDiscount.insets = new Insets(0, 0, 5, 0);
		gbc_txtDiscount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiscount.gridx = 2;
		gbc_txtDiscount.gridy = 3;
		add(txtDiscount, gbc_txtDiscount);
		txtDiscount.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel();
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblChooseARoom = new JLabel("Choose a room:");
		GridBagConstraints gbc_lblChooseARoom = new GridBagConstraints();
		gbc_lblChooseARoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblChooseARoom.gridx = 0;
		gbc_lblChooseARoom.gridy = 5;
		add(lblChooseARoom, gbc_lblChooseARoom);

		roomComboBox = new JComboBox<Object>(b.getR().toArray());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 7;
		add(roomComboBox, gbc_comboBox);

		bCtrl.setGui(this);

		JButton btnAddRoom = new JButton("Add Room");
		btnAddRoom.addActionListener(e ->
		{
			Room r = RoomComboBoxValue();
			b.addToR(r);
			model.updateElements(r);
			((DefaultComboBoxModel<Object>) roomComboBox.getModel()).removeAllElements();
		});

		GridBagConstraints gbc_btnAddRoom = new GridBagConstraints();
		gbc_btnAddRoom.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddRoom.gridx = 2;
		gbc_btnAddRoom.gridy = 7;
		add(btnAddRoom, gbc_btnAddRoom);

		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 9;
		add(btnBack, gbc_btnBack);

		// Button Action event
		btnBack.addActionListener(e ->
		{
			util.refreshTab(this, new CreateGuestUi(b));
			bCtrl.stopUpdateThread();
		});

		JButton btnBookRoom = new JButton("Book Room");
		GridBagConstraints gbc_btnBookRoom = new GridBagConstraints();
		gbc_btnBookRoom.gridx = 2;
		gbc_btnBookRoom.gridy = 9;
		add(btnBookRoom, gbc_btnBookRoom);

		btnBookRoom.addActionListener(e ->
		{
			if (b.getEndDate() != null && b.getStartDate() != null)
				if (calendar_2.getDate().after(calendar_1.getDate()))
				{
					if (txtDiscount.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(this, "Please fill out the discount and use ONLY numbers !");

					} else
					{

						if (Integer.parseInt(txtDiscount.getText()) > 100)
						{
							JOptionPane.showMessageDialog(this, "The discount must be within 100% !");

						} else
						{
							bookRoom((Date) calendar_1.getDate(), (Date) calendar_2.getDate(),
									Integer.parseInt(txtDiscount.getText()));
						}
					}

				} else
				{
					JOptionPane.showMessageDialog(this, "Please choose an end date, after the start date !", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}

			else
			{
				JOptionPane.showMessageDialog(calendar_2, "Please choose 2 dates");

			}

			bCtrl.stopUpdateThread();
		});

		bCtrl.startThread();
	}

	public void findAllRooms()
	{
		boolean updateList = false;

		if (b.getStartDate() != null && b.getEndDate() != null)
		{
			DefaultComboBoxModel<Object> dcm = new DefaultComboBoxModel<>();
			dcm.removeAllElements();
			Room[] roomArray = bCtrl.findAllFreeRooms(b, RoomTypeComboBoxValue().getId()).stream().toArray(Room[]::new);
			int count = 0;
			for (Room roomNumbers : roomArray)
			{
				if ((roomComboBox.getModel().getSize() + roomComboBox.getModel().getSize()
						+ b.getR().size()) == roomArray.length)
				{

					if (checkBookingRooms(roomNumbers))
					{
						dcm.addElement(roomNumbers);
						updateList = true;
					}

				}

				if ((roomComboBox.getModel().getSize() + b.getR().size()) != roomArray.length)
				{
					if (checkBookingRooms(roomNumbers))
					{
						dcm.addElement(roomNumbers);
						updateList = true;
					}
				}
				count++;
			}
			if (updateList)
			{
				roomComboBox.setModel(dcm);
			}
		}

	}

	public boolean checkBookingRooms(Room r)
	{
		boolean returnValue = true;
		for (int i = 0; i < b.getR().size(); i++)
		{
			if (b.getR().get(i).getRoomNo() == r.getRoomNo())
			{
				returnValue = false;
			}

		}
		return returnValue;

	}

	public void bookRoom(Date d1, Date d2, int discount)
	{
		b.setDiscount(discount);
		b.setStartDate(d1);
		b.setEndDate(d2);
		b = bCtrl.addBooking(b);
		util.refreshTab(this, new BookingFinish(b));
	}

	// Returns the RoomType of the chosen dropdown item
	private RoomType RoomTypeComboBoxValue()
	{
		RoomType o1 = (RoomType) rtComboBox.getSelectedItem();
		return o1;
	}

	// Returns the Room of the chosen dropdown item
	private Room RoomComboBoxValue()
	{
		Room r = (Room) roomComboBox.getSelectedItem();
		return r;
	}

	// Place this method in the Controller??? TODO
	// TODO Rename
	// Gets the list of roomTypes and returns it as a String[]
	private RoomType[] getRoomTypeStrings()
	{
		return bCtrl.getAllRoomTypes().stream().toArray(RoomType[]::new);
	}

	private Room[] getRoomStrings()
	{
		return bCtrl.getAllRoomTypes().stream().toArray(Room[]::new);

	}

	private void createButtonColumn(int position)
	{
		new ButtonColumn(table, new AbstractAction()
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e)
			{

				b.deleteRoom(table.getSelectedRow());
				model.updateRooms(table.getSelectedRow());
				// System.out.print("test");

			}
		}, position);
	}
}
