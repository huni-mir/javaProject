package view;

import javax.swing.*;
import java.awt.*;

public class Intro extends JPanel{
ImageIcon introIc = new ImageIcon(""); // 인트로 이미지
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다
		
		g.drawImage(introIc.getImage(), 0, 0, null);
	}
	public Intro() {
		
	}
}
//시작 화면