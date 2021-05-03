package assignment4_2.Adapters;

import assignment4_2.Abstract.CustomerCheckService;
import assignment4_2.Entities.Customer;

public class TCKNValidate implements CustomerCheckService {
	
	@Override
	public boolean checkIfRealPerson(Customer customer) {
		return isTCKN(customer.getNationalityId());
	}
	
	private boolean isTCKN(String tckn) {
        boolean isValid = false;
        if (tckn != null && tckn.length() == 11 && isInt(tckn)) {
            long aTcNo, bTcNo, tcNo;
            long n1, n2, n3, n4, n5, n6, n7, n8, n9, control1, control2;
            tcNo = Long.parseLong(tckn);
            aTcNo = tcNo / 100;
            bTcNo = tcNo / 100;
            n1 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n2 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n3 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n4 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n5 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n6 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n7 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n8 = aTcNo % 10;
            aTcNo = aTcNo / 10;
            n9 = aTcNo % 10;
            control1 = ((10 - ((((n1 + n3 + n5 + n7 + n9) * 3) + (n2 + n4 + n6 + n8)) % 10)) % 10);
            control2 = ((10 - (((((n2 + n4 + n6 + n8) + control1) * 3) + (n1 + n3 + n5 + n7 + n9)) % 10)) % 10);
            isValid = ((bTcNo * 100) + (control1 * 10) + control2 == tcNo);
        }
        return isValid;
    }

    private boolean isInt(String s)  // assuming integer is in decimal number system
    {
        for (int a = 0; a < s.length(); a++) {
            if (a == 0 && s.charAt(a) == '-') continue;
            if (!Character.isDigit(s.charAt(a))) return false;
        }
        return true;
    }
}
