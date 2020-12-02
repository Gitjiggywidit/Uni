package com.bham.pij.assignments.pontoon;

//Dominic Carroll 1678959


import java.util.ArrayList;

public abstract class CardGame {
	
	ArrayList<Player> players = new ArrayList<Player>();
	Deck deck; 

	public CardGame(int nplayers) {
		for(int i = 1; i <= nplayers; i++) {
			String playerName = "Player_" + Integer.toString(i);
			Player player = new Player(playerName);
			this.players.add(player);
		}
		this.deck = new Deck();
	}
	
	public Deck getDeck() {
			return this.deck;
		}
	
	public Player getPlayer(int playerNumber) {
		return players.get(playerNumber - 1);
	}
	
	public int getNumPlayers() {
		return players.size();
	}
	
	public abstract void dealInitalCards();
	
	public abstract int compareHands(Player hand1, Player hand2);
	
}
