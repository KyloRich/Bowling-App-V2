package com.codingsm.bowler_app;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;

public class Game {
	// ArrayList for the frames
	private ArrayList<Frame> game = new ArrayList<>();
	// Keep track of the frame
	private int frame = 1;
	private Scanner sc = new Scanner(System.in);

	
	// Start the game from the main()
	public void setGame() {
		
		// Loop through 10 frames
		while (frame < 11) {
			System.out.println("\nNow bowling in FRAME # "+ frame);
			// Get the score from the user's input
			getScore();
			// Show the score after every frame
			showScore();
		}
		System.out.println(" GAME OVER! ");
	}
	
	private void getScore() {
		String ball;
		char temp;
		
		System.out.println("Enter pins for Frame # " + frame + " Ball #1 \nEnter 'X' for a Strike");
		// Grab the input from the user
		ball = sc.nextLine();
		// Check to see is the character was a X for a strike
		if (ball.charAt(0) == 'X') {
			game.add(new Frame('X','0'));
			frame++;
			return;
		}
		else {
			// If not strike store the pins
			temp = ball.charAt(0);			
		}
		
		System.out.println("Enter pins for Frame # " + frame + " Ball #2 ");
		// Get the second ball from the user
		ball = sc.nextLine();
		if (Character.getNumericValue(temp) + Character.getNumericValue(ball.charAt(0)) > 10) {
			System.out.println("You score can not be over 10 for a frame! Please Re-Enter.");
			return;
		}
		game.add(new Frame(temp,ball.charAt(0)));
		frame++;
		return;
	}
	
	private void showScore() {
		// Initialize the score
		int score = 0;
		System.out.println("\n 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |");
		System.out.println("-----------------------------------------");
		// Loop through the entire array
		for (int x = 0; x < game.size(); x++) {
//			if (game.get(x).getScore() == 11 && game.get(x+1).isStrike && game.get(x+2).isStrike)
//				score += 30;
			
//			if (game.get(x).getScore() == 11 && game.get(x+1).isStrike)
//				score += 10 + Character.getNumericValue(game.get(x+1).b1) + (game.get(x+1).b2);
			
			if (game.get(x).getScore() == 11 && (game.size() -2) > x)
				score += 10 + Character.getNumericValue(game.get(x+1).b1) + (game.get(x+2).b2) ;
			
			 if (game.get(x).getScore() == 10 && (game.size() -1) > x)
				score += 10 + Character.getNumericValue(game.get(x+1).b1);
			else
				score += game.get(x).getScore();
			
			if (game.get(x).getScore() == 11)
				System.out.print("0 X ");
			if (game.get(x).getScore() == 10)
				System.out.print(game.get(x).b1 + " / ");
			if (game.get(x).getScore() < 10)
				System.out.print(game.get(x).b1 + " " + game.get(x).b2 + " ");
		}
		
		
		System.out.println("\n\nGame Total = " + score);
	}

	// Welcome Menu
		public void viewWelcomeMenu() {

			int option;
			do {
				System.out.println("\n----------------------------------------");
				System.out.println("                MAIN MENU");
				System.out.println("              Bowling-Scorer");
				System.out.println("----------------------------------------");
				System.out.println("\n         Enter 1 to Begin Game!");
				System.out.println("\n         Enter 2 to Quit!");

				option = getUserMenuChoice();
				processWelcomeMenu(option);
			} while (option != 2);
		}

		// Process choice of user input on Welcome Menu
		private void processWelcomeMenu(int parseInt) {

			switch (parseInt) {

			case 1:
				setGame();
				break;
			case 2:
				viewExitScreen();
				break;
			default:
				viewWelcomeMenu();
			}

	}

		/* detecting user input errors now distinguish between a user input error and a
		 general application error.*/
		private int getUserMenuChoice() {
			boolean success = false;
			int result = 0;
			while (!success) {
				String option = sc.nextLine();
				success = true;
				try {
					result = Integer.parseInt(option);
				} catch (NumberFormatException e) {
					System.out.println("*Menu Error* Expecting a numeric menu choice.  Please try again.");
					success = false;
				}
			}
			return result;
		}
		
		//trying to get input to prevent anything but numeric input
//		private int getUserBall() {
//			  boolean success = false;
//		        int result = 0;
//		        while (!success) {
//		            String Ball = sc.nextLine();
//		            success = true;
//		            try {
//		                result = Integer.parseInt(Ball);
//		            }
//		            catch (NumberFormatException e) {
//		                System.out.println("*Input Error* Expecting a numeric menu choice.  Please try again.*");
//		                success = false;                
//		            }
//		        }
//		        return result;
//		    }

		// Exit Screen
		private void viewExitScreen() {
			System.out.println("\nGoodbye, I hope you had fun Bowling! \nHave an amazing day!");

		}
}
