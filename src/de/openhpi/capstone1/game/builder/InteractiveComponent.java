package de.openhpi.capstone1.game.builder;

import java.util.ArrayList;
import java.util.List;

import de.openhpi.capstone1.game.view.UpdateBehavior;

public abstract class InteractiveComponent implements Subject {
	// public abstract void handleEvent();
	// protected UpdateBehavior[] views;
	private List<UpdateBehavior> views = new ArrayList<UpdateBehavior>();

	public float xpos, ypos; // Starting position of shape
//	public float speed; // Speed of the shape

//	public int xdirection; // Left to Right
//	public int ydirection; // Top to Bottom
	UpdateBehavior bV;

	public void notifyAllObservers() {
		for (UpdateBehavior view : views) {
			view.update();
		}
	}

	public void attach(UpdateBehavior view) {
		views.add(view);
	}



	public float getXpos() {
		return xpos;
	}

	public float getYpos() {
		return ypos;
	}
	
	public void setXpos(float xpos) {
		this.xpos=xpos;
	}
	public void setYpos(float ypos) {
		this.ypos=ypos;
	}

//	public int getRad() {
//		return rad;
//	}
//	public void setRad(int rad) {
//		this.rad=rad;
//	}
	

	
//	public float getSpeed() {
//		return speed;
//	}
//	public void setSpeed(int speed) {
//		this.speed=speed;
//	}
//	
//	public int getXdirection() {
//		return xdirection;
//	}
//
//	public void setXdirection(int xdirection) {
//		this.xdirection = xdirection;
//	}
//
//	public int getYdirection() {
//		return ydirection;
//	}
//
//	public void setYdirection(int ydirection) {
//		this.ydirection = ydirection;
//	}
	
	public abstract void updatePosition();
}