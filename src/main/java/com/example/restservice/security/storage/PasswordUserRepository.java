package com.example.restservice.security.storage;

import com.example.restservice.security.UserIdentificationInformation;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PasswordUserRepository {

    private final Map<String, UserIdentificationInformation> repository = new HashMap<>();

    public void addIdentificationInformation(UserIdentificationInformation userIdentificationInformation) {
        repository.put(userIdentificationInformation.getUsername(), userIdentificationInformation);
    }

    public UserIdentificationInformation getUserIdentificationInformation(String username) {

        UserIdentificationInformation userIdentificationInformation = repository.get(username);

        if (userIdentificationInformation == null) {
            throw new UsernameNotFoundException("Пользователь под логином: " + username + "не найден");
        }

        return userIdentificationInformation;
    }
}
