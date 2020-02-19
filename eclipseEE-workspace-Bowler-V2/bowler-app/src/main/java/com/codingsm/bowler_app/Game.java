package com.codingsm.bowler_app;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	// ArrayList for the frames
	private static ArrayList<Frame> game = new ArrayList<>();
	// Keep track of the frame
	private int frame = 1;
	private Scanner sc = new Scanner(System.in);
	private boolean isOver = false;
	
	// Start the game from the main()
	public void setGame() {
		
		// Loop through 10 frames
		while (!isOver) {
			System.out.println("Now bowling in FRAME # "+ frame);
			// Get the score from the user's input
			getScore();
			// Show the score after every frame
			showScore();
		}
		System.out.println(" GAME OVER! ");
	}
	
	private void getScore() {
		String ball1, ball2;
		try {
			System.out.println("Enter pins for Frame #" + frame + " Ball #1 ");
			System.out.println("[X = Strike]");
			// Grab the input from the user
			ball1 = sc.nextLine().toUpperCase();
			if (!ball1.equals("X")) {
				System.out.println("Enter pins for Frame #" + frame + " Ball #2 ");
				// Get the second ball from the user
				ball2 = sc.nextLine();
			}
			else {
				ball2 = " ";
			}
			game.add(new Frame(ball1.charAt(0),ball2.charAt(0)));
			frame++;
		} catch (FrameException e) {
			System.out.println("Could not create Frame, " + e.getMessage());
		}
	}
	
	private void showScore() {
		System.out.println(" 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |");
		System.out.println("-----------------------------------------");
		// Loop through the entire array
		for (int x = 0; x < game.size(); x++) {
			if (game.get(x).isStrike)
				System.out.print( "  X ");
			else if (game.get(x).isSpare)
				System.out.print( game.get(x).b1 + " / ");
			if (frame == 12)
				isOver = true;
			else {
				System.out.print( game.get(x).b1 + " " + game.get(x).b2 + " ");
				if (frame == 11)
					isOver = true;
			}
		}
		System.out.println();
		
		System.out.println("\n Game Total = " + calculateScore());
	}
	
	private int calculateScore() {
		int score = 0;

		for (int x = 0; x < game.size(); x++) {
			if (game.get(x).isSpare && x < game.size()-1)
				score += game.get(x+1).b1 + 10; 
			else if (game.get(x).isStrike && x < game.size()-1 && !game.get(x+1).isStrike)
				score += game.get(x+1).b1 + game.get(x+1).b2 + 10; 
			else if (game.get(x).isStrike && (x+1) < game.size()-1 && game.get(x+1).isStrike)
				score += game.get(x+2).b1 + 20; 
			else if (!game.get(x).isSpare && !game.get(x).isStrike)
				score += game.get(x).b1 + game.get(x).b2; 
			
		}
		return score;
	}

}
