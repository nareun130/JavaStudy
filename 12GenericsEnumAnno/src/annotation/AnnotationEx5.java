package annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo {
	int count() default 1;

	String testedBy();

	String[] testTools() default "JUNIT";

	TestType testType() default TestType.FIRST;

	DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
	String yymmdd();

	String hhmmss();
}

enum TestType {
	FIRST, FINAL
}

@Deprecated
@SuppressWarnings("1111") // * 유효하지 않은 어노테이션은 무시됨.
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd = "231128", hhmmss = "001212"))
public class AnnotationEx5 {
	public static void main(String[] args) {

		Class<AnnotationEx5> cls = AnnotationEx5.class;

		TestInfo anno = (TestInfo) cls.getAnnotation(TestInfo.class);
		System.out.println("anno.testedBy()=" + anno.testedBy());
		System.out.println("anno.testDate().yymmdd()=" + anno.testDate().yymmdd());
		System.out.println("anno.testDate().hhmmss()=" + anno.testDate().hhmmss());
		for (String str : anno.testTools()) {
			System.out.println("testTools=" + str);
		}
		Annotation[] annoArr = cls.getAnnotations();

		for (Annotation a : annoArr) {
			System.out.println(a);
		}
	}
}
