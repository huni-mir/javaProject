package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.CharacterAbility1P;
import model.Character1P;

public class Standby extends JPanel {

	// 상단 캐릭터 선택 이미지 아이콘
	private ImageIcon chCat = new ImageIcon("img/character/catProfile.png");
	private ImageIcon chRabbit = new ImageIcon("img/character/rabbitProfile.png");
	private ImageIcon chBear = new ImageIcon("img/character/bearProfile.png");
	private ImageIcon chAstronaut = new ImageIcon("img/character/AstronautProfile.png");

	// 선택된 캐릭터 이미지 아이콘
	private ImageIcon chCatPick = new ImageIcon("img/character/catProfile.png");
	private ImageIcon chRabbitPick = new ImageIcon("img/character/rabbitProfile.png");
	private ImageIcon chBearPick = new ImageIcon("img/character/bearProfile.png");
	private ImageIcon chAstronautPick = new ImageIcon("img/character/AstronautProfile.png");

	// 시작 버튼 이미지 아이콘
	private ImageIcon start = new ImageIcon("img/button/GameStartBtn.png");

	private JButton ch1;
	private JButton ch2;
	private JButton ch3;
	private JButton ch4;

	// 시작 버튼
	private JButton StartBtn;

	// 게임에서 사용할 캐릭터 이미지들을 담을 오브젝트
	private Character1P ci1P;
	private Character1P ci2P;
	private CharacterAbility1P ca1P;
	private CharacterAbility1P ca2P;

	public Character1P getCi1P() {
		return ci1P;
	}

	public Standby(Object o) {

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
					ci1P = new Character1P(new ImageIcon("img/character/catFont.png"),
							new ImageIcon("img/character/catback.png"), new ImageIcon("img/character/catleft.png"),
							new ImageIcon("img/character/catright.png"), new ImageIcon("img/character/catdie.png"));

				} else if (e.getButton() == MouseEvent.BUTTON3) {
					ch1.setIcon(chCatPick);
					ch2.setIcon(chRabbit);
					ch3.setIcon(chBear);
					ch4.setIcon(chAstronaut);
					ci2P = new Character1P(new ImageIcon("img/character/catFont.png"),
							new ImageIcon("img/character/catback.png"), new ImageIcon("img/character/catleft.png"),
							new ImageIcon("img/character/catright.png"), new ImageIcon("img/character/catdie.png"));
				}

			}
		});
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
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					ch1.setIcon(chCat);
					ch2.setIcon(chRabbitPick);
					ch3.setIcon(chBear);
					ch4.setIcon(chAstronaut);
					ci2P = new Character1P(new ImageIcon("img/character/rabbitleftFont.png"),
							new ImageIcon("img/character/rabbitback.png"),
							new ImageIcon("img/character/rabbitleft.png"),
							new ImageIcon("img/character/rabbitright.png"),
							new ImageIcon("img/character/rabbitdie.png"));
				}

			}
		});
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
							new ImageIcon("img/character/bearback.png"), new ImageIcon("img/character/bearleft.png"),
							new ImageIcon("img/character/bearright.png"), new ImageIcon("img/character/beardie.png"));
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					ch1.setIcon(chCat);
					ch2.setIcon(chRabbit);
					ch3.setIcon(chBearPick);
					ch4.setIcon(chAstronaut);
					ci2P = new Character1P(new ImageIcon("img/character/bearFont.png"),
							new ImageIcon("img/character/bearback.png"), new ImageIcon("img/character/bearleft.png"),
							new ImageIcon("img/character/bearright.png"), new ImageIcon("img/character/beardie.png"));
				}

			}
		});
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
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					ch1.setIcon(chCat);
					ch2.setIcon(chRabbit);
					ch3.setIcon(chBear);
					ch4.setIcon(chAstronautPick);
					ci2P = new Character1P(new ImageIcon("img/character/astronautFont.png"),
							new ImageIcon("img/character/astronautback.png"),
							new ImageIcon("img/character/astronautleft.png"),
							new ImageIcon("img/character/astronautright.png"),
							new ImageIcon("img/character/astronautdie.png"));
				}

			}
		});
		ch1.setBounds(90, 102, 150, 200);
		add(ch1);
		ch1.setBorderPainted(false);
		ch1.setContentAreaFilled(false);
		ch1.setFocusPainted(false);

	}
}
