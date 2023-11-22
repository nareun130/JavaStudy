package list;

public class MyVectorTest {
	public static void main(String[] args) {
		MyVector v = new MyVector();
		v.add(1);
		System.out.println(v);
		v.add(1);
		System.out.println(v);
		System.out.println(v.size);
		v.add(2);
		System.out.println(v);
		v.add(2);
		System.out.println(v);
		v.add(2, 3);
		System.out.println(v);
		v.add(1, 4);
		System.out.println(v);
		v.add(v.size - 1, 5);
		System.out.println(v);
		v.set(v.size - 1, 5);
		System.out.println(v);
		
		System.out.println(v.contains(6));

	}
}
