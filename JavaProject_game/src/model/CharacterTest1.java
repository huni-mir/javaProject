package model;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.*;
import model.Character1P;

class CharacterTest1 extends JFrame {
	public CharacterTest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1600, 945);
		// setBounds(0, 0, 1600, 900);
		setLocationRelativeTo(null);
		LayoutManager o = null;
		setContentPane(new GameMap(o));
		setVisible(true);
	}

	public class GameMap extends JPanel {
		private ImageIcon MainGame = new ImageIcon("img/background/selectbackground.png"); // 인트로 이미지

		public void paintComponent(Graphics g) {
			super.paintComponent(g); // 화면을 비운다

			g.drawImage(MainGame.getImage(), 0, 0, null);

		}// 상단 캐릭터 선택 이미지 아이콘

		private ImageIcon chCat = new ImageIcon("img/character/catProfile.png");
		private ImageIcon chRabbit = new ImageIcon("img/character/rabbitProfile.png");
		private ImageIcon chBear = new ImageIcon("img/character/bearProfile.png");
		private ImageIcon chAstronaut = new ImageIcon("img/character/AstronautProfile.png");

		// 선택된 캐릭터 이미지 아이콘
		private ImageIcon chCatPick = new ImageIcon("img/character/catProfile.png");
		private ImageIcon chRabbitPick = new ImageIcon("img/character/rabbitProfile.png");
		private ImageIcon chBearPick = new ImageIcon("img/character/bearProfile.png");
		private ImageIcon chAstronautPick = new ImageIcon("img/character/AstronautProfile.png");

		private ImageIcon chAstronautPick1 = new ImageIcon("img/character/AstronautFont.png");

		// 시작 버튼 이미지 아이콘
		private ImageIcon start = new ImageIcon("img/button/GameStartBtn.png");

		private JButton ch1;
		private JButton ch2;
		private JButton ch3;
		private JButton ch4;
		private JLabel ch41;

		// 시작 버튼
		private JButton StartBtn;

		// 게임에서 사용할 캐릭터 이미지들을 담을 오브젝트
		private Character1P ci1P;
		private Character2P ci2P;

		private CharacterAbility1P ca1P;
		private CharacterAbility2P ca2P;

		public Character1P getCi1P() {
			return ci1P;
		}

		public CharacterAbility1P getCa1P() {
			return ca1P;
		}

		public GameMap(Object o) {

			// 시작 버튼
			StartBtn = new JButton(start);
			StartBtn.setName("StartBtn");
			StartBtn.addMouseListener((MouseListener) o);
			StartBtn.setBounds(254, 334, 291, 81);
			add(StartBtn);
			StartBtn.setBorderPainted(false);
			StartBtn.setContentAreaFilled(false);
			StartBtn.setFocusPainted(false);

			// 캐릭터 고양이
			ch1 = new JButton(chCat);
			ch1.setName("chRabbit");
			ch1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON1) {
						ch1.setIcon(chCatPick);
						ch2.setIcon(chRabbit);
						ch3.setIcon(chBear);
						ch4.setIcon(chAstronaut);
						System.out.print("좌클릭");
						ch41 = new JLabel(chAstronautPick1);
						ch41.setBounds(900, 500, 100, 73);
						add(ch41);
						ci1P = new Character1P(new ImageIcon("img/character/catFont.png"),
								new ImageIcon("img/character/catback.png"), new ImageIcon("img/character/catleft.png"),
								new ImageIcon("img/character/catright.png"), new ImageIcon("img/character/catdie.png"));
						ca1P = new CharacterAbility1P(3, 1, 2, 1);
					} else if (e.getButton() == MouseEvent.BUTTON3) {
						ch1.setIcon(chCatPick);
						ch2.setIcon(chRabbit);
						ch3.setIcon(chBear);
						ch4.setIcon(chAstronaut);
						ci2P = new Character2P(new ImageIcon("img/character/catFont.png"),
								new ImageIcon("img/character/catback.png"), new ImageIcon("img/character/catleft.png"),
								new ImageIcon("img/character/catright.png"), new ImageIcon("img/character/catdie.png"));
						ca2P = new CharacterAbility2P(3, 1, 2, 1);
						System.out.print("우클릭");
					}

				}
			});
			ch1.setBounds(380, 30, 150, 150);
			add(ch1);
			ch1.setBorderPainted(false);
			ch1.setContentAreaFilled(false);
			ch1.setFocusPainted(false);
			// 캐릭터 토끼
			ch2 = new JButton(chRabbit);
			ch2.setName("chCat");
			ch2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON1) {
						ch1.setIcon(chCat);
						ch2.setIcon(chRabbitPick);
						ch3.setIcon(chBear);
						ch4.setIcon(chAstronaut);
						ci1P = new Character1P(new ImageIcon("img/character/rabbitFont.png"),
								new ImageIcon("img/character/rabbitback.png"),
								new ImageIcon("img/character/rabbitleft.png"),
								new ImageIcon("img/character/rabbitright.png"),
								new ImageIcon("img/character/rabbitdie.png"));
						ca1P = new CharacterAbility1P(3, 2, 1, 1);
					} else if (e.getButton() == MouseEvent.BUTTON3) {
						ch1.setIcon(chCat);
						ch2.setIcon(chRabbitPick);
						ch3.setIcon(chBear);
						ch4.setIcon(chAstronaut);
						ci2P = new Character2P(new ImageIcon("img/character/rabbitleftFont.png"),
								new ImageIcon("img/character/rabbitback.png"),
								new ImageIcon("img/character/rabbitleft.png"),
								new ImageIcon("img/character/rabbitright.png"),
								new ImageIcon("img/character/rabbitdie.png"));
						ca2P = new CharacterAbility2P(3, 2, 1, 1);
					}

				}
			});
			ch2.setBounds(610, 30, 150, 150);
			add(ch2);
			ch2.setBorderPainted(false);
			ch2.setContentAreaFilled(false);
			ch2.setFocusPainted(false);
			// 캐릭터 곰
			ch3 = new JButton(chBear);
			ch3.setName("chBear");
			ch3.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON1) {
						ch1.setIcon(chCat);
						ch2.setIcon(chRabbit);
						ch3.setIcon(chBearPick);
						ch4.setIcon(chAstronaut);
						ci1P = new Character1P(new ImageIcon("img/character/bearFont.png"),
								new ImageIcon("img/character/bearback.png"),
								new ImageIcon("img/character/bearleft.png"),
								new ImageIcon("img/character/bearright.png"),
								new ImageIcon("img/character/beardie.png"));
						ca1P = new CharacterAbility1P(3, 1, 1, 2);
					} else if (e.getButton() == MouseEvent.BUTTON3) {
						ch1.setIcon(chCat);
						ch2.setIcon(chRabbit);
						ch3.setIcon(chBearPick);
						ch4.setIcon(chAstronaut);
						ci2P = new Character2P(new ImageIcon("img/character/bearFont.png"),
								new ImageIcon("img/character/bearback.png"),
								new ImageIcon("img/character/bearleft.png"),
								new ImageIcon("img/character/bearright.png"),
								new ImageIcon("img/character/beardie.png"));
						ca2P = new CharacterAbility2P(3, 1, 1, 2);
					}

				}
			});
			ch3.setBounds(840, 30, 150, 150);
			add(ch3);
			ch3.setBorderPainted(false);
			ch3.setContentAreaFilled(false);
			ch3.setFocusPainted(false);
			// 캐릭터 우주인
			ch4 = new JButton(chAstronaut);
			ch4.setName("chAstronaut");
			ch4.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON1) {
						ch1.setIcon(chCat);
						ch2.setIcon(chRabbit);
						ch3.setIcon(chBear);
						ch4.setIcon(chAstronautPick);
						ci1P = new Character1P(new ImageIcon("img/character/astronautFont.png"),
								new ImageIcon("img/character/astronautback.png"),
								new ImageIcon("img/character/astronautleft.png"),
								new ImageIcon("img/character/astronautright.png"),
								new ImageIcon("img/character/astronautdie.png"));
						ca1P = new CharacterAbility1P(4, 1, 1, 1);
					} else if (e.getButton() == MouseEvent.BUTTON3) {
						ch1.setIcon(chCat);
						ch2.setIcon(chRabbit);
						ch3.setIcon(chBear);
						ch4.setIcon(chAstronautPick);
						ci2P = new Character2P(new ImageIcon("img/character/astronautFont.png"),
								new ImageIcon("img/character/astronautback.png"),
								new ImageIcon("img/character/astronautleft.png"),
								new ImageIcon("img/character/astronautright.png"),
								new ImageIcon("img/character/astronautdie.png"));
						ca2P = new CharacterAbility2P(4, 1, 1, 1);
					}

				}
			});
			ch4.setBounds(1070, 30, 150, 150);
			add(ch4);
			ch4.setBorderPainted(false);
			ch4.setContentAreaFilled(false);
			ch4.setFocusPainted(false);
			setLayout(null);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CharacterTest1();
	}

}
