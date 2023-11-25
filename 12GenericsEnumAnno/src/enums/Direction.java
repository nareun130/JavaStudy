package enums;

public enum Direction {
	EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");

	private static final Direction[] DIR_ARR = Direction.values();
	private final int value;
	private final String symbol;

	// * private이 생략됨.
	Direction(int value, String symbol) {
		this.value = value;
		this.symbol = symbol;
	}

	public int getValue() {
		return value;
	}

	public String getSymbol() {
		return symbol;
	}

	public static Direction of(int dir) {
		if (dir < 1 || dir > 4) {
			throw new IllegalArgumentException("Invalid value :" + dir);
		}
		return DIR_ARR[dir - 1];
	}

	//num값 만큼 90도씩 시계방향으로 회전 
	public Direction rotate(int num) {
		num = num % 4; 
		if (num < 0) //음수면 시계반대 방향으로 회전 
			num += 4;
		return DIR_ARR[(value - 1 + num) % 4];
	}

	@Override
	public String toString() {
		return name() + getSymbol();
	}
}
