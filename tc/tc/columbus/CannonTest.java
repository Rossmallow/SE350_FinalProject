package tc.columbus;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.Location;

import columbus.Cannon;

import org.junit.Test;

public class CannonTest {
	

	@Test
	public void testGetLocation() {
		Cannon.getLocation();
		assertTrue(Cannon.getLocation() == null);
	}


	@Test
	public void testToString() {

		//Cannon cannon = new Cannon(10, 10);	
		//Cannon.toString();
		//String expected = "Cannon at [10,10]";
		//assertEquals(expected, cannon.toString());
	}
}