package de.openhpi.capstone1.game.view;

import processing.core.PApplet;

public class BallView extends AbstractView {
	// protected PApplet display;

	public BallView(PApplet display) {
		super(display);
	}

	@Override
	public void update() {
		display.background(204);
		display.fill(153, 0, 153); // lila color
		display.ellipse(120, 120, 50, 50); // first two values define the position, second two values - the size
		display.redraw();
	};
}
