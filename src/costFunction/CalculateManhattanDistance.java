package costFunction;

import java.awt.Point;

public class CalculateManhattanDistance {
	
	public int getMahattanDistance(int[][] goalState, Point posInit, int val) {
		int manhattanDistance = 0;
		Point posGoal = new Point();
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(val == goalState[i][j]) {
					posGoal.x = i;
					posGoal.y = j;
				}
			}
		}
		
		manhattanDistance = Math.abs(posInit.x - posGoal.x) + Math.abs(posInit.y - posGoal.y);
		return manhattanDistance;
	}
}
