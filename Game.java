//************************************
// Game Class -- gnt2106
//************************************

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Game {
	
	private Player p;
	public Deck cards;
    private boolean playing;
	// you'll probably need some more here
	
	
	public Game(String[] testHand){
        p = new Player();
        cards = new Deck();
        cards.shuffle();
        for (String input: testHand){
            int suitNum = 0;
            int rankNum = 0;
            char suitChar = input.charAt(0);
			switch (suitChar){
				case 'c': suitNum = 1;
					break;
				case 'd': suitNum = 2;
					break;
				case 'h': suitNum = 3;
					break;
				case 's': suitNum = 4;
					break;
            }
            rankNum = Integer.parseInt(input.substring(1));
            p.addCard(new Card(suitNum, rankNum));
        }
        playing = true;
        System.out.println("PLAYING CONST: "+playing);
	}
	
	public Game(){
        p = new Player();
        cards = new Deck();
        cards.shuffle();
        playing = true;
        //deal cards
        for(int i = 0; i<5; i++)
            p.addCard(cards.deal());
		// This no-argument constructor is to actually play a normal game
		
	}
	
	public void play(){
		Scanner input = new Scanner(System.in);
        
        //Welcome screen and initialize player 
        System.out.println("Welcome to video Poker!!!");
        System.out.println("You are starting with a balance of: " +
                           Double.toString(p.getBankroll()));
        //System.out.println("PLAYING: "+playing);
        while (playing){
            if (cards.top < 5)
                cards.shuffle();
            System.out.println("How much would you like to bet? (1-5)");
            int amt = input.nextInt();
            input.nextLine();
            p.bets(amt);
            System.out.println("Let me deal you your cards.");

            //print cards for user
            System.out.println("Your cards in order from 0-4 are:");
            Collections.sort(p.getHand());
            p.printHand();

            //rejecting cards
            System.out.println("Would you like to reject a card? Y/N");
            String reject = input.nextLine();
            if (reject.equals("Y")){
                System.out.println("Type the indices of the cards to remove.");
                String rejCard = input.nextLine();
                for(int i = 0; i < rejCard.length(); i++){
                    int a = Integer.parseInt(String.valueOf(rejCard.charAt(i)));
                    p.removeCard(a, cards.deal());
                }
            } 
            //Show final cards
            System.out.println("Your final cards are:");
            Collections.sort(p.getHand()); 
            //put hand in increasing order by rank
            p.printHand();
            System.out.println("You won: " + this.checkHand(p.getHand()));
            System.out.println("Bankroll: " + Double.toString(p.getBankroll()));
            System.out.println("Would you like to play again: (Y/N)");
            String wantsToPlay = input.nextLine();
            if(wantsToPlay.equals("N"))
                playing = false;
            p.clearHand();
            for(int i = 0; i<5; i++)
                p.addCard(cards.deal());
        }  
	}
	
	public String checkHand(ArrayList<Card> hand){
        // this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
        if(this.pairs(hand) == 1){
            p.winnings(1);
            return ("One Pair");
        }
        else if(this.pairs(hand) == 2){
            p.winnings(2);
            return ("Two Pair");
        }
        else if(this.threeKind(hand)){
            if(this.pairs(hand) == 4){
                p.winnings(6);
                return("Full House");
            }
            else if(this.fourKind(hand)){
                p.winnings(25);
                return("Four of a kind");
            }
            p.winnings(3);
            return ("Three of a kind");
        }
        else if(this.straight(hand)){
            if(this.flush(hand)){
                if(this.royalFlush(hand)){
                    p.winnings(250);
                    return("Royal Flush");
                }
                p.winnings(50);
                return("Straight Flush");
            }
            p.winnings(4);    
            return("Straight");
        }
        else if(this.flush(hand)){
            p.winnings(5);
            return("Flush");
        }
        p.winnings(0);
        return ("No pair");   
	}

    //Check for one pair and two pairs
	public int pairs(ArrayList<Card> hand){
        int x = 0;
        int var1;
        int var2;
        for (int i = 0; i<5; i++) {
            for (int k = i + 1; k < 5; k++) {
                var1 = hand.get(i).getRank();
                var2 = hand.get(k).getRank();
                if(var1 == var2){
                    x += 1;
                }
            }
        }
        return x;
    }

    //Check for three of a kind
    public boolean threeKind(ArrayList<Card> hand){
        int x = 0;
        int var1;
        int var2;
        int var3;
        for (int i = 0; i<5; i++) {
            for (int k = i + 1; k < 5; k++) {
                for (int j = k + 1; j < 5; j++) {
                    var1 = hand.get(i).getRank();
                    var2 = hand.get(k).getRank();
                    var3 = hand.get(j).getRank();
                    if (var1 == var2 && var1 == var3){
                        return true;}
                }
            }
        }
        return false;
    }

    //Check for a Straight
    public boolean straight(ArrayList<Card> hand){
        int x = 0;
        int var1;
        int var2;
        for(int i = 0; i<4; i++){
            var1 = hand.get(i).getRank();
            var2 = hand.get(i+1).getRank();
            if(var1 == var2 - 1)
                x += 1;
        }
        var1 = hand.get(0).getRank();
        var2 = hand.get(4).getRank();
        if(var1 * var2 == 13)
            x += 1;
        if(x == 4)
            return true;
        else
            return false;
    }
    
    //Check for flush
    public boolean flush(ArrayList<Card> hand){
        int x = 0;
        int var1;
        int var2;
        for(int i = 0; i<4; i++){
            var1 = hand.get(i).getSuit();
            var2 = hand.get(i+1).getSuit();
            if(var1 == var2)
                x += 1;
        }
        if (x == 4)
            return true;
        return false;
    }

    public boolean fourKind(ArrayList<Card> hand){
        int x = 0;
            int var1;
            int var2;
            int var3;
            int var4;
            for (int i = 0; i<5; i++) {
                for (int k = i + 1; k < 5; k++) {
                    for (int j = k + 1; j < 5; j++) {
                        for (int l = j + 1; l < 5; l++) {
                            var1 = hand.get(i).getRank();
                            var2 = hand.get(k).getRank();
                            var3 = hand.get(j).getRank();
                            var4 = hand.get(l).getRank();
                            if (var1 == var2 && var1 == var3 && var1 == var4)
                                return true;
                        }
                    }
                }
            }
        return false;
    }

    public boolean royalFlush(ArrayList<Card> hand){
        int ace = hand.get(0).getRank();
        int ten = hand.get(1).getRank();
        int jack = hand.get(2).getRank();
        int queen = hand.get(3).getRank();
        int king = hand.get(4).getRank();
        if(ace == 1 && ten == 10 && jack == 11 && queen == 12 && king == 13)
            return true;
        return false;
    } 
}
