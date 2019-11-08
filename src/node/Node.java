package node;

import java.awt.Point;

import operation.MatrixSize;

public class Node {
	private int[][] state;
	private int cost;
	Point currPos;
	Point newPos;
	
	
	public Node() {
	}
	
	public Node(int[][] state, int cost) {
		this.state = state;
		this.cost = cost;
	}
	
	public int[][] getState() {
		return this.state;
	}
	
	public void setState(int[][] state) {
		this.state = state;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void printData() {
		System.out.println("Cost : " + this.cost);
		System.out.println("Board : ");
		for(int i=0; i<MatrixSize.SIZE; i++) {
			for(int j=0; j<MatrixSize.SIZE; j++) {
				System.out.print(this.state[i][j] + " ");
			}
			System.out.println();
		}
	}
}
