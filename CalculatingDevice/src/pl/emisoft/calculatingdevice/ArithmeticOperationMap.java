package pl.emisoft.calculatingdevice;

import java.util.HashMap;

public class ArithmeticOperationMap {
	
	private HashMap<String, ArithmeticOperation> operationMap;
	
	public ArithmeticOperationMap() {
		initialiseOperationMap();
	}
	
	private final void initialiseOperationMap() {
		operationMap = new HashMap<String, ArithmeticOperation>();
		operationMap.put("=", new OperationEqual());
		operationMap.put("+", new OperationAdd());	
		operationMap.put("-", new OperationSubstract());
		operationMap.put("*", new OperationMultiply());
		operationMap.put("/", new OperationDivide());
		operationMap.put("+%", new OperationAddPercent());
		operationMap.put("*%", new OperationMultiplyPercent());
		operationMap.put("-%", new OperationSubstractPercent());
		operationMap.put("/%", new OperationDividePercent());
	}
	
	public boolean isOperationChar(String s) {
		if (operationMap.containsKey(s)) return true; 
		return false;
	}
	
	public ArithmeticOperation get(String s) {
		return operationMap.get(s);
	}
}
