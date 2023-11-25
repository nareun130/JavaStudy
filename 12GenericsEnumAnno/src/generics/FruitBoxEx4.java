package generics;

import java.util.Collections;

import generics.fruits.Apple;
import generics.fruits.AppleComp;
import generics.fruits.FruitBox;
import generics.fruits.FruitComp;
import generics.fruits.Grape;
import generics.fruits.GrapeComp;

public class FruitBoxEx4 {
	public static void main(String[] args) {
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();

		appleBox.add(new Apple("GreenApple", 300));
		appleBox.add(new Apple("GreenApple", 100));
		appleBox.add(new Apple("GreenApple", 200));

		grapeBox.add(new Grape("GreenGrape", 400));
		grapeBox.add(new Grape("GreenGrape", 300));
		grapeBox.add(new Grape("GreenGrape", 200));

		Collections.sort(appleBox.getList(), new AppleComp());
		Collections.sort(grapeBox.getList(), new GrapeComp());
		System.out.println(appleBox);
		System.out.println(grapeBox);

		System.out.println();

		Collections.sort(appleBox.getList(), new FruitComp());
		Collections.sort(grapeBox.getList(), new FruitComp()); 
		System.out.println(appleBox);
		System.out.println(grapeBox);                          

	}
}
