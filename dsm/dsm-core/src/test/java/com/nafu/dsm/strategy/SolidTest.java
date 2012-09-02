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
public class SolidTest {

	@Test
	public void test() {
		Solid solid = new Solid(0.85, 2.05, 0.15);
		assertTrue(0.85 * 2.05 + (0.85 + 2.05 * 2) * 0.15 == solid.calculateResult());
	}

}
