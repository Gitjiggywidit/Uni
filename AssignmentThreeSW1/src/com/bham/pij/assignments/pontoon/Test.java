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
		Card aceDiamonds = new Card(Card.Suit.DIAMONDS, Card.Value.ACE);
		Card tenDiamonds = new Card(Card.Suit.DIAMONDS, Card.Value.TEN);
		Card jackDiamonds = new Card(Card.Suit.DIAMONDS, Card.Value.JACK);
		Card queenHearts = new Card(Card.Suit.HEARTS, Card.Value.QUEEN);
		Card fiveClubs = new Card(Card.Suit.CLUBS, Card.Value.FIVE);
		Card fourClubs = new Card(Card.Suit.CLUBS, Card.Value.FOUR);

		//Player 2
		
		player2.dealToPlayer(tenDiamonds);
		player2.dealToPlayer(aceClubs);
		
		int p2HandVal = 21;
		ArrayList<Integer> p2PossVals = player2.getNumericalHandValue();
		p2PossVals.forEach((n) -> System.out.print(n + ", "));
		int p2ActHandVal = player2.getBestNumericalHandValue();
		boolean p2Pass = p2ActHandVal == p2HandVal;
		
		System.out.println("Player 2 methods pass: " + p2Pass);
		System.out.println("Hand Size = 2: " + (player2.getHandSize() == 2));
		
		//Player 1
		
		player1.dealToPlayer(aceSpades);
		player1.dealToPlayer(aceHearts);
		player1.dealToPlayer(aceClubs);
		player1.dealToPlayer(aceDiamonds);
		player1.dealToPlayer(threeClubs);

		int p1HandVal = 17;
		ArrayList<Integer> p1PossVals = player1.getNumericalHandValue();
		p1PossVals.forEach((n) -> System.out.print(n + ", "));
		int p1ActHandVal = player1.getBestNumericalHandValue();
		boolean p1Pass = p1ActHandVal == p1HandVal;
		
		System.out.println("Player 1 methods pass: " + p1Pass);
		System.out.println("Hand Size = 5: " + (player1.getHandSize() == 5));

		//Player 3
		player3.dealToPlayer(fourClubs);
		player3.dealToPlayer(threeClubs);
		player3.dealToPlayer(jackDiamonds);
		player3.dealToPlayer(aceSpades);
		player3.dealToPlayer(queenHearts);
		
		int p3HandVal = 28;
		ArrayList<Integer> p3PossVals = player3.getNumericalHandValue();
		p3PossVals.forEach((n) -> System.out.print(n + ", "));
		int p3ActHandVal = player3.getBestNumericalHandValue();
		boolean p3Pass = p3ActHandVal == p3HandVal;
		System.out.println("Player 3 handValue: " + p3ActHandVal);
		System.out.println("Player 3 methods pass: " + p3Pass);
		System.out.println("Hand Size = 5: " + (player3.getHandSize() == 5));
	}

	public static void pontoonTest() {
		Pontoon pontoon = new Pontoon(4);
		System.out.println("players:");
		pontoon.players.forEach((n) -> System.out.println(n.getName()));
		
		int numPlayers = pontoon.getNumPlayers();
		int cardsDealt = 0;
		for(Player player: pontoon.players) cardsDealt += player.getHandSize();
		
		System.out.println("\nCards Dealt: " + cardsDealt);
		System.out.println("Deck size: " + pontoon.deck.size());
		System.out.println(cardsDealt + " Cards dealt for " + numPlayers + " Players");
		System.out.println("Pontoon deck contains " + (52 - cardsDealt) +  " cards: " + (pontoon.deck.size() == (52 - cardsDealt)));
		
		System.out.println("\nPlayer P1:");
		Player player1 = pontoon.getPlayer(1);
		player1.dealToPlayer(pontoon.deck.dealRandomCard());
		System.out.println("Pontoon deck contains " + (52 - (cardsDealt + 1)) + " cards: " + (pontoon.deck.size() == (52 - (cardsDealt + 1))));
		int player1HandVal = pontoon.handValue(player1);
		player1.getCards().forEach((n) -> System.out.println(n.getValue() + ", " + n.getSuit()));
		
		//Hand Values
		System.out.print("Possible Values: ");
		player1.getNumericalHandValue().forEach((n) -> System.out.print(" " + n + ", "));
		System.out.println("\nhandValue: " + player1HandVal);
		System.out.println("BestNumericalHandValue: " + player1.getBestNumericalHandValue());

		
		//Test the hand evaluation
		System.out.println("\nPlayer 2:\n");
		Player player2 = pontoon.getPlayer(2);
		player2.dealToPlayer(pontoon.deck.dealRandomCard());
		int player2HandVal = pontoon.handValue(player2);
		player2.getCards().forEach((n) -> System.out.println(n.getValue()+ ", " + n.getSuit()));
		
		//Hand Values
		System.out.print("Possible Values: ");
		player2.getNumericalHandValue().forEach((n) -> System.out.print(" " + n + ", "));
		System.out.println("\nhandValue: " + player2HandVal);
		System.out.println("BestNumericalHandValue: " + player2.getBestNumericalHandValue());
		System.out.println("Pontoon deck contains " + (52 - (cardsDealt + 2)) + " cards: " + (pontoon.deck.size() == (52 - (cardsDealt + 2))));

		
		System.out.println("\nPlayer 3:\n");
		Player player3 = pontoon.getPlayer(3);
		int player3HandVal = pontoon.handValue(player3);
		player3.getCards().forEach((n) -> System.out.println(n.getValue()+ ", " + n.getSuit()));
		System.out.print("Possible Values: ");
		player3.getNumericalHandValue().forEach((n) -> System.out.print(" " + n + ", "));
		System.out.println("\nhandValue: " + player3HandVal);
		System.out.println("BestNumericalHandValue: " + player3.getBestNumericalHandValue());
		System.out.println("Pontoon deck contains " + (52 - (cardsDealt + 2)) + " cards: " + (pontoon.deck.size() == (52 - (cardsDealt + 2))));
		
		System.out.println("\nPlayer 4:\n");
		Player player4 = pontoon.getPlayer(4);
		player4.dealToPlayer(pontoon.deck.dealRandomCard());
		player4.dealToPlayer(pontoon.deck.dealRandomCard());
		int player4HandVal = pontoon.handValue(player4);
		player4.getCards().forEach((n) -> System.out.println(n.getValue()+ ", " + n.getSuit()));
		
		System.out.print("Possible Values: ");
		player4.getNumericalHandValue().forEach((n) -> System.out.print(" " + n + ", "));
		System.out.println("\nhandValue: " + player4HandVal);
		System.out.println("BestNumericalHandValue: " + player4.getBestNumericalHandValue());
		System.out.println("Pontoon deck contains " + (52 - (cardsDealt + 4)) + " cards: " + (pontoon.deck.size() == (52 - (cardsDealt + 4))));
		
		
		System.out.println("\nplayer2 vs player3: " + pontoon.compareHands(player2, player3));
		System.out.println("\nplayer3 vs player4: " + pontoon.compareHands(player3, player4));
	}
	
	static void pontwoon() {
		Pontoon pontwoon = new Pontoon(2);
//		for(Player player: pontwoon.players) player.getCards().forEach((n) -> System.out.println(player.getName() + " " + player.getBestNumericalHandValue() + " " + n.getValue()));
//		System.out.println("\n");
//		for(Player player: pontwoon.players) {
//			if(player.getBestNumericalHandValue() < 21) {
//				player.dealToPlayer(pontwoon.deck.dealRandomCard());
//				System.out.println("\n");
//				player.getCards().forEach((n) -> System.out.println(player.getName() + " " + player.getBestNumericalHandValue() + " " + n.getValue()));
//			}
//		}
		Player p1 = pontwoon.getPlayer(0);
		Player p2 = pontwoon.getPlayer(1);
		
		p1.getCards().clear();
		p2.getCards().clear();
		
		p2.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.ACE));
		p2.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.TEN));
		
		System.out.println(pontwoon.handValue(p2));
		
		p1.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
		p1.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.TEN));
		p1.dealToPlayer(new Card(Card.Suit.CLUBS, Card.Value.THREE));
		
		System.out.println(pontwoon.handValue(p1));
		
		System.out.println((pontwoon.compareHands(p1, p2)) == 1);
	}
	public static void main(String[] args) {
//		PlayerTest();
//		pontoonTest();
//		System.out.println("\n");
		pontwoon();
	}

}

/*
Your class does not compute the numerical value of hands with multiple cards correctly. This method checks ACEs.

Your 'twist' (dealing an extra card to a player) functionality does not work correctly. This test checks what happens when an extra card is dealt to a player.

Your constructor does not initialise the game correctly. You must make sure that you pass the number of players to the Pontoon constructor. 
Your constructor must also create the player objects.

Your compare hands functionality does not work correctly. Make sure that you have read the rules in the specification about the ranking of hands.

*/
