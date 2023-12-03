package Controller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.ExplainPanel;
import view.GamePanel;
import view.IntroPanel;
import view.SelectPanel;

public class Main extends Listener {
	private JFrame frame = new JFrame(); // 창을 띄우기 위한 프레임

	private IntroPanel introPanel; // 인트로 패널
	private ExplainPanel explainPanel; // 설명 패널
	private SelectPanel selectPanel; // 캐릭터 선택 패널
	private GamePanel gamePanel; // 게임 맵 패널

	public Main() { // 프레임 영역
		introPanel = new IntroPanel(this);
		explainPanel = new ExplainPanel(this);
		selectPanel = new SelectPanel(this);

		frame.setTitle("Galaxy Bomb");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);

		introPanel.setBounds(0, 0, 1600, 900);
		explainPanel.setBounds(0, 0, 1600, 900);
		selectPanel.setBounds(0, 0, 1600, 900);

		frame.add(introPanel);
		frame.add(explainPanel);
		frame.add(selectPanel);

		explainPanel.setVisible(false);
		selectPanel.setVisible(false);
		// gamePanel.setVisible(false);

		frame.setSize(1616, 939);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void gamestart() {
		gamePanel = new GamePanel(this);

		gamePanel.setBounds(0, 0, 1200, 900);
		frame.add(gamePanel);
		gamePanel.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) { // 버튼 리스너
		JButton btn = (JButton) e.getSource();

		if (btn.getName().equals("FirstStartBtn")) { // 인트로 시작 버튼 누를 시
			introPanel.setVisible(false);
			selectPanel.setVisible(true);
		} else if (btn.getName().equals("ExplainBtn")) { // 설명 버튼 누를 시
			introPanel.setVisible(false);
			explainPanel.setVisible(true);
		} else if (btn.getName().equals("ExitBtn")) { // 종료 버튼 누를 시
			System.exit(0); // 게임 종료
		} else if (btn.getName().equals("backBtn")) { // 뒤로가기 버튼 누를 시
			explainPanel.setVisible(false);
			selectPanel.setVisible(false);
			introPanel.setVisible(true);
		} else if (btn.getName().equals("StartBtn")) { // 스탠바이에서 시작 버튼 누를 시
			if (selectPanel.getcv1P() == null) {
				JOptionPane.showMessageDialog(null, "1P캐릭터를 골라주세요"); // 캐릭터를 안골랐을경우 팝업
			} else if (selectPanel.getcv2P() == null) {
				JOptionPane.showMessageDialog(null, "2P캐릭터를 골라주세요"); // 캐릭터를 안골랐을경우 팝업
			} else {
				selectPanel.setVisible(false);

				gamestart();

				gamePanel.requestFocus();
				gamePanel.setFocusable(true);
				gamePanel.gameSet(selectPanel.getcv1P(), selectPanel.getcv2P());

				frame.setSize(1216, 939);
				frame.setLocationRelativeTo(null);
			}
		} else if (btn.getName().equals("restartBtn")) {
			gamePanel.setVisible(false);
			frame.setSize(1616, 939);
			frame.setLocationRelativeTo(null);
			selectPanel.setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}