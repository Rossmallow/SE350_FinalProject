package columbus;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test for the singleton Map Class
 */

public class MapTest {

	/**
	 * Tests getInstance() method Ensures that the method is not null and that
	 * an instance is returned
	 */

	@Test
	public void testGetInstance() {
		Map.getInstance();
		assertTrue(Map.getInstance() != null);
	}

	/**
	 * Tests getInstance() method, again Checks the singleton Map class for
	 * equality
	 */

	@Test
	public void testUniqueInstance() {
		Map s1 = Map.getInstance();
		Map s2 = Map.getInstance();

		assertEquals(true, s1 == s2);
	}

	/**
	 * Tests getGrid() method Ensures that the method is not null and that a
	 * grid is returned
	 */

	@Test
	public void testGetGrid() {
		Map.getGrid();
		assertTrue(Map.getGrid() != null);
	}

	/**
	 * Tests initMap() method For this method, nothing is returned Tests the
	 * functionality of the method
	 */

	@Test
	public void testInitMap() {
		Map.initMap();

	}

	/**
	 * Tests set() method 
	 * For this method, nothing is returned 
	 * Tests the functionality of the method
	 */
	@Test
	public void testSet() {
		Map.set(2, 2, 0);

	}

	/**
	 * Tests makeAll method 
	 * For this method, nothing is returned 
	 * Tests the functionality of the method
	 */

	@Test
	public void testMakeAll() {
		Map.makeAll();
	}


	/**
	 * Tests makePirates() method 
	 * For this method, nothing is returned 
	 * Tests the functionality of the method
	 */
	
	@Test
	public void testMakePirates() {
		Map.makePirates();

	}
	
	/**
	 * Tests makeIslands() method 
	 * For this method, nothing is returned 
	 * Tests the functionality of the method
	 */

	@Test
	public void testMakeIslands() {
		Map.makeIslands();
		// assertTrue(Map.makeIslands() == 2);
	}
	
	/**
	 * Tests makeTreasure() method 
	 * For this method, nothing is returned 
	 * Tests the functionality of the method
	 */

	@Test
	public void testMakeTreasure() {
		Map.makeTreasure();
		// assertTrue(Map.makeTreasure() == 2);
	}
	
	/**
	 * Tests makeCannons() method 
	 * For this method, nothing is returned 
	 * Tests the functionality of the method
	 */

	@Test
	public void testMakeCannons() {
		Map.makeCannons();
		// assertTrue(Map.makeCannons() == 2);
	}

}