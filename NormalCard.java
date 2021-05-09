// BWOTSHEWCHB

/**
 * A Class to hold information about NormalCards
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class NormalCard extends Card {
	// Normal Cards : {3 , 4 , 5 , 6 , 9}

	// Constructor
	/**
	 * Creates NormalCard Object
	 *
	 * @param rank Rank of the Card
	 * @param color Color of the Card
	 */
	public NormalCard(String rank , String color) {
		this.rank = rank ;
		this.color = color ;
		if ( rank.equals("NULL") )
			this.point = 0 ;
		else if ( rank.equals("C") )
			this.point = 12 ;
		else if ( rank.equals("D") )
			this.point = 13 ;
		else
			this.point = Integer.parseInt(rank) ;
	}
}

