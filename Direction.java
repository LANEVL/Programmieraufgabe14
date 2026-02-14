package New1;

public enum Direction {
	UP('^', -1, 0), RIGHT('>', 0, 1), DOWN('v', 1, 0), LEFT('<', 0, -1);

	public final char symbol;
	public final int dx;
	public final int dy;

	Direction(char symbol, int dx, int dy) {
		this.symbol = symbol;
		this.dx = dx;
		this.dy = dy;
	}

	public Direction left() {
		return values()[(this.ordinal() + 3) % 4];
	}

	public Direction right() {
		return values()[(this.ordinal() + 1) % 4];
	}

	public Direction back() {
		return values()[(  + 2) % 4];
	}
}