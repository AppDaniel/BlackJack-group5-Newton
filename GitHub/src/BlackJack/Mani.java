package BlackJack;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Mani {

	public static void main(String[] args) {
		
		Hand playingDeck = new Hand();
		playingDeck.createFullDeck();
		playingDeck.shuffle();
		boolean endRun = true;
		Scanner textinput = new Scanner(System.in);
		
		System.out.println("Hello and Weclome yo Casino group 5!");
		System.out.println("What's your name sir/miss?");
		String playerName = textinput.nextLine();
		
		System.out.println("Hello " + playerName + " how much money do you ahve?");
		
		Guest player = new Guest(playerName, 100);
		Dealer dealer = new Dealer();
		
		int money = player.Money();
		int bet = 1;
		
		do {
			bet = player.beta();
			boolean wrongInput;
			
			if(bet > money) {
				do {
					System.out.println(playerName + " don't have that much money...try again.");
					wrongInput = false;
					while(!wrongInput) {
						try {
							bet=textinput.nextInt();
							textinput.nextLine();
							wrongInput = true;
						}catch(InputMismatchException e) {
							System.out.println("Wrong operator, please try again!");
							textinput.nextLine();
							wrongInput = false;
						}
					}
				}while(bet > money && !wrongInput == false);
			}else if(bet != 0) {
				player.getHand(playingDeck);
				dealer.generateCard(playingDeck);
				System.out.println(dealer.toString());
				
				int playerSum = player.hit(playingDeck);
				
				if(playerSum <= 21) {
					int dealerSum = dealer.dealerChoice(playingDeck);
					
					if(dealerSum >= playerSum && dealerSum <= 21 || playerSum > 21) {	
						System.out.println("Dealer Win!");
						money = money -(bet*2);
					}else 
						System.out.println("You Win!");
					money = money + (bet*2);
					
				}else 
					System.out.println("\nBusted, Dealer Win!");
					money = money - bet;
				
			}
			System.out.println("\n"+playerName+"'s Balance: " + ("€"+money));
			player.moveAllToDeck(playingDeck);
			dealer.moveAllToDeck(playingDeck);
		}while(0 < money && bet != 0);
		
		if(money >0)
			System.out.println("Thanks for playing you are going home with €"+money);
		else
			System.out.println("Game is over, your Balance is €"+money);
		
		textinput.close();
		
	}

}