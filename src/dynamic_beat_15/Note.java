package dynamic_beat_15;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPPED * Main.REACH_TIME);
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public Note(String noteType) {
		if(noteType.equals("S")) {
			x = 228;
		}
		else if(noteType.equals("F")) {
			x = 332;
		}else if(noteType.equals("D")) {
			x = 436;
		}else if(noteType.equals("Space")) {
			x = 540;
		}else if(noteType.equals("J")) {
			x = 744;
		}else if(noteType.equals("K")) {
			x = 848;
		}else if(noteType.equals("L")) {
			x = 952;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics g) {
		if(!noteType.equals("Space"))
		{
			g.drawImage(noteBasicImage, x, y, null);
		}
		else { 
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);			
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPPED;
		if(y > 620) {
			System.out.println("Miss");
			close();
		}
	}
	
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);// �� �� ��Ʈ�� ����߸��� 0.01�ʵ��� �ٽ� ����߸��� ������ �ݺ� sleep = 0.01�ʸ� ����������.
				}
				else {
					interrupt();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void judge() {
		if(y > 630) {
			System.out.println("Late");
			close();
		}
		else if(y >= 613) {
			System.out.println("Good");
			close();	
		}
		else if(y >= 587) {
			System.out.println("Great");
			close();	
		}
		else if(y >= 573) {
			System.out.println("Perfect");
			close();	
		}
		else if(y >= 565) {
			System.out.println("Great");
			close();	
		}
		else if(y >= 550) {
			System.out.println("Good");
			close();	
		}
		else if(y >= 535) {
			System.out.println("Early");
			close();	
		}
	}
}