package com.example.restservice.services;

import com.example.restservice.security.Role;
import com.example.restservice.security.UserIdentificationInformation;
import com.example.restservice.security.storage.PasswordUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class WelcomeService implements UserDetailsService {

    private PasswordUserRepository passwordUserRepository;

    @PostConstruct
    public void init() {
        save(
                new UserIdentificationInformation(
                Arrays.asList(new Role("USER")),
                new BCryptPasswordEncoder().encode("123456"),
                "User"
        ));
    }

    @Autowired
    public WelcomeService(PasswordUserRepository passwordUserRepository) {
        this.passwordUserRepository = passwordUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return passwordUserRepository.getUserIdentificationInformation(s);
    }

    public void save(UserIdentificationInformation userIdentificationInformation) {
        passwordUserRepository.addIdentificationInformation(userIdentificationInformation);
    }
}
