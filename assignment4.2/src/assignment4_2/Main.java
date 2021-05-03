package assignment4_2;

import java.time.LocalDate;

import assignment4_2.Abstract.BaseCustomerManager;
import assignment4_2.Adapters.MernisServiceAdapter;
import assignment4_2.Concrete.NeroCustomerManager;
import assignment4_2.Concrete.StarbucksCustomerManager;
import assignment4_2.Entities.Customer;

public class Main {

	public static void main(String[] args) {
        
        Customer starbucksCustomer = new Customer(
        		"Barýþ",
        		"Ertuðrul",
        		LocalDate.of(1977, 01, 01),
        		"12345678910"
        		);
        
		BaseCustomerManager starbucksCustomerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		starbucksCustomerManager.save(starbucksCustomer);
		

        
        Customer neroCustomer = new Customer(
        		"Çaðan Ege",
        		"Ertuðrul",
        		LocalDate.of(2007, 01, 01),
        		"12345678911"
        		);
        
		BaseCustomerManager neroCustomerManager = new NeroCustomerManager();
		neroCustomerManager.save(neroCustomer);
	}

}
