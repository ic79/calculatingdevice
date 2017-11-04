package pl.emisoft.calculatingdevice;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display extends JPanel {
	
	private JLabel displayLabel;
	private DecimalFormat numberFormat;
	
	public Display() {
		this.setPreferredSize(new Dimension(100, 40));
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		displayLabel = new JLabel();
		displayLabel.setFont(new Font("", Font.PLAIN, 20));
		displayLabel.setText("0");
		this.add(displayLabel);
		
		numberFormat = new DecimalFormat("#.##########");
	}
	
	public void setMainContent(double number) {
		String stringNumber = numberFormat.format(number);
		displayLabel.setText(stringNumber);
	}
}
