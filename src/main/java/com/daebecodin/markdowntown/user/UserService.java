package com.daebecodin.markdowntown.user;

import com.daebecodin.markdowntown.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Component
public  interface UserService {

    UserDto getUserById(UUID id);
}
