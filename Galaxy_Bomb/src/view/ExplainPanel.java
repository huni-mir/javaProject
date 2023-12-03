package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExplainPanel extends JPanel {
	private ImageIcon explainIc = new ImageIcon("img/background/explain.png"); // 설명 이미지

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다

		g.drawImage(explainIc.getImage(), 0, 0, null); // 설명 이미지 그리기
	}

	// 뒤로가기 버튼 선언
	private JButton backBtn;

	public ExplainPanel(Object o) { // 리스너 추가를 위해서 Object o 인자 추가
		setLayout(null);

		// 뒤로가기 버튼 생성
		backBtn = new JButton(new ImageIcon("img/button/back.png"));
		backBtn.setName("backBtn");

		// 버튼에 리스너 추가
		backBtn.addActionListener((ActionListener) o);

		// 뒤로가기 버튼 위치, 사이즈 설정
		backBtn.setBounds(44, 30, 69, 115);

		// 패널에 버튼 추가
		add(backBtn);

		// 버튼 기본 배경 제거
		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
	}
}