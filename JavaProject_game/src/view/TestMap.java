package view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestMap extends JFrame {
	public TestMap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600,945);
        //setBounds(0, 0, 1600, 900);
        setLocationRelativeTo(null);
       setContentPane(new GameMap());
       setVisible(true);
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
			 Beullog beullog = new Beullog(16,12);
		        for (int i = 0; i < beullog.size; i++) {
		           for (int j = 0; j < beullog.size1; j++) {
		        	   beullog.map[i][j] = "1";
		              String block = beullog.map[i][j];
		              if (i < 3 && j ==0 || ((i>12 && i<16)&& j==0)/*1번쨰열*/ 
		            	|| i<1  && j ==1 || ((i>14 && i<16)&& j==1)/*2번쨰열*/
		            	|| i<1  && j ==10 || ((i>14 && i<16)&& j==10)/*11번쨰열*/
		            	|| i<3  && j ==11 || ((i>12 && i<16)&& j==11)/*12번쨰열*/) {
		                 JLabel beullog1 = new JLabel(new ImageIcon("img/block/RedBlock.png"));
		                 //item.add 자리
		                 this.add(beullog1);
		                 beullog1.setBounds(i * 75, j * 75, 75, 75);
		              } else if(i < 3 && j ==3 /*4번쨰열*/ 
				            	|| i<3  && j ==1 || ((i>14 && i<16)&& j==1)/*5번쨰열*/
				            	|| i<1  && j ==10 || ((i>14 && i<16)&& j==10)/*6번쨰열*/
				            	|| i<3  && j ==11 || ((i>12 && i<16)&& j==11)/*7번쨰열*/
				            	|| i<3  && j ==11 || ((i>12 && i<16)&& j==11)/*8번쨰열*/) {
				                 JLabel beullog5 = new JLabel(new ImageIcon("img/block/SkyBlock.png"));
				                 //item.add 자리
				                 this.add(beullog5);
				                 beullog5.setBounds(i * 75, j * 75, 75, 75);
				              } 
		           }
		           }
		        
		           }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestMap();
	}

	}