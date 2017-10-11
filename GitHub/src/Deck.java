
import java.util.ArrayList;
import java.util.Random;

public class Deck {


	String suit[] = { "DIAMOND", "HEART", "SPADE", "CLUB" };
	String values[] = { "TWOO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN",
			"KING", "ACE" };
	
	ArrayList<String> newList = new ArrayList<>();

	Random random = new Random();
	
	protected void newCard3() {
			for (int s = 0; s < suit.length; s++) {
				for (int v = 0; v < values.length; v++) {
					String aNewCard = values[v]+ " "+ suit[s];
					System.out.println(aNewCard);
				}	
			}
	}

	protected String createSuit() {
		String suits = suit[random.nextInt(suit.length)];
		return suits;
	}

	protected String createValue() {
		String value = values[random.nextInt(values.length)];
		return value;
	}

}
