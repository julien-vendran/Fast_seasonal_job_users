package com.polytech.users.users.impl;

import com.polytech.users.users.Users;
import com.polytech.users.users.objects.UserInformation;
import org.springframework.stereotype.Service;

@Service
public class UsersImpl implements Users {
    @Override
    public void create(UserInformation userInformation) {
        //TODO: write data into the database
    }
}
