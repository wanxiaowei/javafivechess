import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class PTPonline extends JFrame implements ActionListener{
	private DataInputStream din=null;
	private DataOutputStream dout=null;
	JButton create,join;
	boolean isstart=false,isyourturn=false;
	int isblack;
	chess wh;
	private static Thread t;
	private class MouseHandler extends MouseAdapter
	{

		@Override
		public void mousePressed(MouseEvent e) {
			if(isstart&&isyourturn&&wh.wh_stop==3)
			{
				int xx=e.getX();
				int yy=e.getY();
				int x=(xx-54)/32;
				int y=(yy-66)/32;
				if(xx>54&&xx<694&&yy>66&&yy<706)
				{
					if(wh.wh_arr[x][y]==0)
					{
						wh.wh_rf=isblack==1?true:false;
						wh.insert(x,y);
						repaint();
						if(wh.iswin(x, y)==true)
						{
							if(wh.wh_rf==true) wh.showoutresult("黑棋获胜");
							else wh.showoutresult("白棋获胜");
							repaint();
							if(isblack==1) isyourturn=true;
							else isyourturn=false;
							wh.wh_stop=0;
						}
						else isyourturn=!isyourturn;
						try
						{
							dout.writeInt(x);
							dout.writeInt(y);
						}
						catch(IOException ex)
						{
							ex.printStackTrace();
						}
					}
				}
			}
			
		}

	}
	public PTPonline()
	{
		setTitle("五子棋");
		setLayout(null);
		setBounds(0,0,748,728);
		Container c=getContentPane();
		c.setBackground(Color.gray);
		JLabel jl=new JLabel("五子棋");
		jl.setSize(400, 100);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setBounds(174, 100, 400, 100);
		create=new JButton("创建游戏");
		join=new JButton("加入游戏");
		JButton back=new JButton("返回");
		create.setBounds(224, 250, 300, 50);
		join.setBounds(224, 400, 300, 50);
		back.setBounds(578, 20, 100, 20);
		c.add(create);
		c.add(jl);
		c.add(join);
		c.add(back);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		create.addActionListener(this);
		join.addActionListener(this);
		back.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new mainmenu();
				
			}
			
		});
		t=new Thread(new Runnable()
		{

			@Override
			public void run() {
				while(true)
				{
					System.out.println("gogogo111");
					if (isstart&&!isyourturn)
					{
						//System.out.println("gogogo");
						try
						{
							int row=din.readInt();
							int col=din.readInt();
							wh.wh_rf=isblack==1?false:true;
							wh.insert(row, col);
							repaint();
							if(wh.iswin(row, col))
							{
								if(isblack==2) wh.showoutresult("黑棋胜利");
								else wh.showoutresult("白棋胜利");
								wh.wh_stop=0;
								repaint();
								if(isblack==1) isyourturn=false;
								else isyourturn=true;
							}
							isyourturn=!isyourturn;
						}
						catch(IOException ex)
						{
							ex.printStackTrace();
						}
						
					}
				}
				
			}
			
		});
		t.start();
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("创建游戏"))
		{
			new Thread(new Runnable()
			{

				@Override
				public void run() {
					try{
						ServerSocket server=new ServerSocket(5566);
						Socket client=server.accept();
						din=new DataInputStream(client.getInputStream());
						dout=new DataOutputStream(client.getOutputStream());
						isstart=true;
						isblack=1;
						isyourturn=true;
						wh=new chess();
						wh.addMouseListener(new MouseHandler());
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
					
				}
				
			}).start();
			join.setEnabled(false);
		}
		else if(command.equals("加入游戏"))
		{
			String ip=JOptionPane.showInputDialog("请输入主机的ip");
			if(ip!=null&&ip!="")
			{
				try
				{
					Socket client=new Socket(ip,5566);
					din=new DataInputStream(client.getInputStream());
					dout=new DataOutputStream(client.getOutputStream());
					isstart=true;
					isblack=2;
					isyourturn=false;
					wh=new chess();
					wh.addMouseListener(new MouseHandler());
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				repaint();
				create.setEnabled(false);
			}
		}
	}

}
