package com.xoriant.enrollmentapplication.springJWT.controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xoriant.enrollmentapplication.Repository.UserDao;
import com.xoriant.enrollmentapplication.RequestEntities.UserRequest;
import com.xoriant.enrollmentapplication.entities.User;
import com.xoriant.enrollmentapplication.springJWT.response.JwtResponse;
import com.xoriant.enrollmentapplication.springJWT.response.MessageResponse;
import com.xoriant.enrollmentapplication.springJWT.security.jwt.JwtUtils;
import com.xoriant.enrollmentapplication.springJWT.security.services.UserDetailsImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserDao userRepository;

	@Autowired
	PasswordEncoder encoder;

	RestTemplate rt = new RestTemplate();

	@Autowired
	JwtUtils jwtUtils;

	
	  
	  @GetMapping("/login")
	  public ResponseEntity<?> authenticateUser(@RequestParam("email") String email, @RequestParam("password") String password) 
	  {
	  
	  Authentication authentication = authenticationManager.authenticate(new
	  UsernamePasswordAuthenticationToken(email,
			  hashPassword(password)));
	  
	  SecurityContextHolder.getContext().setAuthentication(authentication); String
	  jwt = jwtUtils.generateJwtToken(authentication);
	  
	  UserDetailsImpl userDetails = (UserDetailsImpl)
	  authentication.getPrincipal(); 

	  return ResponseEntity.ok(new JwtResponse(jwt,userDetails.getUserId(),userDetails.getEmailId())); 
	  }
	  private String hashPassword(String password) {
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(password.getBytes());
				byte[] digest = md.digest();
				StringBuffer hexString = new StringBuffer();
				for (int i = 0; i < digest.length; i++) {
					hexString.append(Integer.toHexString(0xFF & digest[i]));
				}
				return hexString.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return null;
		}
	/*
	 * @PostMapping("/register") public ResponseEntity<?> registerUser(@RequestBody
	 * UserRequest signUpRequest) { if
	 * (userRepository.findByEmailId(signUpRequest.getEmailId()) != null) { return
	 * ResponseEntity .badRequest() .body(new
	 * MessageResponse("Error: User is already in use!")); }
	 */
	/*
	 * if (userRepository.existsByEmail(signUpRequest.getEmail())) { return
	 * ResponseEntity .badRequest() .body(new
	 * MessageResponse("Error: Email is already in use!")); }
	 */

	// Create new user's account
	/*
	 * User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
	 * encoder.encode(signUpRequest.getPassword()));
	 * 
	 * Set<String> strRoles = signUpRequest.getRole(); Set<Role> roles = new
	 * HashSet<>();
	 * 
	 * if (strRoles == null) { Role userRole =
	 * roleRepository.findByName(ERole.ROLE_USER) .orElseThrow(() -> new
	 * RuntimeException("Error: Role is not found.")); roles.add(userRole); } else {
	 * strRoles.forEach(role -> { switch (role) { case "admin": Role adminRole =
	 * roleRepository.findByName(ERole.ROLE_ADMIN) .orElseThrow(() -> new
	 * RuntimeException("Error: Role is not found.")); roles.add(adminRole);
	 * 
	 * break; case "mod": Role modRole =
	 * roleRepository.findByName(ERole.ROLE_MODERATOR) .orElseThrow(() -> new
	 * RuntimeException("Error: Role is not found.")); roles.add(modRole);
	 * 
	 * break; default: Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	 * .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	 * roles.add(userRole); } }); }
	 */
	// user.setRoles(roles);
	// userRepository.save(user);
	// return rt.postForEntity("http://localhost:7079/api/register", signUpRequest,
	// UserRequest.class);

	// return ResponseEntity.ok(new MessageResponse("User registered
	// successfully!"));}

}