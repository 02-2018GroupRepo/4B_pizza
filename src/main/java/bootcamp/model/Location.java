package bootcamp.model;

public class Location {
	
	private String locationName;
	
	public Location(String name) {
		locationName = name;
	}
	
	public void setLocation(String name) {
		this.locationName= name;
	}
	
	public String getLocation() {
		return locationName;
	}

}
