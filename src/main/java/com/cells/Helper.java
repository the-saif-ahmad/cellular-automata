package com.cells;

import java.util.Random;

public class Helper {
	public static Random random = new Random();

	public static int increment(int value, int cap, boolean isCircular) {
		if (isCircular)
			return (value + 1) % cap;
		else
			return value + 1 == cap ? value : value + 1;
	}

	public static int decrement(int value, int wrap, boolean isCircular) {
		if (isCircular)
			return decrement(value, wrap);
		else
			return decrement(value);
	}

	public static int decrement(int value, int wrap) {
		return value - 1 < 0 ? wrap : value - 1;
	}

	public static int decrement(int value) {
		return value - 1 < 0 ? 0 : value - 1;
	}
}
