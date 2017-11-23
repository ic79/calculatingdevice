package pl.emisoft.calculatingdevice;

public class OperationSubstractPercent implements ArithmeticOperation {

	public double getResult(double argument1, double argument2) {
		return argument2 - argument2 * argument1 / 100;
	}

}
