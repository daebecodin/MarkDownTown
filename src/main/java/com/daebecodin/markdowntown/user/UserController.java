package com.daebecodin.markdowntown.user;

import com.daebecodin.markdowntown.markdown.MarkdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path ="/markdowntown")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final MarkdownService markdownService;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository, MarkdownService markdownService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.markdownService = markdownService;
    }

    // TODO: get users
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(@RequestParam(required = false) String name) {
        if (name != null) {
            UserDto dto = userService.getUserByName(name);
            return ResponseEntity.ok(dto);
        } else {
            // fall back to list-all…
            List<UserDto> all = userService.getAllUsers();
            return ResponseEntity.ok(all);
        }
    }

    @PostMapping("/users/new")
    ResponseEntity<User> newUser(@RequestBody User user) {
        User newUser = userRepository.save(user);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    // TODO: get user by id
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(
            @RequestBody
            @PathVariable UUID id) {

        return ResponseEntity.ok(userService.getUserById(id));
    }
    // TODO: get get markdown list fron user by id
    // TODO: get get markdown by id from user by id







}

