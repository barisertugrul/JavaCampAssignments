package assignment5_1.core.adapters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import assignment5_1.core.abstracts.ExternalLoginRegisterService;
import assignment5_1.entities.concretes.UserForExternalResults;
import googleService.GoogleService;

public class GoogleLoginRegisterAdapter implements ExternalLoginRegisterService {

	@Override
	public UserForExternalResults login() {
		GoogleService google = new GoogleService();
		List<String> googleResult = google.register();
		UserForExternalResults loginResult = new UserForExternalResults(googleResult.get(0), null, googleResult.get(1),
				googleResult.get(2), new ArrayList<String>(Arrays.asList("Biþey", "Baþka bir þey")));
		if (loginResult.getEmail() != null)
			System.out.println("Google doðrulamasý baþarýlý.");
		else
			System.out.println("Google doðrulamasý baþarýsýz");
		return loginResult;
	}

	@Override
	public UserForExternalResults register() {
		GoogleService google = new GoogleService();
		List<String> googleResult = google.register();

		if (googleResult != null) {
			UserForExternalResults registerResult = new UserForExternalResults(googleResult.get(0), null,
					googleResult.get(1), googleResult.get(2),
					new ArrayList<String>(Arrays.asList("Biþey", "Baþka bir þey")));
			if (registerResult.getEmail() != null) {
				System.out.println("Google doðrulamasý baþarýlý.");
				return registerResult;
			}
		}
		System.out.println("Google doðrulamasý baþarýsýz");
		return null;
	}

}
