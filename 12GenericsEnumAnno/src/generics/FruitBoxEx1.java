package generics;

import generics.fruits.Apple;
import generics.fruits.Box;
import generics.fruits.Fruit;
import generics.fruits.Grape;
import generics.fruits.Toy;

public class FruitBoxEx1 {
	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Apple> appleBox = new Box<Apple>();
		Box<Toy> toyBox = new Box<Toy>();
		Box<Grape> grapeBox = new Box<Grape>();
		// 타입 불일치
//		Box<Grape> grapeBox = new Box<Apple>();

		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());

		appleBox.add(new Apple());
		appleBox.add(new Apple());
//		appleBox.add(new Toy());

		toyBox.add(new Toy());
//		toyBox.add(new Apple());

		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
	}
}
