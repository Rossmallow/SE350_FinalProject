package columbus;

import java.awt.Point;
import java.util.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PirateShip extends Ship implements Observer{
	
	private Ship toObserve; //The ship this pirate will follow.
	private PirateStrategy strat = new FollowStrategy(this); //The strategy this ship is using.
	
	/** A constructor.
	 * 
	 * @param map - the map this ship will navigate.
	 */
	public PirateShip(Ship toObserve) {
		super();
		this.img = new Image("file:src/columbus/pirateShip.png", 50, 50, true, true);
		this.imgv = new ImageView(img);
		System.out.println("Set toObserve to: " + toObserve.toString());
		this.toObserve = toObserve;
		toObserve.addObserver(this);
	}
	
	/** Moves this ship to a specified point, if possible
	 * @param p - the point to move to.
	 */
	@Override
	public void moveTo(Point p) {
		System.out.println("MoveTo called on pair: " + p.toString());
		if(p.x >= 0 && p.x <= 9 && p.y >= 0 && p.y <= 9 && Map.getGrid()[p.x][p.y] % 2 == 0) {	//Pirate ships are allowed to "pass" each other.
			System.out.println("Moving ship to: " + p.toString());
			Map.getInstance().set(location.x, location.y, 0);	//Set the current location to be empty.
			location = p;						
			Map.getInstance().set(location.x, location.y, 2);	//Set the new location to contain a pirate ship.
			imgv.setX(location.x * scale);
			imgv.setY(location.y * scale);
		}
	}
	
	/** The overridden update method.
	 * @param o
	 * @param arg
	 */
	@Override
	public void update(Observable o, Object arg) {
		if(o == toObserve) {
			strat.chase(toObserve);
		}
	}
	
}
