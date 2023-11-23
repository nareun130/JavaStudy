package set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetLotto {
	public static void main(String[] args) {
		Set set = new TreeSet();

		for (int i = 0; set.size() < 6; i++) {
			int num = (int) (Math.random() * 45) + 1;
			set.add(num);
		}
		//treeSet은 이미 저장때 정렬하므로 따로 정렬할 필요 x 
		System.out.println(set);
	}
}
