package ch.epfl.flamemaker.geometry2d;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {
	
	private static double DELTA = 0.000000001;

	@Test
	public void testPoint() {
		new Point(0, 0);
	}
	
	@Test
	public void testX() {
		Point p = new Point(0, 0);
		assertEquals(p.x(), 0, DELTA);
	}
	
	@Test
	public void testY() {
		Point p = new Point(0, 0);
		assertEquals(p.y(), 0, DELTA);
	}
	
	@Test
	public void testR() {
		Point p = new Point (2, 3);
		assertEquals(p.r(), Math.sqrt(2*2 + 3*3), DELTA);
	}
	
	@Test
	public void testTheta() {
		Point p = new Point (2, 3);
		assertEquals(p.theta(), Math.atan2(3, 2), DELTA);
	}
}
