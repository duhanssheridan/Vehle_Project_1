package com.example.blackjack;
/*Encapsulates the behavior of a deck of cards.
Adheres to the Single Responsibility Principle by focusing on deck-related actions.
Provides a clear interface for actions like shuffling and dealing, enhancing reusability.*/

import java.util.Random;

import java.util.Random;

public class Deck {

	private int nextCardIndex;
	private Card[] deck = new Card[52];

	public Deck() {
		int count = 0;
		for (int i = 1; i <= 13; i++) {
			try {
				deck[count++] = new Card('H', i);
				deck[count++] = new Card('S', i);
				deck[count++] = new Card('C', i);
				deck[count++] = new Card('D', i);
			} catch (IllegalArgumentException e) {
				System.out.println("Error creating card in deck: " + e.getMessage());
			}
		}
		nextCardIndex = 0;
	}

	private void isIndexGood(int index) {
		if (index < 0 || index > 51) {
			throw new IllegalArgumentException("Invalid deck position: " + index);
		}
	}

	private void swapCards(int index1, int index2) {
		isIndexGood(index1);
		isIndexGood(index2);
		Card hold = deck[index1];
		deck[index1] = deck[index2];
		deck[index2] = hold;
	}

	public void shuffle() {
		Random rn = new Random();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < deck.length; j++) {
				swapCards(i, rn.nextInt(52));
			}
		}
		nextCardIndex = 0;
	}

	public Card getCard(int index) {
		isIndexGood(index);
		return deck[index];
	}

	public boolean compareTo(Deck otherDeck) {
		for (int i = 0; i < deck.length; i++) {
			if (!deck[i].compareTo(otherDeck.getCard(i))) {
				return false;
			}
		}
		return true;
	}

	public Card nextCard() {
		if (nextCardIndex < 0 || nextCardIndex > 51) {
			throw new IllegalArgumentException("Invalid deck position: " + nextCardIndex);
		}
		return deck[nextCardIndex++];
	}


}
