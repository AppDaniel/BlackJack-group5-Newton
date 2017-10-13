package BlackJack;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mani {

	public static void main(String[] args) {
		Scanner textinput = new Scanner(System.in);
		Hand playingDeck = new Hand();
		playingDeck.createFullDeck();
		playingDeck.shuffle();
		
		System.out.println("Hello and Weclome to Casino group 5!");
		System.out.println("What's your name sir/miss?");
		String playerName = textinput.nextLine();
		
		System.out.println("Hello " + playerName + " how much money do you have?");
		
		Guest player = new Guest(playerName, 0);
		Dealer dealer = new Dealer();
		
		int money = player.Money();
		int bet = 1;
		boolean wrongInput=false;
		do {
			bet = player.beta();
			
			
			while(bet > money && !wrongInput == false); {
				System.out.println(playerName + " don't have that much money...try again.");
					wrongInput = false;
					while(!wrongInput) {
						
						try {
							bet=textinput.nextInt();
						
							if (bet <= money) {
								wrongInput = true;
								break;
							}else bet=0;
							System.out.println(playerName + " don't have that much money...try again.");
						}catch(InputMismatchException e) {
							System.out.println("Wrong operator, please try again!");
							textinput.nextLine();
							wrongInput = false;
						}
					}
				
			}
			if(bet != 0) {
				
				int firstSum = player.getHand(playingDeck);
				if(firstSum != 21) {
				dealer.generateCard(playingDeck);
				System.out.println(dealer.toString());
				int playerSum = player.hit(playingDeck);				
				
				if(playerSum <= 21) {  
					int dealerSum = dealer.dealerChoice(playingDeck);
					
					if(dealerSum >= playerSum && dealerSum <= 21 || playerSum > 21) {	
						System.out.println("Dealer Win!");
						money -= bet;
					}else {
						System.out.println("You Win!");
					money += bet;
					}
				}else {
					System.out.println("\nBusted, Dealer Win!");
					money -= bet;
				}
			}else {
				System.out.println("---------------------------");
				System.out.println("BLACK JACK!!");
				money += bet;
				System.out.println("---------------------------");
			}
			}
			System.out.println("\n---------------------------");
			System.out.println(playerName+"'s Balance: " + ("€"+money));
			System.out.println("---------------------------");
			player.moveAllToDeck(playingDeck);
			dealer.moveAllToDeck(playingDeck);
			dealer.newDeck();
			player.newDeck2();
		}while(0 < money && bet != 0);
		
		if(money >0)
			System.out.println("Thanks for playing "+playerName+" you are going home with €"+money);
		else
			System.out.println("Game is over, your Balance is €"+money);
		
		textinput.close();
		
	}

}