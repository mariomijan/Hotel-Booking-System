package gui;

import java.awt.Color;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextFieldValidator implements DocumentListener
{
	private JLabel jLbl;
	private String regEx;
	private String lblError;
	private JTextField jTxt;

	public TextFieldValidator(JTextField jTxt, JLabel jLbl, String regEx)
	{
		this.jTxt = jTxt;
		this.jLbl = jLbl;
		this.regEx = regEx;
		this.lblError = "Wrong input";
	}

	@Override
	public void changedUpdate(DocumentEvent e)
	{
		regexPattern();
	}

	@Override
	public void insertUpdate(DocumentEvent e)
	{
		regexPattern();
	}

	@Override
	public void removeUpdate(DocumentEvent e)
	{
		regexPattern();
	}

	// Checks if the inputs are correct based on color
	private void regexPattern()
	{
		if (Pattern.matches(regEx, jTxt.getText()))
		{
			jLbl.setText("Correct input");
			jTxt.setBackground(Color.green);

		} else if (jTxt.getText().isEmpty())
		{
			jTxt.setBackground(Color.white);
			jLbl.setText("");
		} else
		{
			jLbl.setText(lblError);
			jTxt.setBackground(Color.red);
		}

	}
}
