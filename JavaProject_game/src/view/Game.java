package view;

import java.awt.Graphics;

import javax.swing.*;

public class Game extends JPanel {
	private ImageIcon backIc = new ImageIcon("img/background/MainGame.png"); //게임 배경화면
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다
			
		g.drawImage(backIc.getImage(), 0, 0, null);
		
	}
}
