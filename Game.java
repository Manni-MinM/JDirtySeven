// BWOTSHEWCHB

import java.util.Scanner ;
import java.util.ArrayList ;
import java.util.Collections ;
import java.util.concurrent.TimeUnit ;

/**
 * A Class to hold information about the Game
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Game {
	// Fields
	private Pile pile ;
	private Card topCard ;
	private Scanner input ;
	private int playerCount ;
	private ArrayList<Player> players ;
	// Constructor
	/**
	 * Creates Game Object
	 */
	public Game() {
		playerCount = 0 ;
		pile = new Pile() ;
		input = new Scanner(System.in) ;
		players = new ArrayList<Player>() ;
	}
	// Methods
	/**
	 * Clears the screen using an ANSI escape code then waits for some time
	 *
	 * @param seconds The number of seconds the program should wait
	 */
	public void clearScreen(int seconds) {
		if ( seconds == 0 ) {
			System.out.print("\033[H\033[2J") ;
			return ;
		}
		try {
			TimeUnit.SECONDS.sleep(seconds) ;
		} catch (Exception exception) {
			
		}
		System.out.print("\033[H\033[2J") ;
	}
	/**
	 * Displays the top Card using the stringed functions in the Card Class
	 */
	public void showTopCard() {
		ArrayList<String> lines = topCard.stringed() ;
		for ( String line : lines )
			System.out.println(line) ;
	}
	/**
	 * Gives each Player 7 Cards at the beginning of the Game
	 */
	public void initDraw() {
		for ( Player player : players )
			for ( int it = 1 ; it <= 7 ; it ++ )
				player.getDeck().addCard(pile.drawTopCard()) ;
	}
	/**
	 * Check list of Players for a Player without Cards
	 *
	 * @return True if a Player without Cards exists otherwise False
	 */
	public boolean playerWithNoCardsExists() {
		boolean found = false ;
		for ( Player player : players )
			if ( player.getDeck().size() == 0 )
				found = true ;
		return found ;
	}
	/**
	 * Starts the Game in Singleplayer mode
	 */
	public void startSingleplayer() {
		// Get info
		clearScreen(0) ;
		while ( true ) {
			System.out.print("\u001B[36m" + "Enter The Number Of Players [3 , 5] : " + "\u001B[0m") ;
			playerCount = input.nextInt() ;
			String trash = input.nextLine() ;
			if ( playerCount >= 3 && playerCount <= 5 )
				break ;
		}
		System.out.print("\u001B[36m" + "Enter Your Username : " + "\u001B[0m") ;
		String username = input.nextLine() ;
		// Build game
		pile = new Pile() ;
		players.add(new Human(username)) ;
		for ( int it = 1 ; it <= playerCount - 1 ; it ++ )
			players.add(new Bot("Bot " + it)) ;
		// Initial draw
		initDraw() ;
		// Set the top Card
		while ( true ) {
			topCard = pile.drawTopCard() ;
			if ( topCard instanceof NormalCard )
				break ;
			pile.addCard(topCard) ;
		}
		clearScreen(2) ;
	}
	/**
	 * Starts the Game in Multiplayer mode
	 */
	public void startMultiplayer() {
		// Get info
		while ( true ) {
			clearScreen(0) ;
			System.out.print("\u001B[36m" + "Enter The Number Of Players [3 , 5] : " + "\u001B[36m") ;
			playerCount = input.nextInt() ;
			String trash = input.nextLine() ;
			if ( playerCount >= 3 && playerCount <= 5 )
				break ;
		}
		for ( int it = 1 ; it <= playerCount ; it ++ ) {
			System.out.print("\u001B[36m" + "Username : " + "\u001B[0m") ;
			String username = input.nextLine() ;
			players.add(new Human(username)) ;
		}
		// Build game
		pile = new Pile() ;
		// Initial draw
		initDraw() ;
		// Set the top Card
		while ( true ) {
			topCard = pile.drawTopCard() ;
			if ( topCard instanceof NormalCard )
				break ;
			pile.addCard(topCard) ;
		}
		clearScreen(2) ;
	}
	/**
	 * Runs the Game as turns for each Player
	 */
	public void run() {
		// Index of player who should play a card
		int turn = 0 ;
		// {+1} for clockwise AND {-1} for anticlockwise | Default is clockwise
		int direction = 1 ;
		// Stores number of cards player has to draw
		int penalty = 0 ;
		while ( !playerWithNoCardsExists() ) {
			// Player whose turn it is to play a Card
			Player targetPlayer = players.get(turn) ;
			// Print details about the Player
			if ( direction == 1 )
				System.out.println("\u001B[36m" + "Direction => " + "\u001B[33m" + "Clockwise" + "\u001B[0m") ;
			else 
				System.out.println("\u001B[36m" + "Direction => " + "\u001B[33m" + "AntiClockwise" + "\u001B[0m") ;
			System.out.println() ;
			System.out.println("\u001B[36m" + targetPlayer.getUsername() + "'s Turn" + "\u001B[0m") ;
			showTopCard() ;
			System.out.println() ;
			System.out.println("\u001B[36m" + targetPlayer.getUsername() + "'s Deck" + "\u001B[0m") ;
			// if ( targetPlayer instanceof Human )
			targetPlayer.show() ;
			// Get desired Card from the Player
			Card targetCard = targetPlayer.playCard(topCard) ;
			// Player has no Cards avaliable for play
			if ( targetCard == null ) {
				Card secondCard = pile.drawTopCard() ;
				targetPlayer.getDeck().addCard(secondCard) ;
				// The Card drawn from the pile is avaliable for play and thus is played
				if ( topCard.isValid(secondCard) ) {
					// PASS
				}
				// The Card drawn from the pile is not avaliable for play and thus the Players turn is passed
				else {
					if ( penalty != 0 ) {
						for ( int it = 1 ; it <= penalty ; it ++ )
							targetPlayer.getDeck().addCard(pile.drawTopCard()) ;
						penalty = 0 ;
					}
					turn = (turn + direction + playerCount) % (playerCount) ;
					System.out.println("\u001B[33m" + "No Avaliable Moves : " + "\u001B[33m" + "[TURN PASSED]" + "\u001B[0m") ;
				}
			}
			// Player has at least one Card avaliable for play and plays a card
			else {
				pile.addCard(topCard) ;
				topCard = targetCard ;
				Player nextPlayer = players.get((turn + direction + playerCount) % (playerCount)) ;
				// Handle penalty
				if ( penalty != 0 && !(targetCard instanceof DrawFourCard || targetCard instanceof DrawTwoCard) ) {
					for ( int it = 1 ; it <= penalty ; it ++ )
						targetPlayer.getDeck().addCard(pile.drawTopCard()) ;
					System.out.println("\u001B[33m" + "Penalty : [" + penalty + " Cards]" + "\u001B[0m") ;
					System.out.println() ;
					penalty = 0 ;
				}
				// Non-Action Card
				if ( targetCard instanceof NormalCard ) {
					turn = (turn + direction + playerCount) % (playerCount) ;
				}
				// Force-Card
				else if ( targetCard instanceof ForceCard ) {
					Card actionCard = targetPlayer.playCard(null) ;
					nextPlayer.getDeck().addCard(actionCard) ;
					turn = (turn + direction + playerCount) % (playerCount) ;
				}
				// Draw-Four Card
				else if ( targetCard instanceof DrawFourCard ) {
					penalty += 4 ;
					turn = (turn + direction + playerCount) % (playerCount) ;
				}
				// Draw-Two Card
				else if ( targetCard instanceof DrawTwoCard ) {
					penalty += 2 ;
					turn = (turn + direction + playerCount) % (playerCount) ;
				}
				// Prize Card
				else if ( targetCard instanceof PrizeCard ) {
					// PASS
				}
				// Reverse Card
				else if ( targetCard instanceof ReverseCard ) {
					if ( direction == 1 )
						direction = -1 ;
					else
						direction = 1 ;
					turn = (turn + direction + playerCount) % (playerCount) ;
				}
				// Skip Card
				else if ( targetCard instanceof SkipCard ) {
					turn = (turn + 2 * direction + playerCount) % (playerCount) ;
				}
				// Wild Card
				else if ( targetCard instanceof WildCard ) {
					String targetColor = targetPlayer.getWildCardColor() ;
					Card colorChanger = new NormalCard("NULL" , targetColor) ;
					pile.addCard(topCard) ;
					topCard = colorChanger ;
					turn = (turn + direction + playerCount) % (playerCount) ;
				}
			}
			// if Player is a Bot wait for 5 seconds otherwise wait for 1 second
			if ( targetPlayer instanceof Bot )
				clearScreen(4) ;
			else
				clearScreen(1) ;
		}
	}
	/**
	 * Ends the Game and shows the scoreboard
	 */
	public void end() {
		// Calculate the points of each player
		for ( Player player : players )
			player.calculatePoint() ;
		Collections.sort(players , new Player.Compare()) ;
		// Show the scoreboard
		System.out.println("SCOREBOARD : ") ;
		int it = 1 ;
		for ( Player player : players ) {
			System.out.println(it + ") " + player.getUsername() + "=>" + player.getPoint()) ;
			it ++ ;
		}
		clearScreen(10) ;
	}
}

