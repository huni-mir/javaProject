package view;

import javax.swing.*;

import model.Character1P;
import model.Character2P;
import model.CharacterAbility1P;
import model.CharacterAbility2P;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import controlller.*;

class Beullog extends JPanel {
	int size;
	int size1;
	String map[][];

	public Beullog(int size, int size1) {
		this.size = size;
		this.size1 = size1;
		map = new String[size][size1];
		this.setLayout(null);
		this.setBounds(0, 0, 1200, 900);
	}
}

public class GameMap extends JPanel {
	private ImageIcon font1P; // 정면
	private ImageIcon back1P; // 뒷면
	private ImageIcon left1P; // 왼쪽
	private ImageIcon right1P; // 오른쪽
	private ImageIcon dieimg1P; // 죽음

	private ImageIcon font2P; // 정면
	private ImageIcon back2P; // 뒷면
	private ImageIcon left2P; // 왼쪽
	private ImageIcon right2P; // 오른쪽
	private ImageIcon dieimg2P; // 죽음

	// 캐릭터 체력
	private int char1P; // 1P 체력
	// 캐릭터 능력
	private int speed1P; // 1P 스피드
	private int bomb1P; // 1P 폭탄 갯수
	private int range1P; // 1P 폭탄 범위

	// 캐릭터 체력
	private int char2P; // 2P 체력
	// 캐릭터 능력
	private int speed2P; // 2P 스피드
	private int bomb2P; // 2P 폭탄 갯수
	private int range2P; // 2P 폭탄 범위

	private ImageIcon MainGame = new ImageIcon("img/background/MainGame.png"); // 게임이미지
	private Vector<JLabel> item = new Vector<JLabel>();
	private ArrayList<JLabel> itemlist = new ArrayList<JLabel>();
	private ImageIcon[] item2 = { new ImageIcon("img/speed_up.png"), new ImageIcon("img/range_up.png"),
			new ImageIcon("img/heart_up.png"), new ImageIcon("img/bomb_up.png"), null };

	Random random = new Random();
	ImageIcon item3;
	String move;
	String shape;
	int x;
	int y;
	int char2Bx, char2By;
	int char1bx, char1by;
	int char1X = 75;
	int char1Y = 75;

