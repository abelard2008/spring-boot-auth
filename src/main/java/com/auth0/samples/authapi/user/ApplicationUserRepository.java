package com.auth0.samples.authapi.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by abelard on 2018/5/17.
 */
public interface ApplicationUserRepository  extends JpaRepository<ApplicationUser, Long> {
	ApplicationUser findByUsername(String username);
}
