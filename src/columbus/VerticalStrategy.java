package columbus;

public class VerticalStrategy implements PirateStrategy {

	private PirateShip pirate;
	private String direction = "";
 
	/**
	 * A constructor.
	 * 
	 * @param s - the ship this strategy is assigned to. 
	 */
	public VerticalStrategy(PirateShip s) {
		this.pirate = s;
	}

	/**
	 * Tells the pirate to chase the ship passed as an argument. The chase is
	 * performed by checking for the ship in each vertical row of the grid, and then
	 * swimming one space closer to Ship s.
	 * 
	 * @param s - the ship to chase. 
	 */

	@Override
	public void chase(Ship s) {	
		int y = pirate.getLocation().y;
		
		if (direction == "NORTH" && y - 1 >= 0 && Map.getGrid()[pirate.getLocation().x][pirate.getLocation().y - 1] == 0) {
			pirate.goNorth();
			System.out.println("GOING NORTH 1");
		}
		else if (direction == "SOUTH" && y + 1 < Map.SIZE && Map.getGrid()[pirate.getLocation().x][pirate.getLocation().y + 1] == 0) {
			pirate.goSouth();
			System.out.println("GOING SOUTH 1");
		}
		else if (direction == "" || (y + 1 >= Map.SIZE || Map.getGrid()[pirate.getLocation().x][pirate.getLocation().y + 1] != 0)) {
			direction = "NORTH";
			pirate.goNorth();
			System.out.println("GOING NORTH 2");
		}
		else if (direction == "" || (y - 1 < 0 || Map.getGrid()[pirate.getLocation().x][pirate.getLocation().y - 1] != 0)) {
			direction = "SOUTH";
			pirate.goSouth();
			System.out.println("GOING SOUTH 2");
		}
		if(s.getLocation().equals(pirate.getLocation()))
			s.setWinningStatus(Ship.LOST);
	}
}
