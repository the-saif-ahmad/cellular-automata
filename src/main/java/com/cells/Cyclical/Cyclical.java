package com.cells.Cyclical;

import com.cells.*;

public class Cyclical extends CellularAutomaton {
	public Cyclical(CyclicalBuilder builder) {
		this(builder.width(), builder.height(), builder.size(), builder.isCircular());
	}

	public Cyclical(int width, int height, int size, boolean isCircular) {
		this.isCircular = isCircular;

		cells = new CyclicalCell[width][height];

		for (int x = 0; x < cells.length; x++)
			for (int y = 0; y < cells[0].length; y++)
				cells[x][y] = new CyclicalCell(x * size, y * size, size, Helper.random.nextInt(CyclicalCell.COLORS.length));
	}

	@Override
	public String getName() {
		return "Cyclical";
	}

	@Override
	public void update() {
		CyclicalCell[][] newCells = new CyclicalCell[cells.length][cells[0].length];

		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[0].length; y++) {
				Cell[] neighbors = getNeighbors(x, y);

				newCells[x][y] = ((CyclicalCell) cells[x][y]).clone();
				newCells[x][y].update(neighbors);
			}
		}

		cells = newCells;
	}
}
