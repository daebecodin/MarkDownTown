package com.daebecodin.mdt.user;


import com.daebecodin.mdt.markdown.MarkdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    /*
     * GET all users
     */
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(
            @RequestParam(required = false) String name) {
        if (name != null) {
            UserDto dto = userService.getUserByName(name);
            return ResponseEntity.ok(dto);
        } else {
            // fall back to list-all…
            List<UserDto> all = userService.getAllUsers();
            return ResponseEntity.ok(all);
        }
    }
        /*
         * get user by id
         */
    @GetMapping(
            "users/{id}"
    )
    public ResponseEntity<UserDto> getUserById(
            @RequestBody
            @PathVariable UUID id) {

        return ResponseEntity.ok(userService.getUserById(id));
    }

    /*
    * Post new user
     */
    @PostMapping(
            "/users/create"
    )
    ResponseEntity<User> newUser(@RequestBody User user) {
        User newUser = userRepository.save(user);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // TODO: update user
    // TODO: delete user







}

