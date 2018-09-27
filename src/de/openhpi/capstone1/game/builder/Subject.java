package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.view.UpdateBehavior;

public interface Subject {
	void attach (UpdateBehavior observer);
	void notifyAllObservers();

}
