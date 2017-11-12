package com.cells;

import java.awt.Color;

public abstract class Cell {
	protected int size;
	protected int x;
	protected int y;

	public Cell(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int value) {
		size = value;
	}

	public int getX() {
		return x;
	}

	public void setX(int value) {
		x = value;
	}

	public int getY() {
		return y;
	}

	public void setY(int value) {
		y = value;
	}

	public abstract Color getColor();
	public abstract Cell clone();
}
