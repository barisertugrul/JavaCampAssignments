package assignment5_1.business.abstracts;

import assignment5_1.core.abstracts.ExternalLoginRegisterService;
import assignment5_1.entities.concretes.User;
import assignment5_1.entities.concretes.UserForLogin;
import assignment5_1.entities.concretes.UserForRegister;

public interface AuthService {
	User register(UserForRegister userForRegister);

	User login(UserForLogin userForLogin);

	User register(ExternalLoginRegisterService externalRegisterService);

	User login(ExternalLoginRegisterService externalLoginService);

	boolean userExists(String email);

	String createActivationCode(String email);

	boolean comfirmActivation(String email, String activationCode);
}
