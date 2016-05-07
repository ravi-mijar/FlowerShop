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
	
	private Flower flower;
	
	
	public Bundle(int pieces, float pricePerBundle, Flower it) {
		super();
		this.pieces = pieces;
		this.pricePerBundle = pricePerBundle;
		this.flower = it;
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
	 * @return the flower
	 */
	public Flower getFlower() {
		return flower;
	}
	
}
