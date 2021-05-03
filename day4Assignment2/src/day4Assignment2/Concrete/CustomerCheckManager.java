package day4Assignment2.Concrete;

import day4Assignment2.Abstract.CustomerCheckService;
import day4Assignment2.Entities.Customer;

public class CustomerCheckManager implements CustomerCheckService {
	
	@Override
	public Boolean CheckIfRealPerson(Customer customer) {
		return true;
	}

}
