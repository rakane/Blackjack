import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Blackjack {
	public static void main(String[] args) {
		
		// Had to use a double, used to cast back to integer for string comparison
		double zero = 0.0;
		
		boolean play = true;
		ArrayList<Card> deck;
		Hand player, cpu;
		Random randomGenerator;
		int deckSize;
		Scanner sc = new Scanner(System.in);
		
		// Loop so user can restart if needed
		while(play) {
			
			//Initialize deck, random generator, players, and deck size
			deck = new ArrayList<Card>();
			deckSize = 52;
			randomGenerator = new Random();
			player = new Hand();
			cpu = new Hand();
			
			// Add cards to deck, one rank of each suit
			for(int i = 1; i < 14; i++) {
				deck.add(new Card(i, "Hearts"));
				deck.add(new Card(i, "Spades"));
				deck.add(new Card(i, "Clubs"));
				deck.add(new Card(i, "Diamonds"));
			}
			
			
			System.out.println("Welcome to blackjack! Press any key and enter to continue: ");
			sc.hasNext();
			System.out.println();
		
			
			// Deal first Player Card
			int cardIndex = randomGenerator.nextInt(deckSize);
			player.add(deck.get(cardIndex));
			deck.remove(cardIndex);
			deckSize--;
			
			// Deal first Dealer Card
			cardIndex = randomGenerator.nextInt(deckSize);
			cpu.add(deck.get(cardIndex));
			deck.remove(cardIndex);
			deckSize--;
			
			// Deal second Player Card
			cardIndex = randomGenerator.nextInt(deckSize);
			player.add(deck.get(cardIndex));
			deck.remove(cardIndex);
			deckSize--;
			
			// Deal second Dealer Card
			cardIndex = randomGenerator.nextInt(deckSize);
			cpu.add(deck.get(cardIndex));
			deck.remove(cardIndex);
			deckSize--;
			
			// Print player cards
			System.out.println("Your cards are:");
			player.print();
			
			// Print Dealer Cards
			System.out.println("Dealers Face up card is (other is face down):");
			cpu.printCards(new ArrayList<Integer>(Arrays.asList(0)));
			
			
			boolean hit = true;
			String answer = "";
			
			// Loop to ask player if they want to hit or fold
			while(hit) {
				try {
					System.out.print("Do you want to hit or fold?(type it): ");
					answer = sc.nextLine();
					while(answer.compareToIgnoreCase("hit") != 0 && answer.compareToIgnoreCase("fold") != 0) {
						System.out.print("Do you want to hit or fold?(type it): ");
						answer = sc.nextLine();
					}
				} catch(InputMismatchException e) {
					e.printStackTrace();
				}
				
				// If hit, deal a card to player
				if(answer.compareToIgnoreCase("hit") == 0) {
					cardIndex = randomGenerator.nextInt(deckSize);
					player.add(deck.get(cardIndex));
					deck.remove(cardIndex);
					deckSize--;
					
					// Then, reprint cards for player to see
					System.out.println("Your cards are:");
					player.print();
					
					// If player total is over 21, they bust, and their turn is over
					if(player.getTotal() > 21) {
						System.out.println("You busted!!!");
						hit = false;
					}
					
				} else {
					hit = false;
				}
			}
			
			// Dealer hits until their total is >= 16
			int dealerTotal = cpu.getTotal();
			
			while(dealerTotal <= 16) {
				cardIndex = randomGenerator.nextInt(deckSize);
				cpu.add(deck.get(cardIndex));
				deck.remove(cardIndex);
				deckSize--;
				
				dealerTotal = cpu.getTotal();
			}
			
			// Print player and dealer totals
			System.out.println("\nYour total is: " + player.getTotal());
			
			System.out.println("\nDealer cards are:");
			cpu.print();
			System.out.println("Dealer total is: " + cpu.getTotal());
			
			System.out.println();
			
			// Get winner
			if(player.getTotal() > cpu.getTotal() && player.getTotal() <= 21) {
				System.out.println("YOU WIN!!!!");
			} else if(player.getTotal() < cpu.getTotal() || player.getTotal() > 21) {
				System.out.println("DEALER WINS!!");
			} else {
				System.out.println("Push, hand over");
			}
			
			
			// Ask user to play again
			System.out.print("\nPlay Again? (yes or no): ");
			try {
				answer = sc.nextLine();
				while(answer.compareToIgnoreCase("yes") != 0 && answer.compareToIgnoreCase("no") != 0) {
					System.out.print("Play Again? (yes or no): ");
					answer = sc.nextLine();
				}
			} catch(InputMismatchException e) {
				e.printStackTrace();
			}
			
			if(answer.compareToIgnoreCase("yes") == ((int) zero)) {
				play = true;
			} else {
				play = false;
				System.exit(0);
			}
			
		}
		
		sc.close();
	}
}
