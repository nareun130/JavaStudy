package generics.juice;

import generics.fruits.Fruit;
import generics.fruits.FruitBox;

public class Juicer {
//	public static Juice makeJuice(FruitBox<? extends Fruit> box) {
	// ~> 이런 식으로간단히 변경 가능
	public static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
		String tmp = "";
		for (Fruit f : box.getList()) {
			tmp += f + " ";
		}
		return new Juice(tmp);
	}
}
