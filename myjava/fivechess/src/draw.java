import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public class draw extends JPanel{
	Graphics g=getGraphics();
	
	protected void paintComponent(Graphics g)
	{
		g.setColor(Color.yellow);
		g.fill3DRect(0, 0, 748, 728, true);
		g.setColor(Color.black);
		for(int i=0;i<20;i++)
		{
			g.drawLine(70, 50+i*32, 678, 50+i*32);
			g.drawLine(70+i*32, 50, 70+i*32, 658);
		}
		g.setFont(new Font("宋体",Font.PLAIN,30));
		g.drawString("五子棋",300,40);
	}
	public void showoutresult(String s)
	{
		g=getGraphics();
		g.setColor(Color.red);
		g.setFont(new Font("宋体",Font.PLAIN,100));
		g.drawString(s, 150, 300);
	}
	public void showpoint(int x,int y,boolean t)
	{
		g=getGraphics();
		if(t==true)
		{
			g.setColor(Color.BLACK);
			g.fillOval(x*32+55,y*32+35,30,30);
		}
		else
		{
			g.setColor(Color.white);
			g.fillOval(x*32+55, y*32+35, 30, 30);
		}
	}
	
}
