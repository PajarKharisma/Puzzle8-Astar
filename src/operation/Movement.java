package operation;

import java.awt.Point;

public class Movement {

	//bottom, left, top, right
	public static final Point[] STEP = new Point[] {
			new Point(1, 0),
			new Point(0, -1),
			new Point(-1, 0),
			new Point(0, 1)
		};
	
	public boolean isSafe(Point pos) {
		return (pos.x >= 0 && pos.x < 3 && pos.y >= 0 && pos.y < 3);
	}
	
	public Point getBlankPos(int[][] matrix) {
		Point pos = new Point();
		for(int i=0; i<MatrixSize.SIZE; i++) {
			for(int j=0; j<MatrixSize.SIZE; j++) {
				if(matrix[i][j] == 0) {
					pos.x = i;
					pos.y = j;
					break;
				}
			}
		}
		return pos;
	}
	
	public int[][] getCurrentState(int[][] matrix, Point currPos, Point newPos) { 
		MatrixOperation matrixOperation = new MatrixOperation();
		int[][] resultMatrix = matrixOperation.copyOfMatrix(matrix);
		
		int temp = resultMatrix[currPos.x][currPos.y];
		resultMatrix[currPos.x][currPos.y] = resultMatrix[newPos.x][newPos.y];
		resultMatrix[newPos.x][newPos.y] = temp;
		
		return resultMatrix;
	}
}
