package com.footballteam.registration.repository;

import com.footballteam.registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getAllByNameStartsWith(@NotEmpty @Size(max = 128) String name);
}

