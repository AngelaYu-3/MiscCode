
/**
 * FortuneButton 
 * Played around with basic GUI and used ActionListener with buttons.
 * Matches clicks with either a happy or sad face.
 * 
 * @author Angela Yu
 * 
 * @date April 9, 2020
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class buttons implements ActionListener{
	
	private int count = 0;
	private JLabel label1;
	private JLabel label2;
	private JFrame frame;
	private JButton button1;
	private JButton button2;
	private JPanel panel;
	
	public buttons() {
	    frame = new JFrame();
	    
	    button1 = new JButton("Click me");
	    button1.addActionListener(this);
	    button2 = new JButton("Click me if you dare");
	    button2.addActionListener(this);
	    
	    label1 = new JLabel("Number of clicks: 0");
	    label2 = new JLabel("Tomorrow will be: ");
	    
	    panel = new JPanel();
	    panel.setBorder(BorderFactory.createEmptyBorder(10,10,20,20));
	    panel.setLayout(new GridLayout(1,2));
	    panel.add(button1);
	    panel.add(label1);
	    panel.add(button2);
	    panel.add(label2);
	    
	    frame.add(panel, BorderLayout.CENTER);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setTitle("YAY!");
	    frame.pack();
	    frame.setVisible(true);
	    
	}
	
	public static void main(String[] args) {
	    new buttons();	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		count++;
		label1.setText("Number of clicks: " + count);
		
		if(count%2 == 0) {
			label2.setText("Tomorrow will be: :)");
		}
		else {
			label2.setText("Tomorrow will be: :(");
		}
	}
}

