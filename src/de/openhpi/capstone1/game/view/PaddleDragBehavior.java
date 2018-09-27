package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.builder.InteractiveComponent;
import processing.core.PApplet;

public class PaddleDragBehavior extends UpdateBehavior {
	int dragX;
	int paddleWidth;
	int paddleHeight;

	public PaddleDragBehavior(PApplet display, InteractiveComponent ic) {
		super(display, ic);
		paddleWidth = ic.rad * 4;
		paddleHeight = ic.rad;
		update();
	}

	@Override
	public void update() {
		System.out.println("dragX: "+dragX+", display.width - paddleWidth"+(display.width - paddleWidth));
		dragX = display.mouseX;
		if (dragX <= 0) { // if the mouse goes beyond the left side of the canvas
			dragX = 0; // then set the paddle to the left-most edge of the canvas
		} else if (dragX >= display.width - paddleWidth) { // if the mouse goes beyond the right side of the canvas/
			dragX = display.width - paddleWidth; // then set the paddle to the right-most edge of the canvas
		}
		display.rect(dragX, ic.ypos, paddleWidth, paddleHeight);
	}
}
