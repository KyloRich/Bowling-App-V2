package com.codingsm.bowler_app;

public class Frame {
	
	public char b1;
	public char b2;
	public boolean isSpare = false;
	public boolean isStrike = false;
	public Frame nextFrame;
	
	Frame (char b1, char b2){
		if (b1 == 'X' || Character.getNumericValue(b1) == 10) {
			b1 = ' ';
			b2 = 'X';
			isStrike = true;
			System.out.println("\nSTRRRRRIKE!!!!");
			
		}
		if (Character.getNumericValue(b1) + Character.getNumericValue(b2) == 10) {
			isSpare = true;
			System.out.println("\nPicked up the spare!");
			
		}
		this.b1 = b1;
		this.b2 = b2;
	}
	
	public int getScore() {
		if (isStrike)
			return 11;
		if (isSpare)
			return 10;
		else 
			return Character.getNumericValue(b1) + Character.getNumericValue(b2);
	}
}


 