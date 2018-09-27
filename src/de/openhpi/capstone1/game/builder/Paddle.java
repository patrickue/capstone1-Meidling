package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.view.PaddleDragBehavior;
import processing.core.PApplet;

public class Paddle extends InteractiveComponent {
	private int paddleWidth;
	private int paddleHeight;
	
	public Paddle(PApplet display){
		setXpos(200);
		setYpos(580);
		paddleWidth=100;
		paddleHeight=25;
		bV=new PaddleDragBehavior(display,this);
		
	}

	public void updatePosition() {
		bV.update();
	}
	
	public int getPaddleWidth() {
		return paddleWidth;
	}

	public void setPaddleWidth(int paddleWidth) {
		this.paddleWidth = paddleWidth;
	}

	public int getPaddleHeight() {
		return paddleHeight;
	}

	public void setPaddleHeight(int paddleHeight) {
		this.paddleHeight = paddleHeight;
	}
}
