package week06Assignemnt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	// Fields
	//-------------------------------------------------------------------------
	// 		cards (list of card)
	private List<Card> cards; 
	
	// Constructor: every deck has 4 suits and 52 cards
	public Deck() {
		// instantiate the new list of cards
		cards = new ArrayList<>();
		// make an array of suits
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		
		// iterate through each suit in the suits array
		for (String suit : suits) {
			// iterate through the value assigned to each card
			for (int value = 2; value <= 14; value++) {
				// add each card to cards
				cards.add(new Card(value, suit));
			}
		}
	}
	
	// Methods
	//-------------------------------------------------------------------------
	
	// shuffle method - randomize order of the cards 
	public void shuffle() {
		// .shuffle() is apart of the Java Collections Framework for internally implementing
		// the fisher-yates shuffle algorithm 
		Collections.shuffle(cards);
	}
	
	// Draw Method - remove and return the top card of the deck
	public Card draw() {
		// check that there is a card available to draw
		if (!cards.isEmpty()) {
			// return the card being removed from the top of the deck
			return cards.remove(0);
		} else {
		// if there is no card return the value null
			return null;
		}
	}
	
	
	

}
