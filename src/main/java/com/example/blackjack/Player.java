package com.example.blackjack;
/*
Models a player and their attributes.
Encapsulation is followed by managing player-specific properties like name, money, and hand.
Promotes reusability with methods for betting, getting money, and accessing the hand instance.

 */


public class Player {

	private int bank;
	private int bet;
	private String name;
	private Hand hand;

	public Player() {
		bank = 100;
		hand = new Hand();
	}

	public int getBank() {
		return bank;
	}

	public void bust() {
		bank -= bet;
		bet = 0;
	}

	public void win() {
		bank += bet;
		bet = 0;
	}

	public void loss() {
		bank -= bet;
		bet = 0;
	}

	public void removeFromGame() {
		bank = -1;
	}

	public void resetBank() {
		bank = 0;
	}

	public void blackjack() {
		bank += bet * 3 / 2; // Adjusted for blackjack payout
		bet = 0;
	}

	public void push() {
		bet = 0;
	}

	public void setBet(int newBet) {
		bet = newBet;
	}

	public void setName(String name1) {
		name = name1;
	}

	public String getName() {
		return name;
	}

	public int getTotal() {
		return hand.calculateTotal();
	}

	public int getBet() {
		return bet;
	}

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public String getHandString() {
		return "Cards: " + hand.toString();
	}

	public void clearHand() {
		hand.clearHand();
	}
}
