package columbus;

import java.awt.Point;

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
		Point p = s.getLocation();
		Point q = pirate.getLocation();
		if (p.x > q.x) {
			pirate.goEast();
		} else if (p.x < q.x) {
			pirate.goWest();
		} else if (p.y > q.y) {
			pirate.goSouth();
		} else if (p.y < q.y) {
			pirate.goNorth();
		}
		if(p.equals(pirate.getLocation()))
			s.setWinningStatus(Ship.LOST);
	}

}
