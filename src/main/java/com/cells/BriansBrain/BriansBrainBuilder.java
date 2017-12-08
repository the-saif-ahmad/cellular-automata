package com.cells.BriansBrain;

import com.cells.Builder;
import com.cells.CellularAutomaton;

public class BriansBrainBuilder extends Builder {
	public BriansBrainBuilder(int width, int height, int size, boolean isCircular) {
		super(width, height, size, isCircular);
	}

	@Override
	public CellularAutomaton build() {
		return new BriansBrain(this);
	}
}
