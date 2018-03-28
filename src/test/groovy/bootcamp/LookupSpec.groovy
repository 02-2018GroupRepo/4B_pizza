package bootcamp

import bootcamp.model.Company
import spock.lang.Specification

class LookupSpec extends Specification {
	
	def "Pizza Prices"(){
		
		given: "A company with a menu"
		
		Company sampleCompany = new Company(); 
		sampleCompany.setMenu("Pepperoni:12.00 Sausage:11.00 Cheese:10.00");
		
		
		when: "We request today's special"
		
		
		
		then: "Company responds with specials"
		
	}

		
}





