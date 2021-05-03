package day4Assignment2.Concrete;

import day4Assignment2.Abstract.BaseCustomerManager;
import day4Assignment2.Abstract.CustomerCheckService;
import day4Assignment2.Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {

	CustomerCheckService _customerCheckService;
	
	public StarbucksCustomerManager(CustomerCheckService _customerCheckService) {
		this._customerCheckService = _customerCheckService;
	}

	@Override
	public void save(Customer customer) {
		if(_customerCheckService.checkIfRealPerson(customer)) {
			super.save(customer);
		}else {
			System.out.println("Not a valid person");
		}
	}
}
