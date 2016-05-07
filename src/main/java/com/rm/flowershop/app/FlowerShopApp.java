/**
 * 
 */
package com.rm.flowershop.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rm.flowershop.datastructures.Bundle;
import com.rm.flowershop.datastructures.Order;

/**
 * @author hawk
 *
 */
public class FlowerShopApp {
	
	private static final Logger logger = LogManager.getLogger();
	
	private List<Bundle> currentBundles = new ArrayList<>();
	
	public FlowerShopApp(List<Bundle> bundles) {
		if(null != bundles && !bundles.isEmpty()) {
			this.currentBundles = bundles;
		}
		else {
			logger.warn("Don't pass empty bundles! How can I fulfill your order?");
		}
	}

	public boolean isInventoryEmpty() {
		return this.currentBundles.isEmpty();
	}
	
	public Map<Bundle, Integer> orderItem(Order order) {
		if(order!=null && !this.isInventoryEmpty()) {
			Stack<Bundle> result = new Stack<Bundle>();
			if(basicSplittingFunction(this.currentBundles, order.getQuantity(), result, 0)) {
				HashMap<Bundle, Integer> noOfBundles = new HashMap<>();
				Bundle temp = null;
				while(!result.isEmpty()) {
					temp = result.pop();
					if(noOfBundles.containsKey(temp)) {
						Integer x = noOfBundles.get(temp);
						noOfBundles.replace(temp, x, Integer.valueOf(x + 1));
					}
					else {
						noOfBundles.put(temp, 1);
					}
				}
				return noOfBundles;
			}
		}
		else {
			logger.warn("Check if you have set the inventory. Or check if you have passed an empty order.");
		}
		return null;
	}

	public Map<Bundle, Integer> orderItems(List<Order> orders) {
		if(orders!=null && !this.isInventoryEmpty()) {
			HashMap<Bundle, Integer> finalResult = new HashMap<>();
			Map<Bundle, Integer> temp;
			for (Order order : orders) {
				temp = orderItem(order);
				if(temp != null) 
					finalResult.putAll(temp);
			}
			return finalResult;
		}
		else {
			logger.warn("Check if you have set the inventory. Or check if you have passed an empty order.");
		}
		return null;
	}
	
	private static List<Bundle> findFittingBundle(List<Bundle> piecesPerBundle, int remainingQty) {
		List<Bundle> array = new ArrayList<>();
		for (int i = 0; i< piecesPerBundle.size(); i++) {
			if (piecesPerBundle.get(i).getPieces() <= remainingQty)
				array.add(piecesPerBundle.get(i));
		}
		return array;
	}
	
	private boolean basicSplittingFunction(List<Bundle> piecesPerBundle,
			int requestedQty, Stack<Bundle> result, int totalSoFar) {
		
		List<Bundle> possibleBundles;
		if (requestedQty - totalSoFar == 0) {
			return true;
		}
		else {
			possibleBundles = findFittingBundle(piecesPerBundle, (requestedQty-totalSoFar));
			if(possibleBundles.isEmpty()) {
				//nothing to do. No solution.
				result.pop();
				return false;
			}
			else {
				for(Bundle bundle : possibleBundles) {
					totalSoFar += bundle.getPieces();
					result.push(bundle);
					boolean res = basicSplittingFunction(piecesPerBundle, requestedQty, result, totalSoFar);
					if(!res) {
						totalSoFar -= bundle.getPieces();
						continue;
					}
					else {
						return res;
					}
				}
			}
			if(requestedQty - totalSoFar == 0)
				return true;
			else return false;
		}
	}
}
