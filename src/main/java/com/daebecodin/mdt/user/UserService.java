package com.daebecodin.mdt.user;


import com.daebecodin.mdt.folder.Folder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public interface UserService {

    UserDto getUserById(UUID id);

    UserDto getUserByName(String name);

    List<UserDto> getAllUsers();

    Optional<UserDto> updateUserById(UUID id, UserDto updatedUser);

}
