//************************************
// Deck Class -- gnt2106
//************************************
import java.util.Random;
import java.util.Scanner;

public class Deck {
	
	private Card[] cards;
	public int top; // the index of the top of the deck
	// add more instance variables if needed
	
	public Deck(){
        cards = new Card[52];
        cards[0] = new Card(1, 1);
		for(int i = 1; i < 52; i++){
            if (i < 13)
                cards[i] = new Card(1, i%13);
            else if (i>=13 && i<26)
                cards[i] = new Card(2, i%13+1);
            else if (i>=26 && i<39)
                cards[i] = new Card(3, i%13+1);
            else if (i>=39 && i<52)
                cards[i] = new Card(4, i%13+1);
            //System.out.println(i%13+1);
        }
	}
	
	public void shuffle(){
        top = 51;
        Random rand = new Random();		
		for (int i=0; i < 52; i++) {
		    int position = rand.nextInt(52);
		    Card save = cards[i];
		    cards[i] = cards[position];
		    cards[position] = save;
		}
	}
	
	public Card deal(){
		top -= 1;
        return cards[top+1];
	}
	
	// add more methods here if needed

}
