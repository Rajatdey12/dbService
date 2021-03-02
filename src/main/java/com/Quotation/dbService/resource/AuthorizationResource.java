package com.Quotation.dbService.resource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Quotation.dbService.model.AuthenticationRequest;
import com.Quotation.dbService.model.AuthenticationResponse;
import com.Quotation.dbService.security.JwtUtil;
import com.Quotation.dbService.service.UserService;

@RestController
@RequestMapping("/rest/db")
public class AuthorizationResource {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	@RequestMapping("/init")
	public String getInit() {
		return "Authorization end-point";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request)
			throws Exception {
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword())
					);
		}
		catch(BadCredentialsException be) {
			throw new Exception("Incorrect Username or password", be);
		}

		final UserDetails userDetails = userService
				.loadUserByUsername(request.getUserName());
		final String jwtToken = jwtUtil.generateToken(userDetails);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		return ResponseEntity.ok(new AuthenticationResponse(jwtToken, dtf.format(now)));
	}
}
