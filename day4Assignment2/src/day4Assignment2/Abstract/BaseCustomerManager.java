package day4Assignment2.Abstract;

import day4Assignment2.Entities.Customer;

public abstract class BaseCustomerManager implements CustomerService {
	
	@Override
	public void save(Customer customer) {
		System.out.println(customer.getFirstName() + " veritabanưna kaydedildi");
	}
}
