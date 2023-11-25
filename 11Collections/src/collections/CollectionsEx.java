package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class CollectionsEx {
	public static void main(String[] args) {

		List list = new ArrayList();
		System.out.println(list);

		Collections.addAll(list, 1, 2, 3, 4, 5);
		System.out.println(list);

		Collections.rotate(list, 2);// 오른쪽으로 2칸씩 이동
		System.out.println(list);

		// 첫 번째와 세 번째 교환
		Collections.swap(list, 0, 2);
		System.out.println(list);

		// 임의로 변경
		Collections.shuffle(list);
		System.out.println(list);

		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);

		Collections.sort(list);
		System.out.println(list);

		// 3이 저장된 위치
		int idx = Collections.binarySearch(list, 3);
		System.out.println("index of 3 = " + idx);

		System.out.println("max = " + Collections.max(list));
		System.out.println("min = " + Collections.min(list));
		System.out.println("in = " + Collections.max(list, Collections.reverseOrder()));

		Collections.fill(list, 9);
		System.out.println("list = " + list);

		// List 같은 크기의 새로운 list를 생성하고 2로 채운다. 단, 결과는 변경불가
		List newList = Collections.nCopies(list.size(), 2);
		System.out.println("newList = " + newList);

//		newList.add(3);//~> 에러 !

		// 서로소 -> 공통 요소가 없으면 true
		System.out.println(Collections.disjoint(list, newList));

		Collections.copy(list, newList);
		System.out.println("newList = " + newList);
		System.out.println("list = " + list);

		Collections.replaceAll(list, 2, 1);
		System.out.println("list = " + list);

		Enumeration e = Collections.enumeration(list);
		ArrayList list2 = Collections.list(e);
		System.out.println("list2=" + list2);

		// 컬렉션 동기화
		List syncList = Collections.synchronizedList(new ArrayList(10));
		Collections.addAll(syncList, 1, 2, 3, 4, 5);
		System.out.println("syncList = " + syncList);

		// 읽기 전용 컬렉션
		List unmodifiableList = Collections.unmodifiableList(syncList);
		System.out.println("unmodifiableList = " + unmodifiableList);

		// 싱글톤 컬렉션
		List singletonList = Collections.singletonList(syncList);
		System.out.println(singletonList);

		// 한 종류의 객체만 저장하는 컬렉션 -> 이제는 지네릭스로 처리
		List StringList = Collections.checkedList(List.of("1,", "2"), String.class);
		System.out.println(StringList);
	}
}
