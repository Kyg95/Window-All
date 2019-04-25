package n0415;

class King {
	int gold = 100;

	void doIt() {
		System.out.println("나는 왕이다.");
	}
	void showme() {
		System.out.println("쇼유 미");
	}
}

class price extends King {
	void doIt() {
		System.out.println("나는 왕자다.");
	}

	int gold = 101;

	void doshow() {
		System.out.println("나는 금을 가지고 있다.");
	}
}

public class Study5 {
	public static void main(String[] args) {
		price price = new price();
		price.doIt();
		price.doshow();
		System.out.println(price.gold);
		King king = new price(); // 다형성
		king.doIt();
		//king.doshow()는 사용할수 없다.
		System.out.println(king.gold);
		king.showme();
		//다형성의 특징:
		//다형성으로 접근할수있는 메서드는 바꾼메서드(오버라이딩한 메서드)
		//나 조상이 가지고 있는 메서드만 접근 가능 다형성으로 접근할수 있는 변수는 오직 조상의 변수만 가능하다.
	}

}
