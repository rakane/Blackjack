import java.util.ArrayList;

public class Hand {
	
	ArrayList<Card> cards;
	int num_aces;
	
	/**  
	 * Hand Constructor
	 */
	public Hand() {
		cards = new ArrayList<Card>();
		num_aces = 0;
	}
	
	
	/**  
	 * Add card object to hand's cards
	 * @param new_card
	 * 	New card object to add to the hand
	 */
	public void add(Card new_card) {
		if(new_card.getRank() == 1) {
			num_aces++;
		}
		cards.add(new_card);
	}
	
	
	/**  
	 * Returns total of hand, properly handles aces
	 * @return total of hand
	 */
	public int getTotal() {
		int total = 0;
		for(int i = 0; i < cards.size(); i++) {
			if(cards.get(i).getRank() >= 11) {
				total += 10;
			} else {
				total += cards.get(i).getRank();
			}	
		}
		
		if((total > 21) && (num_aces >= 1)) {
			return total - 10;
		} else {
			return total;
		}
	}
	
	/**  
	 * Prints all cards whose index in the list is also in card_nums
	 * @param card_nums
	 * 	ArrayList of indices of the cards to print
	 */
	public void printCards(ArrayList<Integer> card_nums) {
		for(int i = 0; i < card_nums.size(); i++) {
			cards.get(i).print();
		}
		System.out.println();
	}
	
	/**  
	 * Prints all cards in the hand
	 */
	public void print() {
		for(int i = 0; i < cards.size(); i++) {
			cards.get(i).print();
		}
		System.out.println();
	}
	
}
