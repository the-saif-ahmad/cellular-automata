package com.cells.Rule90;

import com.cells.*;

public class Rule90 extends CellularAutomaton {
	int currRow = 1;

	public Rule90(int size, R90Cell[][] cells, boolean isCircular) {
		this.isCircular = isCircular;

		name = "Rule 90";
		this.cells = cells;
	}

	public Rule90(int width, int height, int size, boolean isCircular) {
		this.isCircular = isCircular;

		name = "Rule 90";

		cells = new R90Cell[width][height];

		for (int x = 0; x < cells.length; x++)
			for (int y = 0; y < cells[0].length; y++)
				cells[x][y] = new R90Cell(x * size, y * size, size, x == width / 2 && y == 0);
	}

	@Override
	public void update() {
		for (int x = 0; x < cells.length; x++) {
			int livingNeighbors = getNeighborsR90(x, Helper.decrement(currRow, cells[0].length - 1, isCircular));

			((R90Cell) cells[x][currRow]).update(livingNeighbors);
		}

		currRow = Helper.increment(currRow, cells[0].length, isCircular);
	}

	private int getNeighborsR90(int x, int y) {
		int sum = 0;

		int left = Helper.decrement(x, cells.length - 1, isCircular);
		int right = Helper.increment(x, cells.length, isCircular);

		if (((R90Cell) cells[left][y]).isAlive())
			sum++;

		if (((R90Cell) cells[right][y]).isAlive())
			sum++;

		return sum;
	}

	@Override
	public CellularAutomaton clone() {
		R90Cell[][] newCells = new R90Cell[cells.length][cells[0].length];

		for (int x = 0; x < cells.length; x++)
			for (int y = 0; y < cells[0].length; y++)
				newCells[x][y] = ((R90Cell) cells[x][y]).clone();

		return new Rule90(size, newCells, isCircular);
	}
}
