package com.bham.pij.assignments.pontoon;

//Dominic Carroll 1678959


import java.util.ArrayList;
import java.util.Collections;

public class Player {
	
	private String name;
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	/**
	 * Builds the class with the parameter passed
	 *@param name
	 */
	public Player(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name associated with this instance of 'name'
	 * @return String name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This method deals a card to a player, i.e. it adds a card to a player’s hand
	 * @param card
	 */
	public void dealToPlayer(Card card) {
		hand.add(card);
	}
	
	/**
	 * This method removes a card from a player’s hand
	 * @param card
	 */
	public void removeCard(Card card) {
		hand.remove(card);
	}
	
	/**
	 * This method returns all of the possible numerical values of a hand. This will comprise multiple values if
	 * the hand contains ACE cards since each ACE card can have the value 1 or 11. The numerical values of
	 * the hand should be returned in low to high order (i.e. the lowest value is returned at index 0)
	 * @return
	 */
	public ArrayList<Integer> getNumericalHandValue() {
		int handSize = getHandSize();
		ArrayList<Integer> allValues = new ArrayList<Integer>();
		
		int sum = 0;
		allValues.add(sum);
		
		for(int i = 0; i < handSize; i++) {
			Card card = hand.get(i);
			boolean ace = card.getValue() == Card.Value.ACE;
			ArrayList<Integer> cardNumValue = card.getNumericalValue();
			
			if(!ace) {
				int arraySize = allValues.size();
				for(int j = 0; j < arraySize; j++) {
					int value = cardNumValue.get(0);
					allValues.set(j, (allValues.get(j) + value));
				}
				
			} else {
				int arraySize = allValues.size();
				
				//Copy the array as each element will have to add both 1 and 11
				ArrayList<Integer> extendValues = (ArrayList<Integer>) allValues.clone();
				
				//Add 1 to the original array
				//allValues.forEach((n) -> n += 1);
				for(int j = 0; j < arraySize; j++) allValues.set(j, (allValues.get(j) + 1));				
				
				//add 11 to the copied array, then add the list onto allValue list.
				//extendValues.forEach((n) -> n += 11);
				for(int j = 0; j < arraySize; j++) extendValues.set(j, (extendValues.get(j) + 11));

				allValues.addAll(extendValues);
			}
		}
		return allValues;
	}

	
	/**
	 * This method returns the maximum numerical value of the player’s hand of cards.
	 * @return
	 */
	public int getBestNumericalHandValue() {
		ArrayList<Integer> values = getNumericalHandValue();
		int optimalNum = 0;
		
		for(int value: values) {
			boolean optimal = value > optimalNum && value < 22;
			if(optimal) optimalNum = value;
		}
		if(optimalNum == 0) {
			Collections.sort(values);
			return values.get(0);
		}
		return optimalNum;
	}
	
	/**
	 * Returns the cards in the player’s hand
	 * @return
	 */
	public ArrayList<Card> getCards() {
		return hand;
	}
	
	/**
	 * Returns the number of cards in the player’s hand
	 * @return
	 */
	public int getHandSize() {
		return hand.size();
	}
	
}
