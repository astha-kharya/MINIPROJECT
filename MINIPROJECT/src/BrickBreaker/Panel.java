package BrickBreaker;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
public class Panel extends JPanel implements ActionListener,KeyListener {
	 private boolean play=false;
	    private int score=0;
	    private int totalbricks=28;
	    private Timer timer;
	    private int delay=8;
	    private int ballXposition=120;
	    private int ballYposition=350;
	    private int ballXdirection=-1;
	    private int ballYdirection=-2;
	    private int playerX=350;
	    
	    
	  
	    public void paint(Graphics g){
	        //darkgray canvas
	        g.setColor(Color.darkGray);
	        g.fillRect(1,1,792,692);
	        //border
	        g.setColor(Color.magenta);
	        g.fillRect(0,0,792,3);
	        g.fillRect(0,0,3,692);
	        g.fillRect(791,0,3,692);
	        //paddle
	        g.setColor(Color.green);
	        g.fillRect(playerX,550,200,8);
	        //ball
	        g.setColor(Color.cyan);
	        g.fillOval(ballXposition,ballYposition,40,40);
	    }

	    public Panel() {
	    	addKeyListener(this);
	    	setFocusable(true);
	    	setFocusTraversalKeysEnabled(true);
	    	timer=new Timer(delay,this);
	    	timer.start();
	    }

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		 private void MoveLeft() {
			    play = true;
	        	playerX=playerX-20;
	        }
	        private void MoveRight() {
	        	play = true;
	        	playerX=playerX+20;
	        }
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				if(playerX<=0){
					playerX=0;}
				else{
				MoveLeft();}
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				if(playerX>=600){
					playerX=600;}
				else{
				MoveRight();}
			}
			repaint();
			
		}


		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			timer.start();
			repaint();
				if(play) {

					if(ballXposition<=0){
						ballXdirection=-ballXdirection;}
					if(ballYposition<=0){
						ballYdirection=-ballYdirection;}
					ballXposition+=ballXdirection;
					ballYposition+=ballYdirection;}
				repaint();
			
		}
}