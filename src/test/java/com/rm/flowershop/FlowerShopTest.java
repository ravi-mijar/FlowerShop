/**
 * 
 */
package com.rm.flowershop;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.rm.flowershop.app.FlowerShopApp;
import com.rm.flowershop.datastructures.Bundle;
import com.rm.flowershop.datastructures.FlowerFactory;
import com.rm.flowershop.datastructures.Order;

/**
 * @author hawk
 *
 */
public class FlowerShopTest {

	private FlowerShopApp shop = null;
	
	private List<Bundle> lilyBundles = new ArrayList<>();
	private List<Bundle> roseBundles = new ArrayList<>();
	private List<Bundle> tulipBundles = new ArrayList<>();
	
	private List<Bundle> setupLilyBundles() {
		this.lilyBundles.add(new Bundle(9, 24.95f, FlowerFactory.getLily()));
		this.lilyBundles.add(new Bundle(6, 16.95f, FlowerFactory.getLily()));
		this.lilyBundles.add(new Bundle(3, 9.95f, FlowerFactory.getLily()));
		
		return this.lilyBundles;
	}
	
	private List<Bundle> setupRoseBundles() {
		this.roseBundles.add(new Bundle(10, 12.99f, FlowerFactory.getRose()));
		this.roseBundles.add(new Bundle(5, 6.99f, FlowerFactory.getRose()));
		return this.roseBundles;
	}
	
	private List<Bundle> setupTulipBundles() {
		this.tulipBundles.add(new Bundle(9, 16.99f, FlowerFactory.getTulip()));
		this.tulipBundles.add(new Bundle(5, 9.95f, FlowerFactory.getTulip()));
		this.tulipBundles.add(new Bundle(3, 5.95f, FlowerFactory.getTulip()));
		
		return this.tulipBundles;
	}
	
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
		shop = null;
	}

	/**
	 * Normal path
	 */
	@Test @Ignore
	public void validItemCodeSufficientQuantity() {
		fail("Not yet implemented");
	}
	
	/**
	 * Quantity asked is more than inventory holds.
	 */
	@Test @Ignore
	public void validItemCodeInsufficientQuantity() {
		fail("Unimplemented");
	}
	
	/**
	 * Invalid Item code. 
	 * Expect an error.
	 */
	@Test
	@Ignore
	public void invalidItemCode() {
		fail("Unimplemented");
	}
	
	/**
	 * Meaning the quantity asked will not be possible to be divided.
	 */
	@Test
	@Ignore
	public void validItemCodePartialOrder() {
	}

	@Test
	public void multipleFlowersOrder() {
	
		List<Bundle> allFlowerInventory = new ArrayList<>();
		allFlowerInventory.addAll(setupLilyBundles());
		allFlowerInventory.addAll(setupRoseBundles());
		allFlowerInventory.addAll(setupTulipBundles());
		shop = new FlowerShopApp(allFlowerInventory);
		
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(15, FlowerFactory.LILY_CODE));
		orders.add(new Order(13, FlowerFactory.TULIP_CODE));
		orders.add(new Order(10, FlowerFactory.ROSE_CODE));
		
		Map<Bundle, Integer> shipment = shop.orderItems(orders);
		System.out.println("#" + shipment);
	}
	
	
	@Test
	//@Ignore
	public void minBundles() {
		//order qty 30, bundle size 9,6,3
		//it can be 6*5bundles or 9*3 + 3*1 i.e. 4 bundles
		
		shop = new FlowerShopApp(setupLilyBundles());
		
		Order o = new Order(15, FlowerFactory.LILY_CODE);
		Map<Bundle, Integer> map = shop.orderItem(o);
		Iterator<Bundle> it = map.keySet().iterator();
		Bundle temp;
		float totalPrice = 0.0f;
		while(it.hasNext()) {
			temp = it.next();
			if(temp.getPieces() == 9)
				assertEquals(map.get(temp), Integer.valueOf(1));
			if(temp.getPieces() == 6)
				assertEquals(map.get(temp), Integer.valueOf(1));
			totalPrice += (temp.getPricePerBundle() * map.get(temp));
		}
		assertEquals(totalPrice, 41.9f, 0.005);
		System.out.println("& "+ map);
		System.out.println("Total cost is: " + totalPrice);
	}
	
	@Test 
	//@Ignore
	public void bestFitIs2ndBundle() {
		//order qty 8, bundle size 9, 5, 3.
		//I couldn't find a better name for this scenario! :D
		shop = new FlowerShopApp(setupTulipBundles());
		
		Order o = new Order(8, FlowerFactory.TULIP_CODE);
		Map<Bundle, Integer> map = shop.orderItem(o);
		Iterator<Bundle> it = map.keySet().iterator();
		Bundle temp;
		float totalPrice = 0.0f;
		while(it.hasNext()) {
			temp = it.next();
			if(temp.getPieces() == 5)
				assertEquals(map.get(temp), Integer.valueOf(1));
			if(temp.getPieces() == 3)
				assertEquals(map.get(temp), Integer.valueOf(1));
			totalPrice += (temp.getPricePerBundle() * map.get(temp));
		}
		assertEquals(totalPrice, 15.9, 0.01);
	}
	
	@Test
	public void nosolution() {
		//order qty 7, bundle size 9, 6, 3.
		
		shop = new FlowerShopApp(setupLilyBundles());
		
		Order o = new Order(7, FlowerFactory.LILY_CODE);
		Map<Bundle, Integer> map = shop.orderItem(o);
		assertNull(map);
	}
	
	@Test
	public void nullInventory() {
		shop = new FlowerShopApp(null);
		
		shop.orderItem(new Order(8, FlowerFactory.TULIP_CODE));
		assertTrue(shop.isInventoryEmpty());
		
	}
	
}
