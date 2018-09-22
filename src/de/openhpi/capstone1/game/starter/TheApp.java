package de.openhpi.capstone1.game.starter;

import de.openhpi.capstone1.game.view.AbstractView;
import de.openhpi.capstone1.game.view.BallView;
import de.openhpi.capstone1.game.view.BrickView;
import de.openhpi.capstone1.game.view.PaddleView;
import processing.core.PApplet;

public class TheApp extends PApplet {

	private AbstractView ballView;
	private AbstractView brickView;
	private AbstractView paddleView;
	int rad = 25; // radius of the ball
	float xpos = 200, ypos = 119; // Starting position of shape

	float xspeed = 6; // Speed of the shape
	float yspeed = 6; // Speed of the shape

	int xdirection = 1; // Left to Right
	int ydirection = 1; // Top to Bottom
	int dragX = 190;

	int paddleX = 190;
	int paddleY = 580;
	int paddleWidth = 100;
	int paddleHeight = 25;

	@Override
	public void settings() {
		size(480, 640);
	}

	@Override
	public void setup() { // setup() runs once
		frameRate(30);
		fill(153, 0, 153);// lila color
		ellipseMode(RADIUS);
		//ballView = new BallView(this);
		brickView = new BrickView(this);
		//paddleView = new PaddleView(this);
	}

	@Override
	public void draw() { // draw() loops forever, until stopped
		background(204);
		// ballView.update();
		// brickView.update();
		// paddleView.update();
		dragX = mouseX;
		rect(paddleX, paddleY, paddleWidth, paddleHeight);

		xpos = xpos + (xspeed * xdirection);
		ypos = ypos + (yspeed * ydirection);
		if (dragX <= 0) { // if the mouse goes beyond the left side of the canvas
			dragX = 0; // then set the paddle to the left-most edge of the canvas
		} else if (dragX >= width - paddleWidth) { // if the mouse goes beyond the right side of the canvas/
			dragX = width - paddleWidth; // then set the paddle to the right-most edge of the canvas
		}
		// Test to see if the shape exceeds the boundaries of the screen
		// If it does, reverse its direction by multiplying by -1
		if (xpos > width - rad || xpos < rad) { // if the ball reaches left or right screen side, then bounce
			xdirection *= -1;
		}
		if (ypos < rad) {// if the ball reaches top of the screen, then bounce
			ydirection *= -1;
		}
		if ((ypos > paddleY - rad && (xpos >= paddleX && xpos <= paddleX + paddleWidth)) && ypos < paddleY) {
			ydirection *= -1;
		}
		if ((xpos > paddleX - rad && (ypos >= paddleY && ypos <= paddleY + paddleHeight))
				&& (xpos < paddleX + paddleWidth + rad)) { // if the ball reaches left or right paddle side, then bounce
			xdirection *= -1;
		}
		if (ypos > height + rad) {// if the ball is out, then generate a new ball
			xpos = random(0, width);
			ypos = 220;
			fill(random(255), random(255), random(255));
		}
		
		paddleX = dragX;

		ellipse(xpos, ypos, rad, rad);

	}

//	// Add further user interaction as necessary
//	@Override
//	public void mouseClicked() {
//		ballView.update();
//
//	}

}
