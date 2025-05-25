package com.daebecodin.mdt.user;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(UUID id) {
        super("could not find user" + id);
    }
}
