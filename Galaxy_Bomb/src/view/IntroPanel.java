package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IntroPanel extends JPanel {
	private ImageIcon introImg = new ImageIcon("img/background/intro.png"); // 인트로 배경 이미지

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다

		g.drawImage(introImg.getImage(), 0, 0, null); // 인트로 배경 이미지 그리기
	}

	// 버튼 선언
	private JButton startBtn = new JButton();
	private JButton explainBtn = new JButton();
	private JButton exitBtn = new JButton();

	public IntroPanel(Object o) { // 리스너 추가를 위해서 Object o 인자 추가
		setLayout(null);

		// 버튼 생성
		startBtn = new JButton(new ImageIcon("img/button/gameStart.png"));
		startBtn.setName("firstStartBtn");

		explainBtn = new JButton(new ImageIcon("img/button/gameEx.png"));
		explainBtn.setName("explainBtn");

		exitBtn = new JButton(new ImageIcon("img/button/gameQuit.png"));
		exitBtn.setName("exitBtn");

		// 버튼에 리스너 추가
		startBtn.addActionListener((ActionListener) o);
		explainBtn.addActionListener((ActionListener) o);
		exitBtn.addActionListener((ActionListener) o);

		// 버튼 위치, 크기 설정
		startBtn.setBounds(625, 521, 351, 95);
		explainBtn.setBounds(625, 646, 351, 95);
		exitBtn.setBounds(625, 771, 351, 95);

		// 각 버튼 기본 배경 제거
		startBtn.setBorderPainted(false);
		startBtn.setContentAreaFilled(false);
		startBtn.setFocusPainted(false);
		explainBtn.setBorderPainted(false);
		explainBtn.setContentAreaFilled(false);
		explainBtn.setFocusPainted(false);
		exitBtn.setBorderPainted(false);
		exitBtn.setContentAreaFilled(false);
		exitBtn.setFocusPainted(false);

		// 패널에 버튼 추가
		add(startBtn);
		add(explainBtn);
		add(exitBtn);

		// 버튼에 마우스 올릴 시 이미지 변경
		startBtn.setRolloverIcon(new ImageIcon("img/button/gameStartSelect.png"));
		explainBtn.setRolloverIcon(new ImageIcon("img/button/gameExSelect.png"));
		exitBtn.setRolloverIcon(new ImageIcon("img/button/gameQuitSelect.png"));
	}
}