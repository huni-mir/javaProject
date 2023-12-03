package view;

import java.awt.*;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import model.*;

public class GamePanel extends JPanel {
	private ImageIcon MainGame = new ImageIcon("img/background/inGame.png");

	private ImageIcon speed_up = new ImageIcon("img/item/speed_up.png");
	private ImageIcon bomb_up = new ImageIcon("img/item/bomb_up.png");
	private ImageIcon heart_up = new ImageIcon("img/item/heart_up.png");
	private ImageIcon range_up = new ImageIcon("img/item/range_up.png");

	private JLabel bc1p = new JLabel(new ImageIcon("img/bomb/bomb_explode1.gif"));
	private JLabel bvup1p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Vertical1.png"));
	private JLabel bhright1p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Horizontal1.png"));
	private JLabel bvdown1p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Vertical1.png"));
	private JLabel bhleft1p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Horizontal1.png"));
	private JLabel bombLabel1p = new JLabel(new ImageIcon("img/bomb/bomb1.png"));

	private JLabel bc2p = new JLabel(new ImageIcon("img/bomb/bomb_explode2.gif"));
	private JLabel bvup2p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Vertical2.png"));
	private JLabel bhright2p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Horizontal2.png"));
	private JLabel bvdown2p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Vertical2.png"));
	private JLabel bhleft2p = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Horizontal2.png"));
	private JLabel bombLabel2p = new JLabel(new ImageIcon("img/bomb/bomb2.png"));

	private JButton restartBtn = new JButton(new ImageIcon("img/button/restart.png"));
	private ImageIcon restartSelect = new ImageIcon("img/button/restartSelect.png");

	private JLabel win1p = new JLabel(new ImageIcon("img/button/gameover_1p_win.png"));
	private JLabel win2p = new JLabel(new ImageIcon("img/button/gameover_2p_win.png"));

	private Vector<JLabel> blockItem = new Vector<JLabel>();
	private ArrayList<JLabel> blockitemlist = new ArrayList<JLabel>();

	private ImageIcon[] item = { speed_up, range_up, null, speed_up, null, heart_up, speed_up, bomb_up };
	private JLabel itemLabel;
	private Random random = new Random();
	private ImageIcon item1;

	private ImageIcon front1p, back1p, left1p, right1p, dieimg1p;
	private ImageIcon front2p, back2p, left2p, right2p, dieimg2p;

	private int[] itemCode = new int[60];
	private int count = 0;

	// 프레임 밖으로 못나가게 하는 상수 값
	private final int limitMinX = -23;
	private final int limitMaxX = 797;
	private final int limitMinY = 3;
	private final int limitMaxY = 1124;

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

	private boolean bombcheck1P = true;
	private boolean bombcheck2P = true;

	private int x;
	private int y;
	private int bx1P, by1P, bx2P, by2P;

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

	private int p1X;
	private int p2X;
	private int p1Y;
	private int p2Y;

	private boolean die1 = false;
	private boolean die2 = false;

