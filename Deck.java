// BWOTSHEWCHB

import java.util.Iterator ;
import java.util.ArrayList ;

/**
 * A Class to hold information about the Deck
 */
public class Deck {
	// Fields 
	ArrayList<Card> deck ;
	// Constructor
	/**
	 * Creates Deck Object
	 */
	public Deck() {
		deck = new ArrayList<Card>() ;
	}
	// Methods
	/**
	 * Returns the size of the Deck
	 *
	 * @return Size of the Deck
	 */
	public int size() {
		return deck.size() ;
	}
	/**
	 * Shows the Deck in a graphical fashion in the Terminal
	 * Creates a new line consisting of the line of all Cards using concatenation then displays the lines one by one until the last line
	 */
	public void show() {
		// Make an ArrayList containing all the lines of the Cards
		ArrayList<String> lines = new ArrayList<String>() ;
		for ( int it = 0 ; it < 8 ; it ++ )
			lines.add("") ;
		// Loop over each line of each Card and concatenate them together to make one big line
		for ( int it = 0 ; it < deck.size() ; it ++ ) {	
			Card card = deck.get(it) ;
			ArrayList<String> cardLines = null ;
			if ( it == deck.size() - 1 )
				cardLines = card.stringed() ;
			else
				cardLines = card.stringedWithoutRightSide() ;
			ArrayList<String> temp = new ArrayList<String>() ;
			int index = 0 ;
			for ( String cardLine : cardLines ) {
				temp.add(lines.get(index) + cardLine) ;
				index ++ ;
			}
			lines.clear() ;
			for ( String line : temp )
				lines.add(line) ;
			temp.clear() ;
		}
		// Print the lines one by one
		for ( String line : lines )
			System.out.println(line) ;
	}
	/**
	 * Returns an ArrayList containing all the Cards in the Deck
	 *
	 * @return ArrayList containing the cards of the deck
	 */
	public ArrayList<Card> getCards() {
		return deck ;
	}
	/**
	 * Adds a Card to the Deck
	 *
	 * @param card Card to be added to the Deck
	 */
	public void addCard(Card card) {
		deck.add(card) ;
	}
	/**
	 * Removes a Card from the Deck
	 *
	 * @param card Card to be removed from the Deck
	 */
	public void removeCard(Card card) {
		deck.remove(card) ;
	}
}

