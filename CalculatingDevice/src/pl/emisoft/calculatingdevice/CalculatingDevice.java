package pl.emisoft.calculatingdevice;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class CalculatingDevice extends JFrame {

	private static final long serialVersionUID = 1L;
	Controller myController;
	Display myDisplay;
	Keyboard myKeyboard; 

	public static void main(String[] args) {
		new CalculatingDevice().setVisible(true);
	}

	public CalculatingDevice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        Container content = this.getContentPane();
        content.setLayout(new BorderLayout());
                
		myDisplay = new Display();
		myKeyboard = new Keyboard();
		myController = new Controller(myDisplay, myKeyboard);
				
		content.add(myDisplay, BorderLayout.NORTH);
		content.add(myKeyboard, BorderLayout.CENTER);
	}
	
}
