package com.diplom.klishin.util;

import com.diplom.klishin.model.Role;
import com.diplom.klishin.model.User;

import java.util.Arrays;
import java.util.HashSet;

public class UserUtil {

    public static User createUserByName(String name) {

        User user = new User(name, "testUser1", "testUser1@mail.ru", Boolean.TRUE, new HashSet<>(Arrays.asList(Role.ROLE_USER)));

        return user;
    }

}
