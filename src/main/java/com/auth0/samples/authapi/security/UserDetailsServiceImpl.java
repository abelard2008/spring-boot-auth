package com.auth0.samples.authapi.security;


import com.auth0.samples.authapi.user.ApplicationUser;
import com.auth0.samples.authapi.user.ApplicationUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;

/**
 * Created by abelard on 2018/5/17.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private ApplicationUserRepository applicationUserRepository;
	public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
		this.applicationUserRepository = applicationUserRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
		if (applicationUser == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
	}
}