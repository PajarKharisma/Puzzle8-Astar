package algorithm;

import java.util.ArrayList;

import node.Node;

public class Solution {
	private ArrayList<Node> listOfSolution;
	private boolean solvable;
	
	public ArrayList<Node> getListOfSolution() {
		return listOfSolution;
	}
	
	public void setListOfSolution(ArrayList<Node> listOfSolution) {
		this.listOfSolution = listOfSolution;
	}
	
	public boolean isSolvable() {
		return solvable;
	}
	
	public void setSolvable(boolean solvable) {
		this.solvable = solvable;
	}
	
	
}
