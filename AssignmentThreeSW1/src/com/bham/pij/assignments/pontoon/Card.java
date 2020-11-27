package com.bham.pij.assignments.pontoon;

//Dominic Carroll 1678959

import java.util.ArrayList;

public class Card {
	private Suit suit;
	private Value value;
	
	/**
	 * Constructor, gives the class 'Card' a suit + value.
	 * Parameters for 'suit' and 'value' must be written in all caps
	 * e.g 'Card(SPADES, ACE);'
	 * @param suit
	 * @param value
	 */
	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	
	public static enum Suit { CLUBS, SPADES, HEARTS, DIAMONDS }
	
	public static enum Value { ACE,	TWO, THREE, FOUR, FIVE,	SIX, SEVEN,	EIGHT, NINE, TEN, JACK,	QUEEN, KING }
	
	public Suit getSuit() {
		return suit;
	}
	
	public Value getValue() {
		return value;
	}
	
	public ArrayList<Integer> getNumericalValue() {
		ArrayList<Integer> cardValue = new ArrayList<Integer>();
		switch(value) {
			case ACE:
				cardValue.add(1);
				cardValue.add(11);
				break;
				
			case TWO:
				cardValue.add(2);
				break;
				
			case THREE:
				cardValue.add(3);
				break;
				
			case FOUR:
				cardValue.add(4);
				break;
				
			case FIVE:
				cardValue.add(5);
				break;
				
			case SIX:
				cardValue.add(6);
				break;
				
			case SEVEN:
				cardValue.add(7);
				break;
				
			case EIGHT:
				cardValue.add(8);
				break;
				
			case NINE:
				cardValue.add(9);
				break;
				
			case TEN:
			case JACK:
			case QUEEN:
			case KING:
				cardValue.add(10);
				break;
				
		}
		return cardValue;

	}
	
}