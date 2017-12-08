package com.cells.Cyclical;

import com.cells.Builder;
import com.cells.CellularAutomaton;

public class CyclicalBuilder extends Builder {
	public CyclicalBuilder(int width, int height, int size, boolean isCircular) {
		super(width, height, size, isCircular);
	}

	@Override
	public CellularAutomaton build() {
		return new Cyclical(this);
	}
}
