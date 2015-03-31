import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class PTPmenu extends JFrame{
	public PTPmenu()
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
		JButton b1=new JButton("单机对战");
		JButton b2=new JButton("联网对战");
		JButton back=new JButton("返回");
		b1.setBounds(224, 250, 300, 50);
		b2.setBounds(224, 400, 300, 50);
		back.setBounds(578, 20, 100, 20);
		c.add(b1);
		c.add(jl);
		c.add(b2);
		c.add(back);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		b1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new PTPself();
				
			}
			
		});
		b2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PTPonline();
				
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
	}
}
