package tc.columbus;

import static org.junit.Assert.*;

import org.junit.Test;

import columbus.PirateShipFactory;
import columbus.Ship;
import javafx.embed.swing.JFXPanel;

/**
 * JUnit test for the factory PirateShipFactory Class
 */

public class PirateShipFactoryTest {

	private static final Ship Ship = null;
	JFXPanel jfxPanel = new JFXPanel();
	
	
	/**
	 * Tests the general buildPirateShip() method 
	 * Ensures that the method (in general) is not null and that an instance is returned
	 */
	
	@Test
	public void buildTest() {
		PirateShipFactory.buildPirateShip(Ship, " ");
		assertTrue(PirateShipFactory.buildPirateShip(Ship, " ") != null);

	}
	
	/**
	 * Tests the buildPirateShip() method for a Follow instance 
	 * Ensures that the method is not null and that an instance is returned
	 */
	
	@Test
	public void buildTestFollow() {
		PirateShipFactory.buildPirateShip(Ship, "follow");
		assertTrue(PirateShipFactory.buildPirateShip(Ship, "follow") != null);

	}
	
	/**
	 * Tests the buildPirateShip() method for a Horizontal instance 
	 * Ensures that the method is not null and that an instance is returned
	 */ 
	
	@Test
	public void buildTestHorizontal() {
		PirateShipFactory.buildPirateShip(Ship, "horizontal");
		assertTrue(PirateShipFactory.buildPirateShip(Ship, "horizontal") != null);

	}
	
	/**
	 * Tests the buildPirateShip() method for a Vertical instance 
	 * Ensures that the method is not null and that an instance is returned
	 */
	
	@Test
	public void buildTestVertical() {
		PirateShipFactory.buildPirateShip(Ship, "vertical");
		assertTrue(PirateShipFactory.buildPirateShip(Ship, "vertical") != null);

	}
}