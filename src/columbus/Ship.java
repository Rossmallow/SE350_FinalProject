package columbus;

import java.awt.*;
import java.util.*;
import javafx.scene.image.*;
import javafx.scene.image.Image;

public class Ship extends Observable {

	protected Point location;
	protected Image img = new Image("file:src/columbus/ship.png", 50, 50, true, true);
	protected ImageView imgv = new ImageView(img);
	protected int scale;

	/**
	 * A constructor.
	 * 
	 * @param map
	 *            - the map this ship will navigate.
	 */
	public Ship() {
		location = new Point(1, 1);
	}

	/**
	 * Returns this ship's location.
	 * 
	 * @return - a Point object containing this ship's location.
	 */
	public Point getLocation() {
		return location;
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
	 * Moves this ship to a specified point.
	 * 
	 * @param p
	 *            - the point to move to.
	 */
	public void moveTo(Point p) {
		if (p.x >= 0 && p.x <= 9 && p.y >= 0 && p.y <= 9 && Map.getGrid()[p.x][p.y] == 0) {
			location = p;
			imgv.setX(location.x * scale);
			imgv.setY(location.y * scale);
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Moves 1 space East, if possible.
	 */
	public void goEast() {
		if (location.getX() < 9) {
			int x = ((int) location.getX()) + 1;
			int y = ((int) location.getY());
			moveTo(new Point(x, y));
		}
	}

	/**
	 * Moves 1 space West, if possible.
	 */
	public void goWest() {
		if (location.getX() > 0) {
			int x = ((int) location.getX()) - 1;
			int y = ((int) location.getY());
			moveTo(new Point(x, y));
		}
	}

	/**
	 * Moves 1 space North, if possible.
	 */
	public void goNorth() {
		if (location.getY() > 0) {
			int x = ((int) location.getX());
			int y = ((int) location.getY()) - 1;
			moveTo(new Point(x, y));
		}
	}

	/**
	 * Moves 1 space South, if possible.
	 */
	public void goSouth() {
		if (location.getY() < 9) {
			int x = ((int) location.getX());
			int y = ((int) location.getY()) + 1;
			moveTo(new Point(x, y));
		}
	}

	/**
	 * Converts this ship to a string
	 * 
	 * @return - A string representation of this ship.
	 */
	public String toString() {
		return "Ship at " + location.toString();
	}

	/**
	 * Checks whether or not location is null
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean check(int x, int y) {
		return location != null;
	}

}
