package dynamic_beat_14;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPPED * Main.REACH_TIME);
	private String noteType;
	
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
	}
	
	public void run() {
		try {
			while(true) {
				drop();
				Thread.sleep(Main.SLEEP_TIME); // 한 번 노트를 떨어뜨리고 0.01초동안 다시 떨어뜨리는 형식을 반복 sleep = 0.01초를 기준으로함.
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
