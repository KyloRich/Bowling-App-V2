package com.codingsm.bowler_app;

public class Frame {
	

	public static int frame = 1;
	public int b1;
	public int b2;
	// -1 = STRIKE
	// -2 = SPARE
	// 0  = OPEN
	public int score = 0;
	public boolean isStrike;
	public boolean isSpare;

	Frame (char ball1, char ball2) throws FrameException{
		if (ball1 == 'X') {
			b1 = 10;
			b2 = -1;
			isStrike = true;
			System.out.println("STRRRRRIKE!!!!");
			return;
		}
		b1 = Character.getNumericValue(ball1);
		b2 = Character.getNumericValue(ball2);
		if (b1 < 0 || b2 < 0)
			throw new FrameException("Entered invalid pin count!");
			
		if ((b1 + b2) == 10) {
			isSpare = true;
			System.out.println("Picked up the spare!");
			return;
		}
		if ((b1 + b2) < 10) {
			System.out.println("Open frame - Oops!");
			return;
		}
		throw new FrameException("Entered invalid pin count!");
	}
	
	public int getScore() {
		return 0;
	}
}
