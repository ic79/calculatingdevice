package pl.emisoft.calculatingdevice;

public class OperationMultiply extends ArithmeticOperation {

	@Override
	public double getResult(double argument1, double argument2) {
		return argument1 * argument2;
	}

}
