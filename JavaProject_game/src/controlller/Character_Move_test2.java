package controlller;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Character_Move_test2 extends JFrame {

    private boolean keyUp, keyDown, keyLeft, keyRight;

    // JLabels for characters
    private JLabel ci1pLabel = new JLabel();
    private JLabel ci2pLabel = new JLabel();

    private int myX = 100;
    private int myY = 100;
    private int enemyX = 500;
    private int enemyY = 100;

    // Image icons for characters
    private ImageIcon characterIc;

    // Character objects
    private Character ci1p;
    private Character ci2p;

    public Character_Move_test2() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keyPress(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keyRelease(e.getKeyCode());
            }
        });

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Initialize character objects and set their size and location
        initObject();
        ci1pLabel.setSize(44, 56);
        ci1pLabel.setLocation(myX, myY);
        contentPane.add(ci1pLabel);

        ci2pLabel.setSize(44, 56);
        ci2pLabel.setLocation(enemyX, enemyY);
        contentPane.add(ci2pLabel);

        // Set up JFrame properties
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void keyPress(int keyCode) {
        // Handle key presses
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_R:
                keyUp = true;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_F:
                keyDown = true;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_D:
                keyLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_G:
                keyRight = true;
                break;
        }
    }

    private void keyRelease(int keyCode) {
        // Handle key releases
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_R:
                keyUp = false;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_F:
                keyDown = false;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_D:
                keyLeft = false;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_G:
                keyRight = false;
                break;
        }
    }

    private void updateImages() {
        // Update images based on key states
        // You need to implement this part based on your game logic
    	 if (keyUp) {
             ci1pLabel.setIcon(new ImageIcon("images/Font.png"));
             ci2pLabel.setIcon(new ImageIcon("images/Font.png"));
         } else if (keyDown) {
             ci1pLabel.setIcon(new ImageIcon("images/Back.png"));
             ci2pLabel.setIcon(new ImageIcon("images/Back.png"));
         }
         else if (keyLeft) {
             ci1pLabel.setIcon(new ImageIcon("images/Left.png"));
             ci2pLabel.setIcon(new ImageIcon("images/Left.png"));
         }
         else if (keyRight) {
         	ci1pLabel.setIcon(new ImageIcon("images/Right.png"));
         	ci2pLabel.setIcon(new ImageIcon("images/Right.png"));
         }
    }

    // Initialize image icons and character objects
    private void initObject() {
        characterIc = new ImageIcon("img/Objectimg/character.png"); // Example image path, replace with actual path

        // Create character objects
        ci1p = new Character(characterIc.getImage());
        ci2p = new Character(characterIc.getImage());
    }

    // Class representing a character, you can adjust this according to your needs
    class Character extends JLabel {
        public Character(Image image) {
            super(new ImageIcon(image));
        }
    }

    public static void main(String[] args) {
        new Character_Move_test2();
    }
}
