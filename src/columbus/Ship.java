package columbus;

import java.awt.*;
import java.util.*;
import javafx.scene.image.*;
import javafx.scene.image.Image;

public abstract class Ship extends Observable {

	protected Point location;
	protected Image img = new Image("file:src/columbus/ship.png", Map.SCALE, Map.SCALE, true, true);
	protected ImageView imgv = new ImageView(img);
	protected int scale;
	public final int BOUND = Map.SIZE - 1;
	private Treasure treasure;
	private String winningStatus;
	public static String CONTINUE = "CONTINUE";
	public static String WON = "WON";
	public static String LOST = "LOST";

	/**
	 * A constructor.
	 * 
	 * @param map
	 *            - the map this ship will navigate.
	 */
	public Ship(int x, int y) {
		location = new Point(x, y);
		winningStatus = CONTINUE;
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

	//DAVID - Looking for Treasure
	public boolean lookForTreasure(Point ship) {
		if (ship.equals(this.getTreasure().getLocation()))
			return true;
		return false;
	}

	/**Moves this ship to a specified point.
	 * @param p - the point to move to.
	 */
	public void moveTo(Point p) {
		if (p.x >= 0 && p.x <= BOUND && p.y >= 0 && p.y <= BOUND && (Map.getGrid()[p.x][p.y] != 11 && Map.getGrid()[p.x][p.y] != 1 && Map.getGrid()[p.x][p.y] != 2)) {
			location = p;
			imgv.setX(location.x * scale);
			imgv.setY(location.y * scale);
			setChanged();
			if(/*this instanceof Ship && this.lookForTreasure(p)*/Map.getGrid()[p.x][p.y] == 4 || Map.getGrid()[p.x][p.y] == 14){
				setWinningStatus(WON);
			}else{
				notifyObservers();
			}
		}
	}

	/**
	 * Moves 1 space East, if possible.
	 */
	public void goEast() {
		if (this.getLocation().getX() < BOUND) {
			int x = ((int) location.getX()) + 1;
			int y = ((int) location.getY());
			moveTo(new Point(x, y));
		}
	}

	/**
	 * Moves 1 space West, if possible.
	 */
	public void goWest() {
		if (this.getLocation().getX() > 0) {
			int x = ((int) location.getX()) - 1;
			int y = ((int) location.getY());
			moveTo(new Point(x, y));
		}
	}

	/**
	 * Moves 1 space North, if possible.
	 */
	public void goNorth() {
		if (this.getLocation().getY() > 0) {
			int x = ((int) location.getX());
			int y = ((int) location.getY()) - 1;
			moveTo(new Point(x, y));
		}
	}

	/**
	 * Moves 1 space South, if possible.
	 */
	public void goSouth() {
		if (this.getLocation().getY() < BOUND) {
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

	public abstract int attack();
	
	public Treasure getTreasure() {
		return treasure;
	}
	public void setTreasure(Treasure treasure) {
		this.treasure = treasure;
	}
	public String getWinningStatus() {
		return winningStatus;
	}
	public void setWinningStatus(String winningStatus) {
		this.winningStatus = winningStatus;
	}
}
