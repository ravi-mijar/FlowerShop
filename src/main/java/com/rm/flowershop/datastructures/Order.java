package com.rm.flowershop.datastructures;

/**
 * Class that defines the quantity of the flowers requested.
 * @author hawk
 *
 */
public class Order {
	
	private int quantity;
	private String flowerCode;
	
	public Order(int qty, String flCode) {
		this.quantity = qty;
		this.flowerCode = flCode;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * @return the flowerCode
	 */
	public String getItemCode() {
		return flowerCode;
	}
}
