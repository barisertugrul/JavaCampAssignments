package assignment5_1.business.concretes;

import assignment5_1.business.abstracts.ActivationService;

public class EmailActivationManager implements ActivationService {

	@Override
	public boolean sendActivationCode(String email, String activationCode) {
		// TODO Email adresine aktivasyon kodunun gönderilmesi
		// CreateActivation link: Lİnk parse edildiğinde data kısmından email ve
		// aktivasyon kodu alınabilmeli
		return true;
	}

}
