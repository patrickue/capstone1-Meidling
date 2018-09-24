package de.openhpi.capstone1.game.builder;

import java.util.ArrayList;
import java.util.List;

import de.openhpi.capstone1.game.view.UpdateBehavior;

public abstract class InteractiveComponent implements Subject{
	//public abstract void handleEvent();
	//protected UpdateBehavior[] views; 
	private List<UpdateBehavior> views=new ArrayList<UpdateBehavior>();
	public int rad; // radius of the ball
	public float xpos, ypos; // Starting position of shape
	public float xspeed; // Speed of the shape
	public float yspeed; // Speed of the shape

	public int xdirection; // Left to Right
	public int ydirection; // Top to Bottom
	UpdateBehavior bV;
	
	public void notifyAllObservers() {
		for (UpdateBehavior view : views) {
			view.update(); 
		}
	}
	
	public void attach(UpdateBehavior view) {
		views.add(view);
		}
	
//	public void update() {
		//bV.update(rad, xpos, ypos); 
//	}

	public abstract void updatePosition();
}