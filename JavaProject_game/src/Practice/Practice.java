package Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import view.*;

public class Practice extends Listener {
	private JFrame frame = new JFrame(); // 창을 띄우기 위한 프레임

	private Intro intro; // 인트로
	private Explain explain;
	private Standby standby;
	
	public Practice() {
		intro = new Intro(this);
		explain = new Explain(this);
		standby = new Standby(this);
		
		frame.setTitle("Galaxy Bomb");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		intro.setBounds(0, 0, 1600, 900);
		explain.setBounds(0, 0, 1600, 900);
		standby.setBounds(0, 0, 1600, 900);
		
		frame.add(intro);
		frame.add(explain);
		frame.add(standby);
		
		explain.setVisible(false);
		standby.setVisible(false);
		
		frame.setSize(1616, 939);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = (JButton)e.getSource();
		
		if (btn.getName().equals("StartBtn")) { // 시작 버튼 누를 시
			intro.setVisible(false);
			standby.setVisible(true);
		}
		else if (btn.getName().equals("ExplainBtn")) { // 설명 버튼 누를 시
			intro.setVisible(false);
			explain.setVisible(true);
		}
		else if (btn.getName().equals("ExitBtn")) { // 종료 버튼 누를 시
			System.exit(0);		// 게임 종료
		}
		else if (btn.getName().equals("backBtn")) {
			explain.setVisible(false);
			intro.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Practice();
	}
}