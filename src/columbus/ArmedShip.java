package columbus;

import java.awt.Point;

import javafx.scene.image.ImageView;

/**
 * @author Ross Nelson
 *
 * A class that adds one attack to the ship that this is attached to
 */
public class ArmedShip extends AttackDecorator{
	private Ship ship;
	private Point location;
	private ImageView imgv;
	private int attack;
	
	/**
	 * Creates a reference to the ship that this is decorating
	 * @param ship - the ship to be decorated
	 */
	public ArmedShip (Ship ship) {
		super(ship);
		this.ship = ship;
		this.location = ship.getLocation();
		this.imgv = ship.getImg(Map.SCALE);
	}
	
	/**
	 * adds one to the ship's attack
	 */
	public int attack() {
		attack = ship.attack() + 1;
		System.out.println(attack);
		return attack;
	}
	
	/**
	 * Returns an image of this ship.
	 * 
	 * @param scale
	 *            - the size of the image.
	 * @return - a square image representing this ship.
	 */
	public ImageView getImg(int scale) {
		this.scale = scale;
		imgv.setX(location.x * scale);
		imgv.setY(location.y * scale);
		return imgv;
	}
	
	/**
	 * Returns this ship's location.
	 * 
	 * @return - a Point object containing this ship's location.
	 */
	public Point getLocation() {
		return location;
	}
	
	public void goEast() {
		ship.goEast();
	}
	
	public void goWest() {
		ship.goWest();
	}
	
	public void goNorth() {
		ship.goNorth();
	}
	
	public void goSouth() {
		ship.goSouth();
	}
}
