package de.openhpi.capstone1.game.starter;

import de.openhpi.capstone1.game.builder.Ball;
import de.openhpi.capstone1.game.builder.Paddle;
import processing.core.PApplet;

public class TheApp extends PApplet {

	private Ball ball;
	private Paddle paddle;

	@Override
	public void settings() {
		size(480, 640);
	}

	@Override
	public void setup() { // setup() runs once
		frameRate(30);
		fill(153, 0, 153);// initial: lila color
		ball = new Ball(this);
		paddle = new Paddle(this);
	}

	@Override
	public void draw() { // draw() loops forever, until stopped
		background(255);
		ball.updatePosition();
		paddle.setXpos(mouseX);
		paddle.updatePosition();

		// collision if the ball if flying from the top onto the paddle
		if (ball.ypos + ball.rad > paddle.ypos && ball.ypos < paddle.ypos && ball.xpos >= paddle.xpos
				&& ball.xpos <= (paddle.xpos + paddle.paddleWidth)) {
			ball.ydirection *= -1;
			ball.ypos = paddle.ypos - ball.rad;
		}

		// if the ball reaches left or right paddle side, then bounces
		if (ball.ypos >= paddle.ypos && ball.ypos <= paddle.ypos + paddle.paddleHeight) {
			// the ball is on the same height as the paddle
			// check if it is a collision
			if (ball.xpos + ball.rad > paddle.xpos && ball.xpos - ball.rad < paddle.xpos + paddle.paddleWidth) {
				ball.xdirection *= -1;

				// if it is a collision, check if on the right
				int distToRightPaddleEdge = (int) abs((paddle.xpos + paddle.paddleWidth) - (ball.xpos - ball.rad));
				int distToLeftPaddleEdge = (int) abs(ball.xpos + ball.rad - paddle.xpos);
				if (distToLeftPaddleEdge < distToRightPaddleEdge) {
					// reset the ball to the left edge to be sure it's not INSIDE the paddle
					ball.xpos = paddle.xpos - ball.rad;
				} else {
					// reset the ball to the right edge to be sure it's not INSIDE the paddle
					ball.xpos = paddle.xpos + paddle.paddleWidth + ball.rad;
				}
			}
		}

	}


}
