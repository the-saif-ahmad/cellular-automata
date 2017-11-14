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

	public static final CellularAutomaton[] cellAutos = new CellularAutomaton[] {
		new ConwaysGame(cellsX, cellsY, cellSize, true),
		new LangtonsAnt(cellsX, cellsY, cellSize, true),
		new BriansBrain(cellsX, cellsY, cellSize, true),
		new Rule90(cellsX, cellsY, cellSize, false),
		new Cyclical(cellsX, cellsY, cellSize, true),
		new DayAndNight(cellsX, cellsY, cellSize, true)
	};

	public static void main(String[] args) {

		Window window = new Window(cellsX * cellSize, cellsY * cellSize, cellAutos[SELECTED].clone());
	}
}
