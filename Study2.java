package yg;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//choice설계
//회사이름 choice 와 선택한 회사의 부서이름 choice를 추가합니다.(회사명과 부서명은 배열로 처리)

public class Study2 extends Frame implements WindowListener, ItemListener {

	Choice com, bu; // 회사와 부서 선언
	Label residence, label;

	public Study2(String str) {
		super(str);
		com = new Choice();
		bu = new Choice();
		label = new Label();
		residence = new Label("              ");
		dochoice();
		this.setLayout(new FlowLayout());
		this.add(label);this.add(label);
		this.add(com);
		this.add(label);this.add(label);
		this.add(label);this.add(label);
		this.add(bu);
		this.add(label);this.add(label);
		this.add(residence);
		this.addWindowListener(this);
		this.setSize(600, 300);
		this.setVisible(true);

	}

	String[] comname = { "KT", "LG", "SKT", "APPLE", "KOSEA" };
	String[][] buname = { { "Abu", "Bbu", "Cbu" }, { "Abu1", "Bbu1", "Cbu1" }, { "Abu3", "Bbu3", "Cbu3" },
			{ "Abu4", "Bbu4", "Cbu4" }, { "Abu2", "Bbu2", "Cbu2" } };

	void dochoice() {
		for (int i = 0; i < comname.length; i++) {
			com.add(comname[i]);
		}
		com.addItemListener(this);
		bu.addItemListener(this);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == com) {
			bu.removeAll();
			int index = com.getSelectedIndex();
			for (int i = 0; i < buname[index].length; i++) {
				bu.add(buname[index][i]);
			}
		} else if (e.getSource() == bu) {
			String selectedcom = com.getSelectedItem();
			String selectedbu = bu.getSelectedItem();

			residence.setText("당신이 고른 회사는" + selectedcom + "," + selectedbu + "입니다.");
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);// 프로그램 강제 종료

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new Study2("도전과제");

	}

}
