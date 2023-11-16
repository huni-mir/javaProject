package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Beullog extends JPanel{
	int size;
	int size1;
	  String map[][];

	   public Beullog(int size, int size1) {
	      this.size = size;
	      this.size1 = size1;
	      map = new String[size][size1];
	      this.setLayout(null);
	      this.setBounds(0, 0, 1200, 900);

	   }
}


public class GameMap extends JPanel{
	private ImageIcon MainGame = new ImageIcon("img/background/MainGame.png"); // 인트로 이미지
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다
			
		g.drawImage(MainGame.getImage(), 0, 0, null);
		
	}
	private JLabel beullog1 = new JLabel(new ImageIcon("img/block/Block.png"));
	private JLabel beullog2 = new JLabel(new ImageIcon("img/block/BlueBlock.png"));
	private JLabel beullog3 = new JLabel(new ImageIcon("img/block/PinkBlock.png"));
	private JLabel beullog4 = new JLabel(new ImageIcon("img/block/RedBlock.png"));
	private JLabel beullog5 = new JLabel(new ImageIcon("img/block/SkyBlock.png"));
	

	private GameMap() {
		setLayout(null);
		 Beullog beullog = new Beullog(12,16);
	        for (int i = 0; i < beullog.size; i++) {
	           for (int j = 0; j < beullog.size1; j++) {
	        	   beullog.map[i][j] = "1";
	              String block = beullog.map[i][j];
	              if ((i == 0 && j <3) || (i==0 && (j>12 && j<16))) {
	                 JLabel beullog1 = new JLabel(new ImageIcon("img/block/RedBlock.png"));
	                 
	                 this.add(beullog1);
	                 beullog1.setBounds(i * 70 + 12, j * 40+16, 75, 75);
	              } break;

	           }
		      }
}
}