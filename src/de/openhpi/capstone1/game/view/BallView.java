package de.openhpi.capstone1.game.view;

import processing.core.PApplet;

public class BallView extends AbstractView {
	// protected PApplet display;
    int rad = 25;        // radius of the ball
    float xpos=200, ypos=119;    // Starting position of shape    

    float xspeed = 6;  // Speed of the shape
    float yspeed = 6;  // Speed of the shape

    int xdirection = -1;  // Left to Right
    int ydirection = 1;  // Top to Bottom

	public BallView(PApplet display) {
		super(display);
	}

	@Override
	public void update() {
		display.ellipseMode(display.RADIUS);
		//display.background(204);
		display.fill(153, 0, 153); // lila color
//		
//		display.ellipse(120, 120, 50, 50); // first two values define the position, second two values - the size
//		display.redraw();
		xpos = xpos + ( xspeed * xdirection );
	      ypos = ypos + ( yspeed * ydirection );
	      if (xpos > display.width-rad || xpos < rad) { //if the ball reaches left or right screen side, then bounce
	          xdirection *= -1;
	        }
	        if (ypos < rad) {//if the ball reaches top of the screen, then bounce
	          ydirection *= -1;
	        }
//Comment next 3 lines, so that the ball can dissappear through the bottom	        
	        if (ypos > display.height-rad) {//if the ball reaches the bottom of the screen, then bounce
		          ydirection *= -1;
		        }
	        display.ellipse(xpos, ypos, rad, rad);
	};
}
