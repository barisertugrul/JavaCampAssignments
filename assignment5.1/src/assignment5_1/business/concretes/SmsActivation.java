package assignment5_1.business.concretes;

import assignment5_1.business.abstracts.ActivationService;

public class SmsActivation implements ActivationService {

	@Override
	public boolean sendActivationCode(String phoneNumber, String activationCode) {
		// TODO Baþka bir aktivasyon servisi örneði. send to activationcode to the phoneNumber
		return true;
	}

}
