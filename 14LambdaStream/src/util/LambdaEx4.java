package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaEx4 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i<10;i++)
			list.add(i);
		
		//void forEach(Consumer<? super E> action) 
		list.forEach(i -> System.out.print(i+","));
		System.out.println();
		
		//2또는 3의 배수 제거 
		// boolean removeIf(Predicate<? super E> filter) 
		list.removeIf(x->x%2==0||x%3==0);
		System.out.println(list);
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
		//map의 모든 요소를 {k,v}로 출력
		map.forEach((k,v) -> System.out.print("{"+k+","+v+"}"));
		System.out.println();
	}
}
