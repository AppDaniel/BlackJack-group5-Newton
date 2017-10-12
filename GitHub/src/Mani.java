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
		int bet=1;
		
		do {
		bet = spelare.beta();
		boolean wrongInput;
		

			if (bet > money) {
				do {
					System.out.println(playerName + " don't have that much money...try again");
					wrongInput = false;
					while (!wrongInput) {
						try {
							bet = textInput.nextInt();
							textInput.nextLine();
							wrongInput = true;
						} catch (InputMismatchException e) {
							System.out.println("Wrong operator, please try agian! ");
							wrongInput = false;
						}
					}

				} while (bet > money && !wrongInput == false);
			} else if(bet !=0) {
				spelare.getHand();
				dealer.genereraKort();
				System.out.println(dealer.toString());
				int playerSum = spelare.hit();

				if (playerSum <= 21) {
					int dealerSum = dealer.dealaersChoice();
					if (dealerSum >= playerSum && dealerSum <= 21 || playerSum > 21) {
						System.out.println("Dealer Win");
						money = money-(bet*2);
					} else
						System.out.println("You win!");
					money = money + (bet*2);
				} else
					System.out.println("\nYou got to much, Dealer Win");
				money =  money-bet;
			}
			System.out.println("\n"+playerName+"'s Balance: " + ("€"+money));
		} while (0 < money  && bet !=0);
		
		
		if (money > 0)
			System.out.println("Thanks for playing you are going home with €"+money+" have a nice day!");
		else
		System.out.println("Game is now over, your Balance is €"+money);

		textInput.close();
	}
}