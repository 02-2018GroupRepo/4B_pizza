package bootcamp.dao;

import java.util.Map;
import java.util.HashMap;
import bootcamp.model.Location;

public class LookupDao {
	
	private Map<String, Location> locationMap = new HashMap<>();
	
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
    
}
