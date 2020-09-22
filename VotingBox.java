import stanford.karel.*;

public class VotingBox extends SuperKarel {
	
	/* Karel starts off facing to the right against the far-left wall.
	 * He knows he has ballots to check while the space in front of him is clear.
	 * When he makes it to the far-right wall, he's finished.
	 */
	
	public void run() {
		
		while (frontIsClear()) {
			
			move();
			checkBallot();
			move();
		}
	}
	
	/* Karel checks if a beeper is present in the middle of the ballot rectangle.
	 * If there is, then it's safe to say that there is no intent to vote in that 
	 * rectangle as per the guidelines. If there isn't a beeper, then Karel will 
	 * turn right and start cleaning. After cleaning, Karel moves to the middle of
	 * the rectangle and turns left, facing to the right.
	 */
	
	private void checkBallot() {
			
		if (beepersPresent()) {
				
		} else {
			
			turnRight();
			cleanTurnAround();
			cleanTurnAround();
			move();
			turnLeft();	
		}
	}
	
	/* Karel's cleanTurnAround method will be run twice: while his front is clear he will pick up any beeper 
	 * he comes across, and when he reaches a wall he will turn around. It's ran twice so that both sides 
	 * of the ballot rectangle can be cleaned. To be thorough, Karel will pick up beepers until there are
	 * none remaining in a spot.
	 * 
	 */
	
	private void cleanTurnAround() {
		
		while (frontIsClear()) {
			
			while (beepersPresent()) {
				
				pickBeeper();
			}
			
			move();
		}
		
		while (beepersPresent()) {
			
			pickBeeper();
		}
		
		turnAround();
	}
}