package algorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import costFunction.CalculateCost;
import node.Node;
import operation.MatrixOperation;
import operation.Movement;

public class Astar {

	public Solution getSolution(int[][] initState, int[][] goalState) {
		CalculateCost calculateCost = new CalculateCost();
		Movement movement = new Movement();
		MatrixOperation matrixOperation = new MatrixOperation();
		ArrayList<Node> closeList = new ArrayList<>();
		Solution solution = new Solution();

		ArrayList<Node> listOfSolution = new ArrayList<>();

		Node initNode = new Node(initState, 0);
		listOfSolution.add(initNode);

		do {
			int[][] currentState = matrixOperation.copyOfMatrix(listOfSolution.get(listOfSolution.size()-1).getState());
			Point currPos = movement.getBlankPos(currentState);

			int minCost = Integer.MAX_VALUE;
			Node node = null;
			for (Point step : Movement.STEP) {
				Point newPos = new Point((currPos.x + step.x), currPos.y + step.y);

				if (movement.isSafe(newPos)) {
					int[][] stateAfterMove = movement.getCurrentState(currentState, currPos, newPos);
					int cost = calculateCost.getCost(stateAfterMove, goalState) + calculateCost.getCost(initState, stateAfterMove);

					if (cost < minCost && !matrixOperation.checkVisited(stateAfterMove, closeList)) {
						minCost = cost;
						node = new Node(stateAfterMove, cost);
						node.setGn(calculateCost.getCost(stateAfterMove, goalState));
						node.setHn(calculateCost.getCost(initState, stateAfterMove));
					}
				}
			}
			if (node != null) {
				listOfSolution.add(node);
				closeList.add(node);
			} else {
				closeList.add(listOfSolution.get(listOfSolution.size()-1));
				listOfSolution.remove(listOfSolution.size()-1);
			}
			
			if(listOfSolution.size() > 10000) {
				solution.setSolvable(false);
				solution.setListOfSolution(listOfSolution);
				return solution;
			}
		} while (!Arrays.deepEquals(listOfSolution.get(listOfSolution.size()-1).getState(), goalState));
		
		solution.setSolvable(true);
		solution.setListOfSolution(listOfSolution);
		return solution;
	}
}
