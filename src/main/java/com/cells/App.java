package com.cells;

import com.cells.ConwaysGame.*;
import com.cells.LangtonsAnt.*;

public class App {
	public static final int cellsX = 700;
	public static final int cellsY = 700;
	public static final int cellSize = 1;
	public static int SELECTED = 0;

	public static final CellularAutomata[] cellAutos = new CellularAutomata[] {
		new ConwaysGame(cellsX, cellsY, cellSize, true),
		new LangtonsAnt(cellsX, cellsY, cellSize, true)
	};

	public static void main(String[] args) {
		Window window = new Window(cellsX * cellSize, cellsY * cellSize, cellAutos[SELECTED].clone());
	}
}
