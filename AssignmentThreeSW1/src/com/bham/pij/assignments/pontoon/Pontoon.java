package com.bham.pij.assignments.pontoon;

//Dominic Carroll 1678959


import java.util.ArrayList;

public class Pontoon extends CardGame {
	
	public Pontoon (int players) {
		super(players);
		dealInitalCards();
	}

	@Override
	public void dealInitalCards() {
		for(Player player: players) {
			player.dealToPlayer(deck.dealRandomCard());
			player.dealToPlayer(deck.dealRandomCard());
		}
	}
	
	public int handValue(Player player) {
		int handSize = player.getHandSize();
		int value = player.getBestNumericalHandValue();
		ArrayList<Card> hand = player.getCards();
		
		boolean tenCard = hand.contains(Card.Value.TEN) || hand.contains(Card.Value.JACK) || hand.contains(Card.Value.QUEEN) || hand.contains(Card.Value.KING);
		boolean ace = hand.contains(Card.Value.ACE);
		
		if (value > 21) return 0;
		
		if (handSize == 2 && (ace && tenCard)) {
			//returns 23 if it is a pontoon
			return 23;
			
		} else if (handSize == 5 && value <= 21) {
			//returns 22 if it is a Five Card Trick
			return 22;
			
		} else if (handSize > 2 && value == 21) {
			//returns 21 if handValue == 21
			return 21;
			
		} else {
			return value;
		}
	}
	
	// May have to factor in pontoon (ACE + 10 card) and 5 card (5 card total under 21)
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
