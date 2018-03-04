package columbus;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Explosion {
	private Point location;
	private Image img = new Image("file:src/columbus/explosion.png", Map.SCALE, Map.SCALE, true, true);
	private ImageView imgv = new ImageView(img);
	
	/**
	 * A Constructor
	 * @param x - x position to instantiate this explosion at
	 * @param y - y position to instantiate this explosion at
	 */
	public Explosion(int x, int y) {
		this.location = new Point(x, y);
	}
	
	/**
	 * Returns an image of this explosion.
	 * @param scal e- the size of the image.
	 * @return - a square image representing this explosion.
	 */
	public ImageView getImg(int scale) {
		imgv.setX(location.x * scale);
		imgv.setY(location.y * scale);
		return imgv;
	}
	
	public Point getLocation() {
		return location;
	}
}
