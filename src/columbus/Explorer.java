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

	private final int dimension = 10; // Number of cells in the grid.
	private final int scale = 50; // Size of each cell.
	private Pane root; // The pane this application will run in.
	private final Map map = new Map(dimension); // The map.
	private Ship columbus = new Ship(map); // Columbus' ship.
	private List<PirateShip> pirates; // The pirate ships.
	int[][] grid = map.getMap(); // Our grid.

	/**
	 * Overrides the start method to: -Set up the window. -Draw all the game
	 * objects. -Handle events for gameplay.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		root = new AnchorPane();
		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);
		stage.setTitle("Columbus Game");
		drawMap();
		showShip(columbus);
		showPirates();
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
		ImageView i = s.getImg(scale);
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
	 * Draws the map.
	 */
	private void drawMap() {
		map.makeAll();
		pirates = new ArrayList<PirateShip>();
		for (int x = 0; x < dimension; x++) {
			for (int y = 0; y < dimension; y++) {
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK); // We want the black outline
				if (map.getMap()[x][y] == 1)
					rect.setFill(Color.GREEN); // If the cell contains 1, it's an island.
				else
					rect.setFill(Color.PALETURQUOISE); // Else, it's water.
				if (map.getMap()[x][y] == 2) { // If the cell contains 2, give it a pirate.
					PirateShip p = new PirateShip(map, columbus);
					p.moveTo(new Point(x, y));
					pirates.add(p);
				}
				root.getChildren().add(rect); // Add to the node tree in the pane
			}
		}
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
