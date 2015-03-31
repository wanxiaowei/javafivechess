import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class PTCeasy extends JFrame {
	public PTCeasy() {
		final chess wh = new chess();
		wh.clear();
		wh.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (wh.wh_stop == 3) {
					/*for (int i = 0; i < 20; i++) {
						for (int j = 0; j < 20; j++)
							System.out.print(wh.wh_arr[j][i]);
						System.out.println();
					}*/
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
									ba.insert(attack, defence, i, j);
									bd.insert(attack, defence, i, j);
								}
						// int dbug=wh.value(4, 2, 1);
						if (ba.attack >= 5000) {
							x = ba.x;
							y = ba.y;
						} else if (bd.defence >= 5000) {
							x = bd.x;
							y = bd.y;
						} else if (ba.attack >= bd.defence) {
							x = ba.x;
							y = ba.y;
						} else {
							x = bd.x;
							y = bd.y;
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
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	}

}
