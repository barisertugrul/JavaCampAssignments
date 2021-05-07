package assignment5_1.business.abstracts;

public interface ActivationService {
	boolean sendActivationCode(String sendTo, String activationCode);
}