	private int speed1 = 25;
	private int speed2 = 25;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(MainGame.getImage(), 0, 0, getWidth(), getHeight(), this);
	}

	public GamePanel(Object o) {
		restartBtn.addActionListener((ActionListener) o);
	}

	public void Die() { // Die true 게임 오버
		if (die1 == true) {
			c1p.setIcon(dieimg1p);

			win2p.setVisible(true);
			restartBtn.setVisible(true);

			keyQ = false;
			keyW = false;
			keyE = false;
			keyR = false;
			keyT = false;

			keyY = false;
			keyU = false;
			keyI = false;
			keyO = false;
			keyP = false;

			setFocusable(false);
			die1 = false;
		} else if (die2 == true) {
			c2p.setIcon(dieimg2p);

			win1p.setVisible(true);
			restartBtn.setVisible(true);

			keyQ = false;
			keyW = false;
			keyE = false;
			keyR = false;
			keyT = false;

			keyY = false;
			keyU = false;
			keyI = false;
			keyO = false;
			keyP = false;

			setFocusable(false);
			die2 = false;
		}
	}

	Runnable gameover = new Runnable() {

		@Override
		public void run() {
			while (true) {
				Die();
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	public void c1pCheckLocation() { // 1p 피격 판정
		if ((p1X > bx1P - 65 && p1X < bx1P + 60) && (p1Y > by1P - 40 && p1Y < by1P + 20)) {
			die1 = true;

		} else if ((p1X > bx1P - 100 && p1X < bx1P + 100) && (p1Y > by1P - 100 && p1Y < by1P + 100)) {
			die1 = true;

		}

		if ((p2X > bx1P - 100 && p2X < bx1P + 100) && (p2Y > by1P - 100 && p2Y < by1P + 100)) {
			die2 = true;

		} else if ((p2X > bx1P - 100 && p2X < bx1P + 100) && (p2Y > by1P - 100 && p2Y < by1P + 100)) {
			die2 = true;

		}

		for (int i = 0; i < blockItem.size(); i++) {
			checkDirection(bx1P + 75, by1P, i);
			checkDirection(bx1P, by1P + 75, i);
			checkDirection(bx1P - 75, by1P, i);
			checkDirection(bx1P, by1P - 75, i);
		}

	}

	public void c2pCheckLocation() { // 2p 피격 판정
		if ((p2X > bx2P - 65 && p2X < bx2P + 60) && (p2Y > by2P - 40 && p2Y < by2P + 20)) {
			die2 = true;

		} else if ((p2X > bx2P - 100 && p2X < bx2P + 100) && (p2Y > by2P - 100 && p2Y < by2P + 100)) {
			die2 = true;

		}

		if ((p1X > bx2P - 100 && p1X < bx2P + 100) && (p1Y > by2P - 100 && p1Y < by2P + 100)) {
			die1 = true;

		} else if ((p1X > bx2P - 100 && p1X < bx2P + 100) && (p1Y > by2P - 100 && p1Y < by2P + 100)) {
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

				item1 = item[random.nextInt(8)];
				itemLabel = new JLabel(item1);
				itemLabel.setLocation(blockItem.get(j).getX(), blockItem.get(j).getY());
				itemLabel.setSize(75, 75);
				add(itemLabel);
				blockitemlist.add(itemLabel);

				if (item1 == speed_up) {
					itemCode[count] = 1;
					count += 1;
				} else if (item1 != speed_up) {
					itemCode[count] = 2;
					count += 1;
				}

				blockItem.remove(j);
			}
		}
	}

	public void BombDrop1p(int x1P, int y1P) { //1p 폭탄 드랍
		this.x = x1P;
		this.y = y1P;

		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				x = ((x + 37) / 75) * 75;
				if (y < 5)
					y = -75;
				else
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

					c1pCheckLocation();

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

					c1pCheckLocation();

					Thread.sleep(500);
					c1pCheckLocation();
					bc1p.setVisible(false);
					bvup1p.setVisible(false);
					bhright1p.setVisible(false);
					bvdown1p.setVisible(false);
					bhleft1p.setVisible(false);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(runnable).start();
	}

	Runnable pop1p = new Runnable() { //1p 폭탄 터짐

		@Override
		public void run() {
			if (bombcheck1P) {

				BombDrop1p(p1X, p1Y);
				bombcheck1P = false;

				try {
					Thread.sleep(3000);
					bombcheck1P = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	public void BombDrop2p(int x2P, int y2P) {//2p 폭탄 드랍
		this.x = x2P;
		this.y = y2P;

		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				x = ((x + 37) / 75) * 75;
				if (y < 5)
					y = -75;
				else
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

					c2pCheckLocation();

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

					c2pCheckLocation();

					Thread.sleep(500);
					c2pCheckLocation();
					bc2p.setVisible(false);
					bvup2p.setVisible(false);
					bhright2p.setVisible(false);
					bhleft2p.setVisible(false);
					bvdown2p.setVisible(false);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(runnable).start();
	}

	Runnable pop2p = new Runnable() { //2p 폭탄 터짐
		@Override
		public void run() {
			if (bombcheck2P) {

				BombDrop2p(p2X, p2Y);
				bombcheck2P = false;

				try {
					Thread.sleep(3000);
					bombcheck2P = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	public void ItemSpeed() { //아이템 획득 (아이템 획득으로 인한 스피드 증가)

		for (int i = 0; i < blockitemlist.size(); i++) {
			if ((p1X + 73 > blockitemlist.get(i).getX() && p1X < blockitemlist.get(i).getX() + 75)
					&& (p1Y + 100 > blockitemlist.get(i).getY() && p1Y - 50 < blockitemlist.get(i).getY())) {
				if (blockitemlist.get(i).getIcon() != null && itemCode[i] == 1) {

					speed1 -= 5;
					blockitemlist.get(i).setIcon(null);
					if (speed1 < 10) {
						speed1 = 10;
					}
				}

				else if (blockitemlist.get(i).getIcon() != null && itemCode[i] != 1) {
					blockitemlist.get(i).setIcon(null);
				}
			}

			if ((p2X + 73 > blockitemlist.get(i).getX() && p2X < blockitemlist.get(i).getX() + 75)
					&& (p2Y + 100 > blockitemlist.get(i).getY() && p2Y - 50 < blockitemlist.get(i).getY())) {
				if (blockitemlist.get(i).getIcon() != null && itemCode[i] == 1) {

					speed2 -= 5;
					blockitemlist.get(i).setIcon(null);
					if (speed2 < 10) {
						speed2 = 10;
					}
				}

				else if (blockitemlist.get(i).getIcon() != null && itemCode[i] != 1) {
					blockitemlist.get(i).setIcon(null);
				}
			}
		}

	}

	public void processInput1() { // 1p 블록 위치 키 false
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

	Runnable run1p = new Runnable() { //1p 이동속도 증가로 인한 스레드

		@Override
		public void run() {
			while (true) {
				processInput1();
				ItemSpeed();
				repaint();
				try {
					Thread.sleep(speed1);// 최고 이동속도는 10으로 설정
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	public void processInput2() { // 2p 블록 위치 키 false
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
		if (keyY == true) { // 위
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
		if (keyO == true) { // 오
			if (p2X <= limitMaxY) {
				c2p.setIcon(right2p);
				c2p.setLocation(p2X + 3, p2Y);
			}
		}
	}

	Runnable run2p = new Runnable() {  //2p 이동속도 증가로 인한 스레드

		@Override
		public void run() {
			while (true) {
				processInput2();
				ItemSpeed();
				repaint();
				try {
					Thread.sleep(speed2);// 최고 이동속도는 10으로 설정
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	public void gameSet(CaricValue1p getcv1P, CaricValue2p getcv2P) { // 게임 세팅 및 스레드 실행
		setFocusable(true);

		win1p.setBounds(185, 200, 838, 553);
		win1p.setVisible(false);
		win2p.setBounds(185, 200, 838, 553);
		win2p.setVisible(false);

		add(win1p);
		add(win2p);

		restartBtn.setName("restartBtn");
		restartBtn.setBounds(425, 771, 351, 95);
		add(restartBtn);
		restartBtn.setBorderPainted(false);
		restartBtn.setContentAreaFilled(false);
		restartBtn.setFocusPainted(false);
		restartBtn.setRolloverIcon(restartSelect);
		restartBtn.setVisible(false);

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
		new Thread(gameover).start();

		initListener();
	}

	private void initCharImg1p(CaricValue1p cv1p) { // SelectPamel에서 선택된 1p 캐릭터 이미지 및 능력을 받아옴
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

	private void initCharImg2p(CaricValue2p cv2p) { // SelectPamel에서 선택된 2p 캐릭터 이미지 및 능력을 받아옴
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

	private void initMap() { // 블록 세팅
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

	private void initListener() { // 리스너 추가 메서드
		addKeyListener(new KeyAdapter() { // 키 리스너 추가

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				int keyLocation = e.getKeyLocation();

				switch (keyCode) {
				case KeyEvent.VK_R:
					keyQ = true;
					keyW = false;
					keyE = false;
					keyR = false;
					break;
				case KeyEvent.VK_F:
					keyW = true;
					keyQ = false;
					keyE = false;
					keyR = false;
					break;
				case KeyEvent.VK_D:
					keyE = true;
					keyQ = false;
					keyW = false;
					keyR = false;
					break;
				case KeyEvent.VK_G:
					keyR = true;
					keyQ = false;
					keyW = false;
					keyE = false;
					break;

				case KeyEvent.VK_UP:
					keyY = true;
					keyU = false;
					keyI = false;
					keyO = false;
					break;
				case KeyEvent.VK_DOWN:
					keyU = true;
					keyY = false;
					keyI = false;
					keyO = false;
					break;
				case KeyEvent.VK_LEFT:
					keyI = true;
					keyY = false;
					keyU = false;
					keyO = false;
					break;
				case KeyEvent.VK_RIGHT:
					keyO = true;
					keyY = false;
					keyU = false;
					keyI = false;
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