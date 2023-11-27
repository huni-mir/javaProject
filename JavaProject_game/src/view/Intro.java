package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Intro extends JPanel {
	private ImageIcon introIc = new ImageIcon("img/background/intro.png"); // 인트로 이미지

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다

		g.drawImage(introIc.getImage(), 0, 0, null);

	}

	private ImageIcon startIc = new ImageIcon("img/button/gameStart.png"); // 시작 버튼 이미지 주소
	private ImageIcon explainIc = new ImageIcon("img/button/gameEx.png"); // 설명 버튼 이미지 주소
	private ImageIcon exitIc = new ImageIcon("img/button/gameQuit.png"); // 종료 버튼 이미지 주소
	private ImageIcon startSelect = new ImageIcon("img/button/gameStartSelect.png"); // 시작 버튼 선택
	private ImageIcon explainSelect = new ImageIcon("img/button/gameExSelect.png"); // 설명 버튼 선택
	private ImageIcon exitSelect = new ImageIcon("img/button/gameQuitSelect.png"); // 종료 버튼 선택
	private JButton StartBtn;
	private JButton ExplainBtn;
	private JButton ExitBtn;

	public Intro(Object o) { // 리스너 추가를 위해서 Object o 인자 추가
		setLayout(null);
		StartBtn = new JButton(startIc);
		StartBtn.setName("FirstStartBtn");
		ExplainBtn = new JButton(explainIc);
		ExplainBtn.setName("ExplainBtn");
		ExitBtn = new JButton(exitIc);
		ExitBtn.setName("ExitBtn");

		StartBtn.addActionListener((ActionListener) o);
		ExplainBtn.addActionListener((ActionListener) o);
		ExitBtn.addActionListener((ActionListener) o);

		StartBtn.setBounds(625, 521, 351, 95);
		ExplainBtn.setBounds(625, 646, 351, 95);
		ExitBtn.setBounds(625, 771, 351, 95);

		add(StartBtn);
		add(ExplainBtn);
		add(ExitBtn);

		StartBtn.setBorderPainted(false);
		StartBtn.setContentAreaFilled(false);
		StartBtn.setFocusPainted(false);
		ExplainBtn.setBorderPainted(false);
		ExplainBtn.setContentAreaFilled(false);
		ExplainBtn.setFocusPainted(false);
		ExitBtn.setBorderPainted(false);
		ExitBtn.setContentAreaFilled(false);
		ExitBtn.setFocusPainted(false);

		StartBtn.setRolloverIcon(startSelect);
		ExplainBtn.setRolloverIcon(explainSelect);
		ExitBtn.setRolloverIcon(exitSelect);
	}
}
//시작 화면