package gui;

import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import ctrl.BookingCtrl;
import model.Booking;

public class BookingTableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 4258350672422219967L;
	private BookingCtrl bCtrl = new BookingCtrl();
	private static List<Booking> bookings;

	private String[] columnNames =
	{ "id", "Start Date", "End Date", "payment Date", "Invoice Payed", "Booking Payed", "Delete" };

	public BookingTableModel()
	{
		bookings = bCtrl.getAllBookings();
		addTableModelListener(new TableModelListener()
		{

			@Override
			public void tableChanged(TableModelEvent e)
			{
				
			}
		});
		fireTableDataChanged();

	}

	@Override
	public int getColumnCount()
	{
		return columnNames.length;
	}

	@Override
	public int getRowCount()
	{
		return bookings.size();
	}

	@Override
	public Object getValueAt(int rowindex, int columnindex)
	{

		Booking booking = bookings.get(rowindex);

		switch (columnindex)
		{
		default:
			return null;
		case 0:
			return booking.getId();
		case 1:
			return booking.getStartDate();
		case 2:
			return booking.getEndDate();
		case 3:
			return booking.getI().getPaymentDate();
		case 4:
			return "Invoice Payed";
		case 5:
			return "Booking Payed";

		case 6:
			return "Delete";
		case 7:
		}
		return booking;

	}

	public void updateElements()
	{
		bookings = bCtrl.getAllBookings();
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int column)
	{
		return columnNames[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		if (columnIndex == 0)
		{
			return false;
		}
		return true;
	}

	public String getItemFromRow(int row)
	{
		return (String) getValueAt(row, 1);
	}

	public Booking getBookingAt(int index)
	{
		return bookings.get(index);
	}

}
