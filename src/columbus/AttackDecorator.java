package columbus;
/**
 * @author Ross Nelson
 * 
 * An attack decorator class to create instances of different attacks for the Columbus ship
 */
public abstract class AttackDecorator extends Ship{
	public abstract int attack();
}
