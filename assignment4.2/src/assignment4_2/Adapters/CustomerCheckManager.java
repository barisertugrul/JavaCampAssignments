package assignment4_2.Adapters;

import assignment4_2.Abstract.CustomerCheckService;
import assignment4_2.Entities.Customer;

public class CustomerCheckManager implements CustomerCheckService {
	
	@Override
	public boolean checkIfRealPerson(Customer customer) {
		return true;
	}

}
