package yg;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//사번, 이름, 부서명choice, 업무choice, 월급, 성별(라디오), 취미(체크박스),등록,지우기(버튼) 
//8행 1열(girdLoy) panel써서만듬(패널배치관리자,Flowlay) 
//panel 8개 label 7개 txtfield 3개  choice 2개 radio 2개 checkbox 6개 checkboxGroup 1개 button 2개
public class EmpSystem extends Frame implements WindowListener, ActionListener {

	Panel[] panels;
	Label[] labels;
	TextField[] inputs;
	Choice[] choices;
	Checkbox[] check;
	Button[] btns;
	CheckboxGroup group;
	String[] label_name = { "사번", "이름", "부서명", "업무", "월급", "성별", "취미" };//라벨명 
	String[] dept = { "개발", "영업", "IT", "AD", "Supp", "Market" };//부서
	String[] job_id = {"IT","SALES","MAN","AD","MARKET","SUPP"}; //업무명
	String[] gender_hobby = { "남", "여", "게임", "여행", "독서", "영화", "운동", "노래" };//체크박스
	String[] btn_title = {" 등 록 ","지 우 기 "};//버튼이름 
	void doIt() {
		panels = new Panel[8]; // 배열의 길이를 8로 선언
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new Panel();// 패널 생성
			panels[i].setLayout(new FlowLayout());// 배치관리자 설정
		}
		labels = new Label[7]; // 길이 7개의 배열 생성
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new Label(label_name[i]);
			panels[i].add(labels[i]);// 레이블에 패널을 전부다 박음
		}
		inputs = new TextField[3];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = new TextField(20);
		}
		panels[0].add(inputs[0]);
		panels[1].add(inputs[1]);
		panels[4].add(inputs[2]);
		choices = new Choice[2];
		for (int i = 0; i < choices.length; i++) {
			choices[i] = new Choice();
			switch (i) {
			case 0: // 부서명을 넣음
				for (int k = 0; k < dept.length; k++) {
					choices[0].add(dept[k]);
				}
				break;
			case 1:
				for (int k = 0; k < job_id.length; k++) {
					choices[1].add(job_id[k]);
				}
				break;
			}

		}
		panels[2].add(choices[0]);
		panels[3].add(choices[1]);
		check = new Checkbox[8];// 길이 8의 배열 생성
		group = new CheckboxGroup();// 라디오버튼용 체크박스그룹
		for (int i = 0; i < check.length; i++) {
			if (i >= 2) { // i가 2와같거나 크면 취미
				check[i] = new Checkbox(gender_hobby[i]); // 체크박스에 선언한거 전부다 때려박음
			} else {// i가 0혹은 1이면 성별
				check[i] = new Checkbox(gender_hobby[i], group, false);
			}
		}
		panels[5].add(check[0]); panels[5].add(check[1]);
		panels[6].add(check[2]); panels[6].add(check[3]);
		panels[6].add(check[4]); panels[6].add(check[5]);
		panels[6].add(check[6]); panels[6].add(check[7]);
		
		btns = new Button[2];
		for(int i =0; i<btns.length; i++) {
			btns[i] = new Button(btn_title[i]);
			btns[i].addActionListener(this);//버튼에 리스너를 붙임
		}
		panels[7].add(btns[0]); panels[7].add(btns[1]);
		
		
		
	}

	public EmpSystem(String str) {
		super(str);
		this.setLayout(new GridLayout(8, 1));
		doIt();
		for (int i = 0; i < 8; i++) {
			this.add(panels[i]);
		} // 반복문 돌려서 패널전부 쑤셔 박음
		this.setBackground(Color.DARK_GRAY);
		this.addWindowListener(this);
		this.setSize(400, 600);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new EmpSystem("사원관리 시스템 초본");
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

	
	
	Label total;
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼을 눌렀을 경우, 자동으로 호출되는 메서드
		//버튼이 2개이므로 , 어떤 버튼을 눌렀는지 찾아야한다.
		if(e.getSource() == btns[0]) { //등록버튼을 누른경우
			//입력한 사번, 이름, 월급을 읽어온다.
			//읽어온 데이터를 문자열로 만든다.
			//만든 문자열을 레이블에 출력한다.
			String id = inputs[0].getText(); //사번의 내용을 읽음 ==넣음
			String name = inputs[1].getText();//입력한 이름을 읽음 ==넣음
			String sal= inputs[3].getText();//입력한 월급의 내용을 읽고 sal에 넣음
			String info = id+","+name+","+sal;
			total = new Label(info);
			panels[7].add(total);
		}else if(e.getSource() == btns[1]) {//지우기 버튼을 누른경우
			//
		}
	}
}