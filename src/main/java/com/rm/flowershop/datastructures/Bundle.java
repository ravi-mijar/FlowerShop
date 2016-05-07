/**
 * 
 */
package com.rm.flowershop.datastructures;

/**
 * Class defines the pieces per bundle and the price.
 * @author hawk
 *
 */
public class Bundle {
	
	/**
	 * Number of pieces each bundle will have.
	 */
	private int pieces;
	/**
	 * This is the price per bundle, NOT per piece.
	 */
	private float pricePerBundle;
	
	private Item item;
	
	
	public Bundle(int pieces, float pricePerBundle, Item it) {
		super();
		this.pieces = pieces;
		this.pricePerBundle = pricePerBundle;
		this.item = it;
	}
	/**
	 * @return the pieces
	 */
	public int getPieces() {
		return pieces;
	}
	/**
	 * @return the pricePerBundle
	 */
	public float getPricePerBundle() {
		return pricePerBundle;
	}
	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}
	
}
