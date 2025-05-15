package week06Assignemnt;

public class Card {

	// fields
	//--------------------------------------------------
	
	private int value; // Value from 2-14
	private String name; // Name like "Ace of Diamonds"
	private String suit; // Suit like "hearts, diamonds" etc.
	
	// Constructor: every card has a value, suit and name
	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
		this.name = generateName();
	}
	
	// Methods
	//-------------------------------------------------------------------------
	// Getters
	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSuit() {
		return suit;
	}
	
	// Setters
	public void setValue(int value) {
		this.value = value;
		this.name = generateName();
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
		this.name = generateName();
	}
	
	// describe the card
	private String generateName() {
		String valueName;
		switch (value) {
			case 11:
				valueName = "Jack";
				break;
			case 12: 
				valueName = "Queen";
				break;
			case 13:
				valueName = "King";
				break;
			case 14:
				valueName = "Ace";
				break;
			default:
				valueName = String.valueOf(value);
		}
		return valueName + " of " + suit;
	}

	public void describe() {
		// TODO Auto-generated method stub
		// print card name
		System.out.println(name);
	}

}
