import java.util.ArrayList;

public class Hand {
	
	ArrayList<Card> cards;
	int num_aces;
	
	public Hand() {
		cards = new ArrayList<Card>();
		num_aces = 0;
	}
	
	public void add(Card new_card) {
		if(new_card.getRank() == 1) {
			num_aces++;
		}
		cards.add(new_card);
	}
	
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
	
	public void printCards(ArrayList<Integer> card_nums) {
		for(int i = 0; i < card_nums.size(); i++) {
			cards.get(i).print();
		}
		System.out.println();
	}
	
	public void print() {
		for(int i = 0; i < cards.size(); i++) {
			cards.get(i).print();
		}
		System.out.println();
	}
	
}
