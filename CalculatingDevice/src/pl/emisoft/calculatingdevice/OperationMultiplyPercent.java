package pl.emisoft.calculatingdevice;

public class OperationMultiplyPercent implements ArithmeticOperation {

	public double getResult(double argument1, double argument2) {
		return argument1 * argument2 / 100;
	}

}
