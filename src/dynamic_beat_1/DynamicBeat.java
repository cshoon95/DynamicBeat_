package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame { // GUI ����� ���α׷��� ����� ���� ���� �⺻������ ��ӹ޾ƾ� �ϴ� ��

	public DynamicBeat() {
		setTitle("Dynamic Beat"); // ���� �̸�
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // ȭ�� ������ �ǵ� �� ���� ��.
		setLocationRelativeTo(null); // ȭ�� ����� ��Ÿ���� ��.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� �� ���α׷� ��ü�� �����ϵ��� ���� ! ���� ������ ���س����� ���α׷� ���ο��� ��� ����Ǿ� ��������.
		setVisible(true); // ����â�� ��ǻ�Ϳ� ����� �ǵ��� ��. (�⺻���� false�̹Ƿ� true�� �ٲ������.)
	}
}
