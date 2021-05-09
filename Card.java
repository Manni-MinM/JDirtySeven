// BWOTSHEWCHB

import java.util.ArrayList ;

/**
 * An abstract Class to hold information about Cards
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public abstract class Card {
	// Fields
	protected int point ;
	protected String rank ;
	protected String color ;
	// Classes
	/**
	 * A Class to hold information about ANSI escape code colors
	 */
	public class Color {
		// Fields
		public static final String ANSI_RESET = "\u001B[0m";
		public static final String ANSI_BLACK = "\u001B[30m";
		public static final String ANSI_RED = "\u001B[31m";
		public static final String ANSI_GREEN = "\u001B[32m";
		public static final String ANSI_YELLOW = "\u001B[33m";
		public static final String ANSI_BLUE = "\u001B[34m";
		public static final String ANSI_PURPLE = "\u001B[35m";
		public static final String ANSI_CYAN = "\u001B[36m";
		public static final String ANSI_WHITE = "\u001B[37m";
		// Methods
		/**
		 * Returns escape code of given color
		 *
		 * @param color Name of the color
		 */
		public String getANSI(String color) {
			if ( color.equals("RED") )
				return ANSI_RED ;
			else if ( color.equals("GREEN") )
				return ANSI_GREEN ;
			else if ( color.equals("BLUE") )
				return ANSI_BLUE ;
			else if ( color.equals("BLACK") )
				return ANSI_BLACK ;
			return ANSI_RESET ;
		}
	}
	// Methods
	/**
	 * Returns the Point of the Card
	 *
	 * @return The Point of the Card 
	 */
	public int getPoint() {
		return point ;
	}
	/**
	 * Returns the Rank of the Card
	 *
	 * @return The Rank of the Card
	 */
	public String getRank() {
		return rank ;
	}
	/**
	 * Returns the Color of the Card
	 *
	 * @return The Color of the Card
	 */
	public String getColor() {
		return color ;
	}
	/**
	 * Checks if two Object are equal
	 * 
	 * @param object the Object to be checked
	 * @return True if they are equal otherwise False
	 */
	@Override
	public boolean equals(Object object) {
		if ( !(object instanceof Card) )
			return false ;
		if ( object == this )
			return true ;
		Card card = (Card)object ;
		return (this.getRank().equals(card.getRank()) && this.getColor().equals(card.getColor())) ;
	}
	/**
	 * Converts Object of Card type to String format
	 *
	 * @return The Card in String format
	 */
	@Override
	public String toString() {
		return (this.getRank() + "-" + this.getColor()) ;
	}
	/**
	 * Checks if the next Card can be played after the current card
	 *
	 * @param nextCard the nextCard which we want to play
	 * @return True if nextCard can be played after the current Card otherwise False
	 */
	public boolean isValid(Card nextCard) {
		return (this.getRank().equals(nextCard.getRank()) || this.getColor().equals(nextCard.getColor()) || nextCard.getRank().equals("B")) ;
	}
	/**
	 * Converts the Card to a somewhat graphical format which can be displayed in the Terminal
	 *
	 * @return A list containing the lines of the sorta graphical Card
	 */
	public ArrayList<String> stringed() {
		ArrayList<String> line = new ArrayList<String>() ;
		Color paint = new Color() ;
		if ( rank.equals("NULL") ) {
			line.add(paint.getANSI(color) + "┍━━━━━━━━━┑" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;	
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "┕━━━━━━━━━┙" + paint.getANSI("RESET")) ;
		}
		else {
			line.add(paint.getANSI(color) + "┍━━━━━━━━━┑" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			if ( getRank().equals("10") )
				line.add(paint.getANSI(color) + "│ "+ getRank() + "      │" + paint.getANSI("RESET")) ;
			else
				line.add(paint.getANSI(color) + "│ "+ getRank() + "       │" + paint.getANSI("RESET")) ;	
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│         │" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "┕━━━━━━━━━┙" + paint.getANSI("RESET")) ;
		}
		return line ;
	}
	/**
	 * Converts the Card to a somewhat graphical format which can be displayed in the Terminal
	 *
	 * @return A list containing the lines of the sorta graphical half Card
	 */
	public ArrayList<String> stringedWithoutRightSide() {
		ArrayList<String> line = new ArrayList<String>() ;
		Color paint = new Color() ;
		if ( rank.equals("NULL") ) {
			line.add(paint.getANSI(color) + "┍━━━━━" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│     " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│     " + paint.getANSI("RESET")) ;	
			line.add(paint.getANSI(color) + "│     " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│     " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│     " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│     " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "┕━━━━━" + paint.getANSI("RESET")) ;
		}
		else {
			line.add(paint.getANSI(color) + "┍━━━━━" + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│     " + paint.getANSI("RESET")) ;
			if ( getRank().equals("10") )
				line.add(paint.getANSI(color) + "│ "+ getRank() + "  " + paint.getANSI("RESET")) ;
			else
				line.add(paint.getANSI(color) + "│ "+ getRank() + "   " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│     " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│     " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│     " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "│     " + paint.getANSI("RESET")) ;
			line.add(paint.getANSI(color) + "┕━━━━━" + paint.getANSI("RESET")) ;
		}
		return line ;
	}
}