	int char2X = 1050;
	int char2Y = 750;
	JLabel itemLabel;

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다
		g.drawImage(MainGame.getImage(), 0, 0, null);
	}

	public GameMap() {

		setLayout(null);
		Beullog beullog = new Beullog(16, 12);
		{
			for (int i = 0; i < beullog.size; i++) {
				for (int j = 0; j < beullog.size1; j++) {
					beullog.map[i][j] = "1";
					String block = beullog.map[i][j];
					if (i < 3 && j == 0 || ((i > 12 && i < 16) && j == 0)/* 1번쨰열 */
							|| i < 1 && j == 1 || ((i > 14 && i < 16) && j == 1)/* 2번쨰열 */
							|| i < 1 && j == 10 || ((i > 14 && i < 16) && j == 10)/* 11번쨰열 */
							|| i < 3 && j == 11 || ((i > 12 && i < 16) && j == 11)/* 12번쨰열 */) {
						JLabel beullog1 = new JLabel(new ImageIcon("img/block/RedBlock.png"));
						// item.add 자리
						this.add(beullog1);
						beullog1.setBounds(i * 75, j * 75, 75, 75);
					} else if (i < 3 && j == 3 /* 4번쨰열 */
							|| (i < 2 && i > 0) && (j > 3 && j < 7)/* 5,6,7번쨰열 */
							|| i < 2 && j == 7 /* 8번쨰열 */) {
						JLabel beullog5 = new JLabel(new ImageIcon("img/block/SkyBlock.png"));
						// item.add 자리
						this.add(beullog5);
						beullog5.setBounds(i * 75, j * 75, 75, 75);// J
					} else if ((i > 3 && i < 6) && j == 3 /* 4번쨰열 */
							|| i == 3 && j == 4 || i == 6 && j == 4 /* 5번쨰열 */
							|| (i > 2 && i < 7) && j == 5 /* 6번쨰열 */
							|| i == 3 && j == 6 || i == 6 && j == 6 /* 7번쨰열 */
							|| i == 3 && j == 7 || i == 6 && j == 7 /* 8번쨰열 */) {
						JLabel beullog3 = new JLabel(new ImageIcon("img/block/PinkBlock.png"));
						// item.add 자리
						this.add(beullog3);
						beullog3.setBounds(i * 75, j * 75, 75, 75);// A
					} else if (i == 7 && j == 3 || i == 11 && j == 3 /* 4번쨰열 */
							|| i == 7 && j == 4 || i == 11 && j == 4 /* 5번쨰열 */
							|| i == 7 && j == 5 || i == 11 && j == 5 /* 6번쨰열 */
							|| i == 8 && j == 6 || i == 10 && j == 6 /* 7번쨰열 */
							|| i == 9 && j == 7 /* 8번쨰열 */) {
						JLabel beullog2 = new JLabel(new ImageIcon("img/block/BlueBlock.png"));
						// item.add 자리
						this.add(beullog2);
						beullog2.setBounds(i * 75, j * 75, 75, 75);// V
					} else if ((i > 12 && i < 15) && j == 3 /* 4번쨰열 */
							|| i == 12 && j == 4 || i == 15 && j == 4 /* 5번쨰열 */
							|| (i > 11 && i < 16) && j == 5 /* 6번쨰열 */
							|| i == 12 && j == 6 || i == 15 && j == 6 /* 7번쨰열 */
							|| i == 12 && j == 7 || i == 15 && j == 7 /* 8번쨰열 */) {
						JLabel beullog1 = new JLabel(new ImageIcon("img/block/PupleBlock.png"));
						// item.add 자리
						this.add(beullog1);
						beullog1.setBounds(i * 75, j * 75, 75, 75);// A
					}
				}
			}

		}
	}

	private JLabel char1p;
	private JLabel char2p;

	public void gameSet(Character1P getci1p, Character2P getci2p, CharacterAbility1P getca1p,
			CharacterAbility2P getca2p) {
		setFocusable(true);
		charCi1P(getci1p);
		charCi2P(getci2p);
		charCa1P(getca1p);
		charCa2P(getca2p);
		char1p = new JLabel(new ImageIcon(font1P.getImage()));
		char1p.setBounds(75, 50, 73, 100);
		add(char1p);

		char1p.addKeyListener(new MykeyListener());
		char1p.setFocusable(true);
		char1p.requestFocusInWindow();

		char2p = new JLabel(new ImageIcon(font2P.getImage()));
		char2p.setBounds(1050, 725, 73, 100);
		add(char2p);

		char2p.addKeyListener(new MykeyListener());
		char2p.setFocusable(true);
		char2p.requestFocusInWindow();

	}

	class MykeyListener extends KeyAdapter {
		private boolean[] char1Key = new boolean[256];
		private boolean[] char2Key = new boolean[256];

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();

			if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_S
					|| keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_SHIFT) {
				char1Key[keyCode] = true;
			}
			// 2p
			else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_LEFT
					|| keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_CONTROL) {
				char2Key[keyCode] = true;
			}
			// 여기서 각 플레이어의 입력에 따른 게임 로직을 수행
			processInputs();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_S
					|| keyCode == KeyEvent.VK_D) {
				char1Key[keyCode] = false;
				// 1p
			}
			// 2p
			else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_LEFT
					|| keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_CONTROL) {
				char2Key[keyCode] = false;
			}
			processInputs();
		}

		private void processInputs() {
			// 1p
			if (char1Key[KeyEvent.VK_W]) {
				char1p.setLocation(char1p.getX(), char1p.getY() - 10); // 위로 이동
			}
			if (char1Key[KeyEvent.VK_A]) {
				char1p.setLocation(char1p.getX() - 10, char1p.getY()); // 왼쪽으로 이동
			}
			if (char1Key[KeyEvent.VK_S]) {
				char1p.setLocation(char1p.getX(), char1p.getY() + 10); // 아래로 이동
			}
			if (char1Key[KeyEvent.VK_D]) {
				char1p.setLocation(char1p.getX() + 10, char1p.getY());
			}
			if (char1Key[KeyEvent.VK_SHIFT]) {
				// new Thread(one).start(); //one 스레드 dropBomb
			}
			// 2p
			if (char2Key[KeyEvent.VK_UP]) {
				char2p.setLocation(char2p.getX(), char2p.getY() - 10); // 위로 이동
			}
			if (char2Key[KeyEvent.VK_LEFT]) {
				char2p.setLocation(char2p.getX() - 10, char2p.getY()); // 왼쪽으로 이동
			}
			if (char2Key[KeyEvent.VK_DOWN]) {
				char2p.setLocation(char2p.getX(), char2p.getY() + 10); // 아래로 이동
			}
			if (char2Key[KeyEvent.VK_RIGHT]) {
				char2p.setLocation(char2p.getX() + 10, char2p.getY());
			}
			if (char2Key[KeyEvent.VK_CONTROL]) {
				// new Thread(one).start();
			}
		}
		// thread dropBomp 추가 해야됨
	}
	/*
	 * public void keyPressed(KeyEvent e) { int keyCode=e.getKeyCode();
	 * switch(keyCode) { case KeyEvent.VK_W: char1p.setLocation(char1p.getX(),
	 * char1p.getY() - 10);break; case KeyEvent.VK_A:
	 * char1p.setLocation(char1p.getX() - 10, char1p.getY());break; case
	 * KeyEvent.VK_S: char1p.setLocation(char1p.getX(), char1p.getY() + 10);break;
	 * case KeyEvent.VK_D: char1p.setLocation(char1p.getX() + 10,
	 * char1p.getY());break; } }
	 */

	private void charCa1P(CharacterAbility1P getca1p) {
		char1P = getca1p.getChar1P();
		speed1P = getca1p.getSpeed1P();
		range1P = getca1p.getRange1P();
	}

	private void charCa2P(CharacterAbility2P getca2p) {
		char2P = getca2p.getChar2P();
		speed2P = getca2p.getSpeed2P();
		range2P = getca2p.getRange2P();
	}

	private void charCi1P(Character1P getci1p) {
		font1P = getci1p.getFont1P(); //
		back1P = getci1p.getBack1P(); //
		left1P = getci1p.getLeft1P(); //
		right1P = getci1p.getRight1P(); //
		dieimg1P = getci1p.getDieimg1P(); //
	}

	private void charCi2P(Character2P getci2p) {
		font2P = getci2p.getFont2P(); //
		back2P = getci2p.getBack2P(); //
		left2P = getci2p.getLeft2P(); //
		right2P = getci2p.getRight2P(); //
		dieimg2P = getci2p.getDieimg2P(); //
	}
	/*
	 * private void initListener() {
	 * 
	 * addKeyListener(new KeyAdapter() { // 키 리스너 추가 private boolean[] char1Key =
	 * new boolean[256]; private boolean[] char2Key = new boolean[256]; private int
	 * char1x = 0; private int char1y = 0; private int char2x = 0; private int
	 * char2y = 0;
	 * 
	 * @Override public void keyPressed(KeyEvent e) { int keyCode = e.getKeyCode();
	 * 
	 * // 1p if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_A || keyCode ==
	 * KeyEvent.VK_S || keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_SHIFT) {
	 * char1Key[keyCode] = true; }
	 * 
	 * // 2p else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN ||
	 * keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT || keyCode ==
	 * KeyEvent.VK_CONTROL) { char2Key[keyCode] = true; }
	 * 
	 * // 여기서 각 플레이어의 입력에 따른 게임 로직을 수행 processInputs(); }
	 * 
	 * @Override public void keyReleased(KeyEvent e) { int keyCode = e.getKeyCode();
	 * if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_A || keyCode ==
	 * KeyEvent.VK_S || keyCode == KeyEvent.VK_D ) { char1Key[keyCode] = false; //
	 * 1p } else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN ||
	 * keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
	 * char2Key[keyCode] = false; //2p } processInputs(); }
	 * 
	 * private void processInputs() { //1p if (char1Key[KeyEvent.VK_W]) {
	 * //font1Label.setLocation(font1Label.getX(),font1Label.getY()-10);
	 * char1p.setLocation(getX(), getY() - 10); // 위로 이동 } if
	 * (char1Key[KeyEvent.VK_A]) { char1x -= 10; // 왼쪽으로 이동 } if
	 * (char1Key[KeyEvent.VK_S]) { char1y += 10; // 아래로 이동 } if
	 * (char1Key[KeyEvent.VK_D]) { char1x += 10; // 오른쪽으로 이동 } if
	 * (char1Key[KeyEvent.VK_SHIFT]) { //new Thread(one).start(); //one 스레드 dropBomb
	 * }
	 * 
	 * //2p if (char2Key[KeyEvent.VK_UP]) { char2y -= 10; // 위로 이동 } if
	 * (char2Key[KeyEvent.VK_LEFT]) { char2x -= 10; // 왼쪽으로 이동 } if
	 * (char2Key[KeyEvent.VK_DOWN]) { char2y += 10; // 아래로 이동 } if
	 * (char2Key[KeyEvent.VK_RIGHT]) { char2x += 10; // 오른쪽으로 이동 } if
	 * (char2Key[KeyEvent.VK_CONTROL]) { //new Thread(one).start(); } } //thread
	 * dropBomp 추가 해야됨 }); setFocusable(true); requestFocus();
	 * 
	 * }
	 */
}