package columbus;
/**
 * @author Ross Nelson
 *
 * An instance of a ship who's attack doesn't do anything
 */
public class UnarmedShip extends Ship{
	
	public int attack(){
		System.out.println("Ship did not attack, no cannons attached!");
		return 0;
	}
}
