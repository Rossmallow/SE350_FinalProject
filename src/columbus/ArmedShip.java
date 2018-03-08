package columbus;

/**
 * @author Ross Nelson
 *
 * A class that adds one attack to the ship that this is attached to
 */
public class ArmedShip extends AttackDecorator{
	private Ship ship;
	private int attack;
	
	/**
	 * Creates a reference to the ship that this is decorating
	 * @param ship - the ship to be decorated
	 */
	public ArmedShip (Ship ship) {
		super(ship);
		this.ship = ship;
	}
	
	/**
	 * adds one to the ship's attack
	 */
	public int attack() {
		attack = ship.attack() + 1;
//		System.out.println(attack);
		return attack;
	}
}
