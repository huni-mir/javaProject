package view;

import java.awt.Graphics;
import java.awt.*;

import javax.swing.*;

public class Game extends JFrame {
	private JLabel contentPane;
	public void Game() {
		
	}
	public void Map() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setBounds(0, 0, 1200, 900);
	      setLocationRelativeTo(null);
	      contentPane = new JLabel(new ImageIcon("img/background/MainGame.png"));//게임 배경화면
	      contentPane.setLayout(null);
	      setContentPane(contentPane);
	      
	      Beullog beullog = new Beullog();
	      JLabel beullog1 = new JLabel(new ImageIcon("img/background/Block.png"));
	      JLabel beullog2 = new JLabel(new ImageIcon("img/background/BlueBlock.png"));
	      JLabel beullog3 = new JLabel(new ImageIcon("img/background/PinkBlock.png"));
	      JLabel beullog4 = new JLabel(new ImageIcon("img/background/RedBlock.png"));
	      JLabel beullog5 = new JLabel(new ImageIcon("img/background/SkyBlock.png"));
	      beullog4.setBounds(0,0,75,75);
	      this.add(beullog4);
	      beullog4.setBounds(75,0,75,75);
	      this.add(beullog4);
	      beullog4.setBounds(150,0,75,75);
	      this.add(beullog4);
	      beullog4.setBounds(0,75,75,75);
	      this.add(beullog4);//왼쪽 위
	      
	      beullog4.setBounds(0,750,75,75);
	      this.add(beullog4);
	      beullog4.setBounds(75,825,75,75);
	      this.add(beullog4);
	      beullog4.setBounds(150,825,75,75);
	      this.add(beullog4);
	      beullog4.setBounds(0,825,75,75);
	      this.add(beullog4);//왼쪽 아래
	      
	      beullog4.setBounds(975,0,75,75);
	      this.add(beullog4);
	      beullog4.setBounds(1050,0,75,75);
	      this.add(beullog4);
	      beullog4.setBounds(1125,0,75,75);
	      this.add(beullog4);
	      beullog4.setBounds(1125, 75,75,75);
	      this.add(beullog4);//오른쪽 위
	      
	      beullog4.setBounds(975,825,75,75);
	      this.add(beullog4);
	      beullog4.setBounds(1050,825,75,75);
	      this.add(beullog4);
	      beullog4.setBounds(1125,750,75,75);
	      this.add(beullog4);
	      beullog4.setBounds(1125, 825,75,75);
	      this.add(beullog4);//오른쪽 아래
	      
	      beullog5.setBounds(0,225,75,75);
	      this.add(beullog5);
	      beullog5.setBounds(75,225,75,75);
	      this.add(beullog5);
	      beullog5.setBounds(150,225,75,75);
	      this.add(beullog5);
	      beullog5.setBounds(75,300,75,75);
	      this.add(beullog5);
	      beullog5.setBounds(75,375,75,75);
	      this.add(beullog5);
	      beullog5.setBounds(75,450,75,75);
	      this.add(beullog5);
	      beullog5.setBounds(75,525,75,75);
	      this.add(beullog5);
	      beullog5.setBounds(0,525,75,75);
	      this.add(beullog5);// J
	      
	      beullog3.setBounds(300,225,75,75);
	      this.add(beullog3);
	      beullog3.setBounds(375,225,75,75);
	      this.add(beullog3);
	      beullog3.setBounds(225,300,75,75);
	      this.add(beullog3);
	      beullog3.setBounds(450,300,75,75);
	      this.add(beullog3);
	      beullog3.setBounds(300,375,75,75);
	      this.add(beullog3);
	      beullog3.setBounds(375,375,75,75);
	      this.add(beullog3);
	      beullog3.setBounds(450,375,75,75);
	      this.add(beullog3);
	      beullog3.setBounds(525,375,75,75);
	      this.add(beullog3);
	      beullog3.setBounds(300,450,75,75);
	      this.add(beullog3);
	      beullog3.setBounds(450,450,75,75);
	      this.add(beullog3);
	      beullog3.setBounds(300,525,75,75);
	      this.add(beullog3);
	      beullog3.setBounds(450,525,75,75);
	      this.add(beullog3);// A
	      
	      beullog2.setBounds(525,225,75,75);
	      this.add(beullog2);
	      beullog2.setBounds(825,225,75,75);
	      this.add(beullog2);
	      beullog2.setBounds(525,300,75,75);
	      this.add(beullog2);
	      beullog2.setBounds(825,300,75,75);
	      this.add(beullog2);
	      beullog2.setBounds(525,375,75,75);
	      this.add(beullog2);
	      beullog2.setBounds(825,375,75,75);
	      this.add(beullog2);
	      beullog2.setBounds(600,450,75,75);
	      this.add(beullog2);
	      beullog2.setBounds(750,450,75,75);
	      this.add(beullog2);
	      beullog2.setBounds(675,525,75,75);
	      this.add(beullog2);// V
	      
	      beullog3.setBounds(975,225,75,75);
	      this.add(beullog3);
	      beullog3.setBounds(1050,225,75,75);
	      this.add(beullog2);
	      beullog3.setBounds(900,300,75,75);
	      this.add(beullog2);
	      beullog3.setBounds(1125,300,75,75);
	      this.add(beullog2);
	      beullog3.setBounds(900,375,75,75);
	      this.add(beullog2);
	      beullog3.setBounds(975,375,75,75);
	      this.add(beullog2);
	      beullog3.setBounds(1050,375,75,75);
	      this.add(beullog2);
	      beullog3.setBounds(1125,375,75,75);
	      this.add(beullog2);
	      beullog3.setBounds(900,450,75,75);
	      this.add(beullog2);
	      beullog3.setBounds(1125,450,75,75);
	      this.add(beullog2);
	      beullog3.setBounds(900,525,75,75);
	      this.add(beullog2);
	      beullog3.setBounds(1125,525,75,75);
	      this.add(beullog2);// A
	      
	      
	}
}
