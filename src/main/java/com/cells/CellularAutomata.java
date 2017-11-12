package com.cells;

public abstract class CellularAutomata {
	protected String name;
	protected int size;
	protected Cell[][] cells;
	protected boolean isCircular;

	public Cell[][] getCells() {
		return cells;
	}

	public String getName() {
		return name;
	}

	public boolean isCircular() {
		return isCircular;
	}

	protected Cell[] getNeighbors(int x, int y) {
		Cell[] neighbors = new Cell[8];

		int left = Helper.decrement(x, cells.length - 1, isCircular);
		int right = Helper.increment(x, cells.length - 1, isCircular);
		int up = Helper.decrement(y, cells[0].length - 1, isCircular);
		int down = Helper.increment(y, cells[0].length - 1, isCircular);

		// Top row
		neighbors[0] = cells[left][up];
		neighbors[1] = cells[x][up];
		neighbors[2] = cells[right][up];

		// Left and right
		neighbors[3] = cells[left][y];
		neighbors[4] = cells[right][y];

		// Bottom row
		try {
		neighbors[5] = cells[left][down];
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(left + " " + down);
		}
		neighbors[6] = cells[x][down];
		neighbors[7] = cells[right][down];

		return neighbors;
	}

	public abstract void update();
	public abstract CellularAutomata clone();
}
