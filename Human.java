// BWOTSHEWCHB

import java.util.Scanner ;
import java.util.ArrayList ;

/**
 * A Class to hold information about the Human Players
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Human extends Player {
	// Fields
	Scanner input ;
	// Constructor
	/**
	 * Creates Human Object
	 *
	 * @param username Username of the Human
	 */
	public Human(String username) {
		super(username) ;
		input = new Scanner(System.in) ;
	}
	// Methods
	/**
	 * Creates the Card according with its correct type according to its rank and color
	 *
	 * @param rank Rank of the Card
	 * @param color Color of the Card
	 * @return The Card Object of the Card created in the method
	 */
	public Card createCard(String rank , String color) {
		Card targetCard = null ;
		if ( rank.equals("3") || rank.equals("4") || rank.equals("5") ||
			rank.equals("6") || rank.equals("9") || rank.equals("C") || rank.equals("D") )
				targetCard = new NormalCard(rank , color) ;
		else if ( rank.equals("2") )
			targetCard = new ForceCard(rank , color) ;
		else if ( rank.equals("7") && color.equals("BLACK") )
			targetCard = new DrawFourCard(rank , color) ;
		else if ( rank.equals("7") && !color.equals("BLACK") )
			targetCard = new DrawTwoCard(rank , color) ;
		else if ( rank.equals("8") )
			targetCard = new PrizeCard(rank , color) ;
		else if ( rank.equals("10") )
			targetCard = new ReverseCard(rank , color) ;
		else if ( rank.equals("A") )
			targetCard = new SkipCard(rank , color) ;
		else if ( rank.equals("B") )
			targetCard = new WildCard(rank , color) ;
		return targetCard ;
	}
	/**
	 * Prompts the Player for to choose a Card and plays it
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
		System.out.print("\u001B[36m" + "Avaliable : " + "\u001B[0m") ;
		for ( Card card : avaliable )
			System.out.print(card.toString() + " ") ;
		System.out.printf("\n\n") ;
		if ( avaliable.size() == 0 )
			return null ;
		// Get info
		Card targetCard = null ;
		while ( true ) {
			System.out.print("\u001B[36m" + "Selected Card : " + "\u001B[0m") ;
			String line = input.nextLine() ;
			String[] lineSplit = line.split("-") ;
			targetCard = createCard(lineSplit[0] , lineSplit[1]) ;
			if ( avaliable.contains(targetCard) )
				break ;
		}
		System.out.println() ;
		deck.removeCard(targetCard) ;
		return targetCard ;
	}
	/**
	 * Chooses a color at random after using the wildcard
	 *
	 * @return The color chosen at random
	 */
	public String getWildCardColor() {
		String targetColor = null ;
		while ( true ) {
			System.out.print("\u001B[36m" + "Selected Color{RED , GREEN , BLUE , BLACK} : " + "\u001B[0m") ;
			targetColor = input.nextLine() ;
			if ( targetColor.equals("RED") || targetColor.equals("GREEN") ||
				targetColor.equals("BLUE") || targetColor.equals("BLACK"))
					break ;
		}
		System.out.println() ;
		return targetColor ;
	}
}

