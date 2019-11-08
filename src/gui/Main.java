package gui;

import algorithm.Astar;
import algorithm.Solution;
import node.Node;

public class Main {

	public static void main(String[] args) {

		int[][] initState = {
				{7, 2, 4},
				{5, 0, 6},
				{8, 3, 1}
			};

		// unsolve problem
//		int[][] initState = {
//				{0, 2, 3},
//				{4, 1, 6},
//				{7, 5, 8}
//		};

//		int[][] initState = { 
//				{ 1, 0, 2 },
//				{ 4, 5, 3 },
//				{ 7, 8, 6 }
//			};

		int[][] goalState = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 0 }
			};

		Astar astar = new Astar();
		Solution solution = astar.getSolution(initState, goalState);

		if(solution.isSolvable()) {
			int step = 0;
			for (Node solutionList : solution.getListOfSolution()) {
				System.out.println("==================================");
				System.out.println("Step : " + step);
				step++;
				solutionList.printData();
			}
		}else {
			System.out.println("Your puzzle maybe unsovable");
		}
	}
}
