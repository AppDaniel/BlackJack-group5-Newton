
public class Dealer extends Hand {

	private String kort = newCard();
	private String färg = newSuit();


	protected int dealaersChoice() {
		

		int värde = changeCard(kort);
		String kort1 = newCard();
		String färg1 = newSuit();
		int värde1 = changeCard(kort1);


		System.out.println("\nDealers card: " + kort + " of " + färg + " and " + kort1 + " of " + färg1);

		int dealerSum = värde + värde1;
		System.out.println("Dealer have: " + dealerSum);

		if (dealerSum <= 16) {
			System.out.println("Dealer draw card, needs to draw until 17 or more");

			do {

				String kort2 = newCard();
				String färg2 = newSuit();
				int värde2 = changeCard(kort2);
				String mhm = kort2 + " of " + färg2;

				System.out.println("Dealers new card: " + mhm);
				dealerSum += värde2;

			} while (dealerSum <= 16);
			System.out.println("Dealer got: " + dealerSum);
		}
		return dealerSum;
	}


	@Override
	public String toString() {
		return "Dealers Cards is " + kort + " of " + färg + " and [card hidden]";
	}
}
