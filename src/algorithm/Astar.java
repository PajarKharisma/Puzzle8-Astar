package algorithm;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;

import costFunction.CalculateCost;
import node.Node;
import operation.MatrixOperation;
import operation.Movement;

public class Astar {

	public Solution getSolution(int[][] initState, int[][] goalState) {
		CalculateCost calculateCost = new CalculateCost();
		Movement movement = new Movement();
		MatrixOperation matrixOperation = new MatrixOperation();
		LinkedList<Node> closeList = new LinkedList<>();
		Solution solution = new Solution();

		LinkedList<Node> listOfSolution = new LinkedList<>();

		Node initNode = new Node(initState, 0);
		listOfSolution.add(initNode);

		do {
			int[][] currentState = matrixOperation.copyOfMatrix(listOfSolution.getLast().getState());
			Point currPos = movement.getBlankPos(currentState);

			int minCost = Integer.MAX_VALUE;
			Node node = null;
			for (Point step : movement.STEP) {
				Point newPos = new Point((currPos.x + step.x), currPos.y + step.y);

				if (movement.isSafe(newPos)) {
					int[][] stateAfterMove = movement.getCurrentState(currentState, currPos, newPos);
					int cost = calculateCost.getCost(stateAfterMove, goalState) - calculateCost.getTruePos(stateAfterMove, goalState);

					if (cost < minCost && !matrixOperation.checkVisited(stateAfterMove, closeList)) {
						minCost = cost;
						node = new Node(stateAfterMove, cost);
					}
				}
			}
			if (node != null) {
				listOfSolution.add(node);
				closeList.add(node);
			} else {
				closeList.add(listOfSolution.getLast());
				listOfSolution.remove(listOfSolution.size()-1);
			}
			
			if(listOfSolution.size() > 10000) {
				solution.setSolvable(false);
				solution.setListOfSolution(listOfSolution);
				return solution;
			}
		} while (!Arrays.deepEquals(listOfSolution.getLast().getState(), goalState));
		
		solution.setSolvable(true);
		solution.setListOfSolution(listOfSolution);
		return solution;
	}
}
