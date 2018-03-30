package bootcamp.dao;

import bootcamp.model.Location;

import java.util.HashMap;
import java.util.Map;

public class LookUpDao {
	
	private Map<String, Location> locationMap = new HashMap<>();
	private Map<String, Double> order = new HashMap<>();

	public String putInOrder(String pizza, double price) {
		if(!order.containsKey(pizza)) order.put(pizza, price);
		else order.put(pizza, price + order.get(pizza));
		return pizza + " is in the order";
	}

	public String removeOrder(String pizza) {
		order.remove(pizza);
		return pizza + " is removed";
	}

	public Location getLocationByName(String name) {
		if(!locationMap.isEmpty()) {
			return locationMap.get(name);
		} else {
			System.err.println("[ERROR]: Currently Empty");
			return null;
		}
	}
	
	public void createNewLocation(String name) {
		locationMap.put(name, new Location(name));
	}

	public Map<String, Double> getOrder() {
		return order;
	}
}
