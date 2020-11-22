package BrickBreaker;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
public class Panel extends JPanel implements ActionListener,KeyListener {
	 private boolean play=false;
	    private int score=0;
	    private int totalbricks=32;
	    private Timer timer;
	    private int delay=8;
	    private int ballXposition=120;
	    private int ballYposition=350;
	    private int ballXdirection=-1;
	    private int ballYdirection=-2;
	    private int playerX=350;
	    private BrickGenerator brick;
	  
	    public void paint(Graphics g){
	    	super.paint(g);
	        //darkgray canvas
	        g.setColor(Color.darkGray);
	        g.fillRect(1,1,792,692);

	        //border
	        g.setColor(Color.magenta);
	        g.fillRect(0,0,792,3);
	        g.fillRect(0,3,3,692);
	        g.fillRect(791,3,3,692);

	        //paddle
	        g.setColor(Color.green);
	        g.fillRect(playerX,630,200,8);

	        //ball
	        g.setColor(Color.cyan);
	        g.fillOval(ballXposition,ballYposition,20,20);
	       
	        //bricks
	        brick.draw((Graphics2D)g);
	        
	        //score
	        g.setColor(Color.ORANGE);
	        g.setFont(new Font("serif",Font.BOLD,20));
	        g.drawString("Score:"+score,650,20);
	       
	        
	        //gameover
	        if(ballYposition>=650) {
	        	play=false;
	        	ballXdirection=0;
	        	ballYdirection=0;
	        	
	        	g.setColor(Color.yellow);
	        	g.setFont(new Font("serif",Font.BOLD,40));
	        	g.drawString("GAME OVER!!! Score :"+score,200,300);
	        	
	        	g.setColor(Color.PINK);
	        	g.setFont(new Font("italic",Font.BOLD,30));
	        	g.drawString("PRESS ENTER TO RESTART!!!",200,350);
	        	
	        }
	        if(totalbricks<=0) {
	        	play=false;
	        	ballXdirection=0;
	        	ballYdirection=0;
	        	
	        	g.setColor(Color.white);
	        	g.setFont(new Font("serif",Font.BOLD,40));
	        	g.drawString("You Won! Score :"+score,200,300);
	        	
	        	g.setColor(Color.PINK);
	        	g.setFont(new Font("italic",Font.BOLD,30));
	        	g.drawString("PRESS SPACEBAR TO RESTART!!!",200,350);
	        }
	    }

	    public Panel() {
	    	addKeyListener(this);
	    	setFocusable(true);
	    	setFocusTraversalKeysEnabled(true);
	    	timer=new Timer(delay,this);
	    	timer.start();
	    	brick=new BrickGenerator(4,8);
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
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				if(!play) {
					score=0;
					totalbricks=32;
					ballXposition=120;
					ballYposition=350;
				    ballXdirection=-1;
				    ballYdirection=-2;
				    playerX=350;
				    brick=new BrickGenerator(4,8);
				}
				
			}
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				if(!play) {
					score=0;
					totalbricks=40;
					ballXposition=120;
					ballYposition=350;
				    ballXdirection=-1;
				    ballYdirection=-2;
				    playerX=350;
				    brick=new BrickGenerator(4,8);
				}
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
						ballXdirection=-ballXdirection;
						}
					if(ballXposition>=752) {
						ballXdirection=-ballXdirection;
					}
					if(ballYposition<=0){
						ballYdirection=-ballYdirection;
						}
					Rectangle ball=new Rectangle(ballXposition,ballYposition,20,20);
					Rectangle paddle=new Rectangle(playerX,630,200,8);
					
					if(ball.intersects(paddle)) {
						ballYdirection=-ballYdirection;
					}
					
					A:for(int i=0;i<brick.map.length;i++) {
						for(int j=0;j<brick.map[0].length;j++) {
							if(brick.map[i][j]>0) {
								int width=brick.BrickWidth;
								int height=brick.BrickHeight;
								int brickXposition=100+j*width;
								int brickYposition=20+i*height;
								
								Rectangle brickRect=new Rectangle(brickXposition,brickYposition,width,height);
								
								if(ball.intersects(brickRect)) {
									brick.setBrick(0,i,j);
									totalbricks--;
									score=score+5;
									
									if(ballXposition+19<=brickXposition || ballXposition+1>=brickXposition+width) {
										ballXdirection=-ballXdirection;
									}
									else {
										ballYdirection=-ballYdirection;
									}
									break A;
								}
							}
						}
					}
					
					ballXposition+=ballXdirection;
					ballYposition+=ballYdirection;
					}
				repaint();
			
		}
}