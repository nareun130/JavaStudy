package generics;

import generics.fruits.Apple;
import generics.fruits.Fruit;
import generics.fruits.FruitBox;
import generics.fruits.Grape;
import generics.juice.Juicer;

public class FruitBoxEx3 {
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();

		fruitBox.add(new Apple("사과", 100));
		fruitBox.add(new Grape("포도", 200));

		appleBox.add(new Apple("사과", 300));
		appleBox.add(new Apple("사과", 500));

		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));

	}
}
