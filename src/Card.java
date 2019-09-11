
public class Card {
	
	private int rank;
	private String suit;
	
	public Card(int r, String s) {
		this.rank = r;
		this.suit = s;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	private final String[] rankName
    = {"?","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	public void print() {
		System.out.println(rankName[this.rank] + " of " + suit);
	}
}
