package de.openhpi.capstone1.game.starter;



import de.openhpi.capstone1.game.view.AbstractView;
import de.openhpi.capstone1.game.view.BallView;
import processing.core.PApplet;

public class TheApp extends PApplet {
	
	private AbstractView ballView;
	
	
	@Override
	public void settings() {
		size(500,500);
	}

	@Override
	public void setup() {  // setup() runs once
		frameRate(30);
		ballView = new BallView(this);
		
	}

	@Override
	public void draw() {  // draw() loops forever, until stopped

	}
	
	//Add further user interaction as necessary
	@Override
	public void mouseClicked() {
		ballView.update();
	}
}
