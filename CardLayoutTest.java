package yg;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CardLayoutTest extends Frame implements WindowListener {
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

	Button first, prev, next, last;
	Panel buttons;// 버튼을 붙일 패널
	Panel slide;// 카드레이아웃을 사용할 패널
	Panel card1, card2, card3, card4, card5;// slide에 붙일 패널들
	CardLayout card;// 카드레이아웃용 변수

	void doIt() {
		card = new CardLayout();// 카드레이아웃 생성
		first = new Button("맨처음");
		prev = new Button("이전");
		next = new Button("다음");
		last = new Button("마지막");
		buttons = new Panel();// 버튼을 담을 패널 생성
		buttons.add(first);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(last);// 패널에 버튼을 붙임
		slide = new Panel();// 카드레이아웃을 사용할 패널 생성
		slide.setLayout(card);// 패널의 배치관리자를 카드레이아웃으로 설정
		// 지금 부터 slide에 들어갈 패널 다섯개 생성
		card1 = new Panel();
		card2 = new Panel();
		card3 = new Panel();
		card4 = new Panel();
		card5 = new Panel();
		// 패널은 눈에 안보이므로, 배경색을 지정해서 색을 보이게 한다.
		card1.setBackground(Color.YELLOW);
		card2.setBackground(Color.BLUE);
		card3.setBackground(Color.MAGENTA);
		card4.setBackground(Color.CYAN);
		card5.setBackground(Color.RED);
		// 카드레이아웃을 사용하는 패널에 card1부터 card5까지를 붙임
		// 카드레이아웃에 컴포넌트를 붙일때는 이름을 지정해야 한다.
		slide.add(card1, "1");
		slide.add(card2, "2");
		slide.add(card3, "3");
		slide.add(card4, "4");
		slide.add(card5, "5");// 두번째 인자가 이름

	}

	public CardLayoutTest(String title) {
		super(title);
		this.setLayout(new BorderLayout());// 배치관리자 설정
		// 윈도우에 기본배치관리자는 보더레이아웃이므로,
		// 보더레이아웃을 사용하는 경우 이 부분을 생략해도 된다.
		// Panel의 기본배치관리자는 FlowLayout이므로,
		// 플로우레이아웃을 사용하는 경우 패널에 배치관리자 설정을 생략해도된다.
		this.addWindowListener(this);
		doIt();
		this.add("Center", slide);// 윈도우 가운데에 slide를 붙임
		this.add("South", buttons);// 윈도우 아래에 buttons를 붙임
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new CardLayoutTest("카드레이아웃 윈도우");
	}

}
