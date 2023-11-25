package generics;

import generics.fruits.Apple;
import generics.fruits.Box;
import generics.fruits.Eatable;
import generics.fruits.Fruit;
import generics.fruits.FruitBox;
import generics.fruits.Grape;

//Fruit의 자손이면서 Eatable을 구현한 클래스만 T에 대입 가능 

public class FruitBoxEx2 {
	public static void main(String[] args) {

		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//		FruitBox<Grape> grapeBox = new FruitBox<Apple>();
//		FruitBox<Toy> toyBox = new FruitBox<Toy>();

		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());

		appleBox.add(new Apple());
//		appleBox.add(new Grape()); //Grape는 Apple의 자손 x 
		grapeBox.add(new Grape());

		System.out.println("fruitBox-" + fruitBox);
		System.out.println("appleBox-" + appleBox);
		System.out.println("grapeBox-" + grapeBox);
	}
}
