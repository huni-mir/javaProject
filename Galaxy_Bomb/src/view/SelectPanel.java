package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.*;

public class SelectPanel extends JPanel {
	private ImageIcon selectImg = new ImageIcon("img/background/select.png"); // 캐릭터 선택 화면 배경 이미지

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다

		g.drawImage(selectImg.getImage(), 0, 0, null); // 캐릭터 선택 화면 배경 이미지 그리기
	}

	// 상단 캐릭터 선택 이미지 라벨
	private JLabel catProfile = new JLabel(new ImageIcon("img/character/catProfile.png"));
	private JLabel rabbitProfile = new JLabel(new ImageIcon("img/character/rabbitProfile.png"));
	private JLabel bearProfile = new JLabel(new ImageIcon("img/character/bearProfile.png"));
	private JLabel astronautProfile = new JLabel(new ImageIcon("img/character/astronautProfile.png"));

	// 1p, 2p 선택 이미지 라벨
	private JLabel pick1p = new JLabel(new ImageIcon("img/select/flag1p.png"));
	private JLabel pick2p = new JLabel(new ImageIcon("img/select/flag2p.png"));

	// 캐릭터 선택 가이드 이미지 라벨
	private JLabel click1p = new JLabel(new ImageIcon("img/select/click_1p.png"));
	private JLabel click2p = new JLabel(new ImageIcon("img/select/click_2p.png"));

	// 화면에 보여지는 선택한 캐릭터 전체 이미지
	// 1p 이미지
	private ImageIcon cat = new ImageIcon("img/character/catView.png");
	private ImageIcon rabbit = new ImageIcon("img/character/rabbitView.png");
	private ImageIcon bear = new ImageIcon("img/character/bearView.png");
	private ImageIcon astronaut = new ImageIcon("img/character/astronautview.png");

	// 2p 이미지
	private ImageIcon cat2 = new ImageIcon("img/character/catView2.png");
	private ImageIcon rabbit2 = new ImageIcon("img/character/rabbitView2.png");
	private ImageIcon chBear2 = new ImageIcon("img/character/bearView2.png");
	private ImageIcon chAstronaut2 = new ImageIcon("img/character/astronautview2.png");

	// 패널에 추가할 이미지 라벨
	private JLabel view1p = new JLabel();
	private JLabel view2p = new JLabel();

	// 스탯 아이템 이미지
	private JLabel statItem = new JLabel(new ImageIcon("img/ability/stat_item.png"));

	// 스탯 이미지
	private ImageIcon statIc1 = new ImageIcon("img/ability/stat_1.png");
	private ImageIcon statIc2 = new ImageIcon("img/ability/stat_2.png");
	private ImageIcon statIc3 = new ImageIcon("img/ability/stat_3.png");
	private ImageIcon statIc4 = new ImageIcon("img/ability/stat_4.png");

	// 스탯 이미지 라벨
	private JLabel stat1 = new JLabel();
	private JLabel stat2 = new JLabel();
	private JLabel stat3 = new JLabel();
	private JLabel stat4 = new JLabel();

	// 버튼 선언
	private JButton backBtn;
	private JButton startBtn;

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
		
		// 뒤로가기 버튼 설정
		backBtn = new JButton(new ImageIcon("img/button/back_black.png"));
		backBtn.setName("backBtn");
		backBtn.addActionListener((ActionListener) o);
		backBtn.setBounds(44, 30, 69, 115);
		add(backBtn);
		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);

		// 시작 버튼 설정
		startBtn = new JButton(new ImageIcon("img/button/GameStart.png"));
		startBtn.setName("startBtn");
		startBtn.addActionListener((ActionListener) o);
		startBtn.setBounds(625, 771, 351, 95);
		add(startBtn);
		startBtn.setBorderPainted(false);
		startBtn.setContentAreaFilled(false);
		startBtn.setFocusPainted(false);
		startBtn.setRolloverIcon(new ImageIcon("img/button/gameStartSelect.png")); // 시작 버튼에 마우스 올릴 시

		// 캐릭터 선택 가이드 이미지 설정
		click1p.setBounds(213, 153, 100, 149);
		add(click1p);
		click2p.setBounds(1286, 153, 100, 149);
		add(click2p);

		// 캐릭터 선택 시 이미지 겹쳐지지 않게 미리 세팅
		add(pick1p);
		add(pick2p);

		add(view1p);
		add(view2p);

		add(statItem);
		add(stat1);
		add(stat2);
		add(stat3);
		add(stat4);

		// 고양이 프로필 선택 리스너
		catProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					// 1p 프로필 이미지 설정
					remove(pick1p);
					pick1p.setBounds(304, 30, 83, 87);
					add(pick1p);

					// 1p 캐릭터 이미지 설정
					remove(view1p);
					view1p = new JLabel(cat);
					view1p.setBounds(100, 320, 325, 450);
					add(view1p);

					// 전달할 1p 캐릭터 값 저장
					cv1P = new CharacterValue1p(3, 25, 2, 1, new ImageIcon("img/character/catFront.png"),
							new ImageIcon("img/character/catback.png"), new ImageIcon("img/character/catleft.png"),
							new ImageIcon("img/character/catright.png"), new ImageIcon("img/character/catdie.png"));
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					// 2p 프로필 이미지 설정
					remove(pick2p);
					pick2p.setBounds(523, 93, 83, 87);
					add(pick2p);

					// 2p 캐릭터 이미지 설정
					remove(view2p);
					view2p = new JLabel(cat2);
					view2p.setBounds(1175, 320, 325, 450);
					add(view2p);

					// 전달할 2p 캐릭터 값 저장
					cv2P = new CharacterValue2p(3, 25, 2, 1, new ImageIcon("img/character/catFront2.png"),
							new ImageIcon("img/character/catback2.png"), new ImageIcon("img/character/catleft2.png"),
							new ImageIcon("img/character/catright2.png"), new ImageIcon("img/character/catdie2.png"));
				}
				// 스탯 이미지 설정
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
		// 고양이 프로필 라벨 설정
		catProfile.setBounds(380, 30, 150, 150);
		add(catProfile);

		// 토끼 프로필 선택 리스너
		rabbitProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					// 1p 프로필 이미지 설정
					remove(pick1p);
					pick1p.setBounds(534, 30, 83, 87);
					add(pick1p);

					// 1p 캐릭터 이미지 설정
					remove(view1p);
					view1p = new JLabel(rabbit);
					view1p.setBounds(100, 320, 325, 450);
					add(view1p);

					// 전달할 1p 캐릭터 값 저장
					cv1P = new CharacterValue1p(3, 20, 1, 1, new ImageIcon("img/character/rabbitFront.png"),
							new ImageIcon("img/character/rabbitback.png"),
							new ImageIcon("img/character/rabbitleft.png"),
							new ImageIcon("img/character/rabbitright.png"),
							new ImageIcon("img/character/rabbitdie.png"));
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					// 2p 프로필 이미지 설정
					remove(pick2p);
					pick2p.setBounds(752, 93, 83, 87);
					add(pick2p);

					// 2p 캐릭터 이미지 설정
					remove(view2p);
					view2p = new JLabel(rabbit2);
					view2p.setBounds(1175, 320, 325, 450);
					add(view2p);

					// 전달할 2p 캐릭터 값 저장
					cv2P = new CharacterValue2p(3, 20, 1, 1, new ImageIcon("img/character/rabbitFront2.png"),
							new ImageIcon("img/character/rabbitback2.png"),
							new ImageIcon("img/character/rabbitleft2.png"),
							new ImageIcon("img/character/rabbitright2.png"),
							new ImageIcon("img/character/rabbitdie2.png"));
				}
				// 스탯 이미지 설정
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
		// 토끼 프로필 라벨 설정
		rabbitProfile.setBounds(610, 30, 150, 150);
		add(rabbitProfile);

		// 곰 프로필 선택 리스너
		bearProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					// 1p 프로필 이미지 설정
					remove(pick1p);
					pick1p.setBounds(765, 30, 83, 87);
					add(pick1p);

					// 1p 캐릭터 이미지 설정
					remove(view1p);
					view1p = new JLabel(bear);
					view1p.setBounds(100, 320, 325, 450);
					add(view1p);

					// 전달할 1p 캐릭터 값 저장
					cv1P = new CharacterValue1p(3, 25, 1, 2, new ImageIcon("img/character/bearFront.png"),
							new ImageIcon("img/character/bearback.png"), new ImageIcon("img/character/bearleft.png"),
							new ImageIcon("img/character/bearright.png"), new ImageIcon("img/character/beardie.png"));

				} else if (e.getButton() == MouseEvent.BUTTON3) {
					// 2p 프로필 이미지 설정
					remove(pick2p);
					pick2p.setBounds(982, 93, 83, 87);
					add(pick2p);

					// 2p 캐릭터 이미지 설정
					remove(view2p);
					view2p = new JLabel(chBear2);
					view2p.setBounds(1175, 320, 325, 450);
					add(view2p);

					// 전달할 2p 캐릭터 값 저장
					cv2P = new CharacterValue2p(3, 25, 1, 2, new ImageIcon("img/character/bearFront2.png"),
							new ImageIcon("img/character/bearback2.png"), new ImageIcon("img/character/bearleft2.png"),
							new ImageIcon("img/character/bearright2.png"), new ImageIcon("img/character/beardie2.png"));
				}
				// 스탯 이미지 설정
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
		// 곰 프로필 라벨 설정
		bearProfile.setBounds(840, 30, 150, 150);
		add(bearProfile);

		// 우주인 프로필 선택 리스너
		astronautProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					// 1p 프로필 이미지 설정
					remove(pick1p);
					pick1p.setBounds(995, 30, 83, 87);
					add(pick1p);

					// 1p 캐릭터 이미지 설정
					remove(view1p);
					view1p = new JLabel(astronaut);
					view1p.setBounds(100, 320, 325, 450);
					add(view1p);

					// 전달할 1p 캐릭터 값 저장
					cv1P = new CharacterValue1p(4, 25, 1, 1, new ImageIcon("img/character/astronautFront.png"),
							new ImageIcon("img/character/astronautback.png"),
							new ImageIcon("img/character/astronautleft.png"),
							new ImageIcon("img/character/astronautright.png"),
							new ImageIcon("img/character/astronautdie.png"));
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					// 2p 프로필 이미지 설정
					remove(pick2p);
					pick2p.setBounds(1213, 93, 83, 87);
					add(pick2p);

					// 2p 캐릭터 이미지 설정
					remove(view2p);
					view2p = new JLabel(chAstronaut2);
					view2p.setBounds(1175, 320, 325, 450);
					add(view2p);

					// 전달할 2p 캐릭터 값 저장
					cv2P = new CharacterValue2p(4, 25, 1, 1, new ImageIcon("img/character/astronautFront2.png"),
							new ImageIcon("img/character/astronautback2.png"),
							new ImageIcon("img/character/astronautleft2.png"),
							new ImageIcon("img/character/astronautright2.png"),
							new ImageIcon("img/character/astronautdie.png"));
				}
				// 스탯 이미지 설정
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
		// 우주인 프로필 라벨 설정
		astronautProfile.setBounds(1070, 30, 150, 150);
		add(astronautProfile);
	}
}