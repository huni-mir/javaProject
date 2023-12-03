package Controller;

import java.awt.event.*;
import javax.swing.*;

import view.*;

public class Main implements ActionListener {
	private JFrame frame = new JFrame(); // 창을 띄우기 위한 프레임

	private IntroPanel introPanel; // 인트로 패널 선언
	private ExplainPanel explainPanel; // 설명 패널 선언
	private SelectPanel selectPanel; // 캐릭터 선택 패널 선언
	private GamePanel gamePanel; // 게임 맵 패널 선언

	public Main() { // 프레임 영역
		// 패널 생성
		introPanel = new IntroPanel(this);
		explainPanel = new ExplainPanel(this);
		selectPanel = new SelectPanel(this);

		// 프레임 기본 설정
		frame.setTitle("Galaxy Bomb");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);

		// 각 패널 위치, 사이즈 설정
		introPanel.setBounds(0, 0, 1600, 900);
		explainPanel.setBounds(0, 0, 1600, 900);
		selectPanel.setBounds(0, 0, 1600, 900);

		// 프레임에 패널 추가
		frame.add(introPanel);
		frame.add(explainPanel);
		frame.add(selectPanel);

		// 인트로 패널 제외하고 Visible false
		explainPanel.setVisible(false);
		selectPanel.setVisible(false);

		// 프레임 사이즈 설정
		frame.setSize(1616, 939);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// 게임 패널 생성 메소드 (패널 재시작 구현을 위해서 메소드 생성)
	public void gamePanelStart() {
		gamePanel = new GamePanel(this);

		gamePanel.setBounds(0, 0, 1200, 900);
		frame.add(gamePanel);
		// 게임 패널에 포커스 부여
		gamePanel.requestFocus();
		gamePanel.setFocusable(true);
	}
	
	// 캐릭터 선택 패널 생성 메소드
	public void selectPanelStart() {
		selectPanel = new SelectPanel(this);
		
		selectPanel.setBounds(0, 0, 1600, 900);
		frame.add(selectPanel);
	}

	public void actionPerformed(ActionEvent e) { // 버튼 액션 리스너
		JButton btn = (JButton) e.getSource();

		if (btn.getName().equals("firstStartBtn")) { // 인트로에서 시작 버튼 누를 시
			introPanel.setVisible(false);
			selectPanelStart();
		} else if (btn.getName().equals("explainBtn")) { // 설명 버튼 누를 시
			introPanel.setVisible(false);
			explainPanel.setVisible(true);
		} else if (btn.getName().equals("exitBtn")) { // 종료 버튼 누를 시
			System.exit(0); // 게임 종료
		} else if (btn.getName().equals("backBtn")) { // 설명 패널에서 뒤로가기 버튼 누를 시
			explainPanel.setVisible(false);
			selectPanel.setVisible(false);
			introPanel.setVisible(true);
		} else if (btn.getName().equals("startBtn")) { // 캐릭터 선택에서 시작 버튼 누를 시
			if (selectPanel.getcv1P() == null) {
				JOptionPane.showMessageDialog(null, "1P캐릭터를 골라주세요"); // 캐릭터를 안골랐을경우 팝업
			} else if (selectPanel.getcv2P() == null) {
				JOptionPane.showMessageDialog(null, "2P캐릭터를 골라주세요"); // 캐릭터를 안골랐을경우 팝업
			} else { // 게임 패널로 변경
				selectPanel.setVisible(false);

				gamePanelStart();

				// 선택한 캐릭터의 값 전달
				gamePanel.gameSet(selectPanel.getcv1P(), selectPanel.getcv2P());

				frame.setSize(1216, 939);
				frame.setLocationRelativeTo(null);
			}
		} else if (btn.getName().equals("restartBtn")) { // 게임이 끝나고 다시 시작 버튼 누를 시
			gamePanel.setVisible(false);
			frame.setSize(1616, 939);
			frame.setLocationRelativeTo(null);
			selectPanel.setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Main(); // 게임 실행
	}
}