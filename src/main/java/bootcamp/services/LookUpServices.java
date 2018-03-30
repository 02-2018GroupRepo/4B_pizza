package bootcamp.services;

import bootcamp.dao.LookUpDao;
import bootcamp.model.Location;

public class LookUpServices {
	
	private LookUpDao lookupdao = new LookUpDao();
	
	public Location getLocationByName(String name) {
		return lookupdao.getLocationByName(name);
	}

	public void createNewLocation(String name) {
		lookupdao.createNewLocation(name);
	}

	public LookUpDao getLookupdao() {
		return lookupdao;
	}
}
