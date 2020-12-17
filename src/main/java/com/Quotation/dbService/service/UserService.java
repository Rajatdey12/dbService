package com.Quotation.dbService.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Value("${spring.security.user.name}")
	private String userName;

	@Value("${spring.security.user.password}")
	private String password;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return   new User(this.userName, this.password, new ArrayList<>());
	}

}
