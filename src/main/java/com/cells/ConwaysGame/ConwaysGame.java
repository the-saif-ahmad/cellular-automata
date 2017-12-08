package com.cells.ConwaysGame;

import com.cells.*;
import java.awt.Color;

public class ConwaysGame extends CellularAutomaton {
	public ConwaysGame(ConwaysGameBuilder builder) {
		this(builder.width(), builder.height(), builder.size(), builder.isCircular());
	}

	public ConwaysGame(int width, int height, int size, boolean isCircular) {
		this.isCircular = isCircular;

		cells = new ConwayCell[width][height];

		for (int x = 0; x < cells.length; x++)
			for (int y = 0; y < cells[0].length; y++)
				cells[x][y] = new ConwayCell(x * size, y * size, size, Helper.random.nextBoolean());
	}

	@Override
	public String getName() {
		return "Conway's Game of Life";
	}

	@Override
	public void update() {
		ConwayCell[][] newCells = new ConwayCell[cells.length][cells[0].length];

		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[0].length; y++) {
				Cell[] neighbors = getNeighbors(x, y);
				int livingCells = getLivingCells(neighbors);

				newCells[x][y] = ((ConwayCell) cells[x][y]).clone();
				newCells[x][y].update(livingCells);
			}
		}

		cells = newCells;
	}

	private int getLivingCells(Cell[] cells) {
		int sum = 0;

		for (Cell c : cells)
			if (((ConwayCell) c).isAlive())
				sum++;

		return sum;
	}
}
