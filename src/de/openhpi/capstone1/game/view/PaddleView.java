package de.openhpi.capstone1.game.view;

import processing.core.PApplet;

public class PaddleView implements AbstractView {
	protected PApplet display;
	int dragX;

	int paddleX = 190;
	int paddleY = 580;
	int paddleWidth = 100;
	int paddleHeight = 25;

	public PaddleView(PApplet display) {
		//super(display);
		this.display = display;
	}

	@Override
	public void update() {
		display.fill(255, 255, 255); // white color
		dragX = display.mouseX; // read current mouse x-axis position

		if (dragX <= 0) { // if the mouse goes beyond the left side of the canvas
			dragX = 0; // then set the paddle to the left-most edge of the canvas
		} else if (dragX >= display.width - paddleWidth) { // if the mouse goes beyond the right side of the canvas/
			dragX = display.width - paddleWidth; // then set the paddle to the right-most edge of the canvas
		}
		paddleX = dragX;
		display.rect(paddleX, paddleY, paddleWidth, paddleHeight); // x-axis, y-axis, length, height
	}

}
