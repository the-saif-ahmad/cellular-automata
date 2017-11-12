package com.cells.BriansBrain;

import com.cells.*;
import java.awt.Color;

public class BriansBrainCell extends Cell {
	private static final Color ALIVE_COLOR = Color.BLUE;
	private static final Color DEAD_COLOR = Color.BLACK;
	private static final Color DYING_COLOR = Color.WHITE;

	private boolean isAlive;
	private boolean isDying;

	public BriansBrainCell(int x, int y, int size, boolean alive) {
		this(x, y, size, alive, false);
	}

	private BriansBrainCell(int x, int y, int size, boolean alive, boolean dying) {
		super(x, y, size);

		isAlive = alive;
		isDying = dying;
	}

	public void update(int livingNeighbors) {
		if (livingNeighbors == 2 && !isAlive && !isDying) {
			isAlive = true;
			isDying = false;
		} else if (isAlive && !isDying) {
			isAlive = false;
			isDying = true;
		} else {
			isAlive = false;
			isDying = false;
		}
	}

	public boolean isAlive() {
		return isAlive;
	}

	@Override
	public Color getColor() {
		if (isDying)
			return DYING_COLOR;

		if (isAlive)
			return ALIVE_COLOR;

		return DEAD_COLOR;
	}

	@Override
	public BriansBrainCell clone() {
		return new BriansBrainCell(x, y, size, isAlive, isDying);

	}
}
