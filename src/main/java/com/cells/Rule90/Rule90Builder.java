package com.cells.Rule90;

import com.cells.Builder;
import com.cells.CellularAutomaton;

public class Rule90Builder extends Builder {
	public Rule90Builder(int width, int height, int size, boolean isCircular) {
		super(width, height, size, isCircular);
	}

	@Override
	public CellularAutomaton build() {
		return new Rule90(this);
	}
}
