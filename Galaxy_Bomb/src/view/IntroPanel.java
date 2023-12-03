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
	private JButton StartBtn = new JButton();
	private JButton ExplainBtn = new JButton();
	private JButton ExitBtn = new JButton();

	public IntroPanel(Object o) { // 리스너 추가를 위해서 Object o 인자 추가
		setLayout(null);

		// 버튼 생성
		StartBtn = new JButton(new ImageIcon("img/button/gameStart.png"));
		StartBtn.setName("FirstStartBtn");

		ExplainBtn = new JButton(new ImageIcon("img/button/gameEx.png"));
		ExplainBtn.setName("ExplainBtn");

		ExitBtn = new JButton(new ImageIcon("img/button/gameQuit.png"));
		ExitBtn.setName("ExitBtn");

		// 버튼에 리스너 추가
		StartBtn.addActionListener((ActionListener) o);
		ExplainBtn.addActionListener((ActionListener) o);
		ExitBtn.addActionListener((ActionListener) o);

		// 버튼 위치, 크기 설정
		StartBtn.setBounds(625, 521, 351, 95);
		ExplainBtn.setBounds(625, 646, 351, 95);
		ExitBtn.setBounds(625, 771, 351, 95);

		// 각 버튼 기본 배경 제거
		StartBtn.setBorderPainted(false);
		StartBtn.setContentAreaFilled(false);
		StartBtn.setFocusPainted(false);
		ExplainBtn.setBorderPainted(false);
		ExplainBtn.setContentAreaFilled(false);
		ExplainBtn.setFocusPainted(false);
		ExitBtn.setBorderPainted(false);
		ExitBtn.setContentAreaFilled(false);
		ExitBtn.setFocusPainted(false);

		// 패널에 버튼 추가
		add(StartBtn);
		add(ExplainBtn);
		add(ExitBtn);

		// 버튼에 마우스 올릴 시 이미지 변경
		StartBtn.setRolloverIcon(new ImageIcon("img/button/gameStartSelect.png"));
		ExplainBtn.setRolloverIcon(new ImageIcon("img/button/gameExSelect.png"));
		ExitBtn.setRolloverIcon(new ImageIcon("img/button/gameQuitSelect.png"));
	}
}