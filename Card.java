//************************************
// Card Class -- gnt2106
//************************************
import java.util.Random;
import java.util.Scanner;

public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
	
	public Card(int s, int r){
        suit = s;
        rank = r;
	}
	public int getRank(){
		return this.rank;
	}
	public int getSuit(){
		return this.suit;
	}
	
	public int compareTo(Card c){
		if (this.rank < c.getRank())
            return -1;
        else if (this.rank > c.getRank())
            return 1;
        //else if (this.suit == c.getSuit())
        //	return 0;
        else{ // if (this.rank == c.rank){
            if (this.suit < c.getSuit())
                return -1;
            else //(this.suit > c.suit)
                return 1;
        }
	}

	public String toString(){
        if(this.suit == 1){
            if(this.rank > 1 && this.rank < 11)
                return (Integer.toString(this.rank) + " of clubs");
            else if(this.rank == 11)
                return ("Jack of clubs");
            else if(this.rank == 12)
                return ("Queen of clubs");
            else if(this.rank == 13)
                return ("King of clubs");
            else
                return ("Ace of clubs");
        }
        else if(this.suit == 2){
            if(this.rank > 1 && this.rank < 11)
                return (Integer.toString(this.rank) + " of diamonds");
            else if(this.rank == 11)
                return ("Jack of diamonds");
            else if(this.rank == 12)
                return ("Queen of diamonds");
            else if(this.rank == 13)
                return ("King of diamonds");
            else
                return ("Ace of diamonds");
        }
        else if(this.suit == 3){
            if(this.rank > 1 && this.rank < 11)
                return (Integer.toString(this.rank) + " of hearts");
            else if(this.rank == 11)
                return ("Jack of hearts");
            else if(this.rank == 12)
                return ("Queen of hearts");
            else if(this.rank == 13)
                return ("King of hearts");
            else
                return ("Ace of hearts");
        }
        else {
            if(this.rank > 1 && this.rank < 11)
                return (Integer.toString(this.rank) + " of spades");
            else if(this.rank == 11)
                return ("Jack of spades");
            else if(this.rank == 12)
                return ("Queen of spades");
            else if(this.rank == 13)
                return ("King of spades");
            else
                return ("Ace of spades");
        }

       
        
		//return (Integer.toString(this.suit) + Integer.toString(this.rank));
	}
	// add some more methods here if needed

}
