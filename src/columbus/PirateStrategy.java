package columbus;

public interface PirateStrategy {
	
	/**
	 * Tells the pirate to chase the ship passed as an argument.
	 * @param s - the ship to chase.
	 */
	public void chase(Ship s);

}
