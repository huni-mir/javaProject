package controlller;

import model.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Character_Move_test1 extends JFrame {

	/*private ImageIcon font1P; // 정면
	private ImageIcon back1P; // 뒷면
	private ImageIcon left1P; // 왼쪽
	private ImageIcon right1P;// 오른쪽
	private ImageIcon dieimg1P; // 죽음
	
	private ImageIcon font2P; // 정면
	private ImageIcon back2P; // 뒷면
	private ImageIcon left2P; // 왼쪽
	private ImageIcon right2P;// 오른쪽
	private ImageIcon dieimg2P; // 죽음*/
	
	// 키 눌릴 처리
    private boolean key_Up, key_Down, key_Left, key_Right;
    
    private JLabel astronaut = new JLabel();
    private JLabel bear = new JLabel();

    private int myX = 100;  // Initial X coordinate for astronaut
    private int myY = 100;  // Initial Y coordinate for astronaut

    private int enemyX = 500;  // Initial X coordinate for bear
    private int enemyY = 100;  // Initial Y coordinate for bear

    public Character_Move_test1() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyPress(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyRelease(e.getKeyCode());
            }
        });

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        astronaut.setSize(44, 56);
        astronaut.setLocation(myX, myY);
        contentPane.add(astronaut);

        bear.setSize(44, 56);
        bear.setLocation(enemyX, enemyY);
        contentPane.add(bear);

        // You may want to set up your JFrame and other components here
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void KeyPress(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_R:
                key_Up = true;
                // Update images or perform other actions
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_F:
                key_Down = true;
                // Update images or perform other actions
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_D:
                key_Left = true;
                // Update images or perform other actions
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_G:
                key_Right = true;
                // Update images or perform other actions
                break;
        }
    }
    private void KeyRelease(int keyCode) {
        switch (keyCode) {
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
    private void updateImages() {
        // You can set the images based on the key states here
        // For example:
        if (key_Up) {
            astronaut.setIcon(new ImageIcon("images/astronautBack.png"));
            bear.setIcon(new ImageIcon("images/bearBack.png"));
        } else if (key_Down) {
            astronaut.setIcon(new ImageIcon("images/astronautFont.png"));
            bear.setIcon(new ImageIcon("images/bearFont.png"));
        }
        else if (key_Left) {
            astronaut.setIcon(new ImageIcon("images/astronautLeft.png"));
            bear.setIcon(new ImageIcon("images/bearLeft.png"));
        }
        else if (key_Right) {
        	astronaut.setIcon(new ImageIcon("images/astronautRight.png"));
        	bear.setIcon(new ImageIcon("images/bearRight.png"));
        }
    }
    public static void main(String[] args) {
        new Character_Move_test1();
    }
}