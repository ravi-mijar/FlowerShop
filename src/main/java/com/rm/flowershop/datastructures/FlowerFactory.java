/**
 * 
 */
package com.rm.flowershop.datastructures;

/**
 * @author hawk
 *
 */
public class FlowerFactory {
	
	public static final String LILY = "lily";
	public static final String LILY_CODE = "L09";
	public static final String ROSE = "rose";
	public static final String ROSE_CODE = "R12";
	public static final String TULIP = "Tulip";
	public static final String TULIP_CODE = "T58";
	
	private static Item lily = new Item(LILY, LILY_CODE);
	private static Item rose = new Item(ROSE, ROSE_CODE);
	private static Item tulip = new Item(TULIP, TULIP_CODE);
	
	public static Item getLily() {
		return lily;
	}
	
	public static Item getRose() {
		return rose;
	}
	
	public static Item getTulip() {
		return tulip;
	}

}
