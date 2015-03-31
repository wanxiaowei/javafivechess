import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class mainmenu extends JFrame{
	public mainmenu()
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
		JButton b1=new JButton("人人对战");
		JButton b2=new JButton("人机对战");
		JButton b3=new JButton("退出");
		b1.setBounds(224, 250, 300, 50);
		b2.setBounds(224, 350, 300, 50);
		b3.setBounds(224, 450, 300, 50);
		c.add(b1);
		c.add(jl);
		c.add(b2);
		c.add(b3);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		b1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PTPmenu();
				
			}
			
		});
		b2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PTCmenu();
				
			}
			
		});
		b3.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				int response=JOptionPane.showConfirmDialog(null, "是否确认退出","Confirm exit",JOptionPane.YES_NO_OPTION);
				if(response==0) System.exit(0);
			}
			
		});
	}
	public static void main(String agrs[])
	{
		new mainmenu();
	}
}
