package it.jac.javadb.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.jac.javadb.dao.UserRepository;
import it.jac.javadb.entity.User;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//		User user = userRepository.findByUsername(username);
//        if (user == null) {
//        	throw new UsernameNotFoundException(username);
//        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        String roles = "ROLE_USER;ROLE_EDIT;ROLE_DELETE";
        String[] tokens = roles.split(";");
        for(String role : tokens) {
        	grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        // ROLE_USER
        // ROLE_READONLY
        return new org.springframework.security.core.userdetails.User("user1", bCryptPasswordEncoder.encode("123"), grantedAuthorities);    
	}
}
