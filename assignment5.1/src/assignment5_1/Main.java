package assignment5_1;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import assignment5_1.business.concretes.AuthManager;
import assignment5_1.business.concretes.ServiceFactoryManager;
import assignment5_1.business.concretes.UserManager;

import assignment5_1.core.adapters.GoogleLoginRegisterAdapter;

import assignment5_1.entities.concretes.User;
import assignment5_1.entities.concretes.UserForLogin;
import assignment5_1.entities.concretes.UserForRegister;

public class Main {
	
	static Scanner userKeyboard = new Scanner(System.in);
	public static void main(String[] args) throws IOException {

		AuthManager authManager = new AuthManager(new ServiceFactoryManager());

		// Baþarýsýz register denemesi
		System.out.println("---------------------------");
		System.out.println("Baþarýsýz register denemesi");
		System.out.println("---------------------------\n");

		UserForRegister userForRegister = new UserForRegister("lklkjklj", null, "b", "c");
		authManager.register(userForRegister);

		// Baþarýlý register denemesi
		System.out.println("---------------------------");
		System.out.println("Baþarýlý register denemesi");
		System.out.println("---------------------------\n");

		userForRegister = new UserForRegister("baris@baris.com", "123456", "Barýþ", "Ertuðrul");
		authManager.register(userForRegister);

		userForRegister = new UserForRegister("engin@engin.com", "123456", "Engin", "Demiroð");
		authManager.register(userForRegister);
		
		UserForLogin loginForm = new UserForLogin("baris@baris.com", "123456");
		
		authManager.login(loginForm);
		
		authManager.comfirmActivation("baris@baris.com", "HaShSiMüLaSyOnU12345");
		menu();
	}

	private static void googleRegister() {
		AuthManager authManager = new AuthManager(new ServiceFactoryManager());
		authManager.register(new GoogleLoginRegisterAdapter());
	}

	private static void googleLogin() {
		AuthManager authManager = new AuthManager(new ServiceFactoryManager());
		authManager.login(new GoogleLoginRegisterAdapter());
	}

	private static void login() {

		
		System.out.println("\n----------------------------");
		System.out.println("LOGIN");
		System.out.println("----------------------------");
		System.out.print("Email Adress: ");
		String email = userKeyboard.next();
		System.out.print("Password: ");
		String password = userKeyboard.next();

		UserForLogin userForLogin = new UserForLogin(email, password);
		AuthManager authManager = new AuthManager(new ServiceFactoryManager());
		authManager.login(userForLogin);
	}

	private static void register() {

	
		System.out.println("\n----------------------------");
		System.out.println("REGISTER");
		System.out.println("----------------------------");
		System.out.print("Email Adress: ");
		String email = userKeyboard.next();
		System.out.print("Password: ");
		String password = userKeyboard.next();
		System.out.print("First Name: ");
		String firstName = userKeyboard.next();
		System.out.print("Last Name: ");
		String lastName = userKeyboard.next();
		
		UserForRegister userForRegister = new UserForRegister(email, password, firstName, lastName);

		AuthManager authManager = new AuthManager(new ServiceFactoryManager());
		authManager.register(userForRegister);

	}

	private static void userList() {
		// Tüm kullanýcýlarýn listelenmesi
		System.out
				.println("\n****************************************************************************************");
		System.out.println("======================================== Users =========================================");
		System.out
				.println("****************************************************************************************\n");

		System.out.format("%4s%13s%30s%45s", "No", "  Kayýt Tarihi ", "Ýsim-Soyisim", "E-Posta Adresi\n");
		System.out.format("%4s%13s%30s%45s", "--", "------------", "------------", "--------------\n");
		UserManager userManager = new UserManager(new ServiceFactoryManager());
		List<User> users = userManager.getAll();
		for (User user : users) {

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			String regDateString = dtf.format(user.getRegisterDate());

			System.out.format("%4s%13s%30s%45s", user.getId(), regDateString,
					user.getFirstName() + " " + user.getLastName(), user.getEmail() + "\n");

		}
	}

	private static void menu() throws IOException {
		boolean exit = false;
		
		while (!exit) {
			
			System.out.println("=====================================");
			System.out.println("================ MENU ===============");
			System.out.println("=====================================\n");

			System.out.println("Enter operation number");
			System.out.println("1-Login");
			System.out.println("2-Register");
			System.out.println("3-Google Login");
			System.out.println("4-Google register");
			System.out.println("5-User List");
			System.out.println("6-Exit");
			
			
			System.out.print("Chose: ");
			String menuItem = userKeyboard.next();

			switch(menuItem) {
				case "1":
					login();
					break;
				case "2":
					register();
					break;
				case "3":
					googleLogin();
					break;
				case "4":
					googleRegister();
					break;
				case "5":
					userList();
					break;
				case "6":
					exit = true;
					break;
				default:
					exit = true;
					break;
			}
			System.out.println("\n******** Press any key to continue... ");
			System.in.read();
		}

		
	}

}
