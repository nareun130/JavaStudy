package set;

import java.util.HashSet;
import java.util.Objects;

public class HashSetEx4 {
	public static void main(String[] args) {
		HashSet set = new HashSet();

		set.add("abc");
		set.add("abc");
		set.add(new Person("David", 10));
		set.add(new Person("David", 10));

 		System.out.println(set);
	}
}

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name + ":" + age;
	}

	// 밑의 메서드들을 정의해줘야 같은 인스턴스로 인식
	@Override
	public int hashCode() {
//		return (name + age).hashCode();

		// * 가능하면 이 방식으로!
		return Objects.hash(name, age);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person tmp = (Person) obj;
			return name.equals(tmp.name) && age == tmp.age;
		}
		return false;
	}

}
