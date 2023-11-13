package copy;

public class ShallowDeepCopy {
	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(1, 1), 2.0);
		Circle c2 = c1.shallowCopy();
		Circle c3 = c1.deepCopy();

		System.out.println("c1=" + c1);
		System.out.println("c2=" + c2);
		System.out.println("c3=" + c3);

		c1.p.x = 9;
		c1.p.y = 9;
		System.out.println("===c1변경 후===");

		System.out.println("c1=" + c1);
		System.out.println("c2=" + c2);
		System.out.println("c3=" + c3);
	}
}

class Circle implements Cloneable {

	Point p;// 원
	double r;// 반지름

	public Circle(Point p, double r) {
		this.p = p;
		this.r = r;
	}

	// 얕은 복사
	public Circle shallowCopy() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (Circle) obj;
	}

	public Circle deepCopy() {
		Object obj = null;
		try {
			obj = super.clone();// ~> 참족객체까지 복제하지 않는다.
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		Circle c = (Circle) obj;
		c.p = new Point(this.p.x, this.p.y);

		return c;

	}

	@Override
	public String toString() {
		return "[p=" + p + ", r=" + r + "]";
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
