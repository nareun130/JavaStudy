package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Bingo {
	public static void main(String[] args) {
		// ? HashSet은 자체적인 저장방식에 따라 순서 결정
		// -> 비슷한 위치에 같은 숫자가 나옴 
//		Set set = new HashSet();
		//~> 이런 경우는 LinkedHashSet()이 적당 
		Set set = new LinkedHashSet();
		int[][] board = new int[5][5];

		for (int i = 0; set.size() < 25; i++) {
			set.add((int) (Math.random() * 50) + 1 + "");
		}

		Iterator it = set.iterator();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				// * next()의 반환값이 Object -> 형변환
				board[i][j] = Integer.parseInt((String) it.next());
				System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
			}
			System.out.println();
		}
	}
}
