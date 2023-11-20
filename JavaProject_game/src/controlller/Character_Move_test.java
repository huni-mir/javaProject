package controlller;

import model.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Character_Move_test extends JFrame {
	
	/*private ImageIcon font1P; // 정면
	private ImageIcon back1P; // 뒷면
	private ImageIcon left1P; // 왼쪽
	private ImageIcon right1P;// 오른쪽
	private ImageIcon dieimg1P; // 죽음
	
	private ImageIcon font2P; // 정면
	private ImageIcon back2P; // 뒷면
	private ImageIcon left2P; // 왼쪽
	private ImageIcon right2P;// 오른쪽
	private ImageIcon dieimg2P; // 죽음 */
	
    // 키 눌릴 처리
    boolean key_Up, key_R;
    boolean key_Down, key_F;
    boolean key_Left, key_D;
    boolean key_Right, key_G;

    public Character_Move_test() {
    	
        addKeyListener(new KeyAdapter() {
            @Override
            // 키가 눌렸을 때
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_R:
                        key_Up = true;
                        //astronautCurrent("images/astronautBack.png");
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_F:
                        key_Down = true;
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_D:
                        key_Left = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_G:
                        key_Right = true;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_R:
                        key_Up = false;
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_F:
                        key_Down = false;
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_D:
                        key_Left = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_G:
                        key_Right = false;
                        break;
                }
            }
        });
    }
    
        public void astronaut(String imageLocation) {
  	      astronaut.setIcon(new ImageIcon(imageLocation));
  	   }
  	
  	public void bear(String imageLocation) {
  	      bear.setIcon(new ImageIcon(imageLocation));
  	   }
  	
  	private void firstLocation() {
  	      // 
  	      contentPane.add(astronaut);
  	      astronaut.setSize(44, 56);
  	      astronaut.setLocation(myX, myY); //1p
  	      // 
  	      contentPane.add(bear);
  	      bear.setSize(44, 56);
  	      bear.setLocation(enemyX, enemyY); //2p
  	   }
  	
  /*	public void keyProcess() {
  	      if (key == true) {
  	         ("images/astronaut_back.png");
  	         myY -= 10;
  	         astronaut.setLocation(myX, myY);
  	         move = "U";
  	         gt.send(username + ":" + "MOVE:" + move);
  	         if (myY < 0) {
  	            myY = 0;
  	         }
  	      }
  	      
    }*/

    public static void main(String[] args) {
    	Character_Move_test controlTest = new Character_Move_test();
        //controlTest.setSize(1600, 900);
        //controlTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //controlTest.setVisible(true);
    }
}