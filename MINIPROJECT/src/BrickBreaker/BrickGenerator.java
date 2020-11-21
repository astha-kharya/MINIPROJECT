package BrickBreaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class BrickGenerator {
	public int map[][];
	public int BrickWidth;
	public int BrickHeight;
	
	public BrickGenerator(int row,int col) {
		map=new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				map[i][j]=1;
			}
		}
		BrickWidth=600/col;
		BrickHeight=150/row;
	}
	public void setBrick(int value,int r,int c) {
		map[r][c]=value;
	}
    public void draw(Graphics2D g) {
    	for(int i=0;i<map.length;i++) {
    		for(int j=0;j<map[0].length;j++) {
    			if(map[i][j]>0) {
    				g.setColor(Color.gray);
    				g.fillRect(j*BrickWidth+100,i*BrickHeight+30,BrickWidth,BrickHeight);
    				
    				g.setColor(Color.darkGray);
    				g.setStroke(new BasicStroke(3));
    				g.drawRect(j*BrickWidth+100,i*BrickHeight+30,BrickWidth,BrickHeight);
    			}
    		}
    	}
    }
}
