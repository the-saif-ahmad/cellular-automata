package com.cells.LangtonsAnt;

import com.cells.Builder;
import com.cells.CellularAutomaton;

public class LangtonsAntBuilder extends Builder {
	public LangtonsAntBuilder(int width, int height, int size, boolean isCircular) {
		super(width, height, size, isCircular);
	}

	@Override
	public CellularAutomaton build() {
		return new LangtonsAnt(this);
	}
}
