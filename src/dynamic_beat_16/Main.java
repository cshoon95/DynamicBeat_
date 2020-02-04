package dynamic_beat_16;

public class Main {

	public static final int SCREEN_WIDTH = 1280; // 화면의 너비
	public static final int SCREEN_HEIGHT = 720; // 화면의 높이
	public static final int NOTE_SPPED = 3; //노트가 떨어지는 속도
	public static final int SLEEP_TIME = 10; //노트가 떨어지는 주기
	public static final int REACH_TIME = 2; //노트가 판정바에 도달하기까지에 시간
	
	public static void main(String[] args) {
		
		new DynamicBeat();
	}

}
