package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.view.UpdateBehavior;

public abstract class InteractiveComponent {
	//public abstract void handleEvent();
	protected UpdateBehavior[] views; 
	
	UpdateBehavior bV;//= new BallView(display);
	
//	public void update() {
//		for (UpdateBehavior view : views) {
//			view.update(); 
//		}
//	}
	
	public void update() {
		bV.update(); 
	}

}
