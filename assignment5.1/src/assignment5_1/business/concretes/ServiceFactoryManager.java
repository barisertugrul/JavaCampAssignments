package assignment5_1.business.concretes;

import assignment5_1.business.abstracts.ActivationService;
import assignment5_1.business.abstracts.ServiceFactory;
import assignment5_1.business.abstracts.UserService;
import assignment5_1.business.abstracts.UserValidationService;
import assignment5_1.core.abstracts.ExternalLoginRegisterService;
import assignment5_1.core.adapters.GoogleLoginRegisterAdapter;
import assignment5_1.dataAccess.abtracts.UserDao;
import assignment5_1.dataAccess.concretes.JavaCampUserDao;

public class ServiceFactoryManager implements ServiceFactory {

	private UserDao userDao;
	private UserValidationService userValidationService;
	private UserService userService;
	private ActivationService activationService;
	private ExternalLoginRegisterService externalLoginRegisterService;

	@Override
	public UserDao createUserDao() {
		// return this.userDao;
		return new JavaCampUserDao();
	}

	@Override
	public void release(UserDao userDao) {
		this.userDao = userDao;

	}

	@Override
	public UserValidationService userValidationService() {
		// return this.userValidationService;
		return new UserValidationManager();
	}

	@Override
	public void release(UserValidationService userValidationService) {
		this.userValidationService = userValidationService;

	}

	@Override
	public UserService userService() {
		// return this.userService;
		return new UserManager(this);
	}

	@Override
	public void release(UserService userService) {
		this.userService = userService;

	}

	@Override
	public ActivationService activationService() {
		// return this.activationservice;
		return new EmailActivationManager();
	}

	@Override
	public void release(ActivationService activationService) {
		this.activationService = activationService;

	}

	@Override
	public ExternalLoginRegisterService externalLoginRegisterService() {
		// return this.externalLoginRegisterService;
		return new GoogleLoginRegisterAdapter();
	}

	@Override
	public void release(ExternalLoginRegisterService externalLoginRegisterService) {
		this.externalLoginRegisterService = externalLoginRegisterService;

	}

}
