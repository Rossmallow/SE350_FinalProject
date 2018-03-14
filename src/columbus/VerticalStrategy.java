package columbus;

public class VerticalStrategy implements PirateStrategy {

	private PirateShip pirate;
	private String direction = "";
 
	/**
	 * A constructor.
	 * 
	 * @param s - the ship this strategy is assigned to. 
	 */
	public VerticalStrategy(PirateShip s, String initDir) {
		this.pirate = s;
		this.direction = initDir;
	}
	
	/**
	 * returns "VERTICAL" when called.
	 */
	public String toString() {
		return "VERTICAL";
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
		
		if (direction == "NORTH" && y - 1 >= 0 && Map.getGrid()[pirate.getLocation().x][pirate.getLocation().y - 1] == 0) {// if it's supposed to go north and it can, then go north
			pirate.goNorth();
//			System.out.println("GOING NORTH 1");
		}
		else if (direction == "SOUTH" && y + 1 < Map.SIZE && Map.getGrid()[pirate.getLocation().x][pirate.getLocation().y + 1] == 0) {// if it's supposed to go south and it can, then go south
			pirate.goSouth();
//			System.out.println("GOING SOUTH 1");
		}
		else if (direction == "SOUTH" && (y + 1 >= Map.SIZE || Map.getGrid()[pirate.getLocation().x][pirate.getLocation().y + 1] != 0)) {// if it's supposed to go south and it can't, then go east
			pirate.checkStratChange("EAST");
		}
		else if (direction == "NORTH" && (y - 1 < 0 || Map.getGrid()[pirate.getLocation().x][pirate.getLocation().y - 1] != 0)) {// if it's supposed to go north and it can't, then go west
			pirate.checkStratChange("WEST");
		}
		else if (direction == "" || (y + 1 >= Map.SIZE || Map.getGrid()[pirate.getLocation().x][pirate.getLocation().y + 1] != 0)) {// if it has no direction, and can't go south, then go north
			direction = "NORTH";
			pirate.goNorth();
//			System.out.println("GOING NORTH 2");
		}
		else if (direction == "" || (y - 1 < 0 || Map.getGrid()[pirate.getLocation().x][pirate.getLocation().y - 1] != 0)) {// if it has no direction, and can't go north, then go south
			direction = "SOUTH";
			pirate.goSouth();
//			System.out.println("GOING SOUTH 2");
		}
		if(s.getLocation().equals(pirate.getLocation()))
			s.setWinningStatus(Ship.LOST);
	}
}
