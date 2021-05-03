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
        		"Barýþ",
        		"Ertuðrul",
        		LocalDate.of(1977, 01, 01),
        		"12345678910"
        		);
        

        Customer starbucksCustomer2 = new Customer(
        		"Beril",
        		"Özsoy",
        		LocalDate.of(1980, 01, 01),
        		"12345678911"
        		);

        Customer starbucksCustomer3 = new Customer(
        		"Engin",
        		"Demiroð",
        		LocalDate.of(1985, 01, 01),
        		"12345678912"
        		);
        
		//Gerçek TCKN Kontrollü Kayýt
		BaseCustomerManager starbucksCustomerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		starbucksCustomerManager.save(starbucksCustomer1);
		
		//Sadece TCKN Algoritma Kontrollü Kayýt
		starbucksCustomerManager = new StarbucksCustomerManager(new TCKNValidate());
		starbucksCustomerManager.save(starbucksCustomer2);

		//Fake Doðrulamalý Kayýt
		starbucksCustomerManager = new StarbucksCustomerManager(new CustomerCheckManager());
		starbucksCustomerManager.save(starbucksCustomer3);
		

        
        Customer neroCustomer = new Customer(
        		"Çaðan Ege",
        		"Ertuðrul",
        		LocalDate.of(2007, 01, 01),
        		"12345678913"
        		);
        
		BaseCustomerManager neroCustomerManager = new NeroCustomerManager();
		neroCustomerManager.save(neroCustomer);
	}

}
