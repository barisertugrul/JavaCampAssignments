package assignment5_1.business.concretes;

import java.time.LocalDate;

import assignment5_1.business.abstracts.ActivationService;
import assignment5_1.business.abstracts.AuthService;
import assignment5_1.business.abstracts.ServiceFactory;
import assignment5_1.business.abstracts.UserService;
import assignment5_1.business.abstracts.UserValidationService;
import assignment5_1.core.abstracts.ExternalLoginRegisterService;
import assignment5_1.entities.concretes.User;
import assignment5_1.entities.concretes.UserForExternalResults;
import assignment5_1.entities.concretes.UserForLogin;
import assignment5_1.entities.concretes.UserForRegister;

public class AuthManager implements AuthService {

	private UserService userService;
	private ActivationService activationService;
	private UserValidationService validationService;

	public AuthManager(ServiceFactory serviceFactory) {
		this.userService = serviceFactory.userService();
		this.activationService = serviceFactory.activationService();
		this.validationService = serviceFactory.userValidationService();
	}

	@Override
	public User register(UserForRegister userForRegister) {
		boolean checkExistEmail = userExists(userForRegister.getEmail());
		if (checkExistEmail) {
			System.out.println("Bu mail adresi zaten kayýtlý.");
			return null;
		}
		User user = registerComplete(userForRegister, false);
		if (user != null) {
			return user;
		}
		System.out.println("Hata! Kayýt iþleminiz gerçekleþtirilemedi.");
		return null;
	}

	@Override
	public User login(UserForLogin userForLogin) {
		if (userService.isComfirmActivation(userForLogin.getEmail())) {
			User result = userService.checkLoginInfo(userForLogin.getEmail(), userForLogin.getPassword());
			if (result == null) {
				System.out.println("Giriþ baþarýsýz");
			} else {
				System.out.println("Kullanýcý giriþi yapýldý.");
				return result;
			}
		}
		System.out.println("Mail adresi kayýtlý deðil ya da aktivasyon onayý gerçekleþtirilmemiþ.");
		return null;
	}

	@Override
	public User register(ExternalLoginRegisterService externalRegisterService) {
		UserForExternalResults registerResult = externalRegisterService.register();
		if (registerResult != null) {
			boolean checkExistEmail = userExists(registerResult.getEmail());
			if (checkExistEmail) {
				System.out.println("Bu mail adresi zaten kayýtlý.");
				return null;
			}
			UserForRegister userForRegister = new UserForRegister(registerResult.getEmail(), null,
					registerResult.getFirstName(), registerResult.getLastName());
			User user = registerComplete(userForRegister, true);
			if (user != null) {
				return user;
			}

			System.out.println("Baðlantýlý giriþ baþarýlý oldu, ama sisteme kayýt gerçekleþtirilemedi");
			return null;
		}
		System.out.println("Hata! Baðlantýlý kayýt iþlemi gerçekleþtirilemedi.");
		return null;
	}

	@Override
	public User login(ExternalLoginRegisterService externalLoginService) {
		UserForExternalResults loginResult = externalLoginService.login();
		if (loginResult != null) {
			
			if (userService.isComfirmActivation(loginResult.getEmail())) {
				User user = userService.getByEmail(loginResult.getEmail());
				if(user != null) {
					System.out.println("Giriþ iþlemi baþarýlý");
					return user;
				}
			}
		}
		System.out.println("Giriþ iþlemi baþarýsýz");
		return null;
	}

	@Override
	public boolean userExists(String email) {
		User user = userService.getByEmail(email);
		if (user == null) {
			return false;
		}

		return true;
	}

	@Override
	public String createActivationCode(String email) {
		// TODO Email adresine uygun hash
		return "HaShSiMüLaSyOnU12345";
	}

	@Override
	public boolean comfirmActivation(String email, String activationCode) {
		boolean result = userService.setUserActivation(email, activationCode);
		if (result) {
			System.out.println("Aktivasyon iþlemi tamamlandý");
			return true;
		}
		System.out.println("Hata! Aktivasyon iþlemi tamamlanamadý.");
		return false;
	}

	private User registerComplete(UserForRegister userForRegister, boolean isExternal) {
		// Ortak register kodlarý
		User user = new User(userForRegister.getEmail(), userForRegister.getPassword(), userForRegister.getFirstName(),
				userForRegister.getLastName(), LocalDate.now(), createActivationCode(userForRegister.getEmail()));
		if (!isExternal) {
			boolean validate = validationService.registerValidate(user);
			if (!validate) {
				System.out.println("Eksik veya yanlýþ olan bilgiler var. Lütfen kontrol ediniz.");
				return null;
			}
		}
		User addedUser = userService.add(user);
		if (addedUser != null) {
			boolean result = activationService.sendActivationCode(user.getEmail(), addedUser.getActivationCode());
			if (!result) {
				System.out.println("Aktivasyon kodu gönderilemedi");
			}
			System.out.println("Kayýt iþleminiz gerçekleþti.");
			return addedUser;
		}
		return null;
	}

}
