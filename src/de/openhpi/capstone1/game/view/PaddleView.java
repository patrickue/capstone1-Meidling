package de.openhpi.capstone1.game.view;

import processing.core.PApplet;

public class PaddleView extends AbstractView {
	// protected PApplet display;
	int dragX;


	public PaddleView(PApplet display) {
		super(display); 
	}


	
	@Override
	public void update() {
		display.fill(255, 255, 255); // white color
		dragX=display.mouseX; //read current mouse x-axis position
		
		if (dragX<=0) { //if the mouse goes beyond the left side of the canvas
			dragX=0; //then set the paddle to the left-most edge of the canvas
		}else if (dragX>=400) { //if the mouse goes beyond the right side of the canvas
			dragX=400; //then set the paddle to the right-most edge of the canvas
		}
		display.rect(dragX, 580, 80, 15); //x-axis, y-axis, length, height
		}


	

}
