/**
 * 
 */
package com.nafu.dsm.strategy;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author xmfang
 *
 */
public class PlaneTest {

	@Test
	public void testcalculateResult() {
		Plane plane = new Plane(1.6, 2.2);
		assertTrue(1.6 * 2.2 == plane.calculateResult());
	}

}
