package assignment5_1.core.abstracts;

import assignment5_1.entities.concretes.UserForExternalResults;

public interface ExternalLoginRegisterService {
	UserForExternalResults login();
	UserForExternalResults register();
}
