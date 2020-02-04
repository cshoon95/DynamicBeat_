package dynamic_beat_15;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage(); 
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	//Space를 1,2로 하는 이유는 다른 노트보다 길기 때문에 
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}
	
	
	public void screenDraw(Graphics g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844 , 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for(int i=0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}else{
				note.screenDraw(g);
			}
			note.screenDraw(g);
		}
		g.setColor(Color.white);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 720);
		g.drawString(difficulty, 1190, 702);
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.lightGray);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 702);		
		
	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false);
	}
	
	public void releaseS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false);
	}
	
	public void releaseD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false);
	}
	
	public void releaseF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3", false);
	}
	
	public void releaseSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false);
	}
	
	public void releaseJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false);
	}
	
	public void releaseK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false);
	}
	
	public void releaseL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt(); // 지금 실행중인 스레드를 종료 시켜줌.
	}
	 
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if(titleName.equals("벚꽃 엔딩 - 버스커버스커") && difficulty.equals("Easy")) {
			int startTime = 4457 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 2, "D"),
					new Beat(startTime + gap * 4, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 10, "S"),
					new Beat(startTime + gap * 12, "D"),
					new Beat(startTime + gap * 14, "S"),
					new Beat(startTime + gap * 18, "D"),
					new Beat(startTime + gap * 20, "J"),
					new Beat(startTime + gap * 22, "K"),
					new Beat(startTime + gap * 24, "Space"),
					new Beat(startTime + gap * 26, "K"),
					new Beat(startTime + gap * 28, "J"),
					new Beat(startTime + gap * 30, "L"),
					new Beat(startTime + gap * 32, "S"),
					new Beat(startTime + gap * 36, "D"),
					new Beat(startTime + gap * 38, "S"),
					new Beat(startTime + gap * 40, "D"),
					new Beat(startTime + gap * 42, "F"),
					new Beat(startTime + gap * 44, "Space"),
					new Beat(startTime + gap * 46, "S"),
					new Beat(startTime + gap * 48, "K"),
					new Beat(startTime + gap * 49, "Space"),
					new Beat(startTime + gap * 50, "D"),
					new Beat(startTime + gap * 52, "Space"),
					new Beat(startTime + gap * 54, "L"),
					new Beat(startTime + gap * 56, "D"),
					new Beat(startTime + gap * 59, "S"),
					new Beat(startTime + gap * 61, "Space"),
					new Beat(startTime + gap * 63, "S"),
					new Beat(startTime + gap * 65, "J"),
					new Beat(startTime + gap * 66, "S"),
					new Beat(startTime + gap * 69, "D"),
					new Beat(startTime + gap * 71, "J"),
					new Beat(startTime + gap * 73, "Space"),
					new Beat(startTime + gap * 76, "J"),
					new Beat(startTime + gap * 79, "K"),
					new Beat(startTime + gap * 81, "K"),
					new Beat(startTime + gap * 83, "L"),
					new Beat(startTime + gap * 85, "D"),
					new Beat(startTime + gap * 88, "D"),
					new Beat(startTime + gap * 90, "K"),
					new Beat(startTime + gap * 92, "D"),
					new Beat(startTime + gap * 94, "S"),
					new Beat(startTime + gap * 96, "Space"),
					new Beat(startTime + gap * 98, "L"),
					new Beat(startTime + gap * 100, "K"),
					new Beat(startTime + gap * 102, "Space"),
					new Beat(startTime + gap * 104, "D"),
					new Beat(startTime + gap * 107, "L"),
					new Beat(startTime + gap * 110, "K"),
					new Beat(startTime + gap * 112, "D"),
					new Beat(startTime + gap * 115, "S"),
					new Beat(startTime + gap * 119, "Space"),
					new Beat(startTime + gap * 122, "Space"),
					new Beat(startTime + gap * 126, "D"),
					new Beat(startTime + gap * 130, "F"),
					new Beat(startTime + gap * 132, "D"),
					new Beat(startTime + gap * 134, "J"),
					new Beat(startTime + gap * 136, "Space"),
					new Beat(startTime + gap * 140, "K"),
					new Beat(startTime + gap * 142, "J"),
					new Beat(startTime + gap * 146, "K"),
					new Beat(startTime + gap * 148, "L"),
					new Beat(startTime + gap * 150, "L"),
					new Beat(startTime + gap * 152, "D"),
					new Beat(startTime + gap * 154, "S"),
					new Beat(startTime + gap * 158, "Space"),
					new Beat(startTime + gap * 160, "F"),
					new Beat(startTime + gap * 162, "Space"),
					new Beat(startTime + gap * 164, "S"),
					new Beat(startTime + gap * 166, "Space"),
					new Beat(startTime + gap * 169, "S"),
					new Beat(startTime + gap * 172, "D"),
					new Beat(startTime + gap * 175, "S"),
					new Beat(startTime + gap * 177, "J"),
					new Beat(startTime + gap * 180, "Space"),
					new Beat(startTime + gap * 182, "F"),
					new Beat(startTime + gap * 185, "D"),
					new Beat(startTime + gap * 188, "S"),
					new Beat(startTime + gap * 191, "F"),
					new Beat(startTime + gap * 193, "Space"),
					new Beat(startTime + gap * 196, "D"),
					new Beat(startTime + gap * 200, "J"),
					new Beat(startTime + gap * 202, "L"),
					new Beat(startTime + gap * 204, "J"),
					new Beat(startTime + gap * 207, "L"),
					new Beat(startTime + gap * 210, "Space"),
					new Beat(startTime + gap * 214, "L"),
					new Beat(startTime + gap * 217, "S"),
					new Beat(startTime + gap * 219, "S"),
					new Beat(startTime + gap * 220, "Space"),
					new Beat(startTime + gap * 223, "L"),
					new Beat(startTime + gap * 226, "F"),
					new Beat(startTime + gap * 229, "Space"),
					new Beat(startTime + gap * 231, "S"),
					new Beat(startTime + gap * 235, "Space"),
					new Beat(startTime + gap * 237, "D"),
					new Beat(startTime + gap * 240, "F"),
					new Beat(startTime + gap * 242, "S"),
					new Beat(startTime + gap * 244, "J"),
					new Beat(startTime + gap * 247, "K"),
					new Beat(startTime + gap * 250, "S"),
					new Beat(startTime + gap * 252, "L"),
					new Beat(startTime + gap * 254, "J"),
					new Beat(startTime + gap * 257, "K"),
					new Beat(startTime + gap * 260, "J"),
					new Beat(startTime + gap * 263, "K"),
					new Beat(startTime + gap * 265, "J"),
					new Beat(startTime + gap * 268, "L"),
					new Beat(startTime + gap * 270, "S"),
					new Beat(startTime + gap * 273, "D"),
					new Beat(startTime + gap * 275, "Space"),
					new Beat(startTime + gap * 277, "L"),
					new Beat(startTime + gap * 280, "F"),
					new Beat(startTime + gap * 283, "Space"),
					new Beat(startTime + gap * 286, "S"),
					new Beat(startTime + gap * 290, "K"),
					new Beat(startTime + gap * 293, "Space"),
					new Beat(startTime + gap * 296, "S"),
					new Beat(startTime + gap * 298, "D"),
					new Beat(startTime + gap * 300, "F"),
					new Beat(startTime + gap * 302, "D"),
					new Beat(startTime + gap * 304, "D"),
					new Beat(startTime + gap * 307, "K"),
					new Beat(startTime + gap * 310, "K"),
					new Beat(startTime + gap * 312, "K"),
					new Beat(startTime + gap * 315, "S"),
					new Beat(startTime + gap * 318, "D"),
					new Beat(startTime + gap * 321, "Space"),
					new Beat(startTime + gap * 324, "D"),
					new Beat(startTime + gap * 326, "Space"),
					new Beat(startTime + gap * 328, "L"),
					new Beat(startTime + gap * 330, "S"),
					new Beat(startTime + gap * 332, "Space"),
					new Beat(startTime + gap * 335, "L"),
					new Beat(startTime + gap * 337, "K"),
					new Beat(startTime + gap * 339, "K"),
					new Beat(startTime + gap * 341, "K"),
					new Beat(startTime + gap * 343, "F"),
					new Beat(startTime + gap * 346, "S"),
					new Beat(startTime + gap * 349, "D"),
					new Beat(startTime + gap * 351, "Space")
			};
		}else if(titleName.equals("봄 사랑 벚꽃말고 - IU") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
			};
		}else if(titleName.equals("봄 사랑 벚꽃말고 - IU") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
			};	
		}else if(titleName.equals("연애할래 - 박보람") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
			};
		}else if(titleName.equals("연애할래 - 박보람") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
			};
		};
		
		int i = 0;
		gameMusic.start();
		while(i<beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++; 
			}
			if(!dropped) {
				try{
					Thread.sleep(5);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void judge(String input) {
		for(int i = 0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				note.judge();
				break;
			}
		}
	}
}
