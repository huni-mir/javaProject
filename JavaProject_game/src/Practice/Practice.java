package Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import view.*;

public class Practice extends Listener {
	private JFrame frame = new JFrame(); // 창을 띄우기 위한 프레임

	private Intro intro; // 인트로 패널
	private Explain explain; // 설명 패널
	private Standby standby; // 캐릭터 선택 패널
	private GameMap gameMap; // 게임 맵 패널

	public Practice() { // 프레임 영역
		intro = new Intro(this);
		explain = new Explain(this);
		standby = new Standby(this);
		gameMap = new GameMap();

		frame.setTitle("Galaxy Bomb");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);

		intro.setBounds(0, 0, 1600, 900);
		explain.setBounds(0, 0, 1600, 900);
		standby.setBounds(0, 0, 1600, 900);
		gameMap.setBounds(0, 0, 1200, 900);

		frame.add(intro);
		frame.add(explain);
		frame.add(standby);
		frame.add(gameMap);

		explain.setVisible(false);
		standby.setVisible(false);
		gameMap.setVisible(false);

		frame.setSize(1616, 939);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) { // 버튼 리스너
		JButton btn = (JButton) e.getSource();

		if (btn.getName().equals("FirstStartBtn")) { // 인트로 시작 버튼 누를 시
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
		else if (btn.getName().equals("backBtn")) { // 뒤로가기 버튼 누를 시
			explain.setVisible(false);
			standby.setVisible(false);
			intro.setVisible(true);
		}
		else if (btn.getName().equals("StartBtn")) { // 스탠바이에서 시작 버튼 누를 시
			if (standby.getci1P() == null) {
				JOptionPane.showMessageDialog(null, "1P캐릭터를 골라주세요"); // 캐릭터를 안골랐을경우 팝업
			} else if (standby.getci2P() == null) {
				JOptionPane.showMessageDialog(null, "2P캐릭터를 골라주세요"); // 캐릭터를 안골랐을경우 팝업
			}else{
				gameMap.gameSet(standby.getci1P(),standby.getci2P(),standby.getca1P(),standby.getca2P());
				gameMap.requestFocus(); 
				standby.setVisible(false);
				gameMap.setVisible(true);
			}
		}
	}

	public static void main(String[] args) {
		new Practice();
	}
}