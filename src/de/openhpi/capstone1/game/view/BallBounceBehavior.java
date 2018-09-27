package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.builder.Ball;
import de.openhpi.capstone1.game.builder.InteractiveComponent;
import processing.core.PApplet;

public class BallBounceBehavior extends UpdateBehavior {
	Ball ic;
	
	public BallBounceBehavior(PApplet display, InteractiveComponent ic2) {
		super(display, ic2);
		ic=(Ball)ic2;
		update();
	}

	@Override
	public void update( ) {
		ic.setXpos(ic.getXpos() + (ic.getSpeed() * ic.getXdirection()));
		ic.setYpos(ic.getYpos() + (ic.getSpeed() * ic.getYdirection()));
		if (ic.getXpos() > display.width - ic.getRad() || ic.getXpos() < ic.getRad()) { // if the ball reaches left or right screen side, then bounce
				ic.setXdirection(ic.getXdirection() * -1);
		}
		if (ic.getYpos() < ic.getRad()) {// if the ball reaches top of the screen, then bounce
			ic.setYdirection(ic.getYdirection() * -1);
		}
	        
		if (ic.getYpos() > display.height + ic.getRad()) {// if the ball is out, then generate a new ball with random color
			ic.setXpos(display.random(0, display.width));
			display.fill(display.random(255),display.random(255), display.random(255));
			ic.setYpos(220);
		}
		display.ellipse(ic.getXpos(),ic.getYpos(), ic.getRad(), ic.getRad());

	};
	
	

}
