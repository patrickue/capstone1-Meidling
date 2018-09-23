package de.openhpi.capstone1.game.view;

import processing.core.PApplet;

public abstract class UpdateBehavior {
	protected PApplet display;

	public UpdateBehavior(PApplet display) {
		this.display = display;
	}

	public abstract void update();

}
