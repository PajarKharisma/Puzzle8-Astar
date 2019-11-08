package algorithm;

import java.util.LinkedList;

import node.Node;

public class Solution {
	private LinkedList<Node> listOfSolution;
	private boolean solvable;
	
	public LinkedList<Node> getListOfSolution() {
		return listOfSolution;
	}
	
	public void setListOfSolution(LinkedList<Node> listOfSolution) {
		this.listOfSolution = listOfSolution;
	}
	
	public boolean isSolvable() {
		return solvable;
	}
	
	public void setSolvable(boolean solvable) {
		this.solvable = solvable;
	}
	
	
}
