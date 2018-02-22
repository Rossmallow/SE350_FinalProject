package columbus;

import java.awt.Point;

public class DoNothingStrategy implements PirateStrategy {
	
	/**
	 * Tells the pirate to chase the ship passed as an argument.
	 * Pirates that use this strategy are lazy, so they don't move.
	 * @param s - the ship to chase.
	 */
	@Override
	public void chase(Ship s) {
		//Do nothing.
	}

}
