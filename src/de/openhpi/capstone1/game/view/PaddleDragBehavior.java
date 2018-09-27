package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.builder.InteractiveComponent;
import de.openhpi.capstone1.game.builder.Paddle;
import processing.core.PApplet;

public class PaddleDragBehavior extends UpdateBehavior {
	Paddle paddle;

	public PaddleDragBehavior(PApplet display, InteractiveComponent ic) {
		super(display, ic);
		paddle = (Paddle) ic;
		update();
	}

	@Override
	public void update() {
		paddle.setXpos(display.mouseX); // set x-position of a paddle to the current X-coordinate of mouse
		if (paddle.getXpos() <= 0) { // if the mouse goes beyond the left side of the canvas
			paddle.setXpos(0); // then set the paddle to the left-most edge of the canvas
		} else if (paddle.getXpos() >= display.width - paddle.getPaddleWidth()) { // if the mouse goes beyond the right
																					// side of the canvas/
			paddle.setXpos(display.width - paddle.getPaddleWidth()); // then set the paddle to the right-most edge of
																		// the canvas
		}
		display.rect(paddle.getXpos(), paddle.getYpos(), paddle.getPaddleWidth(), paddle.getPaddleHeight());
	}
}
