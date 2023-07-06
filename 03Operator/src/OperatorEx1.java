
public class OperatorEx1 {
	public static void main(String[] args) {
		int i = 5;
		i++;
		System.out.println(i);// 6

		i = 5;
		++i;
		System.out.println(i);// 6

		i = 5;
		int j = 5;
		System.out.println(i++);// 5
		System.out.println(++j);// 6

		System.out.println("i = " + i + ", j = " + j);// 6, 6

	}
}
