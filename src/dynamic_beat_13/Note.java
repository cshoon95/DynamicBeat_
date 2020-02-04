package dynamic_beat_13;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - 1000 / Main.SLEEP_TIME * Main.NOTE_SPPED;
	private String noteType;
	
	public Note(int x, String noteType) {
		this.x = x;
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics g) {
		if(noteType.equals("short"))
		{
			g.drawImage(noteBasicImage, x, y, null);
		}
		else if(noteType.equals("long")) { // Space��
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);			
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPPED;
	}
	
	public void run() {
		try {
			while(true) {
				drop();
				Thread.sleep(Main.SLEEP_TIME); // �� �� ��Ʈ�� ����߸��� 0.01�ʵ��� �ٽ� ����߸��� ������ �ݺ� sleep = 0.01�ʸ� ����������.
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
