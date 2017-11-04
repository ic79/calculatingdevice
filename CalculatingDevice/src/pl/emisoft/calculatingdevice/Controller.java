package pl.emisoft.calculatingdevice;

public class Controller {

	private final int NUMBER_OF_DIGITS = 12; 
	
	private Display display;
	private Keyboard keyboard;
	
	private ArithmeticOperationMap operationMap;
	private ArithmeticOperation currentOperation;
	
	private InputStringBuilder stringBuilder;
	private double actualResult = 0.0;
		
	public Controller(Display nDisplay, Keyboard nKeyboard) {
		display = nDisplay;
		keyboard = nKeyboard;
		
		operationMap = new ArithmeticOperationMap();		
		currentOperation = operationMap.get('=');
		
		stringBuilder = new InputStringBuilder(NUMBER_OF_DIGITS);
		
		CalcKeyListener keyListener = new CalcKeyListener(this);
		keyboard.addCalcKeyListener(keyListener);
	}
	
	public void performActionForKey(char ch) {	
		if (operationMap.isOperationChar(ch)) operationPressed(ch);
		else if (ch == 'C') clearPressed();
		else if (ch == 'O') offPressed();
		else digitOrDotPressed(ch);
	}
	
	private void digitOrDotPressed(char ch) {
		double userInputDouble = getDoubleFromString(stringBuilder.appendToString(ch));
		validateDisplay(userInputDouble);
	}
	
	private void operationPressed(char ch) {
		performCurrentOperation();
		validateDisplay(actualResult);
		setArithmeticOperation(operationMap.get(ch));
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
	
	private void performCurrentOperation() {
		String myInputString = stringBuilder.getInputString();
		
		if (!myInputString.equals("")) {
			double actualArgument = getDoubleFromString(myInputString);
			actualResult = currentOperation.getResult(actualArgument, actualResult);
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
