package de.openhpi.capstone1.game.starter;

import de.openhpi.capstone1.game.builder.Ball;
import de.openhpi.capstone1.game.builder.InteractiveComponent;
import de.openhpi.capstone1.game.builder.Paddle;
import processing.core.PApplet;

public class TheApp extends PApplet {

	private InteractiveComponent ball;
	private InteractiveComponent paddle;
	private int paddleWidth;
	private int paddleHeight;

	@Override
	public void settings() {
		size(480, 640);
	}

	@Override
	public void setup() { // setup() runs once
		frameRate(30);
		fill(153, 0, 153);// initial: lila color
//		ellipseMode(RADIUS);
		ball = new Ball(this);
		paddle = new Paddle(this);
	}

	@Override
	public void draw() { // draw() loops forever, until stopped
		background(255);
		ball.updatePosition();
		paddle.setXpos(mouseX);
		paddle.updatePosition();

		paddleWidth=paddle.rad*4;
		paddleHeight=paddle.rad;
		ball.xpos = ball.xpos + (ball.speed * ball.xdirection);
		ball.ypos = ball.ypos + (ball.speed * ball.ydirection);
		// // Test to see if the shape exceeds the boundaries of the screen
		// If it does, reverse its direction by multiplying by -1
		if (ball.xpos > width - ball.rad || ball.xpos < ball.rad) { // if the ball reaches left or right screen side,
																	// then bounce
			ball.xdirection *= -1;
		}
		if (ball.ypos < ball.rad) {// if the ball reaches top of the screen, then bounce
			ball.ydirection *= -1;
		}

		// collision if the ball if flying from the top onto the paddle
		if (ball.ypos + ball.rad > paddle.ypos && ball.ypos < paddle.ypos && ball.xpos >= paddle.xpos
				&& ball.xpos <= (paddle.xpos + paddleWidth)) {
			ball.ydirection *= -1;
			ball.ypos = paddle.ypos - ball.rad;
		}

		// if the ball reaches left or right paddle side, then bounces
		if (ball.ypos >= paddle.ypos && ball.ypos <= paddle.ypos + paddleHeight) {
			// the ball is on the same height as the paddle
			// check if it is a collision
			if (ball.xpos + ball.rad > paddle.xpos && ball.xpos - ball.rad < paddle.xpos + paddleWidth) {
				ball.xdirection *= -1;

				// if it is a collision, check if on the right
				int distToRightPaddleEdge = (int) abs((paddle.xpos + paddleWidth) - (ball.xpos - ball.rad));
				int distToLeftPaddleEdge = (int) abs(ball.xpos + ball.rad - paddle.xpos);
				if (distToLeftPaddleEdge < distToRightPaddleEdge) {
					// reset the ball to the left edge to be sure it's not INSIDE the paddle
					ball.xpos = paddle.xpos - ball.rad;
				} else {
					// reset the ball to the right edge to be sure it's not INSIDE the paddle
					ball.xpos = paddle.xpos + paddleWidth + ball.rad;
				}
			}
		}

		// if the ball is out, then generate a new ball
		if (ball.ypos > height + ball.rad) {
			ball.xpos = random(0, width);
			ball.ypos = 220;
			fill(random(255), random(255), random(255));
		}

		//paddleX = dragX;

		ellipse(ball.xpos, ball.ypos, ball.rad, ball.rad);

	}

	// Add further user interaction as necessary
//	@Override
//	public void mouseClicked() {
//		ball.updatePosition();
//		paddle.updatePosition();
//	}

}
