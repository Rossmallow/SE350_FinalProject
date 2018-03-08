package columbus;

public class HorizontalStrategy implements PirateStrategy {

	private PirateShip pirate;
	private String direction = "";
 
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
		int x = pirate.getLocation().x;
		
		if (direction == "WEST" && x - 1 >= 0 && Map.getGrid()[pirate.getLocation().x - 1][pirate.getLocation().y] == 0) {
			pirate.goWest();
			System.out.println("GOING WEST 1");
		}
		else if (direction == "EAST" && x + 1 < Map.SIZE && Map.getGrid()[pirate.getLocation().x + 1][pirate.getLocation().y] == 0) {
			pirate.goEast();
			System.out.println("GOING EAST 1");
		}
		else if (direction == "" || (x + 1 >= Map.SIZE || Map.getGrid()[pirate.getLocation().x + 1][pirate.getLocation().y] != 0)) {
			direction = "WEST";
			pirate.goWest();
			System.out.println("GOING WEST 2");
		}
		else if (direction == "" || (x - 1 < 0 || Map.getGrid()[pirate.getLocation().x - 1][pirate.getLocation().y] != 0)) {
			direction = "EAST";
			pirate.goEast();
			System.out.println("GOING EAST 2");
		}
		if(s.getLocation().equals(pirate.getLocation()))
			s.setWinningStatus(Ship.LOST);
	}
}
