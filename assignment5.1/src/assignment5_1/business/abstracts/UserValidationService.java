package assignment5_1.business.abstracts;

import assignment5_1.entities.concretes.User;

public interface UserValidationService {
	
	boolean registerValidate(User user);

	boolean updateValidate(User user);
}
