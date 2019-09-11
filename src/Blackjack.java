import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Blackjack {
	public static void main(String[] args) {
		
		boolean play = true;
		ArrayList<Card> deck;
		Hand player, cpu;
		Random randomGenerator;
		int deckSize;
		
		// Loop so user can restart if needed
		while(play) {
			
			deck = new ArrayList<Card>();
			deckSize = 52;
			randomGenerator = new Random();
			player = new Hand();
			cpu = new Hand();
			Scanner sc = new Scanner(System.in);
			
			for(int i = 1; i < 14; i++) {
				deck.add(new Card(i, "Hearts"));
				deck.add(new Card(i, "Spades"));
				deck.add(new Card(i, "Clubs"));
				deck.add(new Card(i, "Diamonds"));
			}
			
			System.out.println("Welcome to blackjack! Press any key and enter to continue: ");
			sc.hasNext();
		
			
			
			// First Player Card
			int cardIndex = randomGenerator.nextInt(deckSize);
			player.add(deck.get(cardIndex));
			deck.remove(cardIndex);
			deckSize--;
			
			// First Dealer Card
			cardIndex = randomGenerator.nextInt(deckSize);
			cpu.add(deck.get(cardIndex));
			deck.remove(cardIndex);
			deckSize--;
			
			// Second Player Card
			cardIndex = randomGenerator.nextInt(deckSize);
			player.add(deck.get(cardIndex));
			deck.remove(cardIndex);
			deckSize--;
			
			// Second Dealer Card
			cardIndex = randomGenerator.nextInt(deckSize);
			cpu.add(deck.get(cardIndex));
			deck.remove(cardIndex);
			deckSize--;
			
			System.out.println("Your cards are:");
			player.print();
			
			System.out.println("Dealers Face up card is (other is face down):");
			cpu.printCards(new ArrayList<Integer>(Arrays.asList(0)));
			
			boolean hit = true;
			String answer = "";
			
			while(hit) {
				System.out.print("Do you want to hit or fold?(type it): ");
				try {
					answer = sc.nextLine();
					while(answer.compareToIgnoreCase("hit") != 0 && answer.compareToIgnoreCase("fold") != 0) {
						System.out.print("Do you want to hit or fold?(type it): ");
						answer = sc.nextLine();
					}
				} catch(InputMismatchException e) {
					e.printStackTrace();
				}
				
				if(answer.compareToIgnoreCase("hit") == 0) {
					cardIndex = randomGenerator.nextInt(deckSize);
					player.add(deck.get(cardIndex));
					deck.remove(cardIndex);
					deckSize--;
					
					System.out.println("Your cards are:");
					player.print();
					
					if(player.getTotal() > 21) {
						System.out.println("You busted!!!");
						hit = false;
					}
					
				} else {
					hit = false;
				}
			}
			
			//Implement Dealer Here!!!
			
			int dealerTotal = cpu.getTotal();
			
			while(dealerTotal <= 16) {
				cardIndex = randomGenerator.nextInt(deckSize);
				cpu.add(deck.get(cardIndex));
				deck.remove(cardIndex);
				deckSize--;
				
				dealerTotal = cpu.getTotal();
			}
			
			System.out.println("\nYour total is: " + player.getTotal());
			
			System.out.println("\nDealer cards are:");
			cpu.print();
			System.out.println("Dealer total is: " + cpu.getTotal());
			
			
			if(player.getTotal() > cpu.getTotal()) {
				System.out.println("YOU WIN!!!!");
			} else if(player.getTotal() < cpu.getTotal()) {
				System.out.println("DEALER WINS!!");
			} else {
				System.out.println("Push, hand over");
			}
			
			System.out.print("Play Again? (yes or no): ");
			try {
				answer = sc.nextLine();
				while(answer.compareToIgnoreCase("yes") != 0 && answer.compareToIgnoreCase("no") != 0) {
					System.out.print("Play Again? (yes or no): ");
					answer = sc.nextLine();
				}
			} catch(InputMismatchException e) {
				e.printStackTrace();
			}
			
			if(answer.compareToIgnoreCase("yes") == 0) {
				play = true;
			} else {
				play = false;
			}
			
			sc.close();
		}
		
	}
}
