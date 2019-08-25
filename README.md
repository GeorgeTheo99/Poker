# Poker
A Simple Poker Game in Java

***Card Class***
- Pretty self explanitory
- I have a getRank and getSuit function so these can be returned to the game file when translating 
into human readable cards
- The compareTo compares rank and then if rank is the same, compares suit.


***Deck Class***
- Creates a deck in order by a for loop that repeats 52 times.
- uses %13 to get the rank and looks at what repetition the loop is on for the suit
- Then uses a for loop to shuffle the cards in the array by switching positions 
of randomly generated indexes of cards.

***Player Class***
- Is pretty straightforward.
- Main function is to store the players current hand (in an ArrayList) along with their current bet
and bankroll
- Has multiple methods to return these private instance values to the Game class.

***Game Class***
- testHand uses switch statement to translate from test inputs to a hand ArrayList with Card objects.
- class uses a boolean to continue playing rounds
- for a real game in the Game() constructor, the code is straightforward
- For the play() method: prints out introduction lines and the starting blanace (100)
- Asks the user how much to bet and deals the cards. then asks if you want to reject and then the indices 
of the cards you want to reject, inputed as an int
- the checkHand method uses if and else if statements to check.
- inside these statements there are calls to more methods within this class
- There are three core methods that check for matches in the cards, and then inside these methods 
there are calls to other checks that go further
- Ex: if there is a pair, there may also be three of a kind. These two combined have a different payout. 
- Ex. if there is three of a kind, the program will first find a pair. After the program finds this first pair
  it also checks for three of a kind. If there isn't it returns the pair
- this logic follows for the rest of the possible hands
