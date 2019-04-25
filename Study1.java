package yg;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class MyImage extends Panel {
	Image img;// 이미지를 보여주기 위해서는 이미지를 담당하는 객체를 써야한다.

	MyImage(String path) {
		img = Toolkit.getDefaultToolkit().getImage(path);// 객체생성
	}

	// 이미지를 출력할 메서드
	// paint()메서드를 바꾼다. (오버라이드)
	@Override
	public void print(Graphics arg0) {
		arg0.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
		// 내가 가지고 있는 이미지를 불러와서 출력
	}// 이미지를 출력할 패널
}

public class Study1 extends Frame implements WindowListener {

	public Study1(String str) {
		super(str);
		this.setLayout(new GridLayout(1, 2));
		this.add(new MyImage("src\\yg\\dice5.png"));
		this.setSize(400, 400);
		this.addWindowListener(this);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Study1("이미지");
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}
}
