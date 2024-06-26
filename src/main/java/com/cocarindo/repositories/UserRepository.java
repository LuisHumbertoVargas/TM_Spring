package com.cocarindo.repositories;

import com.cocarindo.entities.User;
import com.cocarindo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserRole(UserRole userRole);

    Optional<User> findFirstByEmail(String email);

}
