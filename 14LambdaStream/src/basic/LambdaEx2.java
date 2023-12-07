package basic;

@FunctionalInterface
interface MyFunction2 {
	void myMethod();
}

public class LambdaEx2 {
	public static void main(String[] args) {
		MyFunction2 f = () -> {};
		
		Object obj = (MyFunction2)(() ->{});
		
		String str = ((Object)(MyFunction2)(()->{})).toString();
		
		System.out.println(f);//basic.LambdaEx2$$Lambda$1/0x0000000800000c08@39a054a5
		//일반 적인 익명객체 : 외부클래이름$번호
		//람다식 : 외부클래스이름$$Lambda$번호 
		System.out.println(obj);
		System.out.println(str);
		
//		System.out.println(()->{});// 람다식은 Object로 형변환 x
		System.out.println((MyFunction2)(()->{}));
//		System.out.println((MyFunction2)(()->{}).toString()); //에러 
		System.out.println(((Object)(MyFunction2)(()->{})).toString());
	}
}
