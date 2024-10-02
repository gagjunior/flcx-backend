package wareysis.com.br.flcx.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wareysis.com.br.flcx.models.UserModel;
import wareysis.com.br.flcx.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserModel createNewUser(String email, String password, String fullName) {

		Optional<UserModel> userModel = userRepository.createNewUser(email, password, fullName);

		return userModel.isPresent() ? userModel.get() : null;
	}

	public void getUserByEmail(String email) {
		userRepository.getUserByEmail(email);
	}

}
