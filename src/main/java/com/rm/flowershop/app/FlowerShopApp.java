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
 * This is the main class of the solution.
 * It has methods that allow you to order some flowers.
 * Also allows you to check if there are any flowers in the inventory.
 * @author hawk
 *
 */
public class FlowerShopApp {
	
	private static final Logger logger = LogManager.getLogger();
	
	private List<Bundle> flowersInInventory = new ArrayList<>();
	
	/**
	 * Initialize the app. Populate the inventory.
	 * @param bundles - inventory of flowers.
	 */
	public FlowerShopApp(List<Bundle> bundles) {
		if(null != bundles && !bundles.isEmpty()) {
			this.flowersInInventory = bundles;
		}
		else {
			logger.warn("Don't pass empty bundles! How can I fulfill your order?");
		}
	}

	/**
	 * Test whether the shop has flowers.
	 * @return - true if flowers exist, false otherwise.
	 */
	public boolean areFlowersAvailable() {
		return !this.flowersInInventory.isEmpty();
	}
	
	/**
	 * Order some flowers of a single type.
	 * @param order - @Order class instance that defines how
	 *  many flowers of a particular type are requested.
	 * @return - Map of <@Bundle used, @Integer - Number of such bundles needed>
	 * - returns null if a solution wasn't possible.
	 */
	public Map<Bundle, Integer> orderFlower(Order order) {
		if(order!=null && this.areFlowersAvailable()) {
			List<Bundle> bundlesOfCurrentFlowerOnly = new ArrayList<>();
			for (Bundle bundle : this.flowersInInventory) {
				if(order.getItemCode().equals(bundle.getFlower().getFlowerCode())) {
					bundlesOfCurrentFlowerOnly.add(bundle);
				}
			}
			Stack<Bundle> result = new Stack<Bundle>();
			if(basicSplittingFunction(bundlesOfCurrentFlowerOnly, order.getQuantity(), result, 0)) {
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

	/**
	 * Places an order involving many flowers of many types.
	 * @param orders - @List of @Order, where each order object defines how many flowers of that type
	 * are requested.
	 * @return - Map of <@Bundle used, @Integer - Number of such bundles needed>
	 * - returns null if a solution wasn't possible.
	 */
	public Map<Bundle, Integer> orderABunch(List<Order> orders) {
		if(orders!=null && this.areFlowersAvailable()) {
			HashMap<Bundle, Integer> finalResult = new HashMap<>();
			Map<Bundle, Integer> temp;
			for (Order order : orders) {
				temp = orderFlower(order);
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
	
	/**
	 * This function will find the bundle that fits the best considering the remaining quantity.
	 * @param piecesPerBundle - @List of @Bundle being considered.
	 * @param remainingQty - number of flowers remaining to be fulfilled. 
	 * @return - @List of @Bundle containing the best fit of bundles.
	 * empty @List if nothing fits.
	 */
	private static List<Bundle> findFittingBundle(List<Bundle> piecesPerBundle, int remainingQty) {
		List<Bundle> fittingBundles = new ArrayList<>();
		for (int i = 0; i< piecesPerBundle.size(); i++) {
			if (piecesPerBundle.get(i).getPieces() <= remainingQty)
				fittingBundles.add(piecesPerBundle.get(i));
		}
		return fittingBundles;
	}
	
	/**
	 * Recursive function that will split the requested quantity into number of @Bundle that
	 * are required. 
	 * @param piecesPerBundle - @List of @Bundle being considered.
	 * @param requestedQty - number of flowers requested in the order.
	 * @param result - @Stack of @Bundle that gets updated with each recursion. At the end,
	 * this stack will have the bundles that may fulfill this order.
	 * @param totalSoFar - running total of flowers accounted for.
	 * @return - true if order can be fulfilled, false otherwise.
	 */
	private boolean basicSplittingFunction(List<Bundle> piecesPerBundle,
			int requestedQty, Stack<Bundle> result, int totalSoFar) {
		

		if (requestedQty - totalSoFar == 0) {
			return true;
		}
		else {
			List<Bundle> possibleBundles = findFittingBundle(piecesPerBundle, (requestedQty-totalSoFar));
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
