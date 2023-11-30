package view;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.BlockSet;
import model.CaricValue1p;
import model.CaricValue2p;

public class GamePanel extends JPanel {
	private ImageIcon MainGame = new ImageIcon("img/background/inGame.png");

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(MainGame.getImage(), 0, 0, getWidth(), getHeight(), this);
	}

	private ImageIcon front1p, back1p, left1p, right1p, dieimg1p;
	private ImageIcon front2p, back2p, left2p, right2p, dieimg2p;

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
	
	private JLabel character1;	// p1 -> 방향키
	private JLabel character2;	// p2 -> ASDW

	
	public GamePanel() {
	}

	public void gameSet(CaricValue1p getcv1P, CaricValue2p getcv2P) {
		setFocusable(true);
		
		initCharImg1p(getcv1P);
		initCharImg2p(getcv2P);
		
		// P1
		character1 = new JLabel(front1p);
		this.add(character1);
	    character1.setBounds(75, 50, 73, 100);  // Adjust the position based on your requirements
	    
	    // P2
		character2 = new JLabel(new ImageIcon(front2p.getImage()));
		this.add(character2);
	    character2.setBounds(1050, 725, 73, 100);
		
		initMap();
		
		
		initListener();
	    
	}

	private void initCharImg1p(CaricValue1p cv1p) {
		front1p = cv1p.getFront1P();
		back1p = cv1p.getBack1P();
		left1p = cv1p.getLeft1P();
		right1p = cv1p.getBack1P();
		dieimg1p = cv1p.getBack1P();
		
//		char1P = cv1p.getChar1P(); // 1P 체력
//		speed1P = cv1p.get; // 1P 스피드
//		bomb1P = 0; // 1P 폭탄 갯수
//		range1P = 0; // 1P 폭탄 범위 
		
	}

	private void initCharImg2p(CaricValue2p cv2p) {
		front2p = cv2p.getFront2P();
		back2p = cv2p.getBack2P();
		left2p = cv2p.getLeft2P();
		right2p = cv2p.getBack2P();
		dieimg2p = cv2p.getBack2P();
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
						// item.add 자리
						this.add(blockred);
						blockred.setBounds(i * 75, j * 75, 75, 75);
					} else if (i < 3 && j == 3 /* 4번쨰열 */
							|| (i < 2 && i > 0) && (j > 3 && j < 7)/* 5,6,7번쨰열 */
							|| i < 2 && j == 7 /* 8번쨰열 */) {
						JLabel blocksky = new JLabel(new ImageIcon("img/block/SkyBlock.png"));
						// item.add 자리
						this.add(blocksky);
						blocksky.setBounds(i * 75, j * 75, 75, 75);// J
					} else if ((i > 3 && i < 6) && j == 3 /* 4번쨰열 */
							|| i == 3 && j == 4 || i == 6 && j == 4 /* 5번쨰열 */
							|| (i > 2 && i < 7) && j == 5 /* 6번쨰열 */
							|| i == 3 && j == 6 || i == 6 && j == 6 /* 7번쨰열 */
							|| i == 3 && j == 7 || i == 6 && j == 7 /* 8번쨰열 */) {
						JLabel blockpink = new JLabel(new ImageIcon("img/block/PinkBlock.png"));
						// item.add 자리
						this.add(blockpink);
						blockpink.setBounds(i * 75, j * 75, 75, 75);// A
					} else if (i == 7 && j == 3 || i == 11 && j == 3 /* 4번쨰열 */
							|| i == 7 && j == 4 || i == 11 && j == 4 /* 5번쨰열 */
							|| i == 7 && j == 5 || i == 11 && j == 5 /* 6번쨰열 */
							|| i == 8 && j == 6 || i == 10 && j == 6 /* 7번쨰열 */
							|| i == 9 && j == 7 /* 8번쨰열 */) {
						JLabel blockblue = new JLabel(new ImageIcon("img/block/BlueBlock.png"));
						// item.add 자리
						this.add(blockblue);
						blockblue.setBounds(i * 75, j * 75, 75, 75);// V
					} else if ((i > 12 && i < 15) && j == 3 /* 4번쨰열 */
							|| i == 12 && j == 4 || i == 15 && j == 4 /* 5번쨰열 */
							|| (i > 11 && i < 16) && j == 5 /* 6번쨰열 */
							|| i == 12 && j == 6 || i == 15 && j == 6 /* 7번쨰열 */
							|| i == 12 && j == 7 || i == 15 && j == 7 /* 8번쨰열 */) {
						JLabel blockpuple = new JLabel(new ImageIcon("img/block/PupleBlock.png"));
						// item.add 자리
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

				private int p1X;
				private int p2X;
				private int p1Y;
				private int p2Y;

				@Override
				public void keyPressed(KeyEvent e) {
					
					p1X = character1.getX();
					p1Y = character1.getY();
					p2X = character2.getX();
					p2Y = character2.getY();
					
					int limitMinX = 75;
					int limitMaxX = 800;
					int limitMinY = 50;
					int limitMaxY = 725;
					
					// 1P
					if (e.getKeyCode() == KeyEvent.VK_UP) { // 위
						if(p1Y >= limitMinX) {
							character1.setLocation(p1X, p1Y - 75);
							character1.setIcon(back1p);
						}
						
					} if (e.getKeyCode() == KeyEvent.VK_DOWN) { // 아래
						character1.setLocation(p1X, p1Y + 75);
						character1.setIcon(front1p);
					} if (e.getKeyCode() == KeyEvent.VK_LEFT) { // 왼
						character1.setLocation(p1X - 75, p1Y);
						character1.setIcon(left1p);
					} if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // 오
						character1.setLocation(p1X + 75, p1Y);
						character1.setIcon(right1p);
					}
					
					// 2P
					if (e.getKeyCode() == KeyEvent.VK_W) { 
						character2.setLocation(p2X, p2Y - 75);
						character2.setIcon(back2p);
					}
					if (e.getKeyCode() == KeyEvent.VK_S) { // 아래
						character2.setLocation(p2X, p2Y + 75);
						character2.setIcon(front2p);
					} if (e.getKeyCode() == KeyEvent.VK_A) { // 왼
						character2.setLocation(p2X - 75, p2Y);
						character2.setIcon(left2p);
					} if (e.getKeyCode() == KeyEvent.VK_D) { // 오
						character2.setLocation(p2X + 75, p2Y);
						character2.setIcon(right2p);
					}
					
				}
			});
		}

}