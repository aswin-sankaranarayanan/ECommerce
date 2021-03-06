package com.ecommerce.apis;

import static com.ecommerce.AppConstants.USER_SIGNUP_SUCCESS;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.dtos.ResponseDTO;
import com.ecommerce.dtos.UserRequestDTO;
import com.ecommerce.dtos.UserResponseDTO;
import com.ecommerce.security.LoginDTO;
import com.ecommerce.security.LoginResponseDTO;
import com.ecommerce.services.UserService;

@RestController
@RequestMapping("/api/user-management")
public class UserManagementAPI {

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<ResponseDTO> signup(@Valid @RequestBody UserRequestDTO userDTO) {
		UserResponseDTO savedUserDTO = userService.signUp(userDTO);
		ResponseDTO responseDTO = new ResponseDTO(USER_SIGNUP_SUCCESS, savedUserDTO);
		return ResponseEntity.ok(responseDTO);
	}
	
	@PostMapping("/email/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO) {
		LoginResponseDTO loginResponseDTO = userService.login(loginDTO);
		return ResponseEntity.ok(loginResponseDTO);
	}
	
	@GetMapping
	public ResponseEntity<LoginResponseDTO> getLoggedInUser(){
		LoginResponseDTO loginResponseDTO = userService.getLoggedInUser();
		return ResponseEntity.ok(loginResponseDTO);
	}
	
	

}
