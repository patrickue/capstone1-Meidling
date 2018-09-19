package de.openhpi.capstone1.game.starter;

import de.openhpi.capstone1.game.view.AbstractView;
import de.openhpi.capstone1.game.view.BallView;
import de.openhpi.capstone1.game.view.BrickView;
import processing.core.PApplet;

public class TheApp extends PApplet {

	private AbstractView ballView;
	private AbstractView brickView;
	
	@Override
	public void settings() {
		size(480, 640);
	}

	@Override
	public void setup() { // setup() runs once
		frameRate(30);
		ballView = new BallView(this);
		brickView = new BrickView(this);
		
	}

	@Override
	public void draw() { // draw() loops forever, until stopped
		brickView.update();
	}

	// Add further user interaction as necessary
	@Override
	public void mouseClicked() {
		ballView.update();
	}

}
