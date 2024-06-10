package com.cocarindo.dtos;

import com.cocarindo.enums.UserRole;
import lombok.Data;


@Data
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
}
