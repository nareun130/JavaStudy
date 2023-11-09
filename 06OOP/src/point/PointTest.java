package point;

public class PointTest {
	public static void main(String[] args) {
		
		Point3D p3 = new Point3D();
		System.out.println(p3.x);
		System.out.println(p3.y);
		System.out.println(p3.z);
	}
}

class Point {
	int x, y;
	
//	Point(){
//	! 이 기본 생성자는 조상 즉 Object 클래스의 생성자 호출 		
//	}
	
	Point(int x, int y) {
		//! 여기서 컴파일러가 super()를 삽입 
		this.x = x;
		this.y = y;
	}

	String getLocation() {
		return "x :" + x + ", y :" + y;
	}
}

class Point3D extends Point {
	
	int z;

	public Point3D() {
		this(100, 200, 300);
	}
	Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	String getLocation() {
		return "x :" + x + ", y :" + y + ", z :" + z;
	}
}
