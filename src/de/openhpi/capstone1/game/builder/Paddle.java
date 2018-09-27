package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.view.PaddleDragBehavior;
import processing.core.PApplet;

public class Paddle extends InteractiveComponent {
	public Paddle(PApplet display){
		rad=25;
		xpos=200;
		ypos=580;
		bV=new PaddleDragBehavior(display,this);
		
	}

	public void updatePosition() {
		bV.update();
	}
	
	public void setXpos(int mouseX) {
	this.xpos=mouseX;
}
}
