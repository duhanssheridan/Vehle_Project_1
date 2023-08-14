package com.example.blackjack;
/*
Encapsulates a playing card's properties and behaviors.
Follows encapsulation by hiding internal details and providing controlled access through getters and setters.
Demonstrates abstraction through methods for checking face status, simplifying card management.
**/

public class Card {

	private char suit;
	private int value;

	public Card(char newSuit, int newValue) {
		try {
			if (newValue < 1 || newValue > 13) {
				throw new IllegalArgumentException("Invalid card value: " + newValue);
			}
			this.value = newValue;

			if (newSuit != 'H' && newSuit != 'S' && newSuit != 'D' && newSuit != 'C') {
				throw new IllegalArgumentException("Invalid card suit: " + newSuit);
			}
			this.suit = newSuit;
		} catch (IllegalArgumentException e) {
			System.out.println("Error creating card: " + e.getMessage());
		}
	}

	public String toString() {
		return getSuitName() + " " + this.value;
	}

	public String getSuitName() {
		String suit;
		if (this.suit == 'H') {
			suit = "Hearts";
		} else if (this.suit == 'S') {
			suit = "Spades";
		} else if (this.suit == 'C') {
			suit = "Clubs";
		} else if (this.suit == 'D') {
			suit = "Diamonds";
		} else {
			suit = "Unknown";
		}
		return suit;
	}

	public char getSuitDesignator() {
		return suit;
	}

	public String getValueName() {
		String name = "Unknown";
		if (this.value >= 2 && this.value <= 10) {
			name = Integer.toString(this.value);
		} else if (this.value == 1) {
			name = "Ace";
		} else if (this.value == 11) {
			name = "Jack";
		} else if (this.value == 12) {
			name = "Queen";
		} else if (this.value == 13) {
			name = "King";
		}
		return name;
	}

	public int getValue() {
		return this.value;
	}

	public boolean compareSuit(Card card) {
		return this.suit == card.getSuitDesignator();
	}

	public boolean compareValue(Card card) {
		return this.value == card.getValue();
	}

	public boolean compareTo(Card card) {
		return this.suit == card.getSuitDesignator() && this.value == card.getValue();
	}

}
