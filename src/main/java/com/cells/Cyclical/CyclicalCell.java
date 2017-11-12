package com.cells.Cyclical;

import com.cells.*;
import java.awt.Color;

public class CyclicalCell extends Cell {
	public static final Color[] COLORS = new Color[16];

	private int color;

	public CyclicalCell(int x, int y, int size, int color) {
		super(x, y, size);

		this.color = color;

		for (int i = 0; i < COLORS.length; i++) {
			int c = i * 255 / (COLORS.length - 1);
			COLORS[i] = new Color(c, c, c);
		}
	}

	public void update(Cell[] neighbors) {
		if (hasNextNeighbor(neighbors))
			color = (color + 1) % COLORS.length;
	}

	private boolean hasNextNeighbor(Cell[] neighbors) {
		int next = (color + 1) % COLORS.length;

		for (Cell c : neighbors)
			if (c.getColor().equals(COLORS[next]))
				return true;

		return false;
	}

	@Override
	public Color getColor() {
		return COLORS[color];
	}

	@Override
	public CyclicalCell clone() {
		return new CyclicalCell(x, y, size, color);

	}
}
