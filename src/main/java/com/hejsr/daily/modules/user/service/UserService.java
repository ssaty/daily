package com.hejsr.daily.modules.user.service;

import com.hejsr.daily.modules.user.entity.UserEntity;
import com.hejsr.daily.modules.user.mapper.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserEntityMapper userMapper;

    public UserEntity getUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
}
