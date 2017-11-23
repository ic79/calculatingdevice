package pl.emisoft.calculatingdevice;

public class OperationDividePercent implements ArithmeticOperation {

	public double getResult(double argument1, double argument2) {
		return argument2 / (argument1 / 100);
	}

}
