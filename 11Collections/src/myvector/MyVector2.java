package myvector;

import java.util.Iterator;

public class MyVector2 extends MyVector implements Iterator {
	int cursor = 0;
	int lastRet = -1;

	public MyVector2(int capacity) {
		super(capacity);
	}

	public MyVector2() {
		this(10);
	}

	public void remove() {
		// 더 이상 삭제할 것이 없으면 IllegalStateException을 발생
		if (lastRet == -1) {
			throw new IllegalStateException();
		} else {
			remove(lastRet); 
			cursor--; // 삭제 후에 cursor의 위치를 감소
			lastRet = -1;// lastRet의 값을 초기화
		}

	}

	@Override
	public boolean hasNext() {
		return cursor != size();
	}

	@Override
	public Object next() {
		Object next = get(cursor);
		lastRet = cursor++;
		return next;
	}

	@Override
	public String toString() {
		String tmp = "";
		Iterator it = iterator();

		for (int i = 0; it.hasNext(); i++) {
			if (i != 0)
				tmp += ", ";
			tmp += it.next();
		}
		return "[" + tmp + "]";
	}

	public Iterator iterator() {
		// cursor와 lastRet초기화
		cursor = 0;
		lastRet = -1;
		return this;
	}

}
