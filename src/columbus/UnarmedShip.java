package columbus;

/**
 * @author Ross Nelson
 *
 * An instance of a ship who's attack doesn't do anything
 */
public class UnarmedShip extends Ship{
	
	/**
	 * Constructor that sets the initial position to (1,1)
	 */
	public UnarmedShip() {
		super(1, 1);
	}

	/**
	 * adds 0 to the ship's attack
	 */
	public int attack(){
//		System.out.println("0");
		return 0;
	}
}
