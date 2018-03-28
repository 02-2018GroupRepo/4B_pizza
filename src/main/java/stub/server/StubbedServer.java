package stub.server;

public class StubbedServer {

	private static String answer = "[STUBBED]: Today's Special\n"
			+ "Peperoni: 12.00\n"
			+ "Sausage: 11.00\n"
			+ "Cheese: 10.00";
	
	@SuppressWarnings("unchecked")
	public <T>T getForObject(String string, Class<String> class1) {
		return (T)answer;
	}
}
