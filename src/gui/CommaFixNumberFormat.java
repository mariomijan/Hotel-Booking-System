package gui;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class CommaFixNumberFormat extends DecimalFormat
{
	private static final long serialVersionUID = 2004522177904161831L;

	public CommaFixNumberFormat()
	{
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(',');
		symbols.setGroupingSeparator(' ');
		setDecimalFormatSymbols(symbols);
	}

}
