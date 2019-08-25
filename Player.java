//************************************
// Player Class -- gnt2106
//************************************

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
	private ArrayList<Card> hand; // the player's cards
	private double bankroll;
    private double bet;

	// you may choose to use more instance variables
		
	public Player(){
        bankroll = 100;
        bet = 0;
        hand = new ArrayList<Card>();
	    // create a player here
	}

	public void addCard(Card c){
        hand.add(c);
	    // add the card c to the player's hand
	}

	public void removeCard(int i, Card c){
        hand.set(i, c);
	    // remove the card c from the player's hand
    }
		
    public void bets(double amt){
        bet = amt;
        // player makes a bet
    }

    public void winnings(double odds){
        bankroll = bankroll + this.bet * odds - this.bet;
    }

    public double getBankroll(){
        return bankroll;
        // return current balance of bankroll
    }

// you may wish to use more methods here
    
    public void clearHand(){
        hand.clear();
    }
    
    public void printHand(){
        for(int i = 0; i<5; i++)
            System.out.println(hand.get(i));
    }
    
    public  ArrayList<Card> getHand(){
        return hand;
    }
/*
    public void orderHand(){
        int var1;
        int var2;
        Card temp;
        for(int k = 0; k<5; k++){
            for(int i = 0; i<4; i++){
                var1 = Integer.parseInt(this.hand.get(i).toString().substring(1));
                var2 = Integer.parseInt(this.hand.get(i+1).toString().substring(1));
                if(var1 > var2){
                    temp = hand.get(i);
                    this.hand.set(i, hand.get(i+1));
                    this.hand.set(i+1, temp);
                }
            }     
        }  
    }
*/
}


