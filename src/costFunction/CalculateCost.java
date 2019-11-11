package costFunction;

import java.awt.Point;
import operation.MatrixSize;

public class CalculateCost {
	
	private CalculateManhattanDistance calculateManhattanDistance;
	
	public int getCost(int[][] initState, int[][] goalState) {
		calculateManhattanDistance = new CalculateManhattanDistance();
		
		int totalCost = 0;
		for(int i=0; i<MatrixSize.SIZE; i++) {
			for(int j=0; j<MatrixSize.SIZE; j++) {
				int val = initState[i][j];
				
				Point posStart = new Point(i, j);
				
				totalCost += calculateManhattanDistance.getMahattanDistance(goalState, posStart, val);
			}
		}
		
		return totalCost;
	}
	
	public int getTruePos(int[][] initState, int[][] goalState) {
		int totalCost = 0;
		
		for(int i=0; i<MatrixSize.SIZE; i++) {
			for(int j=0; j<MatrixSize.SIZE; j++) {
				if(initState[i][j] == goalState[i][j]) {
					totalCost++;
				}
			}
		}
		return totalCost;
	}
	
	public int getBlankDistance(int[][] initState, int[][] goalState) {
		Point pos = new Point();

		for (int i = 0; i < MatrixSize.SIZE; i++) {
			for (int j = 0; j < MatrixSize.SIZE; j++) {
				if (initState[i][j] == 0) {
					pos.x = i;
					pos.y = j;
				}
			}
		}

		return calculateManhattanDistance.getMahattanDistance(goalState, pos, 0);
	}
}
