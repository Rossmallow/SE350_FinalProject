package columbus;

import java.util.*;

public class Map {
	
	private static int[][] grid;
	public static final int SIZE = 15;
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
	public void set(int x, int y, int val) {
		grid[x][y] = val;
	}
	
	/** Makes islands and pirates on the map.
	 */
	public void makeAll() {
		makeIslands();
		makePirates();
	}
	
	/** Makes 2 pirates.
	 */
	public void makePirates() {
		makePirates(2);
	}
	
	/** Makes a specified number of pirates.
	 * @param n - the number of pirates to make.
	 */
	public void makePirates(int n) {
		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < n; i++) {
			grid[rand.nextInt(10)][rand.nextInt(10)] = 2;
		}
	}
	
	/** Makes SIZE islands.
	 */
	public void makeIslands() {
		makeIslands(SIZE);
	}

	/** Makes a specified number of islands.
	 * @param n - the number of islands to make.
	 */
	public void makeIslands(int n) {
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			grid[rand.nextInt(SIZE)][rand.nextInt(SIZE)] = 1;
		}
	}
}
