package map;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx1 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234");

		Scanner s = new Scanner(System.in);

		while (true) {

			System.out.println("id와 password를 입력 ");
			System.out.print("id : ");
			String id = s.nextLine().trim();

			System.out.print("password : ");
			String password = s.nextLine().trim();

			if (!map.containsKey(id)) {
				System.out.println("존재x id, 다시 입력. ");
				continue;
			}
			if(!map.get(id).equals(password)) {
				System.out.println("일치x , 다시 입력 ");
				
			}else {
				System.out.println("id와 비번 일치 ");
				break;
			}

		}

	}
}
