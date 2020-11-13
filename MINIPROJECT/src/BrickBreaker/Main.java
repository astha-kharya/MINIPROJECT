package BrickBreaker;

import javax.swing.JFrame;

public class Main {
	public static void main(String[]args) {
		JFrame frame=new JFrame();
        frame.setSize(800,700);
        frame.setTitle("THE BREAKOUT GAME");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        Panel panel=new Panel();
        frame.add(panel);
        
	}

}


