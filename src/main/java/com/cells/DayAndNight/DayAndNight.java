package com.cells.DayAndNight;

import com.cells.*;
import java.awt.Color;

public class DayAndNight extends CellularAutomaton {
	public DayAndNight(DayAndNightBuilder builder) {
		this(builder.width(), builder.height(), builder.size(), builder.isCircular());
	}

	public DayAndNight(int width, int height, int size, boolean isCircular) {
		this.isCircular = isCircular;

		cells = new DANCell[width][height];

		for (int x = 0; x < cells.length; x++)
			for (int y = 0; y < cells[0].length; y++)
				cells[x][y] = new DANCell(x * size, y * size, size, Helper.random.nextBoolean());
	}

	@Override
	public String getName() {
		return "Day and Night";
	}

	@Override
	public void update() {
		DANCell[][] newCells = new DANCell[cells.length][cells[0].length];

		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[0].length; y++) {
				Cell[] neighbors = getNeighbors(x, y);
				int livingCells = getLivingCells(neighbors);

				newCells[x][y] = ((DANCell) cells[x][y]).clone();
				newCells[x][y].update(livingCells);
			}
		}

		cells = newCells;
	}

	private int getLivingCells(Cell[] cells) {
		int sum = 0;

		for (Cell c : cells)
			if (((DANCell) c).isAlive())
				sum++;

		return sum;
	}
}
