package columbus;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javafx.application.*;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;

public class Explorer extends Application {  

	private Pane root; // The pane this application will run in.
	private Ship columbus = new UnarmedShip(); // Columbus' ship.
	private List<PirateShip> pirates; // The pirate ships.
	private List<Cannon> cannons; // The cannons

	/**
	 * Overrides the start method to: -Set up the window. -Draw all the game
	 * objects. -Handle events for gameplay.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		root = new AnchorPane();
		Scene scene = new Scene(root, Map.SCALE * Map.SIZE, Map.SCALE * Map.SIZE);
		stage.setScene(scene);
		stage.setTitle("Columbus Game");
		drawMap();
		showCannons();
		showPirates();
		showShip(columbus);
		stage.show();
		startSailing(scene);
	}

	/**
	 * Creates an event handler that moves the ship in the right direction,
	 * depending on which arrow key is pressed.
	 * 
	 * @param scene
	 *            - The scene to assign the handler to.
	 */
	private void startSailing(Scene scene) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				switch (ke.getCode()) {
				case RIGHT:
					columbus.goEast();
					break;
				case LEFT:
					columbus.goWest();
					break;
				case UP:
					columbus.goNorth();
					break;
				case DOWN:
					columbus.goSouth();
					break;
				case SPACE:
					columbus.attack();
					break;
				default:
					break;
				}
			}
		});
	}

	/**
	 * Displays a ship.
	 * 
	 * @param s
	 *            - The ship to display.
	 */
	private void showShip(Ship s) {
		ImageView i = s.getImg(Map.SCALE);
		if (!root.getChildren().contains(i)) {
			root.getChildren().add(i);
		}
	}

	/**
	 * Displays the pirate ships.
	 */
	private void showPirates() {
		for (PirateShip p : pirates) {
			System.out.println("Showing ship : " + p.toString());
			showShip(p);
		}
	}
	
	/**
	 * Displays all cannons
	 * @param cannon - the cannon to display
	 */
	private void showCannons() {
		for (Cannon cannon: cannons) {
			ImageView i = cannon.getImg(Map.SCALE);
			if (!root.getChildren().contains(i)) {
				root.getChildren().add(i);
			}
		}
	}

	/**
	 * Draws the map.
	 */
	private void drawMap() {
		Map.getInstance().makeAll();
		pirates = new ArrayList<PirateShip>();
		cannons = new ArrayList<Cannon>();
		for (int x = 0; x < Map.SIZE; x++) {
			for (int y = 0; y < Map.SIZE; y++) {
				Rectangle rect = new Rectangle(x * Map.SCALE, y * Map.SCALE, Map.SCALE, Map.SCALE);
				rect.setStroke(Color.BLACK); // We want the black outline
				if (Map.getGrid()[x][y] == 1)
					rect.setFill(Color.GREEN); // If the cell contains 1, it's an island.
				else
					rect.setFill(Color.PALETURQUOISE); // Else, it's water.
				if (Map.getGrid()[x][y] == 2) { // If the cell contains 2, give it a pirate.
					PirateShip p = new PirateShip(columbus);
					p.moveTo(new Point(x, y));
					pirates.add(p);
				}
				else if (Map.getGrid()[x][y] == 3) { // If the cell contains 3, give it a cannon
					Cannon c = new Cannon(x, y);
					cannons.add(c);
				}
				root.getChildren().add(rect); // Add to the node tree in the pane
			}
		}
	}
	
	/**
	 * Checks to see if there are any cannons at columbus' location
	 */
	private boolean checkForCannons() {
		if (Map.getGrid()[columbus.getLocation().x][columbus.getLocation().y] == 3) {
			columbus = new ArmedShip(columbus);
			for (Cannon cannon : cannons) {
				if (cannon.getLocation() == columbus.getLocation()) {
					cannons.remove(cannon);
					root.getChildren().remove(cannon);
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Launches the application.
	 * 
	 * @param args
	 *            - Command-line arguments. These get ignored.
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
