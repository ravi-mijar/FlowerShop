/**
 * 
 */
package com.rm.flowershop.datastructures;

/**
 * @author hawk
 *
 */
public class Order {
	
	private int quantity;
	private String itemCode;
	
	public Order(int qty, String itemCode) {
		this.quantity = qty;
		this.itemCode = itemCode;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * @return the itemCode
	 */
	public String getItemCode() {
		return itemCode;
	}
}
