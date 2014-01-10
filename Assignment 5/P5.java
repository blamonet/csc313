// Aaron Grant
// CSC 313
// Assignment #5
// 4/8/03

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import javax.swing.border.*;	
import java.text.*;
import java.math.*;

public class P5 extends JFrame implements ActionListener{
		

	public static void main(String[] args){
		P5 frame = new P5();
		frame.show();
	}

	private JButton calculateButton, exitButton;
	private JLabel amountLabel, sqrtLabel;
	private JTextField amountField, sqrtField;
	private JPanel displayPanel;
	private double sqrtNum;

	public P5(){
		setTitle("Calculate the Square Root");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int width = 300;
		int height = 300;
		setBounds((int) (d.width-width)/2,
				  (int) (d.height-height)/2, width, height);

		setResizable(false);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		

		Container contentPane = getContentPane();

		displayPanel = new JPanel();
		JPanel displayPanel2 = new JPanel();
		amountLabel = new JLabel("Enter a Number:");
		sqrtLabel = new JLabel("Square Root Result:");
		amountField = new JTextField(10);
		sqrtField = new JTextField(10);
		sqrtField.setEditable(false);
		displayPanel.add(amountLabel);
		displayPanel.add(amountField);
		displayPanel.add(sqrtLabel);
		displayPanel.add(sqrtField);


		contentPane.add(displayPanel, BorderLayout.CENTER);

	
		JPanel panelx = new JPanel();
		calculateButton = new JButton("Calculate");
		exitButton = new JButton("Exit");
		panelx.add(calculateButton);
		panelx.add(exitButton);
        panelx.setLayout(new FlowLayout(FlowLayout.RIGHT));
		contentPane.add(panelx, BorderLayout.SOUTH);
		
	    calculateButton.addActionListener(this);
		exitButton.addActionListener(this);

	}



	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		if (source == exitButton)
				System.exit(0);
		if (source == calculateButton) {
			try {
				DecimalFormat decimal = new DecimalFormat("0.00");
				double sqrtNum = Double.parseDouble(amountField.getText());
				if(sqrtNum<0) 
				{
				JOptionPane.showMessageDialog(null, "Invalid entry, We don't like dealing with imaginary numbers.\n"
					+ "Please try again.");
				amountField.setText("");
				sqrtField.setText("");
				amountField.requestFocusInWindow();
				return;
		     	}
		     	
				sqrtNum = Math.sqrt(sqrtNum);
				sqrtField.setText(decimal.format(sqrtNum));
	         	}

			catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(null, "Invalid entry.\n"
					+ "Please try again.");
				amountField.setText("");
				sqrtField.setText("");
				amountField.requestFocusInWindow();
			}
			}

}

}
