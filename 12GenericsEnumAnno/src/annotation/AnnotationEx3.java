package annotation;

import java.util.ArrayList;

class NewCalss {
	int newField;

	int getNewField() {
		return newField;
	}

	@Deprecated
	int oldField;

	@Deprecated
	int getOldField() {
		return oldField;
	}
}

public class AnnotationEx3 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		NewClass nc = new NewClass();

		nc.oldField = 10;
		System.out.println(nc.getOldField());

		@SuppressWarnings("unchecked") // 지네릭스 관련 경고 억제
		ArrayList<NewClass> list = new ArrayList(); // 타입 지정 x
		list.add(nc);
	}
}
