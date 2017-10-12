package BlackJack;

import java.util.ArrayList;
import java.util.Random;

public class Hand {
		public enum Suits{
			SPADE, HEART, DIAMOND, CLUBS,
		}
		public enum Value{
			TWOO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE, 
		}
		private ArrayList<Deck> cards;
		
		public Hand() {
			this.cards = new ArrayList<Deck>();
		}
		
		public void createFullDeck() {
			for(Suits cardSuits : Suits.values()) {
				for(Value cardValue : Value.values()) {
					
					this.cards.add(new Deck(cardValue, cardSuits));
				}
			}
		}
		public String toString() {
			String cardListOutput = "";

			for(Deck aCard : this.cards) {
				cardListOutput += "\n" + aCard.toString();
			}
			return cardListOutput;
		}
		public void shuffle() {
			ArrayList<Deck> shuffleDeck = new ArrayList<Deck>();
			Random random = new Random();
			int randomCardIndex = 0;
			int originalSize = this.cards.size();
			for(int i = 0; i<originalSize; i++) {
				
				//Generate random Index rand.next
				randomCardIndex = random.nextInt((this.cards.size()-1-0)+1)+0;
				
				shuffleDeck.add(this.cards.get(randomCardIndex));
				//remove from doriginal deck
				this.cards.remove(randomCardIndex);
			}
			this.cards = shuffleDeck;
		}
		//give cards values
		public int cardValue() {
			int totalValue = 0;
			int aces = 0; 
			for(Deck aCard : this.cards) {
				switch (aCard.getValues()) {
				
				case TWOO: totalValue += 2; break;
				case THREE: totalValue += 3; break;
				case FOUR: totalValue += 4; break;
				case FIVE: totalValue += 5; break;
				case SIX: totalValue += 6; break;
				case SEVEN: totalValue += 7; break;
				case EIGHT: totalValue += 8; break;
				case NINE: totalValue += 9; break;
				case TEN: totalValue += 10; break;
				case JACK: totalValue += 10; break;
				case QUEEN: totalValue += 10; break;
				case KING: totalValue += 10; break;
				case ACE: aces+=1; break;
				}
			}
			if (aces == 1) {
				if (totalValue > 10) 
					totalValue += 1;
				else 
					totalValue +=11;
			}	
			return totalValue;
		}
		public Deck getCard(int i) {
			return this.cards.get(i);
		}
		public void removeCard(int i) {
			this.cards.remove(i);
		}
		public void addCard(Deck addCard) {
			this.cards.add(addCard);
		}
		public void draw(Hand playingDeck) {
			this.cards.add(playingDeck.getCard(0));
			playingDeck.removeCard(0);
		}
		public int deckSize() {
			return this.cards.size();
		}
		//put cards back deck
		public void moveAllToDeck(Hand move) {
			int thisDeckSize = this.cards.size();
			
			for(int i = 0; i < thisDeckSize; i++) {
				move.addCard(this.getCard(i));
			}
			for(int i = 0; i < thisDeckSize; i++) {
				this.removeCard(0);
			}
			
		}
}