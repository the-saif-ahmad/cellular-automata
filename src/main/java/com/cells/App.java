package com.cells;

import com.cells.ConwaysGame.*;
import com.cells.LangtonsAnt.*;
import com.cells.BriansBrain.*;
import com.cells.Rule90.*;
import com.cells.Cyclical.*;
import com.cells.DayAndNight.*;

public class App {
	public static final int WIDTH = 900;
	public static final int HEIGHT = 750;
	public static final int cellSize = 3;
	public static final int cellsX = WIDTH / cellSize;
	public static final int cellsY = HEIGHT / cellSize;
	public static int SELECTED = 0;

	public static final Builder[] cellAutos = new Builder[] {
		new ConwaysGameBuilder(cellsX, cellsY, cellSize, true),
		new LangtonsAntBuilder(cellsX, cellsY, cellSize, true),
		new BriansBrainBuilder(cellsX, cellsY, cellSize, true),
		new Rule90Builder(cellsX, cellsY, cellSize, false),
		new CyclicalBuilder(cellsX, cellsY, cellSize, true),
		new DayAndNightBuilder(cellsX, cellsY, cellSize, true)
	};

	public static void main(String[] args) {
		Window window = new Window(cellsX * cellSize, cellsY * cellSize, cellAutos[SELECTED].build());
	}
}
