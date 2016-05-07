package com.rm.flowershop.datastructures;

/**
 * Class will maintain the information about the item.
 * @author hawk
 *
 */
public class Flower {

	private String flowerName;
	private String flowerCode;
	
	//keeping these constants default. Haven't used them anywhere else.
	static final String LILY = "lily";
	static final String ROSE = "rose";
	static final String TULIP = "tulip";

	//code constants are used in the test package.
	public static final String LILY_CODE = "L09";
	public static final String ROSE_CODE = "R12";
	public static final String TULIP_CODE = "T58";

	private static Flower lilyObject = new Flower(LILY, LILY_CODE);
	private static Flower roseObject = new Flower(ROSE, ROSE_CODE);
	private static Flower tulipObject = new Flower(TULIP, TULIP_CODE);

	/**
	 * Static factory method to return an instance of a Lily @Flower.
	 * @return - a @Flower of type lily.
	 */
	public static Flower getLily() {
		if (lilyObject == null)
			lilyObject = new Flower(LILY, LILY_CODE);
		return lilyObject;
	}

	/**
	 * Static factory method to return an instance of a Rose @Flower.
	 * @return - a @Flower of type rose.
	 */
	public static Flower getRose() {
		if(roseObject == null) 
			roseObject = new Flower(ROSE, ROSE_CODE);
		return roseObject;
	}

	/**
	 * Static factory method to return an instance of a Tulip @Flower.
	 * @return - a @Flower of type tulip.
	 */
	public static Flower getTulip() {
		if(tulipObject == null) 
			tulipObject = new Flower(TULIP, TULIP_CODE);
		return tulipObject;
	}
	
	/**
	 * Suppressed constructor because we have static factory methods.
	 * @param itemName
	 * @param itemCode
	 */
	private Flower(String itemName, String itemCode) {
		super();
		this.flowerName = itemName;
		this.flowerCode = itemCode;
	}
	/**
	 * @return the flowerName
	 */
	public String getFlowerName() {
		return flowerName;
	}
	
	/**
	 * @return the flowerCode
	 */
	public String getFlowerCode() {
		return flowerCode;
	}
}
