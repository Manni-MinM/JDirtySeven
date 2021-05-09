// BWOTSHEWCHB

/**
 * A Class to hold information about WildCards
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class WildCard extends Card {
	// Wild Card : {B}

	// Constructor
	/**
	 * Creates WildCard Object
	 *
	 * @param rank Rank of the Card
	 * @param color Color of the Card
	 */
	public WildCard(String rank , String color) {
		this.rank = rank ;
		this.color = color ;
		this.point = 12 ;
	}
}

