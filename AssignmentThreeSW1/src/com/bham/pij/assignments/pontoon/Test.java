package com.bham.pij.assignments.pontoon;

import java.util.ArrayList;

public class Test {
	
	public void CardTest() {
		Card testCard = new Card(Card.Suit.SPADES, Card.Value.ACE);
	}
	
	public static void PlayerTest() {
		Player player1 = new Player("Dominic");
		Player player2 = new Player("Ian");
		Player player3 = new Player("Brian");

		/*
		 * FOUR
		 * THREE
		 * JACK
		 * ACE
		 * QUEEN
			
		 */
		Card aceSpades = new Card(Card.Suit.SPADES, Card.Value.ACE);
		Card aceHearts = new Card(Card.Suit.HEARTS, Card.Value.ACE);
		Card threeClubs = new Card(Card.Suit.CLUBS, Card.Value.THREE);
		Card aceClubs = new Card(Card.Suit.CLUBS, Card.Value.ACE);
		Card tenDiamonds = new Card(Card.Suit.DIAMONDS, Card.Value.TEN);
		Card jackDiamonds = new Card(Card.Suit.DIAMONDS, Card.Value.JACK);
		Card queenHearts = new Card(Card.Suit.HEARTS, Card.Value.QUEEN);
		Card fiveClubs = new Card(Card.Suit.CLUBS, Card.Value.FIVE);
		Card fourClubs = new Card(Card.Suit.CLUBS, Card.Value.FOUR);

		//Player 2
		
		player2.dealToPlayer(tenDiamonds);
		player2.dealToPlayer(aceClubs);
		
		int p2HandVal = 21;
		int p2ActHandVal = player2.getBestNumericalHandValue();
		boolean p2Pass = p2ActHandVal == p2HandVal;
		
		System.out.println("Player 2 methods pass: " + p2Pass);
		System.out.println("Hand Size = 2: " + (player2.getHandSize() == 2));
		
		//Player 1
		
		player1.dealToPlayer(fiveClubs);
		player1.dealToPlayer(aceHearts);
		player1.dealToPlayer(queenHearts);
		player1.dealToPlayer(threeClubs);

		int p1HandVal = 19;
		int p1ActHandVal = player1.getBestNumericalHandValue();
		boolean p1Pass = p1ActHandVal == p1HandVal;
		
		System.out.println("Player 1 methods pass: " + p1Pass);
		System.out.println("Hand Size = 4: " + (player1.getHandSize() == 4));

		//Player 3
		player3.dealToPlayer(fourClubs);
		player3.dealToPlayer(threeClubs);
		player3.dealToPlayer(jackDiamonds);
		player3.dealToPlayer(aceSpades);
		player3.dealToPlayer(queenHearts);
		
		int p3HandVal = 28;
		player3.getNumericalHandValue().forEach((n) -> System.out.println(n));
		int p3ActHandVal = player3.getBestNumericalHandValue();
		boolean p3Pass = p3ActHandVal == p3HandVal;
		System.out.println("Player 3 handValue: " + p3ActHandVal);
		System.out.println("Player 3 methods pass: " + p3Pass);
		System.out.println("Hand Size = 5: " + (player3.getHandSize() == 5));
	}
	public static void DeckTest() {
		Deck testDeck = new Deck();
		ArrayList<Card> deck = testDeck.getDeck();
		Player player3 = new Player("Emma");
		
		
		System.out.println("\nDeck size = 52: " + (deck.size() == 52));
		Card random1 = testDeck.dealRandomCard();
		Card random2 = testDeck.dealRandomCard();
		System.out.println("Cards Dealt: \n" + random1.getSuit() + ", " + random1.getValue() + "\n" + random2.getSuit() + ", " + random2.getValue());
		player3.dealToPlayer(random1);
		player3.dealToPlayer(random2);
		boolean card1removed = !deck.contains(random1);
		boolean card2removed = !deck.contains(random2);
		
		
		
		System.out.println("Card 1 has been removed: " + card1removed);
		System.out.println("Card 2 has been removed: " + card2removed);
		
		System.out.println("\nDeck size is now = 50: " + (deck.size() == 50));
		
		
		/*
		for(Card card: deck) {
			System.out.println(card.getSuit() + ", " + card.getValue());
			}
		*/
		
	}
	public static void pontoonTest() {
		Pontoon pontoon = new Pontoon(4);
		
		System.out.println("\nPontoon:\nPontoon deck contains 52 cards: " + (pontoon.deck.size() == 52));
		pontoon.dealInitalCards();
		int numPlayers = pontoon.players.size();
		int cardsDealt = pontoon.players.size() * 2;
		System.out.println(cardsDealt + " Cards dealt for " + numPlayers + " Players");
		System.out.println("Pontoon deck contains 48 cards: " + (pontoon.deck.size() == (52 - cardsDealt)));
		
		System.out.println("\nTwist P1:");
		System.out.println("Twist 1:");
		System.out.println("Pontoon deck contains " + (52 - cardsDealt) + " cards: " + (pontoon.deck.size() == (52 - cardsDealt)));
		pontoon.getPlayer(1).dealToPlayer(pontoon.deck.dealRandomCard());
		System.out.println("Pontoon deck contains " + (52 - (cardsDealt + 1)) + " cards: " + (pontoon.deck.size() == (52 - (cardsDealt + 1))));
		pontoon.getPlayer(1).dealToPlayer(pontoon.deck.dealRandomCard());
		System.out.println("Pontoon deck contains " + (52 - (cardsDealt + 2)) + " cards: " + (pontoon.deck.size() == (52 - (cardsDealt + 2))));
		
		//Test the hand evaluation
		System.out.println("\nPlayer 2:\n");
		Player player2 = pontoon.getPlayer(2);
		player2.dealToPlayer(pontoon.deck.dealRandomCard());
		int player2HandVal = pontoon.handValue(player2);
		player2.getCards().forEach((n) -> System.out.println(n.getValue()));
		System.out.println(player2HandVal);
		System.out.println("Pontoon deck contains " + (52 - (cardsDealt + 3)) + " cards: " + (pontoon.deck.size() == (52 - (cardsDealt + 3))));

		
		System.out.println("\nPlayer 3:\n");
		Player player3 = pontoon.getPlayer(3);
		int player3HandVal = pontoon.handValue(player3);
		player3.getCards().forEach((n) -> System.out.println(n.getValue()));
		System.out.println(player3HandVal);
		System.out.println("Pontoon deck contains " + (52 - (cardsDealt + 3)) + " cards: " + (pontoon.deck.size() == (52 - (cardsDealt + 3))));
		
		System.out.println("\nPlayer 4:\n");
		Player player4 = pontoon.getPlayer(4);
		player4.dealToPlayer(pontoon.deck.dealRandomCard());
		player4.dealToPlayer(pontoon.deck.dealRandomCard());
		player4.dealToPlayer(pontoon.deck.dealRandomCard());
		int player4HandVal = pontoon.handValue(player4);
		player4.getCards().forEach((n) -> System.out.println(n.getValue()));
		System.out.println("pontoon.handValue(player4): " + player4HandVal);
		System.out.println("player4.getNumericalHandValue(): " + player4.getNumericalHandValue());
		System.out.println("player4.getBestNumericalHandValue(): " + player4.getBestNumericalHandValue());
		System.out.println("Pontoon deck contains " + (52 - (cardsDealt + 6)) + " cards: " + (pontoon.deck.size() == (52 - (cardsDealt + 6))));
		
		System.out.println("\nplayer2 vs player3: " + pontoon.compareHands(player2, player3));
		System.out.println("\nplayer3 vs player4: " + pontoon.compareHands(player3, player4));
	}
	
	public static void main(String[] args) {
		PlayerTest();
		DeckTest();
		pontoonTest();
	}

}

/*
Your class does not compute the numerical value of hands with multiple cards correctly. This method checks ACEs.
Your 'twist' (dealing an extra card to a player) functionality does not work correctly. This test checks what happens when an extra card is dealt to a player.
Your constructor does not initialise the game correctly. You must make sure that you pass the number of players to the Pontoon constructor.
Your compare hands functionality does not work correctly. Make sure that you have read the rules in the specification about the ranking of hands.

FOUR
THREE
JACK
ACE
QUEEN
*/
