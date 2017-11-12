package com.cells.ConwaysGame;

import com.cells.*;
import java.awt.Color;

public class ConwayCell extends Cell {
	private static final Color ALIVE_COLOR = Color.WHITE;
	private static final Color DEAD_COLOR = Color.BLACK;

	private boolean isAlive;

	public ConwayCell(int x, int y, int size, boolean alive) {
		super(x, y, size);

		isAlive = alive;
	}

	public void update(int livingNeighbors) {
		if (livingNeighbors < 2 || livingNeighbors > 3)
			isAlive = false;
		else if (livingNeighbors == 3)
			isAlive = true;
	}

	public boolean isAlive() {
		return isAlive;
	}

	@Override
	public Color getColor() {
		return isAlive ? ALIVE_COLOR : DEAD_COLOR;
	}

	@Override
	public ConwayCell clone() {
		return new ConwayCell(x, y, size, isAlive);

	}
}
