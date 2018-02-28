package columbus;
/**
 * @author Ross Nelson
 *
 * A class that adds one attack to the ship that this is attached to
 */
public class ArmedShip extends AttackDecorator{
	Ship ship;
	
	/**
	 * Creates a reference to the ship that this is decorating
	 * @param ship - the ship to be decorated
	 */
	public ArmedShip (Ship ship) {
		this.ship = ship;
	}
	
	/**
	 * adds one to the ship's attack
	 */
	public int attack() {
		System.out.println("Ship attacked once!");
		return 1 + ship.attack();
	}
}
