package n0415;


//조상이 가진 메서드를 자식이 상속한 후 메서드를 바꾼다.
//메서드의 오버라이딩(over riding)
//조상이 가진 메서드를 직접 사용하는것이 아니고 , 자식의 메서드를 사용한다.
//이런 경우 조상이 가진 메서드의 몸통을 삭제해도 된다. 몸통이없는걸 추상메서드라고함
//추상메서드를 하나라도 가지고있는 클래스도 추상클래스라고한다.
//추상 메서드나 추상 클래스앞에 추상을 의미하는 abstract를 붙인다.
//추상 클래스의 목적 : 상속
//추상 메서드의 목적 : 오버라이딩(자식이 가지고있는 메서드로 바꿔서 써라)
abstract/*(추상클래스)*/ class Shape { // 삼각형과 사각형의 조상(추상메소드(불안정한메서드))
	int size; final int sansu = 500;
	abstract void doIt(int width, int height);
	void doshow() {
		sansu = 100; // final은 바꿀수없음
	} //정상적인 메서드를 가지고있어도 상관없음
	//몸통이 없는것을 추상메서드라 부름(자식들이 메서드를 바꿔서 쓰기때문에 부모클래스는 아무것도 안써도딤)
	//정상적인 메서드가 있어도 깡통메서드가하나있으면 추상클래스로 변경시켜줘야한다.
}
//인터페이스 : 가질 수 있는것은 추상 메서드와 상수만 가질 수 있다.
//추상클래스 : 추상 메서드와 정상적인 메서드를 가질 수 있다.
//인터페이스나 추상클래스 모두 상속이 목적이다.
//상수 : 변수(처음의 값을 끝까지 가지고 있는 변수), 상수앞에 final을 붙인다. 상수는 일반적으로 대문자로 한다.
interface MyInterface{
	final int MONEY = 100;
	abstract void doIt();	
}
class Circle extends Shape{ //초기에 서클에 오류가있었던 이유는 오버라이딩때문에 
	void doIt(int width, int height) {
		size = (int)(width * width * 3.14);
		
	}
	

}

class Rectangle extends Shape {// 사각형 width * height;
	void doIt(int width, int height) { //doIt을 자식들이 서로 다른 방식으로 사용하는게 오버라이딩
		size = width * height;
	}

}

class Triangle extends Shape { // 삼각형 width * height / 2;
	void doIt(int width, int height) {
		size = width * height / 2;
	}
}

public class Study01 {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		r1.doIt(200, 100); //자식이 가진 메서드를 사용하는거임
		System.out.println(r1.size);
		Triangle t1 = new Triangle();
		t1.doIt(300, 400);
		System.out.println(t1.size);
	}

}
