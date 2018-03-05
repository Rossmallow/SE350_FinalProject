package columbus;

public class FollowStrategy implements PirateStrategy {

	private PirateShip pirate;

	/**
	 * A constructor.
	 * 
	 * @param s
	 *            - the ship this strategy is assigned to.
	 */
	public FollowStrategy(PirateShip s) {
		this.pirate = s;
	}

	/**
	 * Tells the pirate to chase the ship passed as an argument. The chase is
	 * performed by swimming one space closer to Ship s.
	 * 
	 * @param s
	 *            - the ship to chase.
	 */
	@Override
	public void chase(Ship s)
	{
		int x = pirate.getLocation().x - s.getLocation().x;
		int y = pirate.getLocation().y - s.getLocation().y;
		
		if (x > 0 && Map.getGrid()[pirate.getLocation().x - 1][pirate.getLocation().y] == 0)
			pirate.goWest();
		else if (x < 0 && Map.getGrid()[pirate.getLocation().x + 1][pirate.getLocation().y] == 0)
			pirate.goEast();
		else if (y > 0 && Map.getGrid()[pirate.getLocation().x][pirate.getLocation().y - 1] == 0)
			pirate.goNorth();
		else if (y < 0 && Map.getGrid()[pirate.getLocation().x][pirate.getLocation().y + 1] == 0)
			pirate.goSouth();
		if(s.getLocation().equals(pirate.getLocation()))
			s.setWinningStatus(Ship.LOST);
	}

}
