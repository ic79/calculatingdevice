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
	}
	
	public boolean isOperationChar(char ch) {
		if (operationMap.containsKey(ch+"")) return true; 
		return false;
	}
	
	public ArithmeticOperation get(char ch) {
		return operationMap.get(ch+"");
	}
}
