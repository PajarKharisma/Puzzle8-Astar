package operation;

import java.util.ArrayList;
import java.util.Arrays;
import node.Node;

public class MatrixOperation {

	public int[][] copyOfMatrix(int[][] matrix) {
		int[][] result = new int[MatrixSize.SIZE][MatrixSize.SIZE];
		for (int i = 0; i < MatrixSize.SIZE; i++) {
			for (int j = 0; j < MatrixSize.SIZE; j++) {
				result[i][j] = matrix[i][j];
			}
		}
		return result;
	}

	public boolean checkVisited(int[][] state, ArrayList<Node> solutionList) {
		for (Node solution : solutionList) {
			if (Arrays.deepEquals(state, solution.getState())) {
				return true;
			}
		}
		return false;

	}

	private int getInvCount(int[][] initState, int[][] goalState) {
		int invCount = 0;
		for(int i=0; i<MatrixSize.SIZE; i++) {
			for(int j=0; j<MatrixSize.SIZE; j++) {
				if(initState[i][j] != 0 && initState[i][j] != goalState[i][j]) {
					invCount++;
				}
			}
		}
		return invCount;
	}

	public boolean isSolvable(int[][] initState, int[][] goalState) {
		return (getInvCount(initState, goalState) % 2 == 0);
	}
}
