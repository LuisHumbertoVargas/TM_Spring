package com.cocarindo.services.auth;

import com.cocarindo.dtos.SignUpRequest;
import com.cocarindo.dtos.UserDTO;

public interface AuthService {

    UserDTO signUp(SignUpRequest signUpRequest);

    Boolean hasUserWithEmail(String email);

}
