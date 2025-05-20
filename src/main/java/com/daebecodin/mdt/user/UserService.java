package com.daebecodin.mdt.user;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public  interface UserService {

    UserDto getUserById(UUID id);

    UserDto getUserByName(String name);

    List<UserDto> getAllUsers();
}
