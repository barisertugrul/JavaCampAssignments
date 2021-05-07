package assignment5_1.business.abstracts;

import assignment5_1.core.abstracts.ExternalLoginRegisterService;
import assignment5_1.dataAccess.abtracts.UserDao;

public interface ServiceFactory {
	UserDao createUserDao();
    void release(UserDao userDao);

    UserValidationService userValidationService();
    void release(UserValidationService userValidationService);

    UserService userService();
    void release(UserService userService);
    
    ActivationService activationService();
    void release(ActivationService activationService);
    
    ExternalLoginRegisterService externalLoginRegisterService();
    void release(ExternalLoginRegisterService externalLoginRegisterService);
    
}
