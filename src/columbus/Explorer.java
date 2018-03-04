package columbus;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.*;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
	private Treasure treasure; // The treasure
//	private Stage stage; // The stage
	private Scene scene; // The scene

	/**
	 * Overrides the start method to: -Set up the window. -Draw all the game
	 * objects. -Handle events for gameplay.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		root = new AnchorPane();
//		this.stage = stage;
		Scene scene = new Scene(root, Map.SCALE * Map.SIZE, Map.SCALE * Map.SIZE);
		this.scene = scene;
		stage.setScene(scene);
		stage.setTitle("Columbus Game");
		initGame();
		stage.show();
		startSailing(scene);
	}
	
	/**
	 * Initializes the game by drawing each element
	 */
	public void initGame(){
		columbus = new UnarmedShip();
		drawMap();
		showCannons();
		showTreasure();
		showShip(columbus);
		showPirates();
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
					checkGameStatus();
					checkForCannons();
					break;
				case LEFT:
					columbus.goWest();
					checkGameStatus();
					checkForCannons();
					break;
				case UP:
					columbus.goNorth();
					checkGameStatus();
					checkForCannons();
					break;
				case DOWN:
					columbus.goSouth();
					checkGameStatus();
					checkForCannons();
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
	//DAVID - Checking Game status
	public void checkGameStatus(){
		//Check if Columbus won
		if(columbus.getWinningStatus() == Ship.WON){
			reset("Congratulations!!! You Won. Play again?");
		} else if (columbus.getWinningStatus() == Ship.LOST) {
			reset("Alas!!! You Lost. Play again?");
		}
	}
	//DAVID - Reseting the Game
	public void reset(String message){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Info");
		alert.setContentText(message);
		Optional<ButtonType> result = alert.showAndWait();
		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			initGame();
		}else if((result.isPresent()) && (result.get() == ButtonType.CANCEL)){
			Platform.exit();
		}
	}
	
	/**
	 * Checks to see if there are any cannons at Columbus' location
	 */
	private void checkForCannons() {
		if (Map.getGrid()[columbus.getLocation().x][columbus.getLocation().y] == 3) {
			ImageView i = columbus.getImg(Map.SCALE);
			columbus = new ArmedShip(columbus);
			updateColumbus(i);
			for (Cannon cannon : cannons) {
				System.out.println("IN for");
				System.out.println("Cannon: " + cannon.getLocation().toString() + " Columbus: " + columbus.getLocation().toString());
				if (cannon.getLocation().equals(columbus.getLocation())) {
					removeCannon(cannon);
					break;
				}
			}
		}
	}
	
	/**
	 * Removes a cannon from the cannons List and its ImageView from the root
	 * @param cannon - the cannon to remove
	 */
	private void removeCannon(Cannon cannon) {
		System.out.println("Removing...");
		cannons.remove(cannon);
		root.getChildren().remove(cannon.getImg(Map.SCALE));
		System.out.println("Removed...");
	}
	
	public void updateColumbus(ImageView oldImgv) {
		root.getChildren().remove(oldImgv);
		showShip(columbus);
		for (PirateShip pirate: pirates) {
			pirate.setToObserve(columbus);
		}
	}

	/**
	 * Displays a ship.
	 * @param s - The ship to display.
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
	 * Displays Treasure
	 * @param treasure - the treasure to display
	 */
	private void showTreasure(){
		ImageView i = treasure.getImg(Map.SCALE);
		if(!root.getChildren().contains(i))
			root.getChildren().add(i);
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
//					Cannon c = new Cannon(x, y);
					cannons.add(new Cannon(x, y));
				}
				//DAVID-Place treasure on Map
				else if (Map.getGrid()[x][y] == 4) { // If the cell contains 3, give it a Treasure.
					treasure = new Treasure(new Point(x, y));
					//To keep track of Treasure while Columbus is on Move
					columbus.setTreasure(treasure);
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
