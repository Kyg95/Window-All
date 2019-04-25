package n0415;


//4월 8일에 했던 스타 상속버전으로 다시만듬
//추상화버전
class Unit {
	Unit(int energy) {
		this.energy = energy;
	}

	int energy;

	void attack(Zilet z) {
		z.energy = z.energy - 10;
	}

	void attack(Zerg z) {
		z.energy = z.energy - 10;
	}

	void attack(Teran t) {
		t.energy = t.energy - 10;
	}

}

class Teran extends Unit {
	Teran(int energy) { //매개변수를 입력받음
		super(energy);
	}
}

class Zilet extends Unit {
	Zilet(int energy) {
		super(energy);
	}
}

class Zerg extends Unit {

	Zerg(int energy) {
		super(energy);
	}
}

public class Extends {
	public static void main(String[] args) {
		Teran t1 = new Teran(100);
		Zilet z1 = new Zilet(100);
		Zerg zg1 = new Zerg(100);
		t1.attack(z1);
		System.out.println(z1.energy);

	}

}
