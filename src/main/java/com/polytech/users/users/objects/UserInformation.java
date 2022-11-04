package com.polytech.users.users.objects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@Getter
@Accessors(fluent = true)
public abstract class UserInformation {
    private final String name;
    private final String lastName;
    private final String location;
    private final String job;
    private final long phone;
    private final String email;
}