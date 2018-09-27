package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.view.BallBounceBehavior;

import processing.core.PApplet;

public class Ball extends InteractiveComponent {
	private int rad; // radius of the ball
	private float speed; // Speed of the shape for both x & y dimensions
	private int xdirection; // X-Direction
	private int ydirection; // Y-Direction

	public Ball(PApplet display) {
		rad = 25; // radius of the ball
		setXpos(200);// Starting x-position of shape
		setYpos(220); // Starting y-position of shape
		speed = 6;

		xdirection = 1; // Direction from Left to Right
		ydirection = 1; // Direction from Top to Bottom
		display.ellipseMode(PApplet.RADIUS);
		bV = new BallBounceBehavior(display, this);
	}

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getXdirection() {
		return xdirection;
	}

	public void setXdirection(int xdirection) {
		this.xdirection = xdirection;
	}

	public int getYdirection() {
		return ydirection;
	}

	public void setYdirection(int ydirection) {
		this.ydirection = ydirection;
	}

	public void updatePosition() {
		bV.update();

	}
}
