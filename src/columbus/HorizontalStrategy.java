package columbus;

import java.awt.Point;

public class HorizontalStrategy implements PirateStrategy {

	private PirateShip pirate;
 
	/**
	 * A constructor.
	 * 
	 * @param s - the ship this strategy is assigned to. 
	 */
	public HorizontalStrategy(PirateShip s) {
		this.pirate = s;
	}

	/**
	 * Tells the pirate to chase the ship passed as an argument. The chase is
	 * performed by checking for the ship in each horizontal row of the grid, and then
	 * swimming one space closer to Ship s.
	 * 
	 * @param s - the ship to chase. 
	 */

	@Override
	public void chase(Ship s) {

		Point p = s.getLocation();
		Point q = pirate.getLocation(); 

		Point[] chaser = new Point[10];

		int i = 0;
		for (int y = 0; y < 10; y++) {
			if (s.check(q.x, q.y) && i < 10) {
				chaser[i] = new Point(p.x, p.y);
				i++;

			}
		}
	}
}