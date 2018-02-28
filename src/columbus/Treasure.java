package columbus;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//DAVID
public class Treasure {
	protected Point location;
	protected Image img;
	protected ImageView imgv;
	protected int scale;
	public final int BOUND = Map.SIZE - 1;
	
	public Treasure(Point point){
		img = new Image("file:src/columbus/treasure.png", Map.SCALE, Map.SCALE, true, true);
		imgv = new ImageView(img);
		location = new Point(point);
	}
	
	public ImageView getImg(int scale) {
		this.scale = scale;
		imgv.setX(location.x * scale);
		imgv.setY(location.y * scale);
		return imgv;
	}

	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	
	public void moveTo(Point p) {
		if (p.x >= 0 && p.x <= BOUND && p.y >= 0 && p.y <= BOUND && Map.getGrid()[p.x][p.y] == 4) {
			location = p;
			imgv.setX(location.x * scale);
			imgv.setY(location.y * scale);
		}
	}
}
