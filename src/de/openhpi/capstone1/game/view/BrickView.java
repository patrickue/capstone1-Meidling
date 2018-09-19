package de.openhpi.capstone1.game.view;

import processing.core.PApplet;

public class BrickView extends AbstractView {
	// protected PApplet display;

	public BrickView(PApplet display) {
		super(display);
	}

	@Override
	public void update() {

		display.background(150);
		display.fill(0);
		for (int i = 15; i <= 450; i = i + 35) {
			for (int j = 10; j <= 180; j = j + 15) {
				display.rect(i, j, 30, 10); // PosX, PosY, Size, Size
				display.redraw();
			}
		}
	}

};
