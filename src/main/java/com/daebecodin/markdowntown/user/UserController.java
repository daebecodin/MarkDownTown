package com.daebecodin.markdowntown.user;

import com.daebecodin.markdowntown.document.markdown.MarkdownService;
import com.daebecodin.markdowntown.user.dto.UserDto;
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
    private final MarkdownService markdownService;

    @Autowired
    public UserController(UserService userService, MarkdownService markdownService) {
        this.userService = userService;
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
    // TODO: get user by id
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(
            @RequestBody
            @PathVariable Long id) {

        return ResponseEntity.ok(userService.getUserById(id));
    }
    // TODO: get get markdown list fron user by id
    // TODO: get get markdown by id from user by id







}
