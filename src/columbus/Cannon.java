package columbus;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Ross Nelson
 *
 * A class that draws and attaches cannons to Columbus' ship
 */
public class Cannon {
	protected Point location;
	protected Image img = new Image("file:src/columbus/cannon.png", Map.SCALE, Map.SCALE, true, true);
	protected ImageView imgv = new ImageView(img);
	protected int scale;
	public final int BOUND = Map.SIZE - 1;
	
	/**
	 * A constructor
	 * @param x - The x coordinate of the cannon
	 * @param y - The y coordinate of the cannon
	 */
	public Cannon(int x, int y) {
		location = new Point(x, y);
	}
	
	/**
	 * Returns an image of this cannon
	 * @param scale - the size of the image
	 * @return - a square image representing this cannon
	 */
	public ImageView getImg (int scale) {
		this.scale = scale;
		imgv.setX(location.x * scale);
		imgv.setY(location.y * scale);
		return imgv;
	}
	
	/**
	 * Returns the cannon's location
	 * @return - the cannon's location
	 */
	public Point getLocation() {
		return location;
	}
	
	/**
	 * Converts this cannon to a string
	 * 
	 * @return - A string representation of this cannon
	 */
	public String toString() {
		return "Cannon at " + location.toString();
	}
}
