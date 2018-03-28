package bootcamp.services;

import bootcamp.dao.LookupDao;
import bootcamp.model.Location;

public class LookUpServices {
	
	private LookupDao lookupdao = new LookupDao();
	
	public Location getLocationByName(String name) {
		return lookupdao.getLocationByName(name);
	}

	public void createNewLocation(String name) {
		lookupdao.createNewLocation(name);
	}
}
