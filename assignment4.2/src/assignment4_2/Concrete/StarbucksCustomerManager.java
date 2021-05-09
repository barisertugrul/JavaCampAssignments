package assignment4_2.Concrete;

import assignment4_2.Abstract.BaseCustomerManager;
import assignment4_2.Abstract.CustomerCheckService;
import assignment4_2.Entities.Customer;

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
