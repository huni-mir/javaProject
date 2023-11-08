package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Intro extends JPanel{
private ImageIcon introIc = new ImageIcon(""); // 인트로 이미지
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다
		
		g.drawImage(introIc.getImage(), 0, 0, null);
		
	}
	private ImageIcon start = new ImageIcon(""); //시작 버튼 이미지 주소
	private ImageIcon explain = new ImageIcon(""); //설명 버튼 이미지 주소
	private ImageIcon exit = new ImageIcon(""); //종료 버튼 이미지 주소
	private JButton StartBtn;
	private JButton ExplainBtn;
	private JButton ExitBtn;
	
	private Intro(Object o) {
		StartBtn = new JButton(start);
		StartBtn.setName("StartBtn");
		StartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				JButton start = (JButton)o.getSource();
				//캐릭터 고르는 화면으로 이동
			}
		});
		StartBtn.setBounds(254, 334, 291, 81);
		add(StartBtn);
		StartBtn.setBorderPainted(false);
		StartBtn.setContentAreaFilled(false);
		StartBtn.setFocusPainted(false);
		
	}
}
//시작 화면