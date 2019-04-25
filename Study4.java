package n0415;


//상속일때 다형성이 적용된다.
//다형성 : 조상형태의 변수에 자식의 인스턴스를 저장하는 것

class Fruit{ //과일 = 바나나와 사과의 조상
	int price;
	Fruit(int price){this.price = price;}
}

class Banana extends Fruit{
	Banana(int price){super(price);}
}
class Apple extends Fruit{
	Apple(int price){super(price);}
}
public class Study4 {

	public static void main(String[] args) {
		Banana b = new Banana(1000);
		System.out.println(b.price);
		Apple a = new Apple(500);
		System.out.println(a.price);
		//다형성 : 조상형태의 변수에 자식의 인스턴스를 저장
		Fruit b2 = new Banana(1100);
		Fruit a2 = new Apple(550);
		System.out.println("두번째 바나나:"+b2.price+"두번째 사과:"+a2.price);
		Fruit[] fruit = new Fruit[4];
		fruit[0] = new Banana(2000);
		fruit[1] = new Apple(500);
		fruit[2] = new Banana(2500);
		fruit[3] = new Apple(650);
		for(int i = 0; i < fruit.length; i++) {
			//다형성이 적용된 변수에 저장된 인스턴스가
			//어떤 자식의 인스턴스인지를 찾는 연산자  instanceof
			if(fruit[i] instanceof Apple) {
				System.out.println("사과의 가격 :");
			}else if(fruit[i] instanceof Banana) {
				System.out.println("바나나의 가격");
			}
			System.out.println(fruit[i].price);
		}
	}

}