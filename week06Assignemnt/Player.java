package week06Assignemnt;

import java.util.ArrayList;
import java.util.List;

public class Player {

	// Fields
	//-------------------------------------------------------------------------
	private List<Card> hand; 
	private int score; 
	private String name;
	
	// Constructor: every player has a name, score, and a hand
	public Player(String name) {
		this.name = name;
		this.score = 0;
		this.hand = new ArrayList<>();
	}
	
	// Methods
	//-----------------------------------------------------------------------------
	
	// Method to show the player and their hand
	public void describe() {
		System.out.println("Player: " + name);
		System.out.println("Score: " + score);
	}
	
	public void describeHand() {
		System.out.println("Hand:");
		for (Card card: hand) {
			card.describe();
		}
	}
	
	// Flip : removes and returns the top card of hand
	public Card flip() {
		if (!hand.isEmpty()) {
			return hand.remove(0);
		} else {
			return null;
		}
	}
	
	// Draw : draws a card from deck and add it to hand
	public void draw(Deck deck) {
		Card drawnCard = deck.draw();
		if (drawnCard != null) {
			hand.add(drawnCard);
		}
	}
	
	// incrementScore: add 1 to the score
	public void incrementScore() {
		score++;
	}
	
	// Getters
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Card> getHand() {
		return hand;
	}

}
