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
		paddle.updatePosition();

		// In the next piece of code the interaction between ball and paddle is handled
		// collision if the ball if flying from the top onto the paddle
		if (ball.getYpos() + ball.getRad() > paddle.getYpos() && ball.getYpos() < paddle.getYpos()
				&& ball.getXpos() >= paddle.getXpos()
				&& ball.getXpos() <= (paddle.getXpos() + paddle.getPaddleWidth())) {
			ball.setYdirection(ball.getYdirection() * -1);
			ball.setYpos(paddle.getYpos() - ball.getRad());
		}

		// if the ball reaches left or right paddle side, then bounces
		if (ball.getYpos() >= paddle.getYpos() && ball.getYpos() <= paddle.getYpos() + paddle.getPaddleHeight()) {
			// the ball is on the same height as the paddle
			// check if it is a collision
			if (ball.getXpos() + ball.getRad() > paddle.getXpos()
					&& ball.getXpos() - ball.getRad() < paddle.getXpos() + paddle.getPaddleWidth()) {
				ball.setXdirection(ball.getXdirection() * -1);

				// if it is a collision, check if on the right
				int distToRightPaddleEdge = (int) abs(
						(paddle.getXpos() + paddle.getPaddleWidth()) - (ball.getXpos() - ball.getRad()));
				int distToLeftPaddleEdge = (int) abs(ball.getXpos() + ball.getRad() - paddle.getXpos());
				if (distToLeftPaddleEdge < distToRightPaddleEdge) {
					// reset the ball to the left edge to be sure it's not INSIDE the paddle
					ball.setXpos(paddle.getXpos() - ball.getRad());
				} else {
					// reset the ball to the right edge to be sure it's not INSIDE the paddle
					ball.setXpos(paddle.getXpos() + paddle.getPaddleWidth() + ball.getRad());
				}
			}
		}

	}

}
