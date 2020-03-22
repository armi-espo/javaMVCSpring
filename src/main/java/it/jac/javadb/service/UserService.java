package it.jac.javadb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.javadb.dao.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
}
