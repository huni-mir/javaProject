package view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import model.*;

public class GamePanel extends JPanel {
	private ImageIcon MainGame = new ImageIcon("img/background/inGame.png");
	private Vector<JLabel> blockItem = new Vector<JLabel>();
	private ArrayList<JLabel> blockitemlist = new ArrayList<JLabel>();
	private ImageIcon[] item = { new ImageIcon("img/speed_up.png"), new ImageIcon("img/range_up.png"),
			new ImageIcon("img/heart_up.png"), new ImageIcon("img/bomb_up.png"), null };
	JLabel itemLabel;
	Random random = new Random();
	ImageIcon item1;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(MainGame.getImage(), 0, 0, getWidth(), getHeight(), this);
	}

	private ImageIcon front1p, back1p, left1p, right1p, dieimg1p;
	private ImageIcon front2p, back2p, left2p, right2p, dieimg2p;

	int limitMinX = -23;
	int limitMaxX = 797;
	int limitMinY = 3;
	int limitMaxY = 1124;

	// 1P 능력치
	private int char1P = 0; // 1P 체력
	private int speed1P = 0; // 1P 스피드
	private int bomb1P = 0; // 1P 폭탄 갯수
	private int range1P = 0; // 1P 폭탄 범위

	// 2P 능력치
	private int char2P = 0; // 2P 체력
	private int speed2P = 0; // 2P 스피드
	private int bomb2P = 0; // 2P 폭탄 갯수
	private int range2P = 0; // 2P 폭탄 범위

	boolean bombcheck1P = true;
	boolean bombcheck2P = true;

	int x;
	int y;
	int bx1P, by1P, bx2P, by2P;

	private JLabel c1p; // p1 -> 방향키
	private JLabel c2p; // p2 -> ASDW

	boolean keyQ = false;
	boolean keyW = false;
	boolean keyE = false;
	boolean keyR = false;
	boolean keyT = false;

	boolean keyY = false;
	boolean keyU = false;
	boolean keyI = false;
	boolean keyO = false;
	boolean keyP = false;
	
	boolean die1 = false;
	boolean die2 = false;

	private int p1X;
	private int p2X;
	private int p1Y;
	private int p2Y;

	private boolean[] char1Key = new boolean[256];
	private boolean[] char2Key = new boolean[256];

	JLabel bc1p = new JLabel(new ImageIcon("img/bomb/bomb_explode1.gif"));
	JLabel bvup1p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Vertical1.png"));
	JLabel bhright1p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Horizontal1.png"));
	JLabel bvdown1p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Vertical1.png"));
	JLabel bhleft1p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Horizontal1.png"));
	JLabel bombLabel1p = new JLabel(new ImageIcon("img/bomb/bomb1.png"));

	JLabel bc2p = new JLabel(new ImageIcon("img/bomb/bomb_explode2.gif"));
	JLabel bvup2p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Vertical2.png"));
	JLabel bhright2p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Horizontal2.png"));
	JLabel bvdown2p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Vertical2.png"));
	JLabel bhleft2p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Horizontal2.png"));
	JLabel bombLabel2p = new JLabel(new ImageIcon("img/bomb/bomb2.png"));

	public GamePanel() {
	}

	   public void Die1() {
		      if(die1==true) {
		    	  keyQ = false;
		    		 keyW = false;
		    		 keyE = false;
		    		 keyR = false;
		         JOptionPane.showMessageDialog(null, "게임 끝!");
	         die1=false;
	         
		        // dispose();
		         
		      }
		   }
	   Runnable gameover1 = new Runnable() {
		   
		   		      @Override
		   		      public void run() {
		   		         while (true) {
		   		            Die1();
		   		            try {
		   		               Thread.sleep(20);
		   		            } catch (InterruptedException e) {
		   		               // TODO Auto-generated catch block
		   		               e.printStackTrace();
		   		            }
		   		         }
		   		      }
		   		   };
		   		   
		   		public void Die2() {
				      if(die2==true) {
				    	   keyY = false;
				    		 keyU = false;
				    		keyI = false;
				    		keyO = false;
				         JOptionPane.showMessageDialog(null, "게임 끝!");
			         die2=false;
			         
				        // dispose();
				         
				      }
				   }
			   Runnable gameover2 = new Runnable() {
				   
				   		      @Override
				   		      public void run() {
				   		         while (true) {
				   		            Die2();
				   		            try {
				   		               Thread.sleep(20);
				   		            } catch (InterruptedException e) {
				   		               // TODO Auto-generated catch block
				   		               e.printStackTrace();
				   		            }
				   		         }
				   		      }
				   		   };
		  
	   public void c1pCheckLocation() {
			  if((p1X>bx1P-65 && p1X<bx1P+60) &&(p1Y>by1P-40 &&p1Y<by1P+20)) {
			         die1 = true;
			         
			      }
			      else if((p1X>bx1P-100 && p1X<bx1P+100) &&(p1Y>by1P-100 &&p1Y<by1P+100)) {
			         die1 = true;
			      
			      }
			  if((p1X>bx2P-100 && p1X<bx2P+100) &&(p1Y>by2P-100 &&p1Y<by2P+100)) {
			         die1 = true;
			      
			      }
			      else if((p1X>bx2P-100 && p1X<bx2P+100) &&(p1Y>by2P-100 &&p1Y<by2P+100)) {
			         die1 = true;
			      
			      }
			
		
		for (int i = 0; i < blockItem.size(); i++) {
			checkDirection(bx1P + 75, by1P, i);
			checkDirection(bx1P, by1P + 75, i);
			checkDirection(bx1P - 75, by1P, i);
			checkDirection(bx1P, by1P - 75, i);
		}
	}
	   

	public void c2pCheckLocation() {
		
		if((p2X>bx2P-65 && p2X<bx2P+60) &&(p2Y>by2P-40 &&p2Y<by2P+20)) {
	         die2 = true;
	         
	      }
	      else if((p2X>bx2P-100 && p2X<bx2P+100) &&(p2Y>by2P-100 &&p2Y<by2P+100)) {
	         die2 = true;
	      
	      }
	  if((p2X>bx1P-100 && p2X<bx1P+100) &&(p2Y>by1P-100 &&p2Y<by1P+100)) {
	         die1 = true;
	      
	      }
	      else if((p2X>bx1P-100 && p2X<bx1P+100) &&(p2Y>by1P-100 &&p2Y<by1P+100)) {
	         die1 = true;
	      
	      }
		
		for (int i = 0; i < blockItem.size(); i++) {
			checkDirection(bx2P + 75, by2P, i);
			checkDirection(bx2P, by2P + 75, i);
			checkDirection(bx2P - 75, by2P, i);
			checkDirection(bx2P, by2P - 75, i);
		}
	}

	private void checkDirection(int x, int y, int i) {
		for (int j = 0; j < blockItem.size(); j++) {
			if ((x >= blockItem.get(j).getX() && x <= blockItem.get(j).getX())
					&& (y >= blockItem.get(j).getY() && y <= blockItem.get(j).getY())) {
				blockItem.get(j).setIcon(null);

				item1 = item[random.nextInt(5)];
				itemLabel = new JLabel(item1);
				itemLabel.setLocation(blockItem.get(j).getX(), blockItem.get(j).getY());
				itemLabel.setSize(75, 75);
				add(itemLabel);
				blockitemlist.add(itemLabel);
				blockItem.remove(j);
			}
		}
	}

	public void BombDrop1p(int x1P, int y1P) {
		this.x = x1P;
		this.y = y1P;

		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				x = ((x + 37) / 75) * 75;
				if (y < 5) {
					y = -75;
				} else
					y = (y / 75) * 75;

				bombLabel1p.setSize(75, 75);
				bombLabel1p.setLocation(x, y + 75);
				bombLabel1p.setVisible(true);
				add(bombLabel1p);

				bx1P = x;
				by1P = y + 75;
				try {
					Thread.sleep(2000);
					bombLabel1p.setVisible(false);

					bc1p.setSize(75, 75);
					bc1p.setLocation(bx1P, by1P);
					bc1p.setVisible(true);
					add(bc1p);
					bvup1p.setSize(75, 75);
					bvup1p.setLocation(bx1P, by1P - 75);
					bvup1p.setVisible(true);
					add(bvup1p);
					bhright1p.setSize(75, 75);
					bhright1p.setLocation(bx1P + 75, by1P);
					bhright1p.setVisible(true);
					add(bhright1p);
					bvdown1p.setSize(75, 75);
					bvdown1p.setLocation(bx1P, by1P + 75);
					bvdown1p.setVisible(true);
					add(bvdown1p);
					bhleft1p.setSize(75, 75);
					bhleft1p.setLocation(bx1P - 75, by1P);
					bhleft1p.setVisible(true);
					add(bhleft1p);
					Thread.sleep(1000);
					bc1p.setVisible(false);
					bvup1p.setVisible(false);
					bhright1p.setVisible(false);
					bvdown1p.setVisible(false);
					bhleft1p.setVisible(false);

					c1pCheckLocation();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(runnable).start();
	}

	Runnable pop1p = new Runnable() {

		@Override
		public void run() {
			if (bombcheck1P) {

				BombDrop1p(p1X, p1Y);
				bombcheck1P = false;

				try {
					Thread.sleep(3000);
					bombcheck1P = true;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};

	public void BombDrop2p(int x2P, int y2P) {
		this.x = x2P;
		this.y = y2P;

		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				x = ((x + 37) / 75) * 75;
				if (y < 5) {
					y = -75;
				} else
					y = (y / 75) * 75;

				bombLabel2p.setSize(75, 75);
				bombLabel2p.setLocation(x, y + 75);
				bombLabel2p.setVisible(true);
				add(bombLabel2p);

				bx2P = x;
				by2P = y + 75;
				try {
					Thread.sleep(2000);
					bombLabel2p.setVisible(false);

					bc2p.setSize(75, 75);
					bc2p.setLocation(bx2P, by2P);
					bc2p.setVisible(true);
					add(bc2p);
					bvup2p.setSize(75, 75);
					bvup2p.setLocation(bx2P, by2P - 75);
					bvup2p.setVisible(true);
					add(bvup2p);
					bhright2p.setSize(75, 75);
					bhright2p.setLocation(bx2P + 75, by2P);
					bhright2p.setVisible(true);
					add(bhright2p);
					bvdown2p.setSize(75, 75);
					bvdown2p.setLocation(bx2P, by2P + 75);
					bvdown2p.setVisible(true);
					add(bvdown2p);
					bhleft2p.setSize(75, 75);
					bhleft2p.setLocation(bx2P - 75, by2P);
					bhleft2p.setVisible(true);
					add(bhleft2p);
					Thread.sleep(1000);
					bc2p.setVisible(false);
					bvup2p.setVisible(false);
					bhright2p.setVisible(false);
					bhleft2p.setVisible(false);
					bvdown2p.setVisible(false);

					c2pCheckLocation();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(runnable).start();
	}

	Runnable pop2p = new Runnable() {
		@Override
		public void run() {
			if (bombcheck2P) {

				BombDrop2p(p2X, p2Y);
				bombcheck2P = false;

				try {
					Thread.sleep(3000);
					bombcheck2P = true;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};

	public void processInput1() {
		p1X = c1p.getX();
		p1Y = c1p.getY();

		for (int i = 0; i < blockItem.size(); i++) {
			if ((p1X > blockItem.get(i).getX() - 72 && p1X < blockItem.get(i).getX() + 75)
					&& (p1Y > blockItem.get(i).getY() && p1Y <= blockItem.get(i).getY() + 50)) {
				keyQ = false;
				continue;
			} else if ((p1X > blockItem.get(i).getX() - 72 && p1X < blockItem.get(i).getX() + 75)
					&& (p1Y >= blockItem.get(i).getY() - 100 && p1Y < blockItem.get(i).getY())) {
				keyW = false;
				continue;
			} else if ((p1X > blockItem.get(i).getX() && p1X <= blockItem.get(i).getX() + 75)
					&& (p1Y > blockItem.get(i).getY() - 100 && p1Y < blockItem.get(i).getY() + 50)) {
				keyE = false;
				continue;
			} else if ((p1X >= blockItem.get(i).getX() - 75 && p1X < blockItem.get(i).getX())
					&& (p1Y > blockItem.get(i).getY() - 100 && p1Y < blockItem.get(i).getY() + 50)) {
				keyR = false;
				continue;
			}
		}

		// 1P
		if (keyQ == true) { // 위
			if (p1Y >= limitMinX) {
				c1p.setIcon(back1p);
				c1p.setLocation(p1X, p1Y - 3);
			}
		}
		if (keyW == true) { // 아래
			if (p1Y <= limitMaxX) {
				c1p.setIcon(front1p);
				c1p.setLocation(p1X, p1Y + 3);
			}
		}
		if (keyE == true) { // 왼
			if (p1X >= limitMinY) {
				c1p.setIcon(left1p);
				c1p.setLocation(p1X - 3, p1Y);
			}
		}
		if (keyR == true) { // 오
			if (p1X <= limitMaxY) {
				c1p.setIcon(right1p);
				c1p.setLocation(p1X + 3, p1Y);
			}
		}
	}

	Runnable run1p = new Runnable() {

		@Override
		public void run() {
			while (true) {
				processInput1();

				repaint();
				try {
					Thread.sleep(20);// 최고 이동속도는 10으로 설정
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	public void processInput2() {
		p2X = c2p.getX();
		p2Y = c2p.getY();

		for (int i = 0; i < blockItem.size(); i++) {
			if ((p2X > blockItem.get(i).getX() - 72 && p2X < blockItem.get(i).getX() + 75)
					&& (p2Y > blockItem.get(i).getY() && p2Y <= blockItem.get(i).getY() + 50)) {
				keyY = false;
				continue;
			} else if ((p2X > blockItem.get(i).getX() - 72 && p2X < blockItem.get(i).getX() + 75)
					&& (p2Y >= blockItem.get(i).getY() - 100 && p2Y < blockItem.get(i).getY())) {
				keyU = false;
				continue;
			} else if ((p2X > blockItem.get(i).getX() && p2X <= blockItem.get(i).getX() + 75)
					&& (p2Y > blockItem.get(i).getY() - 100 && p2Y < blockItem.get(i).getY() + 50)) {
				keyI = false;
				continue;
			} else if ((p2X >= blockItem.get(i).getX() - 75 && p2X < blockItem.get(i).getX())
					&& (p2Y > blockItem.get(i).getY() - 100 && p2Y < blockItem.get(i).getY() + 50)) {
				keyO = false;
				continue;
			}
		}

		// 2P
		if (keyY == true) {
			if (p2Y >= limitMinX) {
				c2p.setIcon(back2p);
				c2p.setLocation(p2X, p2Y - 3);
			}
		}
		if (keyU == true) { // 아래
			if (p2Y <= limitMaxX) {
				c2p.setIcon(front2p);
				c2p.setLocation(p2X, p2Y + 3);
			}
		}
		if (keyI == true) { // 왼
			if (p2X >= limitMinY) {
				c2p.setIcon(left2p);
				c2p.setLocation(p2X - 3, p2Y);
			}
		}
		if (keyO == true) {
			if (p2X <= limitMaxY) {
				c2p.setIcon(right2p);
				c2p.setLocation(p2X + 3, p2Y);
			}
		}
	}

	Runnable run2p = new Runnable() {

		@Override
		public void run() {
			while (true) {
				processInput2();

				repaint();
				try {
					Thread.sleep(10);// 최고 이동속도는 10으로 설정
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	public void gameSet(CaricValue1p getcv1P, CaricValue2p getcv2P) {
		setFocusable(true);

		initCharImg1p(getcv1P);
		initCharImg2p(getcv2P);

		// P1
		c1p = new JLabel(front1p);
		this.add(c1p);
		c1p.setBounds(75, 50, 73, 100);
		// P2
		c2p = new JLabel(front2p);
		this.add(c2p);
		c2p.setBounds(1050, 725, 73, 100);
		initMap();

		new Thread(run1p).start();
		new Thread(run2p).start();
		new Thread(gameover1).start();
		new Thread(gameover2).start();
		initListener();
	}

	private void initCharImg1p(CaricValue1p cv1p) {
		front1p = cv1p.getFront1P();
		back1p = cv1p.getBack1P();
		left1p = cv1p.getLeft1P();
		right1p = cv1p.getRight1P();
		dieimg1p = cv1p.getDieimg1P();

		char1P = cv1p.getChar1P(); // 1P 체력
		speed1P = cv1p.getChar1P(); // 1P 스피드
		bomb1P = cv1p.getChar1P(); // 1P 폭탄 갯수
		range1P = cv1p.getChar1P(); // 1P 폭탄 범위

	}

	private void initCharImg2p(CaricValue2p cv2p) {
		front2p = cv2p.getFront2P();
		back2p = cv2p.getBack2P();
		left2p = cv2p.getLeft2P();
		right2p = cv2p.getRight2P();
		dieimg2p = cv2p.getDieimg2P();

		char2P = cv2p.getChar2P(); // 2P 체력
		speed2P = cv2p.getChar2P(); // 2P 스피드
		bomb2P = cv2p.getChar2P(); // 2P 폭탄 갯수
		range2P = cv2p.getChar2P(); // 2P 폭탄 범위
	}

	private void initMap() {
		setLayout(null);
		BlockSet blockSet = new BlockSet(16, 12);
		{
			for (int i = 0; i < blockSet.size; i++) {
				for (int j = 0; j < blockSet.size1; j++) {
					blockSet.map[i][j] = "1";
					String block = blockSet.map[i][j];
					if (i < 3 && j == 0 || ((i > 12 && i < 16) && j == 0)/* 1번쨰열 */
							|| i < 1 && j == 1 || ((i > 14 && i < 16) && j == 1)/* 2번쨰열 */
							|| i < 1 && j == 10 || ((i > 14 && i < 16) && j == 10)/* 11번쨰열 */
							|| i < 3 && j == 11 || ((i > 12 && i < 16) && j == 11)/* 12번쨰열 */) {
						JLabel blockred = new JLabel(new ImageIcon("img/block/RedBlock.png"));
						blockItem.add(blockred);
						this.add(blockred);
						blockred.setBounds(i * 75, j * 75, 75, 75);
					} else if (i < 3 && j == 3 /* 4번쨰열 */
							|| (i < 2 && i > 0) && (j > 3 && j < 7)/* 5,6,7번쨰열 */
							|| i < 2 && j == 7 /* 8번쨰열 */) {
						JLabel blocksky = new JLabel(new ImageIcon("img/block/SkyBlock.png"));
						blockItem.add(blocksky);
						this.add(blocksky);
						blocksky.setBounds(i * 75, j * 75, 75, 75);// J
					} else if ((i > 3 && i < 6) && j == 3 /* 4번쨰열 */
							|| i == 3 && j == 4 || i == 6 && j == 4 /* 5번쨰열 */
							|| (i > 2 && i < 7) && j == 5 /* 6번쨰열 */
							|| i == 3 && j == 6 || i == 6 && j == 6 /* 7번쨰열 */
							|| i == 3 && j == 7 || i == 6 && j == 7 /* 8번쨰열 */) {
						JLabel blockpink = new JLabel(new ImageIcon("img/block/PinkBlock.png"));
						blockItem.add(blockpink);
						this.add(blockpink);
						blockpink.setBounds(i * 75, j * 75, 75, 75);// A
					} else if (i == 7 && j == 3 || i == 11 && j == 3 /* 4번쨰열 */
							|| i == 7 && j == 4 || i == 11 && j == 4 /* 5번쨰열 */
							|| i == 7 && j == 5 || i == 11 && j == 5 /* 6번쨰열 */
							|| i == 8 && j == 6 || i == 10 && j == 6 /* 7번쨰열 */
							|| i == 9 && j == 7 /* 8번쨰열 */) {
						JLabel blockblue = new JLabel(new ImageIcon("img/block/BlueBlock.png"));
						blockItem.add(blockblue);
						this.add(blockblue);
						blockblue.setBounds(i * 75, j * 75, 75, 75);// V
					} else if ((i > 12 && i < 15) && j == 3 /* 4번쨰열 */
							|| i == 12 && j == 4 || i == 15 && j == 4 /* 5번쨰열 */
							|| (i > 11 && i < 16) && j == 5 /* 6번쨰열 */
							|| i == 12 && j == 6 || i == 15 && j == 6 /* 7번쨰열 */
							|| i == 12 && j == 7 || i == 15 && j == 7 /* 8번쨰열 */) {
						JLabel blockpuple = new JLabel(new ImageIcon("img/block/PupleBlock.png"));
						blockItem.add(blockpuple);
						this.add(blockpuple);
						blockpuple.setBounds(i * 75, j * 75, 75, 75);// A

					}
				}

			}

		}
	}

	// 리스너 추가 메서드
	private void initListener() {
		addKeyListener(new KeyAdapter() { // 키 리스너 추가

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				int keyLocation = e.getKeyLocation();

				switch (keyCode) {
				case KeyEvent.VK_R:
					keyQ = true;
					break;
				case KeyEvent.VK_F:
					keyW = true;
					break;
				case KeyEvent.VK_D:
					keyE = true;
					break;
				case KeyEvent.VK_G:
					keyR = true;
					break;

				case KeyEvent.VK_UP:
					keyY = true;
					break;
				case KeyEvent.VK_DOWN:
					keyU = true;
					break;
				case KeyEvent.VK_LEFT:
					keyI = true;
					break;
				case KeyEvent.VK_RIGHT:
					keyO = true;
					break;

				case KeyEvent.VK_SHIFT:
					if (keyLocation == KeyEvent.KEY_LOCATION_LEFT) {
						new Thread(pop1p).start();
					} else if (keyLocation == KeyEvent.KEY_LOCATION_RIGHT) {
						new Thread(pop2p).start();
					}
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();

				switch (keyCode) {
				case KeyEvent.VK_R:
					keyQ = false;
					break;
				case KeyEvent.VK_F:
					keyW = false;
					break;
				case KeyEvent.VK_D:
					keyE = false;
					break;
				case KeyEvent.VK_G:
					keyR = false;
					break;

				case KeyEvent.VK_UP:
					keyY = false;
					break;
				case KeyEvent.VK_DOWN:
					keyU = false;
					break;
				case KeyEvent.VK_LEFT:
					keyI = false;
					break;
				case KeyEvent.VK_RIGHT:
					keyO = false;
					break;

				}
			}
		});

	}
}