package com.footballteam.repository;

import com.footballteam.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getAllByNameStartsWith(@NotEmpty @Size(max = 128) String name);
}

