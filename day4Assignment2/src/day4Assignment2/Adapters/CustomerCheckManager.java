package day4Assignment2.Adapters;

import day4Assignment2.Abstract.CustomerCheckService;
import day4Assignment2.Entities.Customer;

public class CustomerCheckManager implements CustomerCheckService {
	
	@Override
	public boolean checkIfRealPerson(Customer customer) {
		return true;
	}

}
