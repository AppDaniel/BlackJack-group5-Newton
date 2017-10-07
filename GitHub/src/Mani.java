import java.util.InputMismatchException;
import java.util.Scanner;

public class Mani {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner textInput = new Scanner(System.in);

		System.out.println("Hello and Welcome to Casino group 5!");
		System.out.println("What's your name sir/miss?");
		String playerName = textInput.nextLine();

		System.out.println("Hello " + playerName + " how much money do you have? ");
		
			Guest spelare = new Guest(playerName, 100);
			Dealer dealer = new Dealer();

			int money = spelare.Money();
			int bet = spelare.beta();
			
			do {	

			if (bet > money) {
				do {
				System.out.println(playerName + " don't have that much money...try again");
				boolean wrongInput = false;	
				while (!wrongInput) {
					try {
						bet = textInput.nextInt();
						wrongInput = true;
					} catch (InputMismatchException e) {
						System.out.println("Wrong operator, please try agian! ");
						textInput.nextLine();
						wrongInput = false;

					}
				}
//				bet = textInput.nextInt();
				} while (bet>money);
			} else {
				spelare.getHand();
				System.out.println(dealer.toString());
				System.out.println("\nDo you want to Hit or Stay?");
				int playerSum = spelare.hit();

			
				
				if (playerSum <= 21) {
					int dealerSum = dealer.dealaersChoice();
					if (dealerSum >= playerSum && dealerSum <= 21 || playerSum > 21) {
						System.out.println("Dealer Win");
						System.out.println("New Balance: " + (money - bet));
						break;
						
					} else
						System.out.println("You win!");
					System.out.println("New Balance: " + (bet + money));
					break;
					
				} else
					System.out.println("\nYou got to much, Dealer Win");
				System.out.println("New Balance: " + (money - bet));
				break;
			}
		} while (bet <= money);


		textInput.close();
	}
}