package com.daebecodin.mdt.user;


import com.daebecodin.mdt.user.exceptions.UserNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public  UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User Not Found"));
        return UserDto.fromEntity(user);

    }

    @Override
    public UserDto getUserByName(String name) {
        User user = userRepository.findUserByName(name);
        return UserDto.fromEntity(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserDto::fromEntity)
                .toList();
    }

    @Override
    public Optional<UserDto> updateUserById(UUID id, UserDto updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(updatedUser.getName());
                    existingUser.setUsername(updatedUser.getUsername());
                    User saved = userRepository.save(existingUser);
                    return UserDto.fromEntity(saved);
                });
    }

    @Override
    public void deleteUserById(UUID id)  {
        userRepository.findById(id).ifPresentOrElse(userRepository::delete, () -> {
            throw new UserNotFoundException(id);
        });
    }



}
