package com.cells.BriansBrain;

import com.cells.*;
import java.awt.Color;

public class BriansBrain extends CellularAutomaton {
	public BriansBrain(BriansBrainBuilder builder) {
		this(builder.width(), builder.height(), builder.size(), builder.isCircular());
	}

	public BriansBrain(int width, int height, int size, boolean isCircular) {
		this.isCircular = isCircular;

		cells = new BriansBrainCell[width][height];

		for (int x = 0; x < cells.length; x++)
			for (int y = 0; y < cells[0].length; y++)
				cells[x][y] = new BriansBrainCell(x * size, y * size, size, Helper.random.nextBoolean());
	}

	@Override
	public String getName() {
		return "Brian's Brain";
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

	private int getLivingCells(Cell[] cells) {
		int sum = 0;

		for (Cell c : cells)
			if (((BriansBrainCell) c).isAlive())
				sum++;

		return sum;
	}
}
