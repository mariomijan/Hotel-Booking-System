package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Booking;
import model.Invoice;

public class InvoiceDb extends FrameWork
{
	private Connection con;

	// The invoiceDB constructor
	public InvoiceDb()
	{
		super();
		con = DbConnection.getInstance().getDBcon();
	}

	// Adds invoice to the DB
	public void addInvoiceToDB(Invoice i)
	{
		String addQuery = addInvoiceQuery();
		PreparedStatement addInvoice = null;
		try
		{
			con.setAutoCommit(false);
			addInvoice = con.prepareStatement(addQuery);
			System.out.println(i.getInvoiceNo());
			addInvoice.setInt(1, i.getInvoiceNo());
			addInvoice.setDate(2, i.getPaymentDate());
			addInvoice.setDouble(3, i.getTotalPrice());
			addInvoice.setBoolean(4, i.isStatus());

			addInvoice.executeUpdate();
		} catch (SQLException e)
		{

			e.printStackTrace();
		} finally
		{
			try
			{

				addInvoice.close();
				con.setAutoCommit(true);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}

		}

	}

	// Query to add the invoice to the DB
	private String addInvoiceQuery()
	{
		return "INSERT INTO Invoice VALUES (?, ?, ?, ?);";
	}

	// Updates the invoice status
	public void updateStatus(Booking b)
	{
		String updateQuery = updateStatusQuery();
		PreparedStatement updateInvoiceStatus = null;
		try
		{
			con.setAutoCommit(false);
			updateInvoiceStatus = con.prepareStatement(updateQuery);
			updateInvoiceStatus.setBoolean(1, true);
			updateInvoiceStatus.setInt(2, b.getId());
			updateInvoiceStatus.executeUpdate();
		} catch (SQLException e)
		{

			e.printStackTrace();
		} finally
		{
			try
			{

				updateInvoiceStatus.close();
				con.setAutoCommit(true);
			} catch (SQLException e)

			{
				e.printStackTrace();
			}

		}

	}

	// Query that updates the status
	private String updateStatusQuery()
	{
		return "UPDATE Invoice SET status = ? where invoiceNo = ?";
	}
}
