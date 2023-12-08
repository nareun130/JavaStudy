package util;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReference {
	public static void main(String[] args) {
		Function<String, Integer> f = Integer::parseInt;
		int fAplly = f.apply("13");
		System.out.println(fAplly);

		BiFunction<String, String, Boolean> bf = String::equals;
		boolean bfApply = bf.apply("123", "123");
		System.out.println(bfApply);
		
		BiFunction<Integer, String, MyClass> bfMyClass = MyClass::new;
		MyClass mc = bfMyClass.apply(10, "hi");
		System.out.println(mc);
		
		BiFunction<Integer,String,MyClass> bfMyClass2 = (age,name) -> new MyClass(age,name);
		MyClass mc2 = bfMyClass2.apply(12, "hello");
		System.out.println(mc2);
		
		Function<MyClass, String> myFunction2 = MyClass::toString;
		System.out.println(myFunction2.apply(mc2));
		
		
	}
}

class MyClass {
	private int age;
	private String name;

	public MyClass() {

	}

	public MyClass(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name +", " + age;
	}

}
