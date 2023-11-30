package controlller;

import javax.swing.*;
import view.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Character_Move extends JPanel implements KeyListener {
    private boolean[] char1Key = new boolean[256];
    private boolean[] char2Key = new boolean[256];
    private int char1x = 0;
    private int char1y = 0;
    private int char2x = 0;
    private int char2y = 0;
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // 1p
        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_A ||
            keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_D ||
            keyCode == KeyEvent.VK_SHIFT) {
            char1Key[keyCode] = true;
        }

        // 2p
        else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN ||
                 keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT ||
                 keyCode == KeyEvent.VK_CONTROL) {
            char2Key[keyCode] = true;
        }

        // 여기서 각 플레이어의 입력에 따른 게임 로직을 수행
        processInputs();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();   
        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_A ||
            keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_D ) {
            char1Key[keyCode] = false;
            // 1p
        }
        else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN ||
                 keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
            char2Key[keyCode] = false;
            //2p
        }
        processInputs();
    }

    private void processInputs() {
    	//1p
    	if (char1Key[KeyEvent.VK_W]) {
    		//font1Label.setLocation(font1Label.getX(),font1Label.getY()-10);
            char1y -= 10; // 위로 이동
        }
        if (char1Key[KeyEvent.VK_A]) {
            char1x -= 10; // 왼쪽으로 이동
        }
        if (char1Key[KeyEvent.VK_S]) {
            char1y += 10; // 아래로 이동
        }
        if (char1Key[KeyEvent.VK_D]) {
            char1x += 10; // 오른쪽으로 이동
        }
        if (char1Key[KeyEvent.VK_SHIFT]) {
        	//new Thread(one).start(); //one 스레드 dropBomb
        }

        //2p
        if (char2Key[KeyEvent.VK_UP]) {
            char2y -= 10; // 위로 이동
        }
        if (char2Key[KeyEvent.VK_LEFT]) {
            char2x -= 10; // 왼쪽으로 이동
        }
        if (char2Key[KeyEvent.VK_DOWN]) {
            char2y += 10; // 아래로 이동
        }
        if (char2Key[KeyEvent.VK_RIGHT]) {
            char2x += 10; // 오른쪽으로 이동
        }
        if (char2Key[KeyEvent.VK_CONTROL]) {
        	//new Thread(one).start();
        }
    }
    //thread dropBomp 추가 해야됨
}