package tc.columbus;

import static org.junit.Assert.*;

import org.junit.Test;

import columbus.Map;
 
/**
 * JUnit test for the singleton Map Class
 */

public class MapTest {

	/**
	 * Tests getInstance() method 
	 * Ensures that the method is not null and that an instance is returned
	 */

	@Test
	public void testGetInstance() {
		Map.getInstance();
		assertTrue(Map.getInstance() != null);
	}

	/**
	 * Tests getInstance() method, again 
	 * Checks the singleton Map class for equality
	 */

	@Test
	public void testUniqueInstance() {
		Map s1 = Map.getInstance();
		Map s2 = Map.getInstance();

		assertEquals(true, s1 == s2);
	}

	/**
	 * Tests getGrid() method 
	 * Ensures that the method is not null and that a grid is returned
	 */

	@Test
	public void testGetGrid() {
		Map.getGrid();
		assertTrue(Map.getGrid() != null);
	}

	/**
	 * Tests initMap() method For this method
	 * Makes sure that the return value is correct in the class 
	 * Tests the functionality of the method
	 */

	@Test
	public void testInitMap() {
		Map.initMap();
		assertTrue(Map.initMap() == 0);


	}

	/**
	 * Tests set() method 
	 * Makes sure that the return value is correct in the class 
	 * Tests the functionality of the method
	 */
	@Test
	public void testSet() {
		Map.set(0, 0, 0);
		assertTrue(Map.set(0, 0, 0) == (0));


	}

	/**
	 * Tests makeAll() method 
	 * Makes sure that the return value is correct in the class 
	 * Tests the functionality of the method
	 */

	@Test
	public void testMakeAll() {
		Map.makeAll();
		assertTrue(Map.makeAll() == 0);

	}


	/**
	 * Tests makePirates() method 
	 * Makes sure that the return value is correct in the class 
	 * Tests the functionality of the method
	 */
	
	@Test
	public void testMakePirates() {
		Map.makePirates();
		assertTrue(Map.makePirates() == 3);

	}
	
	/**
	 * Tests makeIslands() method 
	 * Makes sure that the return value is correct in the class 
	 * Tests the functionality of the method
	 */

	@Test
	public void testMakeIslands() {
		Map.makeIslands();
		assertTrue(Map.makeIslands() == 0);
	}
	
	/**
	 * Tests makeTreasure() method 
	 * Makes sure that the return value is correct in the class 
	 * Tests the functionality of the method
	 */

	@Test
	public void testMakeTreasure() {
		Map.makeTreasure();
		assertTrue(Map.makeTreasure() == 4);
	}
	
	/**
	 * Tests makeCannons() method 
	 * Makes sure that the return value is correct in the class 
	 * Tests the functionality of the method
	 */

	@Test
	public void testMakeCannons() {
		Map.makeCannons();
		assertTrue(Map.makeCannons() == 4);
	}

}