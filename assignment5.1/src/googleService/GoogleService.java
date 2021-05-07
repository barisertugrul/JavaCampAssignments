package googleService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class GoogleService {

	public List<String> register() {
		Scanner userGoogleKeyboard = new Scanner(System.in);
		System.out.println("\n----------------------------");
		System.out.println("GOOGLE REGISTER");
		System.out.println("----------------------------");
		System.out.print("Email Adress: ");
		String email = userGoogleKeyboard.next();
		System.out.print("Password: ");
		String password = userGoogleKeyboard.next();
		System.out.print("First Name: ");
		String firstName = userGoogleKeyboard.next();
		System.out.print("Last Name: ");
		String lastName = userGoogleKeyboard.next();
		ArrayList<String> userInformation = new ArrayList<>(Arrays.asList(email, firstName, lastName));

		return userInformation;
	}

	public List<String> login(){
		Scanner userGoogleKeyboard = new Scanner(System.in);
		System.out.println("\n----------------------------");
		System.out.println("GOOGLE LOGIN");
		System.out.println("----------------------------");
		System.out.print("Email Adress: ");
		String email = userGoogleKeyboard.next();
		System.out.print("Password: ");
		String password = userGoogleKeyboard.next();
		System.out.print("First Name: ");
		String firstName = userGoogleKeyboard.next();
		System.out.print("Last Name: ");
		String lastName = userGoogleKeyboard.next();
		ArrayList<String> userInformation = new ArrayList<>(Arrays.asList(email, firstName,lastName));

		userGoogleKeyboard.close();
		return userInformation;
	}
}
