
public class Card {
	
	private int rank;
	private String suit;
	
	
	/**  
	 * Card class Constructor
	 * @param r
	 * 	rank of card
	 * @param s
	 * 	suit of card
	 */
	public Card(int r, String s) {
		this.rank = r;
		this.suit = s;
	}
	
	/**  
	 * Returns rank of card
	 * @return Rank of card object
	 */
	public int getRank() {
		return this.rank;
	}
	
	/**  
	 * Returns suit of card
	 * @return Suit of card object
	 */
	public String getSuit() {
		return this.suit;
	}
	
	private final String[] rankName
    = {"?","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	
	/**  
	 * Prints card in format: "Rank of suit"
	 */
	public void print() {
		System.out.println(rankName[this.rank] + " of " + suit);
	}
}
