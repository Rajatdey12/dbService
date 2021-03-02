package com.Quotation.dbService.service;

import java.util.ArrayList;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.Quotation.dbService.model.Quote;
import com.Quotation.dbService.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private QuotesRepository quotesRepository;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserService.class);

	/*
		These two properties userName & password with @Value annotation
		are the optional way to define the values in application.properties
		& fetch values from there.
	 */
	@Value("${spring.security.user.name}")
	private String userName;

	@Value("${spring.security.user.password}")
	private String password;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Quote user = quotesRepository.getUserByUserName(userName);

		LOGGER.info("Username Entered Is:::: " +user.getUserName());
		LOGGER.info("Password Entered Is:::: " +user.getPassword());

		if(user == null) {
			throw new UsernameNotFoundException("Could Not Find User");
		}
		return   new User(user.getUserName(), user.getPassword(), new ArrayList<>());

		//Optional way of fetching the username & password form properties file....
		//return new User(this.userName, this.password, new ArrayList<>());
	}

}
