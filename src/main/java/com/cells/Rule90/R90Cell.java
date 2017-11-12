package com.cells.Rule90;

import com.cells.*;
import java.awt.Color;

public class R90Cell extends Cell {
	private static final Color ALIVE_COLOR = Color.WHITE;
	private static final Color DEAD_COLOR = Color.BLACK;

	private boolean isAlive;

	public R90Cell(int x, int y, int size, boolean alive) {
		super(x, y, size);

		isAlive = alive;
	}

	public void update(int livingNeighbors) {
		if (livingNeighbors == 2 || livingNeighbors == 0)
			isAlive = false;
		else
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
	public R90Cell clone() {
		return new R90Cell(x, y, size, isAlive);
	}
}
