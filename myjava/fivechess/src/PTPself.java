import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;


public class PTPself extends JFrame{
	public PTPself()
	{
		final chess wh = new chess();
		wh.clear();
		wh.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e) {
				if(wh.wh_stop==3)
				{
					int xx=e.getX();
					int yy=e.getY();
					int x=(xx-54)/32;
					int y=(yy-66)/32;
					if(xx>54&&xx<694&&yy>66&&yy<706)
					{
						if(wh.wh_arr[x][y]==0)
						{
							wh.wh_rf=!wh.wh_rf;
							wh.insert(x,y);
							if(wh.iswin(x, y)==true)
							{
								if(wh.wh_rf==true) wh.showoutresult("黑棋获胜");
								else wh.showoutresult("白棋获胜");
								wh.wh_stop=0;
							}
							
						}
					}
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
		});
		wh.addMouseMotionListener(new MouseMotionListener()
		{

			@Override
			public void mouseDragged(MouseEvent arg0) {
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
			}
			
		});
	}
}
