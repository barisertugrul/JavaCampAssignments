package assignment5_1.business.concretes;

import assignment5_1.business.abstracts.ActivationService;

public class EmailActivationManager implements ActivationService {

	@Override
	public boolean sendActivationCode(String email, String activationCode) {
		// TODO Email adresine aktivasyon kodunun gönderilmesi
		// CreateActivation link: LÝnk parse edildiðinde data kýsmýndan email ve
		// aktivasyon kodu alýnabilmeli
		return true;
	}

}
