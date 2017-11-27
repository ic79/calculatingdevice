package pl.emisoft.calculatingdevice;

public class Controller {

	private final int NUMBER_OF_DIGITS = 12; 
	
	private Display display;
	private Keyboard keyboard;
	
	private ArithmeticOperationMap operationMap;
	private ArithmeticOperation currentOperation;
	private String operationString;
	
	private InputStringBuilder stringBuilder;
	private double actualResult = 0.0;
	private double userInputDouble = 0.0;
		
	public Controller(Display nDisplay, Keyboard nKeyboard) {
		display = nDisplay;
		keyboard = nKeyboard;
		
		operationMap = new ArithmeticOperationMap();		
		operationString = "=";
		
		stringBuilder = new InputStringBuilder(NUMBER_OF_DIGITS);
		
		CalcKeyListener keyListener = new CalcKeyListener(this);
		keyboard.addCalcKeyListener(keyListener);
	}
	
	public void performActionForKey(char ch) {	
		if (operationMap.isOperationChar(ch+"")) operationPressed(ch);
		else if (ch == 'C') clearPressed();
		else if (ch == 'O') offPressed();
		else if (ch == '%') percentPressed();
		else digitOrDotPressed(ch);
	}
	
	private void digitOrDotPressed(char ch) {
		userInputDouble = getDoubleFromString(stringBuilder.appendToString(ch));
		validateDisplay(userInputDouble);
	}
	
	private void operationPressed(char ch) {
		performCurrentOperation(userInputDouble, actualResult);
		validateDisplay(actualResult);
		createOperationString(ch);
	}
	
	private void createOperationString(char ch) {
		operationString = ch+"";
	}
	
	private void addModifierToOperationString(char ch) {
		operationString += ch;
	}
	
	private void percentPressed() {
		addModifierToOperationString('%');
		operationPressed('=');
	}
	
	private void clearPressed() {
		stringBuilder.clearString();
		setActualResult(0.0);
		validateDisplay(actualResult);
	}
	
	private void offPressed() {
		System.exit(0);
		return;
	}
	
	private void performCurrentOperation(double input, double result) {
		setArithmeticOperation(operationMap.get(operationString));
		if (!stringBuilder.isEmptyString()) {
			actualResult = currentOperation.getResult(input, result);
			stringBuilder.clearString();
		}
	}
	
	private void setArithmeticOperation(ArithmeticOperation myOperation) {
		currentOperation = myOperation;
	}
	
	private double getDoubleFromString(String inputString) {
		Double inputNumber = 0.0;
		try {
			inputNumber = Double.parseDouble(inputString);
		} 
		catch (Exception e) { System.out.println(e.getMessage());	}
		
		return inputNumber;
	}
	
	private void validateDisplay(double number) {
		display.setMainContent(number);
	}
	
	private void setActualResult(double result) {
		actualResult = result;
	}
}
