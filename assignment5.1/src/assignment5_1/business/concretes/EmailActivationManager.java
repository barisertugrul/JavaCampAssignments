package assignment5_1.business.concretes;

import assignment5_1.business.abstracts.ActivationService;

public class EmailActivationManager implements ActivationService {

	@Override
	public boolean sendActivationCode(String email, String activationCode) {
		// TODO Email adresine aktivasyon kodunun g�nderilmesi
		// CreateActivation link: L�nk parse edildi�inde data k�sm�ndan email ve
		// aktivasyon kodu al�nabilmeli
		return true;
	}

}
