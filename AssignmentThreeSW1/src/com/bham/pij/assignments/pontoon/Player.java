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
		
		//Give the Array and initial value for the hand to modify
		int sum = 0;
		allValues.add(sum);
		
		//iterate through the hand
		for(int i = 0; i < handSize; i++) {
			//Get the value of the card in hand and determine if it is an ACE
			Card card = hand.get(i);
			boolean ace = card.getValue() == Card.Value.ACE;
			ArrayList<Integer> cardNumValue = card.getNumericalValue();
			
			//If the card is not an ACE:
			if(!ace) {
				//Give the number of possible values so far
				int arraySize = allValues.size();
				for(int j = 0; j < arraySize; j++) {
					//Get the value of the card from card class, method return ArrayList of len 1 so get(0) always returns the right number
					int value = cardNumValue.get(0);
					//Adds that value to each item in the Values ArrayList
					allValues.set(j, (allValues.get(j) + value));
				}
			//If the card is an ACE:
			} else {
				//Give the number of possible values so far
				int arraySize = allValues.size();
				
				//Copy the array as each element will have to add both 1 and 11
				ArrayList<Integer> extendValues = (ArrayList<Integer>) allValues.clone();
				
				//Add 1 to the original array
				for(int j = 0; j < arraySize; j++) allValues.set(j, (allValues.get(j) + 1));				
				
				//add 11 to the copied array, then add the list onto allValue list.
				for(int j = 0; j < arraySize; j++) extendValues.set(j, (extendValues.get(j) + 11));
				
				//Combines both of the ArrayLists into one to be used again or returned
				allValues.addAll(extendValues);
			}
		}
		//returning the sorted list
		Collections.sort(allValues);
		return allValues;
	}

	
	/**
	 * This method returns the maximum numerical value of the player’s hand of cards.
	 * @return
	 */
	public int getBestNumericalHandValue() {
		//List of the possible values
		ArrayList<Integer> values = getNumericalHandValue();
		int optimalNum = 0;
		
		//Checks to see if any of the value is bigger than the last but still allowed (21 or under) starting with 0 (nobody will have 0 card and therefore 0 value)
		for(int value: values) {
			boolean optimal = value > optimalNum && value < 22;
			if(optimal) optimalNum = value;
		}
		//This is if there is not option in the hand that is 21 or below, just returns the smallest value of the illegal values.
		if(optimalNum == 0) return values.get(0);
		
		//Returns the best value given if at least one option  is less than 21
		else return optimalNum;
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
