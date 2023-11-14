package practice.robot;

public class Toy {

	private String name;
	private int cost;

	Toy() {

	}

	Toy(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "name : " + name + ", cost : " + cost;
	}

}
