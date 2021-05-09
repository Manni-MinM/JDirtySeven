// BWOTSHEWCHB

import java.util.Scanner ;
import java.util.concurrent.TimeUnit ;

/**
 * Main Class
 *
 * @author Manni Moghimi
 * @version v1.0
 */
public class Main {
	public static void main(String[] args) {
		Game game = new Game() ;
		Scanner input = new Scanner(System.in) ;	
		while ( true ) {
			clearScreen(0) ;
			showMenu() ;
			System.out.print("\u001B[36m" + "Command : " + "\u001B[0m") ;
			String line = input.nextLine() ;
			if ( line.equals("Play With Bots") ) {
				game.startSingleplayer() ;
				game.run() ;
				game.end() ;
			}
			else if ( line.equals("Play With Friends") ) {
				game.startMultiplayer() ;
				game.run() ;
				game.end() ;
			}
			else if ( line.equals("Exit") )
				break ;
			else
				handleMenuException() ;
		}
	}
	/**
	 * Clears the screen using an ANSI escape code then waits for some time
	 *
	 * @param seconds The number of seconds the program should wait
	 */
	public static void clearScreen(int seconds) {
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
	 * Shows the main menu
	 */
	public static void showMenu() {	
		System.out.print("\u001B[33m") ;
		System.out.println("#### Dirty Seven ####") ;
		System.out.println() ;
		System.out.print("\u001B[36m") ;
		System.out.println("Play With Bots") ;
		System.out.println("Play With Friends") ;
		System.out.println("Exit") ;
		System.out.println("\u001B[0m") ;
	}
	/**
	 * Prints an error for the user if command is invalid in the menu
	 */
	public static void handleMenuException() {
		System.out.println("[Command Not Found]") ;
	}
}

