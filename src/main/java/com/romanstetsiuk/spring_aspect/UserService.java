package com.romanstetsiuk.spring_aspect;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private User user = new User("Roman", "871230881188");

    public String getUpperName() {
        return user.getName().toUpperCase();
    }

    public String getBirthDateFromPesel() {
        return user.getPesel().substring(0, 6);
    }

    public Long error() {
        return Long.valueOf(user.getName());
    }

}
