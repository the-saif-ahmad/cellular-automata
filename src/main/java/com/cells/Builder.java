package com.cells;

import com.cells.*;

public abstract class Builder {
	protected int width;
	protected int height;
	protected int size;
	protected boolean isCircular;

	public Builder(int width, int height, int size, boolean isCircular) {
		this.width = width;
		this.height = height;
		this.size = size;
		this.isCircular = isCircular;
	}

	public int width() {
		return width;
	}

	public int height() {
		return height;
	}

	public int size() {
		return size;
	}

	public boolean isCircular() {
		return isCircular;
	}

	public abstract CellularAutomaton build();
}
