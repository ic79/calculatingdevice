package pl.emisoft.calculatingdevice;

public class InputStringBuilder {
	
	private String inputString = "";
	private int maxDigits;
	private boolean dotPresent = false;
	
	public InputStringBuilder(int nMaxDigits) {
		maxDigits = nMaxDigits;
	}
	
	public String appendToString(char ch) {
		if (ch == '.') appendDotToString();
		else appendDigitToString(ch);
		
		return inputString;
	}
	
	public void clearString() {
		inputString = "";
		dotPresent = false;
	}
	
	public String getInputString() {
		return inputString;
	}
	
	private void appendDigitToString(char ch) {
		if (getNumberOfDigits() < maxDigits) inputString += ch;
	}
	
	private void appendDotToString() {
		if (!dotPresent) {
			inputString += '.';
			dotPresent = true;
		}
	}
	
	private int getNumberOfDigits() {
		int numberOfDigits = inputString.length();
		if (dotPresent) numberOfDigits = numberOfDigits - 1;
		return numberOfDigits;
	}
}
