package com.bham.pij.assignments.pontoon;

//Dominic Carroll 1678959


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	Card.Suit[] suits = {
			Card.Suit.CLUBS, 
			Card.Suit.DIAMONDS, 
			Card.Suit.HEARTS, 
			Card.Suit.SPADES
			}; 
	
	Card.Value[] values = {
			Card.Value.ACE, 
			Card.Value.TWO, 
			Card.Value.THREE, 
			Card.Value.FOUR, 
			Card.Value.FIVE, 
			Card.Value.SIX, 
			Card.Value.SEVEN, 
			Card.Value.EIGHT, 
			Card.Value.NINE,
			Card.Value.TEN,
			Card.Value.JACK,
			Card.Value.QUEEN,
			Card.Value.KING
			}; 

	public Deck() {
		createDeck();
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public void reset() {
		deck.clear();
		createDeck();
	}
	
	public void createDeck() {
		for(int s = 0; s <= 3; s++) {
			Card.Suit suit = suits[s];
			
			for(int v = 0; v <= 12; v++) {
				Card.Value value = values[v];
				Card card = new Card(suit, value);
				
				this.deck.add(card);
			}
		}
		shuffle();
	}
	
	public Card dealRandomCard() {
		if (size() == 0) {
			return null;
		}
		else {
			Random rand = new Random();
			int randomIndex = rand.nextInt(size());
			Card cardToDeal = deck.get(randomIndex);
			deck.remove(randomIndex);
			return cardToDeal;
		}
	}
	
	public Card getCard(int i) {
		return deck.get(i);
	}
	
	public int size() {
		return deck.size();
	}
}
