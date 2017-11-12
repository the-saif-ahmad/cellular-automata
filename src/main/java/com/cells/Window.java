package com.cells;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.InterruptedException;

public class Window extends JComponent implements Runnable, KeyListener {
	private JFrame frame;
	private Thread thread;
	private CellularAutomata cellAuto;
	private int stepsPerCycle;
	private int delay = 1;

	public Window(int width, int height, CellularAutomata cellAuto) {
		this(width, height, 1, cellAuto);
	}

	public Window(int width, int height, int stepsPerCycle, CellularAutomata cellAuto) {
		this.stepsPerCycle = stepsPerCycle < 1 ? 1 : stepsPerCycle;
		this.cellAuto = cellAuto;

		frame = new JFrame(cellAuto.getName());
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(this);
		frame.add(this);

		thread = new Thread(this, cellAuto.getName());
		thread.start();

		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}

	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < stepsPerCycle; i++)
				cellAuto.update();

			repaint();

			try {
				thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Cell[][] cells = cellAuto.getCells();

		for (Cell[] arr : cells) {
			for (Cell c : arr) {
				g.setColor(c.getColor());
				g.fillRect(c.getX(), c.getY(), c.getSize(), c.getSize());
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case (KeyEvent.VK_Q):
				System.exit(0);
				break;
			case (KeyEvent.VK_UP):
				delay = delay == 1 ? 1 : delay - 1;
				break;
			case (KeyEvent.VK_DOWN):
				delay++;
				break;
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case (KeyEvent.VK_LEFT):
				stepsPerCycle = stepsPerCycle == 1 ? 1 : stepsPerCycle / 2;
				break;
			case (KeyEvent.VK_RIGHT):
				stepsPerCycle *= 2;
				break;
			case (KeyEvent.VK_R):
				cellAuto = App.cellAutos[App.SELECTED].clone();
			case (KeyEvent.VK_B):
				App.SELECTED = Helper.decrement(App.SELECTED, App.cellAutos.length - 1, true);
				cellAuto = App.cellAutos[App.SELECTED].clone();
				break;
			case (KeyEvent.VK_N):
				App.SELECTED = Helper.increment(App.SELECTED, App.cellAutos.length - 1, true);
				cellAuto = App.cellAutos[App.SELECTED].clone();
				break;
			default:
				break;
		}
	}

	public void keyTyped(KeyEvent e) {

	}
}
