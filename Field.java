package New1;

public class Field {

	private char[][] playableField;
	private int[] playerPos = new int[2];
	private int[] playerPosLast = playerPos;

	private char borderMark = '#';
	private int borderThickness = 2;
	private char innerFieldMarks = '.';

	private String playerSym = "^";

	//
	//
	//
	//
	//

	public Field() {
		playableField = new char[10][10];
		int bt = getBorderThickness();
		int rows = playableField.length;
		int cols = playableField[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				boolean isBorder = i < bt || i >= rows - bt || j < bt || j >= cols - bt;

				playableField[i][j] = isBorder ? borderMark : innerFieldMarks;
			}
		}
		printField();
	}

	public Field(int x, int y) {
		playableField = new char[x][y];
		int bt = getBorderThickness();
		int rows = x;
		int cols = y;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				boolean isBorder = i < bt || i >= rows - bt || j < bt || j >= cols - bt;

				playableField[i][j] = isBorder ? borderMark : innerFieldMarks;
			}
		}
		printField();
	}

	//
	//
	//
	//
	//

	public char[][] getPlayableField() {
		return playableField;
	}

	public void setPlayableField(char[][] playableField) {
		this.playableField = playableField;
	}

	public char getBorderMark() {
		return borderMark;
	}

	public void setBorderMark(char borderMark) {
		this.borderMark = borderMark;
	}

	public char getInnerFieldMarks() {
		return innerFieldMarks;
	}

	public void setInnerFieldMarks(char innerFieldMarks) {
		this.innerFieldMarks = innerFieldMarks;
	}

	public int getBorderThickness() {
		return borderThickness;
	}

	public void setBorderThickness(int borderThickness) {
		this.borderThickness = borderThickness;
	}

	public String getPlayerSym() {
		return playerSym;
	}

	public void setPlayerSym(String playerSym) {
		this.playerSym = playerSym;
	}

	public int[] getPlayerPos() {
		return playerPos;
	}

	public void setPlayerPos(int[] playerPos) {
		this.playerPos = playerPos;
	}

	public int[] getPlayerPosLast() {
		return playerPosLast;
	}

	public void setPlayerPosLast(int[] playerPosLast) {
		this.playerPosLast = playerPosLast;
	}

	//
	//
	//
	//
	//

	public void printField() {

		for (int r = 0; r < getPlayableField().length; r++) {
			for (char f : getPlayableField()[r]) {
				System.out.print(f);
			}
			System.out.println("");
		}
	}

	public void checkWallThickness() {
		boolean check = false;
		while (check == false) {
			for (int i = 0; i == getPlayableField().length - 1; i++) {
				for (int j = 0; j == getPlayableField()[i].length - 1; j++) {
					if (playableField[i][j] == getBorderMark()) {
						borderThickness++;
					}
				}
			}
			check = true;
		}
	}

	public boolean canGO(int fieldX, int fieldY) {

		boolean canGoThere = false;
		System.out.println("");
		System.out.print("Du willst zu Position X: " + fieldX + " und Y: " + fieldY + ". ");

		if (playableField[fieldX][fieldY] == getBorderMark()) {
			canGoThere = false;
			System.out.print("Blockiert! Da kannst du nicht hin!");

		} else {
			canGoThere = true;
		}

		System.out.println("");

		return canGoThere;
	}

}
