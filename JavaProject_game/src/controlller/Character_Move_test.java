package controlller;

import javax.swing.JFrame;
import javax.swing.JLabel;

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
    private boolean key_Up, key_R;
    private boolean key_Down, key_F;
    private boolean key_Left, key_D;
    private boolean key_Right, key_G;

    private JLabel astronaut = new JLabel();
    private JLabel bear = new JLabel();
    
    private int myX = 100;  // Initial X coordinate for astronaut
    private int myY = 100;  // Initial Y coordinate for astronaut

    private int enemyX = 500;  // Initial X coordinate for bear
    private int enemyY = 100;  // Initial Y coordinate for bear

    
    public Character_Move_test() {	
        addKeyListener(new KeyAdapter() {
            @Override
            // 키가 눌렸을 때
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_R:
                        key_Up = true;
                        astronaut("images/astronautBack.png");
                        bear("images/bearBack.png");
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_F:
                        key_Down = true;
                        astronaut("images/astronautFont.png");
                        bear("images/bearFont.png");
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_D:
                        key_Left = true;
                        //astronaut("images/astronautFont.png"); 왼쪽 이미지 추가
                        //bear("images/bearFont.png"); 왼쪽 이미지 추가
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_G:
                        key_Right = true;
                        //astronaut("images/astronautFont.png"); 오른쪽 이미지 추가
                        //bear("images/bearFont.png"); 오른쪽 이미지 추가
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
    	Character_Move_test controllTest = new Character_Move_test();
        controllTest.setSize(1600, 900);
        controllTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controllTest.setVisible(true);
    }
}