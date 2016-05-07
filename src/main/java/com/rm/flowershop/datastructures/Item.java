/**
 * 
 */
package com.rm.flowershop.datastructures;

/**
 * Class will maintain the information about the item.
 * @author hawk
 *
 */
public class Item {

	private String itemName;
	private String itemCode;
	
	public Item(String itemName, String itemCode) {
		super();
		this.itemName = itemName;
		this.itemCode = itemCode;
	}
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * @return the itemCode
	 */
	public String getItemCode() {
		return itemCode;
	}
}
