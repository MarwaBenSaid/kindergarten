package tn.esprit.spring.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repositories.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired 
	UserRepository userrepository ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(userrepository.Auth(username)==null) {
			throw new UsernameNotFoundException("No user with: " + username);
				}
		return new User(userrepository.Auth(username).getUsername(),userrepository.Auth(username).getPassword(),new ArrayList<>());

}
}