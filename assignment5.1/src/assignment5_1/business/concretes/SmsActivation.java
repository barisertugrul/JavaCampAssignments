package assignment5_1.business.concretes;

import assignment5_1.business.abstracts.ActivationService;

public class SmsActivation implements ActivationService {

	@Override
	public boolean sendActivationCode(String phoneNumber, String activationCode) {
		// TODO Ba�ka bir aktivasyon servisi �rne�i. send to activationcode to the phoneNumber
		return true;
	}

}
