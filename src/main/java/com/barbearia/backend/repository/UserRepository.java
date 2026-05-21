package com.barbearia.backend.repository;

import com.barbearia.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.barbearia.backend.enums.Role;
import java.util.List;
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(Role role);
}