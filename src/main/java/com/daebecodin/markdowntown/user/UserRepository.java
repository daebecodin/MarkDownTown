package com.daebecodin.markdowntown.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface  UserRepository extends JpaRepository<User, UUID>  {
    User findUserById(UUID id);
    User findUserByName(String name);
    User findById();
    List<User> findAll();


}
