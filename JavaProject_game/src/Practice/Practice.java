package Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import view.*;

public class Practice extends JFrame {
	private JFrame frame; // 창을 띄우기 위한 프레임

	private Intro intro = new Intro(); // 인트로
	private Explain explain = new Explain();
	
	public Practice() {
		setTitle("Galaxy Bomb");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		intro.setBounds(0, 0, 1600, 900);
		explain.setBounds(0, 0, 1600, 900);
		//Standby.setBounds(0, 0, 1600, 900);
		
		add(intro);
		add(explain);
		//add(Standby);
		
		explain.setVisible(false);
		//Standby.setVisible(false);
		
		setSize(1616, 939);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Practice();
	}
}