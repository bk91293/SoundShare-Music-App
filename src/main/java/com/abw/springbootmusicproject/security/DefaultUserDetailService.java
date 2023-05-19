package com.abw.springbootmusicproject.security;

import com.abw.springbootmusicproject.model.User;
import com.abw.springbootmusicproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public DefaultUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        return new UserPrincipal(user);
    }

    private User findByUsername(String username) {
       Optional<User> optionalUser = userRepository.findByUsername(username);
       User user = optionalUser.orElseThrow(()->new UsernameNotFoundException(username));
        return user;
    }
}
