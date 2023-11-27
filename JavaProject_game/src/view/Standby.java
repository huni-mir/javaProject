package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.*;

public class Standby extends JPanel {
	private ImageIcon MainGame = new ImageIcon("img/background/selectbackground.png"); // 인트로 이미지

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다

		g.drawImage(MainGame.getImage(), 0, 0, null);

	}
	private ImageIcon back = new ImageIcon("img/button/back.png"); // 뒤로가기 버튼 이미지 주소
	private JButton backBtn = new JButton(back);
	
	// 상단 캐릭터 선택 이미지 아이콘
	private ImageIcon chCatProfile = new ImageIcon("img/character/catProfile.png");
	private ImageIcon chRabbitProfile = new ImageIcon("img/character/rabbitProfile.png");
	private ImageIcon chBearProfile = new ImageIcon("img/character/bearProfile.png");
	private ImageIcon chAstronautProfile = new ImageIcon("img/character/astronautProfile.png");

	// 선택된 상단 캐릭터 이미지 아이콘
	private ImageIcon pick1 = new ImageIcon("img/character/catProfile.png");
	private ImageIcon pick2 = new ImageIcon("img/character/catProfile.png");

	// 화면에 보여지는 캐릭터 전체 샷
	private ImageIcon chCat = new ImageIcon("img/character/catView.png");
	private ImageIcon chRabbit = new ImageIcon("img/character/rabbitView.png");
	private ImageIcon chBear = new ImageIcon("img/character/bearView.png");
	private ImageIcon chAstronaut = new ImageIcon("img/character/astronautview.png");

	private JLabel view1p = new JLabel();
	private JLabel view2p = new JLabel();
	
	//스탯 아이템 이미지 아이콘
	private ImageIcon statItemIc = new ImageIcon("img/stat/stat_item.png");
	
	private JLabel statItem = new JLabel(statItemIc);
	
	// 스탯 이미지 아이콘
	private ImageIcon statIc1 = new ImageIcon("img/stat/stat_1.png");
	private ImageIcon statIc2 = new ImageIcon("img/stat/stat_2.png");
	private ImageIcon statIc3 = new ImageIcon("img/stat/stat_3.png");
	private ImageIcon statIc4 = new ImageIcon("img/stat/stat_4.png");
	
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
	Character1P ci1P;
	Character2P ci2P;

	private CharacterAbility1P ca1P;
	private CharacterAbility2P ca2P;

	public Character1P getci1P() {
		return ci1P;
	}
	public Character2P getci2P() {
		return ci2P;
	}


	public CharacterAbility1P getca1P() {
		return ca1P;
	}
	public CharacterAbility2P getca2P() {
		return ca2P;
	}
	
	public Standby(Object o) {
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
		
		/*// 뒤로가기 버튼
		backBtn.setName("backBtn");
		backBtn.addActionListener((ActionListener) o);
		backBtn.setBounds(44, 30, 69, 115);
		add(backBtn);
		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);*/
		
		// 선택한 캐릭터 겹쳐지지 않게 미리 세팅
		add(view1p);
		add(view2p);
		
		add(statItem);
		add(stat1); add(stat2); add(stat3); add(stat4);
		
		// 캐릭터 고양이
		ch1 = new JButton(chCatProfile);
		ch1.setName("chCatProfile");

		ch1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					// ch1.setIcon(chCatPick1);
					ch2.setIcon(chRabbitProfile);
					ch3.setIcon(chBearProfile);
					ch4.setIcon(chAstronautProfile);
					
					remove(view1p);
					view1p = new JLabel(chCat);
					view1p.setBounds(100, 320, 325, 450);
					add(view1p);
					
					ci1P = new Character1P(new ImageIcon("img/character/catFont.png"),
							new ImageIcon("img/character/catback.png"), 
							new ImageIcon("img/character/catleft.png"), 
							new ImageIcon("img/character/catright.png"), 
							new ImageIcon("img/character/catdie.png"));
					ca1P = new CharacterAbility1P(3, 1, 2, 1);
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					// ch1.setIcon(chCatPick2);
					ch2.setIcon(chRabbitProfile);
					ch3.setIcon(chBearProfile);
					ch4.setIcon(chAstronautProfile);
					
					remove(view2p);
					view2p = new JLabel(chCat);
					view2p.setBounds(1175, 320, 325, 450);
					add(view2p);
					
					ci2P = new Character2P(new ImageIcon("img/character/catFont.png"),
							new ImageIcon("img/character/catback.png"), 
							new ImageIcon("img/character/catleft.png"),
							new ImageIcon("img/character/catright.png"), 
							new ImageIcon("img/character/catdie.png"));
					ca2P = new CharacterAbility2P(3, 1, 2, 1);
				}
				remove(statItem);
				statItem.setBounds(588, 329, 75, 375);
				add(statItem);
				
				remove(stat1); remove(stat2); remove(stat3); remove(stat4);
				stat1 = new JLabel(statIc3);
				stat2 = new JLabel(statIc1);
				stat3 = new JLabel(statIc2);
				stat4 = new JLabel(statIc1);
				
				stat1.setBounds(698, 340, 204, 54);
				stat2.setBounds(698, 440, 204, 54);
				stat3.setBounds(698, 540, 204, 54);
				stat4.setBounds(698, 640, 204, 54);
				
				add(stat1); add(stat2); add(stat3); add(stat4);
				
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
					ch1.setIcon(chCatProfile);
					// ch2.setIcon(chRabbitPick1);
					ch3.setIcon(chBearProfile);
					ch4.setIcon(chAstronautProfile);
					
					remove(view1p);
					view1p = new JLabel(chRabbit);
					view1p.setBounds(100, 320, 325, 450);
					add(view1p);
					
					ci1P = new Character1P(new ImageIcon("img/character/rabbitFont.png"),
							new ImageIcon("img/character/rabbitback.png"),
							new ImageIcon("img/character/rabbitleft.png"),
							new ImageIcon("img/character/rabbitright.png"),
							new ImageIcon("img/character/rabbitdie.png"));
					ca1P = new CharacterAbility1P(3, 2, 1, 1);
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					ch1.setIcon(chCatProfile);
					// ch2.setIcon(chRabbitPick2);
					ch3.setIcon(chBearProfile);
					ch4.setIcon(chAstronautProfile);
					
					remove(view2p);
					view2p = new JLabel(chRabbit);
					view2p.setBounds(1175, 320, 325, 450);
					add(view2p);
					
					ci2P = new Character2P(new ImageIcon("img/character/rabbitleftFont.png"),
							new ImageIcon("img/character/rabbitback.png"),
							new ImageIcon("img/character/rabbitleft.png"),
							new ImageIcon("img/character/rabbitright.png"),
							new ImageIcon("img/character/rabbitdie.png"));
					ca2P = new CharacterAbility2P(3, 2, 1, 1);
				}
				
				remove(statItem);
				statItem.setBounds(588, 329, 75, 375);
				add(statItem);
				
				remove(stat1); remove(stat2); remove(stat3); remove(stat4);
				stat1 = new JLabel(statIc3);
				stat2 = new JLabel(statIc2);
				stat3 = new JLabel(statIc1);
				stat4 = new JLabel(statIc1);
				
				stat1.setBounds(698, 340, 204, 54);
				stat2.setBounds(698, 440, 204, 54);
				stat3.setBounds(698, 540, 204, 54);
				stat4.setBounds(698, 640, 204, 54);
				
				add(stat1); add(stat2); add(stat3); add(stat4);
				
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
					ch1.setIcon(chCatProfile);
					ch2.setIcon(chRabbitProfile);
					// ch3.setIcon(chBearPick1);
					ch4.setIcon(chAstronautProfile);
					
					remove(view1p);
					view1p = new JLabel(chBear);
					view1p.setBounds(100, 320, 325, 450);
					add(view1p);
					
					ci1P = new Character1P(new ImageIcon("img/character/bearFont.png"),
							new ImageIcon("img/character/bearback.png"), 
							new ImageIcon("img/character/bearleft.png"),
							new ImageIcon("img/character/bearright.png"), 
							new ImageIcon("img/character/beardie.png"));
					ca1P = new CharacterAbility1P(3, 1, 1, 2);
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					ch1.setIcon(chCatProfile);
					ch2.setIcon(chRabbitProfile);
					// ch3.setIcon(chBearPick2);
					ch4.setIcon(chAstronautProfile);
					
					remove(view2p);
					view2p = new JLabel(chBear);
					view2p.setBounds(1175, 320, 325, 450);
					add(view2p);
					
					ci2P = new Character2P(new ImageIcon("img/character/bearFont.png"),
							new ImageIcon("img/character/bearback.png"), 
							new ImageIcon("img/character/bearleft.png"),
							new ImageIcon("img/character/bearright.png"), 
							new ImageIcon("img/character/beardie.png"));
					ca2P = new CharacterAbility2P(3, 1, 1, 2);
				}
				remove(statItem);
				statItem.setBounds(588, 329, 75, 375);
				add(statItem);
				
				remove(stat1); remove(stat2); remove(stat3); remove(stat4);
				stat1 = new JLabel(statIc3);
				stat2 = new JLabel(statIc1);
				stat3 = new JLabel(statIc1);
				stat4 = new JLabel(statIc2);
				
				stat1.setBounds(698, 340, 204, 54);
				stat2.setBounds(698, 440, 204, 54);
				stat3.setBounds(698, 540, 204, 54);
				stat4.setBounds(698, 640, 204, 54);
				
				add(stat1); add(stat2); add(stat3); add(stat4);
				
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
					ch1.setIcon(chCatProfile);
					ch2.setIcon(chRabbitProfile);
					ch3.setIcon(chBearProfile);
					// ch4.setIcon(chAstronautPick1);
					
					remove(view1p);	// 기존 아바타 제거
					view1p = new JLabel(chAstronaut);
					view1p.setBounds(100, 320, 325, 450);
					add(view1p);
					
					ci1P = new Character1P(new ImageIcon("img/character/astronautFont.png"),
							new ImageIcon("img/character/astronautback.png"),
							new ImageIcon("img/character/astronautleft.png"),
							new ImageIcon("img/character/astronautright.png"),
							new ImageIcon("img/character/astronautdie.png"));
					ca1P = new CharacterAbility1P(4, 1, 1, 1);
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					ch1.setIcon(chCatProfile);
					ch2.setIcon(chRabbitProfile);
					ch3.setIcon(chBearProfile);
					// ch4.setIcon(chAstronautPick2);
					
					remove(view2p);
					view2p = new JLabel(chAstronaut);
					view2p.setBounds(1175, 320, 325, 450);
					add(view2p);
					
					ci2P = new Character2P(new ImageIcon("img/character/astronautFont.png"),
							new ImageIcon("img/character/astronautback.png"),
							new ImageIcon("img/character/astronautleft.png"),
							new ImageIcon("img/character/astronautright.png"),
							new ImageIcon("img/character/astronautdie.png"));
					ca2P = new CharacterAbility2P(4, 1, 1, 1);
				}
				remove(statItem);
				statItem.setBounds(588, 329, 75, 375);
				add(statItem);
				
				remove(stat1); remove(stat2); remove(stat3); remove(stat4);
				stat1 = new JLabel(statIc4);
				stat2 = new JLabel(statIc1);
				stat3 = new JLabel(statIc1);
				stat4 = new JLabel(statIc1);
				
				stat1.setBounds(698, 340, 204, 54);
				stat2.setBounds(698, 440, 204, 54);
				stat3.setBounds(698, 540, 204, 54);
				stat4.setBounds(698, 640, 204, 54);
				
				add(stat1); add(stat2); add(stat3); add(stat4);
				
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
