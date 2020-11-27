package com.bham.pij.assignments.pontoon;

//Dominic Carroll 1678959


import java.util.ArrayList;

public abstract class CardGame {
	
	ArrayList<Player> players = new ArrayList<Player>();
	Deck deck; 

	public CardGame(int nPlayers) {
		for(int i = 1; i <= nPlayers; i++) {
			String playerName = "Player_" + Integer.toString(i);
			Player player = new Player(playerName);
			this.players.add(player);
		}
		this.deck = new Deck();
	}
	
	public Deck getDeck() {
			return deck;
		}
	
	public Player getPlayer(int playerNumber) {
		return players.get(playerNumber - 1);
	}
	
	public int numberOfPlayers() {
		return players.size();
	}
	
	public abstract void dealInitalCards();
	
	public abstract int compareHands(Player hand1, Player hand2);
	
}



//public CardGame (int nplayers)
//public abstract void dealInitialCards()
//public abstract int compareHands(Player hand1, Player hand2)
//public Deck getDeck() returns the deck.
//public Player getPlayer(int i)
//public int getNumPlayers() gets the number of players in the game.