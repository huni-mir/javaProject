package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.*;

public class SelectPanel extends JPanel {
	private ImageIcon MainGame = new ImageIcon("img/background/select.png"); // 캐릭터 선택 화면 배경 이미지

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다

		g.drawImage(MainGame.getImage(), 0, 0, null); // 캐릭터 선택 화면 배경 이미지 그리기
	}

	// 상단 캐릭터 선택 이미지 아이콘
	private ImageIcon chCatProfile = new ImageIcon("img/character/catProfile.png");
	private ImageIcon chRabbitProfile = new ImageIcon("img/character/rabbitProfile.png");
	private ImageIcon chBearProfile = new ImageIcon("img/character/bearProfile.png");
	private ImageIcon chAstronautProfile = new ImageIcon("img/character/astronautProfile.png");

	// 선택된 상단 캐릭터 이미지 아이콘
	private ImageIcon pick1Ic = new ImageIcon("img/standby/flag1p.png");
	private ImageIcon pick2Ic = new ImageIcon("img/standby/flag2p.png");

	private JLabel pick1 = new JLabel(pick1Ic);
	private JLabel pick2 = new JLabel(pick2Ic);

	// 캐릭터 선택 마우스 이미지
	private ImageIcon click1pIc = new ImageIcon("img/standby/click_1p.png");
	private ImageIcon click2pIc = new ImageIcon("img/standby/click_2p.png");

	private JLabel click1p = new JLabel(click1pIc);
	private JLabel click2p = new JLabel(click2pIc);

	// 화면에 보여지는 캐릭터 전체 샷
	private ImageIcon chCat = new ImageIcon("img/character/catView.png");
	private ImageIcon chRabbit = new ImageIcon("img/character/rabbitView.png");
	private ImageIcon chBear = new ImageIcon("img/character/bearView.png");
	private ImageIcon chAstronaut = new ImageIcon("img/character/astronautview.png");

	// 2p
	private ImageIcon chCat2 = new ImageIcon("img/character/catView2.png");
	private ImageIcon chRabbit2 = new ImageIcon("img/character/rabbitView2.png");
	private ImageIcon chBear2 = new ImageIcon("img/character/bearView2.png");
	private ImageIcon chAstronaut2 = new ImageIcon("img/character/astronautview2.png");

	private JLabel view1p = new JLabel();
	private JLabel view2p = new JLabel();

	// 스탯 아이템 이미지 아이콘
	private ImageIcon statItemIc = new ImageIcon("img/ability/stat_item.png");

	private JLabel statItem = new JLabel(statItemIc);

	// 스탯 이미지 아이콘
	private ImageIcon statIc1 = new ImageIcon("img/ability/stat_1.png");
	private ImageIcon statIc2 = new ImageIcon("img/ability/stat_2.png");
	private ImageIcon statIc3 = new ImageIcon("img/ability/stat_3.png");
	private ImageIcon statIc4 = new ImageIcon("img/ability/stat_4.png");

	private JLabel stat1 = new JLabel();
	private JLabel stat2 = new JLabel();
	private JLabel stat3 = new JLabel();
	private JLabel stat4 = new JLabel();

	// 시작 버튼 이미지 아이콘
	private ImageIcon start = new ImageIcon("img/button/GameStart.png");
	private ImageIcon startSelect = new ImageIcon("img/button/gameStartSelect.png"); // 시작 버튼 선택

	private JButton ch1;
	private JButton ch2;
	private JButton ch3;
	private JButton ch4;

	// 시작 버튼
	private JButton StartBtn;

	// 게임에서 사용할 캐릭터 이미지들을 담을 오브젝트
	private CharacterValue1p cv1P;
	private CharacterValue2p cv2P;

	public CharacterValue1p getcv1P() {
		return cv1P;
	}

	public CharacterValue2p getcv2P() {
		return cv2P;
	}

	public SelectPanel(Object o) {
		setLayout(null);

		// 시작 버튼
		StartBtn = new JButton(start);
		StartBtn.setName("StartBtn");
		StartBtn.addActionListener((ActionListener) o);
		StartBtn.setBounds(625, 771, 351, 95);
		add(StartBtn);
		StartBtn.setBorderPainted(false);
		StartBtn.setContentAreaFilled(false);
		StartBtn.setFocusPainted(false);
		StartBtn.setRolloverIcon(startSelect);

		click1p.setBounds(213, 153, 100, 149);
		add(click1p);
		click2p.setBounds(1286, 153, 100, 149);
		add(click2p);

		// 선택한 캐릭터 겹쳐지지 않게 미리 세팅
		add(pick1);
		add(pick2);

		add(view1p);
		add(view2p);

		add(statItem);
		add(stat1);
		add(stat2);
		add(stat3);
		add(stat4);

		// 캐릭터 고양이
		ch1 = new JButton(chCatProfile);
		ch1.setName("chCatProfile");

		ch1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					remove(pick1);
					pick1.setBounds(304, 30, 83, 87);
					add(pick1);

					remove(view1p);
					view1p = new JLabel(chCat);
					view1p.setBounds(100, 320, 325, 450);
					add(view1p);

					cv1P = new CharacterValue1p(3, 1, 2, 1, new ImageIcon("img/character/catFront.png"),
							new ImageIcon("img/character/catback.png"), new ImageIcon("img/character/catleft.png"),
							new ImageIcon("img/character/catright.png"), new ImageIcon("img/character/catdie.png"));
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					remove(pick2);
					pick2.setBounds(523, 93, 83, 87);
					add(pick2);

					remove(view2p);
					view2p = new JLabel(chCat2);
					view2p.setBounds(1175, 320, 325, 450);
					add(view2p);

					cv2P = new CharacterValue2p(3, 1, 2, 1, new ImageIcon("img/character/catFront2.png"),
							new ImageIcon("img/character/catback2.png"), new ImageIcon("img/character/catleft2.png"),
							new ImageIcon("img/character/catright2.png"), new ImageIcon("img/character/catdie2.png"));
				}
				remove(statItem);
				statItem.setBounds(628, 329, 75, 375);
				add(statItem);

				remove(stat1);
				remove(stat2);
				remove(stat3);
				remove(stat4);
				stat1 = new JLabel(statIc3);
				stat2 = new JLabel(statIc1);
				stat3 = new JLabel(statIc2);
				stat4 = new JLabel(statIc1);

				stat1.setBounds(738, 340, 204, 54);
				stat2.setBounds(738, 440, 204, 54);
				stat3.setBounds(738, 540, 204, 54);
				stat4.setBounds(738, 640, 204, 54);

				add(stat1);
				add(stat2);
				add(stat3);
				add(stat4);

				repaint();
			}

		});
		ch1.setBounds(380, 30, 150, 150);
		add(ch1);
		ch1.setBorderPainted(false);
		ch1.setContentAreaFilled(false);
		ch1.setFocusPainted(false);

		// 캐릭터 토끼
		ch2 = new JButton(chRabbitProfile);
		ch2.setName("chRabbitProfile");

		ch2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					remove(pick1);
					pick1.setBounds(534, 30, 83, 87);
					add(pick1);

					remove(view1p);
					view1p = new JLabel(chRabbit);
					view1p.setBounds(100, 320, 325, 450);
					add(view1p);

					cv1P = new CharacterValue1p(3, 2, 1, 1, new ImageIcon("img/character/rabbitFront.png"),
							new ImageIcon("img/character/rabbitback.png"),
							new ImageIcon("img/character/rabbitleft.png"),
							new ImageIcon("img/character/rabbitright.png"),
							new ImageIcon("img/character/rabbitdie.png"));
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					remove(pick2);
					pick2.setBounds(752, 93, 83, 87);
					add(pick2);

					remove(view2p);
					view2p = new JLabel(chRabbit2);
					view2p.setBounds(1175, 320, 325, 450);
					add(view2p);

					cv2P = new CharacterValue2p(3, 2, 1, 1, new ImageIcon("img/character/rabbitFront2.png"),
							new ImageIcon("img/character/rabbitback2.png"),
							new ImageIcon("img/character/rabbitleft2.png"),
							new ImageIcon("img/character/rabbitright2.png"),
							new ImageIcon("img/character/rabbitdie2.png"));
				}

				remove(statItem);
				statItem.setBounds(628, 329, 75, 375);
				add(statItem);

				remove(stat1);
				remove(stat2);
				remove(stat3);
				remove(stat4);
				stat1 = new JLabel(statIc3);
				stat2 = new JLabel(statIc2);
				stat3 = new JLabel(statIc1);
				stat4 = new JLabel(statIc1);

				stat1.setBounds(738, 340, 204, 54);
				stat2.setBounds(738, 440, 204, 54);
				stat3.setBounds(738, 540, 204, 54);
				stat4.setBounds(738, 640, 204, 54);

				add(stat1);
				add(stat2);
				add(stat3);
				add(stat4);

				repaint();

			}
		});
		ch2.setBounds(610, 30, 150, 150);
		add(ch2);
		ch2.setBorderPainted(false);
		ch2.setContentAreaFilled(false);
		ch2.setFocusPainted(false);

		// 캐릭터 곰
		ch3 = new JButton(chBearProfile);
		ch3.setName("chBearProfile");
		ch3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					remove(pick1);
					pick1.setBounds(765, 30, 83, 87);
					add(pick1);

					remove(view1p);
					view1p = new JLabel(chBear);
					view1p.setBounds(100, 320, 325, 450);
					add(view1p);

					cv1P = new CharacterValue1p(3, 1, 1, 2, new ImageIcon("img/character/bearFront.png"),
							new ImageIcon("img/character/bearback.png"), new ImageIcon("img/character/bearleft.png"),
							new ImageIcon("img/character/bearright.png"), new ImageIcon("img/character/beardie.png"));

				} else if (e.getButton() == MouseEvent.BUTTON3) {
					remove(pick2);
					pick2.setBounds(982, 93, 83, 87);
					add(pick2);

					remove(view2p);
					view2p = new JLabel(chBear2);
					view2p.setBounds(1175, 320, 325, 450);
					add(view2p);

					cv2P = new CharacterValue2p(3, 1, 1, 2, new ImageIcon("img/character/bearFront2.png"),
							new ImageIcon("img/character/bearback2.png"), new ImageIcon("img/character/bearleft2.png"),
							new ImageIcon("img/character/bearright2.png"), new ImageIcon("img/character/beardie2.png"));
				}
				remove(statItem);
				statItem.setBounds(628, 329, 75, 375);
				add(statItem);

				remove(stat1);
				remove(stat2);
				remove(stat3);
				remove(stat4);
				stat1 = new JLabel(statIc3);
				stat2 = new JLabel(statIc1);
				stat3 = new JLabel(statIc1);
				stat4 = new JLabel(statIc2);

				stat1.setBounds(738, 340, 204, 54);
				stat2.setBounds(738, 440, 204, 54);
				stat3.setBounds(738, 540, 204, 54);
				stat4.setBounds(738, 640, 204, 54);

				add(stat1);
				add(stat2);
				add(stat3);
				add(stat4);

				repaint();
			}
		});
		ch3.setBounds(840, 30, 150, 150);
		add(ch3);
		ch3.setBorderPainted(false);
		ch3.setContentAreaFilled(false);
		ch3.setFocusPainted(false);

		// 캐릭터 우주인
		ch4 = new JButton(chAstronautProfile);
		ch4.setName("chAstronautProfile");
		ch4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					remove(pick1);
					pick1.setBounds(995, 30, 83, 87);
					add(pick1);

					remove(view1p); // 기존 아바타 제거
					view1p = new JLabel(chAstronaut);
					view1p.setBounds(100, 320, 325, 450);
					add(view1p);

					cv1P = new CharacterValue1p(4, 1, 1, 1, new ImageIcon("img/character/astronautFront.png"),
							new ImageIcon("img/character/astronautback.png"),
							new ImageIcon("img/character/astronautleft.png"),
							new ImageIcon("img/character/astronautright.png"),
							new ImageIcon("img/character/astronautdie.png"));
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					remove(pick2);
					pick2.setBounds(1213, 93, 83, 87);
					add(pick2);

					remove(view2p);
					view2p = new JLabel(chAstronaut2);
					view2p.setBounds(1175, 320, 325, 450);
					add(view2p);

					cv2P = new CharacterValue2p(4, 1, 1, 1, new ImageIcon("img/character/astronautFront2.png"),
							new ImageIcon("img/character/astronautback2.png"),
							new ImageIcon("img/character/astronautleft2.png"),
							new ImageIcon("img/character/astronautright2.png"),
							new ImageIcon("img/character/astronautdie.png"));
				}
				remove(statItem);
				statItem.setBounds(628, 329, 75, 375);
				add(statItem);

				remove(stat1);
				remove(stat2);
				remove(stat3);
				remove(stat4);
				stat1 = new JLabel(statIc4);
				stat2 = new JLabel(statIc1);
				stat3 = new JLabel(statIc1);
				stat4 = new JLabel(statIc1);

				stat1.setBounds(738, 340, 204, 54);
				stat2.setBounds(738, 440, 204, 54);
				stat3.setBounds(738, 540, 204, 54);
				stat4.setBounds(738, 640, 204, 54);

				add(stat1);
				add(stat2);
				add(stat3);
				add(stat4);

				repaint();
			}
		});
		ch4.setBounds(1070, 30, 150, 150);
		add(ch4);
		ch4.setBorderPainted(false);
		ch4.setContentAreaFilled(false);
		ch4.setFocusPainted(false);
	}
}
