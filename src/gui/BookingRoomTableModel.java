package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import ctrl.BookingCtrl;
import model.Booking;
import model.Room;

public class BookingRoomTableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 4258350672422219967L;
	private BookingCtrl bCtrl = new BookingCtrl();
	private static List<Room> rooms; 
	
	private String[] columnNames = { "RoomNo", "RoomPrice", "RoomType","Delete"};
	
	public BookingRoomTableModel()
	{
		rooms = new ArrayList<Room>();
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
		return rooms.size();
	}

	@Override
	public Object getValueAt(int rowindex, int columnindex)
	{

		Room room = rooms.get(rowindex);

		switch (columnindex)
		{
			default:
				return null;
			case 0:
				return room.getRoomNo();
			case 1:
				return room.getRt().getRoomPrice();
			case 2:
				return room.getRt().getRoomType();
			case 3:
				return "Delete";
			
		}
		

	}
	
	public void removeAllRooms(){
		rooms = new ArrayList<Room>();
		fireTableDataChanged();
	}
	
	
	public void updateRooms(int numb){
		rooms.remove(numb);
		fireTableDataChanged();
	}
	
	


	public void updateElements(Room r){
		rooms.add(r);
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
	
	public Room getRoomAt(int index){
		return rooms.get(index);
	}
	


}


