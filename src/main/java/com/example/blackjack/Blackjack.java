package com.example.blackjack;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) throws Exception {
		BlackjackGame mygame = new BlackjackGame();
		mygame.initializeGame();

		do {
			mygame.shuffle();
			mygame.getBets();
			mygame.dealCards();
			mygame.printStatus();
			mygame.checkBlackjack();
			mygame.hitOrStand();
			mygame.dealerPlays();
			mygame.settleBets();
			mygame.printMoney();
			mygame.clearHands();
		} while (mygame.playAgain());
	}

}
