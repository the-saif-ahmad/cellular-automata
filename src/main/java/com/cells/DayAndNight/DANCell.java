package com.cells.DayAndNight;

import com.cells.*;
import java.awt.Color;

public class DANCell extends Cell {
	private static final Color ALIVE_COLOR = Color.YELLOW;
	private static final Color DEAD_COLOR = Color.BLACK;

	private boolean isAlive;

	public DANCell(int x, int y, int size, boolean alive) {
		super(x, y, size);

		isAlive = alive;
	}

	public void update(int livingNeighbors) {
		if (!isAlive && (livingNeighbors == 3 || livingNeighbors == 6 || livingNeighbors == 7 || livingNeighbors == 8))
			isAlive = true;
		else if (isAlive && (livingNeighbors == 3 || livingNeighbors == 4 || livingNeighbors == 6 || livingNeighbors == 7 || livingNeighbors == 8))
			isAlive = true;
		else
			isAlive = false;
	}

	public boolean isAlive() {
		return isAlive;
	}

	@Override
	public Color getColor() {
		return isAlive ? ALIVE_COLOR : DEAD_COLOR;
	}

	@Override
	public DANCell clone() {
		return new DANCell(x, y, size, isAlive);

	}
}
