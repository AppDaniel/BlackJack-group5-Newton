package BlackJack;

public class Deck {
		
	public Value value;
	public Suits suits;
	
	public Deck(Value value, Suits suits) {
		
		this.value = value;
		this.suits = suits;
	}
	public String toString() {
		return this.suits.toString() + "-" + this.value.toString();
	}
	public Value getValues() {
		return this.value;
	}
}
