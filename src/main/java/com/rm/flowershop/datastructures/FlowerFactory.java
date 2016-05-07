/**
 * 
 */
package com.rm.flowershop.datastructures;

/**
 * This class has methods to return specific flower objects needed by app. 
 * @author hawk
 *
 */
public class FlowerFactory {
	
	//keeping these constants default. Haven't used them anywhere else.
	static final String LILY = "lily";
	static final String ROSE = "rose";
	static final String TULIP = "tulip";
	
	//code constants are used in the test package.
	public static final String LILY_CODE = "L09";
	public static final String ROSE_CODE = "R12";
	public static final String TULIP_CODE = "T58";
	
	private static Item lilyObject = new Item(LILY, LILY_CODE);
	private static Item roseObject = new Item(ROSE, ROSE_CODE);
	private static Item tulipObject = new Item(TULIP, TULIP_CODE);
	
	public static Item getLily() {
		if (lilyObject == null)
			lilyObject = new Item(LILY, LILY_CODE);
		return lilyObject;
	}
	
	public static Item getRose() {
		if(roseObject == null) 
			roseObject = new Item(ROSE, ROSE_CODE);
		return roseObject;
	}
	
	public static Item getTulip() {
		if(tulipObject == null) 
			tulipObject = new Item(TULIP, TULIP_CODE);
		return tulipObject;
	}

}
