package day4Assignment2;

import java.time.LocalDate;
import day4Assignment2.Abstract.BaseCustomerManager;
import day4Assignment2.Concrete.NeroCustomerManager;
import day4Assignment2.Concrete.StarbucksCustomerManager;
import day4Assignment2.Entities.Customer;
import day4Assignment2.Adapters.MernisServiceAdapter;

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
