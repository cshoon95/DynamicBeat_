package dynamic_beat_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame { // GUI ����� ���α׷��� ����� ���� ���� �⺻������ ��ӹ޾ƾ� �ϴ� ��

	/* ���� ���۸��� ���ؼ� ��ü ȭ�鿡 ���� �̹����� ��� �ν��Ͻ��� */
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground; // ��Ʈ�� ���ȭ��
	
	public DynamicBeat() {
		setTitle("Dynamic Beat"); // ���� �̸�
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // ȭ�� ������ �ǵ� �� ���� ��.
		setLocationRelativeTo(null); // ȭ�� ����� ��Ÿ���� ��.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� �� ���α׷� ��ü�� �����ϵ��� ���� ! ���� ������ ���س����� ���α׷� ���ο��� ��� ����Ǿ� ��������.
		setVisible(true); // ����â�� ��ǻ�Ϳ� ����� �ǵ��� ��. (�⺻���� false�̹Ƿ� true�� �ٲ������.)
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg")).getImage(); // getImage�ν��Ͻ��� introBackground ������ �ʱ�ȭ
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic); // screenDraw �Լ��� �̿��Ͽ� screenImage�� �׸�.
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint(); // ����ؼ� �ݺ��ؼ� �׷���. repaint();
	}
}
