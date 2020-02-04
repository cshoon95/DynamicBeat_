package dynamic_beat_7;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread { // 스레드는 하나의 작은 프로그램 (프로그램 안에 있는 작은 프로그램)

	private Player player; // Player = javazoom사이트에 있던 라이브러리 중 하나
	private boolean isLoop; // 곡이 무한반복인지 아닌지 설정
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file =  new File(Main.class.getResource("../music/" + name).toURI()); //music 폴더 안에 있는 파일 실행 toURl =해당 파일 가져옴
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() { // 현재 실행되고 있는 음악이 어떤 위치에서 실행되고 있는 지 
		if(player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() { // 음악이 언제 실행되던간에 항상 종료할 수 있도록 설정
		isLoop = false;
		player.close();
		this.interrupt(); // 해당 스레드를 중지상태로 만듬 = interrupt();
	}
	
	@Override
	public void run() { // thread를 상속받을 때 무조건 해줘야되는 함수
		try{
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);	
			} while(isLoop);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
