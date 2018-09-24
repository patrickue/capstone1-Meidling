package de.openhpi.capstone1.game.starter;

import de.openhpi.capstone1.game.builder.Ball;
import de.openhpi.capstone1.game.builder.InteractiveComponent;
import de.openhpi.capstone1.game.builder.Paddle;

import processing.core.PApplet;

public class TheApp extends PApplet {

	private InteractiveComponent ball;
	private InteractiveComponent paddle;

	@Override
	public void settings() {
		size(480, 640);
	}

	@Override
	public void setup() { // setup() runs once
		frameRate(30);
		fill(153, 0, 153);// lila color
		ellipseMode(RADIUS);

		ball =new Ball(this);
		paddle =new Paddle(this);
	}

	@Override
	public void draw() { // draw() loops forever, until stopped
		background(255);
		ball.updatePosition();
		paddle.setXpos(mouseX);
		paddle.updatePosition();
		// ballView.update();
		// brickView.update();
		// paddleView.update();
//		dragX = mouseX;
//		rect(paddleX, paddleY, paddleWidth, paddleHeight);
//
//		xpos = xpos + (xspeed * xdirection);
//		ypos = ypos + (yspeed * ydirection);
//		if (dragX <= 0) { // if the mouse goes beyond the left side of the canvas
//			dragX = 0; // then set the paddle to the left-most edge of the canvas
//		} else if (dragX >= width - paddleWidth) { // if the mouse goes beyond the right side of the canvas/
//			dragX = width - paddleWidth; // then set the paddle to the right-most edge of the canvas
//		}
//		// Test to see if the shape exceeds the boundaries of the screen
//		// If it does, reverse its direction by multiplying by -1
//		if (xpos > width - rad || xpos < rad) { // if the ball reaches left or right screen side, then bounce
//			xdirection *= -1;
//		}
//		if (ypos < rad) {// if the ball reaches top of the screen, then bounce
//			ydirection *= -1;
//		}
//	
//		//collision if the ball if flying from the top onto the paddle
//		if (ypos+rad > paddleY && ypos < paddleY && xpos >= paddleX && xpos <= (paddleX + paddleWidth)) 
//		{
//			ydirection *= -1;
//			ypos = paddleY-rad;
//		}
//		
//		// if the ball reaches left or right paddle side, then bounces
//		if(ypos >= paddleY && ypos <= paddleY + paddleHeight)
//		{
//			//the ball is on the same height as the paddle
//			//check if it is a collision
//			if (xpos+rad > paddleX && xpos-rad < paddleX + paddleWidth) { 
//				xdirection *= -1;
//				
//				//if it is a collision, check if on the right
//				int distToRightPaddleEdge = (int)abs((paddleX+paddleWidth) - (xpos-rad));
//				int distToLeftPaddleEdge = (int)abs(xpos+rad-paddleX);
//				if(distToLeftPaddleEdge < distToRightPaddleEdge)
//				{
//					//reset the ball to the left edge to be sure it's not INSIDE the paddle
//					xpos = paddleX-rad;
//				}
//				else 
//				{
//					//reset the ball to the right edge to be sure it's not INSIDE the paddle
//					xpos = paddleX+paddleWidth+rad;
//				}
//			}
//		}
//		
//		// if the ball is out, then generate a new ball
//		if (ypos > height + rad) {
//			xpos = random(0, width);
//			ypos = 220;
//			fill(random(255), random(255), random(255));
//		}
//		
//		paddleX = dragX;
//
//		ellipse(xpos, ypos, rad, rad);

	}

	// Add further user interaction as necessary
	@Override
	public void mouseClicked() {
		ball.updatePosition();
		paddle.updatePosition();
	}

}
