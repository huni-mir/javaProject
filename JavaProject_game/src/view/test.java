package view;

import java.awt.*;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
public class test extends JFrame{
	 private Vector<JLabel> item = new Vector<JLabel>();
    public test(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600,945);
        //setBounds(0, 0, 1600, 900);
        setLocationRelativeTo(null);
        Container c = getContentPane();
        JLabel Gameimage = new JLabel(new ImageIcon("img/background/MainGame.png"));//게임 배경화면
        c.setBounds(0, 0, 1600, 900);
        c.setLayout(new FlowLayout(FlowLayout.LEFT));
        setVisible(true);
        c.add(Gameimage);
        
        
        Beullog beullog = new Beullog(12,16);
        for (int i = 0; i < beullog.size; i++) {
           for (int j = 0; j < beullog.size; j++) {
        	   beullog.map[i][j] = "1";
              String block = beullog.map[i][j];
              if (i == 0 || j == 14 || i == 14 || j == 0) {
                 JLabel beullog1 = new JLabel(new ImageIcon("img/block/RedBlock.png"));
                 
                 this.add(beullog1);
                 beullog1.setBounds(i * 40 + 15, j * 40, 45, 45);
              } else if (i + j == 8 || i + j == 20 || i == j + 6 || i == j - 6) {
                 JLabel beullog2 = new JLabel(new ImageIcon("img/block/BlueBlock.png"));
                 
                 this.add(beullog2);
                 beullog2.setBounds(i * 40 + 15, j * 40, 45, 45);
              }

           }
	      }
      
    }

	public static void main(String[] args){
        new test();
    }
}
