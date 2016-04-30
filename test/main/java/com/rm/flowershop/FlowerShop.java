/**
 * 
 */
package com.rm.flowershop;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hawk
 *
 */
public class FlowerShop {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Normal path
	 */
	@Test
	public void validItemCodeSufficientQuantity() {
		fail("Not yet implemented");
	}
	
	/**
	 * Quantity asked is more than inventory holds.
	 */
	@Test
	public void validItemCodeInsufficientQuantity() {
		fail("Unimplemented");
	}
	
	/**
	 * Invalid Item code. 
	 * Expect an error.
	 */
	@Test
	public void invalidItemCode() {
		fail("Unimplemented");
	}
	
	/**
	 * Meaning the quantity asked will not be possible to be divided.
	 */
	@Test
	public void validItemCodePartialOrder() {
		fail("Unimplemented");
	}

}
