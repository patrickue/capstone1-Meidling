package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.view.PaddleDragBehavior;
import processing.core.PApplet;

public class Paddle extends InteractiveComponent {
	public int paddleWidth;
	public int paddleHeight;
	
	public Paddle(PApplet display){
		xpos=200;
		ypos=580;
		paddleWidth = 100;
		paddleHeight = 25;
		bV=new PaddleDragBehavior(display,this);
		
	}

	public void updatePosition() {
		bV.update();
	}
	
	public void setXpos(int mouseX) {
	this.xpos=mouseX;
}
}
