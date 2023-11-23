package stack;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack extends Vector {

	public Object push(Object item) {
		addElement(item);
		return item;
	}

	public Object pop() {
		// Stack에 저장된 마지막 요소 읽어옴.
		Object obj = peek();
		// 만일 Stack이 비어있으면 peek()메서드가 EmptyStackException을 발생시킴.
		// 마지막 요소를 삭제한다. 배열의 index가 0부터 시작하므로 1을 빼준다.
		removeElement(size() - 1);
		return obj;
	}

	public Object peek() {

		int len = size();
		if (len == 0) {

			throw new EmptyStackException();
		}
		// 마지막 요소를 반환.
		return elementAt(len - 1);
	}

	public boolean empty() {
		return size() == 0;
	}

	public int search(Object o) {
		// 끝에서 부터 객체를 찾음. 반환값은 저장된 위치
		int i = lastIndexOf(o);

		if (i >= 0) {
			return size() - i;
		}

		return -1;
	}
}
