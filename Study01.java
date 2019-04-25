package yg;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//윈도우 클래스 작성
//윈도우에 포함될 컴포넌트 선언
//해당 컴포넌트에서 발생하는 이벤트를 찾는다.
//해당 이벤트를 처리하는 리스너를 찾는다.(이벤트이름+Listener)
//ex)ActionEvent -> ActionListener
//리스너를 윈도우에 설치한다.
//이벤트가 발생하는 컴포넌트에 리스너를 붙인다.
//리스너가 가지고 있는 콜백메서드를 오버라이딩한다.
//윈도우 종료 이벤트 처리
//윈도우의 오른쪽 상단부분의 엑스마크를 누르면 발생하는 이벤트
//windowEvent -> windowEvent를 처리하는 객체(리스너)는 무엇인가?
//-->이벤트이름+Listener->window->Listener->WindowListener
//윈도우에 windowListener를 설치하고 상속한다.
//모든 리스너는 인터페이스이다. 인터페이스를 상속하려면 implements를 쓰고  사용할 이벤트를 오버라이딩
//인터페이스는 몸퉁이없는 메서드(추상메서드)를 가지고있고 인터페이스를 상속한 경우는 반드시 인터페이스가 가지고 있는 추상메소드를 바꿔야한다.->오버라이딩한다.
//오버라이딩방법 클래스안에 커서를 위치시키고 이클립스메뉴 중 Source->Override를 선택하고 오버라이드할 메서드가 보이고 선택한 후 ok를 누름
public class Study01 extends Frame implements WindowListener, ItemListener {

	Choice dong, gu; // 초이스 선언
	Label residence,label;

	public Study01(String str) {
		super(str);
		gu = new Choice();
		dong = new Choice();
		label = new Label();
		residence = new Label("              ");
		dochoice();
		this.setLayout(new FlowLayout());// 배치관리자 선언
		// 버튼이나 선택버튼이나 체크박스등을 붙인다.
		this.addWindowListener(this);
		this.add(label);this.add(label);
		this.add(gu);
		this.add(label);this.add(label);
		this.add(dong);
		this.add(residence);
		// addwindowListener이 메서드에 의해서
		// windowListener가 현재 윈도우에 붙는다.
		// ()안에는 ->윈도우 리스너의 위치 -->현재 클래스가 리스너이므로, 리스너의 위치는 this가 된다.
		this.setSize(400, 200);
		this.setVisible(true);

	}

	String[] guname = { "강북구", "강서구", "강동구", "강남구", "송파구" };
	String[][] dongname = { // 2차원배열선언해서 좀더 편하게 구성할수있음
			{ "강북1동", "강북2동", "강북3동" }, // 2차원배열로하면 좀더 편하게 가능
			{ "강서1동", "강서2동", "강서3동" }, { "강동1동", "강동2동", "강동3동" }, { "강남1동", "강남2동", "강남3동" },
			{ "송파1동", "송파2동", "송파3동" } };
	void dochoice() {
		for (int i = 0; i < guname.length; i++) {
			gu.add(guname[i]);
		}
		gu.addItemListener(this);
		dong.addItemListener(this);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);// 프로그램 강제 종료
		// 윈도우의 오른쪽 위에 있는 엑스마크를 눌렀을때 windowEvent가 발생하고
		// 이 이벤트를 windowListener 감지한 후 windowListener가 가지고 있는
		// 메서드중 windowClosing메서드를 자동으로 호출한다.
		// 이 리스너를 이벤트가 발생하는 요소(이벤트 소스)에 붙인다.
		// windowEvent가 어디서 발생? -> frame(윈도우)에
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == gu) {// 구를 선택한 경우
			// 선택한 구에 해당하는 동이름을 dong에 넣는다
			// 어떤 구를 선택했는지 찾아보자
			// gu.getselectedItem() 메서드는 선택한 데이터를 출력한다.
			dong.removeAll(); // 동이름이 들어갈 초이스의 내용을 지운다.
			int index = gu.getSelectedIndex();
			for (int i = 0; i < dongname[index].length; i++) {
				dong.add(dongname[index][i]);
				// 선택한 구이름에 대한 위치번호가 index에 들어간다.
				// ex)강북구선택한 경우 index에는 0, 송파구를 선택한경우 index에는 4가들어간다.
				// 강북구를 선택한경우 동이름 dongname[0][0],dongname[0][1],dongname[0][2]
				// 송파구를 선택한 경우 동이름 dongname[4]로 배열 부름
			}
		} else if (arg0.getSource() == dong) {
			String selectedgu = gu.getSelectedItem();
			String selecteddong = dong.getSelectedItem();
			
			residence.setText("당신의 거주지는" +selectedgu+","+selecteddong+"입니다.");
		}
	}

	public static void main(String[] args) {
		new Study01("addWindowListener(this)");
	}

}
