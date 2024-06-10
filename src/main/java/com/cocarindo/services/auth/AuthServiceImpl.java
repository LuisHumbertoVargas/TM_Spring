package com.cocarindo.services.auth;

import com.cocarindo.dtos.SignUpRequest;
import com.cocarindo.dtos.UserDTO;
import com.cocarindo.entities.User;
import com.cocarindo.enums.UserRole;
import com.cocarindo.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @PostConstruct
    private void createAnAdminAccount() {
        Optional<User> optionalUser = userRepository.findByUserRole(UserRole.ADMIN);

        if (optionalUser.isEmpty()) {
            User newAdmin = new User();
            newAdmin.setName("Admin");
            newAdmin.setEmail("admin@test.com");
            newAdmin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            newAdmin.setUserRole(UserRole.ADMIN);
            userRepository.save(newAdmin);
        } else {
            System.out.println("Admin account already exists!");
        }
    }

    @Override
    public UserDTO signUp(SignUpRequest signUpRequest) {
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setUserRole(UserRole.EMPLOYEE);
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        return userRepository.save(user).getUserDTO();

    }

    @Override
    public Boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
