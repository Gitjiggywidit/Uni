package com.bham.pij.assignments.pontoon;

//Dominic Carroll 1678959


import java.util.ArrayList;

public class Pontoon extends CardGame {
	
	public Pontoon (int nplayers) {
		super(nplayers);
	}

	@Override
	public void dealInitialCards() {
		for(Player player: players) {
			player.dealToPlayer(deck.dealRandomCard());
			player.dealToPlayer(deck.dealRandomCard());
		}
		
	}
	
	public int handValue(Player player) {
		int handSize = player.getHandSize();
		int value = player.getBestNumericalHandValue();
		ArrayList<Card> hand = player.getCards();
		
		if (value > 21) return 0;
		
		if (handSize == 2 && value == 21) {
			//returns 23 if it is a pontoon
			return 23;
			
		} else if (handSize == 5 && value <= 21) {
			//returns 22 if it is a Five Card Trick
			return 22;
			
		} else if (value == 21 && handSize >= 3) {
			//returns 21 if handValue == 21
			return value;
			
		} else {
			return value;
		}
	}
	
	@Override
	public int compareHands(Player hand1, Player hand2) {
		int hand1Val = handValue(hand1);
		int hand2Val = handValue(hand2);
		
		int toReturn;
		
		if(hand1Val > hand2Val) {
			toReturn = -1;
		} else if (hand2Val > hand1Val) {
			toReturn = 1;
		} else toReturn = 0;
		
		return toReturn;
	}

}
