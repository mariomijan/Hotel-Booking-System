package model;

import java.util.ArrayList;
import java.util.Date;

public class Booking
{
	private int id;
	private Date startDate;
	private Date endDate;
	private int discount;
	private boolean isPayed;
	private Invoice i;
	private Guest g;
	private ArrayList<Room> r = new ArrayList<Room>();

	public Booking()
	{

	}

	public Booking(int id, Date startDate, Date endDate, int discount, boolean isPayed,
			Invoice i, Guest g, ArrayList<Room> r)
	{
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.discount = discount;
		this.isPayed = isPayed;
		this.i = i;
		this.g = g;
		this.r = r;
	}

	public Booking(Date startDate, Date endDate, int discount,
			Invoice i, Guest g, ArrayList<Room> r)
	{
		this.startDate = startDate;
		this.endDate = endDate;
		this.discount = discount;
		this.i = i;
		this.g = g;
		this.r = r;
	}

	public long daysBetween(Date startDate, Date endDate)
	{
		return ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24));
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public int getDiscount()
	{
		return discount;
	}

	public void setDiscount(int discount)
	{
		this.discount = discount;
	}

	public Invoice getI()
	{
		return i;
	}

	public void setI(Invoice i)
	{
		this.i = i;
	}

	public Guest getG()
	{
		return g;
	}

	public void setG(Guest g)
	{
		this.g = g;
	}

	public ArrayList<Room> getR()
	{
		return r;
	}

//	public void setR(ArrayList<Room> r)
//	{
//		this.r = r;
//	}
	
	public void addToR(Room r){
		this.r.add(r);
	}

	public boolean isPayed()
	{
		return isPayed;
	}

	public void setPayed(boolean isPayed)
	{
		this.isPayed = isPayed;
	}
	
	public void deleteAllRooms(){
		r = new ArrayList<Room>();
	}
	
	public void deleteRoom(int numb){
		r.remove(numb);
	}
}
