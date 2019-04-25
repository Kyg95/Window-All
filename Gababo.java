package yg;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Gababo extends Frame implements WindowListener, ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// 컴퓨터가 내민 가위,바위,보는 난수로 설정한다.
		int com = (int) (Math.random() * 3);// 0:가위,1:바위,2:보
		if (checks[0].getState()) {// 가위를 누른 경우
			switch (com) {
			case 0:
				winner.setText("비겼습니다.");
				break;
			case 1:
				winner.setText("컴퓨터가 바위. 컴퓨터 승");
				break;
			case 2:
				winner.setText("컴퓨터가 보. 당신 승");
				break;
			}
		} else if (checks[1].getState()) {// 바위를 누른 경우
			switch (com) {
			case 0:
				winner.setText("컴퓨터 가위. 당신 승");
				break;
			case 1:
				winner.setText("비겼습니다.");
				break;
			case 2:
				winner.setText("컴퓨터가 보. 컴퓨터 승");
				break;
			}
		} else if (checks[2].getState()) {// 보를 누른 경우
			switch (com) {
			case 0:
				winner.setText("컴퓨터가 가위. 컴퓨터 승");
				break;
			case 1:
				winner.setText("컴퓨터가 바위. 당신 승");
				break;
			case 2:
				winner.setText("비겼습니다.");
				break;
			}
		}

	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	Checkbox[] checks;
	CheckboxGroup group;
	Button ok;
	Label winner;
	Panel[] panels;
	String[] gababo = { "가위", "바위", "보" };

	void doIt() {
		checks = new Checkbox[3];// 크기3의 배열 생성
		group = new CheckboxGroup();// 라디오버튼을 만들기위해 그룹생성
		for (int i = 0; i < checks.length; i++) {
			checks[i] = new Checkbox(gababo[i], group, false);// 체크박스 생성
		}
		ok = new Button(" 결과 보기 ");
		ok.addActionListener(this);
		winner = new Label("                     ");
		panels = new Panel[3];// 길이3의 배열생성
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new Panel();
			panels[i].setLayout(new FlowLayout());// 배치관리자 설정
		}
		panels[0].add(checks[0]);
		panels[0].add(checks[1]);
		panels[0].add(checks[2]);// 첫번째 패널에 라디오버튼을 붙임
		panels[1].add(winner);// 두번째 패널에 레이블 붙임
		panels[2].add(ok);// 세번째 패널에 버튼을 붙임
	}

	public Gababo(String str) {
		super(str);
		doIt();
		this.setLayout(new GridLayout(3, 1));
		this.add(panels[0]);
		this.add(panels[1]);
		this.add(panels[2]);
		this.addWindowListener(this);
		this.setSize(500, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Gababo("가위,바위,보 ver1.0");
	}
}