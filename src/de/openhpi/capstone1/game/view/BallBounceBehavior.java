package de.openhpi.capstone1.game.view;

import processing.core.PApplet;

public class BallBounceBehavior extends UpdateBehavior {
//	protected PApplet display;
	int rad = 25; // radius of the ball
	float xpos = 200, ypos = 220; // Starting position of shape

	float xspeed = 6; // Speed of the shape
	float yspeed = 6; // Speed of the shape

	int xdirection = 1; // Left to Right
	int ydirection = 1; // Top to Bottom

	public BallBounceBehavior(PApplet display) {
		super(display);
		//this.display = display;
	}

	@Override
	public void update() {
		display.ellipseMode(display.RADIUS);
		display.fill(0, 0, 0); // lila color
	
		xpos = xpos + (xspeed * xdirection);
		ypos = ypos + (yspeed * ydirection);
		if (xpos > display.width - rad || xpos < rad) { // if the ball reaches left or right screen side, then bounce
			xdirection *= -1;
		}
		if (ypos < rad) {// if the ball reaches top of the screen, then bounce
			ydirection *= -1;
		}
		
	        
		if (ypos > display.height + rad) {// if the ball is out, then generate a new ball
            xpos=display.random(0, display.width);
            ypos=220;
		}
		display.ellipse(xpos, ypos, rad, rad);
	};
}
