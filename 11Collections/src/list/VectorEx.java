package list;

import java.util.Vector;

public class VectorEx {
	public static void main(String[] args) {
		Vector v = new Vector(5);
		v.add("1");
		v.add("2");
		v.add("3");
		print(v);

		v.trimToSize();
		System.out.println("=== After trimToSize() ===");
		print(v);

		// 최소한 용량이 6이 되도록
		v.ensureCapacity(6);
		System.out.println("=== After v.ensureCapacity(6) ===");
		print(v);

		v.setSize(7); // size가 7보다 크면 상관 없지만 6이므로 2를 곱해줘 size를 12 로 만든다.
		System.out.println("After setSize(7)");
		print(v);

		v.clear();
		System.out.println("=== After clear() ===");
		print(v);
	}

	private static void print(Vector v) {
		System.out.println(v);
		System.out.println("size : " + v.size());
		System.out.println("capacity : " + v.capacity());
	}
}
