package columbus;

import java.awt.Point;
import java.util.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PirateShip extends Ship implements Observer{
	
	private Ship toObserve; //The ship this pirate will follow.
	
	/** A constructor.
	 * 
	 * @param map - the map this ship will navigate.
	 */
	public PirateShip(Map map, Ship toObserve) {
		super(map);
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
		if(p.x >= 0 && p.x <= 9 && p.y >= 0 && p.y <= 9 && this.map.getMap()[p.x][p.y] % 2 == 0) {	//Pirate ships are allowed to "pass" each other.
			System.out.println("Moving ship to: " + p.toString());
			map.set(location.x, location.y, 0);	//Set the current location to be empty.
			location = p;						
			map.set(location.x, location.y, 2);	//Set the new location to contain a pirate ship.
			imgv.setX(location.x * scale);
			imgv.setY(location.y * scale);
		}
	}
	
	/** Moves one space closer to the ship passed as an argument.
	 * @param s - the ship to follow.
	 */
	public void follow(Ship s) {
		System.out.println("Calling follow.");
		Point p = s.getLocation();
		Point q = this.getLocation();
		if (p.x > q.x) {
			this.goEast();
		} else if (p.x < q.x) {
			this.goWest();
		} else if (p.y > q.y) {
			this.goSouth();
		} else if (p.y < q.y) {
			this.goNorth();
		}
	}
	
	/** The overridden update method.
	 * @param o
	 * @param arg
	 */
	@Override
	public void update(Observable o, Object arg) {
		if(o == toObserve) {
			this.follow(toObserve);
		}
	}
	
}
