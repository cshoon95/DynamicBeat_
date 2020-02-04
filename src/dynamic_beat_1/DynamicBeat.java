package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame { // GUI 기반의 프로그램을 만들기 위해 가장 기본적으로 상속받아야 하는 것

	public DynamicBeat() {
		setTitle("Dynamic Beat"); // 게임 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 화면 사이즈 건들 수 없게 함.
		setLocationRelativeTo(null); // 화면 가운데에 나타나게 함.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료했을 때 프로그램 전체가 종료하도록 설정 ! 만약 설정을 안해놓으면 프로그램 내부에서 계속 실행되어 남아있음.
		setVisible(true); // 게임창이 컴퓨터에 출력이 되도록 함. (기본값은 false이므로 true로 바꿔줘야함.)
	}
}
