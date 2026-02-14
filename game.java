package New1;

import java.util.Scanner;

public class game {

	private static final String spaceholder = " --- ";
	static Scanner sc = new Scanner(System.in);

//	private static String playerSymbol = "^";
//
//	private static String[][] fieldNow;

	static boolean stopGame = false;
	private int startX = 10;
	private int startY = 10 ;
	Player p1 = new Player("Spieler 1", startX, startY, (char) Direction.UP.ordinal();
	//
	//
	//
	//
	//

	public static void main(String[] args) {

		Grundbedingungen();

		int startX;
		int startY;

		p1.startUpdate();
		Field.printField();
		while (stopGame == false) {

			printInstructions();

			Player.inputGetter(sc.next());

			System.out.println("");

			switch (startX) {
			case 1 -> p1.newDirection(x);
			}

		}

		Field.printField();
	}

	

	//
	//
	//
	//
	//

	public static void Grundbedingungen() {

		System.out.println("Fangen wir an.");
		System.out.println("Wie groß ist dein Feld?");

		System.out.println("X ist ");
		int manualX = sc.nextInt();

		System.out.println("Y ist ");
		int manualY = sc.nextInt();

		Field gameField = new Field(manualX, manualY);

		System.out.println("Wie dick ist deine Wand?");

		gameField.setBorderThickness(sc.nextInt());

		System.out.println("Wie sollen deine Feldmarkierungen aussehen?");

		while (true) {

			String fieldmarkManual = sc.next();
			if (fieldmarkManual.length() == 1 && fieldmarkManual.charAt(0) != gameField.getBorderMark()) {
				gameField.setInnerFieldMarks(fieldmarkManual.charAt(0));
				break; // Eingabe ist erfolgt und richtig
			} else {
				System.out.println("Bitte genau EIN Zeichen eingeben und nicht " + gameField.getBorderMark() + " !");
				// Eingabe ist erfolgt und falsch
			}
		}

	}

	public static void printInstructions() {
		System.out.println();
		System.out.println("Wähle deinen nächsten Schritt:");

		for (ActionHint a : ActionHint.values()) {
			System.out.print(" --- " + a.text + " (" + a.key + ")");
		}
		System.out.println(" ---");
		System.out.print(" >>> " + " Dein Wert: ");
	}

}
