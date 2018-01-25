package model;

import java.sql.Date;

public class Invoice
{
	private int invoiceNo;
	private Date paymentDate;
	private double totalPrice;
	private boolean status;

	public Invoice(int invoiceNo, double totalPrice, Date paymentDate, boolean status)
	{
		this.invoiceNo = invoiceNo;
		this.totalPrice = totalPrice;
		this.paymentDate = paymentDate;
		this.status = status;
	}


	public int getInvoiceNo()
	{
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo)
	{
		this.invoiceNo = invoiceNo;
	}

	public Date getPaymentDate()
	{
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate)
	{
		this.paymentDate = paymentDate;
	}

	public double getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus()
	{
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status)
	{
		this.status = status;
	}
}
