// BWOTSHEWCHB

/**
 * A Class to hold information about DrawTwoCards
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class DrawTwoCard extends Card {
	// Draw Two Cards : {7-RED , 7-GREEN , 7-BLUE}

	// Constructor
	/**
	 * Creates DrawTwoCard Object
	 *
	 * @param rank Rank of the Card
	 * @param color Color of the Card
	 */
	public DrawTwoCard(String rank , String color) {
		this.rank = rank ;
		this.color = color ;
		this.point = 10 ;
	}
}

