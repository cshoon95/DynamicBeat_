package dynamic_beat_4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame { // GUI ����� ���α׷��� ����� ���� ���� �⺻������ ��ӹ޾ƾ� �ϴ� ��

	/* ���� ���۸��� ���ؼ� ��ü ȭ�鿡 ���� �̹����� ��� �ν��Ͻ��� */
	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg"))
			.getImage(); // getImage�ν��Ͻ��� introBackground ������ �ʱ�ȭ // ��Ʈ�� ���ȭ��
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);

	private int mouseX, mouseY; // ���콺�� X�� Y ��ǥ
	
	public DynamicBeat() {
		setUndecorated(true); // �޴��ٸ� ������ �ʰ� ����
		setTitle("Dynamic Beat"); // ���� �̸�
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // ȭ�� ������ �ǵ� �� ���� ��.
		setLocationRelativeTo(null); // ȭ�� ����� ��Ÿ���� ��.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� �� ���α׷� ��ü�� �����ϵ��� ���� ! ���� ������ ���س����� ���α׷� ���ο��� ��� ����Ǿ�
														// ��������.
		setVisible(true); // ����â�� ��ǻ�Ϳ� ����� �ǵ��� ��. (�⺻���� false�̹Ƿ� true�� �ٲ������.)
		setBackground(new Color(0, 0, 0, 0)); // �޴��� ������ ȸ������ ������ (0, 0, 0, 0)���� ������� ��Ÿ���Ե�.
		setLayout(null); // ��ư ���� �־��� �� �� ��ġ�� �ش�ǰ�

		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000); //1�� ���� �ִٰ� �����. �Ҹ����ڸ��� ����Ǵ� �� ����. (1�������� ��Ÿ���� ��) 
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		}) ;
		add(exitButton);
		
		menuBar.setBounds(0, 0, 1280, 30); // ��ġ�� ũ�⸦ ������
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { // ���콺 Ŭ��
				mouseX = getX();
				mouseY = getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) { // ���콺 �巡���� ��
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});

		add(menuBar); // JFram�� menuBar�� �߰���.



		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start(); // ������ ���۵ʰ� ���ÿ� ��Ʈ�ι��� ���
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic); // screenDraw �Լ��� �̿��Ͽ� screenImage�� �׸�.
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g); // �޴��ٿ� ���� ������ �̹����� �ƴ� ������ �̹����� ���
		this.repaint(); // ����ؼ� �ݺ��ؼ� �׷���. repaint();
	}
}