package com.cells.DayAndNight;

import com.cells.Builder;
import com.cells.CellularAutomaton;

public class DayAndNightBuilder extends Builder {
	public DayAndNightBuilder(int width, int height, int size, boolean isCircular) {
		super(width, height, size, isCircular);
	}

	@Override
	public CellularAutomaton build() {
		return new DayAndNight(this);
	}
}
