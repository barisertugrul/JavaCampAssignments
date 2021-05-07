package assignment5_1.business.concretes;

import java.util.List;

import assignment5_1.business.abstracts.ServiceFactory;
import assignment5_1.business.abstracts.UserService;
import assignment5_1.business.abstracts.UserValidationService;
import assignment5_1.dataAccess.abtracts.UserDao;
import assignment5_1.entities.concretes.User;

public class UserManager implements UserService {
	UserDao userDao;
	private UserValidationService validationService;

	public UserManager(ServiceFactory serviceFactory) {
		this.userDao = serviceFactory.createUserDao();
		this.validationService = serviceFactory.userValidationService();
	}

	@Override
	public User add(User user) {
		int userId = userDao.add(user);
		if (userId > 0) {
			user.setId(userId);
			return user;
		}
		return null;
	}

	@Override
	public void update(User user) {
		if (validationService.updateValidate(user)) {
			userDao.update(user);
		} else {
			System.out.println("Lütfen bilgilerinizdekki hatalarý giderip tekrar deneyiniz.");
		}
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);

	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User get(int id) {
		return userDao.getById(id);
	}

	@Override
	public User checkLoginInfo(String email, String password) {
		return userDao.getByLoginInfoComfirm(email, password);
	}

	@Override
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}

	@Override
	public boolean isComfirmActivation(String email) {
		User user = getByEmail(email);
		if (user != null) {
			System.out.println(user.getFirstName());
			if (user.getActivationComfirm())
				return true;
		}
		System.out.println("Kullanýcý bulunamadý");
		return false;
	}

	@Override
	public boolean setUserActivation(String email, String activationCode) {
		User user = userDao.getByEmailAndActivationCode(email, activationCode);
		if (user != null) {
			user.setActivationComfirm(true);
			update(user);
			return true;
		}
		return false;
	}
}
