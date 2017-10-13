package BlackJack;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Guest extends Hand {
	
	protected String name;
	protected int Cash;
	
	public Guest(String name, int cash) {
		this.name = name;
		this.Cash = cash;
	}
	
	Hand playingDeck = new Hand();
	Hand playerDeck = new Hand();
	protected int newSum=0;
	
	int getHand(Hand playingDeck) {
		playerDeck.draw(playingDeck);
		playerDeck.draw(playingDeck);
		
		System.out.println(playerDeck);
		newSum=playerDeck.cardValue();
		System.out.println("Your total sum is: " + newSum);
		return newSum;
	}
	
	Scanner textInput = new Scanner (System.in);
	
	protected int hit(Hand playingDeck) {
		do {
			if(playerDeck.cardValue() < 21) {
				System.out.println("\nDo you want to Hit or Stay?");
				
				String hit = textInput.nextLine();
			
				
				if(hit.equals("hit")) {
					playerDeck.draw(playingDeck);
					System.out.println("New card: " + playerDeck);
					newSum = playerDeck.cardValue();
					System.out.println("New total: " + newSum);
					
				}else if(hit.equals("stay")) {
					newSum = playerDeck.cardValue();
					break;
				}
			}
		}while (playerDeck.cardValue() != 21 && playerDeck.cardValue() <= 20);
		
		return newSum;
	}
	protected int Money() {
		int money = 0; 
		boolean yourMoney = false;
		while(!yourMoney) {
			try {
				money = textInput.nextInt();
				textInput.nextLine();
				yourMoney = true;
			}catch(InputMismatchException e) {
				System.out.println("Wrong operator, please try again!");
				textInput.nextLine();
				yourMoney = false;
			}
		}
		return money;
	}
	protected int beta() {
		int bet = 0;
		System.out.println("How much would you like to bet?");
		System.out.println("0 = end game");
		boolean betMoney = false;
		while(!betMoney) {
			try {
				bet=textInput.nextInt();
				textInput.nextLine();
				betMoney = true;
			}catch(InputMismatchException e) {
				System.out.println("Wrong operator, please try again!");
				textInput.nextLine();
				betMoney = false;
			}
		}
		return bet;
	}
	protected void newDeck2()
	{
		playerDeck.moveAllToDeck(playingDeck);
	}
}