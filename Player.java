package New1;

public class Player {

	private static final String goUp = "^";
	private static final String goRight = ">";
	private static final String goDown = "v";
	private static final String goLeft = "<";
	private static final String[] directionSymbol = { goUp, goRight, goDown, goLeft };
	private static final String playerSymbolStart = "^";

	private static final String left = "a";
	private static final String forward = "w";
	private static final String right = "d";
	private static final String back = "s";
	private static final String exitAll = "x";

	private static final String spaceholder = " --- ";

	private String playerSymbol = "^";
	private int[] playerPos = new int[2];
	private int[] playerPosNext = new int[2];
	private int directionX = 0;
	private String pName;

	public Player(String pName, int posX, int posY, char playerSymbol) {

		this.pName = pName;
		playerSymbol = playerSymbolStart;
		this.playerSymbol = playerSymbol;

		playerPos[0] = posX;
		playerPos[1] = posY;

		playerPosNext[0] = posX;
		playerPosNext[1] = posY;

	}

	public void nextTurn() {
		
		
	playerPos[0] = posX;
	playerPos[1] = posY;
	
	Direction[] dir = Direction.values();
	
	int dirX = dir.equals(directionSymbol);
	
	switch (directionSymbol.notify()) {
	
	case 0 -> 
	playerPosNext[0] = posX;
	playerPosNext[1] = posY;
	}
	
	}

	public String getPlayerSymbolStart() {
		return playerSymbolStart;
	}

	public void setplayerPos(int[] playerPos) {
		this.playerPos = playerPos;
	}

	public int[] getPlayerPos() {
		return playerPos;
	}

	public void setplayerPosNext(int[] playerPosNext) {
		this.playerPosNext = playerPosNext;
	}

	public int[] getPlayerPosNext() {
		return playerPosNext;
	}

	public String getPlayerSymbol() {
		return playerSymbol;
	}

	public void setPlayerSymbol(String playerSymbol) {
		this.playerSymbol = playerSymbol;
	}

	public static String getGoUp() {
		return goUp;
	}

	public String getGoRight() {
		return goRight;
	}

	public String getGoDown() {
		return goDown;
	}

	public String getGoLeft() {
		return goLeft;
	}

	//
	//
	//
	//
	//

	public static void inputGetter(String inputKey) {

		// Prüft en übergebenen Wert und handelt entsprechend
		switch (inputKey) {
		case left: {
			newDirection(+3);
		}
			break;
		case right: {
			newDirection(+1);
		}
			break;
		case back: {
			newDirection(+2);
		}
			break;

		case getForward(): {
			wantGO();

		}
			break;
		case exitAll: {
			System.exit(0);
		}
			break;

		default: {
			System.out.println("Unbekannter Wert: " + inputKey);
		}
		}

		updateAll();
	}

	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	public static String getForward() {
		return forward;
	}

	public static String getLeft() {
		return left;
	}

	public static String getRight() {
		return right;
	}

	public static String getBack() {
		return back;
	}

	public static int newDirection(Direction x) {

		// Nimmt den Wert auf, den es gedreht werden soll und ändert das Symbol
		System.out.println("");

		for (int i = 0; i < directionSymbol.length; i++) {
			if (directionSymbol[i].equals(getPlayerSymbol())) {
				directionX = i;
			}

		}

		int foundValue = directionX + x;

		if (foundValue > 3) {
			foundValue -= 4;

		}

		setPlayerSymbol(directionSymbol[foundValue]);

		return directionX;
	}

	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	public static void wantGO() {
		// Richtung, in die ich gehen will herausfinden und zum Test über geben
		for (int i = 0; i < directionSymbol.length; i++) {
			if (directionSymbol[i].equals(getPlayerSymbol())) {
				directionX = i;
				break;
			}
		}

		int nextX = fieldX;
		int nextY = fieldY;

		switch (directionX) {
		case 0 -> nextX--; // hoch
		case 1 -> nextY++; // rechts
		case 2 -> nextX++; // runter
		case 3 -> nextY--; // links
		}

		boolean go = Field.canGO(nextX, nextY); // <-- Ziel prüfen, nicht aktuelle Position

		if (go) {
//			int lastX = fieldX;
//			int lastY = fieldY;

			fieldX = nextX;
			fieldY = nextY;
			playerPos = new int[] { fieldX, fieldY };
			Field.setPlayerPos(playerPos);
//			field.setPlayerPosLast(new int[] { lastX, lastY });
		}
	}

	public void goStraight() {

		for (int i = 0; i < directionSymbol.length; i++) {
			if (directionSymbol[i].equals(getPlayerSymbol())) {
				directionX = i;
			}

		}
		switch (directionX) {
		case 0: {
			fieldX--;
		}
			break;
		case 1: {
			fieldY++;
		}
			break;
		case 2: {
			fieldX++;
		}
			break;
		case 3: {
			fieldY--;
		}
			break;
		}

		playerPos = new int[] { fieldX, fieldY };

		Field.setPlayerPos(playerPos);
		

	}

	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	public static void startUpdate() {
		Field.StartField();
		String[][] fieldNow = Field.getField();

		fieldX = Math.round(fieldNow.length / 2);
		fieldY = Math.round(fieldNow[fieldX].length / 2);

		fieldNow[fieldX][fieldY] = playerSymbol;

		Field.setPlayerPos(playerPos);

	}

	public static void updateAll() {
		Field.newField();
		String[][] fieldNow = Field.getField();

		fieldNow[fieldX][fieldY] = playerSymbol;

		Field.setPlayerPos(playerPos);

	}

}
