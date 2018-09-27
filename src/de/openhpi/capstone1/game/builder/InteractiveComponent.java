package de.openhpi.capstone1.game.builder;

import java.util.ArrayList;
import java.util.List;

import de.openhpi.capstone1.game.view.UpdateBehavior;

public abstract class InteractiveComponent implements Subject {
	private List<UpdateBehavior> views = new ArrayList<UpdateBehavior>();
	private float xpos, ypos; // Starting position of shape
	UpdateBehavior bV; // update behavior of the shape

	public float getXpos() {
		return xpos;
	}

	public float getYpos() {
		return ypos;
	}

	public void setXpos(float xpos) {
		this.xpos = xpos;
	}

	public void setYpos(float ypos) {
		this.ypos = ypos;
	}

	public void notifyAllObservers() {
		for (UpdateBehavior view : views) {
			view.update();
		}
	}

	public void attach(UpdateBehavior view) {
		views.add(view);
	}

	public abstract void updatePosition();
}