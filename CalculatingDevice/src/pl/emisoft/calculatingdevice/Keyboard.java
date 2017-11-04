package pl.emisoft.calculatingdevice;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Keyboard extends JPanel {
	
	private CalcKeyListener keyListener;
	
	private JButton buttonsDigit[];
	private JButton buttonAddition;
	private JButton buttonSubstraction;
	private JButton buttonMultiplication;
	private JButton buttonDivision;
	private JButton buttonDot;
	private JButton buttonEquality;
	private JButton buttonClear;
	private JButton buttonOff;
	
	public Keyboard() {
		this.setLayout(new GridBagLayout());
		createButtons();
		addButtonsToPanel();
	}
	
	public void addCalcKeyListener(CalcKeyListener nListener) {
		setKeyListener(nListener);
		registerListener();
	}
	
	private void setKeyListener(CalcKeyListener nListener) {
		keyListener = nListener;
	}
	
	private void registerListener() {
		for (int i=0; i<10; i++) buttonsDigit[i].addActionListener(keyListener);
		buttonDot.addActionListener(keyListener);
		
		buttonAddition.addActionListener(keyListener);
		buttonSubstraction.addActionListener(keyListener);
		buttonMultiplication.addActionListener(keyListener);
		buttonDivision.addActionListener(keyListener);
		buttonEquality.addActionListener(keyListener);
		
		buttonClear.addActionListener(keyListener);
		buttonOff.addActionListener(keyListener);
	}
	
	private final void createButtons() {
		buttonsDigit = new JButton[10];
		for (int i=0; i<10; i++) buttonsDigit[i] = new JButton(i+"");
		
		buttonAddition = new JButton("+");
		buttonSubstraction = new JButton("-");
		buttonMultiplication = new JButton("*");
		buttonDivision = new JButton("/");
		
		buttonDot = new JButton(".");
		buttonEquality = new JButton("=");
		buttonClear = new JButton("C");
		buttonOff = new JButton("Off");
	}
	
	private final void addButtonsToPanel() {
		GridBagConstraints layoutConstraints = new GridBagConstraints();	
		layoutConstraints.fill = GridBagConstraints.BOTH;
		
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		
		
		layoutConstraints.gridx = 3;
		layoutConstraints.gridy = 0;
		this.add(buttonAddition, layoutConstraints);
		
		layoutConstraints.gridx = 3;
		layoutConstraints.gridy = 1;
		this.add(buttonSubstraction, layoutConstraints);
		
		layoutConstraints.gridx = 3;
		layoutConstraints.gridy = 2;
		this.add(buttonMultiplication, layoutConstraints);
		
		layoutConstraints.gridx = 3;
		layoutConstraints.gridy = 3;
		this.add(buttonDivision, layoutConstraints);
		
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 0;
		this.add(buttonsDigit[1], layoutConstraints);
		
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 0;
		this.add(buttonsDigit[2], layoutConstraints);
		
		layoutConstraints.gridx = 2;
		layoutConstraints.gridy = 0;
		this.add(buttonsDigit[3], layoutConstraints);
		
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 1;
		this.add(buttonsDigit[4], layoutConstraints);
		
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 1;
		this.add(buttonsDigit[5], layoutConstraints);
		
		layoutConstraints.gridx = 2;
		layoutConstraints.gridy = 1;
		this.add(buttonsDigit[6], layoutConstraints);
		
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 2;
		this.add(buttonsDigit[7], layoutConstraints);
		
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 2;
		this.add(buttonsDigit[8], layoutConstraints);
		
		layoutConstraints.gridx = 2;
		layoutConstraints.gridy = 2;
		this.add(buttonsDigit[9], layoutConstraints);

		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 3;
		this.add(buttonsDigit[0], layoutConstraints);
		
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 3;
		this.add(buttonDot, layoutConstraints);
		
		layoutConstraints.gridx = 2;
		layoutConstraints.gridy = 3;
		this.add(buttonEquality, layoutConstraints);
		
		layoutConstraints.gridwidth = 2;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 4;
		this.add(buttonClear, layoutConstraints);
		
		layoutConstraints.gridx = 2;
		layoutConstraints.gridy = 4;
		this.add(buttonOff, layoutConstraints);
	}
	
}
