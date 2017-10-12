package BlackJack;

public class Dealer extends Hand {
	boolean endRun = true;
	Hand playingDeck = new Hand();
	Hand dealerDeck = new Hand();
	
	
	protected void generateCard(Hand playingDeck) {
		
		dealerDeck.draw(playingDeck);
		dealerDeck.draw(playingDeck);
		
		
	}
	protected int dealerChoice(Hand playingDeck) {
		System.out.println("\nDealers card: " + dealerDeck);
		
		while((dealerDeck.cardValue() < 17)&& endRun == true) {
			dealerDeck.draw(playingDeck);
			System.out.println("Dealer draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
			System.out.println("Dealer has " + dealerDeck);
		}
		System.out.println("Deler's hand is valued at: " + dealerDeck.cardValue());
		
		dealerDeck.moveAllToDeck(playingDeck);
		return dealerDeck.cardValue();
	}
	@Override
	public String toString() {
		return ("Dealers Cards is " + dealerDeck.getCard(0).toString() + " and [Hidden]");
	}
}