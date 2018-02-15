package columbus;

import java.util.*;

public class Map {
	public int[][] map; 
	
	/** Creates a new blank map.
	 *  @return - The new blank map
	 */
	public int[][] getMap() {
		return map;
	}

	/** Constructor - creates a square map of a specified size.
	 *  @param size - the length of one side of the map.
	 */
	public Map(int size) {
		map = new int[size][size];
		for(int y = 0; y < size; y++) {
			for(int x = 0; x < size; x++) {
				map[x][y] = 0;
			}
		}
	}
	
	/** Sets a cell of the map to a specified value.
	 * @param x - the cell's x-coordinate.
	 * @param y - the cell's y-coordinate.
	 * @param val - the value to set the cell to.
	 */
	public void set(int x, int y, int val) {
		map[x][y] = val;
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
			map[rand.nextInt(10)][rand.nextInt(10)] = 2;
		}
	}
	
	/** Makes 10 islands.
	 */
	public void makeIslands() {
		makeIslands(10);
	}

	/** Makes a specified number of islands.
	 * @param n - the number of islands to make.
	 */
	public void makeIslands(int n) {
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			map[rand.nextInt(10)][rand.nextInt(10)] = 1;
		}
	}
}
