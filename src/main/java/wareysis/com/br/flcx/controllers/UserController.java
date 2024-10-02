package wareysis.com.br.flcx.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import wareysis.com.br.flcx.models.UserModel;
import wareysis.com.br.flcx.models.dto.NewUserDTO;
import wareysis.com.br.flcx.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<UserModel> createNewUser(@RequestBody NewUserDTO newUser) {
		UserModel newUserModel = userService.createNewUser(newUser.email(), newUser.password(), newUser.fullName());
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri().path("/{uid}")
				.buildAndExpand(newUserModel.getUid())
				.toUri();
		return ResponseEntity.created(uri).body(newUserModel);
	}
	
	@GetMapping("/{email}")
	public void getUserByEmail(@PathVariable String email) {
		userService.getUserByEmail(email);
	}

}
