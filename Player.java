// BWOTSHEWCHB

import java.util.Comparator ;

/**
 * An abstract Class to hold information about Players
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public abstract class Player {
	// Fields
	protected int point ;
	protected Deck deck ;
	protected String username ;
	// Constructor
	/**
	 * Creates Player Object
	 *
	 * @param username Username of the Player
	 */
	public Player(String username) {
		this.point = 0 ;
		this.deck = new Deck() ;
		this.username = username ;
	}
	// Classes
	/**
	 * Comparator Class used in sorting the Players according to their points (Ascending)
	 */
	static class Compare implements Comparator<Player> {
		// Methods
		/**
		 * Compares two Player Objects
		 *
		 * @param playerOne The first Player
		 * @param playerTwo The second Player
		 */	
		public int compare(Player playerOne , Player playerTwo) {
			return playerOne.getPoint() - playerTwo.getPoint() ;
		}
	}
	// Methods
	/**
	 * Returns the point of the Player
	 *
	 * @return The point of the Player
	 */
	public int getPoint() {
		return point ;
	}
	/**
	 * Returns the Deck of the Player
	 *
	 * @return The Deck of the Player
	 */
	public Deck getDeck() {
		return deck ;
	}
	/**
	 * Returns the username of the Player
	 *
	 * @return The username of the Player
	 */
	public String getUsername() {
		return username ;
	}
	/**
	 * Calculates the point of the Player
	 */
	public void calculatePoint() {
		for ( Card card : getDeck().getCards() )
			point += card.getPoint() ;
	}
	/**
	 * Shows the Deck of the Player
	 */
	public void show() {
		deck.show() ;
		System.out.println() ;
	}
	public abstract Card playCard(Card topCard) ;
	public abstract String getWildCardColor() ;
}

