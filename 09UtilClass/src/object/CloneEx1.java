package object;

public class CloneEx1 {
	public static void main(String[] args) {
		Point original = new Point(3, 5);
		Point copy = (Point) original.clone();
		System.out.println(original);
		System.out.println(copy);
	}
}

class Point implements Cloneable {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}

//	@Override
//	public Object clone() { // ! Cloneabl을 구현해야만 clone()복제가 가능                               
//		Object obj = null;
//		try {
//			obj = super.clone();
//		} catch (CloneNotSupportedException e) {
//			System.out.println("exception 발생");
//		}
//		return obj;
//	}
	
	//* 공변 반환 타입 : 조상 메서드의 반환타입 -> 자손 클래스의 타입으로 변경
	@Override
	public Point clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (Point) obj;
	}
}