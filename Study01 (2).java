package yg;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Study01 extends Frame implements WindowListener,ActionListener{
	Panel[] panels; Checkbox[] drinks; Choice[] numbers;
	Button[] btns; Label total;
	String[] drinks_name = {"우유","아메리카노","데자와","봉봉","코카콜라"};
	//음료수 기준 가격 설정 
	final int MILK_PRICE = 1000; //우유의 기존 가격 설정
	final int AMERICANO_PRICE = 1500; //아메의 기존 가격 설정
	final int DEJAVA_PRICE = 2000; //데자와의 기존 가격 설정
	final int BONGBONG_PRICE = 2500; 
	final int COCA_PRICE = 2200; 
	int total_price;  
	void doIt() {//모든 컴포넌트 생성작업을함
		panels = new Panel[7]; drinks = new Checkbox[5];
		numbers = new Choice[5]; btns = new Button[2];
		total = new Label("           ");
		for(int i = 0; i < panels.length; i++) { //패널 5개 생성
			panels[i] = new Panel();
			panels[i].setLayout(new FlowLayout());//배치관리자 설정
			switch(i) {
			case 0 : panels[i].setBackground(new Color(200,255,255));break;
			case 1 : panels[i].setBackground(new Color(000,255,000));break;
			case 2 : panels[i].setBackground(new Color(204,255,255));break;
			case 3 : panels[i].setBackground(new Color(204,102,153));break;
			case 4 : panels[i].setBackground(new Color(255,102,000));break;
			case 5 : panels[i].setBackground(new Color(255,153,204));break;
			case 6 : panels[i].setBackground(new Color(255,102,204));break;
			case 7 : panels[i].setBackground(new Color(255,051,204));break;
			}
		}
		for(int i = 0; i < drinks.length; i++) { //체크박스 3개생성
			drinks[i] = new Checkbox(drinks_name[i]);
		}
		for(int i = 0; i<numbers.length; i++) {//초이스 3개 생성
			numbers[i] = new Choice();
			for(int k = 1; k <=10; k++) {//초이스에 갯수를 채움(1~10);
				numbers[i].add(k+""); // 숫자를 문자열로 바꾸기위해서 쌍따음표 박음
			} //for end
		} // for for end 
		btns[0] = new Button("계산하기"); btns[0].addActionListener(this);
		btns[1] = new Button("다시하기"); btns[1].addActionListener(this);
		for(int i = 0; i<5; i++) { //첫번째 패널부터 세번째 패널까지 체크박스랑 초이스 박음
			panels[i].add(drinks[i]);//체크박스 
			panels[i].add(numbers[i]);//초이스
		}
		panels[5].add(total);//네번째 패널에 토탈
		panels[6].add(btns[0]);panels[6].add(btns[1]); //다섯번째 패널에 버튼 2개를 붙임
		
	}
	public Study01(String str) {
		super(str);
		this.setLayout(new GridLayout(7,1));
		doIt();
		for(int i =0; i < 7; i++) {
			this.add(panels[i]);
		}
		this.addWindowListener(this);
		this.setBackground(Color.BLACK);
		this.setSize(400,350);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Study01("음료수 주문 시스템 1.0");

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
		System.exit(0);
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
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//버튼을 눌렀을 떄 자동으로 호출되는 메서드(콜백 메서드)
		total_price = 0;
		if(arg0.getSource() == btns[0]) {//계산하기를 누른경우
			if(drinks[0].getState()) {
				System.out.println("우유를 선택함");
				String m = numbers[0].getSelectedItem();
				int price = MILK_PRICE * Integer.parseInt(m);
				total_price = total_price + price;
						
			}
			if(drinks[1].getState()) {
				System.out.println("아메리카노를 선택함");
				String a = numbers[1].getSelectedItem();
				int price = AMERICANO_PRICE * Integer.parseInt(a);
				total_price = total_price + price;
					
			}
			if(drinks[2].getState()) {
				System.out.println("데자와를 선택함");
				String d = numbers[2].getSelectedItem();
				int price = DEJAVA_PRICE * Integer.parseInt(d);
				total_price = total_price + price;
			}
			if(drinks[3].getState()) {
				System.out.println("봉봉을 선택함");
				String b = numbers[3].getSelectedItem();
				int price = BONGBONG_PRICE * Integer.parseInt(b);
				total_price = total_price + price;
			}
			if(drinks[4].getState()) {
				System.out.println("코카콜라를 선택함");
				String c = numbers[4].getSelectedItem();
				int price = COCA_PRICE * Integer.parseInt(c);
				total_price = total_price + price;
			}
			total.setText("총합 :" +total_price);
		}else if(arg0.getSource() == btns[1]) { //다시하기를 누른경우
			System.out.println("다시하기 누름");
		}
	}

}