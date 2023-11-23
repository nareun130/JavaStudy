package iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorEx1 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("1");
		list.add("4");
		list.add("2");
		list.add("3");
		list.add("5");

		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		System.out.println("-----------");
		Set set = new HashSet();
		set.add("1");
		set.add("5");
		set.add("3");
		set.add("2");
		set.add("4");

		Iterator it2 = set.iterator();//set은 순서 보장 x 
		while (it2.hasNext()) {
			Object obj = it2.next();
			System.out.println(obj);
		}
	}
}
