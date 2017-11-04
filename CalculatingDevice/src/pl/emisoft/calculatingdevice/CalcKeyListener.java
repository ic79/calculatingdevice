package pl.emisoft.calculatingdevice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalcKeyListener implements ActionListener {

	char myChar;
	Controller myController;
	
	public CalcKeyListener(Controller nController) {
		myController = nController;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		JButton pressedButton = (JButton)arg0.getSource();
		char ch = pressedButton.getText().charAt(0);
		myController.performActionForKey(ch);
	}

}
