// BWOTSHEWCHB

import java.util.ArrayList ;
import java.util.Collections ;

/**
 * A Class to hold information about the Pile
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Pile {
	// Fields
	ArrayList<Card> pile ;
	// Constructor
	/**
	 * Creates Pile Object and fills it with the stack of Cards
	 */
	public Pile() {
		pile = new ArrayList<Card>() ;
		// Normal Cards
		String[] normalCards = {"3" , "4" , "5" , "6" , "9" , "C" , "D"} ; 
		for ( String rank : normalCards ) {
			pile.add(new NormalCard(rank , "RED")) ;
			pile.add(new NormalCard(rank , "GREEN")) ;
			pile.add(new NormalCard(rank , "BLUE")) ;
			pile.add(new NormalCard(rank , "BLACK")) ;
		}
		// Force Cards
		pile.add(new ForceCard("2" , "RED")) ;
		pile.add(new ForceCard("2" , "GREEN")) ;
		pile.add(new ForceCard("2" , "BLUE")) ;
		pile.add(new ForceCard("2" , "BLACK")) ;
		// Draw Four Card
		pile.add(new DrawFourCard("7" , "BLACK")) ;
		// Draw Two Cards
		pile.add(new DrawTwoCard("7" , "RED")) ;
		pile.add(new DrawTwoCard("7" , "GREEN")) ;
		pile.add(new DrawTwoCard("7" , "BLUE")) ;
		// Prize Card
		pile.add(new PrizeCard("8" , "RED")) ;
		pile.add(new PrizeCard("8" , "GREEN")) ;
		pile.add(new PrizeCard("8" , "BLUE")) ;
		pile.add(new PrizeCard("8" , "BLACK")) ;
		// Reverse Card
		pile.add(new ReverseCard("10" , "RED")) ;
		pile.add(new ReverseCard("10" , "GREEN")) ;
		pile.add(new ReverseCard("10" , "BLUE")) ;
		pile.add(new ReverseCard("10" , "BLACK")) ;
		// Skip Card
		pile.add(new SkipCard("A" , "RED")) ;
		pile.add(new SkipCard("A" , "GREEN")) ;
		pile.add(new SkipCard("A" , "BLUE")) ;
		pile.add(new SkipCard("A" , "BLACK")) ;
		// Wild Card
		pile.add(new WildCard("B" , "RED")) ;
		pile.add(new WildCard("B" , "GREEN")) ;
		pile.add(new WildCard("B" , "BLUE")) ;
		pile.add(new WildCard("B" , "BLACK")) ;
		// Shuffle the Pile
		Collections.shuffle(pile) ;
	}
	// Methods
	/**
	 * Returns the size of the Pile
	 *
	 * @return The size of the Pile
	 */
	public int size() {
		return pile.size() ;
	}
	/**
	 * Adds a Card to the Pile
	 *
	 * @param card The Card to be added to the Pile
	 */
	public void addCard(Card card) {
		if ( card.getRank().equals("NULL") )
			return ;
		pile.add(card) ;
	}
	/**
	 * Removes the top Card from the Pile and returns it
	 *
	 * @return The top Card of the Pile
	 */
	public Card drawTopCard() {
		Card returnValue = pile.get(0) ;
		pile.remove(0) ;
		return returnValue ;
	}
}

