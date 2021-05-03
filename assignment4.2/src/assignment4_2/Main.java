package assignment4_2;

import java.time.LocalDate;

import assignment4_2.Abstract.BaseCustomerManager;
import assignment4_2.Adapters.CustomerCheckManager;
import assignment4_2.Adapters.MernisServiceAdapter;
import assignment4_2.Adapters.TCKNValidate;
import assignment4_2.Concrete.NeroCustomerManager;
import assignment4_2.Concrete.StarbucksCustomerManager;
import assignment4_2.Entities.Customer;

public class Main {

	public static void main(String[] args) {
        
        Customer starbucksCustomer1 = new Customer(
        		"Bar��",
        		"Ertu�rul",
        		LocalDate.of(1977, 01, 01),
        		"12345678910"
        		);
        

        Customer starbucksCustomer2 = new Customer(
        		"Beril",
        		"�zsoy",
        		LocalDate.of(1980, 01, 01),
        		"12345678911"
        		);

        Customer starbucksCustomer3 = new Customer(
        		"Engin",
        		"Demiro�",
        		LocalDate.of(1985, 01, 01),
        		"12345678912"
        		);
        
		//Ger�ek TCKN Kontroll� Kay�t
		BaseCustomerManager starbucksCustomerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		starbucksCustomerManager.save(starbucksCustomer1);
		
		//Sadece TCKN Algoritma Kontroll� Kay�t
		starbucksCustomerManager = new StarbucksCustomerManager(new TCKNValidate());
		starbucksCustomerManager.save(starbucksCustomer2);

		//Fake Do�rulamal� Kay�t
		starbucksCustomerManager = new StarbucksCustomerManager(new CustomerCheckManager());
		starbucksCustomerManager.save(starbucksCustomer3);
		

        
        Customer neroCustomer = new Customer(
        		"�a�an Ege",
        		"Ertu�rul",
        		LocalDate.of(2007, 01, 01),
        		"12345678913"
        		);
        
		BaseCustomerManager neroCustomerManager = new NeroCustomerManager();
		neroCustomerManager.save(neroCustomer);
	}

}
