package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Explain extends JPanel {
	private ImageIcon explainIc = new ImageIcon("img/background/explain.png"); // 설명창 이미지

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다

		g.drawImage(explainIc.getImage(), 0, 0, null);
	}

	private ImageIcon backIc = new ImageIcon("img/button/back.png"); // 뒤로가기 버튼 이미지 주소
	private JButton backBtn;

	public Explain(Object o) { // 리스너 추가를 위해서 Object o 인자 추가
		setLayout(null);
		backBtn = new JButton(backIc);
		backBtn.setName("backBtn");

		backBtn.addActionListener((ActionListener) o);

		backBtn.setBounds(44, 30, 69, 115);

		add(backBtn);

		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
	}
}