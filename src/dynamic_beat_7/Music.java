package dynamic_beat_7;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread { // ������� �ϳ��� ���� ���α׷� (���α׷� �ȿ� �ִ� ���� ���α׷�)

	private Player player; // Player = javazoom����Ʈ�� �ִ� ���̺귯�� �� �ϳ�
	private boolean isLoop; // ���� ���ѹݺ����� �ƴ��� ����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file =  new File(Main.class.getResource("../music/" + name).toURI()); //music ���� �ȿ� �ִ� ���� ���� toURl =�ش� ���� ������
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() { // ���� ����ǰ� �ִ� ������ � ��ġ���� ����ǰ� �ִ� �� 
		if(player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() { // ������ ���� ����Ǵ����� �׻� ������ �� �ֵ��� ����
		isLoop = false;
		player.close();
		this.interrupt(); // �ش� �����带 �������·� ���� = interrupt();
	}
	
	@Override
	public void run() { // thread�� ��ӹ��� �� ������ ����ߵǴ� �Լ�
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
