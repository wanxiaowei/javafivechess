import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class PTChard extends JFrame {
	public PTChard() {
		final chess wh = new chess();
		wh.clear();
		wh.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (wh.wh_stop == 3) {
					int xx = e.getX();
					int yy = e.getY();
					int x = (xx - 54) / 32;
					int y = (yy - 66) / 32;
					if (xx > 54 && xx < 694 && yy > 66 && yy < 706) {
						if (wh.wh_arr[x][y] == 0) {
							wh.wh_rf = !wh.wh_rf;
							wh.insert(x, y);
							if (wh.iswin(x, y) == true) {
								wh.showoutresult("黑棋胜利");
								wh.wh_stop = 0;
								return;
							}
						}
					}
					if (wh.wh_rf == true) {
						bestattack ba = new bestattack();
						bestdefence bd = new bestdefence();
						ba.clear();
						bd.clear();
						for (int i = 0; i < 20; i++)
							for (int j = 0; j < 20; j++)
								if (wh.wh_arr[i][j] == 0) {
									int attack = wh.value(i, j, 2);
									int defence = wh.value(i, j, 1);
									if(attack==0&&defence==0) continue;
									if(attack>=5000)
									{
										ba.insert(100000, defence, i, j);
										wh.erasebuf();
										continue;
									}
									if(defence>=5000)
									{
										bd.insert(attack, defence, i, j);
										wh.erasebuf();
										continue;
									}
									wh.insertbuf(i, j, 2);
									int tmp=0;
									int flag=1;
									while(tmp<5){
										tmp++;
										bestattack batmp = new bestattack();
										bestdefence bdtmp = new bestdefence();
										batmp.clear();
										bdtmp.clear();
										for (int ki = 0; ki < 20; ki++)
											for (int kj = 0; kj < 20; kj++)
												if (wh.wh_arr[ki][kj] == 0) {
													int tmpattack = wh.value(ki,kj,1);
													int tmpdefence = wh.value(ki, kj, 2);
													batmp.insert(tmpattack, tmpdefence, ki, kj);
													bdtmp.insert(tmpattack,tmpdefence, ki, kj);
												}
										if (batmp.attack >= 5000) {
											x = batmp.x;
											y = batmp.y;
										} else if (bdtmp.defence >= 5000) {
											x = bdtmp.x;
											y = bdtmp.y;
										} else if (batmp.attack >= bdtmp.defence) {
											x = batmp.x;
											y = batmp.y;
										} else {
											x = bdtmp.x;
											y = bdtmp.y;
										}
										wh.insertbuf(x, y, 1);
										if(wh.iswin(x, y)==true)
										{
											flag=0;
											break;
										}
										
										batmp.clear();
										bdtmp.clear();
										for (int ki = 0; ki < 20; ki++)
											for (int kj = 0; kj < 20; kj++)
												if (wh.wh_arr[ki][kj] == 0) {
													int tmpattack = wh.value(ki,kj,2);
													int tmpdefence = wh.value(ki, kj, 1);
													batmp.insert(tmpattack, tmpdefence, ki, kj);
													bdtmp.insert(tmpattack,tmpdefence, ki, kj);
												}
										if (batmp.attack >= 5000) {
											x = batmp.x;
											y = batmp.y;
										} else if (bdtmp.defence >= 5000) {
											x = bdtmp.x;
											y = bdtmp.y;
										} else if (batmp.attack >= bdtmp.defence) {
											x = batmp.x;
											y = batmp.y;
										} else {
											x = bdtmp.x;
											y = bdtmp.y;
										}
										wh.insertbuf(x, y, 2);
										if(wh.iswin(x, y)==true)
										{
											attack=5000;
											flag=2;
											break;
										}
									}
									wh.erasebuf();
									if(flag==2)
									{
										ba.insert(5000, defence, i, j);
									}
									else if(flag==1)
									{
										ba.insert(attack, defence, i, j);
										bd.insert(attack, defence, i, j);
									}
									else if(ba.empty()&&bd.empty())
									{
										ba.insert(attack/10, defence/10, x, y);
										bd.insert(attack/10, defence/10, x, y);
									}
								}
						if(ba.attack>=5000)
						{
							x=ba.x;
							y=ba.y;
						}
						else if(bd.defence>=5000)
						{
							x=bd.x;
							y=bd.y;
						}
						else if(ba.attack>bd.defence)
						{
							x=ba.x;
							y=ba.y;
						}
						else
						{
							x=bd.x;
							y=bd.y;
						}
						wh.wh_rf = !wh.wh_rf;
						wh.insert(x, y);
						if (wh.iswin(x, y) == true) {
							wh.showoutresult("白棋胜利");
							wh.wh_stop = 0;
							return;
						}
					}
				}

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		wh.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stubd
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	}
}
