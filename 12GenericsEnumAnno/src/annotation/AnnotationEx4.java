package annotation;

import java.util.Arrays;

class MyArrayList<T> {
	T[] arr; // 이게 컴파일 후에 Object로 변환됨.

	//이걸 두개 같이 씀 .
	@SafeVarargs
	@SuppressWarnings("varargs")// 가변인자가 지네릭스 타입일 때 
	MyArrayList(T... arr) {
		this.arr = arr;
	}
	
	
	@SafeVarargs//* 이것만 쓰면 unchecked를 선언부에서만 처리 가능 
	// ~> varargs는 따로 처리 해야 함.
//	@SuppressWarnings("unchecked") //이걸 쓸 때는선언부, 호출부 둘 다 써야함.
	public static <T> MyArrayList<T> asList(T... a) {
		return new MyArrayList<>(a);
	}
	
	public String toString() {
		return Arrays.toString(arr);
	}

}

public class AnnotationEx4 {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		MyArrayList<String> list = MyArrayList.asList("1", "2", "3");
		System.out.println(list);
	}
}
