package com.cells.ConwaysGame;

import com.cells.Builder;
import com.cells.CellularAutomaton;

public class ConwaysGameBuilder extends Builder {
	public ConwaysGameBuilder(int width, int height, int size, boolean isCircular) {
		super(width, height, size, isCircular);
	}

	@Override
	public CellularAutomaton build() {
		return new ConwaysGame(this);
	}
}
