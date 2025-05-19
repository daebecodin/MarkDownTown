package com.daebecodin.markdowntown.user;

import com.daebecodin.markdowntown.document.markdown.MarkdownService;
import com.daebecodin.markdowntown.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="user")
public class UserController {

    private final UserService userService;
    private final MarkdownService markdownService;

    @Autowired
    public UserController(UserService userService, MarkdownService markdownService) {
        this.userService = userService;
        this.markdownService = markdownService;
    }

    // TODO: get user by id
    @GetMapping("user/{id}")
    public ResponseEntity<UserDto> getUserById() {

        return null;
    }
    // TODO: get get markdown list fron user by id
    // TODO: get get markdown by id from user by id







}
