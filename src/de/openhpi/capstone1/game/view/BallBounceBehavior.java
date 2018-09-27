package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.builder.InteractiveComponent;
import processing.core.PApplet;

public class BallBounceBehavior extends UpdateBehavior {
	
	public BallBounceBehavior(PApplet display, InteractiveComponent ic) {
		super(display, ic);
		update();
	}

	@Override
	public void update( ) {
//		ic.xpos = ic.xpos + (ic.speed * ic.xdirection);
//		ic.ypos = ic.ypos + (ic.speed * ic.ydirection);
//			if (ic.xpos > display.width - ic.rad ||ic.xpos < ic.rad) { // if the ball reaches left or right screen side, then bounce
//				ic.xdirection *= -1;
//		}
//		if (ic.ypos < ic.rad) {// if the ball reaches top of the screen, then bounce
//			ic.ydirection *= -1;
//		}
//	        
//		if (ic.ypos > display.height + ic.rad) {// if the ball is out, then generate a new ball
//			ic.xpos=display.random(0, display.width);
//			display.fill(display.random(255),display.random(255), display.random(255));
//			ic.ypos=220;
//		}
//		display.ellipse(ic.xpos,ic.ypos, ic.rad, ic.rad);

	};
	
	

}
