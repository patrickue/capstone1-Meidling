package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.view.BallBounceBehavior;

import processing.core.PApplet;

public class Ball extends InteractiveComponent {

	public Ball(PApplet display){
		rad=25; // radius of the ball
		xpos=200;
		ypos=220; // Starting position of shape
		speed=6; // Speed of the shape

		xdirection=1; // Left to Right
		ydirection=1; // Top to Bottom
		display.ellipseMode(PApplet.RADIUS);
		bV=new BallBounceBehavior(display,this);
		
	}
	public void updatePosition() {
		bV.update();

	}
}
