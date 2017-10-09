import java.util.InputMismatchException;
import java.util.Scanner;

public class Hand extends Deck {

	protected String newCard() {
		String aNewCard = createValue();
		return aNewCard;

	}

	protected String newSuit() {
		String newSuit = createSuit();
		return newSuit;
	}

	protected int changeCard(String aNewCard) {
		String card = aNewCard;
		int value = 0;
		switch (card) {
		case "TWOO":
			value += 2;
			break;
		case "THREE":
			value += 3;
			break;
		case "FOUR":
			value += 4;
			break;
		case "FIVE":
			value += 5;
			break;
		case "SIX":
			value += 6;
			break;
		case "SEVEN":
			value += 7;
			break;
		case "EIGHT":
			value += 8;
			break;
		case "NINE":
			value += 9;
			break;
		case "TEN":
			value += 10;
			break;
		case "JACK":
			value += 10;
			break;
		case "QUEEN":
			value += 10;
			break;
		case "KING":
			value += 10;
			break;
		case "ACE":
			value +=11;
			break;
		}

		return value;
	}
	protected int changeNewCard(String aNewCard) {
		Scanner textInput = new Scanner(System.in);
		String card = aNewCard;
		int value = 0;
		int ace = 0;
		switch (card) {
		case "TWOO":
			value += 2;
			break;
		case "THREE":
			value += 3;
			break;
		case "FOUR":
			value += 4;
			break;
		case "FIVE":
			value += 5;
			break;
		case "SIX":
			value += 6;
			break;
		case "SEVEN":
			value += 7;
			break;
		case "EIGHT":
			value += 8;
			break;
		case "NINE":
			value += 9;
			break;
		case "TEN":
			value += 10;
			break;
		case "JACK":
			value += 10;
			break;
		case "QUEEN":
			value += 10;
			break;
		case "KING":
			value += 10;
			break;
		case "ACE":
			boolean wrongInput = false;
			int a = 0;
			do {
			while (!wrongInput) {

				try {
					System.out.println("You have a chioce of you ace 1 or 11?");
					a = textInput.nextInt();
//					textInput.nextLine();
					wrongInput = true;
				} catch (InputMismatchException e) {
					System.out.println("Value is not corret");
					textInput.nextLine();
					wrongInput = false;
				}

			}	

			} while (a !=11 || a!=1);
			value += a;
			break;
		}

		return value;
	}


}
