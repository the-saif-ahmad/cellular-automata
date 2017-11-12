package com.cells.BriansBrain;

import com.cells.*;
import java.util.Random;
import java.awt.Color;

public class BriansBrain extends CellularAutomaton {
	public BriansBrain(int size, BriansBrainCell[][] cells, boolean isCircular) {
		this.isCircular = isCircular;

		name = "Brian's Brain";
		this.cells = cells;
	}

	public BriansBrain(int width, int height, int size, boolean isCircular) {
		this.isCircular = isCircular;

		name = "Brian's Brain";
		cells = new BriansBrainCell[width][height];

		Random rand = new Random();

		for (int x = 0; x < cells.length; x++)
			for (int y = 0; y < cells[0].length; y++)
				cells[x][y] = new BriansBrainCell(x * size, y * size, size, rand.nextBoolean());
	}

	@Override
	public void update() {
		BriansBrainCell[][] newCells = new BriansBrainCell[cells.length][cells[0].length];

		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[0].length; y++) {
				Cell[] neighbors = getNeighbors(x, y);
				int livingCells = getLivingCells(neighbors);

				newCells[x][y] = ((BriansBrainCell) cells[x][y]).clone();
				newCells[x][y].update(livingCells);
			}
		}

		cells = newCells;
	}

	@Override
	public CellularAutomaton clone() {
		BriansBrainCell[][] newCells = new BriansBrainCell[cells.length][cells[0].length];

		for (int x = 0; x < cells.length; x++)
			for (int y = 0; y < cells[0].length; y++)
				newCells[x][y] = ((BriansBrainCell) cells[x][y]).clone();

		return new BriansBrain(size, newCells, isCircular);
	}

	private int getLivingCells(Cell[] cells) {
		int sum = 0;

		for (Cell c : cells)
			if (((BriansBrainCell) c).isAlive())
				sum++;

		return sum;
	}
}
