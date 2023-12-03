package view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import model.*;

public class GamePanel extends JPanel {
	private ImageIcon mainGameImg = new ImageIcon("img/background/inGame.png"); // 메인 게임 배경 이미지

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다
		g.drawImage(mainGameImg.getImage(), 0, 0, getWidth(), getHeight(), this); // 메인 게임 배경 이미지 그리기
	}

	// 폭탄 이미지
	private JLabel bombExp1P = new JLabel(new ImageIcon("img/bomb/bomb_explode1.gif"));
	private JLabel bombEff_Up1P = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Vertical1.png"));
	private JLabel bombEff_Right1P = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Horizontal1.png"));
	private JLabel bombEff_Down1P = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Vertical1.png"));
	private JLabel bombEff_Left1P = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Horizontal1.png"));
	private JLabel bombLabel1p = new JLabel(new ImageIcon("img/bomb/bomb1.png"));

	private JLabel bombExp2P = new JLabel(new ImageIcon("img/bomb/bomb_explode2.gif"));
	private JLabel bombEff_Up2P = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Vertical2.png"));
	private JLabel bombEff_Right2P = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Horizontal2.png"));
	private JLabel bombEff_Down2P = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Vertical2.png"));
	private JLabel bombEff_Left2P = new JLabel(new ImageIcon("img/bomb/bomb_Effect_Horizontal2.png"));
	private JLabel bombLabel2p = new JLabel(new ImageIcon("img/bomb/bomb2.png"));

	// 다시 시작 버튼
	private JButton restartBtn = new JButton(new ImageIcon("img/button/restart.png"));
	private ImageIcon restartSelect = new ImageIcon("img/button/restartSelect.png");

	// 게임 오버 후 1p win, 2p win 이미지
	private JLabel win1p = new JLabel(new ImageIcon("img/button/gameover_1p_win.png"));
	private JLabel win2p = new JLabel(new ImageIcon("img/button/gameover_2p_win.png"));

	// 블럭 저장 변수
	private Vector<JLabel> block = new Vector<JLabel>();
	private ArrayList<JLabel> blockList = new ArrayList<JLabel>();

	// 아이템 이미지 아이콘
	private ImageIcon speed_up = new ImageIcon("img/item/speed_up.png");
	private ImageIcon bomb_up = new ImageIcon("img/item/bomb_up.png");
	private ImageIcon heart_up = new ImageIcon("img/item/heart_up.png");
	private ImageIcon range_up = new ImageIcon("img/item/range_up.png");

	// 블럭 파괴 시 아이템 등장 변수 세팅
	private ImageIcon[] item = { speed_up, range_up, null, speed_up, null, heart_up, speed_up, bomb_up };
	private JLabel itemLabel;
	private Random random = new Random();
	private ImageIcon item1;

	// 아이템 확인 변수
	private int[] itemCode = new int[60];
	private int count = 0;

	// 프레임 밖으로 못나가게 하는 상수 값
	private final int limitMinX = -23;
	private final int limitMaxX = 797;
	private final int limitMinY = 3;
	private final int limitMaxY = 1124;

	// 1P 이미지, 능력치
	private ImageIcon front1P, back1P, left1P, right1P, dieimg1P;
	private int heart1P = 0; // 1P 체력
	private int speed1P = 25; // 1P 스피드
	private int bomb1P = 0; // 1P 폭탄 갯수
	private int range1P = 0; // 1P 폭탄 범위

	private JLabel c1p;

	// 2P 이미지, 능력치
	private ImageIcon front2P, back2P, left2P, right2P, dieimg2P;
	private int heart2P = 0; // 2P 체력
	private int speed2P = 25; // 2P 스피드
	private int bomb2P = 0; // 2P 폭탄 갯수
	private int range2P = 0; // 2P 폭탄 범위

	private JLabel c2p;

	// 1P, 2P 죽음 확인
	private boolean die1 = false;
	private boolean die2 = false;

	// 1P, 2P 좌표
	private int p1X, p1Y;
	private int p2X, p2Y;

	// 폭탄 중복 설치 확인
	private boolean bombcheck1P = true;
	private boolean bombcheck2P = true;

	// 폭탄 좌표
	private int x;
	private int y;
	private int bx1P, by1P, bx2P, by2P;

	// 키 입력 확인 1P
	boolean keyR, keyF, keyD, keyG, keyShift_Left = false;

	// 키 입력 확인 2P
	boolean keyUp, keyDown, keyLeft, keyRight, keyShift_Right = false;

	public GamePanel(Object o) {
		restartBtn.addActionListener((ActionListener) o); // 다시 시작 버튼 리스너 추가
	}

	// 1P 이동, 블록 막힘 메소드
	public void processInput1() {
		p1X = c1p.getX();
		p1Y = c1p.getY();

		for (int i = 0; i < block.size(); i++) {
			if ((p1X > block.get(i).getX() - 72 && p1X < block.get(i).getX() + 75)
					&& (p1Y > block.get(i).getY() && p1Y <= block.get(i).getY() + 50)) {
				keyR = false;
				continue;
			} else if ((p1X > block.get(i).getX() - 72 && p1X < block.get(i).getX() + 75)
					&& (p1Y >= block.get(i).getY() - 100 && p1Y < block.get(i).getY())) {
				keyF = false;
				continue;
			} else if ((p1X > block.get(i).getX() && p1X <= block.get(i).getX() + 75)
					&& (p1Y > block.get(i).getY() - 100 && p1Y < block.get(i).getY() + 50)) {
				keyD = false;
				continue;
			} else if ((p1X >= block.get(i).getX() - 75 && p1X < block.get(i).getX())
					&& (p1Y > block.get(i).getY() - 100 && p1Y < block.get(i).getY() + 50)) {
				keyG = false;
				continue;
			}
		}

		if (keyR == true) { // 위
			if (p1Y >= limitMinX) {
				c1p.setIcon(back1P);
				c1p.setLocation(p1X, p1Y - 3);
			}
		}
		if (keyF == true) { // 아래
			if (p1Y <= limitMaxX) {
				c1p.setIcon(front1P);
				c1p.setLocation(p1X, p1Y + 3);
			}
		}
		if (keyD == true) { // 왼
			if (p1X >= limitMinY) {
				c1p.setIcon(left1P);
				c1p.setLocation(p1X - 3, p1Y);
			}
		}
		if (keyG == true) { // 오
			if (p1X <= limitMaxY) {
				c1p.setIcon(right1P);
				c1p.setLocation(p1X + 3, p1Y);
			}
		}
	}

	// 2P 이동, 블록 막힘 메소드
	public void processInput2() {
		p2X = c2p.getX();
		p2Y = c2p.getY();

		for (int i = 0; i < block.size(); i++) {
			if ((p2X > block.get(i).getX() - 72 && p2X < block.get(i).getX() + 75)
					&& (p2Y > block.get(i).getY() && p2Y <= block.get(i).getY() + 50)) {
				keyUp = false;
				continue;
			} else if ((p2X > block.get(i).getX() - 72 && p2X < block.get(i).getX() + 75)
					&& (p2Y >= block.get(i).getY() - 100 && p2Y < block.get(i).getY())) {
				keyDown = false;
				continue;
			} else if ((p2X > block.get(i).getX() && p2X <= block.get(i).getX() + 75)
					&& (p2Y > block.get(i).getY() - 100 && p2Y < block.get(i).getY() + 50)) {
				keyLeft = false;
				continue;
			} else if ((p2X >= block.get(i).getX() - 75 && p2X < block.get(i).getX())
					&& (p2Y > block.get(i).getY() - 100 && p2Y < block.get(i).getY() + 50)) {
				keyRight = false;
				continue;
			}
		}

		if (keyUp == true) { // 위
			if (p2Y >= limitMinX) {
				c2p.setIcon(back2P);
				c2p.setLocation(p2X, p2Y - 3);
			}
		}
		if (keyDown == true) { // 아래
			if (p2Y <= limitMaxX) {
				c2p.setIcon(front2P);
				c2p.setLocation(p2X, p2Y + 3);
			}
		}
		if (keyLeft == true) { // 왼
			if (p2X >= limitMinY) {
				c2p.setIcon(left2P);
				c2p.setLocation(p2X - 3, p2Y);
			}
		}
		if (keyRight == true) { // 오
			if (p2X <= limitMaxY) {
				c2p.setIcon(right2P);
				c2p.setLocation(p2X + 3, p2Y);
			}
		}
	}

	// 1P 폭탄 피격 판정
	public void c1pCheckLocation() {
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
		
		Die();

		for (int i = 0; i < block.size(); i++) {
			checkDirection(bx1P + 75, by1P, i);
			checkDirection(bx1P, by1P + 75, i);
			checkDirection(bx1P - 75, by1P, i);
			checkDirection(bx1P, by1P - 75, i);
		}
	}

	// 2P 폭탄 피격 판정
	public void c2pCheckLocation() {
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
		
		Die();

		for (int i = 0; i < block.size(); i++) {
			checkDirection(bx2P + 75, by2P, i);
			checkDirection(bx2P, by2P + 75, i);
			checkDirection(bx2P - 75, by2P, i);
			checkDirection(bx2P, by2P - 75, i);
		}
	}

	// 블록 파괴 시 아이템 드랍
	private void checkDirection(int x, int y, int i) {
		for (int j = 0; j < block.size(); j++) {
			if ((x >= block.get(j).getX() && x <= block.get(j).getX())
					&& (y >= block.get(j).getY() && y <= block.get(j).getY())) {
				block.get(j).setIcon(null);

				item1 = item[random.nextInt(8)];
				itemLabel = new JLabel(item1);
				itemLabel.setLocation(block.get(j).getX(), block.get(j).getY());
				itemLabel.setSize(75, 75);
				add(itemLabel);
				blockList.add(itemLabel);

				if (item1 == speed_up) {
					itemCode[count] = 1;
					count += 1;
				} else if (item1 != speed_up) {
					itemCode[count] = 2;
					count += 1;
				}

				block.remove(j);
			}
		}
	}

	// 1P 폭탄 드랍
	public void BombDrop1p(int x1P, int y1P) {
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

					bombExp1P.setSize(75, 75);
					bombExp1P.setLocation(bx1P, by1P);
					bombExp1P.setVisible(true);
					add(bombExp1P);
					bombEff_Up1P.setSize(75, 75);
					bombEff_Up1P.setLocation(bx1P, by1P - 75);
					bombEff_Up1P.setVisible(true);
					add(bombEff_Up1P);
					bombEff_Right1P.setSize(75, 75);
					bombEff_Right1P.setLocation(bx1P + 75, by1P);
					bombEff_Right1P.setVisible(true);
					add(bombEff_Right1P);
					bombEff_Down1P.setSize(75, 75);
					bombEff_Down1P.setLocation(bx1P, by1P + 75);
					bombEff_Down1P.setVisible(true);
					add(bombEff_Down1P);
					bombEff_Left1P.setSize(75, 75);
					bombEff_Left1P.setLocation(bx1P - 75, by1P);
					bombEff_Left1P.setVisible(true);
					add(bombEff_Left1P);

					c1pCheckLocation();

					Thread.sleep(500);
					c1pCheckLocation();
					bombExp1P.setVisible(false);
					bombEff_Up1P.setVisible(false);
					bombEff_Right1P.setVisible(false);
					bombEff_Down1P.setVisible(false);
					bombEff_Left1P.setVisible(false);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(runnable).start();
	}

	// 1P 폭탄 설치 후 터짐 스레드
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
					e.printStackTrace();
				}
			}
		}
	};

	// 2P 폭탄 드랍
	public void BombDrop2p(int x2P, int y2P) {
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

					bombExp2P.setSize(75, 75);
					bombExp2P.setLocation(bx2P, by2P);
					bombExp2P.setVisible(true);
					add(bombExp2P);
					bombEff_Up2P.setSize(75, 75);
					bombEff_Up2P.setLocation(bx2P, by2P - 75);
					bombEff_Up2P.setVisible(true);
					add(bombEff_Up2P);
					bombEff_Right2P.setSize(75, 75);
					bombEff_Right2P.setLocation(bx2P + 75, by2P);
					bombEff_Right2P.setVisible(true);
					add(bombEff_Right2P);
					bombEff_Down2P.setSize(75, 75);
					bombEff_Down2P.setLocation(bx2P, by2P + 75);
					bombEff_Down2P.setVisible(true);
					add(bombEff_Down2P);
					bombEff_Left2P.setSize(75, 75);
					bombEff_Left2P.setLocation(bx2P - 75, by2P);
					bombEff_Left2P.setVisible(true);
					add(bombEff_Left2P);

					c2pCheckLocation();

					Thread.sleep(500);
					c2pCheckLocation();
					bombExp2P.setVisible(false);
					bombEff_Up2P.setVisible(false);
					bombEff_Right2P.setVisible(false);
					bombEff_Left2P.setVisible(false);
					bombEff_Down2P.setVisible(false);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(runnable).start();
	}

	// 2P 폭탄 설치 후 터짐 스레드
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
					e.printStackTrace();
				}
			}
		}
	};

	// 아이템 획득으로 인한 스피드 증가
	public void ItemSpeed() {
		for (int i = 0; i < blockList.size(); i++) {
			if ((p1X + 73 > blockList.get(i).getX() && p1X < blockList.get(i).getX() + 75)
					&& (p1Y + 100 > blockList.get(i).getY() && p1Y - 50 < blockList.get(i).getY())) {
				if (blockList.get(i).getIcon() != null && itemCode[i] == 1) {
					
					speed1P -= 5;
					blockList.get(i).setIcon(null);
					
					if (speed1P < 10) {
						speed1P = 10;
					}
				}
				else if (blockList.get(i).getIcon() != null && itemCode[i] != 1) {
					blockList.get(i).setIcon(null);
				}
			}

			if ((p2X + 73 > blockList.get(i).getX() && p2X < blockList.get(i).getX() + 75)
					&& (p2Y + 100 > blockList.get(i).getY() && p2Y - 50 < blockList.get(i).getY())) {
				if (blockList.get(i).getIcon() != null && itemCode[i] == 1) {

					speed2P -= 5;
					blockList.get(i).setIcon(null);
					
					if (speed2P < 10) {
						speed2P = 10;
					}
				}

				else if (blockList.get(i).getIcon() != null && itemCode[i] != 1) {
					blockList.get(i).setIcon(null);
				}
			}
		}
	}

	// 1P 이동, 스피드 증가
	Runnable run1p = new Runnable() {
		@Override
		public void run() {
			while (true) {
				processInput1();
				ItemSpeed();
				repaint();
				try {
					Thread.sleep(speed1P); // 최고 이동속도는 10으로 설정
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	// 2P 이동, 스피드 증가
	Runnable run2p = new Runnable() {
		@Override
		public void run() {
			while (true) {
				processInput2();
				ItemSpeed();
				repaint();
				try {
					Thread.sleep(speed2P); // 최고 이동속도는 10으로 설정
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	// 캐릭터 죽음 게임 오버
	public void Die() {
		// 게임 오버되면 키 입력 방지
		if (die1 == true || die2 == true) {
			keyR = false;
			keyF = false;
			keyD = false;
			keyG = false;
			keyShift_Left = false;
			keyUp = false;
			keyDown = false;
			keyLeft = false;
			keyRight = false;
			keyShift_Right = false;

			setFocusable(false);
		}

		if (die1 == true) { // 2P 승리 시
			c1p.setIcon(dieimg1P);

			win2p.setVisible(true);
			restartBtn.setVisible(true);

			die1 = false;
		} else if (die2 == true) { // 1P 승리 시
			c2p.setIcon(dieimg2P);

			win1p.setVisible(true);
			restartBtn.setVisible(true);

			die2 = false;
		}
	}

	// 게임 세팅 및 스레드 실행
	public void gameSet(CharacterValue1p getcv1P, CharacterValue2p getcv2P) {
		setFocusable(true);

		// 게임 오버 및 승리 플레이어 이미지 설정
		win1p.setBounds(185, 200, 838, 553);
		win1p.setVisible(false);
		win2p.setBounds(185, 200, 838, 553);
		win2p.setVisible(false);

		add(win1p);
		add(win2p);

		// 다시 시작 버튼 설정
		restartBtn.setName("restartBtn");
		restartBtn.setBounds(425, 771, 351, 95);
		add(restartBtn);
		restartBtn.setBorderPainted(false);
		restartBtn.setContentAreaFilled(false);
		restartBtn.setFocusPainted(false);
		restartBtn.setRolloverIcon(restartSelect);
		restartBtn.setVisible(false);

		// 선택한 캐릭터 이미지, 능력치 불러오기
		initCharacter1p(getcv1P);
		initCharacter2p(getcv2P);

		// 1P 캐릭터 설정
		c1p = new JLabel(front1P);
		this.add(c1p);
		c1p.setBounds(75, 50, 73, 100);
		// 2P 캐릭터 설정
		c2p = new JLabel(front2P);
		this.add(c2p);
		c2p.setBounds(1050, 725, 73, 100);
		
		// 블록 세팅
		initMap();

		// 스레드 실행
		new Thread(run1p).start();
		new Thread(run2p).start();

		// 키 리스너
		initListener();
	}

	// 선택된 1p 캐릭터 이미지 및 능력치를 받아옴
	private void initCharacter1p(CharacterValue1p cv1p) {
		// 1p 캐릭터 이미지
		front1P = cv1p.getFront1P();
		back1P = cv1p.getBack1P();
		left1P = cv1p.getLeft1P();
		right1P = cv1p.getRight1P();
		dieimg1P = cv1p.getDieimg1P();

		heart1P = cv1p.getHeart1P(); // 1P 체력
		speed1P = cv1p.getSpeed1P(); // 1P 스피드
		bomb1P = cv1p.getBomb1P(); // 1P 폭탄 갯수
		range1P = cv1p.getRange1P(); // 1P 폭탄 범위

	}

	// 선택된 2p 캐릭터 이미지 및 능력치를 받아옴
	private void initCharacter2p(CharacterValue2p cv2p) {
		// 2p 캐릭터 이미지
		front2P = cv2p.getFront2P();
		back2P = cv2p.getBack2P();
		left2P = cv2p.getLeft2P();
		right2P = cv2p.getRight2P();
		dieimg2P = cv2p.getDieimg2P();

		heart2P = cv2p.getHeart2P(); // 2P 체력
		speed2P = cv2p.getSpeed2P(); // 2P 스피드
		bomb2P = cv2p.getBomb2P(); // 2P 폭탄 갯수
		range2P = cv2p.getRange2P(); // 2P 폭탄 범위

	}

	// 블록 세팅
	private void initMap() {
		setLayout(null);
		BlockSet blockSet = new BlockSet(16, 12);

		for (int i = 0; i < blockSet.size; i++) {
			for (int j = 0; j < blockSet.size1; j++) {
				if (i < 3 && j == 0 || ((i > 12 && i < 16) && j == 0) // 1번째 열
						|| i < 1 && j == 1 || ((i > 14 && i < 16) && j == 1) // 2번째 열
						|| i < 1 && j == 10 || ((i > 14 && i < 16) && j == 10) // 11번째 열
						|| i < 3 && j == 11 || ((i > 12 && i < 16) && j == 11)) { // 12번째 열
					JLabel blockred = new JLabel(new ImageIcon("img/block/RedBlock.png"));
					block.add(blockred);
					this.add(blockred);
					blockred.setBounds(i * 75, j * 75, 75, 75); // 모서리 블럭
				} else if (i < 3 && j == 3 // 4번째 열
						|| (i < 2 && i > 0) && (j > 3 && j < 7) // 5, 6, 7번째 열
						|| i < 2 && j == 7) { // 8번째 열
					JLabel blocksky = new JLabel(new ImageIcon("img/block/SkyBlock.png"));
					block.add(blocksky);
					this.add(blocksky);
					blocksky.setBounds(i * 75, j * 75, 75, 75); // J 모양 블럭
				} else if ((i > 3 && i < 6) && j == 3 // 4번째 열
						|| i == 3 && j == 4 || i == 6 && j == 4 // 5번째 열
						|| (i > 2 && i < 7) && j == 5 // 6번째 열
						|| i == 3 && j == 6 || i == 6 && j == 6 // 7번째 열
						|| i == 3 && j == 7 || i == 6 && j == 7 ) { // 8번째 열
					JLabel blockpink = new JLabel(new ImageIcon("img/block/PinkBlock.png"));
					block.add(blockpink);
					this.add(blockpink);
					blockpink.setBounds(i * 75, j * 75, 75, 75); // A 모양 블럭
				} else if (i == 7 && j == 3 || i == 11 && j == 3 // 4번째 열
						|| i == 7 && j == 4 || i == 11 && j == 4 // 5번째 열
						|| i == 7 && j == 5 || i == 11 && j == 5 // 6번째 열
						|| i == 8 && j == 6 || i == 10 && j == 6 // 7번째 열
						|| i == 9 && j == 7 ) { // 8번째 열
					JLabel blockblue = new JLabel(new ImageIcon("img/block/BlueBlock.png"));
					block.add(blockblue);
					this.add(blockblue);
					blockblue.setBounds(i * 75, j * 75, 75, 75);// V 모양 블럭
				} else if ((i > 12 && i < 15) && j == 3 // 4번째 열
						|| i == 12 && j == 4 || i == 15 && j == 4 // 5번째 열
						|| (i > 11 && i < 16) && j == 5 // 6번째 열
						|| i == 12 && j == 6 || i == 15 && j == 6 // 7번째 열
						|| i == 12 && j == 7 || i == 15 && j == 7 ) { // 8번째 열
					JLabel blockpuple = new JLabel(new ImageIcon("img/block/PupleBlock.png"));
					block.add(blockpuple);
					this.add(blockpuple);
					blockpuple.setBounds(i * 75, j * 75, 75, 75);// A 모양 블럭

				}
			}

		}
	}

	private void initListener() { // 리스너 추가 메서드
		addKeyListener(new KeyAdapter() { // 키 리스너 추가

			@Override
			public void keyPressed(KeyEvent e) { // 키 눌렀을 때
				int keyCode = e.getKeyCode();
				int keyLocation = e.getKeyLocation();

				switch (keyCode) {
				// 1P 이동키
				case KeyEvent.VK_R:
					keyR = true;
					keyF = false;
					keyD = false;
					keyG = false;
					break;
				case KeyEvent.VK_F:
					keyF = true;
					keyR = false;
					keyD = false;
					keyG = false;
					break;
				case KeyEvent.VK_D:
					keyD = true;
					keyR = false;
					keyF = false;
					keyG = false;
					break;
				case KeyEvent.VK_G:
					keyG = true;
					keyR = false;
					keyF = false;
					keyD = false;
					break;

				// 2P 이동키
				case KeyEvent.VK_UP:
					keyUp = true;
					keyDown = false;
					keyLeft = false;
					keyRight = false;
					break;
				case KeyEvent.VK_DOWN:
					keyDown = true;
					keyUp = false;
					keyLeft = false;
					keyRight = false;
					break;
				case KeyEvent.VK_LEFT:
					keyLeft = true;
					keyUp = false;
					keyDown = false;
					keyRight = false;
					break;
				case KeyEvent.VK_RIGHT:
					keyRight = true;
					keyUp = false;
					keyDown = false;
					keyLeft = false;
					break;
					
				// 폭탄 드랍 키
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
			public void keyReleased(KeyEvent e) { // 키 뗐을 때
				int keyCode = e.getKeyCode();

				switch (keyCode) {
				// 1P 이동키
				case KeyEvent.VK_R:
					keyR = false;
					break;
				case KeyEvent.VK_F:
					keyF = false;
					break;
				case KeyEvent.VK_D:
					keyD = false;
					break;
				case KeyEvent.VK_G:
					keyG = false;
					break;

				// 2P 이동키
				case KeyEvent.VK_UP:
					keyUp = false;
					break;
				case KeyEvent.VK_DOWN:
					keyDown = false;
					break;
				case KeyEvent.VK_LEFT:
					keyLeft = false;
					break;
				case KeyEvent.VK_RIGHT:
					keyRight = false;
					break;
				}
			}
		});

	}
}