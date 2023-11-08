package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Intro extends JPanel{
private ImageIcon introIc = new ImageIcon("img/background/intro"); // 인트로 이미지
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다
		
		g.drawImage(introIc.getImage(), 0, 0, null);
		
	}
	private ImageIcon start = new ImageIcon("img/button/gameStart"); //시작 버튼 이미지 주소
	private ImageIcon explain = new ImageIcon("img/button/gameEx"); //설명 버튼 이미지 주소
	private ImageIcon exit = new ImageIcon("img/button/gameQuit"); //종료 버튼 이미지 주소
	private JButton StartBtn;
	private JButton ExplainBtn;
	private JButton ExitBtn;
	
	private Intro(Object o) {
		StartBtn = new JButton(start);
		StartBtn.setName("StartBtn");
		ExplainBtn = new JButton(explain);
		ExplainBtn.setName("ExplainBtn");
		ExitBtn = new JButton(exit);
		ExitBtn.setName("ExitBtn");
		StartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				JButton start = (JButton)o.getSource();
				//캐릭터 고르는 화면으로 이동
			}
		});
		ExplainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				JButton explain = (JButton)o.getSource();
				//게임 설명 패널
			}
		});
		ExitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				JButton exit = (JButton)o.getSource();
				System.exit(0);
			}
		});
		StartBtn.setBounds(620, 521, 351, 95);
		ExplainBtn.setBounds(620, 646, 351, 95);
		ExitBtn.setBounds(620, 771, 351, 95);
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
		
	}
}
//시작 화면