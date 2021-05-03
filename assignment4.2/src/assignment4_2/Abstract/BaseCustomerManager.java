package assignment4_2.Abstract;

import assignment4_2.Entities.Customer;

public abstract class BaseCustomerManager implements CustomerService {
	
	@Override
	public void save(Customer customer) {
		System.out.println(customer.getFirstName() + " veritabanýna kaydedildi");
	}
}
