package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.builder.InteractiveComponent;
import de.openhpi.capstone1.game.builder.Subject;
import processing.core.PApplet;

public abstract class UpdateBehavior {
	protected PApplet display;
	protected InteractiveComponent ic;

	public UpdateBehavior(PApplet display,Subject subject) {
		this.display = display;
		this.ic=(InteractiveComponent)subject;
		subject.attach(this);
	}
	
	public abstract void update();

}
