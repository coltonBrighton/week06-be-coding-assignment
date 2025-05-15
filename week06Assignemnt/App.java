package week06Assignemnt;

public class App {

	public static void main(String[] args) {
		// Instantiate and shuffle deck
		Deck deck = new Deck();
		deck.shuffle();
		
//		instantiate player1 and player 2
		Player player1 = new Player("Jeff");
		Player player2 = new Player("Geraldine");
		
		dealCards(deck, player1, player2);
		printHands(player1, player2);
		startGame(player1, player2);
		announceWinner(player1, player2);
	}
	
	public static void printHands(Player player1, Player player2) {
	    player1.describeHand();
	    player2.describeHand();
	}

	// Method to deal all cards alternately to players
	public static void dealCards(Deck deck, Player player1, Player player2) {
//		fill the deck with cards and deal 26 cards to each player
		for (int i = 0; i < 52; i++) {
			if (i % 2 == 0) {
				player1.draw(deck);
			} else {
				player2.draw(deck);
			}
		}
	}

	// Method to simulate 26 rounds of card flipping
	public static void startGame(Player player1, Player player2) {
//		get names of player1 and player 2
		String p1Name = player1.getName();
		String p2Name = player2.getName();
		
// 		iterate 26 times to give 26 cards to each player
		for (int i = 0; i < 26; i++) {
//			Use flip to flip the top card of each players hand
			Card p1Card = player1.flip();
			Card p2Card = player2.flip();

//			print out the current round and a border
			System.out.println("Round " + (i + 1) + ":");
			System.out.println("=".repeat(40));
			
//			print out the player and the card the player played
			System.out.print("\t" + p1Name + " Plays: ");
			p1Card.describe();
			System.out.println();
			System.out.print("\t" + p2Name + " Plays: ");
			p2Card.describe();
			System.out.println();

//			get the values of the 2 cards
			int p1Value = p1Card.getValue();
			int p2Value = p2Card.getValue();

			String roundWinner;
//			compare card values. Larger value wins a point. If no value is larger then it is a tie
			if (p1Value > p2Value) {
				player1.incrementScore();
				roundWinner = p1Name + " wins a point!";
			} else if (p2Value > p1Value) {
				player2.incrementScore();
				roundWinner = p2Name + " wins a point!";
			} else {
				roundWinner = "It's a tie!";
			}

//			print out the winner of the round
			System.out.println("\t~+~ " + roundWinner + " ~+~\n");
//			print out scores of each player
			scoreMessage();
			printScores(player1, player2);
		}
	}

	// Method to print current scores
	public static void printScores(Player player1, Player player2) {
		System.out.printf("\t%s: %d points\n", player1.getName(), player1.getScore());
		System.out.printf("\t%s: %d points\n\n", player2.getName(), player2.getScore());
	}
	
	public static void scoreMessage() {
		System.out.println("\t|~| Scores |~|\n");
	}
	
	public static void finalScoreMessage() {
		System.out.println("~".repeat(40));
		System.out.println("\t=== Final Scores ===");
	}

	// Method to announce the final winner
	public static void announceWinner(Player player1, Player player2) {
		int p1Score = player1.getScore();
		int p2Score = player2.getScore();
		
		finalScoreMessage();
		printScores(player1, player2);

		String message;
		if (p1Score > p2Score) {
			message = player1.getName() + " wins the game!";
		} else if (p2Score > p1Score) {
			message = player2.getName() + " wins the game!";
		} else {
			message = "The game is a draw!";
		}
		System.out.println("\t### " + message + " ###");
		System.out.println("~".repeat(40) + "\n");
	}
}

