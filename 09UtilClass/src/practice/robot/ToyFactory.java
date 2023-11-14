package practice.robot;

public class ToyFactory {
	private static ToyFactory toyFactory = null;

	private ToyFactory() {

	}

	public static ToyFactory getInstance() {
		if (toyFactory == null) {
			toyFactory = new ToyFactory();
		}
		return toyFactory;
	}

	public Toy makeToy(String name, int Cost) {
		Toy toy = new Toy(name, Cost);
		return toy;
	}

	public Toy makeToy() {
		Toy toy = new Toy();
		return toy;
	}

}
