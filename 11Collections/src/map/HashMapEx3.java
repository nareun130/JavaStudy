package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx3 {
	static HashMap phoneBook = new HashMap();

	public static void main(String[] args) {
		addPhoneNo("친구", "이자바", "010-111-1111");
		addPhoneNo("친구", "김자바", "010-222-2222");
		addPhoneNo("친구", "김자바", "010-333-3333");
		addPhoneNo("회사", "김대리", "010-444-4444");
		addPhoneNo("회사", "김대리", "010-555-5555");
		addPhoneNo("친구", "박대리", "010-666-6666");
		addPhoneNo("회사", "김과장", "010-777-7777");
		addPhoneNo("세탁", "010-888-8888");

		printList();
	}

	private static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}

	private static void printList() {
		Set set = phoneBook.entrySet();

		Iterator it = set.iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();

			Set subSet = ((HashMap) e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();

			System.out.println(" * " + e.getKey() + "[" + subSet.size() + "]");

			while (subIt.hasNext()) {
				Map.Entry subE = (Map.Entry) subIt.next();
				String telNo = (String) subE.getKey();
				String name = (String) subE.getValue();
				System.out.println(name + " " + telNo);
			}
		}
	}

	private static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap group = (HashMap) phoneBook.get(groupName);
		// 이름은 중복될 수 있으므로 tel로 key 설정
		group.put(tel, name);

	}

	private static void addGroup(String groupName) {
		if (!phoneBook.containsKey(groupName))
			phoneBook.put(groupName, new HashMap());
	}
}
