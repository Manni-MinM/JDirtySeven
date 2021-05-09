// BWOTSHEWCHB

import java.util.ArrayList ;
import java.util.Collections ;

/**
 * Class to Hold information about Bots
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Bot extends Player {
	// Constructor
	/**
	 * Creates Bot Object
	 *
	 * @param username Username of the Bot
	 */
	public Bot(String username) {
		super(username) ;
	}
	// Methods
	/**
	 * Chooses a Card and plays it
	 * Finds all avaliable Cards for play and adds it to a list then chooses one from it at random
	 *
	 * @param topCard Top card which is in play now 
	 * @return If a card can be played returns the card otherwise returns null
	 */
	public Card playCard(Card topCard) {
		// Find avaliable cards
		ArrayList<Card> avaliable = new ArrayList<Card>() ;
		for ( Card card : getDeck().getCards() )
			if ( (topCard != null && topCard.isValid(card)) || topCard == null )
				avaliable.add(card) ;
		if ( avaliable.size() == 0 )
			return null ;
		// Get info
		Collections.shuffle(avaliable) ;
		Card targetCard = avaliable.get(0) ;
		deck.removeCard(targetCard) ;
		return targetCard ;
	}
	/**
	 * Chooses a color at random after using the wildcard
	 *
	 * @return The color chosen at random
	 */
	public String getWildCardColor() {
		ArrayList<String> colors = new ArrayList<String>() ;
		colors.add("RED") ;
		colors.add("GREEN") ;
		colors.add("BLUE") ;
		colors.add("BLACK") ;
		Collections.shuffle(colors) ;
		return colors.get(0) ;
	}
}
