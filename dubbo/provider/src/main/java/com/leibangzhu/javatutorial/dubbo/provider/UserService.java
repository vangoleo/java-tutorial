package com.leibangzhu.javatutorial.dubbo.provider;

import com.leibangzhu.javatutorial.dubbo.api.IUserService;
import com.leibangzhu.javatutorial.dubbo.api.User;

public class UserService implements IUserService {
    @Override
    public User echo(User user) {
        return user;
    }
}
