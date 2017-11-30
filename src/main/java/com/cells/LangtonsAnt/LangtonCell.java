package com.cells.LangtonsAnt;

import com.cells.*;
import java.awt.Color;

public class LangtonCell extends Cell {
	private static final LangtonRule[] rules = new LangtonRule[] {
		new LangtonRule(Color.BLACK, 3), // turn left
		new LangtonRule(Color.WHITE, 1), // turn right
		new LangtonRule(Color.GREEN, 1),
		new LangtonRule(Color.MAGENTA, 3)
	};

	private int rule;

	public LangtonCell(int x, int y, int size) {
		super(x, y, size);

		rule = 0;
	}

	private LangtonCell(int x, int y, int size, int rule) {
		super(x, y, size);

		this.rule = rule;
	}

	public void update() {
		rule = (rule + 1) % rules.length;
	}

	public int getDirection() {
		return rules[rule].direction;
	}

	@Override
	public LangtonCell clone() {
		return new LangtonCell(x, y, size, rule);
	}

	@Override
	public Color getColor() {
		return rules[rule].color;
	}
}
