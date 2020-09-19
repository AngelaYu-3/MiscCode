import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongFrame extends JPanel implements ActionListener, KeyListener {

	// practice declarations and assignments
	int xB = 30, yB = 0;
	int widthB = 15, heightB = 15;
	Color colorB = new Color(50, 168, 147);

	// add variables for paddles!
	int p1x = 20, p1y = 0;
	int p2x = 550, p2y = 0;
	int widthP = 13, heightP = 90;
	
	//ball velocities
	int bvx = 10, bvy = 4;
	
	//paddle velocities
	int p1v = 0, p2v = 0;
	
	//score variables
	int p1Score = 0;
	int p2Score = 0;
	
	//font for score
	Font verdana1 = new Font("Verdana", Font.BOLD, 20); 
	Font verdana2 = new Font("verdana", Font.BOLD, 100); 

	/*
	 * paint method runs roughly 60x per second
	 */
	public void paint(Graphics g) {
	   	super.paintComponent(g); // do not remove
	   	
	   	//drawing text on screen + using variables
	   	g.setFont(verdana1);
	   	g.drawString("" + p1Score, 230, 80);
	   	g.drawString("" + p2Score, 350, 80);
	   	 //set the font

	    //position in the x changes based on velocity in the x
	   	xB = xB + bvx;
	   	yB = yB + bvy;
	   	
	   	//condition for changing velocity direction
	   	if(xB >= 587) {
	   		//flip the x velocity if ball is on the right side
	   		bvx = -bvx; 
	   	}
	   	else if (xB <= 0) {
	   		if (bvx < 0) {
	   			bvx = -bvx;
	   		}
	   	}
	   	else if (yB >= 365) {
	   		bvy = -bvy;
	   	}
	   	else if (yB <= 0) {
	   		if (bvy < 0) {
	   			bvy = -bvy;
	   		}   		
	   	}
	   	
		// add code below
		// ball code for drawing
		g.setColor(colorB);
		g.fillOval(xB, yB, widthB, heightB);

		// drawing a rectangle
		g.setColor(Color.black);
		g.fillRect(p1x, p1y, widthP, heightP);
		g.fillRect(p2x, p2y, widthP, heightP);
		g.fillRect(290, 0, 3, 400);

		//paddle movement
		p1y += p1v;
		p2y += p2v;
		
		//paddle collision detection
		if(p1y <= 0) {
		     p1y = 0;
		}
		if(p1y >= 280) {
		     p1y = 280;
		}
		if(p2y <= 0) {
		     p2y = 0;
		}
		if(p2y >= 280) {
		     p2y = 280;
		}
		 
		//collision detection
		//check if the ball y is in the range of the paddle y
		if(yB >= p1y && yB <= p1y + heightP) {
		    if(xB >= p1x && xB <= p1x + widthP) {
		    	bvy = -bvy;
		    	bvx = -bvx;
		    }
		}
		
		if(yB >= p2y && yB <= p2y + heightP) {
		    if(xB >= p2x && xB <= p2x + widthP) {
		    	bvy = -bvy;
		    	bvx = -bvx;
		    }
		}
		
		//score update 
		if(xB == 0) {
		    p2Score += 1;
		}
		if(xB == 590) {
			p1Score += 1;
		}
	
	} // end of paint curly do not delete

	// do not touch
	public PongFrame() {
		JFrame frame = new JFrame("Pong");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		
		//set up frame to listen to keyboard presses
		frame.addKeyListener(this);

		Timer t = new Timer(16, this);
		t.start();
		frame.setVisible(true);
	}// end of MainFrame

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	} // end of actionPerformed curly do not delete

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode());
		
		if(e.getKeyChar() == 's') {	 
		    p1v = 8;	
		}
		if(e.getKeyChar() == 'w') {
		    p1v = -8;	
        }
		
		if(e.getKeyCode() == 40) {
			p2v = 8;
		}
		if(e.getKeyCode() == 38) {
			p2v = -8;
		}		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == 's') {
			 p1v = 0;	
        }
		if(e.getKeyChar() == 'w') {
			 p1v = 0;	
	    }
		if(e.getKeyCode() == 40) {
			 p2v = 0;
		}
		if(e.getKeyCode() == 38) {
			 p2v = 0;
		}
		
		
		
	}

} // end of class curly - do not delete
