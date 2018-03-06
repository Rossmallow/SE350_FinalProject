package tc.columbus;
import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;
import columbus.Cannon;

/**
 * JUnit test for the Cannon Class
 */

public class CannonTest {

	@Test
	public void testGetLocation() {
		Cannon.getLocation();
		assertTrue(Cannon.getLocation() == null);
	}

	@Test
	public void testUniqueGetLocation() {
		Point p1 = Cannon.getLocation();
		Point p2 = Cannon.getLocation();
		assertEquals(true, p1 == p2);
	}

	@Test
	public void testToString() {

		// Cannon cannon = new Cannon(10, 10);
		// Cannon.toString();
		// String expected = "Cannon at [10,10]";
		// assertEquals(expected, cannon.toString());
	}
}