package columbus;

import java.util.*;

public class Map {
	
	private static int[][] grid;
	public static final int SIZE = 20;
	public static final int SCALE = 30;
	private static Map instance;
	
	/** Returns a singleton instance of a Map.
	 *  @return - the Map object.
	 */
	public static Map getInstance() {
		if(instance == null) {
			instance = new Map();
		}
		return instance;
	}
	
	/** Returns this map's grid.
	 *  @return - the grid.
	 */
	public static int[][] getGrid() {
		if(instance == null) {
			instance = new Map();
		}
		return grid;
	}

	/** Constructor - creates a square map of a specified size.
	 *  @param size - the length of one side of the map.
	 */
	private Map() {
		grid = new int[SIZE][SIZE];
	}
	
	//DAVID - Initializing the Map - For reset purpose
	public static void initMap(){
		for(int y = 0; y < SIZE; y++) {
			for(int x = 0; x < SIZE; x++) {
				grid[x][y] = 0;
			}
		}
	}
	
	/** Sets a cell of the map to a specified value.
	 * @param x - the cell's x-coordinate.
	 * @param y - the cell's y-coordinate.
	 * @param val - the value to set the cell to.
	 */
	public static void set(int x, int y, int val) {
		grid[x][y] = val;
	}
	
	/** Makes islands and pirates on the map.
	 */
	public static void makeAll() {
		initMap();
		makeIslands();
		makePirates();
		makeTreasure();
		makeCannons();
	}
	
	/** Makes 2 pirates.
	 */
	public static void makePirates() {
		makePirates(2);
	}
	
	/** Makes a specified number of pirates.
	 * @param n - the number of pirates to make.
	 */
	public static void makePirates(int n) {
		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < n; i++) {
			int randX = 0, randY = 0;
			while(randX <= 10 && randY <= 10) { // Pirates won't initially spawn in the same quadrent as columbus.
				randX = rand.nextInt(SIZE);
				randY = rand.nextInt(SIZE);
			}
			grid[randX][randY] = 2;
		}
	}
	
	/** Makes (SIZE^2)/10 islands.
	 */
	public static void makeIslands() {
		makeIslands(SIZE * SIZE / 10);
	}

	/** Makes a specified number of islands.
	 * @param n - the number of islands to make.
	 */
	public static void makeIslands(int n) {
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			grid[rand.nextInt(SIZE)][rand.nextInt(SIZE)] = 1;
		}
	}
	
	/* DAVID
	 * Using 4 - to specify the Treasure
	 * */
	public static void makeTreasure(){
		makeTreasure(1);
	}
	public static void makeTreasure(int n){
		Random rand = new Random();
		for(int i=0;i<n;i++){
			grid[rand.nextInt(SIZE)][rand.nextInt(SIZE)] = 4;
		}
	}
	/**
	 * Makes 4 cannons
	 */
	public static void makeCannons() {
		makeCannons(4);
	}
	
	/**
	 * Makes a n cannons
	 * @param n - the number of cannons to make
	 */
	public static void makeCannons(int n) {
		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < n; i++) {
			int x = rand.nextInt(SIZE);
			int y = rand.nextInt(SIZE);
			if (grid[x][y] == 0) { // Creates a cannon as long as nothing is already occupying that space
				grid[x][y] = 3;
			}
			else { // If something is occupying the space the cannon is being created in,
				   // reduce i by one, to try to make another cannon
				i--;
			}
		}
	}
}
