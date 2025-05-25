package com.daebecodin.mdt.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path ="/markdowntown/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;

    }

    /*
     * GET all users
     */
    @GetMapping("")
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
            "{id}"
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
            "/create"
    )
    ResponseEntity<User> newUser(@RequestBody User user) {
        User newUser = userRepository.save(user);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    /*
     * update user by id
     */
    @PutMapping(value = "/{id}/update-user")
        ResponseEntity<UserDto> updateUserById(@PathVariable UUID id, @RequestBody UserDto user) {
        return userService.updateUserById(id, user)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }


    /*
     * delete user by id
     */
    @DeleteMapping(value = "{id}/delete-user")
    public ResponseEntity<String> deleteUserById(@PathVariable UUID id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User " + id + " Has Been Deleted ", HttpStatus.OK);
    }







}

