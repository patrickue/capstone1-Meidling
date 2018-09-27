package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.builder.InteractiveComponent;
import de.openhpi.capstone1.game.builder.Paddle;
import processing.core.PApplet;

public class PaddleDragBehavior extends UpdateBehavior {
	private int dragX;
	Paddle paddle;

	public PaddleDragBehavior(PApplet display, InteractiveComponent ic) {
		super(display, ic);
		paddle=(Paddle)ic;
		update();
	}

	@Override
	public void update() {
		System.out.println("dragX: "+dragX+", display.width - paddleWidth"+(display.width - paddle.paddleWidth));
		dragX = display.mouseX;
		if (dragX <= 0) { // if the mouse goes beyond the left side of the canvas
			dragX = 0; // then set the paddle to the left-most edge of the canvas
		} else if (dragX >= display.width - paddle.paddleWidth) { // if the mouse goes beyond the right side of the canvas/
			dragX = display.width - paddle.paddleWidth; // then set the paddle to the right-most edge of the canvas
		}
		display.rect(dragX, ic.ypos, paddle.paddleWidth, paddle.paddleHeight);
	}
}
