package BrickBreaker;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Panel extends JPanel {
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
	        //daekgray canvas
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

}
