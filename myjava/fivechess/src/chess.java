import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;


public class chess extends JFrame{
	int [][]wh_arr=new int[30][30];
	int wh_stop=3,wh_i,wh_j;
	boolean wh_rf;
	draw tmp=new draw();
	public chess()
	{
		super("五子棋");
		Container c=getContentPane();
		c.setLayout(null);
		JButton b=new JButton("重新开始");
		JButton back=new JButton("返回");
		tmp.setBounds(0,0,748,728);
		c.add(back);
		c.add(b);
		b.setBounds(70,20,100,20);
		back.setBounds(578, 20, 100, 20);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				clear();
				repaint();
			}
		});
		back.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new mainmenu();
				
			}
			
		});
		c.add(tmp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(748,728);
		setVisible(true);
		setResizable(false);
	}
	
	public void clear()
	{
		wh_stop=3;
		wh_rf=false;
		for(int i=0;i<20;i++)
			for(int j=0;j<20;j++) wh_arr[i][j]=0;
	}
	private boolean mycheck(int i,int j,int x)
	{
		if(i<0||i>19||j<0||j>19) return false;
		if(wh_arr[i][j]!=x) return false;
		return true;
	}
	public boolean iswin(int x,int y)
	{
		boolean flag=true,win=false;
		for(int i=-2;i<=2;i++)
			flag=flag&&mycheck(x+i,y+i,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-1;i<=3;i++)
			flag=flag&&mycheck(x+i,y+i,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=0;i<=4;i++)
			flag=flag&&mycheck(x+i,y+i,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-3;i<=1;i++)
			flag=flag&&mycheck(x+i,y+i,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-4;i<=0;i++)
			flag=flag&&mycheck(x+i,y+i,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-2;i<=2;i++)
			flag=flag&&mycheck(x-i,y+i,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-3;i<=1;i++)
			flag=flag&&mycheck(x-i,y+i,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-4;i<=0;i++)
			flag=flag&&mycheck(x-i,y+i,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-1;i<=3;i++)
			flag=flag&&mycheck(x-i,y+i,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=0;i<=4;i++)
			flag=flag&&mycheck(x-i,y+i,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-2;i<=2;i++)
			flag=flag&&mycheck(x-i,y,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-3;i<=1;i++)
			flag=flag&&mycheck(x-i,y,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-4;i<=0;i++)
			flag=flag&&mycheck(x-i,y,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-1;i<=3;i++)
			flag=flag&&mycheck(x-i,y,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=0;i<=4;i++)
			flag=flag&&mycheck(x-i,y,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-2;i<=2;i++)
			flag=flag&&mycheck(x,y+i,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-3;i<=1;i++)
			flag=flag&&mycheck(x,y+i,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-4;i<=0;i++)
			flag=flag&&mycheck(x,y+i,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=-1;i<=3;i++)
			flag=flag&&mycheck(x,y+i,wh_arr[x][y]);
		win=win||flag;
		flag=true;
		for(int i=0;i<=4;i++)
			flag=flag&&mycheck(x,y+i,wh_arr[x][y]);
		win=win||flag;
		return win;
	}
	public void insert(int x,int y)
	{
		if(wh_rf==true)
		{
			wh_arr[x][y]=1;
			tmp.showpoint(x, y, wh_rf);
		}
		else
		{
			wh_arr[x][y]=2;
			tmp.showpoint(x, y, wh_rf);
		}
	}
	public void showoutresult(String s)
	{
		tmp.showoutresult(s);
	}
	private mybuf mb = new mybuf();
	public void insertbuf(int x,int y,int t)
	{
		wh_arr[x][y]=t;
		mb.insert(x, y);
	}
	public void erasebuf()
	{
		for(int i=1;i<=mb.k;i++)
			wh_arr[mb.key[i][0]][mb.key[i][1]]=0;
		mb.clear();
	}
	private int []qx=new int[20];
	int [][]dir=new int[4][2];
	public int value(int x,int y,int t)
	{
		wh_arr[x][y]=t;
		if(iswin(x,y)==true) 
		{
			wh_arr[x][y]=0;
			return 5000;
		}
		for(int i=0;i<20;i++) qx[i]=0;
		dir[0][0]=-1;dir[0][1]=-1;
		dir[1][0]=-1;dir[1][1]=1;
		dir[2][0]=0;dir[2][1]=-1;
		dir[3][0]=-1;dir[3][1]=0;
		
		livf(x,y);//0000		2
		deaf1(x,y);//0000x		3
		deaf2(x,y);//0 000		4
		deaf3(x,y);//00 00		5
		livt(x,y);//000		6
		faklivf(x,y);//0 00	7
		deat(x,y);//000x		8
		fakdeaf1(x,y);//0 00x	9
		fakdeaf2(x,y);//00 0x	10
		liv2(x,y);//00			11
		dea2(x,y);//00x		12
		int tmp=0;
		tmp=qx[2]*400+qx[3]*40+(qx[4]+qx[5])*31+qx[6]*20+qx[7]*15+qx[8]*8+(qx[9]+qx[10])*7+qx[11]*3+qx[12];
		if((qx[3]+qx[4]+qx[5])>0&&(qx[6]+qx[7]>0)) tmp+=200;
		if((qx[3]+qx[4]+qx[5])>1) tmp+=300;
		if((qx[6]+qx[7])>1) tmp+=100;
		wh_arr[x][y]=0;
		return tmp;
	}
	private void livf(int x, int y) {
		for(int i=0;i<4;i++)
		{
			for(int j=1;j<=4;j++)
			{
				int sx=x-(j-1)*dir[i][0];
				int sy=y-(j-1)*dir[i][1];
				boolean tmp=true;
				for(int k=1;k<=4;k++)
					tmp=tmp&&mycheck(sx+(k-1)*dir[i][0],sy+(k-1)*dir[i][1],wh_arr[x][y]);
				tmp=tmp&&mycheck(sx-dir[i][0],sy-dir[i][1],0);
				tmp=tmp&&mycheck(sx+4*dir[i][0],sy+4*dir[i][1],0);
				if(tmp==true) qx[2]++;
			}
		}
		
	}

	private void deaf1(int x, int y) {
		for(int i=0;i<4;i++)
		{
			for(int j=1;j<=4;j++)
			{
				int sx=x-(j-1)*dir[i][0];
				int sy=y-(j-1)*dir[i][1];
				boolean tmp=true;
				for(int k=1;k<=4;k++)
					tmp=tmp&&mycheck(sx+(k-1)*dir[i][0],sy+(k-1)*dir[i][1],wh_arr[x][y]);
				tmp=tmp&&(mycheck(sx-dir[i][0],sy-dir[i][1],0)^mycheck(sx+4*dir[i][0],sy+4*dir[i][1],0));
				if(tmp==true) qx[3]++;
			}
		}
		
	}

	private void deaf2(int x, int y) {
		for(int i=0;i<4;i++)
		{
			for(int j=1;j<=5;j++)
			{
				int sx=x-(j-1)*dir[i][0];
				int sy=y-(j-1)*dir[i][1];
				boolean tmp=true;
				for(int k=1;k<=5;k++)
					if(k==2) continue;
					else tmp=tmp&&mycheck(sx+(k-1)*dir[i][0],sy+(k-1)*dir[i][1],wh_arr[x][y]);
				tmp=tmp&&(mycheck(sx+dir[i][0],sy+dir[i][1],0));
				if(tmp==true) qx[4]++;
				tmp=true;
				for(int k=1;k<=5;k++)
					if(k==4) continue;
					else tmp=tmp&&mycheck(sx+(k-1)*dir[i][0],sy+(k-1)*dir[i][1],wh_arr[x][y]);
				tmp=tmp&&(mycheck(sx+3*dir[i][0],sy+3*dir[i][1],0));
				if(tmp==true) qx[4]++;
			}
		}
		
	}

	private void deaf3(int x, int y) {
		for(int i=0;i<4;i++)
		{
			for(int j=1;j<=5;j++)
			{
				int sx=x-(j-1)*dir[i][0];
				int sy=y-(j-1)*dir[i][1];
				boolean tmp=true;
				for(int k=1;k<=5;k++)
					if(k==3) continue;
					else tmp=tmp&&mycheck(sx+(k-1)*dir[i][0],sy+(k-1)*dir[i][1],wh_arr[x][y]);
				tmp=tmp&&(mycheck(sx+2*dir[i][0],sy+2*dir[i][1],0));
				tmp=tmp&&(!mycheck(sx-dir[i][0],sy-dir[i][1],wh_arr[x][y]));
				tmp=tmp&&(!mycheck(sx+5*dir[i][0],sy+5*dir[i][1],wh_arr[x][y]));
				if(tmp==true) qx[5]++;
			}
		}
		
	}

	private void livt(int x, int y) {
		for(int i=0;i<4;i++)
		{
			for(int j=1;j<=3;j++)
			{
				int sx=x-(j-1)*dir[i][0];
				int sy=y-(j-1)*dir[i][1];
				boolean tmp=true;
				for(int k=1;k<=3;k++)
					tmp=tmp&&mycheck(sx+(k-1)*dir[i][0],sy+(k-1)*dir[i][1],wh_arr[x][y]);
				tmp=tmp&&(mycheck(sx-dir[i][0],sy-dir[i][1],0));
				tmp=tmp&&(mycheck(sx+3*dir[i][0],sy+5*dir[i][1],0));
				tmp=tmp&&(!mycheck(sx+4*dir[i][0],sy+4*dir[i][1],wh_arr[x][y]));
				tmp=tmp&&(!mycheck(sx-2*dir[i][0],sy-2*dir[i][1],wh_arr[x][y]));
				if(tmp==true) qx[6]++;
			}
		}
		
	}

	private void faklivf(int x, int y) {
		for(int i=0;i<4;i++)
		{
			for(int j=1;j<=4;j++)
			{
				int sx=x-(j-1)*dir[i][0];
				int sy=y-(j-1)*dir[i][1];
				boolean tmp=true;
				for(int k=1;k<=4;k++)
					if(k!=2)tmp=tmp&&mycheck(sx+(k-1)*dir[i][0],sy+(k-1)*dir[i][1],wh_arr[x][y]);
				tmp=tmp&&mycheck(sx+dir[i][0],sy+dir[i][1],0);
				tmp=tmp&&mycheck(sx+4*dir[i][0],sy+4*dir[i][1],0);
				tmp=tmp&&mycheck(sx-dir[i][0],sy-dir[i][1],0);
				if(tmp==true) qx[7]++;
				tmp=true;
				for(int k=1;k<=4;k++)
					if(k!=3)tmp=tmp&&mycheck(sx+(k-1)*dir[i][0],sy+(k-1)*dir[i][1],wh_arr[x][y]);
				tmp=tmp&&mycheck(sx+2*dir[i][0],sy+2*dir[i][1],0);
				tmp=tmp&&mycheck(sx+4*dir[i][0],sy+4*dir[i][1],0);
				tmp=tmp&&mycheck(sx-dir[i][0],sy-dir[i][1],0);
				if(tmp==true) qx[7]++;
			}
		}
		
	}

	private void deat(int x, int y) {
		for(int i=0;i<4;i++)
		{
			for(int j=1;j<=3;j++)
			{
				int sx=x-(j-1)*dir[i][0];
				int sy=y-(j-1)*dir[i][1];
				boolean tmp=true;
				for(int k=1;k<=3;k++)
					tmp=tmp&&mycheck(sx+(k-1)*dir[i][0],sy+(k-1)*dir[i][1],wh_arr[x][y]);
				if(mycheck(sx-dir[i][0],sy-dir[i][1],3-wh_arr[x][y])==true)
				{
					tmp=tmp&&(mycheck(sx+4*dir[i][0],sy+4*dir[i][1],0));
					tmp=tmp&&(mycheck(sx+3*dir[i][0],sy+3*dir[i][1],0));
				}
				else if(mycheck(sx+3*dir[i][0],sy+3*dir[i][1],3-wh_arr[x][y])==true)
				{
					tmp=tmp&&(mycheck(sx-dir[i][0],sy-dir[i][1],0));
					tmp=tmp&&(mycheck(sx-2*dir[i][0],sy-2*dir[i][1],0));
				}
				else tmp=false;
				if(tmp==true) qx[8]++;
			}
		}
		
	}

	private void fakdeaf1(int x, int y) {
		for(int i=0;i<4;i++)
		{
			for(int j=1;j<=4;j++)
			{
				int sx=x-(j-1)*dir[i][0];
				int sy=y-(j-1)*dir[i][1];
				boolean tmp=true;
				for(int k=1;k<=4;k++)
					if(k!=2)tmp=tmp&&mycheck(sx+(k-1)*dir[i][0],sy+(k-1)*dir[i][1],wh_arr[x][y]);
				tmp=tmp&&mycheck(sx+dir[i][0],sy+dir[i][1],0);
				if(mycheck(sx+4*dir[i][0],sy+4*dir[i][1],0)==true)
				{
					tmp=tmp&&mycheck(sx-dir[i][0],sy-dir[i][1],3-wh_arr[x][y]);
				}
				else if(mycheck(sx-dir[i][0],sy-dir[i][1],3-wh_arr[x][y])==true)
				{
					tmp=tmp&&mycheck(sx+4*dir[i][0],sy+4*dir[i][1],0);
				}
				else tmp=false;
				if(tmp==true) qx[9]++;
			}
		}
		
	}

	private void fakdeaf2(int x, int y) {
		for(int i=0;i<4;i++)
		{
			for(int j=1;j<=4;j++)
			{
				int sx=x-(j-1)*dir[i][0];
				int sy=y-(j-1)*dir[i][1];
				boolean tmp=true;
				for(int k=1;k<=4;k++)
					if(k!=3)tmp=tmp&&mycheck(sx+(k-1)*dir[i][0],sy+(k-1)*dir[i][1],wh_arr[x][y]);
				tmp=tmp&&mycheck(sx+2*dir[i][0],sy+2*dir[i][1],0);
				if(mycheck(sx+4*dir[i][0],sy+4*dir[i][1],0)==true)
				{
					tmp=tmp&&mycheck(sx-dir[i][0],sy-dir[i][1],3-wh_arr[x][y]);
				}
				else if(mycheck(sx-dir[i][0],sy-dir[i][1],3-wh_arr[x][y])==true)
				{
					tmp=tmp&&mycheck(sx+4*dir[i][0],sy+4*dir[i][1],0);
				}
				else tmp=false;
				if(tmp==true) qx[10]++;
			}
		}
		
	}

	private void liv2(int x, int y) {
		for(int i=0;i<4;i++)
		{
			for(int j=1;j<=2;j++)
			{
				int sx=x-(j-1)*dir[i][0];
				int sy=y-(j-1)*dir[i][1];
				boolean tmp=true;
				for(int k=1;k<=2;k++)
					tmp=tmp&&mycheck(sx+(k-1)*dir[i][0],sy+(k-1)*dir[i][1],wh_arr[x][y]);
				tmp=tmp&&mycheck(sx-dir[i][0],sy-dir[i][1],0);
				tmp=tmp&&mycheck(sx+2*dir[i][0],sy+2*dir[i][1],0);
				tmp=tmp&&mycheck(sx-2*dir[i][0],sy-2*dir[i][1],0);
				tmp=tmp&&mycheck(sx+3*dir[i][0],sy+3*dir[i][1],0);
				if(tmp==true) qx[11]++;
			}
		}
		
	}

	private void dea2(int x, int y) {
		for(int i=0;i<4;i++)
		{
			for(int j=1;j<=2;j++)
			{
				int sx=x-(j-1)*dir[i][0];
				int sy=y-(j-1)*dir[i][1];
				boolean tmp=true;
				for(int k=1;k<=2;k++)
					tmp=tmp&&mycheck(sx+(k-1)*dir[i][0],sy+(k-1)*dir[i][1],wh_arr[x][y]);
				if(mycheck(sx-dir[i][0],sy-dir[i][1],3-wh_arr[x][y])==true)
				{
					tmp=tmp&&(mycheck(sx+2*dir[i][0],sy+2*dir[i][1],0));
					tmp=tmp&&(mycheck(sx+3*dir[i][0],sy+3*dir[i][1],0));
				}
				else if(mycheck(sx+2*dir[i][0],sy+2*dir[i][1],3-wh_arr[x][y])==true)
				{
					tmp=tmp&&(mycheck(sx-dir[i][0],sy-dir[i][1],0));
					tmp=tmp&&(mycheck(sx-2*dir[i][0],sy-2*dir[i][1],0));
				}
				else tmp=false;
				if(tmp==true) qx[12]++;
			}
		}
		
	}

	

}
