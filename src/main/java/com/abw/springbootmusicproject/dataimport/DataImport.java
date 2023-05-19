package com.abw.springbootmusicproject.dataimport;

import com.abw.springbootmusicproject.model.Role;
import com.abw.springbootmusicproject.model.User;
import com.abw.springbootmusicproject.repository.RoleRepository;
import com.abw.springbootmusicproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataImport implements ApplicationRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    @Autowired
    public DataImport(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(!userRepository.findByUsername("admin").isPresent()) {
            Role roleAdmin = new Role("ADMIN");
            roleRepository.save(roleAdmin);
            Role roleCreator = new Role("CREATOR");
            roleRepository.save(roleCreator);
            Role roleListener = new Role("LISTENER");
            roleRepository.save(roleListener);

            User admin = new User("admin", "AdminName", "AdminLastName", "admin@musicapp.com", passwordEncoder.encode("123"), roleAdmin);
            userRepository.save(admin);


        }
    }
}
