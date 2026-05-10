package com.itstech.dharm.jwtandoauth2.service;

import com.itstech.dharm.jwtandoauth2.dao.UserRepo;
import com.itstech.dharm.jwtandoauth2.model.User;
import com.itstech.dharm.jwtandoauth2.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private UserRepo repo;

    @Autowired
    public MyUserDetailsServiceImpl(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found with: " + username);
        }
        return new UserPrincipal(user);
    }
}
