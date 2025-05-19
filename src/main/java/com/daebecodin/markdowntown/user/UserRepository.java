package com.daebecodin.markdowntown.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface  UserRepository extends JpaRepository<User, UUID> {
    User findUserById(UUID id);
    User findUserByName(String name);
    List<User> findAll();


}
