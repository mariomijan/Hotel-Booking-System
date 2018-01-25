package gui;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.FileOutputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.Booking;

public class Pdf
{
	private static Font title = new Font(Font.FontFamily.TIMES_ROMAN, 30, Font.BOLD);
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font normalText = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL);
	private Booking book;

	public Pdf(Booking book)
	{
		{
			try
			{
				this.book = book;
				String directory = (System.getProperty("user.dir") + "/BookingPdf/").replace('\\', '/');
				String file = "Booking" + book.getId() + ".pdf";

				FileDialog fileDialog = new FileDialog((Frame) null);
				fileDialog.setMode(FileDialog.SAVE);
				fileDialog.setDirectory(directory);
				fileDialog.setFile(file);
				fileDialog.setVisible(true);
				directory = fileDialog.getDirectory();
				file = fileDialog.getFile();
				if (file == null)
				{
					return;
				}

				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(directory + file));
				document.open();
				addMetaData(document);
				PdfPTable pdfTable = createTable(document);
				addTitlePage(document);

				Paragraph preface = new Paragraph();
			

				document.add(createInformationTable(book));

				document.add(addBookingId());
				
				writeDate(document);

				document.add(pdfTable);

				addEmptyLine(preface, 1);

				document.add(preface);

				document.add(addTotalPrice());

				document.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void writeDate(Document document) throws DocumentException{
		
		Paragraph dato = new Paragraph();

		java.sql.Date sqlDate0 = new java.sql.Date(book.getStartDate().getTime());
		java.sql.Date sqlDate1 = new java.sql.Date(book.getEndDate().getTime());
		
		dato.add(new Paragraph("StartDate: " + sqlDate0 , normalText));
		addEmptyLine(dato, 1);
		dato.add(new Paragraph(" EndDate: "+  sqlDate1, normalText));
		addEmptyLine(dato, 1);
		document.add(dato);
	}

	private void addMetaData(Document document)
	{
		document.addTitle("Booking");
		document.addAuthor("Marocco Holiday Centre");
		document.addCreator("Marocco Holiday Centre");
	}

	private void addTitlePage(Document document) throws DocumentException
	{
		/* Creates the title of the page */
		Paragraph textTitle = new Paragraph();

		textTitle.setSpacingAfter(25);
		textTitle.setSpacingBefore(25);
		textTitle.setAlignment(Element.ALIGN_MIDDLE);
		textTitle.setIndentationLeft(60);
		textTitle.setIndentationRight(50);
		textTitle.add(new Paragraph("Marocco Holiday Center", title));
		document.add(textTitle);

	}

	public Paragraph addBookingId()
	{
		Paragraph preface = new Paragraph();

		preface.add(new Paragraph("Booking ID : " + book.getId(), catFont));
		addEmptyLine(preface, 1);

		
		return preface;

	}

	public PdfPTable addTotalPrice()
	{
		PdfPTable table = new PdfPTable(3);
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.CEILING);
		table.setWidthPercentage(100);
		table.addCell(getCell("", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell("Total price: " + df.format(book.getI().getTotalPrice()) + "EUR", PdfPCell.ALIGN_RIGHT));
		return table;
	}

	public PdfPTable createTable(Document document) throws DocumentException
	{
		float[] columnWidths =
		{ 2, 2, 2, 2, 2 };
		PdfPTable table = new PdfPTable(columnWidths);
		table.setWidthPercentage(100);
		table.getDefaultCell().setUseAscender(true);
		table.getDefaultCell().setUseDescender(true);

		table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
		table.addCell("RoomType");
		table.addCell("Amount of days");
		table.addCell("Price per day");
		table.addCell("Discount");
		table.addCell("Price in EUR");
		table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

		table.setHeaderRows(1);
		table.setFooterRows(0);
		
		for (int i = 0; i < book.getR().size(); i++){
		table.addCell(book.getR().get(i).getRt().getRoomType());
		table.addCell(book.daysBetween(book.getStartDate(), book.getEndDate()) + "");
		
		
		table.addCell(book.getR().get(i).getRt().getRoomPrice() + "");
		
		table.addCell(book.getDiscount() + "");
		table.addCell((book.getR().get(i).getRt().getRoomPrice() *
				book.daysBetween(book.getStartDate(), book.getEndDate() ) )+ "");
		}
		return table;
	}

	public PdfPTable createInformationTable(Booking book)
	{
		String name = book.getG().getName();
		String lastName = book.getG().getLastname();
		String email = book.getG().getEmail();
		String phoneNo = book.getG().getPhoneNo();
		String country = book.getG().getGuestOrigin().getCountry();
		String city = book.getG().getGuestOrigin().getCity();
		String postalCode = book.getG().getGuestOrigin().getPostalCode();

		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100);

		table.addCell(getCell("Company information : ", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("|", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell("Customer Information : ", PdfPCell.ALIGN_RIGHT));

		table.addCell(getCell("Marocco Holiday Center", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("|", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell(name, PdfPCell.ALIGN_RIGHT));

		table.addCell(getCell("Rabat", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("|", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell(lastName, PdfPCell.ALIGN_RIGHT));

		table.addCell(getCell("+212-530-393929", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("|", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell(email, PdfPCell.ALIGN_RIGHT));

		table.addCell(getCell("MaroccoHoliday@gmail.com", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("|", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell(phoneNo, PdfPCell.ALIGN_RIGHT));

		table.addCell(getCell("", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("|", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell(city, PdfPCell.ALIGN_RIGHT));

		table.addCell(getCell("", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("|", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell(postalCode, PdfPCell.ALIGN_RIGHT));

		table.addCell(getCell("", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("|", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell(country, PdfPCell.ALIGN_RIGHT));

		table.addCell(getCell("__________________________", PdfPCell.ALIGN_LEFT));
		table.addCell(getCell("__________________________", PdfPCell.ALIGN_CENTER));
		table.addCell(getCell("__________________________", PdfPCell.ALIGN_RIGHT));
		return table;
	}

	public PdfPCell getCell(String text, int alignment)
	{
		PdfPCell cell = new PdfPCell(new Phrase(text));
		cell.setPadding(0);
		cell.setHorizontalAlignment(alignment);
		cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}

	private void addEmptyLine(Paragraph paragraph, int number)
	{
		for (int i = 0; i < number; i++)
		{
			paragraph.add(new Paragraph(" "));
		}
	}

}
