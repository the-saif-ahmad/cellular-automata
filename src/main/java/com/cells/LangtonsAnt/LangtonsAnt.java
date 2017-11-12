package com.cells.LangtonsAnt;

import com.cells.*;

public class LangtonsAnt extends CellularAutomata {
	private int xLoc, yLoc;
	private int facing;

	public LangtonsAnt(int size, LangtonCell[][] cells, boolean isCircular, int xLoc, int yLoc, int facing) {
		this.isCircular = isCircular;
		this.size = size;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.facing = facing;

		name = "Langton's Ant";
		this.cells = cells;
	}

	public LangtonsAnt(int width, int height, int size, boolean isCircular) {
		this.isCircular = isCircular;
		this.size = size;

		name = "Langton's Ant";
		cells = new LangtonCell[width][height];

		for (int x = 0; x < cells.length; x++)
			for (int y = 0; y < cells[0].length; y++)
				cells[x][y] = new LangtonCell(x * size, y * size, size);

		xLoc = width / 2;
		yLoc = height / 2;
		facing = 0;
	}

	@Override
	public void update() {
		LangtonCell cell = (LangtonCell) cells[xLoc][yLoc];
		facing = (facing + cell.getDirection()) % 4;
		cell.update();
		move();
	}

	@Override
	public CellularAutomata clone() {
		LangtonCell[][] newCells = new LangtonCell[cells.length][cells[0].length];

		for (int x = 0; x < cells.length; x++)
			for (int y = 0; y < cells[0].length; y++)
				newCells[x][y] = ((LangtonCell) cells[x][y]).clone();

		return new LangtonsAnt(size, newCells, isCircular, xLoc, yLoc, facing);
	}

	private void move() {
		if (facing == 0) // UP
			yLoc = Helper.decrement(yLoc, cells[0].length - 1, isCircular);
		else if (facing == 1) // RIGHT
			xLoc = Helper.increment(xLoc, cells.length, isCircular);
		else if (facing == 2) // Down
			yLoc = Helper.increment(yLoc, cells[0].length, isCircular);
		else if (facing == 3) // LEFT
			xLoc = Helper.decrement(xLoc, cells.length - 1, isCircular);
	}
}
